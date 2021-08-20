package com.cabinet.Cabinet.dao;

import org.springframework.stereotype.Repository;

@Repository("com.cabinet.Cabinet.dao.BoardMapper")//이경로가 맞는가..
public interface BoardMapper {
	public int boardCount() throws Exception;
}
