package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;

import com.alacriti.expensetrack.bo.impl.CustomerInformationBO;
import com.alacriti.expensetrack.model.vo.CustomerInformation;
import com.alacriti.expensetrack.model.vo.Validation;

public class CustomerInformationDelegate extends BaseDelegate {

	public void addCustomerDetails(CustomerInformation customerInfo) {
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			CustomerInformationBO customerInformationBo = new CustomerInformationBO(
					getConnection());
			customerInformationBo.addCustomerDetails(customerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	public Validation getCustomerDetails(CustomerInformation customerInfo) {
		boolean rollBack = false;
		boolean flag=false;
		Validation validation=null;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			System.out.println("in delegate");
			setConnection(connection);
			System.out.println("Stil in delegete");
			CustomerInformationBO customerInfoBO= new CustomerInformationBO(getConnection());
			System.out.println("still in delegate 2");
			validation=customerInfoBO.getCustomerDefaults(customerInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
			
		}return validation;

	}
}
