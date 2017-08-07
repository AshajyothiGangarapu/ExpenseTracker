package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;

import com.alacriti.expensetrack.bo.impl.BaseBO;
import com.alacriti.expensetrack.bo.impl.BOException;
import com.alacriti.expensetrack.dao.impl.AccountInformationDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.AccountInformation;


public class AccountInformationBo extends BaseBO {
	public AccountInformationBo() {

	}

	public AccountInformationBo(Connection conn) {
		super(conn);
	}
	public void addExpenses(AccountInformation accountInfo) throws DAOException, BOException{
		try {
			AccountInformationDAO accountInfoDAO =   new AccountInformationDAO(getConnection());
			accountInfoDAO.addAccounts(accountInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}

}