package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.CabinetDTO;

import java.util.List;

public interface CabinetDAO {

    List<CabinetDTO> findLocation();

    void updateCabinet(CabinetDTO cabinetDTO);
}
