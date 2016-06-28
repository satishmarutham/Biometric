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
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.VO.ManagerMasterVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.ManagerMasterBD;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.form.ManagerMasterForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ManagerMasterAction extends DispatchAction{

	private static 	Logger logger = Logger.getLogger(ManagerMasterAction.class);
	public ActionForward managerMasterHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:managerMasterHome: Starting");
		
		 try{
    	ArrayList<ManagerMasterVO>	 managerList= new ManagerMasterBD().getAllManagersBD();
    	request.getSession(false).setAttribute("departmentDetails",
				new DepartmentMasterBD().getDepartmentRecordsBD());
		request.setAttribute("ManagerList", managerList);
    		
		
		String status=request.getParameter("status");
	
    		if(status!=null){
				request.setAttribute("message", status);
			}
		
		 }catch(Exception e){
				
				e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:managerMasterHome: Ending");
		
	
		return mapping.findForward(MessageConstants.MANAGER_MASTER_HOME);
	}

	public ActionForward Add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:Add: Starting");
		
	 try{
			
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String usercode=userDetailVO.getUserCode();
		
				
		String  managerID=	new IDGenerator().getPrimaryKeyID("hrms_manager");
			
		ManagerMasterForm managerform=(ManagerMasterForm)form;
		
		
		managerform.setCreatedby(usercode);
		managerform.setManagerid(managerID);
		
		
		String status=new ManagerMasterBD().addManagerBD(managerform);
		request.setAttribute("message", status);
		
		ArrayList<ManagerMasterVO>	 managerList= new ManagerMasterBD().getAllManagersBD();
		request.setAttribute("ManagerList", managerList);
	 
	 }catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:Add: Ending");
		
	
		return mapping.findForward(MessageConstants.MANAGER_MASTER_HOME);
	}
	public ActionForward checkManagerCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkManagerCount: Starting");
		
	 try{
			
		String username=request.getParameter("username");			
				
		boolean status=new ManagerMasterBD().checkManagerCountBD(username);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("status", status);
		response.getWriter().print(jsonObject);
			 
	 }catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkManagerCount: Ending");
		
	
		return null;
	}
	public ActionForward checkManagerEmailCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkManagerEmailCount: Starting");
		
	 try{
			
		String emailid=request.getParameter("emailid");			
				
		boolean status=new ManagerMasterBD().checkManagerEmailCountBD(emailid);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("status", status);
		response.getWriter().print(jsonObject);
			 
	 }catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkManagerEmailCount: Ending");
		
	
		return null;
	}
	public ActionForward editManagerDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:editManagerDetails: Starting");
		
	 try{
			
		String managerid=request.getParameter("managerID");			
				
		ArrayList<ManagerMasterVO> managerList=new ManagerMasterBD().editManagerDetailsBD(managerid);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("ManagerList", managerList);
		
		response.getWriter().print(jsonObject);
			 
	 }catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:editManagerDetails: Ending");
		
		return null;
	}
	
	public ActionForward checkManagerCountUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkManagerCountUpdate: Starting");
		
	 try{
			
		String username=request.getParameter("username");
		String managerid=request.getParameter("managerID");			
				
		boolean status=new ManagerMasterBD().checkManagerCountUpdateBD(username,managerid);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("status", status);
		response.getWriter().print(jsonObject);
			 
	 }catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkManagerCountUpdate: Ending");
		
		return null;
	}
	
	public ActionForward checkUpdateEmailCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkUpdateEmailCount: Starting");
		
	 try{
			
		String emailid=request.getParameter("emailid");
		String managerid=request.getParameter("managerID");			
				
		boolean status=new ManagerMasterBD().checkUpdateEmailCountBD(emailid,managerid);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("status", status);
		response.getWriter().print(jsonObject);
			 
	 }catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkUpdateEmailCount: Ending");
		
		return null;
	}
	
	public ActionForward Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:Update: Starting");
		
	 try{
			
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String usercode=userDetailVO.getUserCode();
			
				
		ManagerMasterForm managerform=(ManagerMasterForm)form;
		managerform.setCreatedby(usercode);
		
		
		String status=new ManagerMasterBD().updateManagerBD(managerform);
		request.setAttribute("message", status);
		
		ArrayList<ManagerMasterVO>	 managerList= new ManagerMasterBD().getAllManagersBD();
		request.setAttribute("ManagerList", managerList);
	 
	 }catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:Update: Ending");
		
	
		return mapping.findForward(MessageConstants.MANAGER_MASTER_HOME);
	}
	
	public ActionForward deleteManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:Update: Starting");
	 try{
			
		
		 String[] managerID=request.getParameterValues("managerID[]");
					
			 String status =new ManagerMasterBD().deleteManagerBD(managerID);
		  
			  JSONObject object=new JSONObject();
			  object.put("status", status);
	    	  response.getWriter().print(object);
 
	        }catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:Update: Ending");
		
	
		return null;
	}
	
	
	
	
}
