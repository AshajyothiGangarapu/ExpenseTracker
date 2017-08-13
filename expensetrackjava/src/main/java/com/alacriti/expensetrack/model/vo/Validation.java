package com.alacriti.expensetrack.model.vo;

public class Validation {
	
	private boolean isValidUser;
	private String loginId;
	public Validation(boolean isValidUser, String loginId) {
		super();
		this.isValidUser = isValidUser;
		this.loginId = loginId;
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

}
