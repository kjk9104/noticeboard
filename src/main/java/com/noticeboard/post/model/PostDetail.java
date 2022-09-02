package com.noticeboard.post.model;

import java.util.List;

import com.noticeboard.comment.model.CommentView;
import com.noticeboard.user.model.User;

public class PostDetail {
	private Post post;
	private User user;
	private List<CommentView> commentView;
	private boolean like;
	private int likeCount;
	
	public Post getPost() {
		return post;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
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
	public List<CommentView> getCommentView() {
		return commentView;
	}
	public void setCommentView(List<CommentView> commentView) {
		this.commentView = commentView;
	}
	public boolean isLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}

	
	
	
	
	
	
	
	
	
	
}
