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
import com.noticeboard.post.model.PostListView;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostBO postBO;
	
	// http://localhost/post/post_list_view?offset=0
	@RequestMapping("/post_list_view")
	public String postList(Model model
			,@RequestParam(value="offset", required=false) int page 
			,@RequestParam(value="selectBox", required=false) String selected 
			,@RequestParam(value="searchWord", required=false) String searchWord 
			) {
		int startNum = 1;
		int endtNum = 5;
		int pageNum = page+1;
		double limit = 5;
		
		if(selected == null) {
			selected = "최신순";
		}
		
		System.out.println(selected);
		
		List<PostListView> postList = postBO.getPostByOffset(page, limit, selected, searchWord);
		List<Post> postAllList = postBO.getPost();
		
		int totalpage = (int) Math.ceil(postAllList.size()/limit); 
		
		if(totalpage <= endtNum) {
			endtNum = totalpage;
		}
		
		
		if(pageNum > 5 && pageNum%5 == 1) {
			startNum = pageNum;
		}
		if(pageNum > 5 && pageNum%5 == 1) {
			endtNum = pageNum+endtNum;
			if(endtNum >= totalpage) {
				endtNum = totalpage;
			}
		}
		
		
		model.addAttribute("viewName", "post/post_list");
		model.addAttribute("postList", postList);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("page", page);
		model.addAttribute("selected", selected);
		model.addAttribute("startNum", startNum);
		model.addAttribute("endtNum", endtNum);
		
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
		PostDetail postDetail = postBO.getPostDetail(postId, userId);
		
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
