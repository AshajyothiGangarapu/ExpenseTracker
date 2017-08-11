package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopSpendsDAO extends BaseDAO {
	public TopSpendsDAO(Connection conn) {
		super(conn);
	}

	public TopSpendsDAO() {

	}

	public List<ExpenseInformation> getTopSpends(String loginId) throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ExpenseInformation> list = null;

		try {
			String sqlCmd = "Select category_name, amount  as spend_amount   From ashajyothig_expensetracker_transaction_info  where customer_id=(select customer_id from ashajyothig_expensetracker_customer_information where login_id=?) order by spend_amount desc";
			stmt = getPreparedStatementTopSpends(getConnection(), sqlCmd);
			stmt.setString(1, loginId);
			
			rs = stmt.executeQuery();
			list = new ArrayList<ExpenseInformation>();
			while (rs.next()) {

				ExpenseInformation expenseInfo = new ExpenseInformation();
				expenseInfo.setCategory(rs.getString("category_name"));
				expenseInfo.setPrice(rs.getDouble("spend_amount"));
				list.add(expenseInfo);

			}
		} catch (SQLException e) {
			e.printStackTrace();

			throw new DAOException("SQLException in getUserRole():", e);
		} finally {
			close(stmt, rs);
		}
		return list;
	}

	public PreparedStatement getPreparedStatementTopSpends(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
