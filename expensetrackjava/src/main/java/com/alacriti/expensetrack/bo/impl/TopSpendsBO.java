package com.alacriti.expensetrack.bo.impl;
import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetrack.dao.impl.TopSpendsDAO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;




public class TopSpendsBO extends BaseBO {
	
	public TopSpendsBO(Connection connection) {
		super(connection);
	}
	public List<ExpenseInformation> getTopSpends(String loginId) throws DAOException, BOException{
		 List<ExpenseInformation> expenseInfoList = null;
		try {
			TopSpendsDAO topSpendsDAO =   new TopSpendsDAO(getConnection());
			expenseInfoList = topSpendsDAO.getTopSpends(loginId);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}return expenseInfoList;
	}
	}
