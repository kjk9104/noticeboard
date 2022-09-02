package com.noticeboard.notice.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.noticeboard.common.FileManagerSevice;
import com.noticeboard.notice.dao.NoticeDAO;
import com.noticeboard.notice.model.Notice;

@Service
public class NoticeBO {
	@Autowired
	private FileManagerSevice fileManager;
	@Autowired
	private NoticeDAO noticeDAO;
	// 공지 일정 추가
	public void addNotice(int userId, String subject, String content, MultipartFile file, Date startDate, Date endDate, String userNickname) {
		String imagePath ="null";
		
		if(file != null) {
			imagePath = fileManager.savsFile(userNickname, file);
		}
		
		noticeDAO.insertNotice(userId, subject, content, imagePath, startDate, endDate);
		
	}
	
	// notice 테이블 전체 select
	public List<Notice> getNoticeList(){
		return noticeDAO.selectNoticeList();
	}
	// notice 상세 페이지 내용
	public Notice getNotice(int id) {
		return noticeDAO.selectNotice(id);
		
	}
	
	// notice 삭제
	public void delNotice(int id) {
		noticeDAO.delNotice(id);
	}
}
