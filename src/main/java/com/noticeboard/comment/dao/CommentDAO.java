package com.noticeboard.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.comment.model.Comment;
import com.noticeboard.comment.model.CommentComment;

@Repository
public interface CommentDAO {
	public void insertComment(
			@Param("userId")int userId
			,@Param("postId") int postId
			,@Param("content") String content
			);
	
	public void delteCommentByPostId(int postId); 
	
	public  List<Comment> selectCommentByPostId(int posId);
	
	public void commentDel(int id);
	
	public void insertCommentComment(
			@Param("commentId") int commentId
			,@Param("userId") int userId
			,@Param("commentComment") String commentComment
			);

	public  List<CommentComment> selectCommentCommentByCommentId(int commentId);
	
	public CommentComment selectCommentById(int Id);
	
}
