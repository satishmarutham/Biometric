package com.centris.delegate;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.VO.EmployVO;
import com.centris.service.DisplayDeactiveEmployeeDetailsService;
import com.centris.service.GetAllEmployeeService;
import com.centris.service.serviceImpl.DisplayDeactiveEmployeeDetailsServiceImpl;
import com.centris.service.serviceImpl.GetAllEmployeeServiceImpl;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class DisplayDeactiveEmployeeDetailsBD {
	
	private static Logger logger = Logger.getLogger(GetAllEmployeeBD.class);
	
	public ArrayList<EmployVO> getDeactiveEmployeeDetails(String empid){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeBD : getDeactiveEmployeeDetails Starting");
		ArrayList<EmployVO> displayList=new ArrayList<EmployVO>();
		
		DisplayDeactiveEmployeeDetailsService obj=new DisplayDeactiveEmployeeDetailsServiceImpl();
		
		try{
			
			displayList=obj.getDeactiveEmployeeDetails(empid);
			
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeBD : getDeactiveEmployeeDetails Ending");
		return displayList;
	}


}
