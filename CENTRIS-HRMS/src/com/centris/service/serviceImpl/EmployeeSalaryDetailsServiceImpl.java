package com.centris.service.serviceImpl;

import com.centris.DAO.DAOIMPL.EmployeeSalaryDetailsDaoImpl;
import com.centris.POJO.EmployeeSalaryDetailsPojo;
import com.centris.VO.SalaryDetailsVo;
import com.centris.form.EmployeeSalaryDetailsForm;

public class EmployeeSalaryDetailsServiceImpl {
	
	public  String storeEmployeeSalaryDetails(EmployeeSalaryDetailsForm salaruform,String usercode) {
		
		EmployeeSalaryDetailsPojo salarypojo=new EmployeeSalaryDetailsPojo();
		
		salarypojo.setEmpid(salaruform.getEmpid().trim());
		salarypojo.setEmpname(salaruform.getEmpname().trim());
		salarypojo.setBankaccno(salaruform.getBankaccno().trim());
		salarypojo.setEmppfno(salaruform.getEmppfno().trim());
		salarypojo.setEmpesino(salaruform.getEmpesino().trim());
		salarypojo.setPaymenttype(salaruform.getPaymenttype().trim());
		salarypojo.setCtc(Double.parseDouble(salaruform.getCtc().trim()));
		salarypojo.setGrosssalary(Double.parseDouble(salaruform.getGrosssalary().trim()));
		salarypojo.setTotpayable(Double.parseDouble(salaruform.getTotpayable().trim()));
		salarypojo.setBasicda(Double.parseDouble(salaruform.getBasicda().trim()));
		salarypojo.setHra(Double.parseDouble(salaruform.getHra().trim()));
		salarypojo.setConveyance(Double.parseDouble(salaruform.getConveyance().trim()));
		salarypojo.setMedical(Double.parseDouble(salaruform.getMedical().trim()));
		salarypojo.setCca(Double.parseDouble(salaruform.getCca().trim()));
		salarypojo.setSplallow(Double.parseDouble(salaruform.getSplallow().trim()));
		salarypojo.setVariablepay(Double.parseDouble(salaruform.getVariablepay().trim()));
		salarypojo.setEpfempr(Double.parseDouble(salaruform.getEpfempr().trim()));
		salarypojo.setEesiempr(Double.parseDouble(salaruform.getEesiempr().trim()));
		salarypojo.setTotearned(Double.parseDouble(salaruform.getTotearned().trim()));
		salarypojo.setPfempr(Double.parseDouble(salaruform.getPfempr().trim()));
		salarypojo.setPfempy(Double.parseDouble(salaruform.getPfempy().trim()));
		salarypojo.setEsiempr(Double.parseDouble(salaruform.getEsiempr().trim()));
		salarypojo.setEsiempy(Double.parseDouble(salaruform.getEsiempy().trim()));
		salarypojo.setPtax(Double.parseDouble(salaruform.getPtax().trim()));
		salarypojo.setIncometax(Double.parseDouble(salaruform.getIncometax().trim()));
		salarypojo.setAdvance(Double.parseDouble(salaruform.getAdvance().trim()));
		salarypojo.setTotdeductions(Double.parseDouble(salaruform.getTotdeductions().trim()));
		salarypojo.setCreatedby(usercode);
		salarypojo.setLatedeductions(salaruform.getLatedeductions());
		salarypojo.setLeavedeductions(salaruform.getLeavedeductions());
		salarypojo.setOvertime(salaruform.getOvertime());
		
		
		
		if(salaruform.getLta()==null || salaruform.getLta().equalsIgnoreCase("")){
			
			salarypojo.setLta(0.0);
		}else{
			
			salarypojo.setLta(Double.parseDouble(salaruform.getLta()));
		}
		
		
		
		if(salaruform.getLoan()==null || salaruform.getLoan().equalsIgnoreCase("")){
			
			salarypojo.setLoan(0.0);
		}else{
			
			salarypojo.setLoan(Double.parseDouble(salaruform.getLoan()));
		}
		

		
		return new EmployeeSalaryDetailsDaoImpl().storeEmployeeSalaryDetails(salarypojo);
	}
	
	
public boolean validateBankAccNumber(String accnumber,String empid){
	
	return new EmployeeSalaryDetailsDaoImpl().validateBankAccNumber(accnumber,empid);
}

public boolean validatePfNumber(String pfnumber,String empid){
	
	return new EmployeeSalaryDetailsDaoImpl().validatePfCode(pfnumber, empid);
}

public boolean validateEsiCode(String esicode,String empid){
	
	return new EmployeeSalaryDetailsDaoImpl().validateEsiCode(esicode,empid);
}

public SalaryDetailsVo getSalaryDetails(String empid){
	
	return new EmployeeSalaryDetailsDaoImpl().getSalaryDetails(empid);
}

}
