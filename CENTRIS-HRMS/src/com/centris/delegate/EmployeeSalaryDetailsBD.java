package com.centris.delegate;

import com.centris.VO.SalaryDetailsVo;
import com.centris.form.EmployeeSalaryDetailsForm;
import com.centris.service.serviceImpl.EmployeeSalaryDetailsServiceImpl;

public class EmployeeSalaryDetailsBD {
	
	public  String storeEmployeeSalaryDetails(EmployeeSalaryDetailsForm salaruform,String usercode) {
			
			return new EmployeeSalaryDetailsServiceImpl().storeEmployeeSalaryDetails(salaruform,usercode);
		}
	
	public boolean validateBankAccNumber(String accnumber,String empid){
		
		return new EmployeeSalaryDetailsServiceImpl().validateBankAccNumber(accnumber,empid);
	}
	
	public boolean validatePfNumber(String pfnumber,String empid){
		
		return new EmployeeSalaryDetailsServiceImpl().validatePfNumber(pfnumber, empid);
	}
	
	public boolean validateEsiCode(String esicode,String empid){
		
		return new EmployeeSalaryDetailsServiceImpl().validateEsiCode(esicode,empid);
	}
	
public SalaryDetailsVo getSalaryDetails(String empid){
		
		return new EmployeeSalaryDetailsServiceImpl().getSalaryDetails(empid);
	}




}
