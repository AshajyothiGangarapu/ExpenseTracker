package com.alacriti.expensetrack.model.vo;

public class Validation {

	private boolean isValidUser;
	private String loginId;
	private String firstName;

	public Validation(boolean isValidUser, String loginId, String firstName) {
		super();
		this.isValidUser = isValidUser;
		this.loginId = loginId;
		this.firstName=firstName;
	}

	public boolean isValidUser() {
		return isValidUser;
	}

	public void setValidUser(boolean isValidUser) {
		this.isValidUser = isValidUser;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
