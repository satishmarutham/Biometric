package com.centris.util.SQLUtils;

import com.centris.util.JPropertyReader;

public class SQLutilConstants {
	
	public static final String LOGINCHECK = "SELECT u.userCode,u.UserName, u.PassWord ,u.roleCode,r.RoleName roleName,u.Location from hrms_user u,hrmsi_role r WHERE u.RoleCode=r.RoleCode and UserName= ? AND password= ?";
	public static final String GET_USER_DETAILS="select au.userCode,au.username,au.Location LocationCode,au.Location LocationName,au.roleCode,ar.RoleName,group_concat(rpm.permissionCode order by rpm.permissionCode ) userPermissionCode,group_concat(rpm.shortName order by rpm.permissionCode) userPermissionShortName,group_concat(bp.permission order by rpm.permissionCode) userPermissionName,group_concat(rpm.isApplicable order by rpm.permissionCode) isapplicablestatus from hrms_user au,hrmsi_role ar,hrms_role_permissions_mapping rpm,hrms_permissions bp where   au.roleCode=ar.RoleCode and au.roleCode=rpm.roleCode and rpm.permissionCode=bp.PermissionCode and au.username=? and au.password=? group by au.userCode,au.username,au.Location,au.Location,au.roleCode,ar.RoleName";
	//select au.userCode,au.username,au.Location LocationCode,el.Location LocationName,au.roleCode,ar.RoleName,group_concat(rpm.permissionCode order by rpm.permissionCode) userPermissionCode,group_concat(rpm.shortName order by rpm.permissionCode) userPermissionShortName,group_concat(bp.permission order by rpm.permissionCode) userPermissionName from ai_user au,ai_emp_location el,ai_role ar,ai_bio_role_permissions_mapping rpm,ai_bio_permissions bp  where au.Location=el.LocationCode and au.roleCode=ar.RoleCode and au.roleCode=rpm.roleCode and rpm.isApplicable='true' and rpm.permissionCode=bp.PermissionCode and au.username=? and au.password=? group by au.userCode,au.username,au.Location,el.Location,au.roleCode,ar.RoleName
//	public static final String driver = JPropertyReader
//			.getProperty("mySqlDriver");
//	public static final String url = JPropertyReader.getProperty("HOST_NAME");
//	public static final String dbName = JPropertyReader
//			.getProperty("database");
//	public static final String userName = JPropertyReader
//			.getProperty("USER_NAME");
//	public static final String password = JPropertyReader
//			.getProperty("USER_PASSWORD");
	
	
	public static String INSERT_LOGDETAILS="insert into ai_bio_log_details(AI_EMP_ID,AI_EMP_DATE,AI_EMP_TIME,AI_EMP_ENTRY_USER,ETL_CODE) values(?,?,?,?,?)";
	public static String INSERT_LOGDETAILS_new="insert into ai_bio_log_details(AI_EMP_ID,AI_EMP_DATE,AI_EMP_TIME,BIO_SN,ETL_CODE,LOCATION_CODE,AI_EMP_ENTRY_USER,ADMS_CHK_ID) values(?,?,?,?,?,?,?,?)";
	
	public static String SELECT_ALL_LOCATIONS="select LocationCode,BioMachineNumber from ai_emp_location where isActive='Y'";
	public static String calculate_latest_timestamp="select ADMS_CHK_ID,AI_EMP_DATE,AI_EMP_TIME from ai_bio_log_details where AI_EMP_DATE=(select max(AI_EMP_DATE) from ai_bio_log_details) order by AI_EMP_DATE,AI_EMP_TIME desc limit 1";
	public static String getCurrentSessionFirstTimeStamp="select AI_EMP_DATE,AI_EMP_TIME  from ai_bio_log_details where ETL_CODE=? order by AI_EMP_DATE,AI_EMP_TIME limit 1";
	public static String updateAuditDates = "insert into ai_bio_audit_dates (aduit_date,remarks,ETL_CODE) values(?,?,?)";
	public static String checkForData = "select count(*) from ai_bio_log_details where AI_EMP_DATE=?";
	public static String checkForDateIsPresentOrNot = "select aduit_date from ai_bio_audit_dates where aduit_date = ?";
	

	//Util constants for UserMaster start ********  written by seshu  
	
	public static final String ADD_USER = "insert into ai_user(userCode,username,password,createuser,roleCode,Location,groupCode) values(?,?,?,?,?,?,?)";	
	public static final String GET_USERS="select bu.userCode,bu.username,bu.password,bu.roleCode,bu.Location as LocationCode,br.RoleName,ael.Location,ag.Gorupid,ag.GroupName from ai_user bu,ai_role br,ai_emp_location ael,onsite_group ag where br.RoleCode=bu.roleCode and bu.Location=ael.LocationCode and bu.groupCode=ag.Gorupid";
	public static final String EDIT_USER="update ai_user set username=?,password=?,modifyuser=?,modifydate =?,roleCode=?,Location=?,groupCode=? where userCode=?";
	public static final String DELETE_USER="delete from ai_user where userCode=?";
	public static final String VALIDATE_USER_NAME="select count(*) username from ai_user where username=?";
	public static final String VALIDATE_USER_NAME_UPDATE="select count(*) username from ai_user where username=? and userCode!=?";
	public static final String GET_GROUP_CODE="select Gorupid,GroupName from onsite_group";

	
	//Util constants for UserMaster end
	
	//Util constants for Location master start ********  written by seshu
			
			public static final String INSERT_LOCATION="insert into ai_emp_location(LocationCode,Location,LocationNumber,PropriterAddress,PhoneNo,PropriterName,BioMachineNumber,ContactPerson,createUser,createdate,isActive,TSM_TSE_Name,ContactNumber,EmployeeStrength,Bio_Id_Index_Number,DSE_S_Count) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			public static final String SELECT_LOCATION="select LocationCode,Location,LocationNumber,PropriterAddress,PhoneNo,PropriterName,BioMachineNumber,ContactPerson,TSM_TSE_Name,ContactNumber,EmployeeStrength,Bio_Id_Index_Number,DSE_S_Count from ai_emp_location where isActive='Y' and LocationCode in (select LocationCode from onsite_groupmapping where Groupid=?) order by length(LocationCode),LocationCode";
			public static final String SELECT_SINGLE_LOCATION="select LocationCode,Location,LocationNumber,PropriterAddress,PhoneNo,PropriterName,BioMachineNumber,ContactPerson,TSM_TSE_Name,ContactNumber,EmployeeStrength,Bio_Id_Index_Number,DSE_S_Count from ai_emp_location where LocationCode=? and isActive='Y'";
			public static final String UPDATE_LOCATION="update ai_emp_location set Location=?,LocationNumber=?,PropriterAddress=?,PhoneNo=?,PropriterName=?,BioMachineNumber=?,ContactPerson=?,TSM_TSE_Name=?,ContactNumber=?,EmployeeStrength=?,Bio_Id_Index_Number=?,DSE_S_Count=?,modifiedby=?,modifieddate=? where LocationCode=?";
			public static final String DELETE_LOCATION="update ai_emp_location set isActive='N',modifiedby=?,modifieddate=? where LocationCode=?";
			public static final String VALIDATE_LOCATIONNAME="select count(*) locationname from ai_emp_location where Location=?";
			public static final String VALIDATE_LOCATIONNAME_UPDATE="select count(*) locationname from ai_emp_location where Location=? and LocationCode!=?";
			public static final String VALIDATE_LOCATIONID="select count(*) locaid from ai_emp_location where LocationCode=?";
			public static final String VALIDATE_LOCATIONNUMBER="select count(*) locationnumber from ai_emp_location where LocationNumber=?";
			public static final String VALIDATE_LOCATIONNUMBER_UPDATE="select count(*) locationnumber from ai_emp_location where LocationNumber=? and LocationCode!=?";
			public static final String VALIDATE_MACHINENUMBER="select count(*) machinenumber from ai_emp_location where BioMachineNumber=?";
			public static final String VALIDATE_MACHINENUMBER_UPDATE="select count(*) machinenumber from ai_emp_location where BioMachineNumber=? and LocationCode!=?";
			public static final String CHECK_LOCATION_FOR_EMP="select count(*) from ai_emp_details where Location=?";
			public static final String CHECK_LOCATION_FOR_SHIFT="select count(*) from ai_shift_deatails where Location=?";
			public static final String CHECK_LOCATION_FOR_DEPT="select count(*) from ai_bio_department where LOCATION=?";
			public static final String CHECK_LOCATION_FOR_GROUPMAPPING="select count(*) from onsite_groupmapping where LocationCode=?";
			public static final String CHECK_LOCATION_FOR_USER="select count(*) from ai_user where Location=?";
			public static final String CHECK_LOCATION_EXIST="select count(*) from ai_emp_location where Location=? and LocationNumber=? and PropriterAddress=? and PhoneNo=? and PropriterName=? and BioMachineNumber=? and ContactPerson=? and isActive='N'";
			public static final String CHECK_LOCATIONACTIVE="update ai_emp_location set isActive='Y' where Location=? and LocationNumber=? and BioMachineNumber=?";
			public static final String CHECK_BIOIDINDEX="select count(*) from ai_emp_location where Bio_Id_Index_Number=?";
			public static final String CHECK_BIOIDINDEX_UPDATE="select count(*) from ai_emp_location where Bio_Id_Index_Number=? and LocationCode!=?";
			public static final String SELECT_DEACTIVE_LOCATION="select LocationCode,Location,LocationNumber,PropriterAddress,PhoneNo,PropriterName,BioMachineNumber,ContactPerson,TSM_TSE_Name,ContactNumber,EmployeeStrength,Bio_Id_Index_Number from ai_emp_location where isActive='N'";
			public static final String ACTIVATE_LOCATION="update ai_emp_location set isActive='Y',modifiedby=?,modifieddate=? where Location=?";
			public static final String GET_ALL_LOCATIONS="select LocationCode,Location,LocationNumber,PropriterAddress,PhoneNo,PropriterName,BioMachineNumber,ContactPerson,TSM_TSE_Name,ContactNumber,EmployeeStrength,Bio_Id_Index_Number from ai_emp_location where isActive='Y'";
			
			//Util constants for Location master end
	
	
	//Util constants for Designation Master start ********* written by seshu 
			public static final String INSERT_DESIGNATION_DETAILS = "insert into ai_emp_designation (designationId,designationName,description,createuser,isActive) values(?,?,?,?,?)";
			public static final String GET_DESIGNATION_DETAILS = "select designationId,designationName,description,createdate,createuser from ai_emp_designation where isActive='Y' order by designationName asc";
			public static final String VALIDE_DES_NAME = "select count(*) desname from ai_emp_designation where designationName=? and isActive='Y'";
			public static final String EDIT_DESIGNATION = "select designationId,designationName,description,createdate,createuser from ai_emp_designation where designationId=?";
			public static final String DELETE_DESIGNATION = "update ai_emp_designation set isActive=? where designationId =?";
			public static final String VALIDATE_DESID = "select count(*) desname from ai_emp_designation where designationId=?";
			public static final String UPDATE_DESIGNATION = "update ai_emp_designation set designationName= ?,description=?,isActive=? where designationId =?";
			public static final String CHECK_DESIGNATION_MAP = "select count(*) desname from ai_emp_details where EMPDESIGNATION=?";
			public static final String VALIDATE_DESIGNATION_UPDATE="select count(*) desname from ai_emp_designation where designationName=? and designationId!=? and isActive='Y'";
			public static final String GET_SINGLE_DESIGNATION="select designationName from ai_emp_designation where designationId=?";

	//Util constants for Designation master end
	
	//Util constants for Add employee start ********* written by seshu 
	
			public static final String EMAILCOUNT = "SELECT count(*) FROM ai_emp_details where EMAIL=?";
			public static final String EMPREGCOUNT = "SELECT count(*) FROM ai_emp_details where EMP_REGISTRATION_NUMBER=?";
			public static final String EMPIDCOUNT = "SELECT count(*) FROM ai_emp_details where EMPID=?";
			public static final String REGISTER_EMPLOYEE = "INSERT INTO ai_emp_details (EMPID, EMPNAME, PHONE, EMAIL,SHIFT_ID,CREATEUSER,CREATEDATE,EMPADDRESS,EMPDESIGNATION,DEPARTMENT,DOB ,DOJ,FATHERNAME,Location,iSinMultiLocations,EMP_REGISTRATION_NUMBER,isActive) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			public static final String GET_MODIFYEMPLOYEE_DETAILS="select distinct e.Location, e.EMPID,e.EMPNAME,e.PHONE,e.EMAIL,e.SHIFT_ID,s.AI_SHIFT_NAME ,e.EMPDESIGNATION,e.DEPARTMENT,e.EMPADDRESS,e.DOB,e.DOJ,e.FATHERNAME,e.EMP_REGISTRATION_NUMBER,e.iSinMultiLocations,l.Location from ai_emp_details e,ai_shift_deatails s,ai_emp_location l where e.EMPID=? and e.SHIFT_ID=s.AI_SHIFT_ID and e.Location=l.LocationCode";
			public static final String INSERT_MODIFY_EMPLOYEE="update ai_emp_details set EMPNAME=?,FATHERNAME=?,PHONE=?,EMAIL=?,DOB=?,DOJ=?,EMPADDRESS=?,EMPDESIGNATION=?,DEPARTMENT=?,Location=?,SHIFT_ID=?,MODIFIEDBY=?,MODIFIEDDATE=?,iSinMultiLocations=?,EMP_REGISTRATION_NUMBER=?  where EMPID=?";
			public static final String UPDATE_EMAILCOUNT = "SELECT count(*) FROM ai_emp_details where EMAIL=? and EMPID!=?";
			public static final String UPDATE_EMPREGCOUNT = "SELECT count(*) FROM ai_emp_details where EMP_REGISTRATION_NUMBER=? and EMPID!=?";
			public static final String GET_REMOVE_EMPLOYEE="select e.EMPID,e.EMPNAME,e.PHONE,e.EMAIL,s.AI_SHIFT_ID ,s.AI_SHIFT_NAME,d.DEPT_ID,d.DEPT_NAME,l.LocationCode,l.Location from ai_emp_details e,ai_shift_deatails s,ai_bio_department d,ai_emp_location l where e.SHIFT_ID=s.AI_SHIFT_ID and e.DEPARTMENT=d.DEPT_ID and e.Location=l.LocationCode  and e.EMPNAME like ?   and  e.isActive ='Y' and e.Location in(select LocationCode from onsite_groupmapping where Groupid=?)  order by e.EMPNAME limit ?";
			public static final String REMOVE_EMPLOYEE="update ai_emp_details  set isActive ='N',MODIFIEDBY=?,MODIFIEDDATE=?  where EMPID=?";
			public static final String DISPLAY_ALL_EMPLOYEES="SELECT e.EMPNAME,e.EMPID,s.AI_SHIFT_NAME,e.EMPLOYEETYPE,d.DEPT_NAME,l.LocationCode,l.Location FROM ai_emp_details e,ai_bio_department d,ai_shift_deatails s,ai_emp_location l where e.SHIFT_ID=s.AI_SHIFT_ID and d.DEPT_ID=e.DEPARTMENT and e.Location=l.LocationCode and e.isActive='Y' and e.Location in(select LocationCode from onsite_groupmapping where Groupid=?) ORDER BY e.EMPID";
			public static final String SEARCH_DISPLAY_ALL_EMPLOYEE="SELECT e.EMPNAME,e.EMPID,s.AI_SHIFT_NAME,e.EMPLOYEETYPE,d.DEPT_NAME,l.LocationCode,l.Location FROM ai_emp_details e,ai_shift_deatails s,ai_bio_department d,ai_emp_location l where e.isActive='Y' and e.SHIFT_ID=s.AI_SHIFT_ID and d.DEPT_ID=e.DEPARTMENT AND e.Location=l.LocationCode AND (e.EMPNAME LIKE ? OR e.EMPID LIKE ? OR s.AI_SHIFT_NAME LIKE ? OR d.DEPT_NAME LIKE ? OR l.Location LIKE ?)";
			public static final String GET_MODIFYEMPFOR_ALLEMP="select distinct l.LocationCode,l.Location,e.EMPID,e.EMPNAME,e.PHONE,e.EMAIL,s.AI_SHIFT_ID,s.AI_SHIFT_NAME,d.designationId,d.designationName,dep.DEPT_ID,dep.DEPT_NAME,e.EMPADDRESS,e.DOB,e.DOJ,e.FATHERNAME,e.EMP_REGISTRATION_NUMBER,e.iSinMultiLocations from ai_emp_details e,ai_shift_deatails s,ai_bio_department dep,ai_emp_location l,ai_emp_designation d where e.SHIFT_ID=s.AI_SHIFT_ID and  e.DEPARTMENT=dep.DEPT_ID and e.Location=l.LocationCode and e.EMPDESIGNATION=d.designationId and e.EMPID=?";
			public static final String CHECK_EMP_EXIST="select count(*) from ai_emp_details where EMPID=? and EMP_REGISTRATION_NUMBER=? and EMPNAME=? and FATHERNAME=? and PHONE=? and EMAIL=? and DOB=? and DOJ=? and EMPDESIGNATION=? and DEPARTMENT=? and Location=? and SHIFT_ID=? and EMPADDRESS=? and iSinMultiLocations=? and isActive='N'";
			public static final String ACTIVATE_EMPLOYEE="update ai_emp_location set isActive='Y' where EMPID=? and EMAIL=? and EMP_REGISTRATION_NUMBER=?";
			public static final String DEACTIVE_EMPLOYEES="SELECT e.EMPID,e.EMPNAME,e.EMPID,s.AI_SHIFT_NAME,e.EMPLOYEETYPE,d.DEPT_NAME,l.LocationCode,l.Location,des.designationName,des.designationId FROM ai_emp_details e,ai_bio_department d,ai_shift_deatails s,ai_emp_location l,ai_emp_designation des where e.SHIFT_ID=s.AI_SHIFT_ID and des.designationId=e.EMPDESIGNATION and d.DEPT_ID=e.DEPARTMENT and e.Location=l.LocationCode and e.isActive='N' and e.Location in(select LocationCode from onsite_groupmapping where Groupid=?) ORDER BY e.EMPID";
			public static final String UPDATE_DEACTIVEEMPLOYEES="update ai_emp_details set isActive='Y',MODIFIEDBY=?,MODIFIEDDATE=? where EMPID=?";
			public static final String EMP_LOCATION_MAPPING="insert into ai_bio_employee_locations_mapping(empid,LocationCode,createdby) values (?,?,?)";
			public static final String GET_USERID="select userCode from ai_user where username=?";
			public static final String GET_LOCATIONSNAMES="select Location from ai_emp_location where LocationCode=?";
			public static final String GET_LOCATIOM_EMP_MAPPING="select elm.LocationCode,l.Location from ai_bio_employee_locations_mapping elm,ai_emp_location l where elm.empid=? and elm.LocationCode=l.LocationCode";
			public static final String 	GET_MODIFY_EMPLOYEE="select e.EMPID,e.EMPNAME from ai_emp_details e where e.EMPNAME  like ? and e.isActive='Y' and e.Location in(select LocationCode from onsite_groupmapping where Groupid=?) order by EMPNAME limit ?";
			public static final String DELETE_LOCATION_EMP_MAPPING="delete from ai_bio_employee_locations_mapping where empid=?";
			public static final String GET_LOCATIONINDEXID="select Bio_Id_Index_Number,Location from ai_emp_location where LocationCode=?";
			//Util constants for Add employee end ********* written by seshu 
	
	//HolidayMaster start written by seshu
			
