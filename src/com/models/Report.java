package com.models;

import java.sql.Timestamp;
import java.util.Date;

public class Report {

	private int reportID;
	private String projectName;
	private String functions;
	private Timestamp actualTime;
	private Timestamp reportTime;
	private String tools;
	private String reportTo;
	private String technologies;

	public Report() {
		this.reportID = 0;
		this.projectName = "";
		this.functions = "";
		this.actualTime = new Timestamp(0);
		this.reportTime = new Timestamp(new Date().getTime());
		this.tools = "";
		this.reportTo = "";
		this.technologies = "";
	}

	public Report(int reportID, String projectName, String functions, Timestamp actualTime, String tools,
			String reportTo, String technologies) {
		this.reportID = reportID;
		this.projectName = projectName;
		this.functions = functions;
		this.actualTime = actualTime;
		this.reportTime = new Timestamp(new Date().getTime());
		this.tools = tools;
		this.reportTo = reportTo;
		this.technologies = technologies;
	}

	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}

	public Timestamp getActualTime() {
		return actualTime;
	}

	public void setActualTime(Timestamp actualTime) {
		this.actualTime = actualTime;
	}

	public Timestamp getReportTime() {
		return reportTime;
	}

	public void setReportTime(Timestamp reportTime) {
		this.reportTime = reportTime;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

}
