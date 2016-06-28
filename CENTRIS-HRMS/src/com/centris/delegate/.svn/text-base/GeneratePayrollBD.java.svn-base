package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.GeneratePayrollVo;
import com.centris.form.GeneratePayrollForm;
import com.centris.service.serviceImpl.GeneratePayrollServiceImpl;

public class GeneratePayrollBD {
	
	public ArrayList<GeneratePayrollVo> getPayroll( GeneratePayrollForm payrollform,String userid){
		
		return new GeneratePayrollServiceImpl().getPayroll(payrollform,userid);
	}
	
	public String updateSalarydetails(String[] emp_array,String[] salaryadvance_array,String[] pendingsalary,String[] netpay_array,String month,String year,String usercode){
		
		return new GeneratePayrollServiceImpl().updateSalarydetails(emp_array,salaryadvance_array,pendingsalary,netpay_array,month,year,usercode);
	}
	
	
public ArrayList<GeneratePayrollVo> getEmpMonthPayrollDetailsDownload(String month,String year,String department ){
		
		return new GeneratePayrollServiceImpl().getEmpMonthPayrollDetailsDownload(month,year,department);
	}

}
