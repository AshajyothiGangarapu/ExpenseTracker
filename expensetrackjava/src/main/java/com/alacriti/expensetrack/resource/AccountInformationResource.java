package com.alacriti.expensetrack.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.expensetrack.biz.delegate.AccountInformationDelegate;
import com.alacriti.expensetrack.model.vo.AccountInformation;

@Path("/")
public class AccountInformationResource {
	@POST
	@Path("addAccountInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addaccountDetails(AccountInformation accountInfo) {
		AccountInformationDelegate accountInfoDelegate = new AccountInformationDelegate();
		accountInfoDelegate.addAccountDetails(accountInfo);
		return Response.status(200).entity(accountInfo).build();
	}

	@GET
	@Path("getAccountInfo/{LOGIN_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountInformation(@PathParam("LOGIN_ID") String loginId, @Context HttpServletRequest request) {
		System.out
				.println("In getAccountInformation() -> AccountInformationResource");
		AccountInformationDelegate accountInfoDelegate = new AccountInformationDelegate();
		return Response.ok()
				.entity(accountInfoDelegate.getAccountInformation(loginId))
				.build();
	}

}
