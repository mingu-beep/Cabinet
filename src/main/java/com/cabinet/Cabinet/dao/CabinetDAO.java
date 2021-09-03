package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.CabinetDTO;

import java.util.List;

public interface CabinetDAO {

    List<CabinetDTO> getAll();
    List<CabinetDTO> findLocation();
    List<CabinetDTO> findByLocName(String locName);

    void updateCabinet(CabinetDTO cabinetDTO);

    void reSetCabinet(int cnNo);

    String getPassword(int cnNo);

    boolean findByPdNo(int pdNo);

    void updateExist(int cnNo);
}
