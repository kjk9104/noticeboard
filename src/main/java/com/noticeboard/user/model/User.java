package com.noticeboard.user.model;

import javax.xml.crypto.Data;

public class User {

	private int id;
	private String login_id;
	private String password;
	private String name;
	private String nick_name;
	private String eMail;
	private String phone_num;
	private Data createdAt;
	private Data updatedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public Data getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Data createdAt) {
		this.createdAt = createdAt;
	}
	public Data getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Data updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
