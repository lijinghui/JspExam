package com.hand.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Dao.UserDao;
import com.hand.entity.User;

public class UserDaoImp implements UserDao {

	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO tab_user(name,password,email) VALUES(?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getpassword());
		ps.setString(3, user.getEmail());
		ps.execute();
		System.out.println(ps.toString());
	}

	public void update(Connection conn, User user) throws SQLException {
		String upSql = "UPDATE tab_user SET name = ?,password=?,email=?WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(upSql);

		ps.setString(1, user.getName());
		ps.setString(2, user.getpassword());
		ps.setString(3, user.getEmail());
		ps.setLong(4, user.getId());
		ps.execute();
	}

	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM tab_user WHERE id = ?");
		ps.setLong(1, user.getId());
		ps.execute();
	}

	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE first_name = ?");
		ps.setString(1, user.getName());
		
		return ps.executeQuery();
	}
	
	public ResultSet show(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM address;");
		
		return ps.executeQuery();
	}

}