			public static final String GET_ALL_YEARS="select accyear from onsite_accyear";
			public static final String INSERT_HOLIDAY="insert into onsite_holidaymaster(DEPT_ID,CURRENT_YEAR, HOLIDAY_DATE, WEEKDAY, HOLIDAY_NAME,CREATEDBY)values(?,?,?, ?, ?,?)";
			public static final String GET_ALL_HOLIDAYS="select distinct bd.DEPT_ID,bd.DEPT_NAME,HOLIDAY_DATE,HOLIDAY_NAME,WEEKDAY from onsite_holidaymaster hm,ai_bio_department bd where hm.DEPT_ID=bd.DEPT_ID and hm.DEPT_ID like ? and hm.CURRENT_YEAR=?";
			public static final String GET_EDIT_HOLIDAY="select DEPT_ID,HOLIDAY_DATE,WEEKDAY,HOLIDAY_NAME,CURRENT_YEAR from onsite_holidaymaster where HOLIDAY_DATE=?";
			public static final String DELETE_SINGLE_HOLIDAY="delete from onsite_holidaymaster where HOLIDAY_DATE=? and DEPT_ID=?";
			public static final String DATE_VALIDATE="select count(*) from onsite_holidaymaster where HOLIDAY_DATE=? and DEPT_ID=?";
			public static final String GET_DISTINCT_HOLIDAYLIST="select distinct HOLIDAY_DATE,DEPT_ID from onsite_holidaymaster";
			public static final String UPDATE_HOLIDAY="UPDATE onsite_holidaymaster SET WEEKDAY= ?,HOLIDAY_NAME=?,HOLIDAY_DATE=?,MODIFIED_BY=?,MODIFIED_DATE=? WHERE HOLIDAY_DATE= ? and DEPT_ID=?";
			
			//HolidayMaster end written by seshu		
	
			//Department Master start by seshu
			
			public static final String GET_ALL_DEPARTMENT="select d.DEPT_ID,DEPT_NAME,d.DESCRIPTION,l.LocationCode,l.Location from  ai_bio_department d,ai_emp_location l where d.LOCATION=l.LocationCode";
			public static final String INSERT_DEPARTMENT="insert into ai_bio_department (DEPT_ID,DEPT_NAME, DESCRIPTION, LOCATION,CREATED_BY)values(?,?,?, ?,?)";
			public static final String VALIDATE_DEPTNAME="select count(*) deptname from ai_bio_department where dept_name=?";
			public static final String UPDATE_DEPARTMENT="update  ai_bio_department set DEPT_NAME=?,DESCRIPTION=?,LOCATION=?,MODIFIED_BY=?,MODIFIED_DATE=? where dept_id=?";
			public static final String VALIDATE_DEPTNAME_UPDATE="select count(*) deptname from ai_bio_department where dept_name=? and DEPT_ID!=?";
			public static final String EXIST_DEPARTMENT_EMP="select count(*) from ai_emp_details where DEPARTMENT=?";
			public static final String EXIST_DEPARTMENT_HOLIDAY="select count(*) from onsite_holidaymaster where DEPT_ID=?";
			
			
			//WEEKOFF MASTER WRITTEN BY SESHU
			
			public static final String GET_ALL_EMPLOYESS_WEEKOFF="select e.EMPID,e.EMPNAME,e.PHONE,e.EMAIL,s.AI_SHIFT_ID ,s.AI_SHIFT_NAME,d.DEPT_ID,d.DEPT_NAME,l.LocationCode,l.Location from ai_emp_details e,ai_shift_deatails s,ai_bio_department d,ai_emp_location l where e.SHIFT_ID = s.AI_SHIFT_ID and e.DEPARTMENT = d.DEPT_ID and l.LocationCode=e.Location and e.EMPNAME like ? and e.isActive='Y' and e.Location in(select LocationCode from onsite_groupmapping where Groupid=?) order by e.EMPNAME limit ?";
	
		
	

	public static final String selectDistinctNotEmpID = "select Distinct(EMPID) from ai_emp_details where Location like ? and EMPNAME not in(?)";
	public static final String selectDistinctEmpID = "select Distinct(EMPID) from ai_emp_details where  Location like ? and EMPID= ?";
	public static final String selectDistinctDate = "select Distinct(DATE) from ai_emp_attendance where DATE= ?";
	public static final String delectDistinctDate = "delete from ai_emp_attendance where DATE= ?";
	public static final String loginDetails = "SELECT UserName, PassWord  from ai_user WHERE UserId= ?";
	public static final String todayAttendence = "SELECT EMPID, EMPNAME, PHONE, EMAIL  from ai_emp_details where  Location like ? ORDER BY EMPNAME";
	public static final String modifyAttendence = "SELECT EMPID, EMPNAME, REMARK, STATUS from ai_emp_attendance WHERE DATE = ? ORDER BY EMPNAME";

	public static final String getEmployee = "SELECT EMPNAME from ai_emp_details where  Location like ? ORDER BY EMPNAME";
	public static final String getEmployeeID = "select EMPID from ai_emp_details where EMPLOYEETYPE='Normal' ORDER BY EMPNAME";
	public static final String getEmployeeIDShiftID = "select empid from ai_emp_details where  SHIFT_ID=? and EMPLOYEETYPE='Normal'";
	public static final String removeIDEmployee = "SELECT EMPNAME from ai_emp_details WHERE  Location like ? and  EMPID=?";
	// public static final String retrieveDetailAction =
	// "SELECT EMPID, EMPNAME, PHONE, EMAIL,SHIFT_ID,EMPLOYEETYPE,EMPADDRESS,EMPDESIGNATION,DEPARTMENT from ai_emp_details WHERE EMPID=?";

	public static final String ShiftEmployeeMapping = "INSERT INTO shift_emp_mapping (SHIFT_EMP_ID ,SHIFT_ID ,CREATED_USER,CREATED_TIME) VALUES ( ?,?,?,now())";
	public static final String loadAttendence = "INSERT INTO ai_emp_attendance (EMPID, EMPNAME,  STATUS, REMARK, DATE) VALUES (?, ?, ?, ?, ?)";
	public static final String getreportAll = "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance order by DATE asc";
	public static final String getrepNameStatus = "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance WHERE EMPNAME =? AND STATUS=? order by  DATE asc";
	public static final String getrepNameDate = "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance WHERE EMPNAME =? AND DATE=? order by DATE asc";
	public static final String getDayReport = "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance WHERE DATE=? order by DATE asc";
	public static final String getMonthReport = "select * from ai_emp_attendance where DATE like ? order by DATE asc";
	public static final String getIndiMonthReport = "select * from ai_emp_attendance where DATE like ? AND EMPNAME =? order by DATE asc";
	public static final String changePassword = "select password from ai_user";
	public static final String SetPassword = "update ai_user set password= ? where password = ?";

	public static final String getIndiReport = "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance WHERE EMPNAME =?";
	public static final String EMP_ID_VALIDATE = "select * from ai_emp_details where  Location like ? and empid = ?";
	public static final String EMP_DESIGNATION = "select designationId,designationName from ai_emp_designation  where isActive='Y'";
	public static final String EMP_CATEGORY = "select category_id,category_name from ai_emp_category";
	public static final String EMP_PAYMENTTYPE = "select payment_type_id,payment_type_name from ai_emp_paymenttype";
	public static final String MODIFY_ATTEND = "UPDATE ai_emp_attendance SET EMPID= ? , DATE= ?, STATUS = ? , REMARK = ?, modifyuser=?, modifydate=? WHERE EMPNAME = ? AND DATE= ?";

	// public static final String EMP_MODIFY =
	// "UPDATE ai_emp_details SET  EMPNAME=?, PHONE=?, EMAIL=?,SHIFT_ID=?,CREATEUSER=?,CREATEDATE=?,EMPLOYEETYPE=?,EMPADDRESS=?,EMPDESIGNATION=?,DEPARTMENT=?,DOB =?,DOJ=?,FATHERNAME=?,EMPLOYEE_CATEGORY=?,PAYMENT_TYPE=?,BASIC=?,HRA=?,CONVEYANCE=?,ALLOWANCE=?,MEDICAL=?,GROSS_SALARY=?,PF=?,INCOME_TAX=?,PROF_TAX=?,LEAVE_DEDUCTION=?,OTHER_DEDUCTION=?,PF_EMP_CONTRIBUTION=?   WHERE EMPID = ?";

	public static final String UPDATE_FLAT_EMPLOYEE = "  UPDATE ai_emp_details SET  EMPNAME=?,  PHONE=?,  EMAIL=?, SHIFT_ID=?, CREATEUSER=?, CREATEDATE=?, EMPLOYEETYPE=?, EMPADDRESS=?, EMPDESIGNATION=?, DEPARTMENT=?, DOB =?, DOJ=?, FATHERNAME=?, EMPLOYEE_CATEGORY=?, PAYMENT_TYPE=?, BASIC=?, HRA=?, CONVEYANCE=?, ALLOWANCE=?, MEDICAL=?, GROSS_SALARY=?, PF=?, INCOME_TAX=?, PROF_TAX=?, PF_NO=?, PF_EMP_CONTRIBUTION=?, NET_SALARY=?, INCENTIVE_PER_MINUTE=?, INCENTIVE_PER_HOUR=?, INCENTIVE_PER_DAY=?,BANKER_EMAIL=?    WHERE  Location like ? and EMPID = ?";
	public static final String UPDATE_HOURLY_EMPLOYEE = "UPDATE ai_emp_details SET  EMPNAME=?,  PHONE=?,  EMAIL=?, SHIFT_ID=?, CREATEUSER=?, CREATEDATE=?, EMPLOYEETYPE=?, EMPADDRESS=?, EMPDESIGNATION=?, DEPARTMENT=?, DOB =?, DOJ=?, FATHERNAME=?, EMPLOYEE_CATEGORY=?,PF_NO=?, PAYMENT_TYPE=?,    BASIC='0.0', HRA='0.0', CONVEYANCE='0.0', ALLOWANCE='0.0', MEDICAL='0.0', GROSS_SALARY='0.0', PF='0.0', INCOME_TAX='0.0', PROF_TAX='0.0',PF_EMP_CONTRIBUTION='0.0', SHIFT_HOUR=?, INCENTIVE_PER_MINUTE=?, INCENTIVE_PER_HOUR=?, INCENTIVE_PER_DAY=?, INCENTIVE_PER_WEEK=?, NET_SALARY=?,BANKER_EMAIL=?   WHERE  Location like ? and EMPID = ?";
	public static final String UPDATE_EMPLOYEE = "  UPDATE ai_emp_details SET  EMPNAME=?,  PHONE=?,  EMAIL=?, SHIFT_ID=?, CREATEUSER=?, CREATEDATE=?, EMPLOYEETYPE=?, EMPADDRESS=?, EMPDESIGNATION=?, DEPARTMENT=?, DOB =?, DOJ=?, FATHERNAME=?,Location=? WHERE  Location like ? and  EMPID = ?";
	public static final String EMP_MODIFY1 = "UPDATE ai_emp_attendance SET EMPNAME= ? WHERE EMPID = ?";
	public static final String EMP_REMOVE = "DELETE FROM ai_emp_details WHERE  Location like ? and EMPNAME =  ? AND EMPID = ? ";
	public static final String getSpecReport = "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance WHERE STATUS =? ORDER BY EMPNAME";
	public static final String getSpecDayStatus = "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance WHERE STATUS = ? AND DATE =?";
	public static final String EMPNAME1 = "EMPNAME";
	public static final String EMPNAME = "EmpName";
	public static final String EMPID = "EmpId";
	public static final String DATE = "Date";
	public static final String CLIENT = "Client";
	public static final String STATUS = "Status";
	public static final String REMARKS = "Remarks";
	public static final String SUCCESS = "success";
	public static final String EMPINFO = "empinfo";
	public static final String MONTHREPORT = "monthrepo";
	public static final String EMPINFOMONTH = "empinfomonth";

	public static final String ShowNames = "names";

	public static String QUERY_DATASELECTION1 = "SELECT EMPID,EMPNAME FROM ai_emp_details Location like ? ORDER BY EMPNAME";

	// Shift master
	public static String SHIFT_INSERT = "INSERT INTO ai_shift_deatails (AI_SHIFT_ID,AI_SHIFT_NAME,AI_SHIFT_START_TIME,AI_SHIFT_END_TIME,AI_SHIFT_LTOC,AI_SHIFT_LTOC_GC,AI_SHIFT_ETOG_GC,AI_SHIFT_LTOC_NO_EXEC,AI_SHIFT_ETOG_NO_EXEC,AI_SHIFT_LTOC_LD,AI_SHIFT_ETOG_LD,AI_SHIFT_CREATE_USER,AI_SHIFT_CREATE_TIME,AI_SHIFT_MODIFY_USER,AI_SHIFT_MODIFY_TIME,Location) VALUES (?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?, ?,?)";

	public static String SHIFT_MAX_LOGAUDIT = "select ADMS_CHK_ID from ai_bio_log_audit where AI_BIO_LOG_DATE_ENTRY = (select max( AI_BIO_LOG_DATE_ENTRY ) from ai_bio_log_audit)";
	public static String INSERT_LOGAUDIT = "insert into ai_bio_log_details (AI_EMP_ID, AI_EMP_DATE, AI_EMP_TIME,AI_EMP_ENTRY_TIME) values(?, ?, ?,?)";
	public static String LOGMAX_DATE_PICK = "select distinct AI_EMP_DATE from ai_bio_log_details where AI_EMP_DATE > ?";
	public static String SELECT_EMPID = "select distinct empid from ai_emp_details";
	public static String UPDATE_AUDITENTRY = "insert into ai_bio_log_audit(AI_BIO_LOG_DATE_ENTRY,ADMS_CHK_ID, AI_BIO_ENTRY_TIME,ETL_CODE) values(?,?, ?,?)";
	public static String SELECT_EMP_LOG_COMPARISION = "SELECT distinct EMPID FROM ai_emp_details LEFT JOIN ai_bio_log_details ON ai_emp_details.EMPID=ai_bio_log_details.AI_EMP_ID where ai_bio_log_details.AI_EMP_DATE= ? ";
	public static String BIO_ATTANCANCE_INSERT = "insert into ai_emp_attendance (empid,empname,status, DATE) values(? ,?, ?, ?)";
	public static String SELECT_EMPNAME = "select distinct EMPNAME from  ai_emp_details where EMPID = '";

	public static final String SHIFTNAME = "SELECT AI_SHIFT_ID,AI_SHIFT_NAME from ai_shift_deatails where Location like ?";
	public static final String EMPLOYEEINFO = "SELECT EMPID,EMPNAME from ai_emp_details where Location like ? and SHIFT_ID=? and EMPLOYEETYPE='Normal' order by EMPNAME";
	public static final String EMPLOYEEINFO1 = "SELECT EMPID,EMPNAME from ai_emp_details where Location like ? and DEPARTMENT=? and EMPLOYEETYPE='Normal' order by EMPID";

