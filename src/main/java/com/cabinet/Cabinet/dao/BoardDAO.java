package com.cabinet.Cabinet.dao;

import java.util.List;
import java.util.Map;

import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.BoardVO;
import com.cabinet.Cabinet.dto.CsDTO;
import com.cabinet.Cabinet.dto.ProductDTO;
import org.apache.ibatis.annotations.Param;

public interface BoardDAO {

    // 게시글 등록할 때 정보를 board와 product 테이블에 저장하는 쿼리 실행용
    boolean addBoard(BoardDTO boardDTO);
    boolean addProduct(ProductDTO productDTO);

    // 모든 정보를 받아오는 썸네일용 쿼리
    List<BoardDTO> getBoard();
    List<ProductDTO> getProduct();
    
    //메인에서 역순으로 보이는 부분
    List<BoardDTO> mainBoard();
    List<ProductDTO> mainProduct();

    //조회수 순으로 보는 부분
    List<BoardDTO> viewBoard();
    List<ProductDTO> viewProduct();
    
    BoardDTO getBoardWithBdNo(int bdNo);
    ProductDTO getProductWithBdNo(int bdNo);
    
    void updateBoard(BoardDTO boardDTO);
    void updateProduct(ProductDTO productDTO);

    void deleteBoard(int bdNo);

    int boardNo(BoardDTO boardDTO);

    void setComplete(@Param("oppID") String oppID, @Param("bdNo") int bdNo);

    void updateView(int bdNo);
    
	List<Integer> searchBoard(String keyword); // 메인검색

    List<BoardDTO> getBoardByCtNo(int ctNo);
    List<ProductDTO> getProductByCtNo(int ctNo);


	List<BoardVO> findAll();

    void addCs(CsDTO csDTO);
    CsDTO findByCsNo(int csNo);
    List<CsDTO> findAllQnA();
    List<CsDTO> findMyQnA(String memID);

}

