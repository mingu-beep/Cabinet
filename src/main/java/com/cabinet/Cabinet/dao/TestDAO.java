package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.TestDTO;

import java.util.List;

public interface TestDAO {
    List<TestDTO> getTestData();
    // mapper와 연결되어 있으므로 mapper의 getTestData와 메소드 명이 동일해야한다.
}