	public static final String EMPLOYEEREPORT = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE empde.Location like ? and empatt.EMPID =? and empatt.DATE=? and  empde.EMPLOYEETYPE='Normal' and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String EMPLOYEEREPORT3 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE empde.Location like ? and  empatt.EMPID =? and empatt.DATE=? and  empde.EMPLOYEETYPE='Normal' and empatt.EMPID=empde.empid and empde.DEPARTMENT=? order by empde.empid";
	public static final String EMPLOYEEREPORTALL = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=? and  empde.EMPLOYEETYPE='Normal' and empde.SHIFT_ID=?  and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String EMPLOYEEREPORTALL5 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and empde.SHIFT_ID=?  and empde.DEPARTMENT=? and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String EMPLOYEEPRODREPORT = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  e.EMPID=p.EMP_ID and e.EMPID=? and  EMPLOYEETYPE='Normal' and p.ATTENDANCE_DATE=?  order by e.EMPID";
	public static final String EMPLOYEEPRODREPORTALL = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where sdt.Location like ? and  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? )  order by e.EMPID";
	public static final String EMPLOYEEPRODREPORT3 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and e.EMPID=p.EMP_ID and e.EMPID=? and  EMPLOYEETYPE='Normal' and p.ATTENDANCE_DATE=? and e.DEPARTMENT=? order by e.EMPID";
	public static final String EMPLOYEEPRODREPORTALL4 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and  emp.Location like ? and  sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.DEPARTMENT=?)  order by e.EMPID";

	// month report queries
	public static final String EMPLOYEEMONTHREPORT = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.EMPID =? and empatt.DATE between ? and ? and empatt.EMPID=empde.EMPID and empde.EMPLOYEETYPE='Normal'";
	public static final String EMPLOYEEMONTHREPORT4 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.EMPID =? and empatt.DATE between ? and ? and empatt.EMPID=empde.EMPID and empde.EMPLOYEETYPE='Normal' and empde.DEPARTMENT=?";

	// public static final String EMPLOYEEMONTHREPORT =
	// "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance WHERE EMPID =? and DATE between ? and ?";
	public static final String EMPLOYEEMONTHREPORTALL = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal')order by DATE";
	public static final String EMPLOYEEMONTHREPORTALL6 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where   sdt.Location like ? and  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=?)order by DATE";

	// public static final String EMPLOYEEMONTHREPORTALL =
	// "SELECT EMPID, EMPNAME, DATE, STATUS  from ai_emp_attendance WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=?)order by EMPNAME";

	public static final String EMPLOYEEMONTHPRODREPORT = "SELECT distinct(e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and e.EMPID=p.EMP_ID and e.EMPID=? and p.ATTENDANCE_DATE BETWEEN ? AND ? and e.EMPLOYEETYPE='Normal' ORDER BY e.empname ";
	public static final String EMPLOYEEMONTHPRODREPORT4 = "SELECT distinct(e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and e.EMPID=p.EMP_ID and e.EMPID=? and p.ATTENDANCE_DATE BETWEEN ? AND ? and e.EMPLOYEETYPE='Normal' and e.DEPARTMENT=? ORDER BY e.empname ";
	public static final String EMPLOYEEMONTHPRODREPORTALL = "SELECT distinct(e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE BETWEEN ? AND ? and e.EMPLOYEETYPE='Normal'  ";
	public static final String EMPLOYEEMONTHPRODREPORTALL5 = "SELECT distinct(e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE BETWEEN ? AND ? and e.EMPLOYEETYPE='Normal' and e.DEPARTMENT=? ";
	public static final String EMPLOYEEGETSHIFDEDUCTION = "select AI_SHIFT_LTOC_NO_EXEC ,AI_SHIFT_ETOG_NO_EXEC,AI_SHIFT_LTOC_LD,AI_SHIFT_ETOG_LD from ai_shift_deatails where  Location like ? and  AI_SHIFT_ID  =? ";

	public static final String AI_SHIFT_ID = "AI_SHIFT_ID";
	public static final String AI_SHIFT_NAME = "AI_SHIFT_NAME";
	public static final String AI_SHIFT_START_TIME = "AI_SHIFT_START_TIME";
	public static final String AI_SHIFT_END_TIME = "AI_SHIFT_END_TIME";
	public static final String AI_SHIFT_LTOC = "AI_SHIFT_LTOC";
	public static final String AI_SHIFT_ETOG = "AI_SHIFT_ETOG";
	public static final String AI_SHIFT_LTOC_GC = "AI_SHIFT_LTOC_GC";
	public static final String AI_SHIFT_ETOG_GC = "AI_SHIFT_ETOG_GC";
	public static final String AI_SHIFT_LTOC_NO_EXEC = "AI_SHIFT_LTOC_NO_EXEC";
	public static final String AI_SHIFT_ETOG_NO_EXEC = "AI_SHIFT_ETOG_NO_EXEC";
	public static final String AI_SHIFT_LTOC_LD = "AI_SHIFT_LTOC_LD";
	public static final String AI_SHIFT_ETOG_LD = "AI_SHIFT_ETOG_LD";
	public static final String AI_SHIFT_CREATE_USER = "AI_SHIFT_CREATE_USER";
	public static final String AI_SHIFT_CREATE_TIME = "AI_SHIFT_CREATE_TIME";
	public static final String AI_SHIFT_MODIFY_USER = "AI_SHIFT_MODIFY_USER";
	public static final String AI_SHIFT_MODIFY_TIME = "AI_SHIFT_MODIFY_TIME";
	public static final String LOCATION = "location";

	public static final String AI_BIO_PROCESS = "select AI_SHIFT_LTOC_NO_EXEC,AI_SHIFT_ETOG_NO_EXEC,AI_SHIFT_LTOC_LD,AI_SHIFT_ETOG_LD from ai_shift_deatails where  AI_SHIFT_ID=?";
	public static final String AI_BIO_SELECT_AIEMPDETAILS = "select SHIFT_ID, empname from ai_emp_details where  empid=? and EMPLOYEETYPE='Normal'";
	public static final String AI_BIO_SELECT_SHIFTDETAILS = "select AI_SHIFT_LTOC_NO_EXEC, AI_SHIFT_ETOG_NO_EXEC, AI_SHIFT_LTOC_LD, AI_SHIFT_ETOG_LD from ai_shift_deatails where AI_SHIFT_ID=?";
	public static final String AI_BIO_SELECT_TIMEDETAILS = "SELECT MORNING_LATE,EVENING_EARLY  from ai_bio_timesheet WHERE EMP_ID= ? AND ATTENDANCE_DATE between ? and ?";
	public static final String AI_BIO_SELECT_EMPDETAILS = "select empname from ai_emp_details where empid ='";
	public static final String AI_BIO_PROCESS_INSERT = "insert into ai_bio_process (ai_process_id,ai_pro_empid,ai_pro_empname,ai_pro_fromdate,ai_pro_todate,ai_pro_num_latecome,ai_pro_num_earlygo,ai_pro_excuse_latecome,ai_pro_excuse_earlygo,ai_pro_latecome_deduction,ai_pro_earlygo_deduction,ai_pro_latecome_deducted,ai_pro_earlygo_deducted,ai_pro_totaldays_deducted) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String AI_BIO_PROCESS_DISPLAY = "select distinct empde.EMPNAME,shift.AI_SHIFT_NAME, pro.ai_pro_fromdate ,pro.ai_pro_todate,shift.AI_SHIFT_LTOC,pro.ai_pro_num_latecome,shift.AI_SHIFT_ETOG, pro.ai_pro_num_earlygo,shift.AI_SHIFT_LTOC_NO_EXEC, pro.ai_pro_excuse_latecome,shift.AI_SHIFT_ETOG_NO_EXEC, pro.ai_pro_excuse_earlygo,shift.AI_SHIFT_LTOC_LD,pro.ai_pro_latecome_deduction,shift.AI_SHIFT_ETOG_LD,pro.ai_pro_earlygo_deduction, pro.ai_pro_latecome_deducted, pro.ai_pro_earlygo_deducted,ai_pro_totaldays_deducted from ai_bio_process pro,ai_emp_details empde,ai_shift_deatails shift where  empde.EMPNAME=pro.ai_pro_empname and pro.ai_process_id=? and empde.SHIFT_ID=shift.AI_SHIFT_ID and empde.EMPLOYEETYPE='Normal'";
	public static final String AI_BIO_MONTH_REPORT_ALL = "select EMPID,EMPNAME from ai_emp_details order by EMPID";

	public static final String AI_BIO_EMP_OVERTIME_MONTH = "select T.EMP_ID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T,ai_emp_details E where  E.Location like ? and T.EMP_ID =? and E.EMPID=? and T.ATTENDANCE_DATE >= ? and T.ATTENDANCE_DATE <= ? and E.DEPARTMENT = ? order by T.ATTENDANCE_DATE";
	public static final String AI_BIO_EMP_OVERTIME_DAY = "select T.EMP_ID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T,ai_emp_details E where  E.Location like ? and T.EMP_ID =? and E.EMPID=? and T.ATTENDANCE_DATE = ? and E.DEPARTMENT = ?  order by T.ATTENDANCE_DATE";
	public static final String CHECK_EMP_ID = "select count(*) from ai_emp_details where  EMPID=?";
	public static final String ADD_FLAT_EMPLOYEE = "INSERT INTO ai_emp_details (EMPID, EMPNAME, PHONE, EMAIL,SHIFT_ID,CREATEUSER,CREATEDATE,EMPLOYEETYPE,EMPADDRESS,EMPDESIGNATION,DEPARTMENT,DOB ,DOJ,FATHERNAME,EMPLOYEE_CATEGORY,PAYMENT_TYPE,BASIC,HRA,CONVEYANCE,ALLOWANCE,MEDICAL,GROSS_SALARY,PF,INCOME_TAX,PROF_TAX,PF_NO,PF_EMP_CONTRIBUTION,NET_SALARY,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY,BANKER_EMAIL ) VALUES (?,?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String ADD_HOURLY_EMPLOYEE = "INSERT INTO ai_emp_details (EMPID, EMPNAME, PHONE, EMAIL,SHIFT_ID,CREATEUSER,CREATEDATE,EMPLOYEETYPE,EMPADDRESS,EMPDESIGNATION,DEPARTMENT,DOB ,DOJ,FATHERNAME,EMPLOYEE_CATEGORY,PF_NO,PAYMENT_TYPE,SHIFT_HOUR,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY,INCENTIVE_PER_WEEK,NET_SALARY,BANKER_EMAIL ) VALUES (?,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//public static final String REGISTER_EMPLOYEE = "INSERT INTO ai_emp_details (EMPID, EMPNAME, PHONE, EMAIL,SHIFT_ID,CREATEUSER,CREATEDATE,EMPLOYEETYPE,EMPADDRESS,EMPDESIGNATION,DEPARTMENT,DOB ,DOJ,FATHERNAME,Location) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String DEPARTMENTDATA = "SELECT * FROM ai_bio_department order by DEPT_NAME asc";
	public static final String SHIFTDATA = "SELECT * FROM ai_shift_deatails where  Location like ?   order by AI_SHIFT_NAME asc";
	//public static final String EMAILCOUNT = "SELECT count(*) FROM ai_emp_details where  Location like ? and EMAIL=?";
	//public static final String EMPIDCOUNT = "SELECT count(*) FROM ai_emp_details where  Location like ? and EMPID=?";
	// public static final String retrieveDetailAction =
	// "SELECT EMPNAME,EMPID,EMAIL,PHONE,EMPDESIGNATION,DEPARTMENT,SHIFT_ID,EMPLOYEETYPE,EMPADDRESS,DOB,DOJ,FATHERNAME from ai_emp_details WHERE EMPID=?";
	public static final String EMPLOYEEREPORT1 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=? and empatt.status=? and  empde.EMPLOYEETYPE='Normal' and empde.SHIFT_ID=?  and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String EMPLOYEEREPORT4 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=? and empatt.status=? and  empde.EMPLOYEETYPE='Normal' and empde.SHIFT_ID=?  and empde.DEPARTMENT=? and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String EMPLOYEEREPORT2 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE  empde.Location like ? and empatt.EMPID =? and empatt.STATUS=?  and empatt.DATE=? and  empde.EMPLOYEETYPE='Normal' and empatt.EMPID=empde.empid order by empde.empid";
	public static final String EMPLOYEEREPORT6 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE  empde.Location like ? and empatt.EMPID =? and empatt.STATUS=?  and empatt.DATE=? and  empde.EMPLOYEETYPE='Normal' and empatt.EMPID=empde.empid and empde.DEPARTMENT=? order by empde.empid";
	public static final String EMPLOYEEMONTHREPORT1 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.EMPID =? and  empatt.status=? and empatt.DATE between ? and ? and empatt.EMPID=empde.EMPID and empde.EMPLOYEETYPE='Normal'";
	public static final String EMPLOYEEMONTHREPORT15 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.EMPID =? and  empatt.status=? and empatt.DATE between ? and ? and empatt.EMPID=empde.EMPID and empde.EMPLOYEETYPE='Normal' and empde.DEPARTMENT=?";
	public static final String EMPLOYEEMONTHREPORTALL1 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE   DATE between ? and ? and status=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where   sdt.Location like ? and  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal')order by DATE";
	public static final String EMPLOYEEMONTHREPORTALL17 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE   DATE between ? and ? and status=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' emp.DEPARTMENT=?)order by DATE";

	public static String QUERY_ALLEMPLOYEE = "SELECT e.EMPNAME,e.EMPID,s.AI_SHIFT_NAME,e.EMPLOYEETYPE,d.DEPT_NAME FROM ai_emp_details e,ai_bio_department d,ai_shift_deatails s  where  s.Location like ? and  e.Location like ? and e.SHIFT_ID=s.AI_SHIFT_ID and d.DEPT_ID=e.DEPARTMENT  ORDER BY e.EMPID";

	public static String getTodaysReport = "select e.EMPID,e.EMPNAME,d.DEPT_NAME from ai_emp_details e,ai_bio_department d where e.Location like ? and  e.SHIFT_ID=?  and e.EMPID=? and e.DEPARTMENT=d.DEPT_ID order by e.EMPID";
	public static String getTodaysReportAll = "select e.EMPID,e.EMPNAME,d.DEPT_NAME from ai_emp_details e,ai_bio_department d where  e.Location like ? and e.SHIFT_ID=? and e.DEPARTMENT=d.DEPT_ID order by e.EMPID";

	// public static String
	// QUERY_ALLEMPLOYEE="SELECT e.EMPNAME,e.EMPID,s.AI_SHIFT_NAME,e.EMPLOYEETYPE FROM ai_emp_details e  join  ai_shift_deatails s on e.SHIFT_ID=s.AI_SHIFT_ID  ORDER BY e.EMPID";

	// public static String getTodaysReport
	// ="select EMPID,EMPNAME,DEPARTMENT from ai_emp_details where SHIFT_ID=? and EMPID=? order by EMPID";
	// public static String getTodaysReportAll
	// ="select EMPID,EMPNAME,DEPARTMENT from ai_emp_details where SHIFT_ID=? order by EMPID ";
	//public static final String getAllEMpWithShiftandDept = "select e.EMPID,e.EMPLOYEETYPE,e.EMPNAME,e.PHONE,e.EMAIL,s.AI_SHIFT_ID ,s.AI_SHIFT_NAME,d.DEPT_ID,d.DEPT_NAME from ai_emp_details e,ai_shift_deatails s,ai_bio_department d where   s.Location like ? and  e.Location like ? and e.SHIFT_ID = s.AI_SHIFT_ID and e.DEPARTMENT = d.DEPT_ID and  e.EMPNAME like ? order by e.EMPNAME limit ?";
	//public static final String checkEmpinWeekOffMaster = "select count(*) from onsite_weekoffmaster where EMP_ID =?";

//	public static final String insertEmpIntoWeekOff = " insert into onsite_weekoffmaster (EMP_ID,SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,CURRENT_YEAR,CREATEDBY) values (?,?,?,?,?,?,?,?,?,?) ";

	//public static final String updateEmpIntoWeekOff = "update onsite_weekoffmaster set SUNDAY= ?, MONDAY = ?,TUESDAY=?,WEDNESDAY = ?, THURSDAY = ?, FRIDAY = ? ,SATURDAY= ?,MODIFIED_BY =?,MODIFIED_DATE=? ,CREATEDDATE=? , CURRENT_YEAR=?where EMP_ID = ? ";
	//public static final String getweekoffs = "select * from onsite_weekoffmaster where EMP_ID = ?";
	public static final String EMPLOYEEMONTHREPORt = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.EMPID =? and empatt.DATE=? and empde.SHIFT_ID=?  and empatt.EMPID=empde.EMPID";
	public static final String EMPLOYEEID = "SELECT EMPID from ai_emp_details where  Location like ? and SHIFT_ID=? order by EMPID ";
	public static final String EMPLOYEENAME = "SELECT EMPNAME from ai_emp_details where Location like ? and EMPID=?";
	public static final String COUNTWK = "select count(*) from onsite_weekoffmaster where ?='1' and EMP_ID=?";
	public static final String EMPLOYEEIDIND = "SELECT EMPID from ai_emp_details where Location like ? and  DEPARTMENT=? and SHIFT_ID=? order by EMPID ";
	public static final String addGroupDetails = "INSERT INTO onsite_group (createdby, GroupName, Description, Hrmail1,Hrmail2,createdate) VALUES (?, ?, ?, ?,?,now())";
	public static final String getGroupDetails = "select * from onsite_group order by Gorupid";
	public static final String UpdateGroupDetails = "select * from onsite_group where Gorupid=? order by Gorupid";
	public static final String UpdateGroupDetailsVal = "UPDATE onsite_group SET GroupName= ?,Description=?,Hrmail1=?,Hrmail2=?,modifiedby=?,modifieddate=now(),createdate=? WHERE Gorupid = ?";
	public static final String DeleteGroupDetailsVal = "DELETE FROM onsite_group WHERE  Gorupid = ? ";
	public static final String ValidateGroupDetailsVal = "select count(*) FROM onsite_group WHERE  GroupName = ? ";
	public static final String GroupMappingDetailsVal = "select ad.DEPT_ID,ad.DEPT_NAME,ad.LOCAL_MNGR_MAIL,ad.HR_MNGR_MAIL,ad.ONSITE_MNGR_MAIL from onsite_groupmapping og,ai_bio_department ad where  og.Groupid=? and  og.DEPT_ID=ad.DEPT_ID";
	public static final String GroupDepartmentMappingDetailsVal = "select dp.DEPT_ID,dp.DEPT_NAME from ai_bio_department dp where dp.DEPT_ID NOT IN(select og.DEPT_ID from onsite_groupmapping og)";
	public static final String InsertDepartmentMappingDetailsVal = "INSERT INTO onsite_groupmapping (DEPT_ID, Groupid) VALUES (?, ?)";
	public static final String SelectDepartmentMappingDetailsVal = "select count(*) FROM onsite_groupmapping WHERE  DEPT_ID = ? and Groupid=?";
	public static final String INSERTUNAMEPWD = "INSERT INTO onsite_emp_users (USERNAME, PASSWORD,EMP_ID,CREATEDBY) VALUES (?,?,?,?)";
	public static final String EMAIL_ID_VALIDATE = "select * from ai_emp_details where Location like ? and EMAIL = ?";
	public static final String HOLIDAYMASTERYEAR = "select * from onsite_accyear";
	public static final String HOLIDAYMASTERINSERT = "insert into onsite_holidaymaster(DEPT_ID,CURRENT_YEAR, HOLIDAY_DATE, WEEKDAY, HOLIDAY_NAME,CREATEDBY)values(?,?,?, ?, ?,?)";
	public static final String HOLIDAYMASTERSELECt = "select distinct bd.DEPT_NAME,HOLIDAY_DATE,HOLIDAY_NAME,WEEKDAY from onsite_holidaymaster hm,ai_bio_department bd where hm.DEPT_ID=bd.DEPT_ID and hm.DEPT_ID like ? and hm.CURRENT_YEAR=?";
	public static final String GET_HOLIDAY_DATE_LIST = "select distinct HOLIDAY_DATE from onsite_holidaymaster";
	public static final String HOLIDAYMASTERDELETE = "delete from onsite_holidaymaster where HOLIDAY_NAME=?";
	public static final String HOLIDAYMASTERSELECT = "select * from onsite_holidaymaster where HOLIDAY_DATE=?";
	public static final String UPDATEHOLIDAY = "UPDATE onsite_holidaymaster SET WEEKDAY= ?,HOLIDAY_NAME=?,HOLIDAY_DATE=?,MODIFIED_BY=?,MODIFIED_DATE=? WHERE HOLIDAY_DATE= ?";
	public static final String VALIDATEDATE = "select count(*) from onsite_holidaymaster where HOLIDAY_DATE=?";
	public static final String getDepRecords = "select * from  ai_bio_department";
	public static final String insertDep = "insert into ai_bio_department (DEPT_ID,DEPT_NAME, DESCRIPTION, LOCATION, LOCAL_MNGR_MAIL, HR_MNGR_MAIL, ONSITE_MNGR_MAIL)values(?,?,?, ?, ?, ?, ?)";
	public static final String deleteDep = "delete from ai_bio_department where dept_id=? and dept_id not in(select DEPARTMENT from ai_emp_details where  Location like ? and DEPARTMENT=?)";
	public static final String updateDep = "update  ai_bio_department set dept_name=?,description=?,location=?,local_mngr_mail=?,hr_mngr_mail=?,onsite_mngr_mail=? where dept_id=?";
	public static final String duplicateDepartmentCheck = "select * from ai_bio_department where dept_name=?";

	public static final String RemoveEmployeeGetName = "select e.EMPID,e.EMPLOYEETYPE,e.EMPNAME,e.PHONE,e.EMAIL,s.AI_SHIFT_ID ,s.AI_SHIFT_NAME,d.DEPT_ID,d.DEPT_NAME from ai_emp_details e,ai_shift_deatails s,ai_bio_department d where  s.Location like ? and  e.Location like ? and e.SHIFT_ID = s.AI_SHIFT_ID and e.DEPARTMENT = d.DEPT_ID and  e.EMPNAME like ? order by e.EMPNAME limit ?";
	public static final String RemoveEmployeeDetails = "DELETE FROM ai_emp_details WHERE  Location like ? and EMPNAME =  ? and EMPID=?";
	public static final String getAllOffshoreEmployeeNames = "select e.EMPID,e.EMPLOYEETYPE,e.EMPNAME,e.PHONE,e.EMAIL,s.AI_SHIFT_ID ,s.AI_SHIFT_NAME,d.DEPT_ID,d.DEPT_NAME from ai_emp_details e,ai_shift_deatails s,ai_bio_department d where  s.Location like ? and  e.Location like ? and e.SHIFT_ID = s.AI_SHIFT_ID and e.DEPARTMENT = d.DEPT_ID  and e.EMPLOYEETYPE='Normal' and e.EMPNAME like ? order by e.EMPNAME limit ?";
	public static String QUERY_ALLEMPLOYEE_Search = "SELECT e.EMPNAME,e.EMPID,s.AI_SHIFT_NAME,e.EMPLOYEETYPE,d.DEPT_NAME FROM ai_emp_details e,ai_shift_deatails s,ai_bio_department d where s.Location like ? and   e.Location like ? and e.SHIFT_ID=s.AI_SHIFT_ID and d.DEPT_ID=e.DEPARTMENT AND (e.EMPNAME LIKE ? OR e.EMPID LIKE ? OR s.AI_SHIFT_NAME LIKE ? OR e.EMPLOYEETYPE LIKE ?  OR d.DEPT_NAME LIKE ?)";
	//public static String CheckCreatedDateWeekOff = "select CREATEDDATE from onsite_weekoffmaster where EMP_ID=?";

	public static final String Empautofilldetails = "select distinct e.Location, e.EMPID,e.EMPNAME,e.PHONE,e.EMAIL,e.SHIFT_ID ,e.EMPDESIGNATION,e.DEPARTMENT,e.EMPADDRESS,e.EMPLOYEETYPE,e.DOB,e.DOJ,e.FATHERNAME,e.EMPLOYEE_CATEGORY,e.PAYMENT_TYPE,e.BASIC,e.HRA,e.CONVEYANCE,e.ALLOWANCE,e.MEDICAL,e.GROSS_SALARY,e.PF,e.INCOME_TAX,e.PROF_TAX,e.PF_NO,e.PF_EMP_CONTRIBUTION,e.NET_SALARY,e.SHIFT_HOUR,e.INCENTIVE_PER_MINUTE,e.INCENTIVE_PER_HOUR,e.INCENTIVE_PER_DAY,e.INCENTIVE_PER_WEEK,e.BANKER_EMAIL from ai_emp_details e where  e.Location like ? and   e.EMPNAME like ? order by e.EMPNAME limit ?";
	public static final String GET_SEARCHED_EMPLOYEE = "select EMPID, EMPNAME from ai_emp_details where Location like ? and EMPNAME like ?";
	public static final String GET_EMPLOYEE_DETAILS = "select EMPID, EMPNAME, PHONE, EMAIL,SHIFT_ID,CREATEUSER,CREATEDATE,EMPLOYEETYPE,EMPADDRESS,EMPDESIGNATION,DEPARTMENT,DOB ,DOJ,FATHERNAME,EMPLOYEE_CATEGORY,PAYMENT_TYPE,BASIC,HRA,CONVEYANCE,ALLOWANCE,MEDICAL,GROSS_SALARY,PF,INCOME_TAX,PROF_TAX,LEAVE_DEDUCTION,OTHER_DEDUCTION,PF_EMP_CONTRIBUTION from ai_emp_details where Location like ? and EMPID = ?";

	public static final String UpdateGroupDetail = "update onsite_group set  GroupName=? where GroupName=?";

	public static final String getgroupDetails = "select count(*) FROM onsite_group WHERE  GroupName = ? ";
	public static final String CheckEmailCOUNT = "SELECT count(Email) FROM ai_emp_details where Location like ? and EMAIL=?";
	public static final String CheckEmailidCOUNT = "SELECT count(Email) FROM ai_emp_details where Location like ? and EMAIL=? and EMPID=?";
	public static String CheckCreatedDateGroup = "select createdate from onsite_group where Gorupid=?";

	public static final String EmpautofillModifydetails = "select distinct Location,EMPID,EMPNAME,PHONE,EMAIL,SHIFT_ID ,EMPDESIGNATION,DEPARTMENT,EMPADDRESS,EMPLOYEETYPE,DOB,DOJ,FATHERNAME,EMPLOYEE_CATEGORY,PAYMENT_TYPE,BASIC,HRA,CONVEYANCE,ALLOWANCE,MEDICAL,GROSS_SALARY,PF,INCOME_TAX,PROF_TAX,PF_NO,PF_EMP_CONTRIBUTION,NET_SALARY,SHIFT_HOUR,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY,INCENTIVE_PER_WEEK,BANKER_EMAIL from ai_emp_details  where Location like ? and EMPID= ?";
	public static final String UpdateGroupDetailsValdes = "UPDATE onsite_group SET Description=?,Hrmail1=?,Hrmail2=?,modifiedby=?,modifieddate=now(),createdate=? WHERE Gorupid = ?";

	public static final String MONTHLYEMPLOYEEREPORTT2GROUPALL = "select Distinct(att.empid),bio.IN_TIME,emp.EMPNAME,bio.ATTENDANCE_DATE,bio.OUT_TIME,dep.DEPT_NAME  from ai_bio_timesheet bio join ai_emp_attendance att on bio.EMP_ID=att.empid join ai_emp_details emp on emp.EMPID=att.empid join ai_bio_department dep on dep.DEPT_ID=emp.DEPARTMENT and  emp.Location like ? and bio.ATTENDANCE_DATE BETWEEN ? AND ? and dep.DEPT_ID  in(select g.DEPT_ID from onsite_groupmapping g where g.Groupid=?) order by bio.ATTENDANCE_DATE ASC,emp.EMPID ASC";
	public static final String MONTHLYEMPLOYEEREPORTT2GROUPIND = "select Distinct(att.empid),bio.IN_TIME,emp.EMPNAME,bio.ATTENDANCE_DATE,bio.OUT_TIME,dep.DEPT_NAME  from ai_bio_timesheet bio join ai_emp_attendance att on bio.EMP_ID=att.empid join ai_emp_details emp on emp.EMPID=att.empid join ai_bio_department dep on dep.DEPT_ID=emp.DEPARTMENT and  emp.Location like ? and bio.ATTENDANCE_DATE BETWEEN ? AND ? and dep.DEPT_ID  in(select g.DEPT_ID from onsite_groupmapping g where g.Groupid=? and dep.DEPT_ID=?) order by bio.ATTENDANCE_DATE ASC,emp.EMPID ASC";

	public static final String MonthReportStatus = "select distinct att.status,att.empid,bio.IN_TIME,emp.EMPNAME,bio.ATTENDANCE_DATE,bio.OUT_TIME,dep.DEPT_NAME from ai_bio_timesheet bio join ai_emp_attendance att on bio.EMP_ID=att.empid join ai_emp_details emp on emp.EMPID=att.empid join  ai_bio_department dep on dep.DEPT_ID=emp.DEPARTMENT and  emp.Location like ? and emp.EMPNAME=? and att.empid=? and bio.ATTENDANCE_DATE=? and bio.IN_TIME=? and bio.OUT_TIME=? and dep.DEPT_NAME =?";

	public static final String DEL_GROUP_DEPT = "delete from onsite_groupmapping where Groupid =?";
	public static final String INSERT_GROUP_DEPT = "insert into onsite_groupmapping(DEPT_ID,Groupid) values(?,?)";

	// For SHift Employees
	public static final String EMPLOYEEINFO2 = "SELECT EMPID,EMPNAME from ai_emp_details where Location like ? and SHIFT_ID=? and DEPARTMENT=? and EMPLOYEETYPE='Normal' order by EMPNAME";
	public static final String EMPLOYEEINFO3 = "SELECT EMPID,EMPNAME from ai_emp_details where Location like ? and EMPLOYEETYPE='Normal' order by EMPNAME";
	public static final String EMPLOYEEINFO4 = "SELECT EMPID,EMPNAME from ai_emp_details where Location like ? and EMPLOYEETYPE='Normal' and DEPARTMENT=? order by EMPNAME";
	// For Reports

	public static final String DAYStatusReport = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and  empde.SHIFT_ID like ? and empde.empid like ? and empatt.STATUS like ? and empde.DEPARTMENT like ?  and empatt.EMPID=empde.empid order by empde.empid";
	
	public static final String DAYStatusReport1 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and empde.SHIFT_ID=?  and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String DAYStatusReport2 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and  empde.SHIFT_ID=? and empatt.STATUS=?   and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String DAYStatusReport3 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and  empde.SHIFT_ID=? and  empde.empid=?  and empatt.EMPID=empde.empid order by empde.empid";
	public static final String DAYStatusReport4 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and  empde.SHIFT_ID=?  and empde.empid=? and empatt.STATUS=? and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String DAYStatusReport5 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and empde.SHIFT_ID=? and empde.DEPARTMENT=? and empatt.EMPID=empde.empid order by empde.empid";
	public static final String DAYStatusReport6 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and  empde.SHIFT_ID=? and empatt.STATUS=? and empde.DEPARTMENT=?  and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String DAYStatusReport7 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and  empde.SHIFT_ID=? and empde.empid=? and empde.DEPARTMENT=?  and empatt.EMPID=empde.empid order by empde.empid";
	public static final String DAYStatusReport8 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal' and  empde.SHIFT_ID=? and empde.empid=? and empatt.STATUS=? and empde.DEPARTMENT=?  and empatt.EMPID=empde.empid order by empde.empid";

	public static final String DAYStatusReport9 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal'   and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String DAYStatusReport10 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal'  and empatt.STATUS=?   and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String DAYStatusReport11 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal'  and  empde.empid=?  and empatt.EMPID=empde.empid order by empde.empid";
	public static final String DAYStatusReport12 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal'   and empde.empid=? and empatt.STATUS=? and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String DAYStatusReport13 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal'  and empde.DEPARTMENT=? and empatt.EMPID=empde.empid order by empde.empid";
	public static final String DAYStatusReport14 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal'  and empatt.STATUS=? and empde.DEPARTMENT=?  and empatt.EMPID=empde.empid order by empde.empid ";
	public static final String DAYStatusReport15 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal'  and empde.empid=? and empde.DEPARTMENT=?  and empatt.EMPID=empde.empid order by empde.empid";
	public static final String DAYStatusReport16 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS from ai_emp_attendance empatt,ai_emp_details empde WHERE  empde.Location like ? and empatt.DATE=?  and  empde.EMPLOYEETYPE='Normal'  and empde.empid=? and empatt.STATUS=? and empde.DEPARTMENT=?  and empatt.EMPID=empde.empid order by empde.empid";

	public static final String DAYProdReport = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and emp.Location like ? and sdt.ai_shift_id=emp.shift_id  and sdt.ai_shift_id like ? and emp.DEPARTMENT=? and e.EMPID=?)  order by e.EMPID";
	
	public static final String DAYProdReport1 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? )  order by e.EMPID";
	public static final String DAYProdReport2 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE=? and   e.EMPID=? and e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? )  order by e.EMPID";
	public static final String DAYProdReport3 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and  sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.DEPARTMENT=?)  order by e.EMPID";
	public static final String DAYProdReport4 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and  sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.DEPARTMENT=? and e.EMPID=?)  order by e.EMPID";
	public static final String DAYProdReport5 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and  sdt.ai_shift_id=emp.shift_id )  order by e.EMPID";
	public static final String DAYProdReport6 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE=? and   e.EMPID=? and e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and  sdt.ai_shift_id=emp.shift_id )  order by e.EMPID";
	public static final String DAYProdReport7 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and  sdt.ai_shift_id=emp.shift_id and emp.DEPARTMENT=?)  order by e.EMPID";
	public static final String DAYProdReport8 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and p.ATTENDANCE_DATE=? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where   sdt.Location like ? and  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and emp.DEPARTMENT=? and e.EMPID=?)  order by e.EMPID";

	public static final String MONTHStatusReport = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where   sdt.Location like ? and  emp.Location like ? and sdt.ai_shift_id=emp.shift_id  and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=? and emp.EMPID=?)order by DATE";
	public static final String MONTHStatusReport1 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal')order by DATE";
	public static final String MONTHStatusReport2 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal')order by DATE";
	public static final String MONTHStatusReport3 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and  empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' and emp.EMPID=?)order by DATE";
	public static final String MONTHStatusReport4 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' and emp.EMPID=?)order by DATE";
	public static final String MONTHStatusReport5 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=?)order by DATE";
	public static final String MONTHStatusReport6 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=?)order by DATE";
	public static final String MONTHStatusReport7 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=? and emp.EMPID=?)order by DATE";
	public static final String MONTHStatusReport8 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=? and emp.EMPID=?)order by DATE";
	public static final String MONTHStatusReport9 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id  and emp.EMPLOYEETYPE='Normal')order by DATE";
	public static final String MONTHStatusReport10 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and  emp.EMPLOYEETYPE='Normal')order by DATE";
	public static final String MONTHStatusReport11 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and  empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id  and emp.EMPLOYEETYPE='Normal' and emp.EMPID=?)order by DATE";
	public static final String MONTHStatusReport12 = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id  and emp.EMPLOYEETYPE='Normal' and emp.EMPID=?)order by DATE";
	public static final String MONTHStatusReport13 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=?)order by DATE";
	public static final String MONTHStatusReport14 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id  and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=?)order by DATE";
	public static final String MONTHStatusReport15 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id  and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=? and emp.EMPID=?)order by DATE";
	public static final String MONTHStatusReport16 = " SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt WHERE DATE between ? and ? and empatt.STATUS=? and empid in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id  and emp.EMPLOYEETYPE='Normal' and emp.DEPARTMENT=? and emp.EMPID=?)order by DATE";

	public static final String MONTHProdReport = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  sdt.Location like ? and   emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id like ? and emp.DEPARTMENT like ? and e.EMPID like ?)  order by e.EMPID";
	public static final String MONTHProdReport1 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? )  order by e.EMPID";
	public static final String MONTHProdReport2 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and   e.EMPID=? and e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? )  order by e.EMPID";
	public static final String MONTHProdReport3 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.DEPARTMENT=?)  order by e.EMPID";
	public static final String MONTHProdReport4 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and sdt.ai_shift_id=? and emp.DEPARTMENT=? and e.EMPID=?)  order by e.EMPID";
	public static final String MONTHProdReport5 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id )  order by e.EMPID";
	public static final String MONTHProdReport6 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and   e.EMPID=? and e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id )  order by e.EMPID";
	public static final String MONTHProdReport7 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where  emp.Location like ? and sdt.ai_shift_id=emp.shift_id and emp.DEPARTMENT=?)  order by e.EMPID";
	public static final String MONTHProdReport8 = "SELECT distinct (e.empname),p.EMP_ID, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.TOTAL_HOURS,p.TOTAL_WORKING_HOURS,p.MORNING_LATE,p.EVENING_EARLY  from ai_emp_details e,ai_bio_timesheet p where  e.Location like ? and  p.ATTENDANCE_DATE BETWEEN ? and ? and  e.EMPID=p.EMP_ID and  EMPLOYEETYPE='Normal' and e.EMPID in(select emp.empid from ai_emp_details emp, ai_shift_deatails sdt where   emp.Location like ? and sdt.ai_shift_id=emp.shift_id and emp.DEPARTMENT=? and e.EMPID=?)  order by e.EMPID";

	public static final String EMPLOYEEMONTHALLREPORT = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt,ai_emp_details empde  WHERE   empde.Location like ? and empatt.EMPID =? and empatt.DATE=?  and empatt.EMPID=empde.EMPID";
	public static final String LEGENDEMPLOYEEID = "SELECT EMPID from ai_emp_details where  Location like ? and EMPLOYEETYPE='Normal' order by EMPID";
	public static final String LEGENDEMPLOYEEID1 = "SELECT EMPID from ai_emp_details where Location like ? and EMPLOYEETYPE='Normal' and DEPARTMENT=? order by EMPID";
	public static final String EMPLOYEEMONTHREPORTALLSHIT = "SELECT empatt.EMPID, empatt.EMPNAME, empatt.DATE, empatt.STATUS  from ai_emp_attendance empatt,ai_emp_details empde  WHERE  empde.Location like ? and empatt.EMPID =? and empatt.DATE=?  and empatt.EMPID=empde.EMPID";

	public static final String GETEMPLOYEESTATUS = "select distinct att.status,att.empid from  ai_emp_attendance att  where att.empid=? and att.DATE=?";

	public static final String OverTimeReport1 = "select E.EMPID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T join ai_emp_details E on T.EMP_ID=E.EMPID where  E.Location like ? and T.ATTENDANCE_DATE between ? and ? order by T.ATTENDANCE_DATE,E.EMPID asc";
	public static final String OverTimeReport2 = "select E.EMPID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T join ai_emp_details E on T.EMP_ID=E.EMPID where  E.Location like ? and T.ATTENDANCE_DATE between ? and ? and E.EMPID=? order by T.ATTENDANCE_DATE,E.EMPID asc";
	public static final String OverTimeReport3 = "select E.EMPID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T join ai_emp_details E on T.EMP_ID=E.EMPID where  E.Location like ? and T.ATTENDANCE_DATE between ? and ? and E.DEPARTMENT =? order by T.ATTENDANCE_DATE,E.EMPID asc";
	public static final String OverTimeReport4 = "select E.EMPID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T join ai_emp_details E on T.EMP_ID=E.EMPID where  E.Location like ? and T.ATTENDANCE_DATE between ? and ? and E.EMPID=? and E.DEPARTMENT =? order by T.ATTENDANCE_DATE,E.EMPID asc";
	public static final String OverTimeReport5 = "select E.EMPID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T join ai_emp_details E on T.EMP_ID=E.EMPID where  E.Location like ? and T.ATTENDANCE_DATE between ? and ? and E.SHIFT_ID=? order by T.ATTENDANCE_DATE,E.EMPID asc";
	public static final String OverTimeReport6 = "select E.EMPID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T join ai_emp_details E on T.EMP_ID=E.EMPID where  E.Location like ? and T.ATTENDANCE_DATE between ? and ? and E.EMPID=? and E.SHIFT_ID=? order by T.ATTENDANCE_DATE,E.EMPID asc";
	public static final String OverTimeReport7 = "select E.EMPID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T join ai_emp_details E on T.EMP_ID=E.EMPID where  E.Location like ? and T.ATTENDANCE_DATE between ? and ? and E.DEPARTMENT =? and E.SHIFT_ID=? order by T.ATTENDANCE_DATE,E.EMPID asc";
	public static final String OverTimeReport8 = "select E.EMPID, E.EMPNAME ,T.ATTENDANCE_DATE,T.IN_TIME,T.OUT_TIME, T.TOTAL_HOURS,T.TOTAL_WORKING_HOURS, E.SHIFT_ID from ai_bio_timesheet T join ai_emp_details E on T.EMP_ID=E.EMPID where  E.Location like ? and T.ATTENDANCE_DATE between ? and ? and E.EMPID=? and E.DEPARTMENT =? and E.SHIFT_ID=? order by T.ATTENDANCE_DATE,E.EMPID asc";

	/** Mritunjay Coding Start */
	/*
	 * public static final String
	 * GET_SHIFT="select AI_SHIFT_ID,AI_SHIFT_NAME from ai_shift_deatails;";
	 */
	public static final String GET_PAYSLIP_DATA = "select bt.EMP_ID EmpId,GROUP_CONCAT(bt.TOTAL_HOURS) TotalHours,GROUP_CONCAT(bt.TOTAL_WORKING_HOURS) TotalWorkingHour,GROUP_CONCAT(bt.LATE_TIME) LateTime,GROUP_CONCAT(bt.EARLY_TIME) EarlyTime,ed.EMPNAME EmpName,ed.SHIFT_ID ShiftId,ed.EMPLOYEE_CATEGORY EmployeeCategory from ai_bio_timesheet bt,ai_emp_details ed  where  ed.Location like ? and bt.EMP_ID=ed.EMPID and ed.EMPLOYEE_CATEGORY=? and ed.SHIFT_ID like ? and ATTENDANCE_DATE between ? and ? group by EMP_ID order by EMP_ID";
	public static final String GET_PAYSLIP_FOR_EMPLOYEE = "select * from (select PF_NO,EMPID,EMPNAME,EMAIL,des.designationName EMPDESIGNATION,BASIC,HRA,CONVEYANCE,ALLOWANCE,MEDICAL,GROSS_SALARY,PF,INCOME_TAX,PROF_TAX,PF_EMP_CONTRIBUTION,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY from ai_emp_details det ,ai_emp_designation des where  det.Location like ? and  det.EMPDESIGNATION = des.designationId and  PAYMENT_TYPE='Flat' and EMPID=?) a, (select sum(case when status='present' then 1 else 0 end) TotalPresent from ai_emp_attendance where empid=? and DATE between ? and ?) b, (select GROUP_CONCAT(bt.TOTAL_HOURS) TotalHours,GROUP_CONCAT(bt.TOTAL_WORKING_HOURS) TotalWorkingHour,GROUP_CONCAT(bt.LATE_TIME) LateTime,GROUP_CONCAT(bt.EARLY_TIME) EarlyTime from ai_bio_timesheet bt,ai_emp_details ed  where  ed.Location like ? and bt.EMP_ID=ed.EMPID and ed.EMPLOYEE_CATEGORY=? and ed.SHIFT_ID like ? and ATTENDANCE_DATE between ? and ? and ed.EMPID=?)c";
	public static final String GET_HOURLY_PAYSLIP = "select *,(INCENTIVE_PER_DAY*TotalPresent) NetSalary  from (select PF_NO,EMPID,EMPNAME,EMAIL,des.designationName EMPDESIGNATION,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY from ai_emp_details det ,ai_emp_designation des where  det.Location like ? and  det.EMPDESIGNATION = des.designationId and  PAYMENT_TYPE='Hourly' and EMPID=?) a, (select sum(case when status='present' then 1 else 0 end) TotalPresent from ai_emp_attendance where empid=? and DATE between ? and ?) b";
	public static final String INSERT_SALARY_DETAILS = "insert into employee_payslip_details(ID,Name,Designation,StartDate,EndDate,PF_NO,Email,No_of_days_worked,Basic,Hra,Conveyance,ONSITE_Allowance,Medical,PF_Employer_Contribution,Gross_Salary,PF,Income_Tax,Prof_Tax,Leave_Deduction,Other_Deductions,Total_Deductions,Net_Salary,total_lateTime,Internal_FileName,External_FileName,Internal_Email_Satus,External_Email_Status,other_emailid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_HOURLY_SALARY_DETAILS = "insert into employee_payslip_details(ID,Name,Designation,StartDate,EndDate,PF_NO,Email,No_of_days_worked,Net_Salary,total_lateTime,Internal_FileName,External_FileName,Internal_Email_Satus,External_Email_Status,other_emailid) values(?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?)";
	public static final String CHECK_PAYSLIP_AMENDMENT = "select count(*) from employee_payslip_amendment where Category_Name=? and Payment_Type=? and Shift_Id=? and StartDate=? and EndDate=?";
	public static final String INSERT_PAYSLIP_AMENDMENT = "insert into employee_payslip_amendment(Category_Name,Payment_Type,Shift_Id,StartDate,EndDate) values(?,?,?,?,?)";
	public static final String GET_LATEST_PAYSLIP_SEARCH = "select distinct a.Category_Name,a.Payment_Type, case when a.Shift_Id = 'All' then 'All' else s.AI_SHIFT_NAME end shiftName,a.StartDate,a.EndDate from employee_payslip_amendment a,ai_shift_deatails s where  s.Location like ? and  (a.Shift_Id = s.AI_SHIFT_ID or a.Shift_Id = 'All') and S_No = (select max(S_No) from employee_payslip_amendment)";
	public static final String CHECK_PAYSLIP_AMENDMENT_DUPLICATE_SEARCH = "select count(*) from employee_payslip_amendment where Category_Name=? and Payment_Type=? and Shift_Id=? and (StartDate  between ? and ? or EndDate between ? and ?)";
	public static final String GET_ALL_PAYSLIP = "select PF_NO,a.EMPID,EMPNAME,EMAIL,EMPDESIGNATION,BASIC,HRA,CONVEYANCE,ALLOWANCE,MEDICAL,GROSS_SALARY,PF,INCOME_TAX,PROF_TAX,PF_EMP_CONTRIBUTION,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY,BANKER_EMAIL,DEPARTMENT,TotalPresent,TotalAbsent,TotalHours,TotalWorkingHour,LateTime,EarlyTime,case when Internal_Email_Satus is null then 'Yet To Send' else Internal_Email_Satus end Internal_Email_Satus,case when External_Email_Status is null then 'Yet To Send' else External_Email_Status end  External_Email_Status from  (select PF_NO,EMPID,EMPNAME,EMAIL,des.designationName EMPDESIGNATION,BASIC,HRA,CONVEYANCE,ALLOWANCE,MEDICAL,GROSS_SALARY,PF,INCOME_TAX,PROF_TAX,PF_EMP_CONTRIBUTION,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY,BANKER_EMAIL,DEPARTMENT from ai_emp_details det ,ai_emp_designation des where  det.Location like ? and  det.EMPDESIGNATION = des.designationId and  PAYMENT_TYPE='Flat'  and EMPLOYEE_CATEGORY=? and SHIFT_ID like ?) a left outer join (select empid, sum(case when status='present' then 1 else 0 end) TotalPresent,sum(case when status='absent' then 1 else 0 end) TotalAbsent  from ai_emp_attendance where DATE between ? and ? group by empid ) b on b.empid=a.EMPID left outer join (select bt.EMP_ID empid, GROUP_CONCAT(bt.TOTAL_HOURS) TotalHours,GROUP_CONCAT(bt.TOTAL_WORKING_HOURS) TotalWorkingHour,GROUP_CONCAT(bt.LATE_TIME) LateTime,GROUP_CONCAT(bt.EARLY_TIME) EarlyTime from ai_bio_timesheet bt,ai_emp_details ed  where  ed.Location like ? and bt.EMP_ID=ed.EMPID and ed.EMPLOYEE_CATEGORY=? and ed.SHIFT_ID like ? and ATTENDANCE_DATE between ? and ? group by bt.EMP_ID)c on c.empid=a.EMPID  left outer join (select ID,Internal_Email_Satus , External_Email_Status from employee_payslip_details where StartDate=?   and EndDate=?) e on e.ID=a.EMPID";
	public static final String GET_CONSOLIDATED_HOURLY_PAYSLIP = "select PF_NO,EMPID,EMPNAME,EMAIL,EMPDESIGNATION,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY,BANKER_EMAIL,case when TotalPresent is null then 0 else TotalPresent end TotalPresent,case when NetSalary is null then 0 else NetSalary end NetSalary,TotalHours,TotalWorkingHour,LateTime,EarlyTime,case when Internal_Email_Satus is null then 'Yet To Send' else Internal_Email_Satus end Internal_Email_Satus,case when External_Email_Status is null then 'Yet To Send' else External_Email_Status end  External_Email_Status  from ( select PF_NO,a.EMPID,EMPNAME,EMAIL,EMPDESIGNATION,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY,BANKER_EMAIL,TotalPresent,(INCENTIVE_PER_DAY*TotalPresent) NetSalary ,TotalHours,TotalWorkingHour,LateTime,EarlyTime,case when Internal_Email_Satus is null then 'Yet To Send' else Internal_Email_Satus end Internal_Email_Satus,case when External_Email_Status is null then 'Yet To Send' else External_Email_Status end  External_Email_Status from (select distinct PF_NO,EMPID,EMPNAME,EMAIL,des.designationName EMPDESIGNATION,INCENTIVE_PER_MINUTE,INCENTIVE_PER_HOUR,INCENTIVE_PER_DAY,BANKER_EMAIL,DEPARTMENT from ai_emp_details det ,ai_emp_designation des where  det.Location like ? and  det.EMPDESIGNATION = des.designationId and  PAYMENT_TYPE='Hourly'  and EMPLOYEE_CATEGORY=? and SHIFT_ID like ?) a left outer join (select empid,sum(case when status='present' then 1 else 0 end) TotalPresent from ai_emp_attendance where  DATE between ? and ? group by empid) b on a.EMPID=b.empid  left outer join (select bt.EMP_ID empid, GROUP_CONCAT(bt.TOTAL_HOURS) TotalHours,GROUP_CONCAT(bt.TOTAL_WORKING_HOURS) TotalWorkingHour,GROUP_CONCAT(bt.LATE_TIME) LateTime,GROUP_CONCAT(bt.EARLY_TIME) EarlyTime from ai_bio_timesheet bt,ai_emp_details ed  where  ed.Location like ? and bt.EMP_ID=ed.EMPID and ed.EMPLOYEE_CATEGORY=? and ed.SHIFT_ID like ? and ATTENDANCE_DATE between ? and ? group by bt.EMP_ID)c on c.empid=b.EMPID  left outer join (select ID,Internal_Email_Satus , External_Email_Status from employee_payslip_details where StartDate=?   and EndDate=?) e on e.ID=a.EMPID) h";
	public static final String UPDATE_INTERNAL_MAIL_STATUS = "update employee_payslip_details set Internal_Email_Satus='Sent' where ID=? and StartDate=? and EndDate=?";
	public static final String UPDATE_EXTERNAL_MAIL_STATUS = "update employee_payslip_details set External_Email_Status='Sent'  where ID=? and StartDate=? and EndDate=?";
	public static final String UPDATE_SALARY_DETAILS = "update  employee_payslip_details set Internal_FileName=?,External_FileName=? where ID=?";
	public static final String CHECK_SALARY_DETAILS = "select count(*) from employee_payslip_details where ID=? and StartDate=? and EndDate=?";
	public static final String GET_HOLIDAYS_COUNT = " select count(*) TotalHolidays,group_concat(HOLIDAY_DATE) HOLIDAY_DATE from onsite_holidaymaster where HOLIDAY_DATE between ? and ? and HOLIDAY_DATE not in (select DATE from ai_emp_attendance where status='present' and empid=? and DATE between ? and ?) group by DEPT_ID";
	public static final String GET_WEEKOFF_COUNT = "select SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY from onsite_weekoffmaster where EMP_ID=?";
	public static final String GET_HOLIDAY_LIST = "select attendenceRecon, attendencedate from (select group_concat(distinct Attendence_Date) attendenceRecon from ai_bio_attedence_reconcillatoion where attedence='present' and empid=? and Attendence_Date between ? and ?) k,(select group_concat(distinct DATE ) attendencedate from ai_emp_attendance where status='present' and empid=? and DATE between ? and ?) l";
	 public static final String GET_SHIFT_AMENDMENT_LIST="select distinct ed.EMPID,ed.EMPNAME,sd.AI_SHIFT_NAME,ed.MODIFIEDDATE,bd.DEPT_NAME from ai_emp_details ed,ai_shift_deatails sd,ai_bio_department bd where  sd.Location like ? and  ed.Location like ? and ed.SHIFT_ID=sd.AI_SHIFT_ID and ed.DEPARTMENT = bd.DEPT_ID and DEPARTMENT like ? and SHIFT_ID like ? order by EMPID ";

	 public static final String UPDATE_SHIFT_BY_EMPID="update ai_emp_details set SHIFT_ID=?,MODIFIEDBY=?,MODIFIEDDATE=? where Location like ? and  EMPID=? ";
	 public static final String GET_PERMISSION="select PermissionCode,permission,shortName from ai_bio_permissions";
	 public static final String GET_PERMISSION_BY_ROLE="select permissionCode,isApplicable from ai_bio_role_permissions_mapping where roleCode=?";
	 public static final String INSERT_ROLE_PERMISSION_MAPPING="insert into ai_bio_role_permissions_mapping(permissionCode,roleCode,shortName,isApplicable) values(?,?,?,?)"; 
	 public static final String DELETE_ROLE_PERMISSION_MAPPING="delete from ai_bio_role_permissions_mapping where roleCode like ?";
	 public static final String  GET_LOCATION_BY_GROUP="select el.LocationCode,el.Location from ai_emp_location el,onsite_groupmapping gm where gm.LocationCode=el.LocationCode and gm.Groupid=? order by Location";
	 public static final String  GET_SHIFT_BY_LOCATION="select * from ai_shift_deatails sd  where sd.Location like ? and sd.Location in (select LocationCode from onsite_groupmapping where Groupid=?)";
	 public static final String  GET_EMP_BY_SHIFT="select distinct EMPID,EMPNAME from ai_emp_details  where SHIFT_ID like ? and  isActive='Y' and iSinMultiLocations='N' and SHIFT_ID in (select distinct AI_SHIFT_ID from ai_shift_deatails where  Location like ? and Location in (select LocationCode from onsite_groupmapping where Groupid=? ))";
	 public static final String  GET_DETAILED_MONTH_REPORT="select distinct bt.EMP_ID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,bt.ATTENDANCE_DATE,bt.IN_TIME,bt.OUT_TIME,bt.TOTAL_HOURS,bt.TOTAL_WORKING_HOURS,bt.LATE_TIME,bt.EARLY_TIME,ea.status from ai_bio_timesheet bt,ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,onsite_groupmapping gm where gm.LocationCode=ed.Location and ea.empid=ed.EMPID and bt.EMP_ID=ed.EMPID  and ed.SHIFT_ID=sd.AI_SHIFT_ID and ed.Location=el.LocationCode and sd.Location=el.LocationCode and bt.ATTENDANCE_DATE=ea.DATE  and gm.Groupid=? and  ed.Location like ? and ed.SHIFT_ID like ?  and bt.EMP_ID like ? and bt.ATTENDANCE_DATE like ?  and ed.isActive='Y'  order by ATTENDANCE_DATE,EMP_ID";
	 public static final String  GET_CONSOLIDATED_MONTH_REPORT="select distinct bt.EMP_ID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,group_concat(bt.TOTAL_WORKING_HOURS) totalWorkingHours,group_concat(bt.LATE_TIME) totalLateTime,group_concat(bt.EARLY_TIME) totalEarlyTime,sum(case when ea.status='present' then 1 else 0 end) totalPresent   from ai_bio_timesheet bt,ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,onsite_groupmapping gm where gm.LocationCode=ed.Location and ea.empid=ed.EMPID and  bt.EMP_ID=ed.EMPID and ed.SHIFT_ID=sd.AI_SHIFT_ID and ed.Location=el.LocationCode and sd.Location=el.LocationCode and bt.ATTENDANCE_DATE=ea.DATE  and gm.Groupid=? and ed.Location like ? and ed.SHIFT_ID like ?  and bt.EMP_ID like ? and bt.ATTENDANCE_DATE like ?  and ed.isActive='Y' and  ea.status='present' group by EMP_ID,EMPNAME,Location,AI_SHIFT_NAME order by EMP_ID";
	 public static final String GET_EMPLOYEE_BY_DESIGNATION="select distinct EMPID,EMPNAME from ai_emp_details where EMPDESIGNATION=? ";
	 public static final String GET_MANAGER_INFO="select distinct EMPID,EMPNAME from ai_emp_details where iSinMultiLocations='Y'";
	 public static final String GET_LOG_REPORT="select * from  (select * from ( select DATE_ADD(?, INTERVAL ROW DAY) as Date from ( SELECT @row := @row + 1 as row FROM (select 0 union all select 1 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8) t1, (select 0 union all select 1 union all select 3 union all select 4 union all select 5 union all select 6  union all select 7 union all select 8) t2, (select 0 union all select 1 union all select 3 union all select 4 union all select 5 union all select 6  union all select 7 union all select 8) t4, (SELECT @row:=-1) t3 limit ? ) b) c, (select elm.empid,elm.LocationCode,ed.EMPNAME,el.Location from ai_bio_employee_locations_mapping elm,ai_emp_details ed,ai_emp_location el where elm.empid=ed.EMPID and elm.LocationCode=el.LocationCode and ed.iSinMultiLocations='Y' and elm.empid like ?  and ed.Location like ? and ed.Location in (select LocationCode from onsite_groupmapping where Groupid=?)) f) empDetails left outer join (select AI_EMP_ID,AI_EMP_DATE,AI_EMP_TIME,LOCATION_CODE from ai_bio_log_details where AI_EMP_ID like ? and AI_EMP_DATE between ? and ? ) ld on ld.AI_EMP_ID=empDetails.empid and ld.LOCATION_CODE=empDetails.LocationCode and ld.AI_EMP_DATE=empDetails.Date order by empid,Date,Location,AI_EMP_TIME";
	 public static final String GET_EMPLOYEE_BY_LOCATION="select distinct elm.empid EMPID,ed.EMPNAME from ai_emp_details ed,ai_bio_employee_locations_mapping elm where ed.EMPID=elm.empid  and ed. iSinMultiLocations='Y' and isActive='Y' and ed.Location like ? and ed.Location in (select LocationCode from onsite_groupmapping where Groupid=?)";
	 public static final String  GET_TODAYS_EMP_BY_LOCATION="select distinct EMPID,EMPNAME from ai_emp_details  where  isActive='Y' and  Location like ? and Location in (select LocationCode from onsite_groupmapping where Groupid=? ) order by EMPNAME";
	/* public static final String GET_TODAY_REPORT="select badgenumber,group_concat(checktime order by checktime) datetime from checkinout cio,userinfo ui where cio.userid=ui.userid and cio.SN FIND_IN_SET ( ? ) and badgenumber like ? and cio.checktime like ? group by badgenumber order by badgenumber ";*/
	 public static final String GET_MACHINE_NO_BY_LOCATION="select BioMachineNumber from ai_emp_location where isActive='Y' and LocationCode like ? and LocationCode in (select LocationCode from onsite_groupmapping where Groupid=?) ";
	 public static final String GET_EMP_INFO_BY_EMPID="select EMPNAME,sd.AI_SHIFT_NAME,el.Location from ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd where ed.Location=el.LocationCode and ed.SHIFT_ID=sd.AI_SHIFT_ID and ed.isActive='Y' and ed.iSinMultiLocations='N' and ed.EMPID=?";
	 public static final String GET_LOCATION_UPDATE_REPORT="select LocationCode LOCATION_CODE,Location,case when AI_EMP_DATE is null then '-' else AI_EMP_DATE end AI_EMP_DATE,case when lastUpdateTime is null then '-' else lastUpdateTime end lastUpdateTime from ai_emp_location el left outer join  (select AI_EMP_DATE,max(AI_EMP_TIME) lastUpdateTime,LOCATION_CODE from ai_bio_log_details bld inner join ( select max(ea.attedence_date) attendanceDate,ea.LocationCode from ai_bio_time_sheet_etl_audit ea where ea.isCompleted='Y' group by ea.LocationCode ) etlAudit  on bld.AI_EMP_DATE=etlAudit.attendanceDate and bld.LOCATION_CODE=etlAudit.LocationCode group by LOCATION_CODE,AI_EMP_DATE) etl on el.LocationCode=etl.LOCATION_CODE where  el.LocationCode like ? and el.LocationCode in (select LocationCode from  onsite_groupmapping where Groupid=? ) order by length(LocationCode),LocationCode ";
	 public static final String CHECK_DEPARTMENT_DUPLICATE="select count(*) count from ai_bio_department where DEPT_NAME=? and DESCRIPTION=? and LOCATION=?";
	 public static final String INSERT_DAILY_ALLOWANCE="insert into hrms_employee_daily_allowance(Code,Names,HDFC_AC_No,Amount,Project_Manager, Client,Project,Team_Lead,Location,Remarks, Allowance_Date,Posted_Date,Posted_By) values(?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
		
	 
	 public static final String GET_EMPLOYEE_DAILY_ALLOWANCE="select * from hrms_employee_daily_allowance where Allowance_Date=? order by Posted_By,Code";
	 
	 
	 public static final String GET_EMPLOYEE_DAILY_ALLOWANCE_BYMANAGER="select * from hrms_employee_daily_allowance where Allowance_Date=? and Posted_By=? order by Code";
	 public static final String GET_MANAGERNAME_FOR_EMP_DAILY_ALLOWANCE="select distinct Project_Manager,Posted_By from hrms_employee_daily_allowance where Allowance_Date=? order by Posted_By";
	 public static final String CHECK_RECORDS="select count(*) from hrms_employee_daily_allowance where Allowance_Date=?";
	 /** Mritunjay Coding End */

	// ATTENDANCE RECONCILATION
	/*
	 * public static final String GET_DEPARTMENT =
	 * "select DEPT_ID,DEPT_NAME from ai_bio_department"; public static final
	 * String GET_EMPLOYEE =
	 * "select EMPID,EMPNAME from ai_emp_details  where SHIFT_ID=? and DEPARTMENT=?"
	 * ; public static final String GET_EMPLOYEE_ATTENDANCE =
	 * "SELECT empid,empname,status from ai_emp_attendance where DATE=? and status='absent'"
	 * ; public static final String GET_EMPLOYEE_ATTENDANCE1 =
	 * "SELECT empid,empname,status from ai_emp_attendance where DATE=? and empid=? and status='absent'"
	 * ;
	 */
	public static final String UPDATE_ATTENDANCE_RECONCIL = "update ai_emp_attendance set status='Present',reason=?,modifyuser=?,modifydate=now()  where  empname=?  and status='absent' and  DATE=?";

	// ************************* Late comers Report
	// ******************************

	public static final String GET_ALL_SHIFTS = "select AI_SHIFT_ID,AI_SHIFT_NAME,AI_SHIFT_START_TIME,AI_SHIFT_END_TIME from ai_shift_deatails where Location like ?  ";
	public static final String GET_ALL_DEPARTMENTS = "select DEPT_ID,DEPT_NAME from hrms_department";
	public static final String GET_EMPLOYEES = "select EMPID,EMPNAME from ai_emp_details where Location like ? and SHIFT_ID=? and DEPARTMENT=?";
	public static final String GET_EMPLOYEE_REPORT = "select bt.ATTENDANCE_DATE,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,bt.LATE_TIME from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where  bs.Location like ? and  be.Location like ? and be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID=? and bd.DEPT_ID=? and bt.ATTENDANCE_DATE >=? and  bt.ATTENDANCE_DATE<=? and be.EMPID=? and LATE_TIME >?";
	public static final String GET_ALL_EMP_REPORT = "select bt.ATTENDANCE_DATE,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,bt.LATE_TIME from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where  bs.Location like ? and  be.Location like ? and be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID like ? and bd.DEPT_ID like ? and bt.ATTENDANCE_DATE >=? and  bt.ATTENDANCE_DATE<=? and LATE_TIME >?";

	// public static final String GET_LATE_COMERS_REPORT =
	// "select bt.EMP_ID,bt.ATTENDANCE_DATE,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,bt.LATE_TIME,bt.IN_TIME,bt.OUT_TIME from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID like ? and bd.DEPT_ID like ? and be.EMPLOYEETYPE='Normal' and be.EMPID like ? and bt.ATTENDANCE_DATE between ? and ? order by bt.ATTENDANCE_DATE asc,bt.EMP_ID asc";
	public static final String GET_LATE_COMERS_REPORT = "select bt.EMP_ID,bt.ATTENDANCE_DATE,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,bt.LATE_TIME,bt.IN_TIME,bt.OUT_TIME from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where  bs.Location like ? and  be.Location like ? and be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID like ? and bd.DEPT_ID like ? and be.EMPLOYEETYPE='Normal' and be.EMPID like ? and bt.ATTENDANCE_DATE between ? and ? and bt.LATE_TIME>? order by bt.ATTENDANCE_DATE asc,bt.EMP_ID asc";
	// ************************ Emp working lessthan 8hrs *********************

	// public static final String
	// GET_EMPWORKING_LESSTHAN8HRS_REPORT="select bt.ATTENDANCE_DATE,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,bt.TOTAL_WORKING_HOURS from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID=? and bd.DEPT_ID=? and bt.ATTENDANCE_DATE >=? and  bt.ATTENDANCE_DATE<=? and be.EMPID=? and bt.TOTAL_WORKING_HOURS <?";
	public static final String GET_ALL_EMPWORKING_LESSTHAN8HRS_REPORT = "select bt.ATTENDANCE_DATE,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,bt.TOTAL_WORKING_HOURS from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where  bs.Location like ? and  be.Location like ? and be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID like ? and bd.DEPT_ID like ? and bt.ATTENDANCE_DATE >=? and  bt.ATTENDANCE_DATE<=? and bt.TOTAL_WORKING_HOURS <?";
	public static final String GET_EMP_WORKING_LESS_THAN_8_HRS = "select distinct ATTENDANCE_DATE,EMP_ID,TOTAL_WORKING_HOURS,EMPNAME,sd.AI_SHIFT_NAME,bd.DEPT_NAME from ai_bio_timesheet bt,ai_emp_details ed, ai_shift_deatails sd,ai_bio_department bd where   sd.Location like ? and  ed.Location like ? and ed.EMPID=bt.EMP_ID and  ed.SHIFT_ID=sd.AI_SHIFT_ID and ed.DEPARTMENT=bd.DEPT_ID  and AI_SHIFT_ID like ? and DEPT_ID like ? and ed.EMPLOYEETYPE='Normal' and EMPID like ? and ATTENDANCE_DATE between ? and  ? and left(TOTAL_WORKING_HOURS,2)<8 order by ATTENDANCE_DATE,EMP_ID";
	// ********** audit report

	public static final String GET_EMPLOYEES_WITH_SHIFTID_DEPTID = "select EMPID,EMPNAME from ai_emp_details where Location like ? and SHIFT_ID like ? and DEPARTMENT like ? and EMPLOYEETYPE='Normal'";
	public static final String GET_EMPLOYEES_WITH_SHIFTID = "select EMPID,EMPNAME from ai_emp_details where Location like ? and SHIFT_ID=? and DEPARTMENT like '%%' and EMPLOYEETYPE='Normal'";
	public static final String GET_EMPLOYEES_WITH_DEPTID = "select EMPID,EMPNAME from ai_emp_details where Location like ? and SHIFT_ID like '%%' and DEPARTMENT=? and EMPLOYEETYPE='Normal'";
	public static final String GET_ALL_EMPLOYEES = "select EMPID,EMPNAME from ai_emp_details where Location like ? and SHIFT_ID like '%%' and DEPARTMENT like '%%' and EMPLOYEETYPE='Normal'";
	public static final String GET_AUDIT_REPORT_FOR_ONEEMP = "select ba.emp_name,ba.previous_status,ba.current_status,ba.reason,attendece_date,ba.modifiedby,ba.modifiedDate from ai_bio_attedence_audit ba join ai_emp_details emp on emp.EMPID=ba.empid  where  emp.Location like ? and ba.empid=? and ba.previous_status=? and ba.current_status=? and ba.attendece_date>=? and ba.attendece_date<=? and emp.EMPLOYEETYPE='Normal'";
	public static final String GET_AUDIT_REPORT_FOR_ALLEMP = "select ba.emp_name,ba.previous_status,ba.current_status,ba.reason,ba.attendece_date,ba.modifiedby,ba.modifiedDate from ai_bio_attedence_audit ba join ai_emp_details emp on emp.EMPID=ba.empid where  emp.Location like ? and ba.previous_status=? and ba.current_status=? and ba.attendece_date>=? and ba.attendece_date<=? and emp.EMPLOYEETYPE='Normal'";
	public static final String GET_AUDITREPORT_ONEEMP_WITHOUT_TODATE = "select ba.emp_name,ba.previous_status,ba.current_status,ba.reason,attendece_date,ba.modifiedby,ba.modifiedDate from ai_bio_attedence_audit ba join ai_emp_details emp on emp.EMPID=ba.empid where  emp.Location like ? and ba.empid=? and ba.previous_status=? and ba.current_status=? and ba.attendece_date>=? and emp.EMPLOYEETYPE='Normal'";
	public static final String GET_AUDITREPORT_ALLEMP_WITHOUT_TODATE = "select ba.emp_name,ba.previous_status,ba.current_status,ba.reason,ba.attendece_date,ba.modifiedby,ba.modifiedDate from ai_bio_attedence_audit ba join ai_emp_details emp on emp.EMPID=ba.empid where  emp.Location like ? and ba.previous_status=? and ba.current_status=? and ba.attendece_date>=? and emp.EMPLOYEETYPE='Normal'";

	// ******emp working in early hours

	public static final String GET_EARLYTIME_REPORT_ALL = "select bt.EMP_ID,bt.ATTENDANCE_DATE,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,bt.IN_TIME,bt.OUT_TIME,bt.LATE_TIME,bt.EARLY_TIME from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where  bs.Location like ? and  be.Location like ? and be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID=? and bd.DEPT_ID=? and bt.ATTENDANCE_DATE >=? and  bt.ATTENDANCE_DATE<=? and bt.LATE_TIME >? and bt.EARLY_TIME>? order by bt.ATTENDANCE_DATE asc, bt.EMP_ID asc";
	public static final String GET_EARLYTIME_REPORT_ONE = "select bt.EMP_ID,bt.ATTENDANCE_DATE,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,bt.IN_TIME,bt.OUT_TIME,bt.LATE_TIME,bt.EARLY_TIME from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where  bs.Location like ? and  be.Location like ? and be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID=? and bd.DEPT_ID=? and bt.ATTENDANCE_DATE >=? and  bt.ATTENDANCE_DATE<=? and be.EMPID=? and bt.LATE_TIME >? and bt.EARLY_TIME>? order by bt.ATTENDANCE_DATE asc, bt.EMP_ID asc";

	// ******emp working in early hours for consolidate report

	public static final String GET_LATE_EARLY_TIME_CONSOLIDATE_REPORT = "select bt.EMP_ID,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,GROUP_CONCAT(bt.LATE_TIME) lt,GROUP_CONCAT(bt.EARLY_TIME) et from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where  bs.Location like ? and  be.Location like ? and be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID=? and bd.DEPT_ID=? and bt.ATTENDANCE_DATE >=? and  bt.ATTENDANCE_DATE<=? and be.EMPID=? and bt.LATE_TIME >? and bt.EARLY_TIME>? GROUP BY bt.EMP_ID ";
	public static final String GET_ALL_LATE_EARLY_TIME_CONSOLIDATE_REPORT = "select bt.EMP_ID,be.EMPNAME,bs.AI_SHIFT_NAME,bd.DEPT_NAME,GROUP_CONCAT(bt.LATE_TIME) lt,GROUP_CONCAT(bt.EARLY_TIME) et from ai_bio_timesheet bt,ai_emp_details be,ai_shift_deatails bs,ai_bio_department bd where  bs.Location like ? and  be.Location like ? and be.EMPID=bt.EMP_ID and bs.AI_SHIFT_ID=be.SHIFT_ID and be.DEPARTMENT =bd.DEPT_ID and bs.AI_SHIFT_ID=? and bd.DEPT_ID=? and bt.ATTENDANCE_DATE >=? and  bt.ATTENDANCE_DATE<=? and bt.LATE_TIME >? and bt.EARLY_TIME>? GROUP BY bt.EMP_ID";

	
	public static final String GET_SHIFT = "select AI_SHIFT_ID,AI_SHIFT_NAME from ai_shift_deatails where Location like ? ";
	public static final String GET_EMPLOYEE = "select EMPID,EMPNAME from ai_emp_details  where Location like ? and  SHIFT_ID=? and DEPARTMENT=?";
	public static final String GET_EMP_ID = "select empid from ai_emp_attendance where empname=? and DATE=? and status='absent'";
	public static final String GET_EMPLOYEE_COUNT = "select count(*) from ai_bio_attedence_reconcillatoion where empid=? and Attendence_Date=?";
	public static final String UPDATE_ATTENDANCE_ISRECONCILED = "update  ai_emp_attendance set isReconciled='Y',createdate=?,modifyuser=?,modifydate=now() where empid=? and DATE=?";

	
	
	public static final String AUDIT_REPORT_RECONCILIATION = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and br.empid like ? and emp.DEPARTMENT like ? and emp.SHIFT_ID like ? and emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";
	public static final String EMPLOYEE_PRODUCTIVITY_REPORT = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where  s.Location like ? and  e.Location like ? and  e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? and e.EMPID like ? and d.DEPT_ID like ? and s.AI_SHIFT_ID like ?  order by p.ATTENDANCE_DATE asc,e.EMPID asc";
	/*	
	public static final String AUDIT_REPORT_RECONCILIATION_1 = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and                emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";
	public static final String AUDIT_REPORT_RECONCILIATION_2 = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and br.empid=?       and emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";
	public static final String AUDIT_REPORT_RECONCILIATION_3 = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and emp.DEPARTMENT=? and emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";
	public static final String AUDIT_REPORT_RECONCILIATION_4 = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and br.empid=? and emp.DEPARTMENT=? and emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";

	public static final String AUDIT_REPORT_RECONCILIATION_5 = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and emp.SHIFT_ID=? and emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";
	public static final String AUDIT_REPORT_RECONCILIATION_6 = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and br.empid=? and emp.SHIFT_ID=? and emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";
	public static final String AUDIT_REPORT_RECONCILIATION_7 = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and emp.DEPARTMENT=? and emp.SHIFT_ID=? and emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";
	public static final String AUDIT_REPORT_RECONCILIATION_8 = "select Distinct emp.empid,emp.EMPNAME,br.Attendence_Date,at.status as previousStatus,br.attedence as CurrentStatus,br.reason,br.modified_by,br.modified_date from ai_bio_attedence_reconcillatoion br join ai_emp_attendance at on br.empid=at.empid join ai_emp_details emp on emp.EMPID=br.empid and emp.EMPID = at.empid where  emp.Location like ? and at.isReconciled='Y' and at.DATE between ?  and ? and br.empid=? and emp.DEPARTMENT=? and emp.SHIFT_ID=? and emp.EMPLOYEETYPE='Normal' order by br.Attendence_Date asc,emp.empid";

	public static final String EMPLOYEE_PRODUCTIVITY_REPORT_1 = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where  e.Location like ? and e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? order by p.ATTENDANCE_DATE asc,e.EMPID asc";
	public static final String EMPLOYEE_PRODUCTIVITY_REPORT_2 = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where e.Location like ? and  e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? and e.EMPID=? order by p.ATTENDANCE_DATE asc,e.EMPID asc";
	public static final String EMPLOYEE_PRODUCTIVITY_REPORT_3 = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where  e.Location like ? and  e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? and d.DEPT_ID=? order by p.ATTENDANCE_DATE asc,e.EMPID asc";
	public static final String EMPLOYEE_PRODUCTIVITY_REPORT_4 = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where  e.Location like ? and  e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? and d.DEPT_ID=? and e.EMPID=? order by p.ATTENDANCE_DATE asc,e.EMPID asc";
	public static final String EMPLOYEE_PRODUCTIVITY_REPORT_5 = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where  e.Location like ? and  e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? and s.AI_SHIFT_ID=?  order by p.ATTENDANCE_DATE asc,e.EMPID asc";
	public static final String EMPLOYEE_PRODUCTIVITY_REPORT_6 = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where  e.Location like ? and  e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? and e.EMPID=? and s.AI_SHIFT_ID=?  order by p.ATTENDANCE_DATE asc,e.EMPID asc";
	public static final String EMPLOYEE_PRODUCTIVITY_REPORT_7 = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where  e.Location like ? and  e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? and d.DEPT_ID=? and s.AI_SHIFT_ID=? order by p.ATTENDANCE_DATE asc,e.EMPID asc";
	public static final String EMPLOYEE_PRODUCTIVITY_REPORT_8 = "SELECT  e.EMPID, e.empname, p.ATTENDANCE_DATE, p.IN_TIME, p.OUT_TIME,p.LATE_TIME,p.EARLY_TIME,p.TOTAL_WORKING_HOURS as WORKEDHOURS,s.AI_SHIFT_NAME,d.DEPT_NAME  from ai_bio_timesheet p join ai_emp_details e on e.EMPID=p.EMP_ID  join ai_shift_deatails s on s.AI_SHIFT_ID=e.SHIFT_ID join ai_bio_department d on d.DEPT_ID=e.DEPARTMENT where  e.Location like ? and  e.EMPLOYEETYPE='Normal'  and p.ATTENDANCE_DATE between ? and ? and d.DEPT_ID=? and e.EMPID=? and s.AI_SHIFT_ID=?  order by p.ATTENDANCE_DATE asc,e.EMPID asc";
*/
	
	//TIMESHEET REPORT
	public static final String GET_EMP_ATTENDANCE_ALL = "select bio.EMP_ID,emp.EMPNAME,bio.ATTEDANCE_DATE,bio.UPDATED_BY,bio.UPDATED_TIME from ai_bio_timesheet_audit bio,ai_emp_details emp where  emp.Location like ? and bio.EMP_ID=emp.EMPID and bio.ATTEDANCE_DATE>=? and bio.ATTEDANCE_DATE<=? order by UPDATED_TIME  asc";
	public static final String GET_EMP_ATTENDANCE_ONE = "select bio.EMP_ID,emp.EMPNAME,bio.ATTEDANCE_DATE,bio.UPDATED_BY,bio.UPDATED_TIME from ai_bio_timesheet_audit bio,ai_emp_details emp where  emp.Location like ? and  bio.EMP_ID=emp.EMPID  and  bio.EMP_ID=? and bio.ATTEDANCE_DATE>=? and bio.ATTEDANCE_DATE<=? order by UPDATED_TIME  asc";
	public static final String GET_EMP_TIMESHEET = "select PREVIOUS_INTIME,PREVIOUS_OUTTIME,PREVIOUS_TOTALHOURS,PREVIOUS_WORKING_HOURS,PREVIOUS_MOR_LATE,PREVIOUS_EVE_EARLY,PREVIOUS_LATETIME,PREVIOUS_EARLYTIME,CURRENT_INTIME,CURRENT_OUTTIME,CURRENT_TOTALHOURS,CURRENT_WORKING_HOURS,CURRENT_MOR_LATE,CURRENT_EVE_EARLY,CURRENT_LATETIME,CURRENT_EARLYTIME,UPDATED_BY,UPDATED_TIME from ai_bio_timesheet_audit where EMP_ID=? and ATTEDANCE_DATE=? and UPDATED_TIME=?";

	//breakup master
	
	   public static final String GET_BREAKUP_MASTER="select BreakCode,BreakName,StartTime,EndTime,TotalTime from ai_bio_break";
	    public static final String EDIT_BREAKUP_MASTER="update ai_bio_break set BreakName=?,StartTime=?, EndTime=? ,TotalTime=?,UpdateUser=?,UpdateTime=? where BreakCode=?";
	    public static final String ADD_BREAKUP_MASTER="insert into ai_bio_break(BreakCode,BreakName,StartTime,EndTime,TotalTime,CreateUser,CreateDate) values(?,?,?,?,?,?,?)";
	    public static final String DELETE_BREAKUP_MASTER="delete from ai_bio_break where BreakCode=?";
	    public static final String GET_BREAKUP_MASTERCHECK="select count(*) from ai_bio_break where StartTime =? and EndTime =?";
	    public static final String GET_BREAKUP_NAMES="select BreakName from ai_bio_break";
	    public static final String VALIDATE_BREAK_NAME="select count(*) breakname from ai_bio_break where BreakName=? and BreakCode!=?";
	    public static final String VALIDATE_BREAK_TIME="select count(*) time from ai_bio_break where StartTime =? and EndTime =? and BreakCode!=?";

	    
	    //uploadxsl
		public static final String GET_SHIFT_ID = "select AI_SHIFT_ID from ai_shift_deatails where  AI_SHIFT_NAME like ? order by AI_SHIFT_NAME   limit 1";
		public static final String GET_EMP_DATA = "select * from ai_emp_details where EMPID=?";
		public static final String GET_DEPT_ID = "select DEPT_ID from ai_bio_department where DEPT_NAME like ? order by DEPT_NAME limit 1";
		public static final String GET_SHIFT_NAME = "select AI_SHIFT_NAME from ai_shift_deatails where  AI_SHIFT_ID=?";
		public static final String GET_DEPT_NAME = "select DEPT_NAME from ai_bio_department where DEPT_ID=?";
		public static final String UPDATE_EMP = "update ai_emp_details set EMPNAME=?,PHONE=?,EMAIL=?,SHIFT_ID=?,EMPDESIGNATION=?,EMPADDRESS=?,EMPLOYEETYPE=?,DEPARTMENT=?,DOB=?,DOJ=?,FATHERNAME=?, MODIFIEDBY=?,MODIFIEDDATE=? where EMPID=?";

		
		
		//RoleMaster  Satish Starts
		public static final String VALIDATE_ROLE_NAME="select count(*) RoleName from ai_role where RoleName=?";
		public static final String VALIDATE_ROLE_CODE="select count(*) RoleCode from ai_role where RoleCode=?";
		
		public static final String ADD_ROLE = "insert into ai_role(RoleCode,RoleName,Description,createdby) values(?,?,?,?)";	
		public static final String GET_ROLES="select RoleCode,RoleName,Description from ai_role";
		public static final String GET_LOCATION="select LocationCode,Location from ai_emp_location where isActive='Y'";
		
		public static final String UPDATE_ROLE="update ai_role set RoleName=?,Description=?,modifiedby=?,modifiedtime=? where RoleCode=?";
		public static final String VALIDATE_ROLE_NAME_UPDATE="select count(*) RoleName from ai_role where RoleName=? and RoleCode!=? ";
		public static final String DELETE_ROLE="delete from ai_role where RoleCode=?";
		public static final String UPDATE_ROLES="select * from ai_role where RoleCode=?";
		public static final String CHECK_ROLE_USER_MAPPING="select count(*) from ai_user where roleCode=?";
		//RoleMaster Ends

		
				//Shift Creation   
				   public static final String SELECT_SHIFT_DETAILS= "select sft.AI_SHIFT_ID,sft.AI_SHIFT_NAME,sft.AI_SHIFT_START_TIME,sft.AI_SHIFT_END_TIME,sft.AI_SHIFT_LTOC,sft.AI_SHIFT_ETOG,sft.AI_SHIFT_LTOC_GC,sft.AI_SHIFT_ETOG_GC,sft.AI_SHIFT_LTOC_NO_EXEC,sft.AI_SHIFT_ETOG_NO_EXEC,sft.AI_SHIFT_LTOC_LD,sft.AI_SHIFT_ETOG_LD,loc.Location,sft.Location as locationid from ai_emp_location loc,ai_shift_deatails sft where sft.Location=loc.LocationCode and sft.Location in (select LocationCode from onsite_groupmapping where Groupid=?) order by AI_SHIFT_NAME";
				   public static final String INSERT_SHIFT_DETAILS= "insert into ai_shift_deatails(AI_SHIFT_ID,AI_SHIFT_NAME,AI_SHIFT_START_TIME,AI_SHIFT_END_TIME,AI_SHIFT_LTOC,AI_SHIFT_ETOG,AI_SHIFT_LTOC_GC,AI_SHIFT_ETOG_GC,AI_SHIFT_LTOC_NO_EXEC,AI_SHIFT_ETOG_NO_EXEC,AI_SHIFT_LTOC_LD,AI_SHIFT_ETOG_LD,AI_SHIFT_CREATE_USER,AI_SHIFT_CREATE_TIME,Location) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					public static final String UPDATE_SHIFT_DETAILS="update ai_shift_deatails set AI_SHIFT_NAME=?,ai_shift_start_time=?,ai_shift_end_time=?,ai_shift_ltoc=?,ai_shift_etog=?,ai_shift_ltoc_gc=?,ai_shift_etog_gc=?,ai_shift_ltoc_no_exec=?,ai_shift_etog_no_exec=?,ai_shift_ltoc_ld=?,ai_shift_etog_ld=?,ai_shift_modify_user=?,ai_shift_modify_time=?,Location=? where ai_shift_id=?";
					public static final String DELETE_SHIFT_DETAILS= "delete from ai_shift_deatails where ai_shift_id=?";
					public static final String GET_SHIFT_NAMES = "select AI_SHIFT_NAME from ai_shift_deatails";
					public static final String GET_SHIFT_COUNT = "select count(*) from ai_shift_deatails where AI_SHIFT_NAME=?";

			
				// GROUP_LOCATION MAPPING
					public static final String GET_GROUP = "select Gorupid,GroupName from onsite_group";
					public static final String GET_LOCATION_DATA = "select el.LocationCode,el.Location from ai_emp_location el where el.LocationCode NOT IN(select og.LocationCode from onsite_groupmapping og) and el.isActive='Y'";
					public static final String INSERT_GROUP_LOCATION = "insert into onsite_groupmapping(LocationCode,Groupid) values(?,?)";
					public static final String GET_MAPPED_LOCATION = "select el.LocationCode,el.Location from onsite_groupmapping og,ai_emp_location el where  og.Groupid=? and  el.LocationCode=og.LocationCode";
					public static final String DELETE_GROUP_MAPPPING = "delete from onsite_groupmapping where Groupid=?";

				//GROUP MASTER	
					
					public static final String GET_GROUP_COUNT = "select count(*) FROM onsite_group WHERE  GroupName = ? ";
					public static final String ADD_GROUP_DETAILS = "insert into onsite_group(Gorupid,GroupName,Description,createdby,createdate) values(?,?,?,?,now())";
					public static final String GET_GROUP_DETAILS = "select Gorupid,GroupName,Description from onsite_group order by Gorupid";
					public static final String EDIT_GROUP_DETAILS = "select * from onsite_group where Gorupid=? order by Gorupid";
					public static final String UPDATE_GROUP_DETAILS = "update onsite_group set GroupName=?,Description=?,modifiedby=?,modifieddate=? where Gorupid=?";
					public static final String DELETE_GROUP = "delete from onsite_group WHERE  Gorupid = ? ";
					public static final String CHECK_GROUP_NAME = "select count(*) from onsite_group where  GroupName =? and Gorupid!=?";
					public static final String CHECK_GROUP_USER_MAPPING="select count(*) from ai_user where groupCode=?";
			//REPORT RECONCILATION
					public static final String GET_TIME_SHEET = "Select bio.EMP_ID,emp.EMPNAME,bio.ATTENDANCE_DATE,bio.IN_TIME,bio.OUT_TIME,bio.TOTAL_HOURS,bio.TOTAL_WORKING_HOURS,bio.MORNING_LATE,bio.EVENING_EARLY from ai_bio_timesheet bio,ai_emp_details emp where bio.EMP_ID=emp.EMPID and emp.EMPNAME=? and bio.ATTENDANCE_DATE=?";
					public static final String GET_EMP = "select emp.EMPID from ai_emp_details emp,ai_bio_timesheet bio  where bio.EMP_ID=emp.EMPID and emp.EMPNAME=?";

					//Week OFF Master
					public static final String getAllEMpWithShiftandDept = "select e.EMPID,e.EMPLOYEETYPE,e.EMPNAME,e.PHONE,e.EMAIL,s.AI_SHIFT_ID ,s.AI_SHIFT_NAME,d.DEPT_ID,d.DEPT_NAME from ai_emp_details e,ai_shift_deatails s,ai_bio_department d where   s.Location like ? and  e.Location like ? and e.SHIFT_ID = s.AI_SHIFT_ID and e.DEPARTMENT = d.DEPT_ID and  e.EMPNAME like ? order by e.EMPNAME limit ?";
					public static final String checkEmpinWeekOffMaster = "select count(*) from onsite_weekoffmaster where EMP_ID =?";
					public static final String insertEmpIntoWeekOff = " insert into onsite_weekoffmaster (EMP_ID,SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,CURRENT_YEAR,CREATEDBY) values (?,?,?,?,?,?,?,?,?,?) ";
					public static final String updateEmpIntoWeekOff = "update onsite_weekoffmaster set SUNDAY= ?, MONDAY = ?,TUESDAY=?,WEDNESDAY = ?, THURSDAY = ?, FRIDAY = ? ,SATURDAY= ?,MODIFIED_BY =?,MODIFIED_DATE=? ,CREATEDDATE=? , CURRENT_YEAR=?where EMP_ID = ? ";
					public static final String CheckCreatedDateWeekOff = "select CREATEDDATE from onsite_weekoffmaster where EMP_ID=?";
					public static final String getweekoffs = "select * from onsite_weekoffmaster where EMP_ID = ?";


					//Attendance Reconcilatiion
					public static final String GET_GROUP_BY_USER = "select g.GroupName,g.Gorupid from onsite_group g,ai_user u where u.groupCode=g.Gorupid and u.username=?";
					public static final String GET_EMPLOYEE_BY_SHIFT_LOCATION = "SELECT EMPID,EMPNAME FROM ai_emp_details WHERE SHIFT_ID=? and Location= ?";
					public static final String GET_ALL_EMPLOYEE_ATTENDANCE = "SELECT empid,empname,status from ai_emp_attendance where DATE=? and status='absent' and isReconciled='N' order by empid asc,DATE asc";
					public static final String GET_SINGLE_EMPLOYEE_ATTENDANCE = "SELECT empid,empname,status from ai_emp_attendance where DATE=? and empid=? and status='absent' and isReconciled='N' order by empid asc,DATE asc";
					public static final String INSERT_ATTENDANCE_RECONCIL = "insert into ai_bio_attedence_reconcillatoion(empid,Attendence_Date,attedence,reason,short_name,modified_by,modified_date) values(?,?,?,?,?,?,now())";
					public static final String GET_CREATEDDATE = "select createdate from ai_emp_attendance where empid=? and DATE=?";
					public static final String GET_EMPLOYEE_BY_ALL_SHIFT_LOCATION = "SELECT EMPID,EMPNAME FROM ai_emp_details WHERE Location=?";
					public static final String GET_SHIFT_BY_LOCATION1 = "select AI_SHIFT_ID,AI_SHIFT_NAME from ai_shift_deatails where Location=?";
					


			//Day  Report 		
