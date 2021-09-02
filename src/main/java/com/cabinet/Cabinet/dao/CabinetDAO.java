package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.CabinetDTO;

import java.util.List;

public interface CabinetDAO {

    List<CabinetDTO> findLocation();

    void updateCabinet(CabinetDTO cabinetDTO);

    void reSetCabinet(int cnNo);

    String getPassword(int cnNo);

}
