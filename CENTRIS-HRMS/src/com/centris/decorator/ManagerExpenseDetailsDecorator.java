package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.ManagerExpenseDetailsVo;

public class ManagerExpenseDetailsDecorator extends TableDecorator {

	public String getTotalApproved() {
		ManagerExpenseDetailsVo details = (ManagerExpenseDetailsVo) getCurrentRowObject();
		String text = "<input type=\"text\" id=\"totApproved\" class=\"totApproved\" style=\"height:15px;width:75px !important;\" value="+details.getEmp_totapproved()+">";
		return text;
	}
	
	public String getAdvancePaid() {
		ManagerExpenseDetailsVo details = (ManagerExpenseDetailsVo) getCurrentRowObject();
		double advancepaid=0.0;
		if(!(details.getEmp_advpaid().equalsIgnoreCase("-"))){
			advancepaid=Double.parseDouble(details.getEmp_advpaid());
		}
		String text = "<input type=\"text\" id=\"advPaid\"  class=\"advancePaid\" style=\"height:15px;width:75px !important;\"value="+advancepaid+">";
		return text;
	}

	public String getBalance() {
		ManagerExpenseDetailsVo details = (ManagerExpenseDetailsVo) getCurrentRowObject();
		double balance=0.0;
		if(!(details.getEmp_balance().equalsIgnoreCase("-"))){
			balance=Double.parseDouble(details.getEmp_balance());
		}
		String text = "<input type=\"text\" readonly=\"readonly\" id=\"totBalance\" class=\"balance\" style=\"height:15px;width:75px !important;\"value="+balance+">";
		return text;
	}

	public String getDownload() {
		ManagerExpenseDetailsVo details = (ManagerExpenseDetailsVo) getCurrentRowObject();
		String val = "<input type=\"button\" class=\"submitbutton\" style=\"width:80px;\" value=\"Download\" onclick=\"downloadFullExpenseDetails(\'"
				+ details.getEmp_Id() +","+details.getEmp_mangCode()+ "\')\" />";
		return val;
	}

	public String getApprove() {

		String result = "<input type=\"button\" class=\"submitbutton\" style=\"width:80px;\" value=\"Approve\" id=\"empExpenseApprove\" />";
		return result;
	}
	
	
	public String getReject() {

		String result = "<input type=\"button\" class=\"submitbutton\" style=\"width:80px;\" value=\"Reject\" id=\"empExpenseReject\" />";
		return result;
	}

	public String getEmp_projCode() {
		ManagerExpenseDetailsVo details = (ManagerExpenseDetailsVo) getCurrentRowObject();
		String text = "<input type=\"hidden\" readonly=\"readonly\" value="
				+ details.getEmp_projCode()
				+ " id=\"empProjCode\" style=\"height:15px;width:75px !important;\"value=\"0\"/>";
		return text;
	}

	public String getEmp_mangCode() {
		ManagerExpenseDetailsVo details = (ManagerExpenseDetailsVo) getCurrentRowObject();
		
		System.out.println("MANGCODE"+details.getEmp_mangCode());
		
		String text = "<input type=\"hidden\" readonly=\"readonly\" value="
				+ details.getEmp_mangCode()
				+ " id=\"empMangCode\" style=\"height:15px;width:75px !important;\"value=\"0\"/>";
		return text;
	}

}