public static final String GET_DAY_REPORT_DETAILS="select distinct ed.EMPID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,ea.status,bt.IN_TIME,bt.OUT_TIME,bt.LATE_TIME,bt.EARLY_TIME,bt.ATTENDANCE_DATE  from ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,ai_bio_timesheet bt where ed.EMPID=bt.EMP_ID and bt.EMP_ID=ea.empid and bt.ATTENDANCE_DATE=ea.DATE and ed.Location=el.LocationCode and  bt.SHIFT_ID=sd.AI_SHIFT_ID AND bt.EMP_ID like ? and ea.DATE BETWEEN ? and ? and ed.isActive='Y' and ed.Location in (select LocationCode from onsite_groupmapping where Groupid=?) order by ATTENDANCE_DATE asc ";
					
					public static final String GET_DAY_REPORT_ENDDATE_DETAILS="select  distinct ed.EMPID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,ea.status,bt.IN_TIME,bt.OUT_TIME,bt.LATE_TIME,bt.EARLY_TIME,bt.ATTENDANCE_DATE  from ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,ai_bio_timesheet bt where ed.EMPID=bt.EMP_ID and bt.EMP_ID=ea.empid and bt.ATTENDANCE_DATE=ea.DATE and ed.Location=el.LocationCode and bt.SHIFT_ID=sd.AI_SHIFT_ID AND bt.EMP_ID like ? and ea.DATE  <= ? and ed.isActive='Y' and ed.Location in (select LocationCode from onsite_groupmapping where Groupid=?) order by ATTENDANCE_DATE desc ";
					public static final String GET_DAY_REPORT_STARTDATE_DETAILS="select distinct ed.EMPID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,ea.status,bt.IN_TIME,bt.OUT_TIME,bt.LATE_TIME,bt.EARLY_TIME,bt.ATTENDANCE_DATE from ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,ai_bio_timesheet bt where ed.EMPID=bt.EMP_ID and bt.EMP_ID=ea.empid and bt.ATTENDANCE_DATE=ea.DATE and ed.Location=el.LocationCode and bt.SHIFT_ID=sd.AI_SHIFT_ID  AND bt.EMP_ID like ? and ea.DATE >=? and ed.isActive='Y'  and ed.Location in (select LocationCode from onsite_groupmapping where Groupid=?)  order by ATTENDANCE_DATE asc ";


					public static final String GET_TIMESHEET_DATA="select EMPID,EMPNAME,ATTENDANCE_DATE,EMP_ID,IN_TIME,OUT_TIME,TOTAL_HOURS,TOTAL_WORKING_HOURS from ai_emp_details  left outer join (select ATTENDANCE_DATE,EMP_ID,IN_TIME,OUT_TIME,TOTAL_HOURS,TOTAL_WORKING_HOURS,MORNING_LATE,EVENING_EARLY from ai_bio_timesheet where  EMP_ID like ? and ATTENDANCE_DATE between ? and ? ) bt on ai_emp_details.EMPID=bt.EMP_ID  where EMPID like ?  order by ATTENDANCE_DATE,EMPNAME";
					public static final String CHECK_TIMESHEET_EMPLOYEE="select count(*) from ai_bio_timesheet where  EMP_ID=? and ATTENDANCE_DATE=?";
					public static final String UPDATE_TIMESHEET="UPDATE ai_bio_timesheet SET IN_TIME=? ,OUT_TIME=?,TOTAL_HOURS=?,TOTAL_WORKING_HOURS=? WHERE  EMP_ID=? and ATTENDANCE_DATE=?";
					public static final String INSERT_TIMESHEET="insert into ai_bio_timesheet(EMP_ID,ATTENDANCE_DATE,IN_TIME,OUT_TIME,TOTAL_HOURS,TOTAL_WORKING_HOURS) values(?,?,?,?,?, ?)";
					//LateCommers  Report 
					public static final String GET_LATE_COMMERS_REPORT="select ed.EMPID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,bt.ATTENDANCE_DATE,bt.IN_TIME,bt.OUT_TIME,bt.LATE_TIME from ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,ai_bio_timesheet bt where ed.EMPID=bt.EMP_ID and bt.EMP_ID=ea.empid and bt.ATTENDANCE_DATE=ea.DATE and ed.Location=el.LocationCode and ed.SHIFT_ID=sd.AI_SHIFT_ID AND bt.EMP_ID like ? and ea.DATE BETWEEN ? and ?  and ed.isActive='Y'  AND   bt.MORNING_LATE NOT IN(0)";

				
		//Early Time Report
					public static final String GET_EARLY_TIME_REPORT="select distinct ed.EMPID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,bt.ATTENDANCE_DATE,bt.IN_TIME,bt.OUT_TIME,bt.EARLY_TIME from ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,ai_bio_timesheet bt where ed.EMPID=bt.EMP_ID and bt.EMP_ID=ea.empid and bt.ATTENDANCE_DATE=ea.DATE and ed.Location=el.LocationCode and ed.SHIFT_ID=sd.AI_SHIFT_ID AND bt.EMP_ID like ? and ea.DATE BETWEEN ? and ? and ed.isActive='Y'  AND  bt.EVENING_EARLY NOT IN(0)";
	

					
					//MONTHLY LAGEND REPORT START BY SESHU
					
					public static final String GET_SHIFT_FOR_MONTHLYREPORT="select AI_SHIFT_ID,AI_SHIFT_NAME from ai_shift_deatails where Location=?";
					public static final String GET_DEPT_FOR_MONTHLYREPORT="select DEPT_ID,DEPT_NAME from ai_bio_department where LOCATION=?";
					public static final String GET_ALL_SHIFT_FOR_MONTHLYREPORT="select AI_SHIFT_ID,AI_SHIFT_NAME from ai_shift_deatails where Location in (select LocationCode from onsite_groupmapping where Groupid=?)";
					public static final String GET_ALL_DEPT_FOR_MONTHLYREPORT="select DEPT_ID,DEPT_NAME from ai_bio_department";
					public static final String GET_LOCATION_FOR_MONTHLYREPORT="select l.LocationCode,l.Location from ai_emp_location l,onsite_groupmapping g where g.Groupid=? and l.LocationCode=g.LocationCode and l.isActive='Y' order by Location asc";
			      	public static final String GET_ALL_LOCATIONS_FOR_MONTHLYREPORT="select LocationCode,Location from ai_emp_location where  isActive='Y' and LocationCode in (select LocationCode from onsite_groupmapping where Groupid=?) order by Location asc";
						public static final String GET_MONTH_LEGEND_ALL_EMPLOYEE = "select EMPID,EMPNAME from ai_emp_details  where SHIFT_ID in (select AI_SHIFT_ID from ai_shift_deatails where Location in (select LocationCode from onsite_groupmapping where Groupid=?))and iSinMultiLocations='N'";
						public static final String GET_ATTENDANCE_COUNT = "select count(*) from ai_emp_attendance where DATE like ?";
						public static final String GET_EMPLOYEE_BY_DEPT = "select EMPID,EMPNAME from ai_emp_details WHERE DEPARTMENT=? and SHIFT_ID in (select AI_SHIFT_ID from ai_shift_deatails where Location in (select LocationCode from onsite_groupmapping where Groupid=?))and iSinMultiLocations='N'";
						public static final String GET_EMPLOYEE_BY_SHIFT = "select EMPID,EMPNAME from ai_emp_details WHERE SHIFT_ID=?";
						public static final String GET_EMPLOYEE_BY_SHIFT_AND_DEPT = "select EMPID,EMPNAME from ai_emp_details WHERE SHIFT_ID=? and DEPARTMENT=?";
						public static final String GET_EMPLOYEE_BY_ID = "select empname from ai_emp_attendance where empid=?";
						public static final String GET_EMPLOYEE_MONTH_REPORT = "select a.status from ai_emp_attendance a where  DATE=? and empid=?";
						public static final String GET_EMPLOYEE_WORKING_LESSTHAN_8HRS="select ed.EMPID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,bt.ATTENDANCE_DATE,bt.IN_TIME,bt.OUT_TIME,bt.LATE_TIME,bt.EARLY_TIME,bt.TOTAL_WORKING_HOURS,ea.status from ai_bio_timesheet bt,ai_emp_details ed, ai_shift_deatails sd,ai_emp_attendance ea,ai_emp_location el where ed.EMPID=bt.EMP_ID and bt.EMP_ID=ea.empid and bt.ATTENDANCE_DATE=ea.DATE and ed.Location=el.LocationCode and ed.SHIFT_ID=sd.AI_SHIFT_ID AND bt.EMP_ID like ? and ea.DATE BETWEEN ? and ? and ed.isActive='Y' and left(TOTAL_WORKING_HOURS,2)<8";
					
