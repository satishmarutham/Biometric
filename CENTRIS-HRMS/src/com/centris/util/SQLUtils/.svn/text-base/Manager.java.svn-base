package com.centris.util.SQLUtils;

public class Manager {

	public static final String GET_ALL_MANAGERS = "select hm.FirstName,hm.LastName,hm.ManagerCode,hm.email,hm.phoneno,hm.DepartmentId,hm.Username,hd.DEPT_NAME from hrms_manager hm,hrms_department hd where isActive='Y' and hm.DepartmentId=hd.DEPT_ID";
	public static final String ADD_MANAGER = "insert into hrms_manager(ManagerCode,FirstName,LastName,phoneno,password,Username,email,DepartmentId,isActive,createdby,createtime) values(?,?,?,?,?,?,?,?,?,?,now())";
	public static final String COUNT_MANAGER_USERNAME = "select count(*) from hrms_manager where Username=? and isActive='Y'";
	public static final String COUNT_MANAGER_UPDATE = "select count(*) from hrms_manager where Username=? and ManagerCode!=? and isActive='Y'";
	public static final String GET_SINGLE_MANAGER = "select hm.Username,hm.FirstName,hm.LastName,hm.ManagerCode,hm.email,hm.phoneno,hm.DepartmentId,hd.DEPT_NAME from hrms_manager hm,hrms_department hd where hm.DepartmentId=hd.DEPT_ID and hm.ManagerCode=?";
	public static final String UPDATE_MANAGER = "update hrms_manager set FirstName=?,LastName=?,phoneno=?,Username=?,email=?,DepartmentId=?,modifiedby=?,modifiedtime=now() where ManagerCode=?";
	public static final String PROJECT_MANAGER_MAPPING_COUNT = "select count(*) from hrms_project_manager_mapping where ManagerCode=?";
	public static final String MANAGER_COUNT_IN_EMPLOYEE_TABLE = "select count(*) from hrms_employee where ManagerCode=?";
	public static final String MANAGER_COUNT_IN_EMPLOYEE_ATTENDANCE_TABLE = "select count(*) from hrms_employee_attendance where ManagerCode=?";
	public static final String DELETE_MANAGER = "update hrms_manager set isActive='N' where ManagerCode=?";
	public static final String COUNT_MANAGER_EMAIL = "select count(*) from hrms_manager where email=? and isActive='Y'";
	public static final String COUNT_MANAGER_UPDATE_EMAIL = "select count(*) from hrms_manager where email=? and ManagerCode!=? and isActive='Y'";

	public static final String EMPLOYEE_EXPENSE_DETAILS_CONSOLIDATED = "select expe.MEXP_CODE,emp.bioid,emp.EMPID,emp.First_Name,des.designationName,emp.Mobile_Number,hrm.ManagerCode,case when expe.Local_conveyance is null then '-' else expe.Local_conveyance end Local_conveyance,case when expe.Travel_expenses is null then '-' else expe.Travel_expenses end Travel_expenses,case when expe.Staff_welfare is null then '-' else expe.Staff_welfare end Staff_welfare,case when expe.Telephone_expenses is null then '-' else expe.Telephone_expenses end Telephone_expenses,case when expe.Purchases is null then '-' else expe.Purchases end Purchases,case when expe.other_work_expenses is null then '-' else expe.other_work_expenses end other_work_expenses,case when expe.Miscellaneous is null then '-' else expe.Miscellaneous end Miscellaneous,case when expe.Total_amount_claimed is null then '-' else expe.Total_amount_claimed end Total_amount_claimed  from hrms_employee emp join hrms_monthly_expense expe on expe.EMPID=emp.EMPID join hrms_designation des on des.DesignationCode=emp.DesignationCode  join hrms_manager hrm on hrm.ManagerCode=expe.ManagerCode where expe.year=? and expe.month=? and expe.ManagerCode=? and expe.isManagerApproved='N' order by length(emp.EMPID),emp.EMPID";

