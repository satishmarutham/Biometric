/**
 * 
 */
package com.centris.service;

import java.util.List;

import com.centris.VO.DirectorVo;
import com.centris.VO.ReportsAjaxVo;

/**
 * @author satish
 *
 */
public interface AjaxReportService {
	public List<ReportsAjaxVo> getManagersByDirectorCode(String[] directorCode,String userType,String userCode);	
	public List<ReportsAjaxVo> getProjectsByManagerCode(String[] managerCode);
	public List<DirectorVo> getDirectorsByAdmin(String adminCode);
}
