
public class user_account {

	private int accId;
	private String userName;
	private String phoneNo;
	private int accBal;
	private int password;
	public user_account(int accId, String userName, String phoneNo, int accBal, int password) {
		super();
		this.accId = accId;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.accBal = accBal;
		this.password = password;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
