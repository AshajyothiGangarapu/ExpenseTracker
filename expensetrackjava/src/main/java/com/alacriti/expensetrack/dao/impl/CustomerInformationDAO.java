package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.model.vo.CustomerInformation;
import com.alacriti.expensetrack.model.vo.Validation;

public class CustomerInformationDAO extends BaseDAO {
	public CustomerInformationDAO() {

	}

	public CustomerInformationDAO(Connection conn) {
		super(conn);
	}

	private static final Logger log = Logger
			.getLogger(CustomerInformationDAO.class);

	public boolean addCustomerDetails(CustomerInformation customerInfo)
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		int updatedRows =0;

		try {
			String sqlCmd = "sqlCmd";

			stmt = getPreparedStatementCreateCustomer(getConnection(), sqlCmd);
			stmt.setString(1, customerInfo.getFirstName());
			stmt.setString(2, customerInfo.getLastName());
			stmt.setString(3, customerInfo.getEmailId());
			stmt.setDate(4, customerInfo.getDateOfBirth());
			stmt.setString(5, customerInfo.getLoginId());
			stmt.setString(6, customerInfo.getPassword());
			log.debug("in CustomerInformationDAO");
			updatedRows=stmt.executeUpdate();
			if(updatedRows>0)
			{
				flag=true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in CustomerInformationDAO.addCustomerDetails"
					+ e.getMessage());
			throw new DAOException("SQLException in createUserRole():", e);
		} finally {
			close(stmt, rs);
		}
		return flag;
	}

	public Validation getCustomerDetails(CustomerInformation customerInfo)
			throws DAOException {
		Statement stmt = null;
		ResultSet rs = null;
		Validation validation = null;

		try {
			String loginId = customerInfo.getLoginId();
			String password = customerInfo.getPassword();
			String sqlCmd = "select  password,first_name from ashajyothig_expensetracker_customer_information where login_id='"
					+ loginId + "'";
			stmt = getPreparedStatementGetCustomer(getConnection(), sqlCmd);
			rs = stmt.executeQuery(sqlCmd);
			// validation=new Validation();
			if (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					//validation.setFirstName(rs.getString(2));
					validation = new Validation(true, loginId,rs.getString(2));
					System.out.println(rs.getString(2));
				} else {
					validation = new Validation(false, loginId,rs.getString(2));
					System.out.println("Invalid Password");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in CustomerInformationDAO.getCustomerDetails"
					+ e.getMessage());
		} finally {
			close(stmt);
		}
		return validation;
	}

	public Statement getPreparedStatementGetCustomer(Connection connection,
			String sqlCmd) throws SQLException {

		try {

			return connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Exception in getPreparedStatementGetCustomer"
					+ e.getMessage());
			throw e;
		}
	}

	public PreparedStatement getPreparedStatementCreateCustomer(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("insert into ashajyothig_expensetracker_customer_information (first_name,last_name,email_id,date_of_birth,login_id,password) values(?,?,?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Exception in getPreparedStatementCreateCustomer"
					+ e.getMessage());
			throw e;
		}
	}

}