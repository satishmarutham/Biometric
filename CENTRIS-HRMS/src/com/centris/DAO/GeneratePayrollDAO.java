package com.centris.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.centris.VO.EmployeeDetailsForPayrollVo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GeneratePayrollVo;
import com.centris.VO.SalaryDetailsVo;

public interface GeneratePayrollDAO {
	
	public Map<String,EmployeeDetailsForPayrollVo> getEmployeeDetailsForPayroll(int month,int year,String dept,Connection connction);
	public List<EmployeeVO> getEmployeeList(Connection connection,String dept);
	public Map<String,String> getEmployeeTotalPresentAndAbsent(String empId,int month,int year,Connection conn);
	public SalaryDetailsVo getSalaryDetails(String empid,Connection connection);
	public void storePayrollDetails(ArrayList<GeneratePayrollVo> parollList,Connection connection);
	public String updateSalarydetails(String[] emp_array,String[] salaryadvance_array,String[] pendingsalary,String[] netpay_array,String month,String year,String usercode);
	public ArrayList<GeneratePayrollVo> getEmpMonthPayrollDetailsDownload(String month,String year,String department );
	
}
