package com.cabinet.Cabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/intro")
    public String boardIntro(Model model) {
        return "story"; // Controller에서 리턴하는 String은 View의 이름
    }

    @GetMapping("/cs")
    public String boardCS(Model model) {
        return "cs";
    }
}
