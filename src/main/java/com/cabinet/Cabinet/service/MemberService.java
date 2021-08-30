package com.cabinet.Cabinet.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cabinet.Cabinet.dao.BoardDAO;
import com.cabinet.Cabinet.dto.LoginDTO;
import com.cabinet.Cabinet.dto.ProductDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.Cabinet.dao.MemberDAO;
import com.cabinet.Cabinet.dto.MemberDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@Service
public class MemberService {

	@Autowired
	private SqlSessionTemplate memberSqlSession;
	private MemberDAO memberDao;

	//회원가입 서비스
	public int member_service(MemberDTO memberDTO) {
		int resultCnt = 0;

		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		try {
			resultCnt = memberDao.regMember(memberDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultCnt;
	}

	public Map<String, String> validateHandling(Errors errors) {
		Map<String, String> validatorResult = new HashMap<>();

		for (FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		return validatorResult;
	}

	public boolean checkIdDuplicate(String id) {
		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		return memberDao.existById(id);
	}

	public boolean checkEmailDuplicate(String email) {
		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		return memberDao.existByEmail(email);
	}

	public String findId(String name, String email) {
		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		return memberDao.findId(name, email);
	}
	
	public int checkIdAndPw(LoginDTO loginDTO) {
		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		System.out.println(loginDTO.getMemID());
		System.out.println(loginDTO.getMemPW());
		if(memberDao.checkLogin(loginDTO)){
			return memberDao.checkAdmin(loginDTO.getMemID());
		}
		else
			return -1;
	}

	public MemberDTO getInfo(String memID) {
		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		return memberDao.loginMember(memID);
	}

	public List<ProductDTO> getProductWithMemID(String memID) {
		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		return memberDao.getProductWithMemID(memID);
	}

	public List<MemberDTO> getAllMember() {
		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		return memberDao.getAllMember();
	}

	public void deleteMember(int memNo) {
		memberDao = memberSqlSession.getMapper(MemberDAO.class);
		memberDao.deleteMember(memNo);
	}
}
