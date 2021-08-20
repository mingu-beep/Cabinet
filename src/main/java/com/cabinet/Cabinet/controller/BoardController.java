package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/board")
public class BoardController {

//	@Resource(name="com.cabinet.Cabinet.dao.BoardMapper")
//	BoardMapper bm;
//
//	@RequestMapping("/board")
//	private String dbTest() throws Exception {
//		System.out.println(bm.boardCount());
//
//		return "test";
//	}

    @GetMapping("/all")
    public String goodsAll(Model model) {
        return "deal";
    }

    @GetMapping("/upload")
    public String getUpload(Model model) {

        // View에서 정보를 받아오기 위해 Model에 boardDTO라는 이름으로 BoardDTO 객체를 등록한다.
        model.addAttribute("boardDTO", new BoardDTO());
        return "upload";
    }

    @PostMapping("/upload")
    public String postUpload(Model model) {
        return "postUpload";
    }

    @GetMapping("/hot")
    public String goodsHot(Model model) {
        return "hot";
    }

    @GetMapping("/event")
    public String goodsEvent(Model model) {
        return "event";
    }
}
