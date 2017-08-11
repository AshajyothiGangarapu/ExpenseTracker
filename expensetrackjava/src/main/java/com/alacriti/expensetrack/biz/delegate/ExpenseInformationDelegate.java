package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;

import com.alacriti.expensetrack.bo.impl.ExpenseInformationBO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class ExpenseInformationDelegate extends BaseDelegate {
	public void addExpenses(ExpenseInformation expenseInfo) {

		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ExpenseInformationBO expenseInformationBO = new ExpenseInformationBO(
					getConnection());
			expenseInformationBO.addExpenses(expenseInfo);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
}
