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
	// 로그인2(세션에 id를 저장하기 위해 가져오는 값)
	public User getByLoginIdAndPasswordforId(String loginId, String loginPassword) {
		return userDAO.selectByLoginIdAndPasswordforId(loginId, loginPassword);
	};
	// post user단일 정보 가져오기
	public User getByUserId(int id) {
		return userDAO.selectByUserId(id);
	}
//	// postId로 user 가져오기
//	public User getUserByPostId(int id){
//		return userDAO.selectUserByPostId(id);
//	}
}
