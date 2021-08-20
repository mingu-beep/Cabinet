package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.cabinet.Cabinet.dto.MemberDTO;
import com.cabinet.Cabinet.service.MemberService;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
	public String checkIdDuplicate(@RequestParam String value, Model model){
		boolean result = member_service.checkIdDuplicate(value);
		model.addAttribute("value", value);
		model.addAttribute("result", result);

		return "check";
	}
	@GetMapping("/emailCheck")
	public String checkEmailDuplicate(@RequestParam String value, Model model){
		boolean result = member_service.checkEmailDuplicate(value);
		model.addAttribute("value", value);
		model.addAttribute("result", result);
		return "check";
	}

	//회원가입 컨트롤러
	@PostMapping("/join")
	public ModelAndView memberPass(ModelAndView mav, @Valid MemberDTO memberDTO, BindingResult errors) {

		System.out.println(errors.hasErrors());
		if(errors.hasErrors()) {
			System.out.println("I'm here!");
			mav.addObject("data", new Message("올바른 정보를 입력해주세요", "join"));
			mav.setViewName("message");
		}
		else{
			//회원가입 메서드
			try {
				member_service.member_service(memberDTO);
				mav.addObject("data", new Message("회원가입이 완료되었습니다.", "login"));
				mav.setViewName("message");
			}
			catch (Exception e) {
				mav.addObject("data", new Message("중복 정보가 존재합니다.\n다시 입력해주세요.", "join"));
				mav.setViewName("message");
			}
		}

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