	public static final String INSERT_DAILY_ALLOWANCE = "insert into hrms_employee_daily_allowance(Code,Names,HDFC_AC_No,Amount,Project_Manager, Client,Project,Team_Lead,Location,Remarks, Allowance_Date,Posted_Date,Posted_By) values(?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
	public static final String UPDATE_DAILY_ALLOWANCE = "update hrms_employee_daily_allowance set Names=?,HDFC_AC_No=?,Amount=?,Project_Manager=?, Client=?,Project=?,Team_Lead=?,Location=?,Remarks=?,Posted_Date=?,Posted_By=? where Allowance_Date=? and Code=?";
	public static final String INSERT_DAILY_ALLOWANCE_FILEPATH = "insert into hrms_employee_daily_allowance_filepath (date,managerCode,filePath) values (?,?,?)";
	public static final String UPDATE_DAILY_ALLOWANCE_FILEPATH = "update hrms_employee_daily_allowance_filepath set filePath=? where date=? and managerCode=?";
	public static final String SELECT_ALL_DAILY_ALLOWANCE_FILEPATH = "select date,filePath,uploadedTime from hrms_employee_daily_allowance_filepath where managerCode=? order by date asc";
	public static final String CHECK_PATH_ADDED_OR_NOT = "select count(*) from hrms_employee_daily_allowance_filepath where date=? and managerCode=?";
	public static final String CHECK_ALLOWANCEDETAILSCount = "select count(*) from hrms_employee_daily_allowance where Code=? and Allowance_Date=?";

	public static final String UPDATE_EMPLOYEE_ALLOWANCE_BYMANAGER = "update hrms_monthly_expense set Total_amount_approved=?,Advance_paid=?,Balance=?,isManagerApproved=?,managerApprovedDate=?,  createtime=?  where year=? and month=?  and ManagerCode=? and EMPID=?";
	public static final String GET_ALLOWANCE_CREATED_TIME ="select createtime from hrms_monthly_expense where year=? and month=?  and ManagerCode=? and EMPID=?";

