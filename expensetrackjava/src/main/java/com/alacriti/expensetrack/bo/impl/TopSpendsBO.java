package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.dao.impl.TopSpendsDAO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;

public class TopSpendsBO extends BaseBO {

	public TopSpendsBO(Connection connection) {
		super(connection);
	}

	private static final Logger log = Logger.getLogger(TopSpendsBO.class);

	public List<ExpenseInformation> getTopSpends(String loginId)
			throws DAOException, BOException {
		List<ExpenseInformation> expenseInfoList = null;
		log.debug("in TopSpendsBO");
		try {
			TopSpendsDAO topSpendsDAO = new TopSpendsDAO(getConnection());
			expenseInfoList = topSpendsDAO.getTopSpends(loginId);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in TopSpendsBO" + e.getMessage());
			throw new BOException();
		}
		return expenseInfoList;
	}
}
