package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.bo.impl.TopSpendsBO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopSpendsDelegate extends BaseDelegate {
	private static final Logger log = Logger.getLogger(TopSpendsDelegate.class);

	public List<ExpenseInformation> getTopSpends(String loginId) {
		boolean rollBack = false;
		Connection connection = null;
		List<ExpenseInformation> expenseInfoList = null;
		log.debug("in TopSpendsDelegate");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TopSpendsBO topSpendsBO = new TopSpendsBO(getConnection());
			expenseInfoList = topSpendsBO.getTopSpends(loginId);
			System.out.println("Top spends delegate");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in TopSpendsDelegate");
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return expenseInfoList;

	}
}
