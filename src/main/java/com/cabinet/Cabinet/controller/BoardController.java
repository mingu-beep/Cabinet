package com.cabinet.Cabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Resource(name="com.cabinet.Cabinet.dao.BoardMapper")
	BoardMapper bm;

	@RequestMapping("/board")
	private String dbTest() throws Exception {
		System.out.println(bm.boardCount());

		return "test";
	}

    @GetMapping("/all")
    public String goodsAll(Model model) {
        return "deal";
    }

    @GetMapping("/upload")
    public String goodsUpload(Model model) {
        return "upload";
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
