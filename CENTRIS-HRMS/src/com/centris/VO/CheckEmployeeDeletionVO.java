package com.centris.VO;

import java.io.Serializable;

public class CheckEmployeeDeletionVO  implements Serializable{

	
	private String status;
	private String employeecode;
	private String empdesig;
	private String checkstatus;
	private boolean flag;
	
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(String checkstatus) {
		this.checkstatus = checkstatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmployeecode() {
		return employeecode;
	}
	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}
	public String getEmpdesig() {
		return empdesig;
	}
	public void setEmpdesig(String empdesig) {
		this.empdesig = empdesig;
	}
	
	
	
	
	
}
