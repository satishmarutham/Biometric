package com.centris.util.SQLUtils;

public class AttendanceStatusType {

	/* chiru Attendance Status Report */

	public static final String ADD_ATTENDANCE_STATUS_DETAILS = "insert into hrms_attendence_status_type(ASTCode,StatusType,ShortName,Description,CreatedBy,CreateTime)values(?,?,?,?,?,now())";
	public static final String GET_ATTENDANCE_STATUS_DETAILS = "select ASTCode,StatusType,ShortName,Description from hrms_attendence_status_type";
	public static final String DELETE_ATTENDANCE_STATUS_DETAILS = "delete from hrms_attendence_status_type where ASTCode=?";
	public static final String EDIT_ATTENDANCE_STATUS_DETAILS = "select ASTCode,StatusType,ShortName,Description from hrms_attendence_status_type where ASTCode=?";
	public static final String UPDATE_ATTENDANCE_STATUS_DETAILS = "update hrms_attendence_status_type set StatusType=?,ShortName=?,Description=?,UpdatedBy=?,UpdatedTime=? where ASTCode=?";
	public static final String VALIDATE_ATTENDANCE_STATUS_TYPE = "select count(*) from hrms_attendence_status_type where StatusType=?";
	public static final String VALIDATE_ATTENDANCE_SHORT_NAME = "select count(*) from hrms_attendence_status_type where ShortName=?";
	public static final String VALIDATE_STATUS_TYPE_AND_SHORT_NAME = "select count(*) from hrms_attendence_status_type  where  StatusType=? and ASTCode !=? or ShortName=? and ASTCode !=?";
	/* chiru Attendance Status Report */
}
