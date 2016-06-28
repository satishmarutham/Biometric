package com.centris.util.SQLUtils;

public class Employee {
	public static String REGISTER_EMPLOYEE = "insert into hrms_employee(EMPID,Employee_Status,First_Name,HDFC_AC,DOB, gender,Addhar_Card_No,Passport_No,DL_NO,Voter_ID_No, BloodGroup,PAN_Card_No,Passport__Issued_Date,Passport_Issued_Place,Present_Address, Mobile_Number,Personal_Email_ID,Official_Email_ID,Permanent_Address,Major_Qualification, University_Board,Year_of_passing,College_Institute,Previous_Company,Designation_in_the_last_company, DOJ,BaseLocation,Last_Drawn_Salary,Total_experience_before,Fathers_Name, DOB_of_father,Mother_name,DOB_mother,Marital_Status,DOM, Spouse_Name,DOB_Spouse,Child_1,Child_2,Family_phone_no, DOB_Child_1,DOB_Child_2,PanCard,Salary_offered,isActive, DOL,Remarks,ManagerCode,userCode, DesignationCode,DEPT_ID,CreateTime,createdby,Employee_image,Passport_Expir_date,ProjectCode, EmpType,ElectionId,AdharCard,DrivingLicence,Others,Bank_Name,Branch_Name,IFSC_Code,ProjectHeadCode,ReportingManager_2,bioid,File1,File2,File3,File4,File5) values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?, ?,?,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?)";
	public static String UPDATE_EMPLOYEE = "update  hrms_employee set Employee_Status=?,First_Name=?,HDFC_AC=?,DOB=?, gender=?,Addhar_Card_No=?,Passport_No=?,DL_NO=?,Voter_ID_No=?, BloodGroup=?,PAN_Card_No=?,Passport__Issued_Date=?,Passport_Issued_Place=?,Present_Address=?, Mobile_Number=?,Personal_Email_ID=?,Official_Email_ID=?,Permanent_Address=?,Major_Qualification=?, University_Board=?,Year_of_passing=?,College_Institute=?,Previous_Company=?,Designation_in_the_last_company=?, DOJ=?,BaseLocation=?,Last_Drawn_Salary=?,Total_experience_before=?,Fathers_Name=?, DOB_of_father=?,Mother_name=?,DOB_mother=?,Marital_Status=?,DOM=?, Spouse_Name=?,DOB_Spouse=?,Child_1=?,Child_2=?,Family_phone_no=?, DOB_Child_1=?,DOB_Child_2=?,PanCard=?,Salary_offered=?,isActive=?, DOL=?,Remarks=?,ManagerCode=?,userCode=?, DesignationCode=?,DEPT_ID=?,CreateTime=?,createdby=?,Employee_image=?,Passport_Expir_date=?,ProjectCode=?,EmpType=?,ElectionId=?,AdharCard=?,DrivingLicence=?,Others=?,Bank_Name=?,Branch_Name=?,IFSC_Code=?,ProjectHeadCode=?,ReportingManager_2=?,bioid=?,File1=?,File2=?,File3=?,File4=?,File5=? where EMPID=?";
	public static String GET_EMPLOYEE_DETAILS = "select * from hrms_employee  where  isActive='Y' and  EMPID=? limit 1";
	public static String GET_EMPLOYEE_ID_NAME_BY_SEARCH_TERM = "select EMPID,First_Name from hrms_employee where isActive='Y' and First_Name like ? limit ?";
	public static String INSERT_WEEKOFF_DETAILS = "insert into hrms_weekoffmaster(EMPID,CURRENT_YEAR, SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,CLIENTCODE,CREATEDDATE,CREATEDBY,MODIFIED_BY,MODIFIED_DATE) values(?,?,?, ?,?,?,?,?,?,?, ?,?,?,? )";
	public static String UPDATE_WEEKOFF_DETAILS = "update hrms_weekoffmaster set CURRENT_YEAR=?, SUNDAY=?,MONDAY=?,TUESDAY=?,WEDNESDAY=?,THURSDAY=?,FRIDAY=?,SATURDAY=?,CLIENTCODE=?, CREATEDDATE=?,CREATEDBY=?,MODIFIED_BY=?,MODIFIED_DATE=? where EMPID=?";
	public static String INSERT_ONLINE_USER = "insert into hrms_online_users(Username,password,EMPID) values(?,?,?)";
	public static String GET_BOTH_IMAGE_PATH = "select PanCard,Employee_image,ElectionId,AdharCard,DrivingLicence,Others,File1,File2,File3,File4,File5 from hrms_employee where EMPID=?";
	public static String CHECK_DUPLICATE_ENTRY = "select count(*) from hrms_employee where First_Name=? and DOB=? and Mobile_Number=? and bioid=?";
	public static String CHECK_DUPLICATE_EMAILID = "select count(*) from hrms_online_users where Username=? and EMPID<>?";
	public static String UPDATE_ONLINE_USER = "update hrms_online_users set Username=?,password=? where EMPID=?";
	public static String GET_SERVER_URL = "select URL from bio_settings";
	public static String CHECK_OFFICIAL_EMAILID = "select count(*) from hrms_online_users where Username=? and EMPID=?";
	public static String CHECK_DUPLICATE_BIOID = "select count(*) from hrms_employee where bioid=? and EMPID<>?";
	public static String ACTIVE = "Y";
	public static String NOT_ACTIVE = "N";
	public static final String EMPLOYEE = "employee_creation";
	public static final String EMPLOYEE_AMENDMENT = "employee_amendment";
	public static final String EMP_SAVED = "Employee updated successfully";
	public static final String EMP_NOT_SAVED = "Employee not updated, Please try again";
	public static final String EMPLOYEE_TABLE = "hrms_employee";
	public static final String EMP_EXIST = "Employee already exist";
	public static final String OFFICIAL_EMAIL_EXIST = "Official emailId already exist";
	public static final String EMPID_EXIST = "Biometric Id already exist";
	public static final String PASSPORT_EXIST = "Passport already exist";
	public static final String VOTER_ID_EXIST = "Voter Id already exist";
	public static final String PANCARD_EXIST = "Pan Card already exist";
	public static final String ADDHAR_CARD_EXIST = "Addhar Card already exist";
	public static final String DL_EXIST = "DL already exist";
	public static String DELETE_ONLINE_USER = "delete from hrms_online_users where Username=? and EMPID=?";
	public static String CHECK_DUPLICATE_PASSPORT = "select count(*) from hrms_employee where Passport_No=? and Passport_No<>'' and EMPID<>?";
	public static String CHECK_DUPLICATE_PANCARD = "select count(*) from hrms_employee where PAN_Card_No=? and PAN_Card_No<>'' and EMPID<>?";
	public static String CHECK_DUPLICATE_VOTERID = "select count(*) from hrms_employee where Voter_ID_No=? and Voter_ID_No<>'' and EMPID<>?";
	public static String CHECK_DUPLICATE_DL = "select count(*) from hrms_employee where DL_NO=? and DL_NO<>'' and EMPID<>?";
	public static String CHECK_DUPLICATE_ADDHAR_CARD = "select count(*) from hrms_employee where Addhar_Card_No=? and Addhar_Card_No<>'' and EMPID<>?";

