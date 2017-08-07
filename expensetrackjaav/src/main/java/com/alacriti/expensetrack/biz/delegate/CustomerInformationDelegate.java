package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;

import com.alacriti.expensetrack.bo.impl.CustomerInformationBO;
import com.alacriti.expensetrack.model.vo.CustomerInformation;

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
	public boolean getCustomerDetails(CustomerInformation customerInfo) {
		boolean rollBack = false;
		boolean flag=false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			System.out.println("in delegate");
			setConnection(connection);
			System.out.println("Stil in delegete");
			CustomerInformationBO customerInfoBO= new CustomerInformationBO(getConnection());
			System.out.println("still in delegate 2");
			flag=customerInfoBO.getCustomerDefaults(customerInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
			
		}return flag;

	}
}