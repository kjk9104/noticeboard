package com.noticeboard.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.post.model.Post;

@Repository
public interface PostDAO {

	public List<Post> selectPostByOffset(int offset);
	public List<Post> selectPost();
	
	public void insertPost(
			@Param("userId") int userId
			,@Param("subject") String subject
			,@Param("content") String content
			,@Param("imagePath") String imagePath);
	
	public Post selectPostByid(int id);
	
	public void deletePostByid(int postId);
	
	public void updatePost(
			@Param("postId") int postId
			,@Param("subject") String subject
			,@Param("content") String content
			,@Param("imagePath") String imagePath);
	
	public void updateCountView(@Param("postId")int postId, @Param("countView")int countView);
	
	
}
