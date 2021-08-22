package com.cabinet.Cabinet.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.BoardReply;
import com.cabinet.Cabinet.dto.ProductDTO;





public interface BoardDAO {
// 교수님 코드 부분
//    int regContent(Map<String, Object> paramMap);
//    int modifyContent(Map<String, Object> paramMap);
//    int getContentCnt(Map<String, Object> paramMap);
//    List<BoardDTO> getContentList(Map<String, Object> paramMap);
//    BoardDTO getContentView(Map<String, Object> paramMap);
//    int regReply(Map<String, Object> paramMap);
//    List<BoardReply> getReplyList(Map<String, Object> paramMap);
//    int delReply(Map<String, Object> paramMap);
//    int getBoardCheck(Map<String, Object> paramMap);
//    int delBoard(Map<String, Object> paramMap);
//    boolean checkReply(Map<String, Object> paramMap);
//    boolean updateReply(Map<String, Object> paramMap);

    boolean addBoard(BoardDTO boardDTO);
    boolean addProduct(ProductDTO productDTO);

    List<BoardDTO> getBoard();
    List<ProductDTO> getProduct();
    List<BoardDTO> getMine();

    boolean updateContent(BoardDTO boardDTO);
    

    int boardNo(BoardDTO boardDTO);
    BoardDTO getBoardOne(int idx);
    boolean addReply(BoardReply boardReply);
    List<BoardReply> getReply(int boardIdx);
    
}

