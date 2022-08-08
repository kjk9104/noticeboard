package com.noticeboard.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.user.dao.UserDAO;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	public boolean getUserByLoginId(String loginId) {
		return userDAO.selectUserByLoginId(loginId);
	}
	public boolean getUserByNickName(String nickName) {
		return userDAO.selectByNickName(nickName);
	}
}
