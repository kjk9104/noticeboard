package com.noticeboard.like.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.like.dao.LikeDAO;
import com.noticeboard.like.model.Like;

@Service
public class LikeBO {
	@Autowired
	private LikeDAO likeDAO;
	
	// 좋아요 on off
	public void LikeOnOff(
			int postId 
			,int userId) {
			boolean like = likeDAO.selectLikeByUserIdAndPostId(postId, userId);
			if(like == false) {
				// on 일때 off 로 바꿈
				likeDAO.insertLike(postId, userId);
			}else if(like) {
				// off 일때 on 으로 빠굼
				likeDAO.deleteLike(postId, userId);
			}
	}
	
	// 좋아요 있으면 true 없으면 false
	public boolean getLikeByuserIdAndPostId(int postId,int userId) {
		return likeDAO.selectLikeByUserIdAndPostId(postId, userId);
	}
	
	// 좋아요 수를 가져오기 위한 리스트
	public List<Like> getLikeListByPostId(int postId){
		return likeDAO.selectLikeListByPostId(postId);
	}
	
		
	// 좋아요 off
	public void delLikeByPostId(int postId){
		likeDAO.delLikeByPostId(postId);
	}
	
////	 좋아요 순으로 리스트 뽑아오기
//	public List<Like> getLikeList(){
//		return likeDAO.selectLikeList();
//	}
		
	
}
