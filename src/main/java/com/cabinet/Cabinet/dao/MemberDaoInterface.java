package com.cabinet.Cabinet.dao;

import java.sql.SQLException;

import com.cabinet.Cabinet.dto.LoginDTO;
import org.apache.ibatis.annotations.Param;

import com.cabinet.Cabinet.dto.MemberDTO;

public interface MemberDaoInterface {

	//유저정보
	int regMember(MemberDTO memberDTO) throws SQLException; //유저 회원가입 메서드
	int getKey(String memID, String member_key); //유저 인증키 생성 메서드
	int alter_memberKey(String memID, String key); //유저 인증키 y로 바꿔주는 메서드
	int searchPassword(String memID, String memEmail, String key); //회원 임시 비밀번호 변경 메서드
	MemberDTO loginMember(@Param("memID") String memID); //유저 로그인 메서드
	//Param 어노테이션을 사용하면 mapper에서 해당이름으로 사용할 수 있다.

	// 회원가입시 중복 아이디, 이메일 체크 메서드
	boolean existById(String id);
	boolean existByEmail(String email);

	// 로그인시 회원 체크 메서드
	boolean checkLogin(LoginDTO loginDTO);

}