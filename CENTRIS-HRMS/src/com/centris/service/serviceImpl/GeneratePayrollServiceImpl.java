package com.centris.service.serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.DAOIMPL.GeneratePayrollDaoImpl;
import com.centris.VO.EmployeeDetailsForPayrollVo;
import com.centris.VO.GeneratePayrollVo;
import com.centris.VO.SalaryDetailsVo;
import com.centris.form.GeneratePayrollForm;
import com.centris.service.GeneratePayrollService;
import com.centris.util.HelperClass;
import com.centris.util.PayrollCalculations;

public class GeneratePayrollServiceImpl extends DBService implements GeneratePayrollService{
	
	
	public ArrayList<GeneratePayrollVo> getPayroll( GeneratePayrollForm payrollform,String userid){
		
		Connection connection=null;
		int count=0;
		int payabledayscount=0;
		ArrayList<GeneratePayrollVo> payarollList=new ArrayList<GeneratePayrollVo>();
		
		
		try {
			
			String[] month_name=payrollform.getMonth().split(",");
			
			int month_int=Integer.parseInt(month_name[0]);
			int year_int=Integer.parseInt(payrollform.getYear().trim());
			String dept=payrollform.getDepartment().trim();
			int totalDaysInMonth=HelperClass.getDaysByMonthAndYear(month_int, year_int);
			
			GeneratePayrollDaoImpl generatePayrollDaoImpl=new GeneratePayrollDaoImpl();
			connection =getConnection();
			Map<String,EmployeeDetailsForPayrollVo> emp_details_map=generatePayrollDaoImpl.getEmployeeDetailsForPayroll(month_int, year_int,dept,connection);
		
			
			Iterator itr = emp_details_map.entrySet().iterator();
			
			 while(itr.hasNext())
		        {
		        	
		        	count++;
		        	
		        	GeneratePayrollVo generatePayrollVo=new GeneratePayrollVo();
		        	
		        	Map.Entry<String, EmployeeDetailsForPayrollVo> empdetails=(Map.Entry<String, EmployeeDetailsForPayrollVo>)itr.next();
		          
		        	EmployeeDetailsForPayrollVo employeeDetailsForPayrollVO=emp_details_map.get(empdetails.getKey());
		    
		        	List<String> presentdates =employeeDetailsForPayrollVO.getPresentdates();
		        	
		        	List<String> absentdates =employeeDetailsForPayrollVO.getAbsentdates();
		        	
		        	List<String> leavedates =employeeDetailsForPayrollVO.getLeavedates();
		        	
		        	List<String> holidaydates =employeeDetailsForPayrollVO.getHolidaydates();
		        	
		        	List<String> weekoffdates =employeeDetailsForPayrollVO.getWeekoffdates();
		        	
		        	
		        	HashSet<String> payyabledays=new HashSet<String>();
		        	
		        	if(!(presentdates.size()==0)){
		        	for(int i=0;i<presentdates.size();i++){
		        		
		        		payyabledays.add(presentdates.get(i));
		        	}
		        	}
		        	
		        	if(!(weekoffdates.size()==0)){
		        		for(int i=0;i<weekoffdates.size();i++){
		        			
		        			payyabledays.add(weekoffdates.get(i));
		        		}
		        	}
		        	
		        	if(!(holidaydates.size()==0)){
		        		for(int i=0;i<holidaydates.size();i++){
		        			
		        			payyabledays.add(holidaydates.get(i));
		        		}
		        	}
		        	
		        	
		        	
		        	payabledayscount=payyabledays.size();
		        	
		        	SalaryDetailsVo salary_vo=new SalaryDetailsVo();
		        	salary_vo.setMonth(month_int);
		        	salary_vo.setYear(year_int);
		        	
		        	salary_vo=generatePayrollDaoImpl.getSalaryDetails(empdetails.getKey(),connection);
		        	System.out.println(salary_vo.getLeavedeductions());
		        	if(!("Y".equalsIgnoreCase(salary_vo.getLeavedeductions())))
		        			{   
		        		
					        		if(!(leavedates.size()==0)){
			        	        		for(int i=0;i<leavedates.size();i++){
			        	        			
			        	        			payyabledays.add(leavedates.get(i));
			        	        		}
			        	        	}
					        		
					        		payabledayscount=payyabledays.size();
		        			}
		        
		        	generatePayrollVo.setSno(count);
		        	
		        	generatePayrollVo.setEmpId(employeeDetailsForPayrollVO.getEmpid());
		        	
		        	generatePayrollVo.setEmpName(employeeDetailsForPayrollVO.getEmpName());
		        	
		        	generatePayrollVo.setEmp_dept(employeeDetailsForPayrollVO.getDepartment());
		        	
		        	generatePayrollVo.setEmp_des(employeeDetailsForPayrollVO.getDesignation());
		        	generatePayrollVo.setDesid(employeeDetailsForPayrollVO.getDesid());
		        	generatePayrollVo.setDoj(employeeDetailsForPayrollVO.getDoj());
		        	generatePayrollVo.setMonth(month_int);
		        	generatePayrollVo.setYear(year_int);
		        	generatePayrollVo.setDeptid(employeeDetailsForPayrollVO.getDeptid());
		        	generatePayrollVo.setLocation(employeeDetailsForPayrollVO.getLocation());
		        	generatePayrollVo.setBackaccno(salary_vo.getBankaccno());
		        	
		        	 String pfNo=salary_vo.getEmppfno();
		        	 String esicode=salary_vo.getEmpesino();
		        	 
		        	 if(esicode==null){
		        		 
		        		 esicode="";
		        	 }
		        	 
					 if(pfNo==null){
						 
						 pfNo="";
					 }
					 
					 generatePayrollVo.setEsicode(esicode);
					 generatePayrollVo.setEpfNo(pfNo); 
					 
		        	generatePayrollVo.setNo_of_actual_days(totalDaysInMonth);
		        	generatePayrollVo.setPayable_days(payabledayscount);
		        	generatePayrollVo.setBasicda_actual(salary_vo.getBasicda());
		        	generatePayrollVo.setHra_actual(salary_vo.getHra());
		        	generatePayrollVo.setConvinience_actual(salary_vo.getConveyance());
		        	generatePayrollVo.setMedical_actual(salary_vo.getMedical());
		        	generatePayrollVo.setSpecial_allowances_actual(salary_vo.getSplallow());
		        	generatePayrollVo.setVariablepay_actual(salary_vo.getVariablepay());
		        	generatePayrollVo.setEpfempr_actual(salary_vo.getEpfempr());
		        	generatePayrollVo.setEesiempr_actual(salary_vo.getEesiempr());
		        	generatePayrollVo.setTotEarned_actual(salary_vo.getTotearned());
		        	generatePayrollVo.setCreatedby(userid);
		        	
		        	
		        	
		        	generatePayrollVo.setGross_actual(salary_vo.getGrosssalary());
		        	generatePayrollVo.setCtc_actual(salary_vo.getCtc());
		        	
		        	double earned_grossSalary=PayrollCalculations.calEarnedGross(salary_vo, payabledayscount, totalDaysInMonth);
		        	double earned_ctc=PayrollCalculations.calEarnedCtc(salary_vo, payabledayscount, totalDaysInMonth);
		        	
		        	generatePayrollVo.setGross_earned(earned_grossSalary);
		        	generatePayrollVo.setCtc_earned(earned_ctc);
		        	
		        	double earnedBasic=PayrollCalculations.calculateBasicDa(salary_vo,earned_ctc);
		        	
		        	
		        	generatePayrollVo.setBasicda_earned(earnedBasic);
		        	generatePayrollVo.setHra_earned(PayrollCalculations.calculateHra(salary_vo, earnedBasic));
		        	generatePayrollVo.setConvinience_earned(PayrollCalculations.calEarnedConveyance(salary_vo, payabledayscount, totalDaysInMonth));
		        	generatePayrollVo.setMedical_earned(PayrollCalculations.calEarnedMedical(salary_vo, payabledayscount, totalDaysInMonth));
		        	generatePayrollVo.setCca_earned(PayrollCalculations.calEarnedCca(salary_vo, payabledayscount, totalDaysInMonth));
		        	generatePayrollVo.setSpecial_allowances_earned(PayrollCalculations.calEarnedSplAllow(salary_vo, payabledayscount, totalDaysInMonth));
		        	generatePayrollVo.setVariablepay_earned(PayrollCalculations.calEarnedVariablePay(salary_vo, payabledayscount, totalDaysInMonth));
		        	generatePayrollVo.setPfempr_earned(PayrollCalculations.calculatePfEmpr(salary_vo, earnedBasic));
		        	generatePayrollVo.setPfempy_earned(PayrollCalculations.calculatePfEmpy(salary_vo, earnedBasic));
		        	generatePayrollVo.setEsiempr_earned(PayrollCalculations.calculateEsiEmpr(salary_vo, earned_grossSalary));
		        	generatePayrollVo.setEsiempy_earned(PayrollCalculations.calculateEsiEmpy(salary_vo, earned_grossSalary));
		        	generatePayrollVo.setPf(generatePayrollVo.getPfempr_earned()+generatePayrollVo.getPfempy_earned());
		        	generatePayrollVo.setEsi(generatePayrollVo.getEsiempr_earned()+generatePayrollVo.getEsiempy_earned());
		        	generatePayrollVo.setPtax_earned(PayrollCalculations.calculatePt(salary_vo, earnedBasic));
		        	generatePayrollVo.setIncometax_earned(PayrollCalculations.calEarnedIcometax(salary_vo, payabledayscount, totalDaysInMonth));
		        	generatePayrollVo.setAdvance_earned(PayrollCalculations.calEarnedAdvance(salary_vo, payabledayscount, totalDaysInMonth));
		        	
		        	
		        double totEarned=generatePayrollVo.getBasicda_earned()+generatePayrollVo.getHra_earned()+generatePayrollVo.getConvinience_earned()+
		        		generatePayrollVo.getMedical_earned()+generatePayrollVo.getCca_earned()+generatePayrollVo.getSpecial_allowances_earned()+
		        		generatePayrollVo.getVariablepay_earned()+generatePayrollVo.getPfempr_earned()+generatePayrollVo.getEsiempr_earned();
		        	
		        	
		        	generatePayrollVo.setTotEarned_earned(totEarned);
		        	
		        double totDeductions=generatePayrollVo.getPfempr_earned()+generatePayrollVo.getEsiempr_earned()+generatePayrollVo.getPfempy_earned()+generatePayrollVo.getEsiempy_earned()
		        		+generatePayrollVo.getPtax_earned()+generatePayrollVo.getIncometax_earned()+generatePayrollVo.getAdvance_earned();
		        		
		        		
		        	generatePayrollVo.setTotdeduction_earned(totDeductions);
		        	generatePayrollVo.setTotpayabbla_earned(totEarned-totDeductions);
		        	
		        	generatePayrollVo.setTakehome(totEarned-totDeductions);
		        	generatePayrollVo.setNetamount(totEarned-totDeductions);
		        	
		        	if(payabledayscount!=0){
		        	payarollList.add(generatePayrollVo);
		        	}
		    	
		        }
		        
			if(payarollList.size()>0){
				
				generatePayrollDaoImpl.storePayrollDetails(payarollList, connection);
			}
			 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray array=new JSONArray(payarollList);
		
		System.out.println("payarollList ::: "+array);
		
		
		return payarollList;
		
	}
	
	

	public String updateSalarydetails(String[] emp_array,String[] salaryadvance_array,String[] pendingsalary,String[] netpay_array,String month,String year,String usercode){
		
		return new GeneratePayrollDaoImpl().updateSalarydetails(emp_array,salaryadvance_array,pendingsalary,netpay_array,month,year,usercode);
	}
	
public ArrayList<GeneratePayrollVo> getEmpMonthPayrollDetailsDownload(String month,String year,String department ){
		
		return new GeneratePayrollDaoImpl().getEmpMonthPayrollDetailsDownload(month,year,department);
	}

public static void main(String[] args) {
	
	GeneratePayrollForm payrollform=new GeneratePayrollForm();
	payrollform.setDepartment("DEP2");
	payrollform.setMonth("07");
	payrollform.setYear("2015");
	
	new GeneratePayrollServiceImpl().getPayroll(payrollform, "USR1");
}

	
}
