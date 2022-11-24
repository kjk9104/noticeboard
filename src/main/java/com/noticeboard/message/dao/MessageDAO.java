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
	
	// id 값으로 삭제 Message list 갖고 오기
	public Message selectMsgListByid(int id);
		
	// id 값으로 send_message 값 false로 수정 
	public void updateSendMsgById(int id);
	
	// id 값으로 receive_message 값 false로 수정 
	public void updateReceiveMsgById(int id);
	
	// id 값으로 message 삭제 
	public void delMsgbyId(int id);
	
	
		
}
