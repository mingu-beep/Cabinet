package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.*;

import com.cabinet.Cabinet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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

    @Autowired
    EventService eventService;

    @Autowired
    LocationService locationService;

    @Autowired
    CabinetService cabinetService;

    // 게시판 관리 페이지
    @GetMapping("/board")
    public String adminHome(Model model) {

        model.addAttribute("boardList", boardService.getBoardData());
        model.addAttribute("productList", boardService.getProductData());

        return "admin_board";
    }

    @RequestMapping(value = "/delete")
    public String deleteBoard(Model model, @RequestParam("bdNo") int bdNo) {

        boardService.deleteBoard(bdNo);
        return "redirect:/admin/board";
    }

    // 카테고리 관리 페이지
    @GetMapping("category")
    public String manageCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());

        return "admin_category";
    }

    @PostMapping("/ctInsert")
    @ResponseBody
    public int addNewCategory(@RequestParam HashMap<Object, Object> params) {

        String newCtType = (String) params.get("ctType");

        categoryService.insertCategory(newCtType);

        return 1;
    }

    @PostMapping("/ctUpdate")
    @ResponseBody
    public int updateCategory(@RequestParam HashMap<Object, Object> params) {

        int ctNo = Integer.parseInt((String) params.get("ctNo"));
        String ctType = (String) params.get("ctType");

        try {
            categoryService.updateCtType(ctNo, ctType);
        } catch (Exception e) {
            return 0;
        }

        return 1;
    }

    @RequestMapping("/ctDelete/{ctNo}") //댓글 삭제
    @ResponseBody
    public boolean deleteCategory(@PathVariable int ctNo) {

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
        model.addAttribute("eventList", eventService.getAllInfo());
        return "admin_event";
    }

    @GetMapping("/addEvent")
    public String addEventForm(Model model) {
        model.addAttribute("type", "추가");
        model.addAttribute("eventDTO", new EventDTO());
        return "addEvent";
    }

    @PostMapping("/postEvent")
    public ResponseEntity postEvent(Model model, EventDTO eventDTO,
                                    @RequestParam("file") MultipartFile file,
                                    HttpServletRequest req) throws IOException, ParseException {

        System.out.println(eventDTO.getEvtTitle());
        if (!file.getOriginalFilename().isEmpty()) {
            System.out.println("I'm here");
            String path = "C:\\attached\\" + file.getOriginalFilename();
            file.transferTo(new File(path));
            eventDTO.setEvtImg("/upload/" + file.getOriginalFilename());

            eventService.addEventInfo(eventDTO);

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);


    }

    @GetMapping("/updateEvent")
    public String updateEventForm(Model model, @RequestParam("evtNo") int evtNo) {
        model.addAttribute("type", "수정");
        model.addAttribute("evtNo", evtNo);
        model.addAttribute("upEventDTO", new EventDTO());
        model.addAttribute("eventDTO", eventService.findByEvtNo(evtNo));
        return "addEvent";
    }

    @PostMapping("/postUpdateEvent")
    public ResponseEntity postUpdateEvent(Model model, EventDTO newEventDTO,
                                          @RequestParam("evtNo") int evtNo,
                                          HttpServletRequest req) throws IOException, ParseException {
        newEventDTO.setEvtNo(evtNo);
        eventService.updateEventInfo(newEventDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/member/delEvent")
    public ResponseEntity deleteEvent(@RequestParam HashMap<Object, Object> params) {
        int evtNo = Integer.parseInt((String) params.get("evtNo"));
        eventService.deleteEvent(evtNo);
        return new ResponseEntity(HttpStatus.OK);
    }


    // 회원 관리
    @GetMapping("/member")
    public String manageMember(Model model) {
        model.addAttribute("memberList", memberService.getAllMember());
        return "admin_member";
    }


    @GetMapping("/member/delete")
    public String deleteMember(@RequestParam("memNo") int memNo) {
        memberService.deleteMember(memNo);

        return "redirect:/admin/member";
    }

    // QnA 관리
    @GetMapping("/cs")
    public String manageQnA(Model model) {

        model.addAttribute("csList", boardService.findAllQnA());

        return "admin_cs";
    }

    // 서비스 지역 관리
    @GetMapping("/location")
    public String manageLocation(Model model) {
        model.addAttribute("locationList",locationService.getAllLocation());
        return "admin_location";
    }

    // Location
    @PostMapping("/locInsert")
    @ResponseBody
    public int addNewLocation(@RequestParam HashMap<Object, Object> params) {

        String newLocName = (String) params.get("locName");

        locationService.insertLocation(newLocName);

        return 1;
    }

    @RequestMapping("/locList")
    @ResponseBody
    public List<LocationDTO> locationServiceList(@RequestParam HashMap<Object, Object> params) {

        return locationService.getAllLocation();
    }

    @PostMapping("/locUpdate")
    @ResponseBody
    public int updateLocation(@RequestParam HashMap<Object, Object> params) {

        int locNo = Integer.parseInt((String) params.get("locNo"));
        String locName = (String) params.get("locName");

        try {
            locationService.updateLocName(locNo, locName);
        } catch (Exception e) {
            return 0;
        }

        return 1;
    }

    @RequestMapping("/locDelete/{locNo}") //댓글 삭제
    @ResponseBody
    public boolean deleteLocation(@PathVariable int locNo) {

        return locationService.deleteLocation(locNo);
    }

    // Cabinet
    @GetMapping("/location/cabinet")
    public String showCabinet(Model model, @RequestParam("locNo") int locNo){
        model.addAttribute("cabinetList", cabinetService.findByLocName(locationService.getLocName(locNo)));

        return "admin_cabinet";
    }
}
