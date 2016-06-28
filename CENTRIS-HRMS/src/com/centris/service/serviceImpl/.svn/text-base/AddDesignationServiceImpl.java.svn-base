package com.centris.service.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DAOIMPL.AddDesignationDaoImpl;
import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.AddDesignationPojo;
import com.centris.VO.AddDesignationVO;
import com.centris.form.AddDesignation;
import com.centris.service.AddDesignationService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class AddDesignationServiceImpl  implements AddDesignationService{

	private static 	Logger logger = Logger.getLogger(AddDesignationServiceImpl.class);
	
	public String insertDesignationDetails(AddDesignation aform,String currentuser){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationServiceImpl:insertDesignationDetails: Starting");
		
		IDGenerator id=new IDGenerator();
	/*	Date currentDate=HelperClass.getCurrentTime();*/
		AddDesignationPojo apojo=new AddDesignationPojo();

		try {
			
			apojo.setDesgid(id.getPrimaryKeyID("hrms_designation"));
			apojo.setDesgname(aform.getDesignation_name());
			apojo.setDesgdes(aform.getDesignation_description());
			apojo.setReportingTo(aform.getReportingTo());
			
			apojo.setCreatedDate("");
			apojo.setCreatedBy(currentuser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationServiceImpl:insertDesignationDetails: Ending");
	
		return new AddDesignationDaoImpl().insertDesignationDetails(apojo);
	
	}
	public String updateDesignationDetails(AddDesignation aform,String currentuser){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationServiceImpl:updateDesignationDetails: Starting");
		
		AddDesignationPojo apojo=new AddDesignationPojo();
		
		try {
			
			apojo.setDesgid(aform.getDesignationid());
			apojo.setDesgname(aform.getDesignation_name());
			apojo.setDesgdes(aform.getDesignation_description());
			apojo.setReportingTo(aform.getReportingTo());
			
			apojo.setCreatedBy(currentuser);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationServiceImpl:updateDesignationDetails: Ending");
		
		return new AddDesignationDaoImpl().updateDesignationDetails(apojo);
	}
	
	
	public ArrayList<AddDesignationVO> getDesignationDetails(){
	
		return new AddDesignationDaoImpl().getDesignationDetails();
	
	}
	
	public boolean validateDesName(String desname,String desid){
		
		return new AddDesignationDaoImpl().validateDesName(desname,desid);
	}
	
	public boolean validateDesNameUpdate(String desname,String desid){
		
		return new AddDesignationDaoImpl().validateDesNameUpdate(desname,desid);
	}
	
	public ArrayList<AddDesignationVO> getEditDesignationDetails(String desid){
		
		return new AddDesignationDaoImpl().getEditDesignationDetails(desid);
	}
	
public String deleteDesignationDetails(String[] desid){
		
		return new AddDesignationDaoImpl().deleteDesignationDetails(desid);
	}


}
