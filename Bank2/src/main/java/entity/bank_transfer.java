package entity;

import java.time.format.DateTimeFormatter;

public class bank_transfer {
	int accNo_sender;
	int accNo_reciever;
	float amt;
	DateTimeFormatter date;
	public bank_transfer(int accNo_sender, int accNo_reciever, float amt, DateTimeFormatter date) {
		super();
		this.accNo_sender = accNo_sender;
		this.accNo_reciever = accNo_reciever;
		this.amt = amt;
		this.date = date;
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
	public DateTimeFormatter getDate() {
		return date;
	}
	public void setDate(DateTimeFormatter date) {
		this.date = date;
	}

}