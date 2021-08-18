package com.cabinet.Cabinet.controller;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//회원가입 컨트롤러
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String memberPass(MemberDTO memberDTO) {
		//회원가입 메서드
		member_service.member_service(memberDTO);
		//인증 메일 보내기 메서드
//		mail_sender.mailSendWithUserKey(memberDTO.getMem_email(), memberDTO.getMem_id());
		
		return "redirect:/";
	}
//	@GetMapping("/join")
//	public String memberJoin(Model model) {
//		return "join";
//	}
	@GetMapping("/login")
	public String memberLogin(Model model) {
		return "login";
	}
	@GetMapping("/my")
	public String memberMypage(Model model) {
		return "mypage";
	}
}
