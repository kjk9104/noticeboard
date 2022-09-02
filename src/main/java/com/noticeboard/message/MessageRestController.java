package com.noticeboard.message;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.message.bo.MessageBO;
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
		
		String userNickname = (String) session.getAttribute("userNickname");
		
		messageBO.addMessage(userNickname, otherNickname, msg);
		
		result.put("result", "success");
		
		return result;
	} 
	
	
	
	
	
	
	
}
