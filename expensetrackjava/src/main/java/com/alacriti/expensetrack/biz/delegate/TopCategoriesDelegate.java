package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.bo.impl.TopCategoriesBO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopCategoriesDelegate extends BaseDelegate {
	private static final Logger log = Logger
			.getLogger(TopCategoriesDelegate.class);

	public List<ExpenseInformation> getTopCategories(String loginId) {
		boolean rollBack = false;
		Connection connection = null;
		List<ExpenseInformation> expenseInfoList = null;
		log.debug("in TopCategoriesDelegate");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TopCategoriesBO topCategoriesBO = new TopCategoriesBO(
					getConnection());
			expenseInfoList = topCategoriesBO.getTopCategories(loginId);
			System.out.println("delegate");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in TopCategoriesDelegate" + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return expenseInfoList;

	}
}