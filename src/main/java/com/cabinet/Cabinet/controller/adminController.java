package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.CategoryDTO;
import com.cabinet.Cabinet.dto.ReplyDTO;
import com.cabinet.Cabinet.service.BoardService;
import com.cabinet.Cabinet.service.CategoryService;
import com.cabinet.Cabinet.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    BoardService boardService;

    @Autowired
    MemberService memberService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/dashboard")
    public String adminHome(Model model) { // 게시물 관리

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("boardList", boardService.getBoardData());
        model.addAttribute("productList", boardService.getProductData());

        return "admin_dash";
    }

    @RequestMapping(value="/delete")
    public String deleteBoard(Model model, @RequestParam("bdNo") int bdNo) {

        boardService.deleteBoard(bdNo);
        return  "redirect:/admin/dashboard";
    }

    @PostMapping("/ctUpdate")
    @ResponseBody
    public int updateCategory(@RequestParam HashMap<Object, Object> params){

        int ctNo = Integer.parseInt((String)params.get("ctNo"));
        String ctType = (String) params.get("ctType");

        try {
            categoryService.updateCtType(ctNo, ctType);
        }
        catch(Exception e) {
            return 0;
        }

        return 1;
    }
    @RequestMapping("/ctDelete/{ctNo}") //댓글 삭제
    @ResponseBody
    public boolean deleteCategory(@PathVariable int ctNo){

        return categoryService.deleteCategory(ctNo);
    }

    @RequestMapping("/ctList")
    @ResponseBody
    public List<CategoryDTO> categoryServiceList(@RequestParam HashMap<Object, Object> params) {

        return categoryService.getAllCategory();
    }


}