	// priya All_employee start

	/*
	 * public static final String GET_EMPLOYEES_DETAILS =
	 * "select e.EMPID,e.First_Name,p.Project_Name,m.FirstName,d.designationName,e.Salary_offered from hrms_employee e join hrms_project p on e.ProjectCode=p.ProjectCode join hrms_manager m on e.ManagerCode=m.ManagerCode join hrms_designation d on e.DesignationCode=d.DesignationCode and e.isActive='Y'and Employee_Status='present' order by length(e.EMPID),e.EMPID"
	 * ;
	 */
	public static final String GET_EMPLOYEES_DETAILS = "select e.Employee_image,e.DOJ,e.DOB,e.BaseLocation,e.Major_Qualification,e.Present_Address,e.HDFC_AC,e.bioid,e.EMPID,e.First_Name,e.BaseLocation,m.FirstName,concat((case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='Y')>0 then 'D' else '' end),' ',(case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='Y')>0 then 'M' else '' end),' ',(case when (select count(*) from hrms_user where empId=e.EMPID and isActive='Y')>0 then 'A' else '' end)) as permissions,d.designationName,e.Salary_offered,e.Official_Email_ID,e.Mobile_Number from hrms_employee e left outer join hrms_manager m on e.ManagerCode=m.ManagerCode join hrms_designation d on e.DesignationCode=d.DesignationCode  and e.isActive='Y'and Employee_Status='present' order by length(e.bioid),e.bioid";

