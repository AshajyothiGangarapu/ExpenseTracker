package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetrack.dao.impl.TopCategoriesDAO;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;




public class TopCategoriesBO extends BaseBO {
	
	public TopCategoriesBO(Connection connection) {
		super(connection);
	}
	public List<ExpenseInformation> getTopCategories(String loginId) throws DAOException, BOException{
		List<ExpenseInformation> expenseInfoList = null;
		try {
			TopCategoriesDAO topCategoriesDAO =   new TopCategoriesDAO(getConnection());
			expenseInfoList = topCategoriesDAO.getTopCategories(loginId);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return expenseInfoList;
	}
	}