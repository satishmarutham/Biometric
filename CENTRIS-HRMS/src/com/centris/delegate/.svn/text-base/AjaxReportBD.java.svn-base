/**
 * 
 */
package com.centris.delegate;

import java.util.List;

import com.centris.VO.DirectorVo;
import com.centris.VO.ReportsAjaxVo;
import com.centris.service.AjaxReportService;
import com.centris.service.serviceImpl.AjaxReportServiceImpl;

/**
 * @author satish
 *
 */
public class AjaxReportBD {
public List<ReportsAjaxVo> getManagersByDirectorCode(String[] departmentCode,String userType,String userCode){
	
	
AjaxReportService ajaxReportService=new AjaxReportServiceImpl();
return ajaxReportService.getManagersByDirectorCode(departmentCode,userType,userCode);
	
}

public List<ReportsAjaxVo> getProjectsByManagerCode(String[] managerCode){
	
	
AjaxReportService ajaxReportService=new AjaxReportServiceImpl();
return ajaxReportService.getProjectsByManagerCode(managerCode);
	
}

public List<DirectorVo> getDirectorsByAdmin(String adminCode){
	AjaxReportService ajaxReportService=new AjaxReportServiceImpl();
		
		
	return ajaxReportService.getDirectorsByAdmin(adminCode);
}
}