	public static final String AUTO_SEARCH_EMPLOYEES = "select First_Name,EMPID from hrms_employee where First_Name like ? and Employee_Status='present' and isActive='Y'";

	public static final String SEARCH_EMPLOYEES = "select e.Employee_image,e.DOJ,e.DOB,e.BaseLocation,e.Major_Qualification,e.Present_Address,e.HDFC_AC,e.bioid,e.EMPID,e.First_Name,e.BaseLocation,m.FirstName,concat((case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='Y')>0 then 'D' else '' end),' ',(case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='Y')>0 then 'M' else '' end),' ',(case when (select count(*) from hrms_user where empId=e.EMPID and isActive='Y')>0 then 'A' else '' end)) as permissions,d.designationName,e.Salary_offered,e.Official_Email_ID,e.Mobile_Number from hrms_employee e left outer join hrms_manager m on e.ManagerCode=m.ManagerCode join hrms_designation d on e.DesignationCode=d.DesignationCode  where e.First_Name=? or e.EMPID=? and e.isActive='Y'and e.Employee_Status='present'";

	public static final String GET_SPECIFIC_EMPLOYEES = "SELECT * FROM hrms_employee he WHERE isActive='Y' AND  he.EMPID=? LIMIT 1";
	// priya All_employee end

	// Arul for Employee Login Update Personal Details
	public static final String GET_EMP_PERSONAL_DETAILS = "select em.EMPID,em.bioid,em.First_Name,em.Employee_Status,em.HDFC_AC,em.Bank_Name,em.Branch_Name,em.IFSC_Code,em.DOB,em.gender,em.Addhar_Card_No,em.Passport_No,em.DL_NO ,em.Voter_ID_No,em.BloodGroup,em.PAN_Card_No,em.Passport__Issued_Date,em.Passport_Issued_Place,em.Passport_Expir_date ,em.Present_Address,em.Mobile_Number,em.Personal_Email_ID,em.Official_Email_ID,em.Permanent_Address,em.Major_Qualification ,em.University_Board,em.Year_of_passing,em.College_Institute,em.Previous_Company,em.Designation_in_the_last_company,em.DOJ ,em.BaseLocation,em.Last_Drawn_Salary,em.Total_experience_before,em.Fathers_Name,em.DOB_of_father,em.Mother_name,em.DOB_mother ,em.Marital_Status,em.DOM,em.Spouse_Name,em.DOB_Spouse,em.Child_1,em.Child_2,em.Family_phone_no,em.DOB_Child_1,em.DOB_Child_2 ,em.Salary_offered,em.DOL,em.EmpType,em.Employee_image,des.designationName from hrms_employee em join hrms_online_users ons on ons.EMPID=em.EMPID  join hrms_designation des on des.DesignationCode=em .DesignationCode where ons.EMPID=?";
	public static final String PERSONAL_EMAIL_EXIST = "Personal Email ID Already Exist";

	public static String CHECK_DUPLICATE_PERSONAL_EMAILID = "select count(e.Personal_Email_ID) from hrms_employee e  where e.Personal_Email_ID=? and e.EMPID<>?";
	public static String UPDATE_EMPLOYEEPERSONAL_DETAILS = "update hrms_employee emp set emp.First_Name=?,emp.DOB=?,emp.Mobile_Number=?,emp.Personal_Email_ID=?, emp.Marital_Status=? , emp.Present_Address =? , emp.Fathers_Name=? , emp.DOB_of_father=? , emp.Mother_name =? , emp.DOB_mother=? , emp.Family_phone_no =?, emp.DOM=? , emp.Spouse_Name=? , emp.DOB_Spouse=? , emp.Child_1=? , emp.DOB_Child_1=? , emp.Child_2=? , emp.DOB_Child_2=? , emp.Passport_Expir_date=? , emp.Passport__Issued_Date=? , emp.Passport_Issued_Place=? , emp.Previous_Company=? , emp.Designation_in_the_last_company=? , emp.University_Board=? , emp.College_Institute=? , emp.Employee_image=? where emp.EMPID=?";
	public static String GET_IMAGE_PATH = "select Employee_image from hrms_employee where EMPID=?";

