package com.cabinet.Cabinet.mapper;

import java.util.List;
import java.util.Map;

import com.cabinet.Cabinet.dto.BoardDTO;
import com.cabinet.Cabinet.dto.BoardReply;

public interface BoardMapper {
	public boolean addBoard(BoardDTO boardDTO);
	public List<BoardDTO> getBoard();
	public BoardDTO getBoardOne(int idx);
    public boolean addReply(BoardReply boardReply);
    public List<BoardReply> getReply(int boardIdx);
}

