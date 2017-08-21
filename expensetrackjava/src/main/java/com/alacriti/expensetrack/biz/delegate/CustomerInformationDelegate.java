package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.bo.impl.CustomerInformationBO;
import com.alacriti.expensetrack.model.vo.CustomerInformation;
import com.alacriti.expensetrack.model.vo.Validation;

public class CustomerInformationDelegate extends BaseDelegate {
	private static final Logger log = Logger
			.getLogger(CustomerInformationDelegate.class);

	public boolean addCustomerDetails(CustomerInformation customerInfo) {
		boolean rollBack = false;
		Connection connection = null;
		boolean flag = false;
		log.debug("in CustomerInformationDelegate.addCustomerDetails");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			CustomerInformationBO customerInformationBo = new CustomerInformationBO(
					getConnection());
			flag= customerInformationBo.addCustomerDetails(customerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in in CustomerInformationDelegate.addCustomerDetails"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return flag;

	}

	public Validation getCustomerDetails(CustomerInformation customerInfo) {
		boolean rollBack = false;
		boolean flag = false;
		Validation validation = null;
		Connection connection = null;
		log.debug("in CustomerInformationDelegate.getCustomerDetails");
		try {
			connection = startDBTransaction();
			System.out.println("in delegate");
			setConnection(connection);
			System.out.println("Stil in delegete");
			CustomerInformationBO customerInfoBO = new CustomerInformationBO(
					getConnection());
			System.out.println("still in delegate 2");
			validation = customerInfoBO.getCustomerDefaults(customerInfo);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in CustomerInformationDelegate.getCustomerDetails"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);

		}
		return validation;

	}
}