	// for Employee Expense
	public static String GET_EMPLOYEE_DETAILS_FOREXPENSE = "select em.bioid,em.EMPID,em.First_Name,em.Official_Email_ID,em.Mobile_Number,des.designationName,mng.ManagerCode,(case when mng.LastName is null then mng.FirstName else concat(mng.FirstName,' ',mng.LastName) end) ManagerName from hrms_employee em join hrms_online_users ons on ons.EMPID=em.EMPID join hrms_designation des on des.DesignationCode=em.DesignationCode left outer join hrms_employee_manager_mapping hmm on hmm.EmployeeId=em.EMPID left outer join hrms_manager mng on mng.ManagerCode=hmm.ManagerId where ons.Username=? and ons.EMPID=?";
	public static String INSERT_EMPLOYEE_TOTALEXPENSE = "insert into hrms_monthly_expense (MEXP_CODE,EMPID,year,month,ManagerCode,Local_conveyance,Travel_expenses,Staff_welfare,Telephone_expenses,Purchases,other_work_expenses,Miscellaneous,Total_amount_claimed,createtime,createdby,isManagerApproved,managerApprovedDate,Total_amount_approved) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String INSERT_LOCAL_EXPENSE = "insert into hrms_monthly_local_convenyance (MEXP_CODE,LC_DATE,Location,LC_From,LC_To,Remarks,LC_MODE,AMOUNT,EMPID,createdby) values (?,?,?,? ,?,?,?,?, ?,?) ";
	public static String INSERT_STAFFWELFARE_EXPENSE = "insert into hrms_monthly_staffwelfare (MEXP_CODE,Location,Date_From,Date_to,No_Of_Days,AsSingle_Team,Allowance,amount,EMPID,CreatedBy)  values (?,?,?,?,?,?,?,?,?,?)";
	public static String INSERT_PURCHASE_EXPENSE = "insert into hrms_monthly_purchases (MEXP_CODE,MP_DATE,Bill_No,Particulars,AMOUNT,EMPID,CreatedBy) values (?,?,? ,?,?,?,?)";
	public static String INSERT_TELEPHONE_EXPENSE = "insert into hrms_monthly_telephone (MEXP_CODE,MT_DATE,Telephone_no,Location,AMOUNT,EMPID,createdby) values (?,?,?,? ,?,?,?)";
	public static String INSERT_TRAVEL_EXPENSE = "insert into hrms_monthly_travel_expense (MEXP_CODE,TE_DATE,Location,TE_From,TE_To,Remarks,TE_MODE,AMOUNT,EMPID,createdby)  values (?,?,?,?,?,?,?,?,?,?)";
	public static String INSERT_OTHER_EXPENSE = "insert into hrms_monthly_otherworkexpenses(MEXP_CODE,MO_DATE,Description,AMOUNT,EMPID,CreatedBy) values (?,?,?,?,?,?)";
	public static String INSERT_MISCELLANEOUS_EXPENSE = "insert into hrms_monthly_miscellaneous(MEXP_CODE,MM_DATE,Description,AMOUNT,EMPID,CreatedBy) values (?,?,?,?,?,?)";
	public static String GET_EXPENSE_POSTEDCOUNT = "select count(*) from hrms_monthly_expense where year=? and month=? and EMPID=?";
	public static String GET_PJT_REF_CODE = "SELECT ProjectRefCode FROM hrms_project WHERE ProjectCode=?";
	
	

	// for employee salary details

	public static String EMPLOYEE_SALARY_DETAILS = "employessSalaryDetails";

	public static double BASI_DA = 53.59;
	public static double HRA = 25;
	public static double CONVEYANCE = 800;
	public static double MEDICAL = 1250;
	public static double CCA = 0;
	public static double SPL_ALLOW = 0;
	public static double VARIABLE_PAY = 0;
	public static double PF_EMPR = 12;
	public static double PF_EMPY = 12;
	public static double ESI_EMPR = 4.75;
	public static double ESI_EMPY = 1.75;
	public static double PT_14999 = 150;
	public static double PT_15000 = 200;
	public static double INCOMETAX = 0;
	public static double ADVANCE = 0;

	public static String EMP_SAL_ADD_SUCESS = "Employee salary details saved successfully";
	public static String EMP_SAL_ADD_FAIL = "Employee salary details not saved successfully";
	public static String EMP_SAL_UPDATE_SUCESS = "Employee salary details updated successfully";
	public static String EMP_SAL_UPDATE_FAIL = "Employee salary details not updated successfully";

