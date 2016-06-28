package com.centris.delegate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;




import com.centris.VO.AllEmployeeReportVO;
import com.centris.VO.AllEmployeesViewDialogVo;
import com.centris.VO.EmployVO;
import com.centris.VO.GetAllEmployeeVO;
import com.centris.service.GetAllEmployeeService;
import com.centris.service.serviceImpl.GetAllEmployeeServiceImpl;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class GetAllEmployeeBD {
	private static Logger logger = Logger.getLogger(GetAllEmployeeBD.class);
public ArrayList<GetAllEmployeeVO> getDetails(){
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:All_Employee Home Starting");
	
	GetAllEmployeeService obj=new GetAllEmployeeServiceImpl();
	ArrayList<GetAllEmployeeVO> employeeDetails=new ArrayList<GetAllEmployeeVO>();
	try{
		employeeDetails=obj.getDetails();
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:All_Employee Home Ending");
	return employeeDetails;
}
public ArrayList<GetAllEmployeeVO> autosearchemployee(String term){
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:autosearchemployee Starting");
	
	GetAllEmployeeService obj=new GetAllEmployeeServiceImpl();
	ArrayList<GetAllEmployeeVO> autosearchemployee=new ArrayList<GetAllEmployeeVO>();
	try{
	autosearchemployee=obj.autosearchemployee(term);
	}catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:autosearchemployee Ending");
	return autosearchemployee;
}
public ArrayList<GetAllEmployeeVO> searchemployee(String searchterm){
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:searchemployee Starting");
	
	GetAllEmployeeService obj=new GetAllEmployeeServiceImpl();
	ArrayList<GetAllEmployeeVO> searchemployee=new ArrayList<GetAllEmployeeVO>();
	try{
	searchemployee=obj.searchemployee(searchterm);
	}catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:searchemployee Ending");
	return searchemployee;
}
public ArrayList<EmployVO> modifyemployee(String empid){
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:modifyemployee Starting");
	ArrayList<EmployVO> modifyemployee=new ArrayList<EmployVO>();
	
	GetAllEmployeeService obj=new GetAllEmployeeServiceImpl();
	try{
		modifyemployee=obj.modifyemployee(empid);
	}catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:modifyemployee Ending");
	return modifyemployee;
}

public List<AllEmployeeReportVO> getallEmployeeDetails(String[] empids) {
	
	GetAllEmployeeService obj=new GetAllEmployeeServiceImpl();
	
	return obj.getallEmployeeDetails(empids);
}

public ArrayList<AllEmployeesViewDialogVo> getEmpDetailsForViewBD(String empid){
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:getEmpDetailsForViewBD Starting");
	ArrayList<AllEmployeesViewDialogVo> modifyemployee=new ArrayList<AllEmployeesViewDialogVo>();
	
	GetAllEmployeeService obj=new GetAllEmployeeServiceImpl();
	try{
		modifyemployee=obj.getEmpDetailsForViewService(empid);
	}catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:getEmpDetailsForViewBD Ending");
	return modifyemployee;
}

public ArrayList<GetAllEmployeeVO> getDeactiveEmployeeDetails() {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD : getDeactiveEmployeeDetails Starting");

	GetAllEmployeeService obj = new GetAllEmployeeServiceImpl();
	ArrayList<GetAllEmployeeVO> employeeDetails = new ArrayList<GetAllEmployeeVO>();
	try {
		employeeDetails = obj.getDeactiveEmployeeDetails();
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}

	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD:getDeactiveEmployeeDetails Ending");
	return employeeDetails;
}

public int activateEmployee(String empid) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD : activateEmployee Starting");

	GetAllEmployeeService obj = new GetAllEmployeeServiceImpl();
	 int status=0;
	try {
		status = obj.activateEmployee(empid);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}

	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GetAllEmployeeBD: activateEmployee Ending");
	return status;
}



}
