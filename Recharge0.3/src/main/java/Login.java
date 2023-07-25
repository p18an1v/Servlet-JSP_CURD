
public class Login {
 
	private int accId;
	private int password;
	public Login(int accId, int password) {
		super();
		this.accId = accId;
		this.password = password;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
}
