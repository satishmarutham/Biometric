package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import com.centris.DAO.EmployeeAllowanceReportDao;
import com.centris.DAO.DAOIMPL.EmployeeAllowanceReportDaoImpl;
import com.centris.POJO.EmployeeAllowanceReportPojo;
import com.centris.VO.EmployeeAllowanceReportVO;
import com.centris.service.EmployeeAllowanceReportService;
import com.centris.util.constants.MessageConstants;

public class EmployeeAllowanceReportServiceImpl implements EmployeeAllowanceReportService {

	public Map<String, ArrayList<EmployeeAllowanceReportVO>> getAllowances(
			EmployeeAllowanceReportPojo employeeAllowanceReportPojo) {

	  Map<String, ArrayList<EmployeeAllowanceReportVO>> allowances=new HashMap<String, ArrayList<EmployeeAllowanceReportVO>>();
	  EmployeeAllowanceReportDao employeeAllowanceReportDao=new EmployeeAllowanceReportDaoImpl();
		
	  try{
			
		  if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(employeeAllowanceReportPojo.getGroupby())){
			  
			  allowances=employeeAllowanceReportDao.getAllowancesByManagerDao(employeeAllowanceReportPojo);
		  }else{
			  
			  allowances=employeeAllowanceReportDao.getAllowancesByProjectDao(employeeAllowanceReportPojo);
		  }
		  
			
		
	  }catch(Exception e){
			e.printStackTrace();
	  }
		return allowances;
	}

	
	public ArrayList<EmployeeAllowanceReportVO> getAllowancesfordownload(EmployeeAllowanceReportPojo employeeAllowanceReportPojo) {
		
		ArrayList<EmployeeAllowanceReportVO> allownceeslist=new ArrayList<EmployeeAllowanceReportVO>();
		 EmployeeAllowanceReportDao employeeAllowanceReportDao=new EmployeeAllowanceReportDaoImpl();

		 try{
				
 				  allownceeslist=employeeAllowanceReportDao.getAllowancesfordownload(employeeAllowanceReportPojo);
		
		  }catch(Exception e){
				e.printStackTrace();
		  }
			return allownceeslist;
		}
	

}
