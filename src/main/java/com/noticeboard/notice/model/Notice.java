package com.noticeboard.notice.model;

import java.util.Date;

public class Notice {
	private int id;
	private int user_id;
	private String subject;
	private String content;
	private String imge_path;
	private Date start_schedule;
	private Date end_schedule;
	private Date createdAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImge_path() {
		return imge_path;
	}
	public void setImge_path(String imge_path) {
		this.imge_path = imge_path;
	}
	public Date getStart_schedule() {
		return start_schedule;
	}
	public void setStart_schedule(Date start_schedule) {
		this.start_schedule = start_schedule;
	}
	public Date getEnd_schedule() {
		return end_schedule;
	}
	public void setEnd_schedule(Date end_schedule) {
		this.end_schedule = end_schedule;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
