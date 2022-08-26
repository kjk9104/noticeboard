package com.noticeboard.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.noticeboard.comment.bo.CommentBO;
import com.noticeboard.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {
	@Autowired
	private PostBO postBO;
	@Autowired
	private CommentBO commentBO;
	// 게시물 작성
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("subject") String subject
			,@RequestParam("content") String content
			,@RequestParam(value="file", required=false) MultipartFile file
			,HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		
		Object userIdObject = session.getAttribute("userId");
		// 비로그인시
		if(userIdObject == null) {
			result.put("errorMessage", "error");
			result.put("errorMessage", "로그인 후 사용 가능합니다.");
			return result;
		}
		
		//  로그인 된 사용자
		int userId = (int)userIdObject;
		String userNickname = (String)session.getAttribute("userNickname");
		
		
		postBO.addPost(userId, userNickname, subject, content, file);
		
		result.put("result", "success");
				
			
		return result;
	}
	
	// 게시물 삭제
	@DeleteMapping("/delete")
	public Map<String, Object> deletePost(
			@RequestParam("postId") int postId ){
		Map<String, Object> result = new HashMap<>();
		 postBO.deletePostByid(postId);
		 commentBO.delteCommentByPostId(postId);
		 result.put("result", "success");
		
		return result;
	}
	// 게시물 수정
	@PutMapping("/update")
	public Map<String, Object> updatePost(
			@RequestParam("postId") int postId
			,@RequestParam("subject") String subject
			,@RequestParam("content") String content
			,@RequestParam(value="file", required=false) MultipartFile file
			,HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		String userNickname = (String) session.getAttribute("userNickname");
		postBO.updatePost(postId, userNickname, subject, content, file);
		
		result.put("result", "success");
		
		return result;
	}
	
}
