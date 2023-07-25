package com.entity;

public class bank_tranfer {
private int accNo_sender;
private int accNo_reciver;
private int amt;
public bank_tranfer(int accNo_sender, int accNo_reciver, int amt) {
	super();
	this.accNo_sender = accNo_sender;
	this.accNo_reciver = accNo_reciver;
	this.amt = amt;
}
public int getAccNo_sender() {
	return accNo_sender;
}
public void setAccNo_sender(int accNo_sender) {
	this.accNo_sender = accNo_sender;
}
public int getAccNo_reciver() {
	return accNo_reciver;
}
public void setAccNo_reciver(int accNo_reciver) {
	this.accNo_reciver = accNo_reciver;
}
public int getAmt() {
	return amt;
}
public void setAmt(int amt) {
	this.amt = amt;
}

}
