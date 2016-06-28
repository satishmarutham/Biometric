package com.centris.util.SQLUtils;

public class EmployeePayroll {
	
	//message constatnts
	
	public static String GET_PAYROLL="getPayroll";
	
	
	
	
	//Sql quiries

	public static final String GET_EMPLIST="select e.EMPID,e.First_Name,e.Official_Email_ID,dept.DEPT_NAME,dept.DEPT_ID,des.designationName,des.DesignationCode,e.DOJ,e.BaseLocation from hrms_employee e,hrms_department dept,hrms_designation des,hrms_employee_salary_details esal where e.EMPID in (select EmployeeId from hrms_employee_manager_mapping where ManagerId in (select UserCode from hrms_department_mapping where DepartmentCode like ?)) and e.DesignationCode=des.DesignationCode and e.EMPID=esal.EmployeeId and dept.DEPT_ID like ?";
	
	public static final String GET_EMPLOYEE_ATTENDANCE="select EMPID,sum(case when Attedence_Status='present' then 1 else 0 end) totalpresent,GROUP_CONCAT(case when Attedence_Status='present' then Attendence_Date end) presentdate,sum(case when Attedence_Status='Absent' then 1 else 0 end) totalabsent,GROUP_CONCAT(case when Attedence_Status='Absent' then Attendence_Date end) absentdate,sum(case when Attedence_Status='Leave' then 1 else 0 end) totalleave,GROUP_CONCAT(case when Attedence_Status='Leave' then Attendence_Date end) leavedate,sum(case when Attedence_Status='Holiday' then 1 else 0 end) totalholiday,GROUP_CONCAT(case when Attedence_Status='Holiday' then Attendence_Date end) holidaydate,sum(case when Attedence_Status='weeklyoff' then 1 else 0 end) totalweekoff,GROUP_CONCAT(case when Attedence_Status='weeklyoff' then Attendence_Date end) weekoffdate from hrms_employee_attendance where EMPID=? AND Attendence_Date between ? and ? group by EMPID";
	
	public static final String STORE_PAYROLL_DEATILS="insert into hrms_payroll(EmpId,Designation,Doj,PfNo,EsiCode,NoOfDays,BasicDa_Actual,Hra_Actual,Conveyance_Actual,Medical_Actual,Cca_Actual,SplAllow_Actual,VariablePay_Actual,Ctc_Actual,GrossSalary_Actual,PayableDays,BasicDa_Earned,Hra_Earned,Conveyance_Earned,Medical_Earned,Cca_Earned,SplAllow_Earned,VariablePay_Earned,Ctc_Earned,GrossSalary_Earned,EmprPf,EmpyPf,EmprEsi,EmpyEsi,PTax,Incometax,Advance,TotalDeductions,TakeHome,SalaryAdvance,PendingSalary,NetPay,Month,Year,CreatedBy,Department,Location,BankAccountNumber) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String DELETE_PAYROLL="delete from hrms_payroll where EmpId=? and Month=? and Year=?";
	
	public static final String UPDATE_PAYROLL="update hrms_payroll set SalaryAdvance=?,PendingSalary=?,NetPay=?,ModifiedBy=?,Modified=? where EmpId=? and Month=? and Year=?";
	
	public static final String GET_PAYROLL_DETAILS="select p.EmpId,e.First_Name,des.designationName,dept.DEPT_NAME,p.Doj,p.PfNo,p.EsiCode,p.NoOfDays,p.BasicDa_Actual,p.Hra_Actual,p.Conveyance_Actual,p.Medical_Actual,p.Cca_Actual,p.SplAllow_Actual,p.VariablePay_Actual,p.Ctc_Actual,p.GrossSalary_Actual,p.PayableDays,p.BasicDa_Earned,p.Hra_Earned,p.Conveyance_Earned,p.Medical_Earned,p.Cca_Earned,p.SplAllow_Earned,p.VariablePay_Earned,p.Ctc_Earned,p.GrossSalary_Earned,p.EmprPf,p.EmpyPf,p.EmprEsi,p.EmpyEsi,p.PTax,p.Incometax,p.Advance,p.TotalDeductions,p.TakeHome,p.SalaryAdvance,p.PendingSalary,p.NetPay,p.Location,p.BankAccountNumber from hrms_payroll p,hrms_department dept,hrms_designation des,hrms_employee e where e.EMPID=p.EmpId and p.EMPID in ( select EmployeeId from hrms_employee_manager_mapping where ManagerId in (select UserCode from hrms_department_mapping where DepartmentCode like ?) ) and p.Designation=des.DesignationCode and p.Department=dept.DEPT_ID and Month=? and Year=?";

}
