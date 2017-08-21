package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopCategoriesDAO extends BaseDAO {
	public TopCategoriesDAO(Connection conn) {
		super(conn);
	}

	public TopCategoriesDAO() {

	}

	private static final Logger log = Logger.getLogger(TopCategoriesDAO.class);

	public List<ExpenseInformation> getTopCategories(String loginId)
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ExpenseInformation> list = null;

		try {
			String sqlCmd = "Select category_name, (sum(amount)* 100 / (Select sum(amount) From "
					+ "ashajyothig_expensetracker_transaction_info  where customer_id=(select customer_id from"
					+ " ashajyothig_expensetracker_customer_information where login_id=?))) as spend_ratio From"
					+ " ashajyothig_expensetracker_transaction_info  where customer_id=(select customer_id from"
					+ " ashajyothig_expensetracker_customer_information where login_id=?)Group By  category_name order by"
					+ " spend_ratio desc";

			stmt = getPreparedStatementGetTopCategories(getConnection(), sqlCmd);
			stmt.setString(1, loginId);
			stmt.setString(2, loginId);
			rs = stmt.executeQuery();
			list = new ArrayList<ExpenseInformation>();
			while (rs.next()) {

				ExpenseInformation expenseInfo = new ExpenseInformation();
				expenseInfo.setCategory(rs.getString("category_name"));
				expenseInfo.setPrice(rs.getDouble("spend_ratio"));
				list.add(expenseInfo);
				log.debug("in TopCategoriesDAO");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in TopCategoriesDAO" + e.getMessage());
			throw new DAOException("SQLException in getUserRole():", e);
		} finally {
			close(stmt, rs);
		}
		return list;
	}

	public PreparedStatement getPreparedStatementGetTopCategories(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Exception in getPreparedStatementGetTopCategories"
					+ e.getMessage());
			throw e;
		}
	}
}
