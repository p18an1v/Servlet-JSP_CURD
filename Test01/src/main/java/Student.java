
public class Student {

	private int studId;
	private String studName;
	private long studMob;
	private String studPass;
	public Student(int studId, String studName, long studMob, String studPass) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studMob = studMob;
		this.studPass = studPass;
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
	public long getStudMob() {
		return studMob;
	}
	public void setStudMob(long studMob) {
		this.studMob = studMob;
	}
	public String getStudPass() {
		return studPass;
	}
	public void setStudPass(String studPass) {
		this.studPass = studPass;
	}
	
	
}
