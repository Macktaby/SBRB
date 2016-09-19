package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.Report;
import com.mysql.jdbc.Statement;

public class ReportDAO {

	private Connection conn;

	public ReportDAO() {
		conn = DBConnection.getActiveConnection();
	}

	private Report parseReport(ResultSet rs) throws SQLException {
		Report report = new Report();

		report.setReportID(rs.getInt("report_id"));
		report.setProjectName(rs.getString("proj_name"));
		report.setActualTime(rs.getTimestamp("actual_time"));
		report.setReportTime(rs.getTimestamp("report_time"));
		report.setFunctions(rs.getString("functions"));
		report.setReportTo(rs.getString("report_to"));
		report.setTechnologies(rs.getString("technology"));
		report.setTools(rs.getString("tools"));

		return report;
	}

	public ArrayList<Report> getReports() {
		try {
			String sql = "SELECT * FROM report";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			ArrayList<Report> reports = new ArrayList<Report>();

			while (rs.next())
				reports.add(parseReport(rs));

			return reports;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Report addReport(Report report) {

		try {
			String sql = "INSERT INTO `report`"
					+ "(`proj_name`, `functions`, `actual_time`, `report_time`, `tools`, `report_to`, `technology`) "
					+ "VALUES (?,?,?,?,?,?,?)";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, report.getProjectName());

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				report.setReportID(rs.getInt(1));
				return report;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
