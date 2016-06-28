package com.centris.util.SQLUtils;

public class AttendanceTimeSheetReport {
	
	public static final String GET_ACC_YEAR="select AccadamicYear from hrms_accyear";
	//public static final String GET_TIMESHEET_REPORT="select e.EMPID,e.First_Name,ast.ASTCode,ast.ShortName,a.isAproved,a.isPosted,a.Attendence_Date from hrms_employee_attendance a,hrms_attendence_status_type ast,hrms_employee e where e.EMPID=a.EMPID and ast.ASTCode=a.ASTCode and Attendence_Date=?  and a.EMPID=? order by Attendence_Date";
	public static final String GET_TIMESHEET_REPORT="select e.EMPID,e.First_Name,a.isAproved,a.isPosted,a.Attendence_Date,a.Attedence_Status from hrms_employee_attendance a,hrms_employee e where e.EMPID=a.EMPID and  Attendence_Date=?  and a.EMPID=? order by a.EMPID";
	public static final String GET_SHORT_NAME="select ast.ASTCode,ast.ShortName from hrms_employee_attendance a,hrms_attendence_status_type ast where ast.ASTCode=a.ASTCode and Attendence_Date=?  and a.EMPID=?";

}
