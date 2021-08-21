package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.BoardDAO;
import com.cabinet.Cabinet.dao.MemberDAO;
import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.ProductDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BoardService {

    @Autowired
    private SqlSessionTemplate boardSqlSession;
    private BoardDAO boardDao;

    public void setBoardData(BoardDTO boardDTO, ProductDTO productDTO) {
        boardDTO.setWriteDate(new Date());
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        boardDao.addBoard(boardDTO);
    }
}
