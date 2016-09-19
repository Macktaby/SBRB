package com.controller;

import java.sql.Timestamp;

import com.DAO.ReportDAO;
import com.models.Report;

public class DeveloperController {

	public int addReport(String projectName, String functions, Timestamp actualTime, Timestamp reportTime, String tools,
			String reportTo, String technologies) {

		Report report = new Report(0, projectName, functions, actualTime, tools, reportTo, technologies);

		ReportDAO reportDAO = new ReportDAO();
		report = reportDAO.addReport(report);

		return report.getReportID();
	}

}
