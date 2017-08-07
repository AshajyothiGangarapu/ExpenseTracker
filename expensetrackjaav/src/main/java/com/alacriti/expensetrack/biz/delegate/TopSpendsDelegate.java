package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;

import com.alacriti.expensetrack.bo.impl.TopSpendsBO;
import com.alacriti.expensetrack.model.vo.CustomerInformation;

public class TopSpendsDelegate extends BaseDelegate {

	public void getTopSpends(CustomerInformation customerInfo) {
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TopSpendsBO topSpendsBO = new TopSpendsBO(
					getConnection());
			topSpendsBO.getTopSpends(customerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
}