package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.LocationDAO;
import com.cabinet.Cabinet.dto.LocationDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private SqlSessionTemplate locationSqlSession;
    private LocationDAO locationDAO;

    public List<LocationDTO> getAllLocation() {
        locationDAO = locationSqlSession.getMapper(LocationDAO.class);
        return locationDAO.findAll();
    }

    public boolean updateLocName(int locNo, String locName) {

        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLocNo(locNo);
        locationDTO.setLocName(locName);

        locationDAO = locationSqlSession.getMapper(LocationDAO.class);
        return locationDAO.updateByLocNo(locationDTO);
    }

    public boolean deleteLocation(int locNo) {
        locationDAO = locationSqlSession.getMapper(LocationDAO.class);
        return locationDAO.deleteByLocNo(locNo);
    }

    public void insertLocation(String locName) {
        locationDAO = locationSqlSession.getMapper(LocationDAO.class);
        locationDAO.insertNewLocation(locName);
    }

    public String getLocName(int locNo){
        locationDAO = locationSqlSession.getMapper(LocationDAO.class);
        return locationDAO.findLocName(locNo);
    }

    public void upLocCNT(String locName){
        locationDAO = locationSqlSession.getMapper(LocationDAO.class);
        locationDAO.upLocCNT(locName);
    }

    public void downLocCNT(String locName){
        locationDAO = locationSqlSession.getMapper(LocationDAO.class);
        locationDAO.downLocCNT(locName);
    }
}
