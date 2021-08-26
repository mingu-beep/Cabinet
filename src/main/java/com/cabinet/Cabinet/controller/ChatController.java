package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dto.MessageDTO;
import com.cabinet.Cabinet.dto.RoomDTO;
import com.cabinet.Cabinet.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class ChatController {

    @Autowired
    ChatService chatService;
    List<RoomDTO> roomList = new ArrayList<RoomDTO>();
    static int roomNumber = 0;

    @RequestMapping("/chat")
    public ModelAndView chat() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chat");
        return mv;
    }

    @RequestMapping("/dealRoom")
    public ResponseEntity createDealRoom (@RequestParam HashMap<Object, Object> params) {

        // 방 정보 가져오기
        roomNumber = chatService.getLargestRoomNo();
        roomList = chatService.getRooms();

        // 방 만들기
        System.out.println((String)params.get("memID"));
        System.out.println((String)params.get("pdName"));
        String roomName = (String)params.get("memID") + "님의 " + (String)params.get("pdName") + "거래방";
        if(roomName != null && !roomName.trim().equals("")) {
            RoomDTO room = new RoomDTO();
            room.setRoomNumber(Integer.toString(++roomNumber));
            room.setRoomName(roomName);
            roomList.add(room);
            chatService.saveRoomInfo(room);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 방 페이지
     * @return
     */
    @RequestMapping("/room")
    public ModelAndView room() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("room");
        return mv;
    }

    /**
     * 방 생성하기
     * @param params
     * @return
     */
    @RequestMapping("/createRoom")
    public @ResponseBody List<RoomDTO> createRoom(@RequestParam HashMap<Object, Object> params){
        String roomName = (String) params.get("roomName");
        if(roomName != null && !roomName.trim().equals("")) {
            RoomDTO room = new RoomDTO();
            room.setRoomNumber(Integer.toString(++roomNumber));
            room.setRoomName(roomName);
            roomList.add(room);
            chatService.saveRoomInfo(room);
        }
        return roomList;
    }

    /**
     * 방 정보가져오기
     * @param params
     * @return
     */
    @RequestMapping("/getRoom")
    public @ResponseBody List<RoomDTO> getRoom(@RequestParam HashMap<Object, Object> params){
        roomNumber = chatService.getLargestRoomNo();
        roomList = chatService.getRooms();
        return roomList;
    }

    /**
     * 채팅방
     * @return
     */
    @RequestMapping("/moveChating")
    public ModelAndView chating(@RequestParam HashMap<Object, Object> params, final HttpSession session) {
        ModelAndView mv = new ModelAndView();
        int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

        List<RoomDTO> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
        if(new_list != null && new_list.size() > 0) {

            mv.addObject("messageList",
                    chatService.findMessagesByRoomNumber(params.get("roomNumber").toString()));
            mv.addObject("roomName", params.get("roomName"));
            mv.addObject("roomNumber", params.get("roomNumber"));
            mv.setViewName("chat");
        }else {
            mv.setViewName("room");
        }
        return mv;
    }

    @PostMapping("saveMessage")
    public ResponseEntity saveMessage (MessageDTO messageDTO) {
        chatService.saveMessage(messageDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}