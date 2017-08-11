package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.expensetrack.dao.impl.BaseDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class ExpenseInformationDAO extends BaseDAO {
	public ExpenseInformationDAO() {

	}

	public ExpenseInformationDAO(Connection conn) {
		super(conn);
	}

	public void addExpenses(ExpenseInformation expenseInfo)
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sqlCmd = "insert into ashajyothig_expensetracker_transaction_info "
					+ "(customer_id,account_id,category_name,description,amount,date)"
					+ "values((select customer_id from ashajyothig_expensetracker_customer_information where login_id='al245'),"
					+ "?,?,?,?,?)";
			
			stmt =getPreparedStatementExpenseAddition(getConnection(), sqlCmd);
			stmt.setInt(1, expenseInfo.getAccountId());
			stmt.setString(2, expenseInfo.getCategory());
			stmt.setString(3, expenseInfo.getDescription());
			stmt.setDouble(4,expenseInfo.getPrice());
			stmt.setString(5, expenseInfo.getDate());
			 stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("SQLException in createUserRole():", e);
		} finally {
			close(stmt, rs);
		}
	}
	
	public PreparedStatement getPreparedStatementExpenseAddition(Connection connection, String sqlCmd) throws SQLException{
		try {
			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}