package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.BoardDAO;
import com.cabinet.Cabinet.dao.MemberDAO;
import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.ProductDTO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private SqlSessionTemplate boardSqlSession;
    private BoardDAO boardDao;

    public void test() {
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        boardDao.getAllProduct();
    }

    public void setBoardData(BoardDTO boardDTO, ProductDTO productDTO) throws ParseException {

        // 쿼리의 where 조건의 writeDate 때문에 오류가 발생함.
        // println을 통해 값들을 모두 출력해보니 자바의 Date형식과 MySQL의 datetime의 형식이 달라
        // 일치하는 결과가 없어서 nullPointerException이 발생함.
        // 자바 형식을 MySQL 형식에 맞춰주기 위해 SimpleDateFormat 클래스를 활용함
        String pattern = "yyyy-MM-dd hh:mm:ss"; // db 저장 패턴 : '2021-08-21 16:46:01'
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); // SimpleDateFormat을 우리가 정한 패턴으로 생성
        boardDTO.setWriteDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
        // 1. .format(~)로 Date형의 데이터를 우리가 지정한 형식에 맞는 String형식의 데이터로 만든다.
        // 2. Date type인 DTO 변수에 맞게 String 결과를 Date 형식으로 바꿔주기 위해 .parse 사용
        // 3. 그 결과 mysql의 datetime의 형식과 맞는 date 형 변수를 얻을 수 있었다.

        productDTO.setPdDate(boardDTO.getWriteDate());
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        boardDao.addBoard(boardDTO);
        productDTO.setBdNo(boardDao.boardNo(boardDTO));
        boardDao.addProduct(productDTO);
    }
    public List<BoardDTO> getBoardData() {
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
    	return boardDao.getBoard();
	}
}
