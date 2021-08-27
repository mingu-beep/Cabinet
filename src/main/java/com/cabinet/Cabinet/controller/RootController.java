package com.cabinet.Cabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import com.cabinet.Cabinet.dao.BoardDAO;
import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.Message;
import com.cabinet.Cabinet.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RootController {
	
    @Autowired
    private BoardService boardService;
    private BoardDAO boardDao;

    @GetMapping("/")
    public String home(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        return "index";
    }
    
    @GetMapping("/intro")
    public String boardIntro(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }
        return "story";
    } // Controller에서 리턴하는 String은 View의 이름

    @GetMapping("/cs")
    public String boardCS(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        return "cs";
    }

    @RequestMapping("/request/transaction")
    @ResponseBody
    public ResponseEntity requstTransaction(@RequestParam HashMap<Object, Object> param) {

        // 채팅방 만들기
        System.out.println(param);
        // 댓글 남기기
        return new ResponseEntity(HttpStatus.OK);

    }
    @RequestMapping(value = "/search")
	public String openSearch(BoardDTO boardDTO, final HttpSession session, ModelAndView mav, Model model, 
			 HttpServletRequest request,
			@RequestParam("keyword")String keyword) // 메인에서 검색시 리스트
			throws Exception {
		
	        Object memName = session.getAttribute("memName");
	        if (session.getAttribute("memName") != null) {
	            model.addAttribute("memName", memName);
	            model.addAttribute("memID", session.getAttribute("memID").toString());
	        }
	        
			System.out.println("검색키워드=" + keyword);
			System.out.println(boardService.searchBoard(keyword));
			List<Integer> searchresult = boardService.searchBoard(keyword);

			System.out.println(boardService.findProduct(searchresult));
			System.out.println(boardService.findBoard(searchresult));

			model.addAttribute("productList", boardService.findProduct(searchresult));
			model.addAttribute("boardList",  boardService.findBoard(searchresult));

			return "searchlist";

	}

}
