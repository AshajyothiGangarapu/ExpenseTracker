package com.alacriti.expensetrack.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountInformation {
	private long accountNumber;
	private String nickName;

	public AccountInformation() {
	}

	public AccountInformation(int accountNumber, String nickName) {
		super();
		this.accountNumber = accountNumber;
		this.nickName = nickName;
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
}
