package com.noticeboard.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.noticeboard.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {
	@Autowired
	private PostBO postBO;

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
			result.put("result", "error");
			result.put("error", "로그인 후 사용 가능합니다.");
			return result;
		}
		
		//  로그인 된 사용자
		int userId = (int)userIdObject;
		String userNickname = (String)session.getAttribute("userNickname");
		
		// 글쓰기 db insert
		
		postBO.addPost(userId, userNickname, subject, content, file);
				
		
			
		return result;
	}
}
