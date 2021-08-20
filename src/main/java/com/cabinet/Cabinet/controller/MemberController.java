package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.LoginDTO;
import com.cabinet.Cabinet.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cabinet.Cabinet.dto.MemberDTO;
import com.cabinet.Cabinet.service.MemberService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

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

		if(errors.hasErrors()) {
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


	// 로그인 관련 컨트롤러
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("loginDTO", new LoginDTO());
		return "login";
	}
	@PostMapping("/login")
	public ModelAndView postLogin(ModelAndView mav, LoginDTO loginDTO,
								  final HttpSession session,
								  HttpServletResponse response){
		// 쿠키, 세션 구현 필요
		// 쿠키와 세션 모두 사용자를 식별하고 정보를 저장하는데 사용됨
		// 쿠키 : 사용자 컴퓨터에 파일로 남겨지며 서버에서 받은 값을 저장할 수 있다. 정보노출의 위험이 있다.
		// 세션 : 서버에 데이터를 저장하는 수단. 쿠키와 달리 서버에 저장되므로 정보가 노출되지 않는다.

		// 목표 : 로그인 완료시 멤버 정보를 쿠키 및 세션에 저장.

		boolean login = memberService.checkIdAndPw(loginDTO);
		// 사용자의 아이디와 비밀번호를 받는 DTO

		if (login) {
			// 로그인 완료시 사용자의 모든 데이터를 받아오는 부분 -> 이름 받아오려고...
			MemberDTO memberDTO = memberService.getInfo(loginDTO.getMemID());

			// 쿠키에 저장
			Cookie storeIdCookie = new Cookie("storeIdCookie", memberDTO.getMemID());
			storeIdCookie.setPath("/");
			storeIdCookie.setMaxAge(60*5);
			response.addCookie(storeIdCookie);

			// 세션에 저장
			session.setAttribute("memID", memberDTO.getMemID());
			session.setAttribute("memName", memberDTO.getMemName());
			session.setMaxInactiveInterval(60*5);

			mav.addObject("data", new Message(memberDTO.getMemName() + "님 환영합니다!", "/"));

		}
		else {
			mav.addObject("data", new Message("아이디 혹은 비밀번호를 확인해주세요.", "login"));
		}

		mav.setViewName("message");
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, ModelAndView mav) {
		request.getSession().invalidate();
		request.getSession(true);
		mav.addObject("data", new Message("로그아웃 되었습니다!", "/"));
		mav.setViewName("message");
		return mav;
	}
	
	@GetMapping("/mypage")
	public String memberMypage(Model model) {
		return "mypage";
	}
}
