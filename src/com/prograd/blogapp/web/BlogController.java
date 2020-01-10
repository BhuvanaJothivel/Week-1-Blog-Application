package com.prograd.blogapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prograd.blogapp.dao.BlogDao;
import com.prograd.blogapp.dao.BlogDaoImpl;
import com.prograd.blogapp.model.Blog;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 * 
 * 
 */

@WebServlet("/")
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao blogDAO;

	public void init() {
		blogDAO = new BlogDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBlog(request, response);
				break;
			case "/delete":
				deleteBlog(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBlog(request, response);
				break;
			case "/list":
				listBlog(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBlog(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Blog> listTodo = blogDAO.selectAllBlogs();
		request.setAttribute("listBlog", listTodo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blog/blog-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("blog/blog-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Blog existingTodo = blogDAO.selectBlog(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blog/blog-form.jsp");
		request.setAttribute("todo", existingTodo);
		dispatcher.forward(request, response);

	}

	private void insertBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String description = request.getParameter("description");
		
		/*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);*/
		
		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		Blog newTodo = new Blog(title, username, description, LocalDate.now(), isDone);
		blogDAO.insertBlog(newTodo);
		response.sendRedirect("list");
	}

	private void updateBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String description = request.getParameter("description");
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
		
		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		Blog updateTodo = new Blog(id, title, username, description, targetDate, isDone);
		
		blogDAO.updateBlog(updateTodo);
		
		response.sendRedirect("list");
	}

	private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		blogDAO.deleteBlog(id);
		response.sendRedirect("list");
	}
}
