package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.CategoryDTO;

import com.cabinet.Cabinet.service.BoardService;
import com.cabinet.Cabinet.service.CategoryService;
import com.cabinet.Cabinet.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // 게시판 관리 페이지
    @GetMapping("/board")
    public String adminHome(Model model) {

        model.addAttribute("boardList", boardService.getBoardData());
        model.addAttribute("productList", boardService.getProductData());

        return "admin_board";
    }

    @RequestMapping(value="/delete")
    public String deleteBoard(Model model, @RequestParam("bdNo") int bdNo) {

        boardService.deleteBoard(bdNo);
        return  "redirect:/admin/board";
    }

    // 카테고리 관리 페이지
    @GetMapping("category")
    public String manageCategory(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());

        return "admin_category";
    }

    @PostMapping("/ctInsert")
    @ResponseBody
    public int addNewCategory(@RequestParam HashMap<Object, Object> params){

        String newCtType = (String) params.get("ctType");

        categoryService.insertCategory(newCtType);

        return 1;
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

    // 이벤트 관리 페이지
    @GetMapping("/event")
    public String manageEvent(Model model) {
        return "admin_event";
    }

    // 회원 관리
    @GetMapping("/member")
    public String manageMember(Model model) {

        model.addAttribute("memberList", memberService.getAllMember());
        return "admin_member";
    }


    @GetMapping("/member/delete")
    public String deleteMember(@RequestParam("memNo") int memNo){
        memberService.deleteMember(memNo);

        return "redirect:/admin/member";
    }

    // QnA 관리
    @GetMapping("/cs")
    public String manageQnA(Model model) {
        return "admin_cs";
    }
}
