package com.alacriti.expensetrack.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExpenseInformation {

	private int accountId;
	private String category;
	private double price;
	private String description;
	private String date;
	private String loginId;

	
	public ExpenseInformation() {
	}

	public ExpenseInformation(String category, double price) {
	}

	public ExpenseInformation(int accountId, String category, String date,
			double price, String description, String loginId) {
		super();
		this.accountId = accountId;

		this.category = category;
		this.price = price;
		this.description = description;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
