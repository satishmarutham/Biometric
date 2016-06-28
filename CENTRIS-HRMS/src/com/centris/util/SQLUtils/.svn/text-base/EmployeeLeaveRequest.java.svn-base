package com.centris.util.SQLUtils;

public class EmployeeLeaveRequest {

	
	public static final String CHECK_LEAVE_COUNT = "select count(*) from hrms_employee_leave_request where RequestedBy=? and (? between StartDate and EndDate or ? between  StartDate and EndDate)";
	public static final String INSERT_LEAVE_REQUEST = "insert into hrms_employee_leave_request(NoofLeaves,ReasonForLeave,StartDate,EndDate,RequestedBy,RequestedTo,RequestedDate,filepath,LeaveStatus,LeaveType)values(?,?,?,?,?,?,now(),?,?,?)";
	public static final String GET_SINGLE_MANAGER = "select m.ManagerCode,m.FirstName from  hrms_employee e,hrms_manager m where e.ManagerCode=m.ManagerCode and e.EMPID=?";
	
	
	public static final String GET_EMPLOYEE_LEAVE_STATUS="select hrl.SNO,hrl.NoofLeaves,hrl.ReasonForLeave,hrl.StartDate,hrl.EndDate,hrl.RequestedDate,hrl.LeaveStatus,hrl.LeaveType from hrms_employee_leave_request hrl where RequestedBy=? order by RequestedDate";
	public static final String EMPLOYEE_LEAVE_STATUS_BY_SNO="select hm.ManagerCode,hrl.SNO,hrl.ApprovedBy,hrl.NoofLeaves,hrl.ReasonForLeave,hrl.StartDate,hrl.EndDate,hrl.RequestedDate,hre.First_Name,hrl.filepath,hrl.ApprovedStartDate,hrl.ApprovedEndDate,hrl.commennts,hrl.TotalDaysAproved,hrl.ApprovedStartDate,hrl.AprovedDate,hm.FirstName,hrl.LeaveType from hrms_employee_leave_request hrl,hrms_employee hre ,hrms_manager hm where hre.EMPID=hrl.RequestedBy and hm.ManagerCode=hrl.RequestedTo and hrl.SNO=?";
	public static final String EMPLOYEE_LEAVE_STATUS_BY_SNO_FOR_MGR="select d.DirectorCode AS ManagerCode,hrl.SNO,hrl.ApprovedBy,hrl.NoofLeaves,hrl.ReasonForLeave,hrl.StartDate,hrl.EndDate,hrl.RequestedDate,hre.First_Name,hrl.filepath,hrl.ApprovedStartDate,hrl.ApprovedEndDate,hrl.commennts,hrl.TotalDaysAproved,hrl.ApprovedStartDate,hrl.AprovedDate,e.First_Name AS FirstName,hrl.LeaveType from hrms_employee_leave_request hrl,hrms_employee hre ,hrms_director d,hrms_employee e where hre.EMPID=hrl.RequestedBy and d.DirectorCode=hrl.RequestedTo and e.EMPID=d.EMPID and hrl.SNO=?";
	
	//view leave details
	public static final String GET_LEAVEBANK_DETAILS = "select SL,sum(PL+CL)as al from hrms_empwise_leave_bank_details where AccYearCode=? and EMPID=?";
	public static final String GET_TOTAL_LEAVES = "select ay.AccadamicYear,lb.AccyearCode,lb.SL,sum(PL+CL)as AL from hrms_employee_leave_bank lb,hrms_accyear ay where  ay.AccyearCode=lb.AccyearCode  and  ay.AccadamicYear>=? group by lb.AccyearCode order by lb.AccyearCode asc";
	public static final String GET_ACADAMICYEAR_ID = "select AccyearCode from hrms_accyear where AccadamicYear=?";
	public static final String UPDATE_EMPLOYEE_LEAVE_REQUEST_WITH_OUT_FILE_PATH="update hrms_employee_leave_request set NoofLeaves=?,ReasonForLeave=?,StartDate=?,EndDate=?,RequestedBy=?,RequestedTo=?,RequestedDate=?,LeaveType=? where SNO=?";
			
	public static final String CHECK_LEAVE_COUNT_UPDATE = "select count(*) from hrms_employee_leave_request where RequestedBy=? and (StartDate between ? and ? or EndDate between ? and ?) and SNO!=?";

	public static final String GET_SINGLE_DIRECTORS="select e.EMPID,e.First_Name,d.DirectorCode,d.Username from hrms_employee e,hrms_director d where e.EMPID=d.EMPID and d.DirectorCode=?";

	public static final String UPDATE_EMPLOYEE_LEAVE_REQUEST_WITH_FILE_PATH="update hrms_employee_leave_request set NoofLeaves=?,ReasonForLeave=?,StartDate=?,EndDate=?,RequestedBy=?,RequestedTo=?,RequestedDate=?,filepath=?,LeaveType=? where SNO=?";
	
	public static final String GET_EMP_DOJ_YEAR = "select y.AccadamicYear,y.AccyearCode,month(e.DOJ) as month from hrms_employee e,hrms_accyear y where AccadamicYear>=YEAR(STR_TO_DATE(e.DOJ, '%Y-%m-%d'))  and  e.EMPID=?";

	public static final String GET_SL_LEAVES = "select lb.SL as slopenbal,l.SL as slconsumebal,(lb.SL - l.SL)as slclosingbal from hrms_employee_leave_bank lb,hrms_empwise_leave_bank_details l where   lb.AccyearCode=? and l.AccYearCode=lb.AccyearCode  and  l.EMPID=? group by lb.AccyearCode";
	
	public static final String GET_PL_LEAVES = "select lb.PL as plopenbal ,l.PL plconsumebal,(lb.PL - l.PL) as plclosingbal  from hrms_employee_leave_bank lb,hrms_empwise_leave_bank_details l where   lb.AccyearCode=? and l.AccYearCode=lb.AccyearCode  and  l.EMPID=? group by lb.AccyearCode";
	
	public static final String GET_CL_LEAVES = "select lb.CL as clopenbal,l.CL as clconsumebal,(lb.CL - l.CL)as clclosingbal from hrms_employee_leave_bank lb,hrms_empwise_leave_bank_details l where   lb.AccyearCode=? and l.AccYearCode=lb.AccyearCode  and  l.EMPID=? group by lb.AccyearCode";
	
	
}
