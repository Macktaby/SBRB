package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.Transaction;
import com.mysql.jdbc.Statement;

public class TransactionDAO {

	private Connection conn;

	public TransactionDAO() {
		conn = DBConnection.getActiveConnection();
	}

	private Transaction parseTransaction(ResultSet rs) throws SQLException {

		Transaction transaction = new Transaction();

		transaction.setTransactionID(rs.getInt("transaction_id"));
		transaction.setProjectOwnerID(rs.getInt("proj_owner_id"));
		transaction.setProjectOwnerName(rs.getString("proj_owner.name"));
		transaction.setPackageName(rs.getString("package"));
		transaction.setAction(rs.getString("action"));
		transaction.setStartDate(rs.getTimestamp("start_date"));

		return transaction;
	}

	public ArrayList<Transaction> getTransactions() {
		try {
			String sql = "SELECT * FROM transactions, proj_owner WHERE transactions.proj_owner_id = proj_owner.proj_owner_id";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			ArrayList<Transaction> transactions = new ArrayList<Transaction>();

			while (rs.next())
				transactions.add(parseTransaction(rs));

			return transactions;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Transaction> filterTransactionsByPO(int projOwnerID) {
		try {
			String sql = "SELECT * FROM transactions, proj_owner "
					+ "WHERE proj_owner_id = ? AND transactions.proj_owner_id = proj_owner.proj_owner_id";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, projOwnerID);

			ResultSet rs = stmt.executeQuery();

			ArrayList<Transaction> transactions = new ArrayList<Transaction>();

			while (rs.next())
				transactions.add(parseTransaction(rs));

			return transactions;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Transaction addTransaction(Transaction transaction) {

		try {
			String sql = "INSERT INTO `transactions` (`proj_owner_id`,`package`,`action`,`start_date`) VALUES (?,?,?,?);";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, transaction.getProjectOwnerID());
			stmt.setString(2, transaction.getPackageName());
			stmt.setString(3, transaction.getAction());
			stmt.setTimestamp(4, transaction.getStartDate());

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				transaction.setTransactionID(rs.getInt(1));
				return transaction;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
