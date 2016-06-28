package com.centris.util.SQLUtils;

public class MonthReportSqlUtil {
    
	public static final String GET_ALL_EMPLOYEES = "select e.EMPID,e.First_Name from hrms_employee e,hrms_employee_manager_mapping em where em.EmployeeId=e.EMPID and em.ManagerId=? and e.isActive='Y'" ;
    public static final String GET_ALL_MANAGERS_BY_DEPT="select hm.FirstName,hm.ManagerCode from hrms_manager hm,hrms_department_mapping hmd where hmd.UserCode=hm.ManagerCode and hmd.DepartmentCode=?";
    public static final String GET_MONTH_REPORT="select e.bioid,e.EMPID,e.First_Name ,att.Attendence_Date, att.Attedence_Status,attst.ShortName ,att.isPosted ,att.isAproved from hrms_employee e,hrms_employee_attendance att, hrms_attendence_status_type attst where e.EMPID=att.EMPID and att.ASTCode=attst.ASTCode and att.EMPID=? and att.Attendence_Date=?";
    public static final String CHECK_MANAGER="select count(*) from hrms_manager_director_mapping where ManagerCode=? and DirectorCode=?";
    public static final String GET_MANAGER_BY_DEPARTMENT_CODE_DIRECTOR="SELECT distinct hm.FirstName,hm.ManagerCode from hrms_manager hm,hrms_department_mapping hmd,hrms_manager_director_mapping dm where hmd.UserCode=hm.ManagerCode and hmd.DepartmentCode=? and  hm.ManagerCode in (select ManagerCode from hrms_manager_director_mapping where DirectorCode=?)";
    public static final String GET_MANAGER_BY_DEPARTMENT_CODE="SELECT hm.FirstName,hm.ManagerCode from hrms_manager hm,hrms_department_mapping hmd where hmd.UserCode=hm.ManagerCode and hmd.DepartmentCode=?";
    
}