	public static String INSERT_SALARY_DETAILS = "insert into hrms_employee_salary_details(EmployeeId,BankAccNumber,PfNumber,EsiCode,PaymentType,Ctc,GrossSalary,TotalPayable,BasicDa,Hra,Conveyance,Medical,Cca,FixSplAllowances,VariablePay,EarnedEmprPf,EarnedEmprEsi,TotalEarned,PfEmpr,PfEmpy,EsiEmpr,EsiEmpy,PTax,IncomeTax,Advance,TotalDeductions,CreatedBy,IsApplicableForLeave,IsApplicableForLate,IsApplicableForOt,Lta,Loan) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String CHECK_BANKACC_NUMBER = "select count(*) from hrms_employee_salary_details where EmployeeId!=? and BankAccNumber=?";
	public static String CHECK_PF_NUMBER = "select count(*) from hrms_employee_salary_details where EmployeeId!=? and PfNumber=?";
	public static String CHECK_ESI_CODE = "select count(*) from hrms_employee_salary_details where EmployeeId!=? and EsiCode=?";
	public static String GET_SAL_DETAILS = "SELECT sl.*,e.HDFC_AC FROM hrms_employee_salary_details sl ,hrms_employee e WHERE EmployeeId = EMPID AND EMPID = ? ";
	public static String CHECK_EMPID = "select count(*) from hrms_employee_salary_details where EmployeeId=?";
	public static String UPDATE_SALARY_DETAILS = "update hrms_employee_salary_details set BankAccNumber=?,PfNumber=?,EsiCode=?,PaymentType=?,Ctc=?,GrossSalary=?,TotalPayable=?,BasicDa=?,Hra=?,Conveyance=?,Medical=?,Cca=?,FixSplAllowances=?,VariablePay=?,EarnedEmprPf=?,EarnedEmprEsi=?,TotalEarned=?,PfEmpr=?,PfEmpy=?,EsiEmpr=?,EsiEmpy=?,PTax=?,IncomeTax=?,Advance=?,TotalDeductions=?,IsApplicableForLeave=?,IsApplicableForLate=?,IsApplicableForOt=?,Lta=?,Loan=? where EmployeeId=?";

	public static final String GET_ALL_EMPLOYEES_DETAILS = "select emp.EMPID,emp.First_Name, emp.DOB, emp.DOJ, emp.Personal_Email_ID, emp.Official_Email_ID, emp.Mobile_Number, emp.Present_Address, emp.Employee_image,prj.Project_Name, prj.Location,concat(man.FirstName,' ',man.LastName) as ProjectManager, des.designationName, dep.DEPT_NAME, emp.EmpType from hrms_employee emp, hrms_project prj,hrms_manager man, hrms_designation des, hrms_department dep where emp.ProjectCode = prj.ProjectCode and emp.ManagerCode = man.ManagerCode and emp.DesignationCode = des.DesignationCode and emp.DEPT_ID = dep.DEPT_ID  and emp.EMPID=? and emp.isActive ='Y' and emp.Employee_Status = 'Present' order by length(emp.EMPID),emp.EMPID asc";

	public static String CHECK_DUPLICATE_ACCOUNT = "select count(*) from hrms_employee where HDFC_AC =? ";
	public static final String ACCOUNT_NO_EXISTS = "Account No already exist";
	
	public static final String GET_PROJECTNAME_AND_CODE = "select pmm.ProjectCode,pj.Project_Name from hrms_project_manager_mapping pmm join hrms_project pj on pj.ProjectCode=pmm.ProjectCode where pmm.ManagerCode=? and pj.Status='Y' and  ProjectStatus='Approved' order by pj.Project_Name";

	
	//delete employee
	public static final String DELETE_EMPLOYEE="delete from hrms_employee  where EMPID=?";
	public static final String DELETE_ONLINE_USERS="delete from hrms_online_users where EMPID=?";
	public static final String DELETE_EMPLOYEE_ATTENDANCE="delete from hrms_employee_attendance where EMPID=?";
	public static final String DELETE_WEEKOFF_SETTINGS="delete from hrms_weekoffmaster where EMPID=?";
	public static final String CHECK_EXIST_EMPLOYEE="select count(*) from hrms_employee  where EMPID=?";
	
