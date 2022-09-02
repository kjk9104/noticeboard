package com.noticeboard.like.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.noticeboard.like.model.Like;

@Repository
public interface LikeDAO {

	public boolean selectLikeByUserIdAndPostId(
			@Param("postId") int postId
			,@Param("userId") int userId);
	
	public void insertLike(
			@Param("postId") int postId
			,@Param("userId") int userId
			);
	
	public void deleteLike(
			@Param("postId") int postId
			,@Param("userId") int userId
			);
	
	public List<Like> selectLikeListByPostId(int postId);
	
	public Like getLikeByPostId(int postId);
	
	public void delLikeByPostId(int postId);
}
