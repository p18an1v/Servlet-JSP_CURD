
public class Student {
	private int studId;
	private String studName;
	private String userName;
	private String password;
	public Student(int studId, String studName, String userName, String password) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.userName = userName;
		this.password = password;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
