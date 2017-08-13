package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.expensetrack.model.vo.CustomerInformation;
import com.alacriti.expensetrack.model.vo.Validation;

public class CustomerInformationDAO extends BaseDAO {
	public CustomerInformationDAO() {

	}

	public CustomerInformationDAO(Connection conn) {
		super(conn);
	}

	public void addCustomerDetails(CustomerInformation customerInfo)
			throws DAOException {
		// log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sqlCmd";

			stmt = getPreparedStatementCreateUserRole(getConnection(), sqlCmd);
			stmt.setString(1, customerInfo.getFirstName());
			stmt.setString(2, customerInfo.getLastName());
			stmt.setString(3, customerInfo.getEmailId());
			stmt.setDate(4, customerInfo.getDateOfBirth());
			stmt.setString(5, customerInfo.getLoginId());
			stmt.setString(6, customerInfo.getPassword());
			// log.logDebug("reached here********");
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("SQLException in createUserRole():", e);
		} finally {
			close(stmt, rs);
		}
	}

	public Validation getCustomerDetails(CustomerInformation customerInfo)
			throws DAOException {
		Statement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		Validation validation=null;

		try {
			String loginId = customerInfo.getLoginId();
			String password = customerInfo.getPassword();
			String sqlCmd ="select  password from ashajyothig_expensetracker_customer_information where login_id='"+loginId+"'";
			stmt = getPreparedStatementGetUserRole(getConnection(),sqlCmd);
			rs = stmt.executeQuery(sqlCmd);
			//validation=new Validation();
			if (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					System.out.println("Successfully Logged in***" +loginId);
					flag = true;
					validation=new Validation(true, loginId);
				} else {
					validation=new Validation(false, loginId);
					System.out.println("Invalid Password");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return validation;
	}

	public Statement getPreparedStatementGetUserRole(Connection connection,
			String sqlCmd) throws SQLException {

		try {

			return connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public PreparedStatement getPreparedStatementCreateUserRole(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("insert into ashajyothig_expensetracker_customer_information (first_name,last_name,email_id,date_of_birth,login_id,password) values(?,?,?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

}