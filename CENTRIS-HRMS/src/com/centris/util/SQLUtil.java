package com.centris.util;

public class SQLUtil {
 
		/*public static final String driver= "com.mysql.jdbc.Driver";
		public static final String url = "jdbc:mysql://localhost:3306/";
		public static final String dbName = "test";
		public static final String userName = "test"; 
		public static final String password = "test";
	
		
		public static final String loginDetails = "SELECT UserName, PassWord  from table1 WHERE UserId= ?";
		public static final String todayAttendence = "SELECT EMPID, EMPNAME, PHONE, EMAIL  from emp_list";
		public static final String getEmployee = "SELECT EMPNAME from emp_list";
		public static final String removeIDEmployee = "SELECT EMPID from emp_list WHERE EMPNAME=?";
		public static final String retrieveDetailAction = "SELECT EMPID, EMPNAME, PHONE, EMAIL  from emp_list WHERE EMPNAME=?";
		public static final String addEmployee = "INSERT INTO emp_list (EMPID, EMPNAME, PHONE, EMAIL) VALUES (?, ?, ?, ?)";
		public static final String loadAttendence = "INSERT INTO emp_attendence (EMPID, EMPNAME,  STATUS, REMARK, DATE) VALUES (?, ?, ?, ?, ?)";
		public static final String getreportAll = "SELECT EMPID, EMPNAME, DATE, STATUS  from emp_attendence";
		public static final String getrepNameStatus = "SELECT EMPID, EMPNAME, DATE, STATUS  from emp_attendence WHERE EMPNAME =? AND STATUS=?";
		public static final String getrepNameDate =	  "SELECT EMPID, EMPNAME, DATE, STATUS  from emp_attendence WHERE EMPNAME =? AND DATE=?";
		public static final String getDayReport = "SELECT EMPID, EMPNAME, DATE, STATUS  from emp_attendence WHERE DATE=?";
		public static final String getIndiReport = "SELECT EMPID, EMPNAME, DATE, STATUS  from emp_attendence WHERE EMPNAME =?";*/
	public static final String SELECTLOGSDATA ="select chk.USERID,chk.CHECKTIME,chk.CHECKTYPE,usrinfo.USERID,usrinfo.Badgenumber  from CHECKINOUT chk,USERINFO usrinfo where chk.USERID=usrinfo.USERID  order by chk.USERID";
	public static final String SATURDAYSHIFTCHECK ="update ai_emp_attendance ae INNER JOIN ai_emp_details ad ON ae.empid = ad.EMPID SET ae.status='Holiday' WHERE ad.EMPDEPARTMENT ='montessori' AND ae.DATE = ' ";
	public static final String SATURDAYSELECT ="SELECT AI_SHIFT_LTOC, AI_SHIFT_ETOG FROM ai_shift_deatails WHERE AI_SHIFT_NAME = 'SATURDAY'";
	public static final String SATURDAYEMPLOYEESHIFTMAPPING ="SELECT  ai_emp_details.EMPID, ai_emp_details.SHIFT_ID, ai_shift_deatails.AI_SHIFT_LTOC,ai_shift_deatails.AI_SHIFT_ETOG FROM ai_emp_details, ai_shift_deatails where ai_emp_details.SHIFT_ID= ai_shift_deatails.AI_SHIFT_ID and ai_emp_details.EMPID='";
	public static final String SELECTEMPTIME ="select AI_EMP_TIME from ai_bio_log_details where AI_EMP_ID = '";
}
