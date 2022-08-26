package com.noticeboard.post.bo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.noticeboard.comment.bo.CommentBO;
import com.noticeboard.comment.model.Comment;
import com.noticeboard.comment.model.CommentCommentView;
import com.noticeboard.comment.model.CommentView;
import com.noticeboard.common.FileManagerSevice;
import com.noticeboard.post.dao.PostDAO;
import com.noticeboard.post.model.Post;
import com.noticeboard.post.model.PostDetail;
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
	
	// 게시물 목록
	public List<Post> getPostByOffset(int page, double limit) {
		int offset = (int) (page*limit);
		return postDAO.selectPostByOffset(offset);
		
	}
	public List<Post> getPost() {
		return postDAO.selectPost();
	}
	// 게시물 생성
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
	public PostDetail getPostDetail(int postId){
		PostDetail postDetail = new PostDetail();
		
		Post post = getPostByid(postId);
		int userId = post.getUser_id();
		
		User user = userBO.getByUserId(userId);
		
		List<CommentView> commentViewList = commentBO.generateCommentVeiwListByPostId(postId);
		
		
		postDetail.setPost(post);
		postDetail.setUser(user);
		postDetail.setCommentView(commentViewList);
		
		
		return postDetail;
		
	}
	
	// 게시물 삭제
	public void deletePostByid(int postId) {
		postDAO.deletePostByid(postId);
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
}
