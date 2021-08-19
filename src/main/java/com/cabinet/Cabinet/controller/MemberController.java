package com.cabinet.Cabinet.controller;

import java.lang.reflect.Member;

import com.cabinet.Cabinet.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cabinet.Cabinet.dto.MemberDTO;
import com.cabinet.Cabinet.service.MemberService;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("/idCheck")
	public ResponseEntity<Boolean> checkIdDuplicate(@RequestParam String id){
		return ResponseEntity.ok(member_service.checkEmailDuplicate(id));
	}
	@GetMapping("/emailCheck")
	public ResponseEntity<Boolean> checkEmailDuplicate(@RequestParam String email){
		return ResponseEntity.ok(member_service.checkEmailDuplicate(email));
	}

	//회원가입 컨트롤러
	@PostMapping("/join")
	public ModelAndView memberPass(ModelAndView mav, MemberDTO memberDTO) {
		//회원가입 메서드
		try {
			member_service.member_service(memberDTO);
			mav.addObject("data", new Message("회원가입이 완료되었습니다.", "login"));
			mav.setViewName("message");
		}
		catch (Exception e) {
			mav.addObject("data", new Message("중복된 정보입니다.", "join"));
			mav.setViewName("message");
		}
		//인증 메일 보내기 메서드
//		mail_sender.mailSendWithUserKey(memberDTO.getMem_email(), memberDTO.getMem_id());

		return mav;
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
