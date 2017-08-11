package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;
import com.alacriti.expensetrack.bo.impl.TopSpendsBO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopSpendsDelegate extends BaseDelegate {

	public List<ExpenseInformation> getTopSpends(String loginId) {
		boolean rollBack = false;
		Connection connection = null;
		List<ExpenseInformation> expenseInfoList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TopSpendsBO topSpendsBO = new TopSpendsBO(
					getConnection());
			expenseInfoList = topSpendsBO.getTopSpends(loginId);
			System.out.println("Top spends delegate");
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return expenseInfoList;


	}
}






