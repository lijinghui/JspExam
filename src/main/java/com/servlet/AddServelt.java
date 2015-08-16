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

import com.hand.entity.Film;
import com.hand.util.ConnectionFactory;
import com.mysql.fabric.xmlrpc.base.Data;

/**
 * Servlet implementation class AddServelt
 */
public class AddServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Film film = new Film();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServelt() {
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
		String upSql = "INSERT INTO film(title,description,language_id,rental_duration,rental_rate,replacement_cost,last_update) VALUES(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(upSql);
			ps.setString(1, request.getParameter("tit"));
			ps.setString(2, request.getParameter("dis"));
			ps.setString(3, getLan(request.getParameter("lan")));
			ps.setString(4, "1");
			ps.setString(5, "1");
			ps.setString(6, "1");
			ps.setString(7, new Data().toString());
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("film.jsp");
		rd.forward(request, response);

	}

	public String getLan(String s) {
		switch (s) {
		case "English":
			return "1";
		case "Italian":
			return "2";
		case "Japanese":
			return "3";
		case "Mandarin":
			return "4";
		case "Greman":
			return "5";
		}
		return "1";
	}
}
