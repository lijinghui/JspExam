package com.hand.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Dao.FilmDao;
import com.hand.entity.Film;

public class FilmDaoImp implements FilmDao {

	@Override
	public void save(Connection conn, Film film) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection conn, Film film) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection conn, Film film) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet get(Connection conn, Film film) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"SELECT a.film_id,a.title,a.description,b.name FROM film AS a ,language AS b  WHERE a.language_id = b.language_id; ");

		return ps.executeQuery();
	}

	public ResultSet show(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"SELECT a.film_id,a.title,a.description,b.name FROM film AS a ,language AS b  WHERE a.language_id = b.language_id; ");

		return ps.executeQuery();
	}

	public ResultSet getAllLan(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"SELECT name FROM language  ");

		return ps.executeQuery();
	}

}
