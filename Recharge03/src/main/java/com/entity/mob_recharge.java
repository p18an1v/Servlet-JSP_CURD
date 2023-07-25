package com.entity;

public class mob_recharge {

	int accNo;
	long phoneNo;
	int recAmt;
	String service_provider;
	public mob_recharge(int accNo, long phoneNo, int recAmt, String service_provider) {
		super();
		this.accNo = accNo;
		this.phoneNo = phoneNo;
		this.recAmt = recAmt;
		this.service_provider = service_provider;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getRecAmt() {
		return recAmt;
	}
	public void setRecAmt(int recAmt) {
		this.recAmt = recAmt;
	}
	public String getService_provider() {
		return service_provider;
	}
	public void setService_provider(String service_provider) {
		this.service_provider = service_provider;
	}
	
}
