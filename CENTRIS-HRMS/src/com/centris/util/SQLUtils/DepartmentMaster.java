/**
 * 
 */
package com.centris.util.SQLUtils;

/**
 * @author sathish
 *
 */
public class DepartmentMaster {
	public static final String INSERT_DEPARTMENT="insert into hrms_department (DEPT_ID,DEPT_NAME,DESCRIPTION,CREATE_DATE,createdby) values(?,?,?,?,?)";
	public static final String CHECK_DEPARTMENT_DUPLICATE="select count(*) count from hrms_department where DEPT_NAME=? and DESCRIPTION=?";
	public static final String VALIDATE_DEPTNAME="select count(*) deptname from hrms_department where DEPT_NAME=?";
	
	
	
	
	public static final String UPDATE_DEPARTMENT="update  hrms_department set DEPT_NAME=?,DESCRIPTION=?,UpdatedBy=? where DEPT_ID=?";
	public static final String VALIDATE_DEPTNAME_UPDATE="select count(*) deptname from hrms_department  where DEPT_NAME=? and DEPT_ID!=?";
	public static final String EXIST_DEPARTMENT_EMP="select count(*) from hrms_employee where DEPT_ID=?";
	public static final String EXIST_DEPARTMENT_HOLIDAY="select count(*) from hrms_holidaymaster where DEPT_ID=?";
	public static final String deleteDep = "delete from hrms_department where DEPT_ID =? and DEPT_ID  not in(select DEPT_ID from hrms_employee where DEPT_ID=?)";
	
	
	public static final String GET_ALL_DEPARTMENT="select d.DEPT_ID,DEPT_NAME,d.DESCRIPTION,d.LOCAL_MNGR_MAIL,d.HR_MNGR_MAIL,d.ONSITE_MNGR_MAIL from  hrms_department d ";
	public static final String GET_SINGLE_DEPT="select DEPT_ID,DEPT_NAME from hrms_department where DEPT_ID like ?";

}
