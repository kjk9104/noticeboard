package com.noticeboard.comment.model;

import java.util.List;

import com.noticeboard.user.model.User;

public class CommentCommentView {
	private List<CommentComment> commentComment;
	private Comment comment;
	private User user;
	
	public List<CommentComment> getCommentComment() {
		return commentComment;
	}
	public void setCommentComment(List<CommentComment> commentComment) {
		this.commentComment = commentComment;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	
	
}
