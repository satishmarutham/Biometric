package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DAOIMPL.ManagerDirectorMappingDAOIMPL;
import com.centris.VO.ManagerDirectorMappingVo;
import com.centris.service.ManagerDirectorMappingService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ManagerDirectorMappingServiceImpl implements ManagerDirectorMappingService{
	
	private static 	Logger logger = Logger.getLogger(ManagerDirectorMappingServiceImpl.class);
	
	public ArrayList<ManagerDirectorMappingVo> getDirector()
	{
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in ManagerDirectorMappingServiceImpl : getDirector Starting");
		ArrayList<ManagerDirectorMappingVo> directorlist=null;
		try{
			
			directorlist=new ManagerDirectorMappingDAOIMPL().getDirector();
			
			
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingServiceImpl : getDirector Ending");
		return directorlist;
		
		
	}
	
	public ArrayList<ManagerDirectorMappingVo> getAvailableManagers()
	{
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in ManagerDirectorMappingServiceImpl : getAvailableManagers Starting");
		ArrayList<ManagerDirectorMappingVo> directorlist=null;
		try{
			
			directorlist=new ManagerDirectorMappingDAOIMPL().getAvailableManagers();
			
			
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingServiceImpl : getAvailableManagers Ending");
		return directorlist;
		
	}
	
	public String savemanagerDirectorMapping(String directorId,JSONArray jsonproject, String username) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in ManagerDirectorMappingServiceImpl : savemanagerDirectorMapping Starting");
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingServiceImpl : savemanagerDirectorMapping Ending");
			
		return new ManagerDirectorMappingDAOIMPL().savemanagerDirectorMapping(directorId,jsonproject,username);
		}
	
	
	public ArrayList<ManagerDirectorMappingVo> getMappedManagers(String directorId)
	{
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in ManagerDirectorMappingServiceImpl : getMappedManagers Starting");
		ArrayList<ManagerDirectorMappingVo> mappedmanagers=null;
		try{
			
			mappedmanagers=new ManagerDirectorMappingDAOIMPL().getMappedManagers(directorId);
			
			
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingServiceImpl : getMappedManagers Ending");
		return mappedmanagers;
		
		
	}
	
	
	

	
	
}
