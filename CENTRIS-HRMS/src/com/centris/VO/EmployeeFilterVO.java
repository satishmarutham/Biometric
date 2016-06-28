package com.centris.VO;

import java.util.ArrayList;

public class EmployeeFilterVO {

	
	private String empname;
	private String empid;
    private String departmentCode;
    private String intime;
    private String outtime;
    private String totaltime;
    private String working_hours;
    private String permission_hours;
    private ArrayList<ProductivityStatusList> statusList ;
    
    
    
    
    
    
		
	
	public ArrayList<ProductivityStatusList> getStatusList() {
		return statusList;
	}
	public void setStatusList(ArrayList<ProductivityStatusList> statusList) {
		this.statusList = statusList;
	}
	public String getWorking_hours() {
		return working_hours;
	}
	public void setWorking_hours(String working_hours) {
		this.working_hours = working_hours;
	}
	public String getPermission_hours() {
		return permission_hours;
	}
	public void setPermission_hours(String permission_hours) {
		this.permission_hours = permission_hours;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
    
    
	
	
	
	
	
	
	
}
