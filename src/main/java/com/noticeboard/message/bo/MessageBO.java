package com.noticeboard.message.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.message.dao.MessageDAO;
import com.noticeboard.message.model.Message;

@Service
public class MessageBO {
	@Autowired
	private MessageDAO messageDAO;
	
	// 메세지 보내기
	public void addMessage(String userNick, String otherNick, String msg ) {
			messageDAO.insertMessage(userNick, otherNick, msg);
	}
	
	// 세션의 닉네임으로 검색하는 받은 메일 리스트
	public List<Message> getMessageListByNickFromOtherNick(String otherNick){
		return messageDAO.selectMessageListByNickFromOtherNick(otherNick);
	}
	
	// 세션의 닉네임으로 검색하는 받은 메일 리스트
	public List<Message> getMessageListByNickFromUserNick(String userNick){
		return messageDAO.selectMessageListByNickFromUserNick(userNick);
		
	}
}
