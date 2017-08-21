package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

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

	private static final Logger log = Logger
			.getLogger(AccountInformationBO.class);

	public boolean addAccountDetails(AccountInformation accountInfo)
			throws DAOException, BOException {
		boolean flag=false;
		log.debug("in AccountInformationBO.addAccountDetails ");
		try {
			AccountInformationDAO accountInfoDAO = new AccountInformationDAO(
					getConnection());
			flag=accountInfoDAO.addAccountDetails(accountInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in AccountInformationBO.addAccountDetails"
					+ e.getMessage());
			throw new BOException();
		}
		return flag;
	}

	public List<AccountInformation> getAccountInformations(String loginId)
			throws DAOException, BOException {
		List<AccountInformation> accountInfoList = null;
		log.debug("in AccountInformationBO.getAccountInformations");
		try {
			AccountInformationDAO accountInfoDAO = new AccountInformationDAO(
					getConnection());
			accountInfoList = accountInfoDAO.getAccountInformation(loginId);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in AccountInformationBO.getAccountInformations "
					+ e.getMessage());
			throw new BOException();
		}
		return accountInfoList;
	}
}
