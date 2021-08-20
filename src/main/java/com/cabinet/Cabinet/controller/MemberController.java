package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.LoginDTO;
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
	private MemberService memberService;
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
		boolean result = memberService.checkIdDuplicate(value);
		model.addAttribute("value", value);
		model.addAttribute("result", result);

		return "check";
	}
	@GetMapping("/emailCheck")
	public String checkEmailDuplicate(@RequestParam String value, Model model){
		boolean result = memberService.checkEmailDuplicate(value);
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
				memberService.member_service(memberDTO);
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
	public String getLogin(Model model) {
		model.addAttribute("loginDTO", new LoginDTO());
		return "login";
	}
	@PostMapping("/login")
	public ModelAndView postLogin(ModelAndView mav, LoginDTO loginDTO){
		boolean login = memberService.checkIdAndPw(loginDTO);

		if (login) {
			mav.addObject("data", new Message("환영합니다!", "/"));
			mav.setViewName("message");
		}
		else {
			mav.addObject("data", new Message("아이디 혹은 비밀번호를 확인해주세요.", "login"));
			mav.setViewName("message");
		}

		return mav;
	}

	@GetMapping("/my")
	public String memberMypage(Model model) {
		return "mypage";
	}
}
