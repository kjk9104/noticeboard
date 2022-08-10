package com.noticeboard.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.user.dao.UserDAO;
import com.noticeboard.user.model.User;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	// 아이디 중복체크
	public boolean getUserByLoginId(String loginId) {
		return userDAO.selectUserByLoginId(loginId);
	}
	// 닉네임 중복체크
	public boolean getUserByNickName(String nickName) {
		return userDAO.selectByNickName(nickName);
	}
	// 회원가입
	public void addUser(String loginId, String password, String name, String nickName, String eMail, String phoneNum) {
		userDAO.insertUser(loginId, password, name, nickName, eMail, phoneNum);
		
	}
	// 로그인
	public boolean getByLoginIdAndPassword(String loginId, String loginPassword) {
		return userDAO.selectByLoginIdAndPassword(loginId, loginPassword);
	};
}
