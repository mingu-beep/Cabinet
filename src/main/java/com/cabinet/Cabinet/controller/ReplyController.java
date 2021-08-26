package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.ReplyDTO;
import com.cabinet.Cabinet.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @RequestMapping("/list")
    @ResponseBody
    public List<ReplyDTO> replyServiceList(@RequestParam HashMap<Object, Object> params) {

        System.out.println(params);
        return replyService.replyListService(Integer.parseInt((String)params.get("bdNo")));
    }

    @RequestMapping("/insert") //댓글 작성
    @ResponseBody
    public int mCommentServiceInsert(@RequestParam HashMap<Object, Object> params){

        ReplyDTO reply = new ReplyDTO();
        reply.setBdNo(Integer.parseInt((String)params.get("bdNo")));
        reply.setReplyContent((String)params.get("content"));
        //로그인 기능을 구현했거나 따로 댓글 작성자를 입력받는 폼이 있다면 입력 받아온 값으로 사용하면 됩니다. 저는 따로 폼을 구현하지 않았기때문에 임시로 "test"라는 값을 입력해놨습니다.
        reply.setReplyWriter("test");

        return replyService.replyInsertService(reply);
    }

    @RequestMapping("/update") //댓글 수정
    @ResponseBody
    public int mCommentServiceUpdateProc(@RequestParam int replyNo, @RequestParam String content){

        ReplyDTO reply = new ReplyDTO();
        reply.setReplyNo(replyNo);
        reply.setReplyContent(content);

        return replyService.replyUpdateService(reply);
    }

    @RequestMapping("/delete/{replyNo}") //댓글 삭제
    @ResponseBody
    public int mCommentServiceDelete(@PathVariable int replyNo){

        return replyService.replyDeleteService(replyNo);
    }

}