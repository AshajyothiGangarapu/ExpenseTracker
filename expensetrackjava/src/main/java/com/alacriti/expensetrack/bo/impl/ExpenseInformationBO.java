package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.bo.impl.BaseBO;
import com.alacriti.expensetrack.bo.impl.BOException;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.dao.impl.ExpenseInformationDAO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class ExpenseInformationBO extends BaseBO {
	public ExpenseInformationBO() {

	}

	public ExpenseInformationBO(Connection conn) {
		super(conn);
	}

	private static final Logger log = Logger
			.getLogger(ExpenseInformationBO.class);

	public boolean addExpenses(ExpenseInformation expenseInfo)
			throws DAOException, BOException {
		boolean flag = false;
		log.debug("in ExpenseInformationBO");
		try {
			ExpenseInformationDAO customerInfoDAO = new ExpenseInformationDAO(
					getConnection());
			flag=customerInfoDAO.addExpenses(expenseInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in ExpenseInformationBO" + e.getMessage());
			throw new BOException();
		}
		return flag;
	}

}
