package com.noticeboard.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.like.bo.LikeBO;

@RestController
@RequestMapping("like")
public class LikeRestController {
	@Autowired
	private LikeBO likeBO;
	
	
	@RequestMapping("like")
	public Map<String, Object> Like(
			@RequestParam("postId") int postId
			,HttpSession session
			){
		Map<String, Object> result = new HashMap<>();
		
		int userId = (int)session.getAttribute("userId");
		
		likeBO.LikeOnOff(postId, userId);
		
		result.put("result", "success");
		return result;
	}
}
