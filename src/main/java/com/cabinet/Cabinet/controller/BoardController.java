package com.cabinet.Cabinet.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cabinet.Cabinet.dao.BoardMapper;

@Controller
public class BoardController {

	@Resource(name="com.cabinet.Cabinet.dao.BoardMapper")
	BoardMapper bm;
	
	@RequestMapping("/board")
	private String dbTest() throws Exception {
		System.out.println(bm.boardCount());
		
		return "test";
	}
    
}
