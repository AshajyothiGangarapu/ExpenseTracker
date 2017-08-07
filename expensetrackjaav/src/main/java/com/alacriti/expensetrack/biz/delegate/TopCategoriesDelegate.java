package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;

import com.alacriti.expensetrack.bo.impl.TopCategoriesBO;
import com.alacriti.expensetrack.model.vo.CustomerInformation;

public class TopCategoriesDelegate extends BaseDelegate {

	public void getTopCategories(CustomerInformation customerInfo) {
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TopCategoriesBO topCategoriesBO = new TopCategoriesBO(
					getConnection());
			topCategoriesBO.getTopCategories(customerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
}