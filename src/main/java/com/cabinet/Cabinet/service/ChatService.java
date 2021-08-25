package com.cabinet.Cabinet.service;


import com.cabinet.Cabinet.dao.ChatDAO;
import com.cabinet.Cabinet.dto.MessageDTO;
import com.cabinet.Cabinet.dto.RoomDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private SqlSessionTemplate chatSqlSession ;
    private ChatDAO chatDao;

    public int getLargestRoomNo() {
        chatDao = chatSqlSession.getMapper(ChatDAO.class);
        return chatDao.selectMaxRoomNo();
    }
    public void saveRoomInfo(RoomDTO roomDTO){
        chatDao = chatSqlSession.getMapper(ChatDAO.class);
        chatDao.insertRoom(roomDTO);
    }

    public List<RoomDTO> getRooms() {
        chatDao = chatSqlSession.getMapper(ChatDAO.class);
        return chatDao.selectRoom();
    }

    public void saveMessage(MessageDTO messageDTO){
        chatDao = chatSqlSession.getMapper(ChatDAO.class);
        chatDao.insertMessage(messageDTO);
    }

    public List<MessageDTO> findMessagesByRoomNumber(String roomNumber) {
        chatDao = chatSqlSession.getMapper(ChatDAO.class);
        return chatDao.selectMessages(roomNumber);
    }
}
