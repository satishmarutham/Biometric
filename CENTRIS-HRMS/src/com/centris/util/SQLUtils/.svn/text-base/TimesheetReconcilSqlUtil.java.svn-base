package com.centris.util.SQLUtils;

public class TimesheetReconcilSqlUtil {

	public static final String GET_ALL_DEPT = "select DEPT_ID,DEPT_NAME from hrms_department ";
	public static final String GET_TIMESHEET_DATA = "select a.EMPID,a.Attendence_Date,a.intime,a.outtime,a.totaltime,e.First_Name from hrms_employee_attendance a left outer join hrms_employee e on e.EMPID=a.EMPID where  a.EMPID in () and a.Attendence_Date>=?and a.Attendence_Date<=? and  a.isPosted='Y' and a.isAproved='Y'  order by a.Attendence_Date";

	public static final String CHECK_TIMESHEET_EMPLOYEE="select count(*) from hrms_employee_attendance where  EMPID=? and Attendence_Date=?";
	public static final String UPDATE_TIMESHEET="UPDATE hrms_employee_attendance SET intime=? ,outtime=?,totaltime=?,ModifiedBy=?,ModifiedDate=?  WHERE  EMPID=? and Attendence_Date=?";

}
