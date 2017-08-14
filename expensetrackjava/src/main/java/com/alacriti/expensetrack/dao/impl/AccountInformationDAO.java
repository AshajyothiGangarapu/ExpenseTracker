package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.expensetrack.dao.impl.BaseDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.AccountInformation;
public class AccountInformationDAO extends BaseDAO {
	public AccountInformationDAO() {

	}

	public AccountInformationDAO(Connection conn) {
		super(conn);
	}

	public void addAccountDetails(AccountInformation accountInfo)
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "insert into ashajyothig_expensetracker_account_info "
					+ "(customer_id,account_number,nick_name)"
					+ " values((select customer_id from ashajyothig_expensetracker_customer_information "
					+ "where login_id=?),?,?);";

			stmt = getPreparedStatementCreateAccount(getConnection(), sqlCmd);
			stmt.setString(1, accountInfo.getLoginId());
			stmt.setLong(2, accountInfo.getAccountNumber());
			stmt.setString(3, accountInfo.getNickName());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("SQLException in createUserRole():", e);
		} finally {
			close(stmt, rs);
		}
	}

	public PreparedStatement getPreparedStatementCreateAccount(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<AccountInformation> getAccountInformation(String loginId)
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AccountInformation> list = null;
		try {
			String sqlCmd = "select account_id,account_number,nick_name "
					+ "from ashajyothig_expensetracker_account_info a,"
					+ " ashajyothig_expensetracker_customer_information b where"
					+ " a.customer_id=b.customer_id and b.login_id=?";
			stmt = getPreparedStatementGetAccountInfo(getConnection(), sqlCmd);
			stmt.setString(1, loginId);
			rs = stmt.executeQuery();
			list = new ArrayList<AccountInformation>();
			while (rs.next()) {
				AccountInformation accountInfo = new AccountInformation();
				accountInfo.setAccountId(rs.getInt("account_id"));
				accountInfo.setAccountNumber(rs.getLong("account_number"));
				accountInfo.setNickName(rs.getString("nick_name"));
				list.add(accountInfo);

			}

		} catch (SQLException e) {
			e.printStackTrace();

			throw new DAOException("SQLException in getAccountInformation():",
					e);
		} finally {
			close(stmt, rs);
		}
		return list;
	}

	public PreparedStatement getPreparedStatementGetAccountInfo(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
