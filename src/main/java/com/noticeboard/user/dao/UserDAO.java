package com.noticeboard.user.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	public boolean selectUserByLoginId(String loginId);
	public boolean selectByNickName(String nickName);
	
}
