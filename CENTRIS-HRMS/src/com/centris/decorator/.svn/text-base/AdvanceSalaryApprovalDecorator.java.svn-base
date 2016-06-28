package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.AdvanceSalaryRequestVo;

public class AdvanceSalaryApprovalDecorator  extends TableDecorator{
	public String getApproval() {
		String approval;
		AdvanceSalaryRequestVo advanceSalaryRequestVo=(AdvanceSalaryRequestVo)getCurrentRowObject();

	
	
		/*String approval = "<input class=\"submitbutton\" type=\"button\" value=\"Approval\" onclick='callApprovalDialog(\""
				+ advanceSalaryRequestVo.getEmployeeCode() 
				+ "," 
				+advanceSalaryRequestVo.getEmployeeName()
				+","
				+advanceSalaryRequestVo.getProjectReferenceCode()
				+","
				+advanceSalaryRequestVo.getRequestedByCode()
				+","
				+advanceSalaryRequestVo.getComments()
				+","
				+advanceSalaryRequestVo.getRequestedByName()
				+","
				+advanceSalaryRequestVo.getAdvanceSalaryCode()
				+ " \")'/>";*/
		
		approval= "<a class=\"submitbutton\" name='viewButton' onclick='callApprovalDialog( \""
				+  advanceSalaryRequestVo.getBioId() 
				+ "\","
				+ "\""
				+advanceSalaryRequestVo.getEmployeeCode()
				+ "\","
				+ "\""
				+ advanceSalaryRequestVo.getEmployeeName()
				+ "\","
				+ "\""
				+advanceSalaryRequestVo.getProjectReferenceCode()
				+ "\","
				+ "\""
				+advanceSalaryRequestVo.getRequestedByCode()
				+ "\","
				+ "\""
				+ advanceSalaryRequestVo.getRequestedByName()
				+ "\","
				+ "\""
				+ advanceSalaryRequestVo.getSalary()
				+ "\","
				+ "\""
				+advanceSalaryRequestVo.getRequestedDate()
				+ "\","
				+ "\""
				+ advanceSalaryRequestVo.getAdvanceSalaryCode()
				+ "\")'>Approve</>";
return approval;

	}
}
