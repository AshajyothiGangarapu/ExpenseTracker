package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;
import com.alacriti.expensetrack.bo.impl.BaseBO;
import com.alacriti.expensetrack.bo.impl.BOException;
import com.alacriti.expensetrack.dao.impl.AccountInformationDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.AccountInformation;

public class AccountInformationBO extends BaseBO {
	public AccountInformationBO() {

	}

	public AccountInformationBO(Connection conn) {
		super(conn);
	}

	public void addAccountDetails(AccountInformation accountInfo)
			throws DAOException, BOException {
		try {
			AccountInformationDAO accountInfoDAO = new AccountInformationDAO(
					getConnection());
			accountInfoDAO.addAccountDetails(accountInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}

	public List<AccountInformation> getAccountInformations(String loginId)
			throws DAOException, BOException {
		List<AccountInformation> accountInfoList = null;
		try {
			AccountInformationDAO accountInfoDAO = new AccountInformationDAO(
					getConnection());
			accountInfoList = accountInfoDAO.getAccountInformation(loginId);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return accountInfoList;
	}
}
