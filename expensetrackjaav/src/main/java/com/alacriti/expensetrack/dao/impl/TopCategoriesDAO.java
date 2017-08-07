package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.expensetrack.model.vo.CustomerInformation;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopCategoriesDAO extends BaseDAO {
	public TopCategoriesDAO(Connection conn) {
		super(conn);
	}

	public TopCategoriesDAO() {

	}

	public List<ExpenseInformation> getTopCategories(
			CustomerInformation customerInfo) throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ExpenseInformation> list = null;

		try {
			String sqlCmd = "Select category_name, (sum(amount)* 100 / (Select sum(amount) From ashajyothig_expensetracker_transaction_info  where customer_id=(select customer_id from ashajyothig_expensetracker_customer_information where login_id=?))) as spend_ratio From ashajyothig_expensetracker_transaction_info  where customer_id=(select customer_id from ashajyothig_expensetracker_customer_information where login_id=?)Group By  category_name order by spend_ratio desc;";

			stmt = getPreparedStatementTopCategories(getConnection(), sqlCmd);
			stmt.setString(1, customerInfo.getLoginId());
			stmt.setString(2, customerInfo.getLoginId());
			rs = stmt.executeQuery();
			list = new ArrayList<ExpenseInformation>();
			while (rs.next()) {
				ExpenseInformation expenseInfo = new ExpenseInformation();
				expenseInfo.setCategory(rs.getString(1));
				expenseInfo.setPrice(rs.getInt(1));

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
