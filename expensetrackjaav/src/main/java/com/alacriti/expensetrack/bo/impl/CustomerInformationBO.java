package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;

import com.alacriti.expensetrack.dao.impl.CustomerInformationDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.CustomerInformation;

public class CustomerInformationBO extends BaseBO {
	public CustomerInformationBO() {

	}

	public CustomerInformationBO(Connection conn) {
		super(conn);
	}

	public void addCustomerDetails(CustomerInformation customerInfo)
			throws DAOException, BOException {

		try {
			CustomerInformationDAO customerInfoDAO = new CustomerInformationDAO(
					getConnection());
			customerInfoDAO.addCustomerDetails(customerInfo);
		} catch (Exception e) {
			e.printStackTrace();

			throw new BOException();
		}
	}

	public boolean getCustomerDefaults(CustomerInformation customerInfo)
			throws DAOException, BOException {
		boolean flag=false;

		try {
			CustomerInformationDAO customerInfoDAO = new CustomerInformationDAO(
					getConnection());
			flag=customerInfoDAO.getCustomerDetails(customerInfo);
		

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return flag;
	}

}
