package com.entity;

public class login {

	private int accNo;
	private int password;
	public login(int accNo, int password) {
		super();
		this.accNo = accNo;
		this.password = password;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}

	
}