	public static final String EMP_DELETED = "Employee Deleted Successfully";
	public static final String EMP_NOT_DELETED = "Employee not deleted, Please try again";
	

    //CHECK EMPLOYEE	
	public static final String CHECK_EMPLOYEE_IN_MANAGER = "select ManagerCode from hrms_manager where EMPID=?";
	public static final String CHECK_EMPLOYEE_IN_DIRECTOR = "select DirectorCode from hrms_director where EMPID=?";
	public static final String CHECK_EMPLOYEE_IN_USER = "select userCode from hrms_user where empId=?";
	//CHECK MANAGER MAPPINGS
	public static final String MANAGER_IN_DIRECTOR_MANAGER_MAPPING = "select count(*) from hrms_manager_director_mapping where ManagerCode=?";
	public static final String MANAGER_IN_PROJECT_MANAGER_MAPPING = "select count(*) from hrms_project_manager_mapping where ManagerCode=?";
	public static final String MANAGER_IN_DEPARTMENT_MAPPING = "select count(*) from hrms_department_mapping where UserCode=?";
	public static final String MANAGER_IN_EMPLOYEE_MANAGER_MAPPING = "select count(*) from hrms_employee_manager_mapping where ManagerId=?";
	//CHECK DIRECTOR MAPPINGS
	public static final String DIRECTOR_IN_DIRECTOR_MANAGER_MAPPING = "select count(*) from hrms_manager_director_mapping where DirectorCode=?";
	//check Employee Mapping
	public static final String EMPLOYEE_IN_EMPLOYEE_MANAGER_MAPPING = "select count(*) from hrms_employee_manager_mapping where EmployeeId=?";
	
	public static final String DELETE_MANAGER = "delete from hrms_manager where EMPID=?";
	public static final String DELETE_DIRECTOR = "delete from hrms_director where EMPID=?";
	public static final String DELETE_USER = "delete from hrms_user where empId=?";
	public static final String GET_EMPLOYEE_INFO = "select First_Name,Official_Email_ID,bioid from hrms_employee where EMPID=?";
	public static final String INSERT_DELETE_AUDIT = "insert into hrms_employee_delete_audit(EmpId,EMP_BIOID,EmployeeName,OfficialId,CreatedDate,CreatedBy)values(?,?,?,?,now(),?)";
	public static final String EMPID_IN_MANAGER = "select count(*) from hrms_manager where EMPID=?";
	public static final String EMPID_IN_DIRECTOR = "select count(*) from hrms_director where EMPID=?";
	public static final String EMPID_IN_USER = "select count(*) from hrms_user where empId=?";
	
	//Delete Employee Audit
	
		public static final String DELETE_EMPLOYEE_AUDIT="select hde.EmpId,hde.EmployeeName,hde.EMP_BIOID,hde.OfficialId,hde.CreatedDate,hdu.username from hrms_employee_delete_audit hde,hrms_user hdu where hde.CreatedBy=? and hde.CreatedBy=hdu.userCode"; 
		
		public static final String GET_EMPLOYEE_PERMISSIONS="select case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='Y')>0 then 'D' else '' end director,case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='Y')>0 then 'M' else '' end manager,case when (select count(*) from hrms_user where empId=e.EMPID and isActive='Y')>0 then 'A' else '' end admin from hrms_employee e join hrms_designation d on e.DesignationCode=d.DesignationCode  and e.EMPID=?";

		public static final String BLOCK_DIRECTOR="update hrms_director set isActive='N' where EMPID=?";
		public static final String BLOCK_MANAGER="update hrms_manager set isActive='N' where EMPID=?";
		public static final String BLOCK_ADMIN="update hrms_user set isActive='N' where EMPID=?";
		public static final String BLOCK_EMPLOYEE="update hrms_employee set isActive='N' where EMPID=?";
		public static final String VIEW_EMPLOYEES_DIALOG="select e.EMPID,e.First_Name,e.Official_Email_ID,e.Employee_image,e.DOJ,e.DOB,e.BaseLocation,e.Major_Qualification,e.Present_Address,concat((case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='Y')>0 then 'D' else '' end),' ',(case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='Y')>0 then 'M' else '' end),' ',(case when (select count(*) from hrms_user where empId=e.EMPID and isActive='Y')>0 then 'A' else '' end)) as permissions from hrms_employee e where  e.EMPID=? and e.isActive='Y'and e.Employee_Status='present'";
		
		

		
		
