package com.noticeboard.post.model;

import com.noticeboard.user.model.User;

public class PostListView {
	private Post post;
	private User user;
	private int likeSize;
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getLikeSize() {
		return likeSize;
	}
	public void setLikeSize(int likeSize) {
		this.likeSize = likeSize;
	}
	
	
	
	
}
