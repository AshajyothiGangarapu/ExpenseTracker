package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.bo.impl.AccountInformationBO;
import com.alacriti.expensetrack.model.vo.AccountInformation;

public class AccountInformationDelegate extends BaseDelegate {
	private static final Logger log = Logger
			.getLogger(AccountInformationDelegate.class);

	public boolean addAccountDetails(AccountInformation accountInfo) {
		boolean rollBack = false;
		Connection connection = null;
		boolean flag= false;
		log.debug("in AccountInformationDelegate.addAccountDetails");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			AccountInformationBO accountInfoBO = new AccountInformationBO(
					getConnection());
			flag=accountInfoBO.addAccountDetails(accountInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in in AccountInformationDelegate.addAccountDetails"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return flag;
	}

	public List<AccountInformation> getAccountInformation(String loginId) {
		boolean rollBack = false;
		Connection connection = null;
		List<AccountInformation> accountInfoList = null;
		log.debug("in AccountInformationDelegate.getAccountInformation");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			AccountInformationBO accountInfoBO = new AccountInformationBO(
					getConnection());
			accountInfoList = accountInfoBO.getAccountInformations(loginId);
			System.out.println("delegate");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in AccountInformationDelegate.getAccountInformation"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return accountInfoList;

	}

}
