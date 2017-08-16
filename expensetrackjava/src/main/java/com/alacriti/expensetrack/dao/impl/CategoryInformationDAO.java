package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.expensetrack.model.vo.CategoryVo;

public class CategoryInformationDAO extends BaseDAO{
	public CategoryInformationDAO() {

	}

	public CategoryInformationDAO(Connection conn) {
		super(conn);
	}
	public List<CategoryVo> getCategoryInformation()
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CategoryVo> list = null;
		try {
			String sqlCmd = "select category_id,category_name "
					+ " from ashajyothig_expensetracker_category_information";
			stmt = getPreparedStatementGetCategoryInfo(getConnection(), sqlCmd);
			rs = stmt.executeQuery();
			list = new ArrayList<CategoryVo>();
			while (rs.next()) {
				CategoryVo categoryInfo = new CategoryVo();
				categoryInfo.setCategoryId(rs.getInt("category_id"));
				categoryInfo.setCategoryName(rs.getString("category_name"));
				list.add(categoryInfo);

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

	public PreparedStatement getPreparedStatementGetCategoryInfo(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}


}
