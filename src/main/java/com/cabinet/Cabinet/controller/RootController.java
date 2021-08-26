package com.cabinet.Cabinet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class RootController {

    @GetMapping("/")
    public String home(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        return "index";
    }
    
    @GetMapping("/intro")
    public String boardIntro(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }
        return "story";
    } // Controller에서 리턴하는 String은 View의 이름

    @GetMapping("/cs")
    public String boardCS(Model model, final HttpSession session) {

        Object memName = session.getAttribute("memName");
        if (session.getAttribute("memName") != null) {
            model.addAttribute("memName", memName);
        }

        return "cs";
    }

    @RequestMapping("/request/transaction")
    @ResponseBody
    public ResponseEntity requstTransaction(@RequestParam HashMap<Object, Object> param) {

        // 채팅방 만들기
        System.out.println(param);
        // 댓글 남기기
        return new ResponseEntity(HttpStatus.OK);

    }
}
