package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.alacriti.expensetrack.model.vo.SearchTransaction;

public class SearchTransactionDAO extends BaseDAO {

	public SearchTransactionDAO(Connection conn) {
		super(conn);
	}

	public SearchTransactionDAO() {

	}

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
					+ " where login_id='al245')";

			stmt = getPreparedStatementTopCategories(getConnection(), sqlCmd);
			stmt.setString(1, "%" + searchTransc.getSearchValue() + "%");
			rs = stmt.executeQuery();
			list = new ArrayList<SearchTransaction>();
			while (rs.next()) {

				searchTransc.setAccountNumber(rs.getLong("account_number"));
				searchTransc.setNickName(rs.getString("nick_name"));
				searchTransc.setCategory(rs.getString("Category_name"));
				searchTransc.setDescription(rs.getString("description"));
				searchTransc.setAmount(rs.getDouble("amount"));
				searchTransc.setDate(rs.getString("date"));
				list.add(searchTransc);

			}

		} catch (SQLException e) {
			e.printStackTrace();

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
					+ "from ashajyothig_expensetracker_transaction_info a"
					+ "inner join ashajyothig_expensetracker_account_info b on a.account_id=b.account_id "
					+ "and a.category_name like ?  and "
					+ "b.customer_id=(select customer_id from ashajyothig_expensetracker_customer_information"
					+ "where login_id='al245')";

			stmt = getPreparedStatementTopCategories(getConnection(), sqlCmd);
			stmt.setString(1, "%" + searchTransc.getSearchValue() + "%");
			rs = stmt.executeQuery();
			list = new ArrayList<SearchTransaction>();
			while (rs.next()) {

				searchTransc.setAccountNumber(rs.getLong("account_number"));
				searchTransc.setNickName(rs.getString("nick_name"));
				searchTransc.setCategory(rs.getString("Category_name"));
				searchTransc.setDescription(rs.getString("description"));
				searchTransc.setAmount(rs.getDouble("amount"));
				searchTransc.setDate(rs.getString("date"));
				list.add(searchTransc);

			}

		} catch (SQLException e) {
			e.printStackTrace();

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
					+ " order by date and b.customer_id=(select customer_id from ashajyothig_expensetracker_customer_information "
					+ " where login_id='al245')";

			stmt = getPreparedStatementTopCategories(getConnection(), sqlCmd);
			stmt.setDate(1,searchTransc.getFromDate());
			stmt.setDate(2,searchTransc.getToDate());
			rs = stmt.executeQuery();
			list = new ArrayList<SearchTransaction>();
			while (rs.next()) {

				searchTransc.setAccountNumber(rs.getLong("account_number"));
				searchTransc.setNickName(rs.getString("nick_name"));
				searchTransc.setCategory(rs.getString("Category_name"));
				searchTransc.setDescription(rs.getString("description"));
				searchTransc.setAmount(rs.getDouble("amount"));
				searchTransc.setDate(rs.getString("date"));
				list.add(searchTransc);

			}

		} catch (SQLException e) {
			e.printStackTrace();

			throw new DAOException("SQLException in getUserRole():", e);
		} finally {
			close(stmt, rs);
		}
		return list;

	}

	public PreparedStatement getPreparedStatementTopCategories(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
