package com.entity;

public class account {

	private int accNo;
	private String userName;
	private String accType;
	private int phoneNo;
	private String password;
	private int accBal;
	
	public account(int accNo, String userName, String accType, int phoneNo, String password, int accBal) {
		super();
		this.accNo = accNo;
		this.userName = userName;
		this.accType = accType;
		this.phoneNo = phoneNo;
		this.password = password;
		this.accBal = accBal;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccBal() {
		return accBal;
	}
	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}
	
	
	
}
