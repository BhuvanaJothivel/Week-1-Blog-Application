package com.prograd.blogapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.prograd.blogapp.model.Blog;

public interface BlogDao {

	void insertBlog(Blog todo) throws SQLException;

	Blog selectBlog(long todoId);

	List<Blog> selectAllBlogs();

	boolean deleteBlog(int id) throws SQLException;

	boolean updateBlog(Blog todo) throws SQLException;

}