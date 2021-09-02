package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.service.BoardService;
import com.cabinet.Cabinet.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {
    @Autowired
    CabinetService cabinetService;

    @Autowired
    BoardService boardService;

    @GetMapping("/comDeal")
    public String completeDealWithCabinet(Model model, @RequestParam("oppID") String oppID, @RequestParam("bdNo") int bdNo){

        model.addAttribute("bdNo", bdNo);
        model.addAttribute("oppID", oppID);
        model.addAttribute("cabinetList",cabinetService.findLocation());

        return "checkCabinet";
    }

    @PostMapping("/comDeal")
    public ResponseEntity postComplete(HttpServletRequest request, final HttpSession session){

        int cnNo = Integer.parseInt(request.getParameter("location"));
        String cnPW = request.getParameter("pw");
        String oppID = request.getParameter("oppID");
        int bdNo = Integer.parseInt(request.getParameter("bdNo"));

        cabinetService.setCabinet(cnNo, cnPW, session.getAttribute("memID").toString());
        boardService.completeDeal(oppID, bdNo);

        return new ResponseEntity(HttpStatus.OK);
    }

    // 아두이노 통신용
    @GetMapping("/getPassword")
    @ResponseBody
    public String sendPassword(@RequestParam("cnNo") String cnNo){
        return "<0101";
    }

    @GetMapping("/sendData")
    @ResponseBody
    public ResponseEntity takeDataFromCabinet(@RequestParam("choice") String choice, @RequestParam("status") String status){
        return new ResponseEntity(HttpStatus.OK);

    }
}
