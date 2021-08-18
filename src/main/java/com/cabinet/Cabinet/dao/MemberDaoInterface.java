package com.cabinet.Cabinet.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

import com.cabinet.Cabinet.dto.MemberDTO;

public interface MemberDaoInterface {
	
	//유저정보
	int regMember(MemberDTO memberDTO) throws SQLException; //유저 회원가입 메서드
	int getKey(String memID, String member_key); //유저 인증키 생성 메서드
	int alter_memberKey(String memID, String key); //유저 인증키 y로 바꿔주는 메서드
	int searchPassword(String memID, String memEmail, String key); //회원 임시 비밀번호 변경 메서드
	MemberDTO loginMember(@Param("memID")String memID); //유저 로그인 메서드
}
