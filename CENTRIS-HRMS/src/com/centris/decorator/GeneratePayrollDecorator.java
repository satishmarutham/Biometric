package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;
import com.centris.VO.GeneratePayrollVo;

public class GeneratePayrollDecorator extends TableDecorator {
	
	
	public String getPendingSalary() {
		
		GeneratePayrollVo mapData = (GeneratePayrollVo)getCurrentRowObject();
		double advanceValue=0.0;
		
		String pendingSalary = "<input type=\"text\" class=\"advanceTakenClass\" value=\""+advanceValue+ "\" style=\"height:30px;\"/>";
		
		
		return pendingSalary;
	}
	
	/*public String getPendingSalary(){
		
		GeneratePayrollVo mapData = (GeneratePayrollVo)getCurrentRowObject();
		double advanceValue=mapData.getAdvance_actual();
		
		String pendingSalary = "<input type=\"text\" class=\"advanceTakenClass\" value=\""+advanceValue+ "\" style=\"height:30px;\"/>";
		return pendingSalary;
	}*/
	
	
	public String getSalaryAdvance(){
		
		GeneratePayrollVo mapData = (GeneratePayrollVo)getCurrentRowObject();
		double advanceValue=0.0;
		
		String salaryAdvance = "<input type=\"text\" class=\"salaryadvanceTakenClass\" value=\""+advanceValue+ "\" style=\"height:30px;\"/>";
		return salaryAdvance;
	}
	
	
public String getEmpsignature(){
		
	GeneratePayrollVo mapData = (GeneratePayrollVo)getCurrentRowObject();
		String empsignature = "";
		return empsignature;
	}


}
