package com.noticeboard.message.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.message.model.Message;

@Repository
public interface MessageDAO {

	// 메세지 보내기
	public void insertMessage(
			@Param("userNick") String userNick, 
			@Param("otherNick") String otherNick, 
			@Param("talk") String talk );
	
	// 세션의 닉네임으로 검색하는 받은 메일 리스트
	public List<Message> selectMessageListByNickFromOtherNick(String otherNick);
	
	// 세션의 닉네임으로 검색하는 보낸 메일 리스트
	public List<Message> selectMessageListByNickFromUserNick(String userNick);
}
