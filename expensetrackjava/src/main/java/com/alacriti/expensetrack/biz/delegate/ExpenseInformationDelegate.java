package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.bo.impl.ExpenseInformationBO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class ExpenseInformationDelegate extends BaseDelegate {
	private static final Logger log = Logger
			.getLogger(ExpenseInformationDelegate.class);

	public boolean addExpenses(ExpenseInformation expenseInfo) {

		boolean rollBack = false;
		Connection connection = null;
		boolean flag=false;
		
		log.debug("in ExpenseInformationDelegate");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ExpenseInformationBO expenseInformationBO = new ExpenseInformationBO(
					getConnection());
			flag=expenseInformationBO.addExpenses(expenseInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in ExpenseInformationDelegate"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return flag;

	}
}
