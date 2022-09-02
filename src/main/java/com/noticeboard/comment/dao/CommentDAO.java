package com.noticeboard.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.comment.model.Comment;

@Repository
public interface CommentDAO {
	// 댓글 추가
	public void insertComment(
			@Param("userId")int userId
			,@Param("postId") int postId
			,@Param("content") String content
			);
	
	// 게시물 관련 댓글 삭제
	public void delteCommentByPostId(int postId); 
	
	// 게시물 관련 댓글 목록 찾기
	public  List<Comment> selectCommentByPostId(int posId);
	
	// 댓글 삭제
	public void commentDel(int id);
	
	
	
	
	
}
