package com.noticeboard.notice.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.notice.model.Notice;

@Repository
public interface NoticeDAO {
	// 공지 일정 추가
	public void insertNotice(
			@Param("userId") int userId, 
			@Param("subject") String subject, 
			@Param("content") String content, 
			@Param("imagePath") String imagePath, 
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate
			);
	// notice 테이블 전체 select
	public List<Notice> selectNoticeList();
	
	// notice 상세 페이지 내용
	public Notice selectNotice(int id);
	
	// notice 삭제
	public void delNotice(int id);
}
