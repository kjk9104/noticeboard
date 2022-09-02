package com.noticeboard.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.comment.bo.CommentBO;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
	@Autowired
	private CommentBO commentBO;
	
	/**
	 * 댓글 작성
	 * @param postId
	 * @param comment
	 * @param session
	 * @return
	 */
	@RequestMapping("/create")
	public Map<String, Object>commentCreate(
			@RequestParam("postId") int postId
			,@RequestParam("content") String content
			,HttpSession session
			) {
		int userId = (int) session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		
		commentBO.addComment(userId,postId,content);
		
		result.put("result", "success");
	
		return result;
	}
	
	/**
	 * 댓글 삭제
	 * @param commentId
	 * @return
	 */
	@DeleteMapping("delete")
	public Map<String, Object>commentDelete(
			@RequestParam("commentId") int commentId
			){
		Map<String, Object> result = new HashMap<>();
		commentBO.commentDel(commentId);
		
		result.put("result", "success");
		return result;
		
	}
	
}
