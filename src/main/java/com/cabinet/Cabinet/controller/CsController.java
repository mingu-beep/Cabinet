package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.CsDTO;
import com.cabinet.Cabinet.dto.ProductDTO;
import com.cabinet.Cabinet.dto.ReplyDTO;
import com.cabinet.Cabinet.service.BoardService;
import com.cabinet.Cabinet.service.CategoryService;
import com.cabinet.Cabinet.service.MemberService;
import com.cabinet.Cabinet.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

@Controller
@RequestMapping("/cs")
public class CsController {

    @Autowired
    BoardService boardService;

    @Autowired
    MemberService memberService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/main")
    public String boardCS(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memID", session.getAttribute("memID"));
            model.addAttribute("memName", memName);

        }



        return "cs";
    }

    @GetMapping("/upload")
    public String getUpload(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        model.addAttribute("csDTO", new CsDTO());
        return "csUpload";
    }

    @PostMapping("/upload")
    public ResponseEntity postUpload(Model model, CsDTO csDTO,
                                     final HttpSession session,
                                     HttpServletRequest req) throws IOException, ParseException {

        csDTO.setMemID((String)session.getAttribute("memID"));
        boardService.setCsData(csDTO);
        memberService.updateQCNT(csDTO.getMemID());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list")
    public String qnaList(Model model, final HttpSession session){

        model.addAttribute("csList", boardService.findMyQnA((String)session.getAttribute("memID")));
        return "csList";
    }

    @GetMapping("/detail")
    public String qnaDetail(Model model, final HttpSession session, @RequestParam("csNo") int csNo) {
        model.addAttribute("memID", session.getAttribute("memID"));
        model.addAttribute("csDetail", boardService.findByCsNo(csNo));
        return "csDetail";
    }

}