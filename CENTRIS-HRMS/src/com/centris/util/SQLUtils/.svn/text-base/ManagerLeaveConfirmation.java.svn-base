/**
 * 
 */
package com.centris.util.SQLUtils;

/**
 * @author sathish
 *
 */
public class ManagerLeaveConfirmation {
	public static final String GET_LEAVES_TO_APPROVED= "select hrl.SNO,hrl.NoofLeaves,hrl.ReasonForLeave,hrl.StartDate,hrl.EndDate,hrl.RequestedDate,hre.First_Name,hrl.LeaveStatus,hrl.LeaveType from hrms_employee_leave_request hrl,hrms_employee hre where hre.EMPID=hrl.RequestedBy and RequestedTo=? and RequestedBy like ? and hrl.LeaveStatus in ('NOT APPROVED','HOLD') order by RequestedDate";
	public static final String CONFIRM_LEAVE_REQUEST= "update hrms_employee_leave_request set LeaveStatus=?,ApprovedBy=?,AprovedDate=?,TotalDaysAproved=?,commennts=?,ApprovedStartDate=?,ApprovedEndDate=? where SNO=?";
	public static final String REJECT_LEAVE_REQUEST= "update hrms_employee_leave_request set LeaveStatus=?,commennts=? where SNO=?";
	public static final String HOLD_LEAVE_REQUEST= "update hrms_employee_leave_request set LeaveStatus=?,commennts=?,StartDate=?,EndDate=?,RequestedDate=?,NoofLeaves=? where SNO=?";
	
	
	public static final String GET_LEAVEDETAILS_BY_SNO="select hrl.NoofLeaves,hrl.ReasonForLeave,hrl.StartDate,hrl.EndDate,hrl.RequestedDate,hre.First_Name,hrl.filepath from hrms_employee_leave_request hrl,hrms_employee hre where hre.EMPID=hrl.RequestedBy and hrl.SNO=?";
	
	public static final String GET_MANAGER_AND_EMPLOYEE_ID_BY_SNO="select * from  hrms_employee_leave_request where SNO=?";

	
	// for mail sending to employee
		public static final String GET_EMPLOYEE_USERNAME_PASSWORD = "select ou.Username,e.First_Name from hrms_online_users ou,hrms_employee e where  e.EMPID=ou.EMPID  and  e.EMPID=? ";

	// get hr mail details
		
		public static final String GET_HR_MAIL_DETAILS ="select HrMailId from hrms_hr_mail_details";

}
