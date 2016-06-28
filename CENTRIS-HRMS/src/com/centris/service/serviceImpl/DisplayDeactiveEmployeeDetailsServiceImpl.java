package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DisplayDeactiveEmployeeDetailsDao;
import com.centris.DAO.GetAllEmployeeDao;
import com.centris.DAO.DAOIMPL.DisplayDeactiveEmployeeDetailsDaoImpl;
import com.centris.DAO.DAOIMPL.GetAllEmployeeDaoImpl;
import com.centris.VO.EmployVO;
import com.centris.service.DisplayDeactiveEmployeeDetailsService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class DisplayDeactiveEmployeeDetailsServiceImpl implements DisplayDeactiveEmployeeDetailsService{

	private static Logger logger = Logger.getLogger(DisplayDeactiveEmployeeDetailsServiceImpl.class);

	
	@Override
	public ArrayList<EmployVO> getDeactiveEmployeeDetails(String empid){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DisplayDeactiveEmployeeDetailsServiceImpl : getDeactiveEmployeeDetails Home Starting");
		ArrayList<EmployVO> displayList=new ArrayList<EmployVO>();
		DisplayDeactiveEmployeeDetailsDao obj=new DisplayDeactiveEmployeeDetailsDaoImpl();
		try{
			
			displayList=obj.getDeactiveEmployeeDetails(empid);
			
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DisplayDeactiveEmployeeDetailsServiceImpl: getDeactiveEmployeeDetails Home Ending");
		
		return displayList;
	}

}
