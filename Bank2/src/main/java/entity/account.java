package entity;
public class account {
	String custName;
	String userName;
	int accNo;
	String password;
	String phoneNo;
	float accBal;
	public account(String custName, String userName, int accNo, String password, String phoneNo, float accBal) {
		super();
		this.custName = custName;
		this.userName = userName;
		this.accNo = accNo;
		this.password = password;
		this.phoneNo = phoneNo;
		this.accBal = accBal;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public float getAccBal() {
		return accBal;
	}
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	
}
