package com.noticeboard.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noticeboard.notice.bo.NoticeBO;
import com.noticeboard.notice.model.Notice;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeBO noticeBO;
	
	
	// http://localhost/notice/notice_list_view
	@RequestMapping("/notice_list_view")
	public String noticeList(
			Model model
			,HttpSession session
			) {
		String userNickname = (String) session.getAttribute("userNickname");
		List<Notice> noticeList = noticeBO.getNoticeList();
		
		model.addAttribute("viewName", "notice/notice_list");
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("userNickname", userNickname);
		
		return "/template/layout";
	}
	
	// http://localhost/notice/notice_create_view
	@RequestMapping("/notice_create_view")
	public String noticeCreate(
			Model model
			) {
		
		
		model.addAttribute("viewName", "notice/notice_create");
		return "/template/layout";
	}
	
	// http://localhost/notice/notice_detail_view
	@RequestMapping("/notice_detail_view")
	public String noticeDetail(
			Model model
			,@RequestParam("id") int id
			,HttpSession session
			) {
		
		Notice notice = noticeBO.getNotice(id);
		String userNickname = (String) session.getAttribute("userNickname");
		
		model.addAttribute("notice",notice);
		model.addAttribute("userNickname",userNickname);
		model.addAttribute("viewName", "notice/notice_detail");
		return "/template/layout";
	}
	
	
	
}
