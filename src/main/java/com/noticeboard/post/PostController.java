package com.noticeboard.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noticeboard.post.bo.PostBO;
import com.noticeboard.post.model.Post;
import com.noticeboard.post.model.PostDetail;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostBO postBO;
	
	// http://localhost/post/post_list_view
	@RequestMapping("/post_list_view")
	public String postList(Model model
			,@RequestParam(value="offset", required=false) int page 
			) {
		
		double limit = 5;
		List<Post> postList = postBO.getPostByOffset(page, limit);
		List<Post> postAllList = postBO.getPost();
		int totalpage = (int) Math.ceil(postAllList.size()/limit); 
		
		model.addAttribute("viewName", "post/post_list");
		model.addAttribute("postList", postList);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("page", page);
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
	
	
	// http://localhost/post/post_detail_view
	@RequestMapping("/post_detail_view")
	public String postDetail(
			Model model
			,@RequestParam("postId") int postId
			,HttpSession session
			) {
		
		int userId = (int) session.getAttribute("userId");
		PostDetail postDetail = postBO.getPostDetail(postId);
		model.addAttribute("viewName", "post/post_detail");
		model.addAttribute("post", postDetail);
		model.addAttribute("userId", userId);
		
		return "/template/layout";
	}
	
	// http://localhost/post/post_update_view
	@RequestMapping("/post_update_view")
	public String postDetail(
			Model model
			,@RequestParam("postId") int postId
			) {
		Post post = postBO.getPostByid(postId);
		
		model.addAttribute("post", post);
		model.addAttribute("viewName", "post/post_update");
		
		
		return "/template/layout";
	}
	
	
}
