package com.centris.util.SQLUtils;

public class AttendenceDetails {

	
	public static final String GET_EMP_BASEDON_MGR="select * from hrms_employee,hrms_employee_manager_mapping where EMPID=EmployeeId and ManagerId=? and isActive='Y'";
	public static final String GET_EMP_ATTENDENCE="select eatt.Attendence_Date,eatt.EMPID,eatt.Attedence_Status,eatt.intime,eatt.outtime,eatt.totaltime,eatt.Location,eatt.ASTCode,ast.StatusType,pjt.ClientCode,pjt.ClientName,emp.First_Name,eatt.isAproved,ast.ShortName from hrms_employee emp,hrms_employee_attendance eatt left outer join hrms_attendence_status_type ast on eatt.ASTCode=ast.ASTCode left outer join hrms_client pjt on eatt.ProjectCode=pjt.ClientCode where  eatt.EMPID=emp.EMPID and eatt.EMPID like ? and eatt.Attendence_Date between ? and ? and  eatt.EMPID in (select EmployeeId from hrms_employee_manager_mapping where ManagerId=?) order by eatt.Attendence_Date,emp.First_Name";
	//public static final String GET_EMP_ATTENDENCE="select eatt.Attendence_Date,eatt.EMPID,eatt.Attedence_Status,eatt.intime,eatt.outtime,eatt.totaltime,eatt.Location,eatt.ASTCode,ast.StatusType,eatt.ProjectCode,pjt.Project_Name,emp.First_Name from hrms_employee_attendance eatt,hrms_attendence_status_type ast,hrms_project pjt,hrms_employee emp where eatt.ASTCode=ast.ASTCode and eatt.ProjectCode=pjt.ProjectCode and eatt.EMPID=emp.EMPID and eatt.EMPID=? and eatt.Attendence_Date between ? and ? and eatt.isAproved='N' order by eatt.Attendence_Date";
	public static final String GET_ATT_STATUS_TYPE="select * from hrms_attendence_status_type";
	public static final String GET_ATT_STATUS="select * from hrms_attendence_status";
	public static final String GET_SINGLE_EMPLOYEE="select * from hrms_employee where EMPID=? and isActive='Y'";
	public static final String UPDATE_EMP_ATTENDANCE="update hrms_employee_attendance set Attedence_Status=?,intime=?,outtime=?,totaltime=?,Location=?,isAproved=?,ApprovedTime=?,ApprovedBy=?,ASTCode=?,ProjectCode=?,ManagerCode=? where Attendence_Date=? and EMPID=?";
	public static final String UPDATE_EMP_ATT_BY_HR="update hrms_employee_attendance set Attedence_Status=?,intime=?,outtime=?,totaltime=?,Location=?,isAproved=?,ApprovedTime=?,ApprovedBy=?,ASTCode=?,ProjectCode=?,userCode=? where Attendence_Date=? and EMPID=?";
	public static final String UPDATE_ALL_EMP_ATTENDANCE="update hrms_employee_attendance set isAproved=?, ApprovedTime=?,ApprovedBy=?,ManagerCode=? where Attendence_Date between ? and ? and EMPID=?";
	public static final String UPDATE_ALL_EMP_ATT_BY_HR="update hrms_employee_attendance set isAproved=?, ApprovedTime=?,ApprovedBy=?,userCode=? where Attendence_Date between ? and ? and EMPID=?";

	public static final String GET_EMPLOYEEATTENDANCE = "select ons.EMPID,emp.First_Name,att.Description,att.Attendence_Date,att.intime,att.outtime,att.totaltime,att.Location,att.Attedence_Status from hrms_employee emp join hrms_online_users ons on ons.EMPID=emp.EMPID join hrms_employee_attendance att on emp.EMPID=att.EMPID where ons.Username=? and ons.EMPID=?  and att.Attendence_Date between ? and ? and att.isAproved='N' and att.isPosted='N' order by att.Attendence_Date asc";
	public static final String GET_PROJECTMANAGERDETAILS = "select m.ManagerCode,case when m.LastName is null then m.FirstName else concat(m.FirstName,' ',m.LastName)end ManagerName from hrms_manager m join hrms_employee_manager_mapping emm on emm.ManagerId=m.ManagerCode and emm.EmployeeId=?";
	public static final String GET_ATTENDANCETYPEDETAILS = "select * from hrms_attendence_status_type";
	public static final String GET_ATTENDANCE_STATUS="select type from hrms_attendence_status";
	public static final String UPDATE_ATTENDANCE_DETAILS="update hrms_employee_attendance set intime=?,outtime=?,totaltime=?,Description=?,ManagerCode=?,ProjectCode=?, Attedence_Status=?, ASTCode=? ,isPosted='Y' where EMPID=? and Attendence_Date=?";

	public static final String GET_EMP_SPECIFIC_ATTENDENCE="select eatt.Attendence_Date,eatt.EMPID,eatt.Attedence_Status,eatt.intime,eatt.outtime,eatt.totaltime,eatt.Location,eatt.ASTCode,ast.StatusType,pjt.ClientCode,pjt.ClientName,emp.First_Name,eatt.isAproved,ast.ShortName from hrms_employee emp ,hrms_employee_attendance eatt left outer join hrms_attendence_status_type ast on eatt.ASTCode=ast.ASTCode left outer join hrms_client pjt on eatt.ProjectCode=pjt.ClientCode where  eatt.EMPID=emp.EMPID and eatt.EMPID like ? and eatt.Attendence_Date between ? and ? and isAproved like ? and eatt.EMPID in (select EmployeeId from hrms_employee_manager_mapping where ManagerId=?) order by eatt.Attendence_Date,emp.First_Name";
	
