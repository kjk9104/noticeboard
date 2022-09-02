package com.noticeboard.commentComment.model;

import com.noticeboard.user.model.User;

public class CommentCommentView {
	private CommentComment commentComment;
	private User user;
	
	public CommentComment getCommentComment() {
		return commentComment;
	}
	public void setCommentComment(CommentComment commentComment) {
		this.commentComment = commentComment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	


	
	
}