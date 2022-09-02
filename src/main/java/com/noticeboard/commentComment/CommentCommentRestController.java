package com.noticeboard.commentComment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.commentComment.bo.CommentCommentBO;

@RestController
@RequestMapping("/commentComment")
public class CommentCommentRestController {
	@Autowired
	private CommentCommentBO commentCommentBO;
	
	/**
	 * 답글(대댓글) 입력
	 * @param postId
	 * @param commentId
	 * @param commentComment
	 * @param session
	 * @return
	 */
	@RequestMapping("/create")
	public Map<String, Object> addCommentComment(
			@RequestParam("postId") int postId
			,@RequestParam("commentId") int commentId
			,@RequestParam("commentComment") String commentComment
			,HttpSession session
			){
		Map<String, Object> result = new HashMap<>();
		int userId = (int)session.getAttribute("userId");
		commentCommentBO.addCommentComment(postId, commentId, userId, commentComment);
		
		result.put("result", "success");
		
		return result;
	} 
	/**
	 * 답글(대댓글) 삭제
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public Map<String, Object>delCommentComment(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();
		commentCommentBO.delCommentCommentById(id);
		
		result.put("result", "success");
		return result;
	}
	
}
