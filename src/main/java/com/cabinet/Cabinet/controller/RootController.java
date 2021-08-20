package com.cabinet.Cabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RootController {

    @GetMapping("/")
    public String home(Model model, final HttpSession session) {

        Object memID = session.getAttribute("memID");
        if (memID != null) {
            System.out.println(memID);
            model.addAttribute("memID", memID.toString());
        }
        return "index";
    }
}