//locationbasedshift by seshu
						public static final String GET_LOCATION_BASED_SHIFT="select s.AI_SHIFT_ID,s.AI_SHIFT_NAME,l.LocationCode,l.Location from ai_shift_deatails s,ai_emp_location l  where s.Location=? and s.Location=l.LocationCode";


						
						/*chiru timereport*/
						public static final String GET_SHIFT_NAMES_DETAILS ="select AI_SHIFT_ID,AI_SHIFT_NAME from ai_shift_deatails";
						public static final String GET_DEPARTMENT ="select DEPT_ID,DEPT_NAME from ai_bio_department";
						public static final String GET_EMPLOYEES_WITH_SHIFTID_DEPTID1 ="select EMPID,EMPNAME from ai_emp_details where SHIFT_ID=? and DEPARTMENT=? and EMPLOYEETYPE='Normal'";
						public static final String GET_EMPLOYEES_WITH_SHIFTID1 ="select EMPID,EMPNAME from ai_emp_details where SHIFT_ID=? and DEPARTMENT like '%%' and EMPLOYEETYPE='Normal'";
						public static final String GET_EMPLOYEES_WITH_DEPTID1 ="select EMPID,EMPNAME from ai_emp_details where SHIFT_ID like '%%' and DEPARTMENT=? and EMPLOYEETYPE='Normal'";
						public static final String GET_ALL_EMPLOYEES1 = "select EMPID,EMPNAME from ai_emp_details where SHIFT_ID like '%%' and DEPARTMENT like '%%' and EMPLOYEETYPE='Normal'";
						
						public static final String GET_EMP_ATTENDANCE_ALL1 ="select bio.EMP_ID,emp.EMPNAME,bio.ATTEDANCE_DATE,bio.UPDATED_BY,bio.UPDATED_TIME from ai_bio_timesheet_audit bio,ai_emp_details emp where bio.EMP_ID=emp.EMPID and bio.ATTEDANCE_DATE>=? and bio.ATTEDANCE_DATE<=? order by UPDATED_TIME  asc";
						public static final String GET_EMP_ATTENDANCE_ONE1 ="select bio.EMP_ID,emp.EMPNAME,bio.ATTEDANCE_DATE,bio.UPDATED_BY,bio.UPDATED_TIME from ai_bio_timesheet_audit bio,ai_emp_details emp where bio.EMP_ID=emp.EMPID  and  bio.EMP_ID=? and bio.ATTEDANCE_DATE>=? and bio.ATTEDANCE_DATE<=? order by UPDATED_TIME  asc";
						/*chiru timereport*/
						
						//seshu
						
						public static final String GET_GROUP_BASED_SHIFT="select * from ai_shift_deatails sd where sd.Location in (select LocationCode from onsite_groupmapping where Groupid=?)";
						public static final String CHECT_SHIFT_LOCATION_DUPLICATE="select count(*) from ai_shift_deatails where AI_SHIFT_NAME=? and Location=?";
						public static final String CHECK_SHIFT_LOCATION_DUPLICATE_UPDATE="select count(*) from ai_shift_deatails where AI_SHIFT_NAME=? and Location=? and AI_SHIFT_ID!=?";
						public static final String CHECK_SHIFT_EMPLOYEE_MAP="select count(*) from ai_emp_details where SHIFT_ID=?";
						//satish
						public static final String GET_GROUP_BY_CURRENTUSER="select distinct  bg.GroupName,bg.Gorupid from onsite_group bg,ai_user bu where bg.Gorupid=bu.groupCode and  bu.userCode=?";
						public static final String GET_EMPDETAILS_BY_LATECOMMERS="select distinct EMPID,EMPNAME from ai_emp_details  where SHIFT_ID like ? and  isActive='Y' and iSinMultiLocations='N' and SHIFT_ID in (select distinct AI_SHIFT_ID from ai_shift_deatails where  Location like ? and Location in (select LocationCode from onsite_groupmapping where Groupid=? ))";

						

						// Arul for Change Password
						public static final String GETPASSWORD_FORCURRENTUSER = "select password from ai_user where username=?";
						public static final String UPDATEPASSWORD_FORCURRENTUSER = "update ai_user set password=? where username=?  and password=?";


						//Monthly lengend report by seshu
						
						public static final String MONTHLYLEGEND_ALLEMP_BASED_LOCATION="select EMPID,EMPNAME from ai_emp_details  where SHIFT_ID in (select AI_SHIFT_ID from ai_shift_deatails where Location=?)and iSinMultiLocations='N'";
						
						public static final String MONTHLYLEGEND_ALLEMP_BASED_LOCATION_DEPT="select EMPID,EMPNAME from ai_emp_details WHERE DEPARTMENT=? and SHIFT_ID in (select AI_SHIFT_ID from ai_shift_deatails where Location=?)and iSinMultiLocations='N'";


						
						public static final String GET_USERNAME_CHECK ="select count(username) from ai_user where username=?";

						
					public static final String SELECT_LOCATIONS_BY_SEARCH_LOCATION = "select LocationCode,Location,LocationNumber,PropriterAddress,PhoneNo,PropriterName,BioMachineNumber,ContactPerson,TSM_TSE_Name,ContactNumber,EmployeeStrength,Bio_Id_Index_Number from ai_emp_location where isActive='Y' and Location like ? and LocationCode in (select LocationCode from onsite_groupmapping where Groupid=?)";

				
					//Daily Log Report Created BY Swathi
						public static final String GET_LOCATION_COUNT_BY_GROUP = "SELECT COUNT(LocationCode) FROM ai_emp_location WHERE isActive='Y' and LocationCode like ? and LocationCode in (select LocationCode from onsite_groupmapping where Groupid=?)";
						public static final String GET_DAILY_LOG_REPORT = "select group_concat(AI_EMP_TIME order by AI_EMP_ID,AI_EMP_DATE,AI_EMP_TIME) time,AI_EMP_DATE,AI_EMP_ID  from ai_bio_log_details where AI_EMP_ID like ?  and AI_EMP_DATE  between  ?  and ? and AI_EMP_ID in (select EMPID from ai_emp_details) and  LOCATION_CODE like ? group by AI_EMP_ID,AI_EMP_DATE order by AI_EMP_DATE asc,AI_EMP_ID asc";
						public static final String GET_EMP_INFO_BY_ALL_EMPID = "select EMPID,EMPNAME,sd.AI_SHIFT_NAME,el.Location from ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd where ed.Location=el.LocationCode and ed.SHIFT_ID=sd.AI_SHIFT_ID and ed.isActive='Y'";
						public static final String GET_EMP_INFO_BY_EMPIDS = "select EMPID,EMPNAME,el.Location,d.designationName from ai_emp_details ed,ai_emp_location el,ai_emp_designation d where ed.Location=el.LocationCode and ed.EMPDESIGNATION =d.designationId and ed.isActive='Y' and iSinMultiLocations='N' and  ed.EMPID=?";
						public static final String GET_DAILY_LOG_REPORT_END_DATE = "select group_concat(AI_EMP_TIME order by AI_EMP_ID,AI_EMP_DATE,AI_EMP_TIME) time,AI_EMP_DATE,AI_EMP_ID  from ai_bio_log_details where AI_EMP_ID like ?  and AI_EMP_DATE  <=? and  LOCATION_CODE like ? group by AI_EMP_ID,AI_EMP_DATE order by AI_EMP_DATE asc,AI_EMP_ID asc";
						public static final String GET_DAILY_LOG_REPORT_START_DATE = "select group_concat(AI_EMP_TIME order by AI_EMP_ID,AI_EMP_DATE,AI_EMP_TIME) time,AI_EMP_DATE,AI_EMP_ID  from ai_bio_log_details where AI_EMP_ID like ?  and AI_EMP_DATE  >=? and  LOCATION_CODE like ? group by AI_EMP_ID,AI_EMP_DATE order by AI_EMP_DATE asc,AI_EMP_ID asc ";
					//end

					public static final String GET_CONSOLIDATED_MONTH_REPORT_N = "select ed.EMPID,ed.EMPNAME,sd.AI_SHIFT_NAME,dd.DEPT_NAME,att.status,bt.ATTENDANCE_DATE,el.Location,case when bt.TOTAL_WORKING_HOURS ='00:00:00' then '-' else bt.TOTAL_WORKING_HOURS end totalWorkingHours,case when bt.LATE_TIME ='00:00:00' then '-' else bt.LATE_TIME end totalLateTime,case when bt.EARLY_TIME ='00:00:00' then '-' else bt.EARLY_TIME end totalEarlyTime,case when att.status='present' then 'Present' else 'Absent' end totalPresent from ai_emp_details ed join ai_shift_deatails sd on sd.AI_SHIFT_ID=ed.SHIFT_ID join ai_bio_department dd on dd.DEPT_ID=ed.DEPARTMENT join ai_emp_attendance att on att.empid=ed.EMPID join ai_bio_timesheet bt on bt.EMP_ID = ed.EMPID and bt.ATTENDANCE_DATE=att.DATE join ai_emp_location el on el.LocationCode=ed.Location join onsite_groupmapping gm on gm.LocationCode=ed.Location where  gm.Groupid=? and  el.LocationCode like ? and sd.AI_SHIFT_ID like ?  and bt.EMP_ID like ? and bt.ATTENDANCE_DATE = ? and ed.isActive='Y'  order by bt.ATTENDANCE_DATE asc, ed.EMPID ";
					public static final String GET_DAYCONSOLIDATED_MONTH_REPORT = "select ed.EMPID,ed.EMPNAME,sd.AI_SHIFT_NAME,dd.DEPT_NAME,att.status,bt.ATTENDANCE_DATE,el.Location,case when bt.TOTAL_WORKING_HOURS ='00:00:00' then '-' else bt.TOTAL_WORKING_HOURS end totalWorkingHours,case when bt.LATE_TIME ='00:00:00' then '-' else bt.LATE_TIME end totalLateTime,case when bt.EARLY_TIME ='00:00:00' then '-' else bt.EARLY_TIME end totalEarlyTime,case when att.status='present' then 'Present' else 'Absent' end totalPresent from ai_emp_details ed join ai_shift_deatails sd on sd.AI_SHIFT_ID=ed.SHIFT_ID join ai_bio_department dd on dd.DEPT_ID=ed.DEPARTMENT join ai_emp_attendance att on att.empid=ed.EMPID join ai_bio_timesheet bt on bt.EMP_ID = ed.EMPID and bt.ATTENDANCE_DATE=att.DATE join ai_emp_location el on el.LocationCode=ed.Location join onsite_groupmapping gm on gm.LocationCode=ed.Location where  gm.Groupid=? and  el.LocationCode like ? and sd.AI_SHIFT_ID like ?  and bt.EMP_ID like ? and bt.ATTENDANCE_DATE = ? and ed.isActive='Y'  order by bt.ATTENDANCE_DATE asc, ed.EMPID ";
					public static final String GET_YEARLY_REPORT_DETAILS="select distinct ed.EMPID,ed.EMPNAME,el.Location,sum( case when ea.status='present' then 1 else 0 end) totalPresent,sum( case when ea.status='absent' then 1 else 0 end) totalAbsent,sum( case when ea.status='casual' then 1 else 0 end) totalCasual,sum( case when ea.status='weekoff' then 1 else 0 end) totalWeekoff,sum( case when ea.status='otherleave' then 1 else 0 end) totalotherLeaves,sum( case when ea.status='holiday' then 1 else 0 end) totalHoliday,sum( case when ea.status='weekoffpayble' then 1 else 0 end) weekoffPayble ,sum(case when ea.status='sickleave' then 1 else 0 end) totalSickLeaves ,sum( case when ea.status='holidaypayable' then 1 else 0 end) holidayPayable,sum( case when ea.status='payableleave' then 1 else 0 end) payableLeaves from ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,ai_bio_timesheet bt where ed.EMPID=bt.EMP_ID and bt.EMP_ID=ea.empid and bt.ATTENDANCE_DATE=ea.DATE and ed.Location=el.LocationCode and  bt.SHIFT_ID=sd.AI_SHIFT_ID AND bt.EMP_ID like ? and ea.DATE like ? and ed.isActive='Y' and ed.Location in (select LocationCode from onsite_groupmapping where Groupid= ?) group by ed.EMPID,ed.EMPNAME,el.Location order by EMPID asc ";
					public static final String GET_YEARLY_REPORT_DETAILS_EMPLOYEES="select ed.EMPNAME,el.Location from ai_emp_details ed,ai_emp_location el where el.LocationCode=ed.Location and  ed.EMPID=? ";
					public static final String EMPLOYEES_COUNT = "select count(*) from ai_emp_details where isActive='Y' and Location=? ";
					
					public static final String ETL_SHIFT_FETCH = "select s.AI_SHIFT_ID,s.AI_SHIFT_NAME,s.AI_SHIFT_START_TIME,s.AI_SHIFT_END_TIME,s.AI_SHIFT_LTOC,s.AI_SHIFT_ETOG, l.LocationCode,l.Location from ai_shift_deatails s,ai_emp_location l  where s.Location=? and s.Location=l.LocationCode";
					public static final String GETGROUP_LOGREPORT = "select att.DATE,grp.GroupName,loc.Location,count(emp.EMPID) as TotalEmployee,sum(case when att.status='present' then 1 else 0 end) TotalPresent,sum(case when att.status='absent' then 1 else 0 end) TotalAbsent,loc.LocationCode from onsite_groupmapping grpm join onsite_group grp on grp.Gorupid=grpm.Groupid join ai_emp_location loc on loc.LocationCode=grpm.LocationCode join ai_emp_details emp on emp.Location=loc.LocationCode join ai_emp_attendance att on att.empid=emp.EMPID join ai_shift_deatails sft on sft.AI_SHIFT_ID=emp.SHIFT_ID join ai_emp_designation des on des.designationId=emp.EMPDESIGNATION where grpm.Groupid=? and  loc.LocationCode like ? and emp.EMPDESIGNATION like ?  and  emp.EMPID like ? and att.DATE = ? and emp.isActive='Y'  group by att.DATE order by att.DATE asc";
					public static final String GET_LOGREPORT_FORTHISDATE = "select ed.EMPID,ed.EMPNAME,bt.ATTENDANCE_DATE,case when bt.TOTAL_HOURS ='00:00:00' then '-' else bt.TOTAL_HOURS end TotalHours,case when bt.TOTAL_WORKING_HOURS ='00:00:00' then '-' else bt.TOTAL_WORKING_HOURS end WorkingHours,case when bt.IN_TIME ='00:00:00' then '-' else bt.IN_TIME end IN_TIME,case when bt.OUT_TIME ='00:00:00' then '-' else bt.OUT_TIME end OUT_TIME,case when bt.LATE_TIME ='00:00:00' then '-' else bt.LATE_TIME end LATE_TIME,case when bt.EARLY_TIME ='00:00:00' then '-' else bt.EARLY_TIME end EARLY_TIME,case when att.status='present' then 'Present' else 'Absent' end Status from ai_emp_details ed join ai_shift_deatails sd on sd.AI_SHIFT_ID=ed.SHIFT_ID join ai_bio_department dd on dd.DEPT_ID=ed.DEPARTMENT join ai_emp_attendance att on att.empid=ed.EMPID join ai_bio_timesheet bt on bt.EMP_ID = ed.EMPID and bt.ATTENDANCE_DATE=att.DATE join ai_emp_location el on el.LocationCode=ed.Location join onsite_groupmapping gm on gm.LocationCode=ed.Location where    el.LocationCode =? and  bt.ATTENDANCE_DATE = ? and gm.Groupid=? and  ed.isActive='Y'  order by bt.ATTENDANCE_DATE asc, ed.EMPID";
					public static final String GET_MAPPEDLOCATIONS = "select * from onsite_groupmapping where Groupid=? order by length(LocationCode) asc";

					
					//validating Dse count by seshu
					
					public static final String GET_NOOFEMP="select count(*) employee from ai_emp_details where EMPDESIGNATION=? and Location=? and isActive='Y'";
					public static final String GET_DES_COUNT="select DSE_S_Count from ai_emp_location where LocationCode=?";


				
					
					//CHANGES IN MONTHLY LEGEND REPORT
					public static final String GET_EMPID_BY_LOCATION = "select EMPID,EMPNAME,d.designationName from ai_emp_details e, ai_emp_designation d where e.EMPDESIGNATION =d.designationId and e.Location=? and e.isActive='Y'";
					public static final String GET_EMPID_BY_LOCATION_AND_DESIGNATION = "select EMPID,EMPNAME,d.designationName from ai_emp_details e,ai_emp_designation d where e.EMPDESIGNATION =d.designationId and e.Location=? and e.EMPDESIGNATION=? and e.isActive='Y' ";
					//and e.iSinMultiLocations='N'
					//CHANGES IN DAILYLOG REPORT
					public static final String GET_EMPLOYEE_BY_LOCATION_AND_DESIGNATION = "select EMPID,EMPNAME from ai_emp_details where Location  in (select LocationCode from onsite_groupmapping where Groupid=?) and EMPDESIGNATION like ?  and  Location like ? and isActive='Y' and iSinMultiLocations='N'";

					public static final String GET_EMP_IDS_BY_LOCATION_AND_DESIGNATION = "select EMPID from ai_emp_details where Location  in (select LocationCode from onsite_groupmapping where Groupid=?) and EMPDESIGNATION like ?  and  Location like ? and isActive='Y' and iSinMultiLocations='N'";

					public static final String GET_EMPLOYEE_REGISTRATIONTIME="select emp.EMPID,emp.EMPNAME,emp.PHONE,des.designationName,loc.Location,grp.GroupName,emp.createdate from ai_emp_details emp join ai_emp_designation des on emp.EMPDESIGNATION=des.designationId join ai_emp_location loc on loc.LocationCode=emp.Location join onsite_groupmapping ogm on ogm.LocationCode=emp.Location join onsite_group grp on grp.Gorupid=ogm.Groupid where ogm.Groupid=? and emp.Location in (?) and emp.createdate like ? order by emp.Location asc,emp.CREATEDATE,emp.EMPID asc ";


					public static final String GET_EMPLOYEE_ATTENDANCEDETAILS="select emp.EMPID,emp.EMPNAME,att.status,att.DATE,loc.Location,des.designationName from ai_emp_details emp join ai_emp_attendance att on att.empid=emp.EMPID join ai_emp_location loc on loc.LocationCode= emp.Location join onsite_groupmapping ogm on ogm.LocationCode=loc.LocationCode join ai_emp_designation des on des.designationId=emp.EMPDESIGNATION where ogm.Groupid=? and emp.Location=? and emp.EMPID like ?and att.DATE=? and att.status='absent' and emp.isActive='Y'";
					public static final String GET_AttendanceCreatedTime="select createdate from ai_emp_attendance where  empid=? and DATE=? and LOCATION_CODE=?";
					public static final String UpdateAttendance="update ai_emp_attendance set status=?,modifydate=now(),modifyuser=?,createdate=? where empid=? and DATE=? and LOCATION_CODE=?";
					public static final String GET_TimeSheetCreatedTime="select createtime,SHIFT_ID from ai_bio_timesheet where EMP_ID=? and ATTENDANCE_DATE=? and LOCATION_CODE=?";
					public static final String GET_ShiftTimings="select AI_SHIFT_START_TIME,AI_SHIFT_END_TIME from ai_shift_deatails where AI_SHIFT_ID=? and Location=?";
					public static final String UpdateTimeSheet="update ai_bio_timesheet set IN_TIME=?,OUT_TIME=?,TOTAL_HOURS=?,TOTAL_WORKING_HOURS=?,MORNING_LATE='0',EVENING_EARLY='0',createtime=?,modifyuser=?,modifyDate=now() where EMP_ID=? and ATTENDANCE_DATE=? and LOCATION_CODE=?";
					
					public static final String LOCATION_EMPLOYEES_COUNT = "select count(emp.EMPID),sum(case when emp.EMPDESIGNATION=? then 1 else 0 end)DSECount from ai_emp_details emp,ai_emp_designation des where des.designationId=emp.EMPDESIGNATION and emp.isActive='Y' and emp.Location=?";


                  //priya leavebank start
					public static final String	GET_ACC_YEAR="select * from hrms_accyear";
					public static final String 	ADD_LEAVE="insert into hrms_employee_leave_bank(AccyearCode,total_leaves,allowed_per_month,CreatedBy,SL,PL,CL)values(?,?,?,?,?,?,?)";	

					public static final String 	GET_ALL_LEAVES="select le.sno,yr.AccadamicYear ,le.total_leaves,le.allowed_per_month,le.SL,le.PL,le.CL from hrms_accyear yr join hrms_employee_leave_bank le on yr.AccyearCode=le.AccyearCode";	
		
					public static final String GET_SPECIFIC_LEAVE="select le.sno,yr.AccadamicYear,yr.AccyearCode,le.total_leaves,le.allowed_per_month,le.SL,le.PL,le.CL from hrms_accyear yr join hrms_employee_leave_bank le on yr.AccyearCode=le.AccyearCode where sno=?";
				
					public static final String UPDATE_LEAVE="update hrms_employee_leave_bank set AccyearCode=?,total_leaves=?,allowed_per_month=?,ModifiedBy=?,SL=?,PL=?,CL=? where sno=?";
			
					public static final String	COUNT_LEAVE_YEAR="select count(*) from hrms_employee_leave_bank where AccyearCode=? ";
				
					public static final String	UPDATE_COUNT_LEAVE_YEAR="select count(*) from hrms_employee_leave_bank where AccyearCode=? and sno<> ?";
					
					public static final String DELETE_LEAVE="delete from hrms_employee_leave_bank where sno=?";
					//priya leavebank end					

					//for productivity report
					
					public static final String GET_EMP_BY_DEPT="select concat(First_Name,'-',bioid) as employeename,EMPID from hrms_employee emp,hrms_employee_manager_mapping emgr,hrms_department_mapping deptm where deptm.DepartmentCode like ? and deptm.UserCode=emgr.ManagerId and  emgr.EmployeeId=emp.EMPID";
					
					public static final String GET_EMP_ATT="select att.Attendence_Date,emp.EMPID,emp.First_Name,att.intime,att.outtime,att.totaltime,att.TOTAL_WORKING_HOURS from hrms_employee emp join hrms_employee_attendance att on emp.EMPID=att.EMPID join hrms_department_mapping dep on dep.UserCode=att.ManagerCode  where  emp.EMPID like ? and att.Attendence_Date between ? and ?";
					

				

}
