package com.centris.util.SQLUtils;

public class ETL_AttendanceProcessing {

	public static String SHIFT_MAX_LOGAUDIT = "select ADMS_CHK_ID from hrms_att_log_audit where AI_BIO_LOG_DATE_ENTRY = (select max( AI_BIO_LOG_DATE_ENTRY ) from hrms_att_log_audit)";
	public static String INSERT_LOGDETAILS_new="insert into hrms_att_log_details(AI_EMP_ID,AI_EMP_DATE,AI_EMP_TIME,BIO_SN,ETL_CODE,AI_EMP_ENTRY_USER,ADMS_CHK_ID) values(?,?,?,?,?,?,?)";
	public static String SELECT_MAX_LOG_ID = "select id,checktime from checkinout where checktime <= ? order by checktime desc limit 1";
	public static String LOG_SELECT_SQL = "select chk.id ADMS_CHK_ID,chk.USERID,chk.CHECKTIME,chk.CHECKTYPE,usrinfo.USERID,usrinfo.Badgenumber,chk.SN from CHECKINOUT chk,USERINFO usrinfo where chk.USERID=usrinfo.USERID and chk.id > ? and chk.id <= ?  order by chk.USERID ,chk.CHECKTIME";
	
	public static String ETL_AUDIT = "insert into hrms_att_etl_details (ETL_CODE,CREATED_TIME) values (?,?)";	
	public static String getCurrentSessionFirstTimeStamp="select AI_EMP_DATE,AI_EMP_TIME  from hrms_att_log_details where ETL_CODE=? order by AI_EMP_DATE,AI_EMP_TIME limit 1";
	public static String UPDATE_AUDITDATES = "insert into hrms_att_audit_dates (aduit_date,remarks,ETL_CODE) values(?,?,?)";
	public static String UPDATE_AUDITENTRY = "insert into hrms_att_log_audit(AI_BIO_LOG_DATE_ENTRY,ADMS_CHK_ID, AI_BIO_ENTRY_TIME,ETL_CODE) values(?,?, ?,?)";
	
	public static String CHECK_TIMESHEET_COMPLETED="select isCompleted from  hrms_att_bio_time_sheet_etl_audit where attedence_date=? ";
	public static String LOG_DETAILS_COUNT="select count(*) cnt from hrms_att_log_details where ETL_CODE=?  and AI_EMP_DATE=? ";
	public static String LOG_DETAILS_COUNT_DATE="select count(*) cnt from hrms_att_log_details where ETL_CODE=? and AI_EMP_DATE > ?";
	//public static String GET_ALL_EMPLOYEES="SELECT emp.EMPID,emp.bioid,emp.First_Name as EMPNAME,prj.ProjectCode,prj.Project_Name,pjmap.ManagerCode,manj.FirstName FROM hrms_employee emp join hrms_project prj on prj.ProjectCode=emp.ProjectCode join hrms_manager manj join hrms_project_manager_mapping pjmap on pjmap.ProjectCode=prj.ProjectCode and pjmap.ManagerCode=manj.ManagerCode WHERE emp.Employee_Status=? and  emp.isActive='Y' order by length(emp.bioid),emp.bioid";
	
	//get all employees information written by seshu
	public static String GET_ALL_EMPLOYEES="SELECT emp.EMPID,emp.bioid,emp.First_Name as EMPNAME,prj.ProjectCode,prj.Project_Name,mgr.ManagerCode, mgr.FirstName FROM hrms_employee emp left outer join hrms_manager mgr on mgr.ManagerCode in (select ManagerId from hrms_employee_manager_mapping where EmployeeId=emp.EMPID) left outer join hrms_project prj on prj.ProjectCode = (select ProjectCode from hrms_project_manager_mapping where ManagerCode=mgr.ManagerCode limit 1) WHERE emp.Employee_Status=? and  emp.isActive='Y' order by length(emp.bioid),emp.bioid";
	
	public static String GET_PUCNCH_TIME="SELECT AI_EMP_TIME FROM hrms_att_log_details WHERE AI_EMP_ID=? AND AI_EMP_DATE=? ORDER BY AI_EMP_TIME";
	public static String calculate_latest_timestamp="select ADMS_CHK_ID,AI_EMP_DATE,AI_EMP_TIME from hrms_att_log_details where AI_EMP_DATE=(select max(AI_EMP_DATE) from hrms_att_log_details) order by AI_EMP_DATE,AI_EMP_TIME desc limit 1";	
	public static String checkForData = "select count(*) from hrms_att_log_details where AI_EMP_DATE=?";
	public static String checkForDateIsPresentOrNot = "select aduit_date from hrms_att_audit_dates where aduit_date = ?";
	
	public static String LOGMAX_DATE_PICK = "select distinct AI_EMP_DATE from hrms_att_log_details where AI_EMP_DATE > ?";
	public static String SELECT_EMPID = "select distinct EMPID from hrms_employee";	
	public static String CHECK_POSTED_OR_NOT ="select count(*) from hrms_employee_attendance where Attendence_Date=?";
	public static String UPDATE_ATTENDANCE="update hrms_employee_attendance set Attedence_Status=?,intime=?,outtime=?,totaltime=?,Location=?,isAproved=?,isPosted=?,ApprovedTime=?,PostedTime=?,ApprovedBy=?,ProjectCode=?,ManagerCode=?,ASTCode=? where EMPID=? and Attendence_Date=?";
	
	public static String CHECK_FOR_LEAVE="select ApprovedStartDate,ApprovedEndDate from hrms_employee_leave_request where RequestedBy=? and LeaveStatus='APPROVED'";
	public static String CHECK_FOR_HOLIDAY="select count(*) from hrms_holidaymaster where HOLIDAY_DATE=? and DEPT_ID=? and CURRENT_YEAR=?";
	public static String INCORRECT_PUNCH="insert into hrms_att_incorrect_punched_employees (ATTEDANCE_DATE, EMP_ID, REASON, ETL_CODE ) values (?,?,?,?) ";
	public static String ATT_PROCESSOD_OR_NOT="select isCompleted from  hrms_att_bio_time_sheet_etl_audit where attedence_date=?";
	
	public static String CHECK_TIMESHEET_AUDIT="select count(*) from hrms_att_bio_time_sheet_etl_audit where attedence_date=?";
	public static String INSERT_TIMESHEET_AUDIT="insert into hrms_att_bio_time_sheet_etl_audit (attedence_date,  status, reason, isCompleted, ETL_CODE ) values (?,?,?,?,?)";
	public static String UPDATE_TIMESHEET_AUDIT="update hrms_att_bio_time_sheet_etl_audit set status=?,reason = ?,isCompleted= ?, ETL_CODE=? where attedence_date=?";
}
