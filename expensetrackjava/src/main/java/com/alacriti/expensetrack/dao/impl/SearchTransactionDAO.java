package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.model.vo.SearchTransaction;

public class SearchTransactionDAO extends BaseDAO {

	public SearchTransactionDAO(Connection conn) {
		super(conn);
	}

	public SearchTransactionDAO() {

	}

	private static final Logger log = Logger
			.getLogger(SearchTransactionDAO.class);

	public List<SearchTransaction> getTransactionsOnAccountNumber(
			SearchTransaction searchTransc) throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<SearchTransaction> list = null;

		try {
			String sqlCmd = "select b.account_number,b.nick_name,category_name,description,amount,date "
					+ "from ashajyothig_expensetracker_transaction_info a"
					+ " inner join ashajyothig_expensetracker_account_info b on a.account_id=b.account_id "
					+ " and b.account_number like ?  and "
					+ " b.customer_id=(select customer_id from ashajyothig_expensetracker_customer_information"
					+ " where login_id=?)";

			stmt = getPreparedStatementGetSearchInfo(getConnection(), sqlCmd);
			stmt.setString(1, "%" + searchTransc.getSearchValue() + "%");
			stmt.setString(2, searchTransc.getLoginId());
			rs = stmt.executeQuery();
			list = new ArrayList<SearchTransaction>();
			while (rs.next()) {
				SearchTransaction searchTrans = new SearchTransaction();

				searchTrans.setAccountNumber(rs.getLong("account_number"));
				searchTrans.setNickName(rs.getString("nick_name"));
				searchTrans.setCategory(rs.getString("Category_name"));
				searchTrans.setDescription(rs.getString("description"));
				searchTrans.setAmount(rs.getDouble("amount"));
				searchTrans.setDate(rs.getString("date"));
				list.add(searchTrans);
				log.debug("in SearchTransactionDAO.getTransactionsOnAccountNumber");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in SearchTransactionDAO.getTransactionsOnAccountNumber"
					+ e.getMessage());
			throw new DAOException("SQLException in getUserRole():", e);
		} finally {
			close(stmt, rs);
		}
		return list;
	}

	public List<SearchTransaction> getTransactionsOnCategoryName(
			SearchTransaction searchTransc) throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<SearchTransaction> list = null;

		try {
			String sqlCmd = "select b.account_number,b.nick_name,category_name,description,amount,date "
					+ " from ashajyothig_expensetracker_transaction_info a"
					+ " inner join ashajyothig_expensetracker_account_info b on a.account_id=b.account_id "
					+ " and a.category_name like ?  and "
					+ " b.customer_id=(select customer_id from ashajyothig_expensetracker_customer_information"
					+ " where login_id=?)";

			stmt = getPreparedStatementGetSearchInfo(getConnection(), sqlCmd);
			stmt.setString(1, "%" + searchTransc.getSearchValue() + "%");
			stmt.setString(2, searchTransc.getLoginId());
			System.out.println(searchTransc.getSearchValue());
			rs = stmt.executeQuery();
			list = new ArrayList<SearchTransaction>();
			while (rs.next()) {
				SearchTransaction searchTrans = new SearchTransaction();

				searchTrans.setAccountNumber(rs.getLong("account_number"));
				searchTrans.setNickName(rs.getString("nick_name"));
				searchTrans.setCategory(rs.getString("Category_name"));
				searchTrans.setDescription(rs.getString("description"));
				searchTrans.setAmount(rs.getDouble("amount"));
				searchTrans.setDate(rs.getString("date"));
				list.add(searchTrans);
				log.debug("in SearchTransactionDAO.getTransactionsOnCategoryName");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in SearchTransactionDAO.getTransactionsOnCategoryName"
					+ e.getMessage());
			throw new DAOException("SQLException in getUserRole():", e);
		} finally {
			close(stmt, rs);
		}
		return list;
	}

	public List<SearchTransaction> getTransactionsOnDate(
			SearchTransaction searchTransc) throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<SearchTransaction> list = null;

		try {
			String sqlCmd = "select b.account_number,b.nick_name,category_name,description,amount,date "
					+ "from ashajyothig_expensetracker_transaction_info a"
					+ " inner join ashajyothig_expensetracker_account_info b on "
					+ "a.account_id=b.account_id and a.date >= ? and a.date <= ?"
					+ "  and b.customer_id=(select customer_id from ashajyothig_expensetracker_customer_information "
					+ " where login_id=?) order by date ";

			stmt = getPreparedStatementGetSearchInfo(getConnection(), sqlCmd);
			stmt.setDate(1, searchTransc.getFromDate());
			stmt.setDate(2, searchTransc.getToDate());
			stmt.setString(3, searchTransc.getLoginId());
			rs = stmt.executeQuery();
			list = new ArrayList<SearchTransaction>();
			while (rs.next()) {
				SearchTransaction searchTrans = new SearchTransaction();

				searchTrans.setAccountNumber(rs.getLong("account_number"));
				searchTrans.setNickName(rs.getString("nick_name"));
				searchTrans.setCategory(rs.getString("Category_name"));
				searchTrans.setDescription(rs.getString("description"));
				searchTrans.setAmount(rs.getDouble("amount"));
				searchTrans.setDate(rs.getString("date"));
				list.add(searchTrans);
				log.debug("in SearchTransactionDAO.getTransactionsOnDate");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in SearchTransactionDAO.getTransactionsOnDate"
					+ e.getMessage());
			throw new DAOException("SQLException in getUserRole():", e);
		} finally {
			close(stmt, rs);
		}
		return list;

	}

	public PreparedStatement getPreparedStatementGetSearchInfo(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Exception in getPreparedStatementGetSearchInfo"
					+ e.getMessage());
			throw e;
		}
	}
}
