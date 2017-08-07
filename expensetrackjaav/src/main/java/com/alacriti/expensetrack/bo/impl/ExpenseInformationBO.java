package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;

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
	public boolean addExpenses(ExpenseInformation expenseInfo) throws DAOException, BOException{
		boolean flag=false;
		try {
			ExpenseInformationDAO customerInfoDAO =   new ExpenseInformationDAO(getConnection());
			customerInfoDAO.addExpenses(expenseInfo);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return flag;
	}

}
