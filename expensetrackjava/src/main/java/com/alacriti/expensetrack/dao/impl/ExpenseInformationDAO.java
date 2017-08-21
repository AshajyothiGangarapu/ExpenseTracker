package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.alacriti.expensetrack.dao.impl.BaseDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class ExpenseInformationDAO extends BaseDAO {
	public ExpenseInformationDAO() {

	}

	public ExpenseInformationDAO(Connection conn) {
		super(conn);
	}

	private static final Logger log = Logger
			.getLogger(ExpenseInformationDAO.class);

	public boolean addExpenses(ExpenseInformation expenseInfo) throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean flag=false;
		int updatedRows=0;
		try {
			String sqlCmd = "insert into ashajyothig_expensetracker_transaction_info "
					+ "(customer_id,account_id,category_name,description,amount,date)"
					+ "values((select customer_id from ashajyothig_expensetracker_customer_information where login_id=?),"
					+ "?,?,?,?,?)";

			stmt = getPreparedStatementExpenseAddition(getConnection(), sqlCmd);
			stmt.setString(1, expenseInfo.getLoginId());
			stmt.setInt(2, expenseInfo.getAccountId());
			stmt.setString(3, expenseInfo.getCategory());
			stmt.setString(4, expenseInfo.getDescription());
			stmt.setDouble(5, expenseInfo.getPrice());
			stmt.setString(6, expenseInfo.getDate());
			updatedRows=stmt.executeUpdate();
			if(updatedRows>0)
			{
				flag=true;
			}
			log.debug("in ExpenseInformationDAO.addExpenses");

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL EXception in ExpenseInformationDAO" + e.getMessage());
			throw new DAOException("SQLException in createUserRole():", e);
		} finally {
			close(stmt, rs);
		}
		return flag;
	}

	public PreparedStatement getPreparedStatementExpenseAddition(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Exception in getPreparedStatementExpenseAddition"
					+ e.getMessage());
			throw e;
		}
	}
}