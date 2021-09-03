package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.LocationDTO;

import java.util.List;

public interface LocationDAO {
    List<LocationDTO> findAll();

    boolean updateByLocNo(LocationDTO locationDTO);
    boolean deleteByLocNo(int locNo);
    void insertNewLocation(String locName);

    void upLocCNT(String locName);
    void downLocCNT(String locName);

    String findLocName(int locNo);
}
