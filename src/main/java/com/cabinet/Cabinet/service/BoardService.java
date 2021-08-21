package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.BoardDao;
import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.ProductDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private SqlSessionTemplate memberSqlSession;
    private BoardDao boardDao;

    public void setBoardData(BoardDTO boardDTO, ProductDTO productDTO) {

    }
}
