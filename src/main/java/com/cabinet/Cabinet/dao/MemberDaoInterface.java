package com.cabinet.Cabinet.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

import com.cabinet.Cabinet.dto.MemberDTO;

public interface MemberDaoInterface {
	
	//유저정보
	int regMember(MemberDTO memberDTO) throws SQLException; //유저 회원가입 메서드
	int getKey(String inputId, String member_key); //유저 인증키 생성 메서드
	int alter_memberKey(String inputId, String key); //유저 인증키 y로 바꿔주는 메서드
	int searchPassword(String inputId, String inputEmail, String key); //회원 임시 비밀번호 변경 메서드
	MemberDTO loginMember(@Param("inputId")String inputId); //유저 로그인 메서드
}