	public static final String EMPLOYEE_EXPENSE_DETAILS_CONSOLIDATED_IN_DIRECTOR = "select emp.bioid,expe.MEXP_CODE,case when expe.Total_amount_approved is null then '-' else expe.Total_amount_approved end Approved_Amt,case when expe.Advance_paid is null then '-' else expe.Advance_paid end AdvancePaid,case when expe.Balance is null then '-' else expe.Balance end balance,emp.EMPID,emp.First_Name,des.designationName,emp.Mobile_Number,hrm.ManagerCode,hrm.FirstName as ManagerName,case when expe.Local_conveyance is null then '-' else expe.Local_conveyance end Local_conveyance,case when expe.Travel_expenses is null then '-' else expe.Travel_expenses end Travel_expenses,case when expe.Staff_welfare is null then '-' else expe.Staff_welfare end Staff_welfare,case when expe.Telephone_expenses is null then '-' else expe.Telephone_expenses end Telephone_expenses,case when expe.Purchases is null then '-' else expe.Purchases end Purchases,case when expe.other_work_expenses is null then '-' else expe.other_work_expenses end other_work_expenses,case when expe.Miscellaneous is null then '-' else expe.Miscellaneous end Miscellaneous,case when expe.Total_amount_claimed is null then '-' else expe.Total_amount_claimed end Total_amount_claimed  from hrms_employee emp left join hrms_monthly_expense expe on expe.EMPID=emp.EMPID join hrms_designation des on des.DesignationCode=emp.DesignationCode  join hrms_manager hrm on hrm.ManagerCode=expe.ManagerCode where expe.year=? and expe.month=? and expe.ManagerCode in (select ManagerCode from hrms_manager_director_mapping where DirectorCode=?) and expe.isManagerApproved='Y' and expe.isDirectorApproved='N' order by length(emp.EMPID),emp.EMPID";
	public static final String UPDATE_EMPLOYEE_ALLOWANCE_BY_DIRECTOR = "update hrms_monthly_expense set TotAmt_Director_Approved=?,Director_Balance_Amt=?,isDirectorApproved=?,directorApprovedDate=?,  createtime=?  where year=? and month=?  and ManagerCode=? and EMPID=?";
	
	
	public static final String EMPLOYEE_EXPENSE_DETAILS_CONSOLIDATED_IN_ACCOUNT ="select emp.bioid,expe.MEXP_CODE,case when expe.TotAmt_Director_Approved is null then '-' else expe.TotAmt_Director_Approved end Approved_Amt,case when expe.Advance_paid is null then '-' else expe.Advance_paid end AdvancePaid,case when expe.Director_Balance_Amt is null then '-' else expe.Director_Balance_Amt end balance,md.DirectorCode,emp.EMPID,emp.First_Name,des.designationName,emp.Mobile_Number,hrm.ManagerCode,hrm.FirstName as managername,case when expe.Local_conveyance is null then '-' else expe.Local_conveyance end Local_conveyance,case when expe.Travel_expenses is null then '-' else expe.Travel_expenses end Travel_expenses,case when expe.Staff_welfare is null then '-' else expe.Staff_welfare end Staff_welfare,case when expe.Telephone_expenses is null then '-' else expe.Telephone_expenses end Telephone_expenses,case when expe.Purchases is null then '-' else expe.Purchases end Purchases,case when expe.other_work_expenses is null then '-' else expe.other_work_expenses end other_work_expenses,case when expe.Miscellaneous is null then '-' else expe.Miscellaneous end Miscellaneous,case when expe.Total_amount_claimed is null then '-' else expe.Total_amount_claimed end Total_amount_claimed  from hrms_employee emp left join hrms_monthly_expense expe on expe.EMPID=emp.EMPID  join hrms_designation des on des.DesignationCode=emp.DesignationCode  join hrms_manager hrm on hrm.ManagerCode=expe.ManagerCode join hrms_manager_director_mapping md on md.ManagerCode=hrm.ManagerCode where expe.year=? and expe.month=? and expe.isManagerApproved='Y' and expe.isDirectorApproved='Y' and expe.isAccountApproved='N' order by length(emp.EMPID),emp.EMPID";
	public static final String GET_DIRECTOR= "select e.First_Name from hrms_employee e,hrms_director d where e.EMPID=d.EMPID and d.DirectorCode=? and d.isActive='Y'";
	public static final String UPDATE_EMPLOYEE_ALLOWANCE_BY_ADMIN ="update hrms_monthly_expense set TotAmt_Account_Approved=?,Account_Balance_Amt=?,ApprovedAccountCode=?, isAccountApproved=?,accountApprovedDate=?,  createtime=?  where year=? and month=? and ManagerCode=? and EMPID=?";

	
	public static final String GET_DIRECTOR_DETAILS = "select e.First_Name,e.Official_Email_ID from hrms_employee e,hrms_director dd where dd.EMPID=e.EMPID and dd.DirectorCode in (select d.DirectorCode from hrms_director d,hrms_manager_director_mapping mdm where d.DirectorCode=mdm.DirectorCode and mdm.ManagerCode=? and d.isActive='Y' )";
	public static final String GET_MANAGER = "select FirstName,email from hrms_manager where ManagerCode=?";
	public static final String GET_ADMIN_DETAILS = "select e.First_Name,e.Official_Email_ID from  hrms_employee e,hrms_user u where e.EMPID=u.empId and U.userCode=?";
	
	public static final String MANAGER_CONTACT_US_MAIL = "manager_ContactUsMail";

	

	//approve expenses details
	
	public static final String APPROVE_ALL_EXPENSES_BY_MANAGER ="update hrms_monthly_expense set Total_amount_approved=?,Advance_paid=?,Balance=?,isManagerApproved=?,managerApprovedDate=?,  createtime=?  where MEXP_CODE=?";
	public static final String GET_EXPENSE_CREATED_TIME ="select createtime from hrms_monthly_expense where MEXP_CODE=?";
	public static final String APPROVE_ALL_EXPENSES_BY_DIRECTOR="update hrms_monthly_expense set isDirectorApproved=?,directorApprovedDate=?,createtime=?,TotAmt_Director_Approved=?,Director_Balance_Amt=?  where MEXP_CODE=?";
	public static final String APPROVE_ALL_EXPENSES_BY_ADMIN="update hrms_monthly_expense set ApprovedAccountCode=?, isAccountApproved=?,accountApprovedDate=?,  createtime=?,TotAmt_Account_Approved=?,Account_Balance_Amt=?  where MEXP_CODE=?";

	public static final String GET_EMPLOYEEID="select EMPID from hrms_employee where bioid=?";


}
