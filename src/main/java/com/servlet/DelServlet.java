package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.util.ConnectionFactory;

/**
 * Servlet implementation class DelServlet
 */
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelServlet() {
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
		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		System.out.println(request.getParameter("id"));
		int a = Integer.parseInt(request.getParameter("id").toString());

		String sql = "delete from film_actor where film_id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, a);
			preparedStatement.execute();
			sql = "delete from film_category where film_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, a);
			preparedStatement.execute();
			sql = "delete from rental where inventory_id in(select inventory_id from inventory where film_id=?)";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, a);
			preparedStatement.execute();
			sql = "delete from inventory where film_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, a);
			preparedStatement.execute();
			sql = "delete from film where film_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, a);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("INFO-->删除出错！");
		}

	}
}
