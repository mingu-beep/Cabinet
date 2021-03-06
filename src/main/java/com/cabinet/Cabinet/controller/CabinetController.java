package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.service.BoardService;
import com.cabinet.Cabinet.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {
    @Autowired
    CabinetService cabinetService;

    @Autowired
    BoardService boardService;

    @GetMapping("/comDeal")
    public String completeDealWithCabinet(Model model, @RequestParam("oppID") String oppID, @RequestParam("bdNo") int bdNo){

        model.addAttribute("bdNo", bdNo);
        model.addAttribute("oppID", oppID);
        model.addAttribute("cabinetList",cabinetService.findLocation());

        return "checkCabinet";
    }

    @PostMapping("/comDeal")
    @ResponseBody
    public ResponseEntity postComplete(@RequestParam("bdNo") int bdNo, @RequestParam("oppID") String oppID, @RequestParam HashMap<Object, Object> params, final HttpSession session){

        System.out.println(bdNo);
        System.out.println(oppID);
        int cnNo = Integer.parseInt(params.get("location").toString());
        String cnPW = params.get("pw").toString();
        boardService.completeDeal(oppID, bdNo);
        cabinetService.setCabinet(bdNo, cnNo, cnPW, session.getAttribute("memID").toString());


        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/checkInner")
    @ResponseBody
    public boolean checkInner(@RequestParam HashMap<Object, Object> params) {
        return cabinetService.searchCabinet(Integer.parseInt(params.get("pdNo").toString()));
    }

    // 아두이노 통신용
    @GetMapping("/getPassword")
    @ResponseBody
    public String sendPassword(@RequestParam("cnNo") String cnNo){
        String pw = cabinetService.getPassword(Integer.parseInt(cnNo));
        String result = "<" + pw;
        System.out.println(result);
        return result;
    }

    @GetMapping("/sendData")
    @ResponseBody
    public String takeDataFromCabinet(@RequestParam("cnNo") String cnNo, @RequestParam("choice") String choice, @RequestParam("state") String state){
        // choice : 1. put in 2. put out
        // state : Y(물건 ㅇㅇ) N(물건 ㄴㄴ)

        System.out.println("cnNo = " + cnNo + "  /  choice = " + choice + "  /  state = " + state);

        if(choice.equals("1")){
            if(state.equals("Y")){ // 넣는데 물건이 있어 -> 거래완료
                System.out.print("In if : 1,Y");
                cabinetService.setExist(Integer.parseInt(cnNo));
            } else if (state.equals("N")) { // 넣는데 물건이 없어 -> 거래 미완료
                System.out.print("In if : 1,N");
            }
        } else if (choice.equals("2")) {
            if(state.equals("Y")){ // 빼는 데 물건이 있어 -> 거래 미완료
                System.out.print("In if : 2,Y");
            } else if (state.equals("N")) { // 빼는 데 물건이 없어 -> 거래 완료
                System.out.print("In if : 2,N");
                cabinetService.reSetCabinet(Integer.parseInt(cnNo));
            }
        }

        return "<";
    }
}
