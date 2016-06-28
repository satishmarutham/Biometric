package com.centris.util.SQLUtils;

public class ProjectManagerMappingSQLutil {

	public static final String GET_MANAGER = "select m.ManagerCode,concat(e.First_Name,'-',e.bioid) as managername from hrms_manager m,hrms_employee e where m.isActive='Y' and m.EMPID=e.EMPID and e.isActive='Y' order by managername";
	public static final String GET_PROJECT_DATA = "select p.ProjectCode,p.ProjectRefCode from hrms_project p where p.ProjectCode NOT IN(select pm.ProjectCode from hrms_project_manager_mapping pm) and p.Status='Y' and  ProjectStatus='Approved'";
	public static final String INSERT_PROJECT_MANAGER = "insert into hrms_project_manager_mapping(ManagerCode,ProjectCode,createdby,createtime) values(?,?,?,now())";
	public static final String GET_MAPPED_PROJECT = "select p.ProjectCode,p.ProjectRefCode from hrms_project_manager_mapping pm,hrms_project p where  pm.ManagerCode=? and  p.ProjectCode=pm.ProjectCode";
	public static final String DELETE_PROJECT_MANAGER = "delete from hrms_project_manager_mapping where ManagerCode=?";
	
	public static final String GET_PROJECTHEAD = "select ProjectHeadCode,FirstName from hrms_projecthead where isActive='Y'";
	
	public static final String GET_MGRID_BY_EMPID ="select ManagerCode from hrms_manager where isActive='Y' and EMPID=?";

	public static final String GET_DIRECTOR = "select d.DirectorCode,concat(e.First_Name,'-',e.bioid) as directorname from hrms_director d,hrms_employee e where d.isActive='Y' and d.EMPID=e.EMPID and e.isActive='Y' order by directorname";

	public static final String GET_ALL_PROJECTS = "select ProjectCode,ProjectRefCode from hrms_project where Status='Y' and  ProjectStatus='Approved' ";


}
