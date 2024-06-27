package Entity;

public class Employee {
	private String ename;
	private int eid;
	private long phoneno;
	private double esal;
	private int eage;
	private String edesgn;

	public Employee(String name, int eid, long phoneno, double esal, int eage, String edesgn) {
		super();
		this.ename = name;
		this.eid = eid;
		this.phoneno = phoneno;
		this.esal = esal;
		this.eage = eage;
		this.edesgn = edesgn;
	}

	@Override
	public String toString() {
		return "Employee Details :\nname=" + ename + ", eid=" + eid + ", phoneno=" + phoneno + ", esal=" + esal + ", age=" + eage
				+ ", edesgn=" + edesgn ;
	}

	public String getName() {
		return ename;
	}

	public void setName(String name) {
		this.ename = name;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public double getEsal() {
		return esal;
	}

	public void setEsal(double esal) {
		this.esal = esal;
	}

	public int getAge() {
		return eage;
	}

	public void setAge(int eage) {
		this.eage = eage;
	}

	public String getEdesgn() {
		return edesgn;
	}

	public void setEdesgn(String edesgn) {
		this.edesgn = edesgn;
	}

}
