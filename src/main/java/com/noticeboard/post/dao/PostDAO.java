package com.noticeboard.post.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.noticeboard.post.model.Post;

@Repository
public interface PostDAO {

	public List<Post> selectPost();
}
