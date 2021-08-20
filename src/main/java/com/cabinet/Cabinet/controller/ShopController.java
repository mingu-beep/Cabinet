package com.cabinet.Cabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @GetMapping("/all")
    public String goodsAll(Model model) {
        return "deal";
    }

    @GetMapping("/upload")
    public String goodsUpload(Model model) {
        return "upload";
    }

    @GetMapping("/hot")
    public String goodsHot(Model model) {
        return "hot";
    }

    @GetMapping("/event")
    public String goodsEvent(Model model) {
        return "event";
    }
}
