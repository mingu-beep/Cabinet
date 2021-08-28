package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    MemberService memberService;

    @GetMapping("/dashboard")
    public String adminHome(Model model) {
        return "admin_dash";
    }
}
