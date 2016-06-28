package com.centris.util.SQLUtils;

public class DepartmentMapping {

	public static final String GET_USER_IDENTIFICATION = "select isManager,isEmployee from hrms_designation where DesignationCode=?";
	public static final String GET_ALL_MANAGERS = "select m.ManagerCode as code,concat(e.First_Name,'-',e.bioid)as name from hrms_manager m,hrms_employee e where m.isActive='Y' and m.EMPID=e.EMPID and e.isActive='Y' order by name";
	public static final String GET_ALL_EMPLOYEES = "select EMPID as code,concat(First_Name,'-',bioid)as name from hrms_employee  where isActive='Y' order by name";
	public static final String GET_DEPARTMENTS = "select dept.DEPT_ID,dept.DEPT_NAME from hrms_department dept where dept.DEPT_ID not in(select DepartmentCode from hrms_department_mapping where UserCode=?)";
	public static final String GET_MANAGER_FOR_EMPLOYEE = "select ManagerCode from hrms_employee where EMPID=?";
	public static final String GET_MAPPED_DEPARTMENTS = "select dept.DEPT_ID,dept.DEPT_NAME from hrms_department dept,hrms_department_mapping dm where dm.DepartmentCode=dept.DEPT_ID and dm.UserCode=?";
	public static final String DELETE_MAPPED_DEPARTMENTS = "delete from hrms_department_mapping where UserCode=?";
	public static final String INSERT_DEPARTMENT_MAPPING = "insert into hrms_department_mapping(DepartmentCode,UserCode,Createdby,Createtime)values(?,?,?,now())";
	public static final String GET_DESIGNATIONS = "select DesignationCode,designationName from hrms_designation where isManager='Y'";

}
