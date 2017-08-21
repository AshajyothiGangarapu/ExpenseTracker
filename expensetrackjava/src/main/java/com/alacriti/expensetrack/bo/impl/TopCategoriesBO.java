package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.dao.impl.TopCategoriesDAO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopCategoriesBO extends BaseBO {

	public TopCategoriesBO(Connection connection) {
		super(connection);
	}

	private static final Logger log = Logger.getLogger(TopCategoriesBO.class);

	public List<ExpenseInformation> getTopCategories(String loginId)
			throws DAOException, BOException {
		List<ExpenseInformation> expenseInfoList = null;
		log.debug("in TopCategoriesBO");
		try {
			TopCategoriesDAO topCategoriesDAO = new TopCategoriesDAO(
					getConnection());
			expenseInfoList = topCategoriesDAO.getTopCategories(loginId);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in TopCategoriesBO" + e.getMessage());
			throw new BOException();
		}
		return expenseInfoList;
	}
}