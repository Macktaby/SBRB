package com.services;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.models.ProjectOwner;
import com.models.Transaction;

public class JSONBuilder {

	@SuppressWarnings("unchecked")
	public static JSONObject convertProjOwnersToJSON(ArrayList<ProjectOwner> projOwners) {

		JSONObject json = new JSONObject();

		if (projOwners == null) {
			json.put("state", "false");
		} else {

			JSONArray jsonArr = new JSONArray();
			for (ProjectOwner po : projOwners)
				jsonArr.add(convertProjOwnerToJSON(po));

			json.put("prodOwners", jsonArr);
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertProjOwnerToJSON(ProjectOwner po) {

		JSONObject json = new JSONObject();

		if (po == null)
			json.put("state", "false");
		else {
			json.put("id", po.getProjectOwnerID());
			json.put("name", po.getName());
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertTransactionsToJSON(ArrayList<Transaction> transactions) {
		JSONObject json = new JSONObject();

		if (transactions == null) {
			json.put("state", "false");
		} else {

			JSONArray jsonArr = new JSONArray();
			for (Transaction transaction : transactions)
				jsonArr.add(convertTransactionToJSON(transaction));

			json.put("transactions", jsonArr);
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertTransactionToJSON(Transaction transaction) {

		JSONObject json = new JSONObject();

		if (transaction == null)
			json.put("state", "false");
		else {
			json.put("id", transaction.getTransactionID());
			json.put("projOwnerID", transaction.getProjectOwnerID());
			json.put("package", transaction.getPackageName());
			json.put("action", transaction.getAction());
			json.put("startDate", transaction.getStartDate().toString());
		}

		return json;
	}

	/************************ JSON Build Functions ************************/

}
