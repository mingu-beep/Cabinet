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
        return "story";
    }

    @GetMapping("/cs")
    public String boardCS(Model model) {
        return "cs";
    }
}
