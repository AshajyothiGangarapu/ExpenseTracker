package com.alacriti.expensetrack.model.vo;

import java.sql.Date;

public class SearchTransaction {
	
	private Date fromDate;
	private Date toDate;
	private String searchValue;
	private int selectOption;
	private long accountNumber;
	private String nickName;
	private String category;
	private String description;
	private double amount;
	private String Date;
	public SearchTransaction(){}
	public SearchTransaction(long accountNumber, String nickName,
			String category, String description, double amount, String date) {
		super();
		this.accountNumber = accountNumber;
		this.nickName = nickName;
		this.category = category;
		this.description = description;
		this.amount = amount;
		Date = date;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public int getSelectOption() {
		return selectOption;
	}
	public void setSelectOption(int selectOption) {
		this.selectOption = selectOption;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
	
}
