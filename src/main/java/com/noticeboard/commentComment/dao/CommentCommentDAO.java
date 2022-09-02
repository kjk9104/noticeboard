package com.noticeboard.commentComment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.commentComment.model.CommentComment;

@Repository
public interface CommentCommentDAO {
	// 답글(대댓글) 작성
	public void insertCommentComment(
			@Param("postId") int postId
			,@Param("commentId") int commentId
			,@Param("userId") int userId
			,@Param("commentComment") String commentComment
			);

	// 댓글 관련 답글(대댓글) 목록 가져오기
	public  List<CommentComment> selectCommentCommentByCommentId(int commentId);
	
	// 대댓글 단일로 가져오기
	public CommentComment selectCommentById(int Id);
	
	// 대댓글 삭제
	public void delCommentComment(int id);
	
	// 댓글 관련 답글(대댓글) 삭제
	public void delCommentCommentDelByCommentId (int commentId);
	
	// 게시물 관련 답글(대댓글) 삭제
	public void delteCommentCommentByPostId(int postId);











}
