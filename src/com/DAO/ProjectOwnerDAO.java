package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.ProjectOwner;
import com.mysql.jdbc.Statement;

public class ProjectOwnerDAO {

	private Connection conn;

	public ProjectOwnerDAO() {
		conn = DBConnection.getActiveConnection();
	}

	private ProjectOwner parseProjectOwner(ResultSet rs) throws SQLException {

		ProjectOwner po = new ProjectOwner();

		po.setName(rs.getString("name"));
		po.setProjectOwnerID(rs.getInt("proj_owner_id"));

		return po;
	}

	public ArrayList<ProjectOwner> getProjOwners() {
		try {
			String sql = "SELECT * FROM proj_owner";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			ArrayList<ProjectOwner> POs = new ArrayList<ProjectOwner>();

			while (rs.next())
				POs.add(parseProjectOwner(rs));

			return POs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ProjectOwner addProjOwner(ProjectOwner po) {

		try {
			String sql = "INSERT INTO `proj_owner` (`name`) VALUES ( ? );";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, po.getName());

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				po.setProjectOwnerID(rs.getInt(1));
				;
				return po;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