		public static final String GET_ALL_DEACTIVE_EMPLOYEES="select e.EMPID,e.First_Name,e.Mobile_Number,e.Official_Email_ID,e.bioid,concat((case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='N')>0 then 'D' else '' end),' ',(case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='N')>0 then 'M' else '' end),' ',(case when (select count(*) from hrms_user where empId=e.EMPID and isActive='N')>0 then 'A' else '' end)) as permissions,d.designationName from hrms_designation d ,hrms_employee e where e.DesignationCode=d.DesignationCode and e.isActive='N' order by e.bioid ";
		public static final String ACTIVATE_EMPLOYEE="update hrms_employee set isActive='Y' where EMPID=?";
		
		//Employee Ammendment
		public static final String UPDATE_MANAGER = "update hrms_manager set  FirstName=?,Username=?,email=?,password=? where EMPID=?";
		public static final String CHECK_MANAGER = "select count(ManagerCode) as managcount,isActive from hrms_manager where EMPID=?";
		public static final String CHECK_DIRECTOR = "select count(DirectorCode) as direcount,isActive from hrms_director where EMPID=?";
		public static final String UPDATE_DIRECTOR = "update hrms_director set  Username=?,U_password=? where EMPID=?";
		public static final String CHECK_ADMIN = "select count(userCode)as admincount,isActive from hrms_user where empId=?";
		public static final String UPDATE_ADMIN = "update hrms_user set  username=?,password=?,email_id=? where empId=?";
	
		
		public static final Object MANAGER_NOT_SAVED = "Employee having 'Manager' privileges and login credentials not updated, Please try again ";
		public static final Object DIRECTOR_NOT_SAVED = "Employee having 'Director' privileges and login credentials not updated, Please try again ";
		public static final Object ADMIN_NOT_SAVED = "Employee having 'Admin' privileges and login credentials not updated, Please try again ";
		public static final Object EMP_UPDATED_MAIL_NOT_SENT = "Employee updated successfully,Mail not Sent";
	
		
		public static final String GET_MANAGER = "select FirstName,email from hrms_manager where isActive='Y' and ManagerCode=?";
		public static final String GET_EMPLOYEE = "select e.First_Name,e.Official_Email_ID from hrms_employee e,hrms_online_users u where  e.EMPID=u.EMPID and e.isActive='Y' and e.EMPID=?";
		public static final String EMPLOYEE_CONTACT_US_MAIL = "employee_ContactUsMail";
		public static final String GET_ALL_EXPENSEmAILID="select d.Username,m.email,ol.Username as empMail from hrms_monthly_expense me,hrms_manager m,hrms_director d,hrms_online_users ol where d.DirectorCode in (select DirectorCode from hrms_manager_director_mapping where ManagerCode=me.ManagerCode) and m.ManagerCode=me.ManagerCode and me.MEXP_CODE=? and ol.EMPID=me.EMPID";
		

	    //Expenses claimed multiple times in month written by swathi	

		public static final String GET_ALL_EMP_EXPENSE_MAILID="select Username from  hrms_online_users where EMPID in (select EMPID from hrms_monthly_expense where MEXP_CODE=?)";
		

