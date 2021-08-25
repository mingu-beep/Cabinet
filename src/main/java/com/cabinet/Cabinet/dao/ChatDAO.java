package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.MessageDTO;
import com.cabinet.Cabinet.dto.RoomDTO;

import java.util.List;

public interface ChatDAO {

    int selectMaxRoomNo();

    void insertRoom(RoomDTO roomVO);
    List<RoomDTO> selectRoom();

    void insertMessage(MessageDTO messageDTO);
    List<MessageDTO> selectMessages(String roomNumber);
}
