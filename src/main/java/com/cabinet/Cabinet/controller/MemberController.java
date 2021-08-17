package com.cabinet.Cabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/join")
	public String memberJoin(Model model) {
		return "join";
	}
	@GetMapping("/login")
	public String memberLogin(Model model) {
		return "login";
	}
	@GetMapping("/my")
	public String memberMypage(Model model) {
		return "mypage";
	}
}
