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
import com.mysql.fabric.xmlrpc.base.Data;


public class UpdateServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		String upSql = "UPDATE film SET title = ?,description=?,language_id=? WHERE film_id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(upSql);
			ps.setString(1, request.getParameter("title"));
			ps.setString(2, request.getParameter("dis"));
			ps.setInt(3, getLan(request.getParameter("lan")));
			ps.setString(4,  request.getParameter("id"));
			System.out.println(ps.toString());
			System.out.println(request.getParameter("lan"));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("film.jsp");
		rd.forward(request, response);
		
	}
	
	public int getLan(String s) {
		switch (s) {
		case "English":
			return 1;
		case "Italian":
			return 2;
		case "Japanese":
			return 3;
		case "Mandarin":
			return 4;
		case "Greman":
			return 5;
		default : return 1;	
		}
		
	}

}
