package com.noticeboard.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.post.dao.PostDAO;
import com.noticeboard.post.model.Post;

@Service
public class PostBO {
	@Autowired
	private PostDAO postDAO;
	
	public List<Post> getPost() {
		return postDAO.selectPost();
		
	}
}
