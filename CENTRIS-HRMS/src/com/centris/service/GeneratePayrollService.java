package com.centris.service;

import java.util.ArrayList;

import com.centris.VO.GeneratePayrollVo;
import com.centris.form.GeneratePayrollForm;

public interface GeneratePayrollService {
	
	public ArrayList<GeneratePayrollVo> getPayroll( GeneratePayrollForm payrollform,String userid);
	public String updateSalarydetails(String[] emp_array,String[] salaryadvance_array,String[] pendingsalary,String[] netpay_array,String month,String year,String usercode);
	public ArrayList<GeneratePayrollVo> getEmpMonthPayrollDetailsDownload(String month,String year,String department );

}
