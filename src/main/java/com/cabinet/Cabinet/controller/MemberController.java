package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dao.MemberDAO;
import com.cabinet.Cabinet.dto.LoginDTO;
import com.cabinet.Cabinet.dto.Message;
import com.cabinet.Cabinet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.cabinet.Cabinet.dto.MemberDTO;
import com.cabinet.Cabinet.service.MemberService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	CategoryService categoryService;

	@GetMapping("/join")
	public String memberJoin(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());

		model.addAttribute("categories", categoryService.getAllCategory());

		return "join";
	}

	@GetMapping("/idCheck")
	public String checkIdDuplicate(@RequestParam String value, Model model){
		boolean result = memberService.checkIdDuplicate(value);
		model.addAttribute("type", "id");
		model.addAttribute("value", value);
		model.addAttribute("result", result);

		return "check";
	}

	@GetMapping("/emailCheck")
	public String checkEmailDuplicate(@RequestParam String value, Model model){
		boolean result = memberService.checkEmailDuplicate(value);
		model.addAttribute("type", "email");
		model.addAttribute("value", value);
		model.addAttribute("result", result);
		return "check";
	}

	@GetMapping("/findId")
	private String checkName(@RequestParam("name") String nameValue, @RequestParam("email") String emailValue, MemberDTO memberDTO , Model model) {
		System.out.println(nameValue);
		System.out.println(emailValue);
		String idresult = memberService.findId(nameValue, emailValue);
		System.out.println(idresult);
		
			model.addAttribute("type", "id");
			model.addAttribute("value", idresult);
			model.addAttribute("namevalue", nameValue);
			model.addAttribute("emailValue", emailValue);
		
		return "find";
	}	
	
	@GetMapping("/findPw")
	private String checkName(@RequestParam("id") String idValue, @RequestParam("name") String nameValue, @RequestParam("email") String emailValue, MemberDTO memberDTO , Model model) {
		System.out.println(idValue);
		System.out.println(nameValue);
		System.out.println(emailValue);
		String pwresult = memberService.findPw(idValue, nameValue, emailValue);
		System.out.println(pwresult);
		
			model.addAttribute("type", "pw");
			model.addAttribute("value", pwresult);
			model.addAttribute("idvalue", idValue);
			model.addAttribute("namevalue", nameValue);
			model.addAttribute("emailValue", emailValue);
		
		return "find";
	}	
	
	//회원가입 컨트롤러
	@PostMapping("/join")
	public ModelAndView memberPass(ModelAndView mav, @Valid MemberDTO memberDTO, Errors errors) {

		if(errors.hasErrors()) {
			mav.addObject("memberDTO", memberDTO);

			Map<String, String> validatorResult = memberService.validateHandling(errors);
			System.out.println(validatorResult);
			for(String key: validatorResult.keySet()){
				mav.addObject(key, validatorResult.get(key));
			}

			mav.setViewName("join");
			return mav;
		}

		//회원가입 메서드
		try {
			System.out.println("회원가입 In");
			memberService.member_service(memberDTO);
			System.out.println("회원가입 Out");
			mav.addObject("data", new Message("회원가입이 완료되었습니다.", "login"));
			mav.setViewName("message");
		}
		catch (Exception e) {
			mav.addObject("data", new Message("중복 정보가 존재합니다.\n다시 입력해주세요.", "join"));
			mav.setViewName("message");
		}

		return mav;
	}

	//회원정보 수정
	@GetMapping("/mypage")
	private String getupdateMember(Model model, MemberDTO memberDTO,  final HttpSession session) {
		Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }
        int memNo = Integer.parseInt(session.getAttribute("memNo").toString());
        System.out.println(memNo);
        model.addAttribute("memNo", memNo);
        model.addAttribute("memberDTO", memberService.getMemWithMemNo(memNo));
        
        return "mypage";
	}
	@PostMapping("/mypage")
	private ModelAndView postupdateMember(Model model, ModelAndView mav, MemberDTO memberDTO, final HttpSession session) throws ParseException {
		System.out.println(memberDTO.getMemNo());
		mav.addObject("memberDTO", memberDTO);	//페이지가자마자 보일 수 있도록 하는 부분 return도 mav필수
		mav.setViewName("redirect:/member/mypage");
		try {
			System.out.println("회원정보 수정 In");
			memberService.updateMemberInfo(memberDTO);
			System.out.println(memberDTO.getMemPhone());
			System.out.println("회원정보 수정 Out");
			mav.addObject("data", new Message("회원정보 수정이 완료되었습니다.", "mypage"));
			mav.setViewName("message");
		}
		catch (Exception e) {
			mav.addObject("data", new Message("중복 정보가 존재합니다.\n다시 입력해주세요.", "mypage"));
			mav.setViewName("message");
		}
		return mav;
	}
	
	// 로그인 관련 컨트롤러
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("loginDTO", new LoginDTO());
		model.addAttribute("categories", categoryService.getAllCategory());
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

		int login = memberService.checkIdAndPw(loginDTO);
		// 사용자의 아이디와 비밀번호를 받는 DTO

		if (login >= 0) {
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
			session.setAttribute("memNo", memberDTO.getMemNo());
			session.setMaxInactiveInterval(60*5);

			if(login == 0)
				mav.addObject("data", new Message(memberDTO.getMemName() + "님 환영합니다!", "/"));
			else
				mav.addObject("data", new Message("관리자 권한으로 로그인하셨습니다.", "/admin/board"));
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
	
	@RequestMapping(value = "/delete")
	public String deleteMember(Model model, final HttpSession session,HttpServletRequest request, @RequestParam("memNo") int memNo) {
    	Object memID = session.getAttribute("memID");
        if (session.getAttribute("memID") != null) {
            memberService.deleteMember(memNo);
            model.addAttribute("memID", memID);
        }	
		request.getSession().invalidate();
		request.getSession(true);
        return "redirect:/";
	}
	
	@GetMapping("/mylist")
	public String goodsMine(Model model, final HttpSession session, @RequestParam("memID")String memID) {

		Object memName = session.getAttribute("memName");
		if (session.getAttribute("memName") != null) {
			model.addAttribute("memName", memName);
		}

		System.out.println(memID);
		model.addAttribute("productList",memberService.getProductWithMemID(memID));
		model.addAttribute("categories", categoryService.getAllCategory());
		return "mylist";
	}

	@GetMapping("/mydeal")
	public String dealMine(Model model, final HttpSession session) {
		model.addAttribute("dealList",memberService.getDealWithMemID(session.getAttribute("memID").toString()));
		return "myDeal";
	}

	@PostMapping("/checkOpponent")
	@ResponseBody
	public boolean checkOpponentID(@RequestParam HashMap<Object, Object> params) {
		return memberService.checkIdDuplicate(params.get("oppID").toString());
	}
}
