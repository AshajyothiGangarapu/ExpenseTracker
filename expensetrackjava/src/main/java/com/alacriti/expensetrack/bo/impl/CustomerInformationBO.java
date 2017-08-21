package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.dao.impl.CustomerInformationDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.CustomerInformation;
import com.alacriti.expensetrack.model.vo.Validation;

public class CustomerInformationBO extends BaseBO {
	public CustomerInformationBO() {

	}

	public CustomerInformationBO(Connection conn) {
		super(conn);
	}

	private static final Logger log = Logger
			.getLogger(CustomerInformationBO.class);

	public boolean addCustomerDetails(CustomerInformation customerInfo)
			throws DAOException, BOException {
		boolean flag = false;
		log.debug("in CustomerInformationBO.addCustomerDetails");

		try {
			CustomerInformationDAO customerInfoDAO = new CustomerInformationDAO(
					getConnection());
			flag=customerInfoDAO.addCustomerDetails(customerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in CustomerInformationBO.addCustomerDetails"
					+ e.getMessage());
			throw new BOException();
		}
		return flag;
	}

	public Validation getCustomerDefaults(CustomerInformation customerInfo)
			throws DAOException, BOException {
		Validation validation = null;
		boolean flag = false;
		log.debug("in CustomerInformationBO.getCustomerDefaults");
		try {
			CustomerInformationDAO customerInfoDAO = new CustomerInformationDAO(
					getConnection());
			validation = customerInfoDAO.getCustomerDetails(customerInfo);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in CustomerInformationBO.getCustomerDefaults"
					+ e.getMessage());
			throw new BOException();
		}
		return validation;
	}

}
