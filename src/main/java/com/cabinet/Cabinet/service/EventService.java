package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.EventDAO;
import com.cabinet.Cabinet.dto.EventDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private SqlSessionTemplate eventSqlSession;
    private EventDAO eventDao;

    public List<EventDTO> getAllInfo() {
        eventDao = eventSqlSession.getMapper(EventDAO.class);
        return eventDao.getAllEvent();
    }

    public void addEventInfo(EventDTO eventDTO) {
        eventDao = eventSqlSession.getMapper(EventDAO.class);
        eventDao.insertEvent(eventDTO);
    }

    public EventDTO findByEvtNo(int evtNo){
        eventDao = eventSqlSession.getMapper(EventDAO.class);
        return eventDao.findByEvtNo(evtNo);
    }

    public void updateEventInfo(EventDTO eventDTO) {
        eventDao = eventSqlSession.getMapper(EventDAO.class);
        eventDao.updateEvent(eventDTO);
    }

    public void deleteEvent(int evtNo) {
        eventDao = eventSqlSession.getMapper(EventDAO.class);
        eventDao.deleteEvent(evtNo);
    }
}