		public static final String GET_BIOID ="select max(bioid) as bioID from hrms_employee";
		public static final String GET_EXPENSE_CODE = "select MEXP_CODE from hrms_monthly_expense where year=? and month=? and EMPID=?  and isManagerApproved='N'";
		public static final String GET_LOCAL_EXPENSES = "select sno,LC_DATE,Location,LC_From,LC_To,Remarks,LC_MODE,AMOUNT from hrms_monthly_local_convenyance where MEXP_CODE=?";
		public static final String GET_STAFF_EXPENSES = "select sno,Location,Date_From,Date_to,No_Of_Days,AsSingle_Team,Allowance,amount from hrms_monthly_staffwelfare where MEXP_CODE=?";
		public static final String GET_TRAVEL_EXPENSES = "select sno,TE_DATE,Location,TE_From,TE_To,Remarks,TE_Mode,AMOUNT from hrms_monthly_travel_expense where MEXP_CODE=?";
		public static final String GET_TELEPHONE_EXPENSES = "select sno,MT_DATE,Telephone_no,Location,AMOUNT from hrms_monthly_telephone where MEXP_CODE=?";
		public static final String GET_PURCHASE_EXPENSES = "select sno,MP_DATE,Bill_No,Particulars,AMOUNT from hrms_monthly_purchases where MEXP_CODE=?";
		public static final String GET_OTHERWORK_EXPENSES = "select sno,MO_DATE,Description,AMOUNT from hrms_monthly_otherworkexpenses where MEXP_CODE=? ";
		public static final String GET_MISCELLANEOUS_EXPENSES = "select sno,MM_DATE,Description,AMOUNT from hrms_monthly_miscellaneous where MEXP_CODE=?";
		public static final String GET_MONTHLY_EXPENSES = "select Local_conveyance,Travel_expenses,Staff_welfare,Telephone_expenses,Purchases,other_work_expenses,Miscellaneous,Total_amount_claimed from hrms_monthly_expense where MEXP_CODE=?";
		public static final String GET_EXPENSECODE_COUNT = "select count(*) from hrms_monthly_expense where MEXP_CODE=?";
		public static final String UPDATE_EMPLOYEE_TOTALEXPENSE = "update hrms_monthly_expense set EMPID=?,year=?,month=?,ManagerCode=?,Local_conveyance=?,Travel_expenses=?,Staff_welfare=?,Telephone_expenses=?,Purchases=?,other_work_expenses=?,Miscellaneous=?,Total_amount_claimed=?,modifiedtime=?,modifiedby=?,isManagerApproved=?,Total_amount_approved=?,managerApprovedDate=? where MEXP_CODE=?";
		public static final String CHECK_LOCAL_EXPENSE = "select count(*) from hrms_monthly_local_convenyance where MEXP_CODE=?";
		public static final String CHECK_TRAVEL_EXPENSE = "select count(*) from hrms_monthly_travel_expense where  MEXP_CODE=?";
		public static final String CHECK_STAFF_EXPENSE = "select count(*) from hrms_monthly_staffwelfare where  MEXP_CODE=?";
		public static final String CHECK_TELEPHONE_EXPENSE = "select count(*) from hrms_monthly_telephone where MEXP_CODE=?";
		public static final String CHECK_PURCHASE_EXPENSE = "select count(*) from hrms_monthly_purchases where  MEXP_CODE=?";
		public static final String CHECK_OTHER_EXPENSE = "select count(*) from hrms_monthly_otherworkexpenses where MEXP_CODE=?";
		public static final String GET_DIRECTOR_DETAILS = "select d.DirectorCode,e.First_Name from hrms_director d  left outer join hrms_employee e on e.EMPID=d.EMPID   where d.DirectorCode in (select DirectorCode from hrms_manager_director_mapping where ManagerCode =?)";
		public static final String GET_MANAGER_CODE = "select ManagerCode from hrms_manager where EMPID=?";
		public static final String GET_MANAGER_EXPENSE_CODE = "select MEXP_CODE from hrms_monthly_expense where year=? and month=?  and EMPID=?  and isDirectorApproved='N'";
		public static final String DELETE_LOCAL_EXPENSE = "delete from hrms_monthly_local_convenyance where MEXP_CODE=?";
		public static final String DELETE_TRAVEL_EXPENSE = "delete from hrms_monthly_travel_expense where  MEXP_CODE=?";
		public static final String DELETE_STAFFWELFARE_EXPENSE = "delete from hrms_monthly_staffwelfare where  MEXP_CODE=?";
		public static final String DELETE_TELEPHONE_EXPENSE = "delete from hrms_monthly_telephone where  MEXP_CODE=?";
		public static final String DELETE_PURCHASE_EXPENSE = "delete from hrms_monthly_purchases where  MEXP_CODE=?";
		public static final String DELETE_OTHER_EXPENSE = "delete from hrms_monthly_otherworkexpenses where  MEXP_CODE=?";
		public static final String CHECK_MISCELLANEOUS_EXPENSE = "select count(*) from hrms_monthly_miscellaneous where  MEXP_CODE=?";
		public static final String DELETE_MISCELLANEOUS_EXPENSE = "delete from hrms_monthly_miscellaneous where  MEXP_CODE=?";
	
		
		//Deactive Employee Details
		
		public static final String GET_DEACTIVE_EMP_DETAILS ="SELECT * FROM hrms_employee he WHERE isActive='N' AND  he.EMPID=? LIMIT 1";
}