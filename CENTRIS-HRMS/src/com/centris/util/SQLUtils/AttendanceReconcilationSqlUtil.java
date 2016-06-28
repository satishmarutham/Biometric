package com.centris.util.SQLUtils;

public class AttendanceReconcilationSqlUtil {

	public static final String GET_ALL_DEPT = "select DEPT_ID,DEPT_NAME from hrms_department ";
	public static final String INSERT_ATTENDANCE_RECONCIL = "insert into hrms_attedence_reconcillatoion(empid,Attendence_Date,attedence,reason,short_name,modified_by,modified_date) values(?,?,?,?,?,?,now())";
	public static final String UPDATE_ATTENDANCE_ISRECONCILED = "update  hrms_employee_attendance set isRecouncil='Y',ModifiedBy=?,ModifiedDate=now() where EMPID=? and Attendence_Date=?";


}
