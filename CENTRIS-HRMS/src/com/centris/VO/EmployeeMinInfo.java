package com.centris.VO;

public class EmployeeMinInfo {

	public EmployeeMinInfo() {
		// TODO Auto-generated constructor stub
	}

	private String empid;
	private String ename;
	private String deptid;
	private String projectCode;
	private String managerCode;
	private String bioid;

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public String getBioid() {
		return bioid;
	}

	public void setBioid(String bioid) {
		this.bioid = bioid;
	}

}