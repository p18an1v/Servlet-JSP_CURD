
public class Employee {
      private String ename;
      private int eno;
      private int esal;
	public Employee(String ename, int eno, int esal) {
		super();
		this.ename = ename;
		this.eno = eno;
		this.esal = esal;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
      
}
