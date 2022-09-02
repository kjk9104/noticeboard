package com.noticeboard.commentComment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.commentComment.dao.CommentCommentDAO;
import com.noticeboard.commentComment.model.CommentComment;
import com.noticeboard.commentComment.model.CommentCommentView;
import com.noticeboard.user.bo.UserBO;
import com.noticeboard.user.model.User;

@Service
public class CommentCommentBO {
	@Autowired
	private CommentCommentDAO commentCommentDAO;	
	@Autowired
	private UserBO userBO;
	
	// 답글(대댓글) 작성
	public void addCommentComment(
			int postId
			,int commentId
			,int userId
			,String commentComment
			) {
		commentCommentDAO.insertCommentComment(postId, commentId, userId, commentComment);
	}
	// 답글(대댓글) 목록 불러오기
	public List<CommentComment> getCommentCommentByCommentId(int commentId){
		return commentCommentDAO.selectCommentCommentByCommentId(commentId);
		
	}
	// 답글(대댓글) 단일목록 불러오기
	public CommentComment getCommentById(int id) {
		return commentCommentDAO.selectCommentById(id);
		
	}
	// 답글(대댓글) 유저 닉네임 댓글 불러오기
	public List<CommentCommentView> generateCommentCommentVeiwListByCommentId(int commentId){
		
		List<CommentComment> commentCommentList = getCommentCommentByCommentId(commentId);
		List<CommentCommentView> commentCommentViewList = new ArrayList<>();
		
		
		for(CommentComment comments : commentCommentList) {
			CommentCommentView commentComment = new CommentCommentView();
			
			User user = userBO.getByUserId(comments.getUser_id());
			CommentComment commentCommentcontent = getCommentById(comments.getId());
			commentComment.setUser(user);
			commentComment.setCommentComment(commentCommentcontent);
			
			commentCommentViewList.add(commentComment);
		}
		
		return commentCommentViewList;
	}
	// 답글(대댓글) 삭제
	public void delCommentCommentById(int id) {
		commentCommentDAO.delCommentComment(id);
	}
	// 게시물 관련 답글(대댓글) 삭제
	public void delCommentCommentByPostId(int postId) {
		commentCommentDAO.delteCommentCommentByPostId(postId);
	}
	// 댓글 관련 답글(대댓글) 삭제
	public void delCommentCommentByCommentId(int commentId) {
		commentCommentDAO.delCommentCommentDelByCommentId(commentId);;
	}
}
