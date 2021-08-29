package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.service.BoardService;
import com.cabinet.Cabinet.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    BoardService boardService;

    @Autowired
    MemberService memberService;

    @GetMapping("/dashboard")
    public String adminHome(Model model) { // 게시물 관리

        model.addAttribute("boardList", boardService.getBoardData());
        model.addAttribute("productList", boardService.getProductData());

        return "admin_dash";
    }

    @RequestMapping(value="/delete")
    public String deleteBoard(Model model, @RequestParam("bdNo") int bdNo) {

        boardService.deleteBoard(bdNo);
        return  "redirect:/admin/dashboard";
    }
}
