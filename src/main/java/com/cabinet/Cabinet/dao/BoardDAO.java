package com.cabinet.Cabinet.dao;

import java.util.List;

import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.ProductDTO;

public interface BoardDAO {

    // 게시글 등록할 때 정보를 board와 product 테이블에 저장하는 쿼리 실행용
    boolean addBoard(BoardDTO boardDTO);
    boolean addProduct(ProductDTO productDTO);

    // 모든 정보를 받아오는 썸네일용 쿼리
    List<BoardDTO> getBoard();
    List<ProductDTO> getProduct();

    BoardDTO getBoardWithBdNo(int bdNo);
    ProductDTO getProductWithBdNo(int bdNo);
    List<ProductDTO> getProductWithMemID(String memID);
    
    void updateBoard(BoardDTO boardDTO);
    void updateProduct(ProductDTO productDTO);

    void deleteBoard(int bdNo);

    int boardNo(BoardDTO boardDTO);
    BoardDTO getBoardOne(int idx);

    void updateView(int bdNo);
    
}

