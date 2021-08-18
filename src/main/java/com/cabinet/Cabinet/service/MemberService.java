package com.cabinet.Cabinet.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.Cabinet.dao.MemberDaoInterface;
import com.cabinet.Cabinet.dto.MemberDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class MemberService {
	@Autowired
	private SqlSessionTemplate memberSqlSession;
	private MemberDaoInterface memberDao;
	
	//회원가입 서비스
	public int member_service(MemberDTO memberDTO) {
		int resultCnt = 0;
		
		memberDao = memberSqlSession.getMapper(MemberDaoInterface.class);
		try {
			resultCnt = memberDao.regMember(memberDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultCnt;
	}
}
