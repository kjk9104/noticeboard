package com.noticeboard.comment.model;

import java.util.List;

import com.noticeboard.commentComment.model.CommentCommentView;
import com.noticeboard.user.model.User;

public class CommentView {
	private Comment comment;
	private List<CommentCommentView> commentComment;
	private User user;
	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public List<CommentCommentView> getCommentComment() {
		return commentComment;
	}
	public void setCommentComment(List<CommentCommentView> commentComment) {
		this.commentComment = commentComment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
}
