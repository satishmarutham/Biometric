package com.centris.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.LetterHeadPOJO;
import com.centris.VO.LetterHeadVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.LetterHeadBD;
import com.centris.exception.AITrackerException;
import com.centris.form.LetterHeadForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class LetterHeadAction extends DispatchAction{


	private static 	Logger logger = Logger.getLogger(LetterHeadAction.class);
	
	public synchronized  ActionForward letterHeadHome(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in LetterHeadAction: letterHeadHome : Starting");
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String usercode=userDetailVO.getUserCode();
			
			ArrayList<LetterHeadVo> letterheadlist=new LetterHeadBD().getAllLetterHeads(usercode);
		
	    	request.setAttribute("AllLetterHeads", letterheadlist);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in LetterHeadAction: letterHeadHome : Ending");

		return mapping.findForward(MessageConstants.LETTERHEAD);	
	}
	
	public synchronized  ActionForward insertLetterHead(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in LetterHeadAction: insertLetterHead : Starting");
		try{
		
		LetterHeadForm letterheadform = (LetterHeadForm) form;
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String usercode=userDetailVO.getUserCode();
		
		LetterHeadPOJO letterHeadPOJO=new LetterHeadPOJO();
		
		letterHeadPOJO.setLettertype(letterheadform.getLettertype().trim());
		letterHeadPOJO.setPurpose(letterheadform.getPurpose().trim());
		letterHeadPOJO.setDescription(letterheadform.getDescription().trim());
		letterHeadPOJO.setCreatedby(usercode.trim());
		letterHeadPOJO.setLetterheadcode(new IDGenerator().getPrimaryKeyID("hrms_employee_letterhead_request"));
		
		String status=new LetterHeadBD().insertLetterHead(letterHeadPOJO);
		
		ArrayList<LetterHeadVo> letterheadlist=new LetterHeadBD().getAllLetterHeads(usercode);
	  	request.setAttribute("AllLetterHeads", letterheadlist);
		
		if(status.equals("true")){
			request.setAttribute("successMessage", MessageConstants.LETTERHEAD_INSERT_SUCCESS);
		}else{
			request.setAttribute("errorMessage", MessageConstants.LETTERHEAD_INSERT_FAILURE);
		}
	
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in LetterHeadAction: insertLetterHead : Ending");

		return mapping.findForward(MessageConstants.LETTERHEAD);	
	}
	
	
	
	
	
	
}
