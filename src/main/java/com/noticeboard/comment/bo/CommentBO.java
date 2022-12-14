package com.noticeboard.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.comment.dao.CommentDAO;
import com.noticeboard.comment.model.Comment;
import com.noticeboard.comment.model.CommentView;
import com.noticeboard.commentComment.bo.CommentCommentBO;
import com.noticeboard.commentComment.model.CommentCommentView;
import com.noticeboard.user.bo.UserBO;
import com.noticeboard.user.model.User;

@Service
public class CommentBO {
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private UserBO userBO;
	@Autowired
	private CommentCommentBO commentCommentBO;
	// 댓글 작성
	public void addComment(int userId, int postId, String content) {
		commentDAO.insertComment(userId, postId, content);

	}
	
	// 댓글 목록 불러오기
	public List<Comment> getCommentByPostId(int posId){
		
		return commentDAO.selectCommentByPostId(posId);
	}
	
	// 댓글 유저 닉네임 댓글 불러오기
	public List<CommentView> generateCommentVeiwListByPostId(int postId){
		
		List<Comment> commentList = getCommentByPostId(postId);
		
		List<CommentView> CommentViewList = new ArrayList<>();
		
		for(Comment comments : commentList) {
			CommentView comment = new CommentView();
			int commentId = comments.getId();
			comment.setComment(comments);
			List<CommentCommentView> generateCommentCommentVeiwListByCommentId = commentCommentBO.generateCommentCommentVeiwListByCommentId(commentId);
			comment.setCommentComment(generateCommentCommentVeiwListByCommentId);
			
			User user = userBO.getByUserId(comments.getUser_id());
			comment.setUser(user);
			
			CommentViewList.add(comment);
		}
		
		return CommentViewList;
		
	}
	// 게시물 관련 댓글 및 답글(대댓글) 전부 삭제
	public void delteCommentByPostId(int postId) {
		commentDAO.delteCommentByPostId(postId);
		commentCommentBO.delCommentCommentByPostId(postId);
	}
	
	// 댓글 삭제
	public void commentDel(int id) {
		commentDAO.commentDel(id);
		commentCommentBO.delCommentCommentByCommentId(id);
	}
	
	
	
	
	
	
	
	
	
	
}
