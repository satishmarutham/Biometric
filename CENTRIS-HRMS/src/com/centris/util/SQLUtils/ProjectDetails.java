package com.centris.util.SQLUtils;

public class ProjectDetails {
	
	public static final String ADD_PROJECT="INSERT INTO hrms_project (ProjectCode,Project_Name,Location,ClientName,ProjectType,EndCustomer,projectHighLevelActivity,forFuturExpan,projectActivityCat,linkfinancialyear,ProjectRefCode,STATUS,CreatedBy,CreateTime,ProjectStatus,ReportingTo,PoNumber) VALUES(?,?,?,?,? ,? ,? ,? ,? ,? ,? ,'Y',?,?,?,?,?)";
	public static final String GET_ALL_PROJECT_BYUSER="SELECT * FROM hrms_project WHERE STATUS='Y' AND createdby = ? order by ProjectStatus='Created' desc ";
	public static final String GET_ALL_PROJECT_BYUSER_MAN="SELECT * FROM hrms_project WHERE STATUS='Y' AND (ProjectCode IN ( SELECT ProjectCode FROM hrms_project_manager_mapping WHERE ManagerCode =? ) or   ReportingTo=? ) order by ProjectStatus='Created' desc ";
	public static final String GET_ALL_PROJECT="SELECT * FROM hrms_project WHERE STATUS='Y' order by ProjectStatus='Created' desc ";
	public static final String GET_SINGLE_PROJECT="select * from hrms_project where ProjectCode=? and Status='Y'";
	public static final String UPDATE_PROJECT=" UPDATE hrms_project SET Project_Name=?,Location=?,ClientName=?,ProjectType= ?,EndCustomer=?,projectHighLevelActivity=?,forFuturExpan=?,projectActivityCat=? ,linkfinancialyear=? , ProjectRefCode=? , UpdatedBy=? ,UpdateTime= ?,ReportingTo=?,PoNumber=?  WHERE ProjectCode=? ";
	public static final String PROJECT_MANAGER_MAPPING_COUNT="select count(*) from hrms_project_manager_mapping where ProjectCode=?";
	public static final String DELETE_PROJECT="update hrms_project set Status='N' where ProjectCode=?";
	public static final String COUNT_PROJECTNAME="select count(*) from hrms_project where Project_Name=? and Status='Y'";
	public static final String COUNT_PROJECTNAME_UPDATE="select count(*) from hrms_project where Project_Name=? and ProjectCode!=? and Status='Y'";
	public static final String GET_ALL_PROJECT_BY_MANAGER="select pm.ProjectCode,p.Project_Name,p.ProjectRefCode from hrms_project p,hrms_project_manager_mapping pm where p.ProjectCode=pm.ProjectCode and pm.ManagerCode=? and p.Status='Y'";
	public static final String CHECK_PROJECTREFCODE="select count(*) from hrms_project where ProjectCode!=? and ProjectRefCode=? and Status='Y'";
	
	public static final String GET_PROJECT_REFCODE="SELECT ProjectCode,ProjectRefCode,CreatedBy FROM hrms_project WHERE ProjectCode = ? AND ProjectRefCode= ?";
	
	public static final String select_project ="SELECT ProjectCode PC,Project_Name PN,Location,ProjectRefName,ProjectRefCode FROM hrms_project WHERE CreatedBy ='MAN1'";
	
	public static final String GET_PROJECTS_BY_MGR_EMP="select p.ProjectCode,p.Project_Name,p.Location,p.ProjectRefCode from hrms_project p where p.ProjectCode in (select ProjectCode from hrms_project_manager_mapping where ManagerCode in (select ManagerCode from hrms_manager where EMPID=?))";

	public static final String GET_APPROVE_USERS = "select concat(m.FirstName,'-',e.bioid,'-','Manager')as name,m.ManagerCode as Id from hrms_manager  m,hrms_employee e where m.EMPID=e.EMPID and m.isActive='Y' union select concat(e.First_Name,'-',e.bioid,'-','Director')as name,d.DirectorCode as Id from hrms_director d,hrms_employee e where d.EMPID=e.EMPID and d.isActive='Y'";

	public static final String GET_SINGLE_MANAGER = "select FirstName,email from hrms_manager where ManagerCode=?";
	public static final String GET_SINGLE_DIRECTOR = "select e.First_Name,d.Username from hrms_employee e,hrms_director d where e.EMPID=d.EMPID and d.DirectorCode=?";
	public static final String UPDATE_PROJECT_STATUS = "update hrms_project set ApprovedBy=?,ProjectStatus=?,ApprovedTime=? where ProjectCode=?";
	public static final String UPDATE_PROJECT_WITH_CLOSED = " UPDATE hrms_project SET Project_Name=?,Location=?,ClientName=?,ProjectType= ?,EndCustomer=?,projectHighLevelActivity=?,forFuturExpan=?,projectActivityCat=? ,linkfinancialyear=? , ProjectRefCode=? , UpdatedBy=? ,UpdateTime= ?,ReportingTo=?,ClosedBy=?,ClosedTime=?,ProjectStatus=?,PoNumber=? WHERE ProjectCode=? ";
	
	public static final String GET_MANG_SEARCH_PROJECT = "SELECT * FROM hrms_project WHERE STATUS='Y' AND (ProjectCode IN ( SELECT ProjectCode FROM hrms_project_manager_mapping WHERE ManagerCode =? ) or   ReportingTo=? ) and (Project_Name like ? or  ProjectRefCode like ? or Location like ? or CreatedBy like ? )  order by ProjectStatus='Created' desc ";
	public static final String GET_SEARCH_PROJECT_DETAILS = "SELECT * FROM hrms_project WHERE STATUS='Y'  and   Project_Name like ? or  ProjectRefCode like ?  or Location like ? or CreatedBy like ?  order by ProjectStatus='Created' desc ";
	public static final String GET_CREATED_BY = "select CreatedBy from hrms_project where ProjectCode=?";
	public static final String GET_SINGLE_ADMIN = " select u.username,e.First_Name from hrms_user u,hrms_employee e where u.empId=e.EMPID and u.userCode=?";

	public static final String GET_PROJECTBY_DIR ="select pm.ProjectCode,p.Project_Name,p.ProjectRefCode from hrms_project p,hrms_project_manager_mapping pm where p.ProjectCode=pm.ProjectCode and pm.ManagerCode in (select ManagerCode from hrms_manager_director_mapping where DirectorCode=?) and p.Status='Y'";
	
	public static final String GET_PROJECTBY_EMP = "select pm.ProjectCode,p.Project_Name,p.ProjectRefCode from hrms_project p,hrms_project_manager_mapping pm where p.ProjectCode=pm.ProjectCode and pm.ManagerCode in (select ManagerId from hrms_employee_manager_mapping where EmployeeId=?) and p.Status='Y'";
}
