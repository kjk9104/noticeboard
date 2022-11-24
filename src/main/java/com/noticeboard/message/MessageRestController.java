package com.noticeboard.message;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.message.bo.MessageBO;
import com.noticeboard.message.model.Message;
import com.noticeboard.user.bo.UserBO;

@RestController
@RequestMapping("/message")
public class MessageRestController {

	@Autowired
	private UserBO userBO;
	@Autowired
	private MessageBO messageBO;
	
	
	
	
	/**
	 * 닉네임 확인
	 * @param userNickname
	 * @return
	 */
	@RequestMapping("/chkNick")
	public Map<String, Object> chkNick(
			@RequestParam("userNickname") String userNickname){
		Map<String, Object> result =  new HashMap<>();
		
		boolean chk = userBO.getUserByNickName(userNickname);
		
		if(chk) {
			result.put("result", "success");
			return result;
		}else {
			result.put("result", "fail");
			return result;
		}
	}
	
	
	
	/**
	 * 쪽지 보내기
	 * @param otherNickname
	 * @param msg
	 * @param session
	 * @return
	 */
	@RequestMapping("/sendMsg")
	public Map<String, Object> sendMsg(
			@RequestParam("otherNickname") String otherNickname
			,@RequestParam("msg") String msg
			,HttpSession session
			){
		Map<String, Object> result =  new HashMap<>();
		// 세션에서 닉네임 갖고오기
		String userNickname = (String) session.getAttribute("userNickname");
		
		messageBO.addMessage(userNickname, otherNickname, msg);
		
		result.put("result", "success");
		
		return result;
	} 
	
	/**
	 * 보낸 메세지 삭제
	 * @param id
	 * @return
	 */
	@RequestMapping("/send/delete")
	public Map<String, Object> sendMessageDel(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();
		// id 값을 토대로 message의 receive_message 와 send_message 갖고 오기
		
		System.out.println("보낸 메세지 삭제");
		Message msg = messageBO.getMsgListByid(id);
		// send_message 값 false로 변경
		messageBO.updateSendMsgById(id);
		
		// 둘다 false 일때 데이터 삭제
		if(!msg.isReceive_message()) {
			messageBO.delMsgbyId(id);
		}
		
		// 결과
		result.put("result", "success");
		return result;
	}
	
	/**
	 * 받은 메세지 삭제
	 * @param id
	 * @return
	 */
	@RequestMapping("/receive/delete")
	public Map<String, Object> receiveMessageDel(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();

		// id 값을 토대로 message의 receive_message 와 send_message 갖고 오기
		Message msg = messageBO.getMsgListByid(id);
		
		// receive_message 값 false로 변경
		messageBO.updateReceiveMsgById(id);
		
		
		// 둘다 false 일때 데이터 삭제
		if(!msg.isSend_message()) {
			messageBO.delMsgbyId(id);
		}
		
		// 결과
		result.put("result", "success");
		return result;
	}
	
	
	
	
}
