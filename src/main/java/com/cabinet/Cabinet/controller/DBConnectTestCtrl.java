package com.cabinet.Cabinet.controller;

import com.cabinet.Cabinet.dao.TestDAO;
import com.cabinet.Cabinet.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DBConnectTestCtrl {

    @Autowired
    private TestDAO testDAO;
    // DAO를 주입

    @GetMapping("/hello")
    public List<TestDTO> HelloWorld() {
        return testDAO.getTestData();
    }
}
