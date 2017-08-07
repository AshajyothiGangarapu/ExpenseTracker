package com.alacriti.expensetrack.model.vo;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExpenseInformation {

	private long accountNumber;

	private String category;
	private double price;
	private String description;
	private String date;
	

	public ExpenseInformation() {
	}

	public ExpenseInformation(long accountNumber, String category, String date, 
			double price, String description) {
		super();
		this.accountNumber = accountNumber;
		
		this.category = category;
		this.price = price;
		this.description = description;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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
