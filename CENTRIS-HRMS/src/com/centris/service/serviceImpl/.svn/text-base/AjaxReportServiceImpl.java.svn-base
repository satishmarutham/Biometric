/**
 * 
 */
package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.AjaxReportDao;

import com.centris.DAO.DAOIMPL.AjaxReportDaoImpl;

import com.centris.VO.DirectorVo;
import com.centris.VO.ReportsAjaxVo;
import com.centris.service.AjaxReportService;

/**
 * @author satish
 *
 */
public class AjaxReportServiceImpl implements AjaxReportService {

	@Override
	public List<ReportsAjaxVo> getManagersByDirectorCode(String[] departmentCode,String userType,String userCode) {
		
		AjaxReportDao ajaxReportDao=new AjaxReportDaoImpl();
		// TODO Auto-generated method stub
		return ajaxReportDao.getManagersByDirectorCode(departmentCode,userType,userCode);
	}

	@Override
	public List<ReportsAjaxVo> getProjectsByManagerCode(String[] managerCode) {
		// TODO Auto-generated method stub
		AjaxReportDao ajaxReportDao=new AjaxReportDaoImpl();
		// TODO Auto-generated method stub
		return ajaxReportDao.getProjectsByManagerCode(managerCode);
	}
	public List<DirectorVo> getDirectorsByAdmin(String adminCode) {
		AjaxReportDao ajaxReportDao=new AjaxReportDaoImpl();
		// TODO Auto-generated method stub
		return ajaxReportDao.getDirectorsByAdmin(adminCode);
	}
}
