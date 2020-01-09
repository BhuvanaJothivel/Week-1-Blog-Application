package com.prograd.blogapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.prograd.blogapp.model.Blog;

public interface BlogDao {

	void insertTodo(Blog todo) throws SQLException;

	Blog selectTodo(long todoId);

	List<Blog> selectAllTodos();

	boolean deleteTodo(int id) throws SQLException;

	boolean updateTodo(Blog todo) throws SQLException;

}