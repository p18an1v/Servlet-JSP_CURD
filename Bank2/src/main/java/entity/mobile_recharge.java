package entity;

public class mobile_recharge {
	int accNo;
	String phoneNo;
	String serviceProvider;
	float recAmt;
	String date;
	public mobile_recharge(int accNo, String phoneNo, String serviceProvider, float recAmt, String date) {
		super();
		this.accNo = accNo;
		this.phoneNo = phoneNo;
		this.serviceProvider = serviceProvider;
		this.recAmt = recAmt;
		this.date = date;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public float getRecAmt() {
		return recAmt;
	}
	public void setRecAmt(float recAmt) {
		this.recAmt = recAmt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
