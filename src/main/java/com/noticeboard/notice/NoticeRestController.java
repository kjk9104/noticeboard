package com.noticeboard.notice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.noticeboard.notice.bo.NoticeBO;

@RestController
@RequestMapping("/notice")
public class NoticeRestController {
	@Autowired
	private NoticeBO noticeBO;
	/**
	 * 공지 일정 추가
	 * @param subject
	 * @param content
	 * @param file
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> noticeCreate(
			@RequestParam("subject") String subject
			,@RequestParam("content") String content
			,@RequestParam(value="file", required=false) MultipartFile file
			,@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate
			,@RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate
			,HttpSession session
			){
		Map<String, Object> result = new HashMap<>();
		
		int userId = (int) session.getAttribute("userId");
		String userNickname = (String) session.getAttribute("userNickname");
	
		noticeBO.addNotice(userId, subject, content, file, startDate, endDate, userNickname);
		
		result.put("result", "success");
		
		return result;
	}
	/**
	 * 공지 일정 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public Map<String, Object> noticeDelete(
			@RequestParam("id") int id
			){
		Map<String, Object> result = new HashMap<>();
		
		noticeBO.delNotice(id);
		
		result.put("result", "success");
		return result;
	}
}
