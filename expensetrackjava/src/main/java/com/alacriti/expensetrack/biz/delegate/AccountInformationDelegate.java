package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetrack.bo.impl.AccountInformationBO;
import com.alacriti.expensetrack.model.vo.AccountInformation;

public class AccountInformationDelegate extends BaseDelegate {
	public void addAccountDetails(AccountInformation accountInfo) {
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			AccountInformationBO accountInfoBO = new AccountInformationBO(
					getConnection());
			accountInfoBO.addAccountDetails(accountInfo);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}

	public List<AccountInformation> getAccountInformation(String loginId) {
		boolean rollBack = false;
		Connection connection = null;
		List<AccountInformation> accountInfoList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			AccountInformationBO accountInfoBO = new AccountInformationBO(
					getConnection());
			accountInfoList = accountInfoBO.getAccountInformations(loginId);
			System.out.println("delegate");
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return accountInfoList;

	}

}
