package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.BoardDAO;

import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.BoardVO;
import com.cabinet.Cabinet.dto.CsDTO;
import com.cabinet.Cabinet.dto.ProductDTO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private SqlSessionTemplate boardSqlSession;
    private BoardDAO boardDao;

    public List<BoardVO> findAll_asc(){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAll_asc();
    }
    public List<BoardVO> findAll_notCom(){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAll_notCom();
    }
    public List<BoardVO> findAll_desc(){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAll_desc();
    }
    public List<BoardVO> findAll_view(){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAll_view();
    }

    public List<BoardVO> findAllByCtNo(int ctNo){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAllByCtNo(ctNo);
    }
    public List<BoardVO> findAllByLocName(String location){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAllByLocName(location);
    }
    public List<BoardVO> findAllByDealType(int type){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAllByDealType(type);
    }
    public List<BoardVO> findAllByBdNo(int bdNo){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAllByBdNo(bdNo);
    }

    public BoardVO findByBdNo(int bdNo){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findOneByBdNo(bdNo);
    }


    public void setBoardData(BoardDTO boardDTO, ProductDTO productDTO) throws ParseException {

        // ????????? where ????????? writeDate ????????? ????????? ?????????.
        // println??? ?????? ????????? ?????? ??????????????? ????????? Date????????? MySQL??? datetime??? ????????? ??????
        // ???????????? ????????? ????????? nullPointerException??? ?????????.
        // ?????? ????????? MySQL ????????? ???????????? ?????? SimpleDateFormat ???????????? ?????????
        String pattern = "yyyy-MM-dd HH:mm:ss"; // db ?????? ?????? : '2021-08-21 16:46:01'
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        boardDTO.setWriteDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
        // 1. .format(~)??? Date?????? ???????????? ????????? ????????? ????????? ?????? String????????? ???????????? ?????????.
        // 2. Date type??? DTO ????????? ?????? String ????????? Date ???????????? ???????????? ?????? .parse ??????
        // 3. ??? ?????? mysql??? datetime??? ????????? ?????? date ??? ????????? ?????? ??? ?????????.

        productDTO.setPdUpDate(boardDTO.getWriteDate());
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        boardDao.addBoard(boardDTO);
        productDTO.setBdNo(boardDao.boardNo(boardDTO));
        boardDao.addProduct(productDTO);

    }

    public void deleteBoard(int bdNo) {
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        boardDao.deleteBoard(bdNo);
    }

    public void completeDeal(String oppID, int bdNo) {
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        boardDao.setComplete(oppID, bdNo);
    }





    public void updateContent(BoardDTO boardDTO, ProductDTO productDTO) throws ParseException {
        boardDao = boardSqlSession.getMapper(BoardDAO.class);

        String pattern = "yyyy-MM-dd hh:mm:ss"; // db ?????? ?????? : '2021-08-21 16:46:01'
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); // SimpleDateFormat??? ????????? ?????? ???????????? ??????
        productDTO.setPdUpDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));

        boardDao.updateBoard(boardDTO);
        boardDao.updateProduct(productDTO);

	}

	public void viewCount(int bdNo) {

        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        boardDao.updateView(bdNo);

    }
	
	public List<Integer> searchBoard(String keyword) {
		boardDao = boardSqlSession.getMapper(BoardDAO.class);
		System.out.println(1);
		List<Integer> searchNum = boardDao.searchBoard(keyword);
		return searchNum;
	}
	
	public List<BoardVO> findBoard(List<Integer> searchNum) {
		boardDao = boardSqlSession.getMapper(BoardDAO.class);
		
		List<BoardVO> boardList = new ArrayList<>();
	    for(Integer no : searchNum){
	        boardList.add(boardDao.findOneByBdNo(no));
	    }
	    
	    return boardList;
	}
	

    public List<CsDTO> findAllQnA(){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findAllQnA();
    }
	public List<CsDTO> findMyQnA(String memID){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findMyQnA(memID);
    }

    public void setCsData(CsDTO csDTO){
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        boardDao.addCs(csDTO);
    }

    public CsDTO findByCsNo(int csNo) {
        boardDao = boardSqlSession.getMapper(BoardDAO.class);
        return boardDao.findByCsNo(csNo);
    }

}
