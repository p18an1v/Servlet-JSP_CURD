package com.entity;

public class account {

	private String username;
	private long phoneNo;
	private int accNo;
	private int accBal;
	private int password;
	public account(String username, long phoneNo, int accNo, int accBal, int password) {
		super();
		this.username = username;
		this.phoneNo = phoneNo;
		this.accNo = accNo;
		this.accBal = accBal;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public int getAccBal() {
		return accBal;
	}
	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
}
