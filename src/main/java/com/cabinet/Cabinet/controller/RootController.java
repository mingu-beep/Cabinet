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
        if (memName != null) {
            System.out.println("I'm here");
            System.out.println(memName);
            model.addAttribute("memName", memName);
        }
        System.out.println("Out Here");
        return "index";
    }
}
