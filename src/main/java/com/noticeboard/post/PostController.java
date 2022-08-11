package com.noticeboard.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noticeboard.post.bo.PostBO;
import com.noticeboard.post.model.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostBO PostBO;
	
	// http://localhost/post/post_list_view
	@RequestMapping("/post_list_view")
	public String postList(Model model) {
	
		List<Post> postList = PostBO.getPost();
		
		model.addAttribute("viewName", "post/post_list");
		model.addAttribute("postList", postList);
		
		return "/template/layout";
	}
	
	// http://localhost/post/post_create_view
	@RequestMapping("/post_create_view")
	public String postCreate(
			Model model
			) {
		model.addAttribute("viewName", "post/post_create");
		return "/template/layout";
	}
	
}
