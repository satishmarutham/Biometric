package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.VO.EmpVO;
import com.centris.VO.LocationMasterVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.LocationMasterBD;
import com.centris.delegate.ModifyEmployeeBD;
import com.centris.form.AddEmployeeForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class ModifyEmployeeAction extends DispatchAction {
	
	private static 	Logger logger = Logger.getLogger(ModifyEmployeeAction.class);

	public synchronized ActionForward ModifyEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: ModifyEmployee : Starting");

		try{
		AddEmployeeForm modifyEmpForm = (AddEmployeeForm) form;
	
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String username=userDetailVO.getUserCode();
		
		String status=new ModifyEmployeeBD().ModifyEmployee(modifyEmpForm,username);
		
		request.setAttribute("message", status);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: ModifyEmployee : Ending");
		
		return mapping.findForward(ApplicationConstants.EMP_MODIFY);
	}

	
	
	public ActionForward getModifyEmployeeList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: getModifyEmployeeList : Starting");
		
		try{
		String search = request.getParameter("searchTerm").toString();
		
		ArrayList<EmpVO> empVOlist=new ArrayList<EmpVO>();
		
		empVOlist=new ModifyEmployeeBD().getModifyEmployeeList(search);
		
		
		JSONObject jo = new JSONObject();
		jo.accumulate("emplist", empVOlist);
		
		response.getWriter().print(jo);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: getModifyEmployeeList : Ending");
		
		return null;
	}
	
	public ActionForward checkEmail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: checkEmail : Starting");
	try{	
	String empemail=(String)request.getParameter("email");
	String empid=(String)request.getParameter("empid");
	
		boolean status=new ModifyEmployeeBD().checkEmail(empemail,empid);
		
		JSONObject object=new JSONObject();
		object.put("status", status);
		response.getWriter().print(object);
	}catch(Exception e){
		
		e.printStackTrace();
		logger.error(e);
	}
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ModifyEmployeeAction: checkEmail : Ending");
		
		return null;
	}
	
	public synchronized ActionForward ModifyEmployeefromlist(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: ModifyEmployeefromlist : Starting");
		
		try{
		
		String id = request.getParameter("selectEmployee");

		List<EmpVO> empVOlist = new ModifyEmployeeBD().getModifyEmpDetailsForAllEmp(id);

		EmpVO voobj = new EmpVO();
		voobj = (EmpVO) empVOlist.get(0);
		HashSet<LocationMasterVo> hlist=null;
		String locationlist="";
		String locationidlist="";
		
		if(voobj.getIsempreginmultilocations().equalsIgnoreCase("Y")){
		
		 hlist=voobj.getLocationslist();
		/* for(int i=0;i<hlist.size();i++){
		 locationlist=hlist
		 }*/
		 
		 for (LocationMasterVo myVal : hlist) {
		       
			 locationlist=myVal.getLocationname()+","+locationlist;
			 locationidlist=myVal.getLocationid()+","+locationidlist;
			 
			 System.out.println("location string --- "+locationlist);
		      }
		 
		}
		
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String groupcode=userDetailVO.getGroupCode();
		
		request.setAttribute("employeeDetails", voobj);
		
		request.getSession(false).setAttribute("DESIGNATIONLIST", new AddDesignationBD().getDesignationDetails());
		request.getSession(false).setAttribute("LOCATIONLIST", new LocationMasterBD().getLocation(groupcode));
		request.getSession(false).setAttribute("DEPARTMENTLIST", new DepartmentMasterBD().getDepartmentRecordsBD());
		request.getSession(false).setAttribute("MAPPEDLOCATIONSLIST", locationlist);
		request.getSession(false).setAttribute("MAPPEDLOCATIONSIDLIST", locationidlist);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: ModifyEmployeefromlist : Ending");
		
		return mapping.findForward("modifyEmployee");
	}
	
	public ActionForward checkEmpregNo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: checkEmpregNo : Starting");
	try{	
	String empregno=(String)request.getParameter("empregno");
	String empid=(String)request.getParameter("empid");
	
		boolean status=new ModifyEmployeeBD().checkEmpregNo(empregno,empid);
		
		JSONObject object=new JSONObject();
		object.put("status", status);
		response.getWriter().print(object);
	}catch(Exception e){
		
		e.printStackTrace();
		logger.error(e);
	}
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ModifyEmployeeAction: checkEmpregNo : Ending");
		
		return null;
	}
	
	public  ActionForward getSearchEmployees(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: getSearchEmployees : Starting");
		
		try{
		String search = request.getParameter("name_startsWith").toString();
		String max = request.getParameter("maxRows").toString();
		

		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String groupcode=userDetailVO.getGroupCode();
		
		ArrayList<EmpVO> emplist=new ModifyEmployeeBD().getSearchEmployees( search, max,groupcode);
		
		JSONObject jo = new JSONObject();
		jo.accumulate("empVOlist", emplist);
		
		response.getWriter().print(jo);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeAction: getSearchEmployees : Ending");
		
		return null;
	}
	
	
	
	
	
}