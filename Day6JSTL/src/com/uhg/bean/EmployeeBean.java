package com.uhg.bean;

public class EmployeeBean {
	private int empId;
	private String empName;
	private long mobile;
	private String email;

	public EmployeeBean() {
		super();
	}

	public EmployeeBean(int empId, String empName, long mobile, String email) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.mobile = mobile;
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", mobile=" + mobile + ", email=" + email
				+ "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
