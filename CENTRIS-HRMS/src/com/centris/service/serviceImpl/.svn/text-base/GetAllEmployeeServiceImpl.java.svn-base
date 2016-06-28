package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.GetAllEmployeeDao;
import com.centris.DAO.DAOIMPL.GetAllEmployeeDaoImpl;
import com.centris.VO.AllEmployeeReportVO;
import com.centris.VO.AllEmployeesViewDialogVo;
import com.centris.VO.EmployVO;
import com.centris.VO.GetAllEmployeeVO;


import com.centris.service.GetAllEmployeeService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class GetAllEmployeeServiceImpl implements GetAllEmployeeService {
	private static Logger logger = Logger.getLogger(GetAllEmployeeServiceImpl.class);
	public ArrayList<GetAllEmployeeVO> getDetails(){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:All_Employee Home Starting");
		GetAllEmployeeDao obj=new GetAllEmployeeDaoImpl();
		ArrayList<GetAllEmployeeVO> getDetails=new ArrayList<GetAllEmployeeVO>();
		try{
		getDetails=obj.getDetails();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:All_Employee Home Ending");
		return getDetails;
	}
	public ArrayList<GetAllEmployeeVO> autosearchemployee(String term){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:autosearchemployee Home Starting");
		ArrayList<GetAllEmployeeVO> autosearchemployee=new ArrayList<GetAllEmployeeVO>();
		GetAllEmployeeDao obj=new GetAllEmployeeDaoImpl();
		try{
			autosearchemployee=obj.autosearchemployee(term);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:autosearchemployee Home Ending");
		return autosearchemployee;
	}
	public ArrayList<GetAllEmployeeVO> searchemployee(String searchterm){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:searchemployee Home Starting");
		ArrayList<GetAllEmployeeVO> searchemployee=new ArrayList<GetAllEmployeeVO>();
		GetAllEmployeeDao obj=new GetAllEmployeeDaoImpl();
		try{
			searchemployee=obj.searchemployee(searchterm);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:searchemployee Home Ending");
		return searchemployee;
	}
	public ArrayList<EmployVO> modifyemployee(String empid){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:modifyemployee Home Starting");
		ArrayList<EmployVO> modifyemployee=new ArrayList<EmployVO>();
		GetAllEmployeeDao obj=new GetAllEmployeeDaoImpl();
		try{
		modifyemployee=obj.modifyemployee(empid);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:modifyemployee Home Ending");
		return modifyemployee;
	}
	public List<AllEmployeeReportVO> getallEmployeeDetails(String[] empids) {
		
		return new GetAllEmployeeDaoImpl().getallEmployeeDetails(empids);
	}
	@Override
	public ArrayList<AllEmployeesViewDialogVo> getEmpDetailsForViewService(String empid) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:getEmpDetailsForViewService Home Starting");
		
		ArrayList<AllEmployeesViewDialogVo> empDetailsList=new ArrayList<AllEmployeesViewDialogVo>();
		GetAllEmployeeDao obj=new GetAllEmployeeDaoImpl();
		try{
			empDetailsList=obj.getEmpDetailsForViewDao(empid);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:getEmpDetailsForViewService Home Ending");
		return empDetailsList;
	}
	
	public ArrayList<GetAllEmployeeVO> getDeactiveEmployeeDetails(){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl: getDeactiveEmployeeDetails Starting");
		GetAllEmployeeDao obj=new GetAllEmployeeDaoImpl();
		ArrayList<GetAllEmployeeVO> getDetails=new ArrayList<GetAllEmployeeVO>();
		try{
		getDetails=obj.getDeactiveEmployeeDetails();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl:getDeactiveEmployeeDetails Ending");
		return getDetails;
	}
	
	public int activateEmployee(String empid){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl: activateEmployee Starting");
		GetAllEmployeeDao obj=new GetAllEmployeeDaoImpl();
	    int status=0;
		try{
			status=obj.activateEmployee(empid);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeServiceImpl: activateEmployee Ending");
		return status;
	}
		
}
