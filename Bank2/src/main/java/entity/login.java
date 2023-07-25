package entity;

public class login {
	String userName;
	int accNo;
	String password;
	public login(String userName, int accNo, String password) {
		super();
		this.userName = userName;
		this.accNo = accNo;
		this.password = password;
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

}
