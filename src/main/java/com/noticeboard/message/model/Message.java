package com.noticeboard.message.model;

import java.util.Date;

public class Message {
	private int id;
	private String user_nickName;
	private String other_nick_name;
	private String talk;
	private boolean receive_message;
	private boolean send_message;
	private Date createdAt;
	private Date updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_nickName() {
		return user_nickName;
	}
	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}
	public String getOther_nick_name() {
		return other_nick_name;
	}
	public void setOther_nick_name(String other_nick_name) {
		this.other_nick_name = other_nick_name;
	}
	public String getTalk() {
		return talk;
	}
	public void setTalk(String talk) {
		this.talk = talk;
	}
	public boolean isReceive_message() {
		return receive_message;
	}
	public void setReceive_message(boolean receive_message) {
		this.receive_message = receive_message;
	}
	public boolean isSend_message() {
		return send_message;
	}
	public void setSend_message(boolean send_message) {
		this.send_message = send_message;
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
