package com.alacriti.expensetrack.bo.impl;
import java.sql.Connection;

import com.alacriti.expensetrack.dao.impl.TopSpendsDAO;
import com.alacriti.expensetrack.model.vo.CustomerInformation;




public class TopSpendsBO extends BaseBO {
	
	public TopSpendsBO(Connection connection) {
		super(connection);
	}
	public void getTopSpends(CustomerInformation customerInfo) throws DAOException, BOException{
		
		try {
			TopSpendsDAO topSpendsDAO =   new TopSpendsDAO(getConnection());
			topSpendsDAO.getTopSpends(customerInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}
	}
