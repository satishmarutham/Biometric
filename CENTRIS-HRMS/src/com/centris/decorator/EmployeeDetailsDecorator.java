package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.EmpVO;

public class EmployeeDetailsDecorator extends TableDecorator {
	
	
	public String getViewButton() {
		
		EmpVO empVO=(EmpVO)getCurrentRowObject();
	
		String viewButton="<a class=\"decorator\" href=\"EmpDashBoardInManager.do?method=employeeDashboardHome&empId="+empVO.getEmpid()+"&empName="+empVO.getEmpname()+" \">View</a>";
		
		return viewButton;
	}


	public String getDownload() {
		EmpVO empVO=new EmpVO();
		String download="<a class=\"decorator\" href=\"#\">Download</a>";
	
		return download;
	}


	
	

}