	public static final String GET_ATTENDANCE_NOT_APPROVED_BY_MANAGER="select hea.EMPID,max(PostedTime) PostedTime,he.First_Name,max(Attendence_Date) endDate,min(Attendence_Date) startDate from  hrms_employee_attendance hea,hrms_employee he where hea.EMPID=he.EMPID and hea.isPosted='Y' and hea.isAproved='N' and hea.EMPID in ( select e.EMPID from hrms_employee e,hrms_employee_manager_mapping em where e.EMPID=em.EmployeeId and em.ManagerId=? and isActive='Y') group by hea.EMPID,First_Name order by PostedTime desc";
	public static final String GET_NOT_APPROVED_EMPLOYEE_COUNT="select count(*) from ( select count(*) from  hrms_employee_attendance hea,hrms_employee he where hea.EMPID=he.EMPID and hea.isPosted='Y' and hea.isAproved='N' group by hea.EMPID,First_Name) s";
	public static final String GET_SINGLE_MANAGER="select * from hrms_manager where ManagerCode=? and isActive='Y'";

	//chnaged get notification count
	public static final String GET_NOT_APPROVED_ATTENDANCE_COUNT="select count(*) from hrms_employee_attendance where EMPID in (select EmployeeId from  hrms_employee_manager_mapping where  ManagerId=?) and isPosted='Y' and isAproved='N' group by EMPID";
	
	// for mail sending to employee
	public static final String GET_EMPLOYEE_USERNAME_PASSWORD = "select ou.Username,ou.password from hrms_online_users ou where ou.EMPID=? ";
	
	public static final String GET_ALL_CLIENTS ="select ClientCode,ClientName from hrms_client";
	
	
	
	//attendance approved by director
	public static final String GET_EMP_BASEDON_DIR="select e.EMPID,e.First_Name from hrms_employee e,hrms_manager m where e.EMPID=m.EMPID and  m.ManagerCode in (select ManagerCode from hrms_manager_director_mapping where DirectorCode=?)";
	public static final String GET_ALL_DIRECTORS="select d.DirectorCode,e.First_Name from hrms_director d,hrms_employee e where e.EMPID=d.EMPID and d.isActive='Y'";
	public static final String GET_SINGLE_DIRECTORS="select e.EMPID,e.First_Name,d.DirectorCode,d.Username from hrms_employee e,hrms_director d where e.EMPID=d.EMPID and d.DirectorCode=?";

	public static final String GET_EMP_OFFICIAL_ID="select Official_Email_ID from hrms_employee where EMPID=? and isActive='Y'";

	public static final String GET_EMP_ATTENDENCE_BY_MONTH="select eatt.Attendence_Date,eatt.EMPID,eatt.Attedence_Status,eatt.intime,eatt.outtime,eatt.totaltime,eatt.Location,eatt.ASTCode,ast.StatusType,eatt.ProjectCode,pjt.ProjectRefCode,emp.First_Name,eatt.isAproved,ast.ShortName from hrms_employee emp,hrms_employee_attendance eatt left outer join hrms_attendence_status_type ast on eatt.ASTCode=ast.ASTCode left outer join hrms_project pjt on eatt.ProjectCode=pjt.ProjectCode where  eatt.EMPID=emp.EMPID and eatt.EMPID=? and eatt.Attendence_Date between ? and ? order by eatt.Attendence_Date";
	public static final String GET_EMP_SPECIFIC_ATTENDENCE_BY_MONTH="select eatt.Attendence_Date,eatt.EMPID,eatt.Attedence_Status,eatt.intime,eatt.outtime,eatt.totaltime,eatt.Location,eatt.ASTCode,ast.StatusType,eatt.ProjectCode,pjt.ProjectRefCode,emp.First_Name,eatt.isAproved,ast.ShortName from hrms_employee emp ,hrms_employee_attendance eatt left outer join hrms_attendence_status_type ast on eatt.ASTCode=ast.ASTCode left outer join hrms_project pjt on eatt.ProjectCode=pjt.ProjectCode where  eatt.EMPID=emp.EMPID and eatt.EMPID=? and eatt.Attendence_Date between ? and ? and isAproved like ? order by eatt.Attendence_Date";

	
	public static final String GET_MGR_ATTENDANCE="select eatt.Attendence_Date,eatt.EMPID,eatt.Attedence_Status,eatt.intime,eatt.outtime,eatt.totaltime,eatt.Location,eatt.ASTCode,ast.StatusType,pjt.ClientCode,pjt.ClientName,emp.First_Name,eatt.isAproved,ast.ShortName from hrms_employee emp,hrms_employee_attendance eatt left outer join hrms_attendence_status_type ast on eatt.ASTCode=ast.ASTCode left outer join hrms_client pjt on eatt.ProjectCode=pjt.ClientCode where  eatt.EMPID=emp.EMPID and eatt.EMPID like ? and eatt.Attendence_Date between ? and ? and  eatt.EMPID in (select EMPID from hrms_manager where ManagerCode in (select ManagerCode from hrms_manager_director_mapping where DirectorCode=?)) order by eatt.Attendence_Date,emp.First_Name";





}
