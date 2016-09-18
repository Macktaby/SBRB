package com.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;

import com.models.ProjectOwner;
import com.models.Transaction;

@Path("/")
@Produces("text/html")
public class ViewController {

	@GET
	@Path("/signup")
	@Produces("text/html")
	public Response signUp() {
		try {
			return Response.ok(new Viewable("/WEB-INF/jsp/signup")).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/home")
	@Produces("text/html")
	public Response home() {
		try {
			UserServices us = new UserServices();
			us.getProjectOwners();
			return Response.ok(new Viewable("/WEB-INF/jsp/home")).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/AllTransactions")
	@Produces("text/html")
	public Response allTransactions() {
		try {
			UserServices us = new UserServices();
			ArrayList<Transaction> transactions = us.getTransactions();

			return Response.ok(new Viewable("/WEB-INF/jsp/AllTransactions", transactions)).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Path("/FilterTransactions")
	@Produces("text/html")
	public Response filterTransactions(@FormParam("filterSelect") int projOwnerID) {
		try {
			UserServices us = new UserServices();
			ArrayList<Transaction> transactions = us.filterTransactionsByPO(projOwnerID);

			return Response.ok(new Viewable("/WEB-INF/jsp/FilterTransactions", transactions)).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Path("/AddTransaction")
	@Produces("text/html")
	public Response AddTransaction(@FormParam("addTransSelect") int projOwnerID,
			@FormParam("package") String packageName, @FormParam("action") String action,
			@FormParam("time") String time) {
		try {
			UserServices us = new UserServices();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/DD HH:mm");
			Date parsedDate = dateFormat.parse(time);
			Timestamp timestamp = new Timestamp(parsedDate.getTime());
			Transaction transaction = us.addTransaction(projOwnerID, packageName, action, timestamp);

			if (transaction != null)
				return Response.ok("Transaction added SUCCSEFULLY").build();
			else
				return Response.ok("Error in adding Transaction").build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(e.toString()).build();
		}
	}

	@GET
	@Path("/AllProjectOwners")
	@Produces("text/html")
	public Response allProjectOwners() {
		try {
			UserServices us = new UserServices();
			ArrayList<ProjectOwner> projectOwners = us.getProjectOwners();

			return Response.ok(new Viewable("/WEB-INF/jsp/GetProjectOwners", projectOwners)).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Path("/AddProjectOwner")
	@Produces("text/html")
	public Response addProjectOwner(@FormParam("poName") String projOwnerName) {
		try {
			UserServices us = new UserServices();
			ProjectOwner po = us.addProjectOwner(projOwnerName);
			if (po != null)
				return Response.ok("Project Owner added SUCCSEFULLY").build();
			else
				return Response.ok("Error in adding Project Owner").build();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/signupViewer")
	@Produces(MediaType.TEXT_PLAIN)
	public String getJson() {
		return "Hello From ViewController";
	}

}
