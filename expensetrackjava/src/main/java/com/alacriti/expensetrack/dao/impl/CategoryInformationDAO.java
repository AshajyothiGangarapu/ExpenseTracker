package com.alacriti.expensetrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.model.vo.CategoryVo;

public class CategoryInformationDAO extends BaseDAO{
	public CategoryInformationDAO() {

	}

	public CategoryInformationDAO(Connection conn) {
		super(conn);
	}
	 private static final Logger log = Logger.getLogger(CategoryInformationDAO.class);
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
			log.debug("in CategoryInformationDAO");
			while (rs.next()) {
				CategoryVo categoryInfo = new CategoryVo();
				categoryInfo.setCategoryId(rs.getInt("category_id"));
				categoryInfo.setCategoryName(rs.getString("category_name"));
				list.add(categoryInfo);
				log.debug(categoryInfo.getCategoryName());

			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Exception in CategoryInformationDAO" + e.getMessage() );
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
			log.error("Exception in getPreparedStatementGetCategoryInfo"+ e.getMessage());
			throw e;
		}
	}


}
