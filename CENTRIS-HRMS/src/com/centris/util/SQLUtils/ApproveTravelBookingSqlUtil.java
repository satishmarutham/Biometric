package com.centris.util.SQLUtils;

public class ApproveTravelBookingSqlUtil {
	
	public static final String GET_TKT_BOOKED_DETAILS="select b.Remarks,b.ApprovedAmount,e.First_Name as directorName,b.ApprovedDirectorCode,b.DirectorRemarks,substr(b.DirectorApprovedTime,1,19) as approveddate,b.isApprovedByDirector,m.FirstName as postedbyName,b.Posted_By,b.TKTBookCode,b.Tkt_Booked_by_empcode,b.mode,b.resource_who_on_travel_empcode,b.Amount,b.ProjectRefCode,p.Project_Name,b.Traveling_From,b.Traveling_To,b.Booked_date,b.Travelling_Date,b.Debit_crdit_card_usedBy_empcode,substr(b.Posted_Date,1,19) as posteddate,(select bioid from hrms_employee where EMPID in (select EMPID from hrms_manager where  ManagerCode=b.Posted_By)) as postedByBioId,b.FilePath from hrms_ticket_booking b left outer join hrms_project p on p.ProjectCode=b.ProjectCode left outer join hrms_manager m on m.ManagerCode=b.Posted_By,hrms_director d,hrms_employee e  where b.Posted_By in (select ManagerCode from hrms_manager_director_mapping where DirectorCode=? ) and d.DirectorCode=? and d.EMPID=e.EMPID and isConflict='N' and substr(b.Posted_Date,1,10)>=? and substr(b.Posted_Date,1,10)<=? order by length(b.Posted_By),b.Posted_By";
	
	public static final String GET_SINGLE_TKT_DETAILS="select b.DirectorRemarks,b.Remarks,e.First_Name as directorName,b.ApprovedDirectorCode,substr(b.DirectorApprovedTime,1,19) as approveddate,b.isApprovedByDirector,m.FirstName as postedbyName,b.Posted_By,b.ProjectRefCode,p.Project_Name,b.Travelling_Date,b.Debit_crdit_card_usedBy_empcode,substr(b.Posted_Date,1,19) as posteddate from hrms_ticket_booking b left outer join hrms_project p on p.ProjectCode=b.ProjectCode  left outer join hrms_manager m on m.ManagerCode=b.Posted_By left outer join hrms_director d on b.ApprovedDirectorCode=d.DirectorCode left outer join hrms_employee e on  d.EMPID=e.EMPID where  b.TKTBookCode=?";
	
	public static final String APPROVE_SINGLE_TKT="update hrms_ticket_booking set ApprovedAmount=?,DirectorRemarks=?,isApprovedByDirector='Y',ApprovedDirectorCode=?,DirectorApprovedTime=? where TKTBookCode=?";

	public static final String GET_CONFLICT_EMPLOYEES="select b.Remarks,b.ApprovedAmount,e.First_Name as directorName,b.ApprovedDirectorCode,b.DirectorRemarks,substr(b.DirectorApprovedTime,1,19) as approveddate,b.isApprovedByDirector,m.FirstName as postedbyName,b.Posted_By,b.TKTBookCode,b.Tkt_Booked_by_empcode,b.mode,b.resource_who_on_travel_empcode,b.Amount,b.ProjectRefCode,p.Project_Name,b.Traveling_From,b.Traveling_To,b.Booked_date,b.Travelling_Date,b.Debit_crdit_card_usedBy_empcode,substr(b.Posted_Date,1,19) as posteddate,b.FilePath from hrms_ticket_booking b left outer join hrms_project p on p.ProjectCode=b.ProjectCode left outer join hrms_manager m on m.ManagerCode=b.Posted_By,hrms_director d,hrms_employee e  where b.Posted_By in (select ManagerCode from hrms_manager_director_mapping where DirectorCode=? ) and d.DirectorCode=? and d.EMPID=e.EMPID and isConflict='Y' and substr(b.Posted_Date,1,10)>=? and substr(b.Posted_Date,1,10)<=? order by length(b.Posted_By),b.Posted_By";
	public static final String GET_MAIL_DETAILS ="select tb.Amount,e.First_Name,tb.ApprovedAmount,m.email,tb.Booked_date,d.Username as directorMail from hrms_ticket_booking tb left outer join hrms_director d on d.DirectorCode=tb.ApprovedDirectorCode,hrms_employee e,hrms_manager m where tb.Tkt_Booked_by_empcode=e.EMPID and tb.Posted_By=m.ManagerCode and tb.TKTBookCode=? ";

