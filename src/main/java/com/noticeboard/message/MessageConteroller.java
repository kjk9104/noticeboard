package com.noticeboard.message;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noticeboard.message.bo.MessageBO;
import com.noticeboard.message.model.Message;

@Controller
@RequestMapping("/message")
public class MessageConteroller {
	
	@Autowired
	private MessageBO messageBO;
	
	
	
	
	// http://localhost/message/message_receive_list_view
	@RequestMapping("/message_receive_list_view")
	public String messageReceiveListView(
			Model model
			,HttpSession session
			) {
		
		String userNickname = (String) session.getAttribute("userNickname");
		
		List<Message> MessageList = messageBO.getMessageListByNickFromOtherNick(userNickname);
		
		model.addAttribute("viewName", "message/message_receive_list");
		model.addAttribute("MessageList", MessageList);

		return "/template/layout";
	}
	
	
	// http://localhost/message/message_send_list_view
	@RequestMapping("/message_send_list_view")
	public String messageSendListView(
			Model model
			,HttpSession session
			) {
		
		String userNickname = (String) session.getAttribute("userNickname");
		
		List<Message> MessageList = messageBO.getMessageListByNickFromUserNick(userNickname);
		
		model.addAttribute("viewName", "message/message_send_list");
		model.addAttribute("MessageList", MessageList);

		return "/template/layout";
	}
	
	
}
