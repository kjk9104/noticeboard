package com.noticeboard.post.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.noticeboard.comment.bo.CommentBO;
import com.noticeboard.comment.model.CommentView;
import com.noticeboard.common.FileManagerSevice;
import com.noticeboard.like.bo.LikeBO;
import com.noticeboard.like.model.Like;
import com.noticeboard.post.dao.PostDAO;
import com.noticeboard.post.model.Post;
import com.noticeboard.post.model.PostDetail;
import com.noticeboard.post.model.PostListView;
import com.noticeboard.user.bo.UserBO;
import com.noticeboard.user.model.User;

@Service
public class PostBO {
	@Autowired
	private FileManagerSevice fileManager;
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private UserBO userBO;
	@Autowired
	private CommentBO commentBO;
	@Autowired
	private LikeBO likeBO;
	// 게시물 리스트
	public List<PostListView> getPostByOffset(int page, double limit, String selected, String searchWord) {
		int offset = (int) (page*limit);

		List<Post> postList = postDAO.selectPostByOffset(offset);
		List<PostListView> postListView = new ArrayList<>();
//		List<Like> likeCountList=  likeBO.getLikeList();
		
		if(selected.equals("조회수")) {
			postList = postDAO.selectPostByCountViewAndOffset(offset);
		}
		
		if(searchWord != null) {
			postList = postDAO.selectPostBySerchWordAndOffset(offset, searchWord);
		}
		
//		if(selected.equals( "추천수")) {
//			for(Like like :  likeCountList) {
//				like.getPost_id();
//			}
//		}
		
		for(Post post : postList) {
			PostListView postView = new PostListView(); 
			User user = userBO.getByUserId(post.getUser_id());
			
			List<Like> likeList = likeBO.getLikeListByPostId(post.getId());
			int likeSize = likeList.size();
			
			postView.setPost(post);
			postView.setUser(user);
			postView.setLikeSize(likeSize);
			
			postListView.add(postView);
		}
		
		return postListView;
		
	}
	// 게시물 페이징을 위한 db select
	public List<Post> getPost() {
		return postDAO.selectPost();
	}
	
	// 게시물 저장
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
	// 게시물 상세 단일 정보
	public Post getPostByid(int id) {
		return postDAO.selectPostByid(id);
	}
	
	// 게시물 상세 정보
	public PostDetail getPostDetail(int postId, int userIdex){
		PostDetail postDetail = new PostDetail();
		
		
		Post post = getPostByid(postId);
		int userId = post.getUser_id();
		
		User user = userBO.getByUserId(userId);
		
		int countView = post.getCountView();
		updateCountView(postId,countView);
		List<CommentView> commentViewList = commentBO.generateCommentVeiwListByPostId(postId);
		
		boolean like = likeBO.getLikeByuserIdAndPostId(postId, userIdex);
		List<Like> likeList = likeBO.getLikeListByPostId(postId);
		int likeSize = likeList.size();
		
		
		postDetail.setPost(post);
		postDetail.setUser(user);
		postDetail.setCommentView(commentViewList);
		postDetail.setLike(like);
		postDetail.setLikeCount(likeSize);
			
		return postDetail;
		
	}
	
	// 게시물 삭제
	public void deletePostByid(int postId) {
		postDAO.deletePostByid(postId);
		commentBO.delteCommentByPostId(postId);
		likeBO.delLikeByPostId(postId);
	}
	
	// 게시물 수정
	public void updatePost(int postId, String userNickname, String subject, String content, MultipartFile file) {
		Post post =  postDAO.selectPostByid(postId);
		String imagePath ="null";
		if(post == null) {
			return;
		}
		
		if(file != null) {
			imagePath = fileManager.savsFile(userNickname, file);
			
			if (imagePath != null && post.getImge_path() != null) {
				// 기존 이미지 삭제
				try {
					fileManager.deleteFile(post.getImge_path());
				} catch (IOException e) {
					
				}
			}
		}
		postDAO.updatePost(postId, subject, content, imagePath);
	}
	
	public void updateCountView(int postId, int countView) {
		countView++;
		postDAO.updateCountView(postId, countView);
	}
}
