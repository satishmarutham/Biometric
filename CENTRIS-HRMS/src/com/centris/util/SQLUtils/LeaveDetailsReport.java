package com.centris.util.SQLUtils;

public class LeaveDetailsReport {

	public static final String GET_LEAVEDETAILS_REPORT="select amp.bioid,amp.EMPID,amp.First_Name,amp.DOJ,amp.Employee_Status,ea.Attendence_Date from (select EMPID,First_Name,DOJ,Employee_Status,bioid from hrms_employee e where  e.EMPID=? ) amp left outer join hrms_employee_attendance ea on amp.EMPID=ea.EMPID and ea.Attedence_Status='leave' and ea.isAproved='Y' and ea.isPosted='Y' and ea.Attendence_Date<=?";
	public static final String GET_NO_OF_LEAVES="select total_leaves,allowed_per_month from hrms_employee_leave_bank where AccyearCode in (select AccyearCode from hrms_accyear where AccadamicYear=?)";
}
