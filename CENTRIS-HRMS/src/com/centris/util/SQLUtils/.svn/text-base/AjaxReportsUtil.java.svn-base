/**
 * 
 */
package com.centris.util.SQLUtils;

/**
 * @author satish
 *
 */
public class AjaxReportsUtil {
	public static final String GET_MANAGER_BY_DIRECTOR_CODE="select hm.FirstName,hm.ManagerCode from hrms_manager_director_mapping hmdm,hrms_manager hm  where hm.ManagerCode=hmdm.ManagerCode and hmdm.DirectorCode=?";
	
	public static final String GET_PROJECT_BY_MANAGER_CODE="select pm.ProjectCode,p.Project_Name,p.ProjectRefCode from hrms_project p,hrms_project_manager_mapping pm where p.ProjectCode=pm.ProjectCode and pm.ManagerCode=? and p.Status='Y' and ProjectStatus='Approved'";
	public static final String GET_DIRECTOR_DETAILS_BY_ADMIN="select hd.DirectorCode,hd.Username from hrms_director hd where hd.CreatedBy=? and hd.isActive='Y'";
	public static final String GET_MANAGER_BY_DEPARTMENT_CODE="SELECT hm.FirstName,hm.ManagerCode from hrms_manager hm,hrms_department_mapping hmd where hmd.UserCode=hm.ManagerCode and hmd.DepartmentCode=?";
	public static final String GET_MANAGER_BY_DEPARTMENT_CODE_DIRECTOR="SELECT hm.FirstName,hm.ManagerCode from hrms_manager hm,hrms_department_mapping hmd,hrms_manager_director_mapping dm where hmd.UserCode=hm.ManagerCode and hmd.DepartmentCode=? and  hm.ManagerCode in (select ManagerCode from hrms_manager_director_mapping where DirectorCode=?)";
}
