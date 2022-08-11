package com.noticeboard.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.noticeboard.common.FileManagerSevice;
import com.noticeboard.post.dao.PostDAO;
import com.noticeboard.post.model.Post;

@Service
public class PostBO {
	@Autowired
	private FileManagerSevice fileManager;
	@Autowired
	private PostDAO postDAO;
	
	// 게시물 목록
	public List<Post> getPost() {
		return postDAO.selectPost();
		
	}
	//게시물 생성
	public void addPost (
			int userId
			,String userNickname
			,String subject
			,String content
			,MultipartFile file) {
		String imagePath ="null";
		
		if(file != null) {
			imagePath = fileManager.savsFile(userNickname, file);
		}
		
		postDAO.insertPost(userId, subject, content, imagePath);
	}
	
}
