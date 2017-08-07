package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.expensetrack.dao.impl.BaseDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.AccountInformation;

public class AccountInformationDAO extends BaseDAO {
	public AccountInformationDAO() {

	}

	public AccountInformationDAO(Connection conn) {
		super(conn);
	}

	public void addAccounts(AccountInformation accountInfo)
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sqlCmd";
			
			stmt =getPreparedStatementCreateUserRole(getConnection(), sqlCmd);
			stmt.setLong(1, accountInfo.getAccountNumber());
			stmt.setString(2, accountInfo.getNickName());
			 stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("SQLException in createUserRole():", e);
		} finally {
			close(stmt, rs);
		}
	}
	
	public PreparedStatement getPreparedStatementCreateUserRole(Connection connection, String sqlCmd) throws SQLException{
		try {
			return connection.prepareStatement("insert into ashajyothig_expensetracker_account_info (account_number,nick_name) values(?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}