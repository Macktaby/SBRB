package com.services;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.DAO.ProjectOwnerDAO;
import com.DAO.TransactionDAO;
import com.models.ProjectOwner;
import com.models.Transaction;

@Path("/")
public class UserServices {

	@POST
	@Path("/getTransactions")
	@Produces(MediaType.TEXT_PLAIN)
	public ArrayList<Transaction> getTransactions() {

		TransactionDAO transactionDAO = new TransactionDAO();
		ArrayList<Transaction> transactions = transactionDAO.getTransactions();

		return transactions;
		// return
		// JSONBuilder.convertTransactionsToJSON(transactions).toJSONString();
	}

	@POST
	@Path("/filterTransactionsByPO")
	@Produces(MediaType.TEXT_PLAIN)
	public ArrayList<Transaction> filterTransactionsByPO(@FormParam("projOwnerID") int projOwnerID) {

		TransactionDAO transactionDAO = new TransactionDAO();
		ArrayList<Transaction> transactions = transactionDAO.filterTransactionsByPO(projOwnerID);

		return transactions;
		// return
		// JSONBuilder.convertTransactionsToJSON(transactions).toJSONString();
	}

	@POST
	@Path("/addTransaction")
	@Produces(MediaType.TEXT_PLAIN)
	public Transaction addTransaction(@FormParam("projOwnerID") int projOwnerID,
			@FormParam("package") String packageName, @FormParam("action") String action,
			@FormParam("startTime") Timestamp startDate) {

		Transaction transaction = new Transaction(0, projOwnerID, "", packageName, action, startDate);

		TransactionDAO transactionDAO = new TransactionDAO();
		transaction = transactionDAO.addTransaction(transaction);

		return transaction;

		// return
		// JSONBuilder.convertTransactionToJSON(transaction).toJSONString();
	}

	/************************ Project Owner ************************/

	@POST
	@Path("/getProjectOwners")
	@Produces(MediaType.TEXT_PLAIN)
	public static ArrayList<ProjectOwner> getProjectOwners() {

		ProjectOwnerDAO projectOwnerDAO = new ProjectOwnerDAO();
		ArrayList<ProjectOwner> projOwners = projectOwnerDAO.getProjOwners();

		return projOwners;

		// return
		// JSONBuilder.convertProjOwnersToJSON(projOwners).toJSONString();
	}

	@POST
	@Path("/addProjectOwner")
	@Produces(MediaType.TEXT_PLAIN)
	public ProjectOwner addProjectOwner(@FormParam("name") String name) {

		ProjectOwner po = new ProjectOwner(0, name);
		ProjectOwnerDAO projectOwnerDAO = new ProjectOwnerDAO();
		po = projectOwnerDAO.addProjOwner(po);

		return po;

		// return JSONBuilder.convertProjOwnerToJSON(po).toJSONString();
	}

	/************************ For test ONLY ************************/

	@POST
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getJson() {
		return "Hello after editing";
		// Connection URL:
		// mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/
	}
}
