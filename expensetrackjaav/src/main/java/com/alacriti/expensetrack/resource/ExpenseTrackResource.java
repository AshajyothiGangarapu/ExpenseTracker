package com.alacriti.expensetrack.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.expensetrack.biz.delegate.CustomerInformationDelegate;
import com.alacriti.expensetrack.biz.delegate.ExpenseInformationDelegate;
import com.alacriti.expensetrack.model.vo.CustomerInformation;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;
@Path("/customer")
public class ExpenseTrackResource {
	@POST
	@Path("/addCustomerDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCustomerDetails(CustomerInformation customerInfo){
		CustomerInformationDelegate customerInfoDelegate = new CustomerInformationDelegate();
		customerInfoDelegate.addCustomerDetails(customerInfo);
		return Response.status(200).entity(customerInfo).build();
	}
	@POST
	@Path("/addExpenses")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addExpenses(ExpenseInformation expenseInfo){
		ExpenseInformationDelegate ExpenseInfoDelegate = new ExpenseInformationDelegate();
		ExpenseInfoDelegate.addExpenses(expenseInfo);
		return Response.status(200).entity(expenseInfo).build();
	}
        @POST
		@Path("/getLoginDetails")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public boolean getCustomerDetails(CustomerInformation customerInfo){
			CustomerInformationDelegate customerInfoDelegate = new CustomerInformationDelegate();
			return customerInfoDelegate.getCustomerDetails(customerInfo);
			
		}
}