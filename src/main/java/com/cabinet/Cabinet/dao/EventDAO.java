package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.EventDTO;

import java.util.List;

public interface EventDAO {
    List<EventDTO> getAllEvent();

    void insertEvent(EventDTO eventDTO);
    void updateEvent(EventDTO eventDTO);
    void deleteEvent(int evtNo);

    EventDTO findByEvtNo(int evtNo);
}
