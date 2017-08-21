package com.alacriti.expensetrack.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.expensetrack.biz.delegate.CategoryInformationDelegate;
import com.alacriti.expensetrack.biz.delegate.CustomerInformationDelegate;
import com.alacriti.expensetrack.biz.delegate.ExpenseInformationDelegate;
import com.alacriti.expensetrack.biz.delegate.SearchTransactionDelegate;
import com.alacriti.expensetrack.biz.delegate.TopCategoriesDelegate;
import com.alacriti.expensetrack.biz.delegate.TopSpendsDelegate;
import com.alacriti.expensetrack.model.vo.CustomerInformation;
import com.alacriti.expensetrack.model.vo.ExpenseInformation;
import com.alacriti.expensetrack.model.vo.SearchTransaction;
import com.alacriti.expensetrack.model.vo.Validation;

@Path("/")
public class ExpenseTrackResource {
	@POST
	@Path("/customer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addCustomerDetails(CustomerInformation customerInfo) {
		CustomerInformationDelegate customerInfoDelegate = new CustomerInformationDelegate();
		return customerInfoDelegate.addCustomerDetails(customerInfo);
	}

	@GET
	@Path("/session")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSessoin(@Context HttpServletRequest request) {

		if (request.getSession(false) != null) {
			return true;
		} else {
			return false;
		}
	}

	@GET
	@Path("/logout")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean destroySessoin(@Context HttpServletRequest request) {

		if (request.getSession(false) != null) {
			request.getSession().invalidate();
			return true;
		} else {
			return false;
		}
	}

	@POST
	@Path("/expenses")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addExpenses(ExpenseInformation expenseInfo,
			@Context HttpServletRequest request) {
		ExpenseInformationDelegate expenseInfoDelegate = new ExpenseInformationDelegate();
		return expenseInfoDelegate.addExpenses(expenseInfo);

	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Validation getCustomerDetails(CustomerInformation customerInfo,
			@Context HttpServletRequest request) {
		CustomerInformationDelegate customerInfoDelegate = new CustomerInformationDelegate();
		if (customerInfoDelegate.getCustomerDetails(customerInfo).isValidUser()) {
			HttpSession session = request.getSession();
		}
		return customerInfoDelegate.getCustomerDetails(customerInfo);

	}

	@GET
	@Path("/categorySpendRatio/{LOGIN_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTopCategories(@PathParam("LOGIN_ID") String loginId) {
		System.out.println("In getTopCategories() -> ExpenseTrackResource");
		TopCategoriesDelegate topCategoryDelegate = new TopCategoriesDelegate();
		return Response.ok()
				.entity(topCategoryDelegate.getTopCategories(loginId)).build();
	}

	@GET
	@Path("/categorySpendAmount/{LOGIN_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTopSpends(@PathParam("LOGIN_ID") String loginId) {
		System.out.println("In getTopSpends() -> ExpenseTrackResource");
		TopSpendsDelegate topSpendsDelegate = new TopSpendsDelegate();
		return Response.ok().entity(topSpendsDelegate.getTopSpends(loginId))
				.build();
	}

	@GET
	@Path("/category")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoryInformation() {
		System.out
				.println("In getCategoryInformation() -> CategoryInformationResource");
		CategoryInformationDelegate categoryInfoDelegate = new CategoryInformationDelegate();
		return Response.ok()
				.entity(categoryInfoDelegate.getCategoryInformation()).build();
	}

	@POST
	@Path("/searchondetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getSearchDetails(SearchTransaction searchTransaction) {
		System.out.println(searchTransaction.getSearchValue() + " : "
				+ searchTransaction.getSelectOption());
		SearchTransactionDelegate searchTransactionDelegate = new SearchTransactionDelegate();
		searchTransactionDelegate.getSearchDetails(searchTransaction);
		return Response
				.ok()
				.entity(searchTransactionDelegate
						.getSearchDetails(searchTransaction)).build();

	}

	@POST
	@Path("/searchondate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getSearchOnDate(SearchTransaction searchTransaction) {
		SearchTransactionDelegate searchTransactionDelegate = new SearchTransactionDelegate();
		searchTransactionDelegate.getSearchOnDate(searchTransaction);
		return Response
				.ok()
				.entity(searchTransactionDelegate
						.getSearchOnDate(searchTransaction)).build();

	}
}