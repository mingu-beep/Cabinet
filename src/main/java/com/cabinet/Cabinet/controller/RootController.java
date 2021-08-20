package com.cabinet.Cabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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
}
