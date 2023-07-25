package com.entity;

public class bank_transfer {

	int accNo_sender;
	int accNo_reciever;
	float amt;
	public bank_transfer(int accNo_sender, int accNo_reciever, float amt) {
		super();
		this.accNo_sender = accNo_sender;
		this.accNo_reciever = accNo_reciever;
		this.amt = amt;
	}
	public int getAccNo_sender() {
		return accNo_sender;
	}
	public void setAccNo_sender(int accNo_sender) {
		this.accNo_sender = accNo_sender;
	}
	public int getAccNo_reciever() {
		return accNo_reciever;
	}
	public void setAccNo_reciever(int accNo_reciever) {
		this.accNo_reciever = accNo_reciever;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	 
}
