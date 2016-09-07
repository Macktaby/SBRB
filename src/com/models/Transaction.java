package com.models;

import java.sql.Timestamp;

public class Transaction {

	private int transactionID;
	private int projectOwnerID;
	private String packageName;
	private String action;
	private Timestamp startDate;

	public Transaction() {
		this.transactionID = 0;
		this.projectOwnerID = 0;
		this.packageName = "";
		this.action = "";
		this.startDate = new Timestamp(0);
	}

	public Transaction(int transactionID, int projectOwnerID, String packageName, String action, Timestamp startDate) {
		this.transactionID = transactionID;
		this.projectOwnerID = projectOwnerID;
		this.packageName = packageName;
		this.action = action;
		this.startDate = startDate;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public int getProjectOwnerID() {
		return projectOwnerID;
	}

	public void setProjectOwnerID(int projectOwnerID) {
		this.projectOwnerID = projectOwnerID;
	}
}
