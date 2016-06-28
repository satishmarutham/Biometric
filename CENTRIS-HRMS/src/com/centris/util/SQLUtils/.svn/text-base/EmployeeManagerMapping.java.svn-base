package com.centris.util.SQLUtils;

public class EmployeeManagerMapping {

	public static final String GET_EMPLOYEES = "select e.EMPID,concat(e.First_Name,'-',e.bioid) as firstname from hrms_employee e where e.EMPID NOT IN(select em.EmployeeId from hrms_employee_manager_mapping em) and e.EMPID NOT IN(select d.EMPID from hrms_director d where d.isActive='Y') and e.isActive='Y'";
	public static final String DELETE_EMPLOYEE_MANAGER_MAP = "delete from hrms_employee_manager_mapping where ManagerId=?";
	public static final String INSERT_EMPLOYEE_MANAGER = "insert into hrms_employee_manager_mapping(EmployeeId,ManagerId,Createdby,Createtime) values(?,?,?,now())";
	public static final String GET_MAPPED_EMPLOYEES = "select e.EMPID,concat(e.First_Name,'-',e.bioid) as firstname from  hrms_employee e,hrms_employee_manager_mapping em where em.EmployeeId=e.EMPID and em.ManagerId=?";

}
