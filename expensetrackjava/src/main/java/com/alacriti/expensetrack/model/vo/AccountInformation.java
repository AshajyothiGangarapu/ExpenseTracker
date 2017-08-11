package com.alacriti.expensetrack.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountInformation {
	private int accountId;
	private long accountNumber;
	private String nickName;

	public AccountInformation() {
	}

	public AccountInformation(int accountId, int accountNumber, String nickName) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.nickName = nickName;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
