package com.cabinet.Cabinet.controller;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cabinet.Cabinet.dto.MemberDTO;
import com.cabinet.Cabinet.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService member_service;
//	@Autowired
//	private AdminStoreListService store_service;
//	@Autowired
//	private UserMailSendService mail_sender;

	@GetMapping("/join")
	public String memberJoin(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());
		return "join";
	}

	//회원가입 컨트롤러
	@PostMapping("/join")
	public String memberPass(Model model, MemberDTO memberDTO) {
		//회원가입 메서드
		member_service.member_service(memberDTO);

		//인증 메일 보내기 메서드
//		mail_sender.mailSendWithUserKey(memberDTO.getMem_email(), memberDTO.getMem_id());

		return "login";
	}

	@GetMapping("/login")
	public String memberLogin(Model model) {

		model.addAttribute("memDTO", new MemberDTO());
		return "login";
	}
	@GetMapping("/my")
	public String memberMypage(Model model) {
		return "mypage";
	}
}
