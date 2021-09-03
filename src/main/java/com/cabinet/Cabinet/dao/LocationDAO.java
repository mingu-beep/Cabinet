package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.LocationDTO;

import java.util.List;

public interface LocationDAO {
    List<LocationDTO> findAll();

    boolean updateByLocNo(LocationDTO locationDTO);
    boolean deleteByLocNo(int locNo);
    void insertNewLocation(String locName);

    void updateLocCNT(int locNo);
    String findByLocNo(int locNo);

    String findLocName(int locNo);
}
