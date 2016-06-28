package com.centris.util.SQLUtils;

public class TravelBookedDetailsSqlUtil {

	public static final String GET_SEARCH_EMPLOYEE = "select concat(First_Name,'-',bioid) as employeename,EMPID from hrms_employee where isActive='Y' and First_Name like ?";
	public static final String GET_ALL_PROJECTS = "select distinct  ProjectCode,ProjectRefCode from hrms_project where Status='Y' and   ProjectStatus='Approved'";
	public static final String SAVE_BOOKED_TICKET = "insert into hrms_ticket_booking(TKTBookCode,Tkt_Booked_by_bioid,Tkt_Booked_by_empcode,Amount,resource_who_on_travel_bioid,resource_who_on_travel_empcode,mode,Project_Manager,ProjectCode,ProjectRefCode,Traveling_From,Traveling_To,Remarks,Travelling_Date,Booked_date,Debit_crdit_card_usedBy_bio,Debit_crdit_card_usedBy_empcode,Posted_Date,Posted_By,isConflict,FilePath)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,?,?)";
	public static final String GET_PROJECT_MANAGER = "select pm.ManagerCode from hrms_project p , hrms_project_manager_mapping pm where  p.ProjectCode=pm.ProjectCode and p. ProjectCode=?";
	public static final String GET_NOT_APPROVED_BOOKING_DETAILS = "select b.TKTBookCode,b.Tkt_Booked_by_empcode,b.mode,b.resource_who_on_travel_empcode,b.Amount,b.ProjectRefCode,p.Project_Name,b.Traveling_From,b.Traveling_To,b.Booked_date,b.Travelling_Date,b.Debit_crdit_card_usedBy_empcode,substr(b.Posted_Date,1,19) as posteddate,substr(b.AccountsApprovedTime,1,19) as approveddate,b.AccountApprovedAmount from hrms_ticket_booking b left outer join hrms_project p on p.ProjectCode=b.ProjectCode where b.isApprovedByAccounts='N' and b.Posted_By=? order by b.Posted_Date desc";
	public static final String GET_EMPLOYEE_BY_EMPCODE = "select concat(First_Name,'-',bioid) as First_Name from hrms_employee where EMPID=?";
    public static final String GET_APPROVED_BOOKING_DETAILS = "select b.TKTBookCode,b.Tkt_Booked_by_empcode,b.mode,b.resource_who_on_travel_empcode,b.Amount,b.ProjectRefCode,p.Project_Name,b.Traveling_From,b.Traveling_To,b.Booked_date,b.Travelling_Date,b.Debit_crdit_card_usedBy_empcode,substr(b.Posted_Date,1,19) as posteddate,u.empId as approvedby,substr(b.AccountsApprovedTime,1,19) as approveddate,b.AccountApprovedAmount,b.isApprovedByAccounts  from hrms_ticket_booking b left outer join hrms_project p on b.ProjectCode=p.ProjectCode left outer join hrms_user u on u.userCode=b.ApprovedAccountsCode where (b.isApprovedByAccounts='Y' or b.isApprovedByAccounts='R') and  b.Posted_By=? order by b.Posted_Date desc";
	public static final String CHECK_VALID_TRAVELLING_DATE_BY_POSTED_BY = "select count(*),FilePath from hrms_ticket_booking where Travelling_Date=?  and resource_who_on_travel_empcode=? and Posted_By=?";

	public static final String GET_DIRECTOR_MAILID = "select d.Username,e.First_Name from hrms_director d,hrms_manager_director_mapping dm,hrms_employee e where dm.DirectorCode=d.DirectorCode and d.EMPID=e.EMPID and  d.isActive='Y' and dm.ManagerCode=?";
	public static final String CHECK_VALID_TRAVELLING_DATE = "select distinct count(TKTBookCode)as count,Posted_By,FilePath from hrms_ticket_booking where Travelling_Date=?  and resource_who_on_travel_empcode=? group by TKTBookCode ";
	
	
	

}
