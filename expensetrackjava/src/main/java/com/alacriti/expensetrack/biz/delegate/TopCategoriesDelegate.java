package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetrack.bo.impl.TopCategoriesBO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopCategoriesDelegate extends BaseDelegate {

	public List<ExpenseInformation> getTopCategories(String loginId) {
		boolean rollBack = false;
		Connection connection = null;
		List<ExpenseInformation> expenseInfoList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TopCategoriesBO topCategoriesBO = new TopCategoriesBO(
					getConnection());
			expenseInfoList = topCategoriesBO.getTopCategories(loginId);
			System.out.println("delegate");
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return expenseInfoList;

	}
}