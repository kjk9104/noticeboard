package com.noticeboard.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.post.model.Post;

@Repository
public interface PostDAO {
	// 게시물 최신순 리스트 목록
	public List<Post> selectPostByOffset(int offset);
	
	// 게시물 조회수 리스트 목록 
	public List<Post> selectPostByCountViewAndOffset(int offset);
	
	// 게시물 검색어 최신순 목록
	public List<Post> selectPostBySerchWordAndOffset(
			@Param("offset") int offset
			,@Param("searchWord") String searchWord);
	
	// 게시물 전체 size를 알기위한 select
	public List<Post> selectPost();
	
	// 게시물 추가
	public void insertPost(
			@Param("userId") int userId
			,@Param("subject") String subject
			,@Param("content") String content
			,@Param("imagePath") String imagePath);
	
	// 게시물 상세 페이지 
	public Post selectPostByid(int id);
	
	// 게시물 삭제
	public void deletePostByid(int postId);
	
	// 게시물 업데이트
	public void updatePost(
			@Param("postId") int postId
			,@Param("subject") String subject
			,@Param("content") String content
			,@Param("imagePath") String imagePath);
	
	//게시물 조회수 추가
	public void updateCountView(@Param("postId")int postId, @Param("countView")int countView);
	
	
}
