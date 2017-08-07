package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;

import com.alacriti.expensetrack.dao.impl.TopCategoriesDAO;
import com.alacriti.expensetrack.model.vo.CustomerInformation;




public class TopCategoriesBO extends BaseBO {
	
	public TopCategoriesBO(Connection connection) {
		super(connection);
	}
	public void getTopCategories(CustomerInformation customerInfo) throws DAOException, BOException{
		
		try {
			TopCategoriesDAO topCategoriesDAO =   new TopCategoriesDAO(getConnection());
			topCategoriesDAO.getTopCategories(customerInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}
	}