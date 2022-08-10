package com.noticeboard.post.model;

import java.util.Date;

public class Post {

	private int id;
	private String user_id;
	private String subject;
	private String imge_path;
	private int countView;
	private Date createdAt;
	private Date updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getImge_path() {
		return imge_path;
	}
	public void setImge_path(String imge_path) {
		this.imge_path = imge_path;
	}
	public int getCountView() {
		return countView;
	}
	public void setCountView(int countView) {
		this.countView = countView;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
