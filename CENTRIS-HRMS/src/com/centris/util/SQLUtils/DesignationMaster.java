/**
 * 
 */
package com.centris.util.SQLUtils;

/**
 * @author sathish
 *
 */
public class DesignationMaster {
	public static final String INSERT_DESIGNATION_DETAILS = "insert into hrms_designation (DesignationCode,designationName,description,createdate,isActive,CreatedBy,ReportingTo) values(?,?,?,?,?,?,?)";
	public static final String VALIDE_DES_NAME = "select count(*) desname from hrms_designation where designationName=? and isActive='Y'";
	public static final String GET_DESIGNATION_DETAILS = "select DesignationCode,designationName,description,createdate,CreatedBy,ReportingTo from hrms_designation where isActive='Y' order by DesignationCode asc";
	public static final String GET_SINGLE_DESIGNATION="select designationName from hrms_designation where DesignationCode=?";
	public static final String DELETE_DESIGNATION = "update hrms_designation set isActive=? where DesignationCode =? and isSA!='Y'";
	public static final String CHECK_DESIGNATION_MAP = "select count(*) desname from hrms_employee where DesignationCode=?";
	public static final String EDIT_DESIGNATION = "select DesignationCode,designationName,description,createdate,CreatedBy,ReportingTo from hrms_designation where DesignationCode=?";
	public static final String UPDATE_DESIGNATION = "update hrms_designation set designationName= ?,description=?,isActive=?,ReportingTo=?,ModifiedBy=?,ModifiedTime=? where DesignationCode =?";
	public static final String VALIDATE_DESIGNATION_UPDATE="select count(*) desname from hrms_designation where designationName=? and DesignationCode!=? and isActive='Y'";
	
	public static final String VALIDATE_DESID = "select count(*) desname from hrms_designation where DesignationCode=?";
	
	public static final String GET_REPORTINGTO_BY_ID="select designationName from hrms_designation where DesignationCode=?";
	
	
	
}
