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
	
	// id 값으로 삭제 Message list 갖고 오기
	public Message getMsgListByid(int id){
		return messageDAO.selectMsgListByid(id);
	}
	
	// id 값으로 send_message 값 false로 수정 
	public void updateSendMsgById(int id) {
		messageDAO.updateSendMsgById(id);
	}
	
	// id 값으로 receive_message 값 false로 수정 
	public void updateReceiveMsgById(int id) {
		messageDAO.updateReceiveMsgById(id);
	}
	
	// id 값으로 message 삭제 
	public void delMsgbyId(int id) {
		messageDAO.delMsgbyId(id);
	}
	
}
