package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.User;
import com.hand.service.CheckUserService;

/**
 * Servlet implementation class LoginServelet
 */
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CheckUserService cs = new CheckUserService();
	User user = new User();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		user.setName(userName);
		boolean b = false;
		try {

			b = cs.check(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (b) {

			RequestDispatcher rd = request.getRequestDispatcher("film.jsp");
			rd.forward(request, response);
			request.setAttribute("isLogin", "yes");
			// 重定向是不会传递接getParameter来的值
			// resp.sendRedirect(req.getContextPath()+"/servlets/success.jsp");
		} else {
			// resp.sendRedirect(req.getContextPath()+"/servlets/error.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			request.setAttribute("isLogin", "no");

		}
	}

}
