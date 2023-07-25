package com.entity;

public class login {
	int AccNo;
	String userName;
	String password;
	public login(int accNo, String userName, String password) {
		super();
		AccNo = accNo;
		this.userName = userName;
		this.password = password;
	}
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
