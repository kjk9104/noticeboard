package com.noticeboard.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.user.model.User;

@Repository
public interface UserDAO {

	// 아이디 중복확인
	public boolean selectUserByLoginId(String loginId);
	// 닉네임 중복확인
	public boolean selectByNickName(String nickName);
	// 회원가입
	public void insertUser(
			@Param("loginId") String loginId, 
			@Param("password")String password, 
			@Param("name")String name, 
			@Param("nickName")String nickName, 
			@Param("eMail")String eMail, 
			@Param("phoneNum")String phoneNum);
	
}