	//approve travel booking by admin
	public static final String GET_NOT_APPROVEDTKT_BY_ADMIN="select b.Remarks,b.isApprovedByAccounts,b.ApprovedAmount,b.ApprovedDirectorCode,e.First_Name as directorName,e.bioid as directorBiocode, b.DirectorRemarks,substr(b.DirectorApprovedTime,1,19) as approveddate,m.FirstName as postedbyName,b.Posted_By,b.TKTBookCode,b.Tkt_Booked_by_empcode,b.mode,b.resource_who_on_travel_empcode,b.Amount,b.ProjectRefCode,p.Project_Name,b.Traveling_From,b.Traveling_To,b.Booked_date,b.Travelling_Date,b.Debit_crdit_card_usedBy_empcode,substr(b.Posted_Date,1,19) as posteddate,b.FilePath  from hrms_ticket_booking b  left outer join hrms_project p on p.ProjectCode=b.ProjectCode  left outer join hrms_manager m on m.ManagerCode=b.Posted_By,hrms_director d,hrms_employee e  where b.ApprovedDirectorCode=d.DirectorCode and d.EMPID=e.EMPID and isConflict='N' and b.isApprovedByDirector='Y' and substr(b.DirectorApprovedTime,1,10)>=? and substr(b.DirectorApprovedTime,1,10)<=? order by length(b.ApprovedDirectorCode),b.ApprovedDirectorCode";
	public static final String GET_CONFLICTNOT_APPROVEDTKT_BY_ADMIN="select b.Remarks,b.isApprovedByAccounts,b.ApprovedAmount,b.ApprovedDirectorCode,e.First_Name as directorName, b.DirectorRemarks,substr(b.DirectorApprovedTime,1,19) as approveddate,m.FirstName as postedbyName,b.Posted_By,b.TKTBookCode,b.Tkt_Booked_by_empcode,b.mode,b.resource_who_on_travel_empcode,b.Amount,b.ProjectRefCode,p.Project_Name,b.Traveling_From,b.Traveling_To,b.Booked_date,b.Travelling_Date,b.Debit_crdit_card_usedBy_empcode,substr(b.Posted_Date,1,19) as posteddate,b.FilePath  from hrms_ticket_booking b  left outer join hrms_project p on p.ProjectCode=b.ProjectCode  left outer join hrms_manager m on m.ManagerCode=b.Posted_By,hrms_director d,hrms_employee e  where b.ApprovedDirectorCode=d.DirectorCode and d.EMPID=e.EMPID and isConflict='Y' and b.isApprovedByDirector='Y' and substr(b.DirectorApprovedTime,1,10)>=? and substr(b.DirectorApprovedTime,1,10)<=? order by length(b.ApprovedDirectorCode),b.ApprovedDirectorCode ";
	public static final String APPROVE_TKTBY_ADMIN="update hrms_ticket_booking set isApprovedByAccounts='Y',ApprovedAccountsCode=?,AccountsApprovedTime=?,AccountApprovedAmount=?,AccountsRemarks=? where TKTBookCode=?";
	public static final String GET_ALL_MAIL_IDS="select d.Username,m.email from  hrms_ticket_booking tb,hrms_manager m,hrms_director d where d.DirectorCode=tb.ApprovedDirectorCode and  m.ManagerCode=tb.Posted_By and TKTBookCode=?";
	public static final String GET_ADMIN_MAIL_DETAILS="select AccMailId from hrms_accounts_mail_details";

	public static final String REJECTTKTBK_BY_DIRECTOR="update hrms_ticket_booking set ApprovedAmount=?,DirectorRemarks=?,isApprovedByDirector='R',ApprovedDirectorCode=?,DirectorApprovedTime=? where TKTBookCode=?";
	
	public static final String REJECTTKTBK_BY_ADMIN="update hrms_ticket_booking set isApprovedByAccounts='R',ApprovedAccountsCode=?,AccountsApprovedTime=? where TKTBookCode=?";

	
	public static final String GET_MGRMAIL_ALLAPRROVE = "select m.email from  hrms_ticket_booking tkt,hrms_manager m where m.ManagerCode=tkt.Posted_By and TKTBookCode=?";

	public static final String UPDATE_MAILSENT = "update hrms_ticket_booking set isMailSent='Y',MailSentTime=? where TKTBookCode=?";

	public static final String GET_MAX_DATES = "select sum(Amount) as amount,max(Booked_date) as maxdate,min(Booked_date) as mindate from hrms_ticket_booking where Posted_By=? and isConflict='N' and substr(Posted_Date,1,10)>=? and substr(Posted_Date,1,10)<=?";

	public static final String GET_CONSOLIDATED_BY_DIRECTOR="select sum(ApprovedAmount) as amount,max(Booked_date) as maxdate,min(Booked_date) as mindate from hrms_ticket_booking where ApprovedDirectorCode=? and isConflict='N' and substr(DirectorApprovedTime,1,10)>=? and substr(DirectorApprovedTime,1,10)<=?";

	public static final String GET_EMP_INFO_FROM_TEVAL_BOOKING = "select t.resource_who_on_travel_bioid,e.First_Name,t.Amount,t.ProjectRefCode,t.ApprovedAmount,t.Booked_date from hrms_ticket_booking t,hrms_employee e where e.EMPID=t.resource_who_on_travel_empcode and t.TKTBookCode=?";

	public static final String GET_DIRE_WISE_EMP_INFO_FROM_TEVAL_BOOKING = "select t.resource_who_on_travel_bioid,e.First_Name,t.Amount,t.ProjectRefCode,t.AccountApprovedAmount,t.ApprovedDirectorCode,t.ApprovedAmount,m.FirstName,t.Booked_date from hrms_ticket_booking t,hrms_employee e,hrms_manager m where e.EMPID=t.resource_who_on_travel_empcode and m.ManagerCode=t.Posted_By and t.TKTBookCode=?";

	public static final String GET_MANG_WISE_EMP_INFO_FROM_TEVAL_BOOKING = "select t.resource_who_on_travel_bioid,e.First_Name,t.Amount,t.ProjectRefCode,t.ApprovedAmount,t.Booked_date,t.Posted_By from hrms_ticket_booking t,hrms_employee e where e.EMPID=t.resource_who_on_travel_empcode and t.TKTBookCode=?";

	public static final String GET_ADMIN_APPROVED_MANG_WISE_EMP_TEVAL_BOOKING_ = "select t.resource_who_on_travel_bioid,e.First_Name,t.Amount,t.ProjectRefCode,t.AccountApprovedAmount,t.Posted_By,t.ApprovedAmount,m.FirstName,t.Booked_date from hrms_ticket_booking t,hrms_employee e,hrms_manager m where e.EMPID=t.resource_who_on_travel_empcode and m.ManagerCode=t.Posted_By and t.TKTBookCode=?";


	
	
	
}
