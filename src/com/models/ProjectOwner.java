package com.models;

public class ProjectOwner {

	private int projectOwnerID;
	private String name;

	public ProjectOwner() {
		this.projectOwnerID = 0;
		this.name = "";
	}

	public ProjectOwner(int projectOwnerID, String name) {
		this.projectOwnerID = projectOwnerID;
		this.name = name;
	}

	public int getProjectOwnerID() {
		return projectOwnerID;
	}

	public void setProjectOwnerID(int projectOwnerID) {
		this.projectOwnerID = projectOwnerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
