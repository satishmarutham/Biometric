package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
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

import com.centris.DAO.DAOIMPL.EmployeeAttendancePostingDaoImpl;
import com.centris.POJO.AttendenceApprovelPojo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.VO.ClientVO;
import com.centris.VO.CurrentSearchVo;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AttendanceApprovalByDateBD;
import com.centris.delegate.AttendenceApprovelBD;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.exception.AITrackerException;
import com.centris.form.AttendanceApprovalByDateForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class AttendanceApprovalByDateAction extends DispatchAction {
	

	
private static Logger logger = Logger.getLogger(AttendanceApprovalByDateAction.class);
	
	//Get employee attendence
	public ActionForward getEmployeeAttendence(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getEmployeeAttendence Starting");
		
		String userType=HelperClass.getCurrentUserIDType(request);
		try {
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();

			request.getSession(false).setAttribute("emp_list",new AttendenceApprovelBD().getEmployees(currentUserId,userType));
			
			AttendanceApprovalByDateForm att_fprm=(AttendanceApprovalByDateForm)form;
			
		    String employeename=new AttendanceApprovalByDateBD().getSingleEmployee(att_fprm.getEmployeename());
		  
		  ArrayList<CurrentSearchVo> current_search_list=new ArrayList<CurrentSearchVo>();
		  CurrentSearchVo cvo=new CurrentSearchVo();
		  
		  cvo.setEmployeeid(att_fprm.getEmployeename());
		  cvo.setStartdate(att_fprm.getStartdate());
		  cvo.setEnddate(att_fprm.getEnddate());
		  cvo.setEmployeename(employeename);
		  
		  current_search_list.add(cvo);
		  
		  request.setAttribute("current_search_list", current_search_list);
		   
		   ArrayList<AttendenceApprovelVo> attendence_list=new AttendanceApprovalByDateBD().getEmployeeAttendance(att_fprm,currentUserId);
		   
		   if(attendence_list.size()!=0){
		   request.setAttribute("attendence_list", attendence_list);
		   }else{
			   
			   request.setAttribute("Nothing", "Nothing found to display");
		   }
		   
		   

		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getEmployeeAttendence Ending");
		
		if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			
			return mapping.findForward("admin_attendenceapprovel_by_date");
			
		}else{
			
		return mapping.findForward("attendenceapprovel_by_date");
		
		}

	}
	
	
	//Get attendence status type
	public ActionForward getAttendanceStatusType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getAttendanceStatusType Starting");
		try {
			
		
			ArrayList<AttendenceApprovelVo> att_status_typ_list=new AttendanceApprovalByDateBD().getAttendanceStatusTypeBD();
		   
			JSONObject object=new JSONObject();
			object.put("ATT_TYPE_LIST", att_status_typ_list);
			
			response.getWriter().print(object);
		   

		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getAttendanceStatusType Ending");
		
		return null;

	}

	//Get project
	public ActionForward getProject(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AITrackerException, Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getProject Starting");
			try {
				
				UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
				String userid =userDetailVO.getUserCode();
				String userType=HelperClass.getCurrentUserIDType(request);
				
				ArrayList<ProjectMasterVo> project_list=null;
				
				if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
					
					if(request.getParameter("empId")!=null){
					
					String empId=request.getParameter("empId");
					
					project_list=new ProjectMasterDelegate().getAllProjectsByDir(empId,userid);
					}
					
				}else{
					
					project_list=new ProjectMasterDelegate().getAllProjects(userid);
					
				}
				
				
			   
				JSONObject object=new JSONObject();
				object.put("project_list", project_list);
				
				response.getWriter().print(object);
			   

			} catch (Exception exception) {
				logger.error(exception.getMessage(),exception);
				exception.printStackTrace();
			}
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getProject Ending");
			
			return null;

		}
	
	
	public ActionForward getClients(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getClients Starting");
		try {
			
			List<ClientVO> clientList= new  AttendenceApprovelBD().getAllClients();
			
			JSONObject object=new JSONObject();
			object.put("client_list", clientList);
			
			response.getWriter().print(object);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getClients Ending");
		
		return null;

	}
		
		
		//Get Attendance status
	public ActionForward getAttendanceStatus(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response)
						throws AITrackerException, Exception {
					
					logger.setLevel(Level.DEBUG);
					JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
					logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : attendanceStatus Starting");
					try {
						
					
						ArrayList<AttendenceApprovelVo> att_status=new AttendanceApprovalByDateBD().getAttendanceStatus();
						   
						JSONObject object=new JSONObject();
						object.put("att_status", att_status);
						
						response.getWriter().print(object);
					   

					} catch (Exception exception) {
						logger.error(exception.getMessage(),exception);
						exception.printStackTrace();
					}
					JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
					logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : attendanceStatus Ending");
					
					return null;

				}
		
		
		
		//updateEmpAttendance
		public ActionForward updateEmpAttendance(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AITrackerException, Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : updateEmpAttendance Starting");
			try {
				
				
				String empid=request.getParameter("empid");
				String attendencedate=request.getParameter("attendencedate");
				String attendence_status=request.getParameter("attendence_status");
				String status_type=request.getParameter("status_type");
				String location=request.getParameter("location");
				String project_name=request.getParameter("project_name");
				String inTime=request.getParameter("inTime");
				String outTime=request.getParameter("outTime");
				
				AttendenceApprovelPojo att_pojo=new AttendenceApprovelPojo();
				
				att_pojo.setEmployeeid(empid);
				att_pojo.setAttendencedate(HelperClass.convertUIToDatabase(attendencedate));
				att_pojo.setAttendancestatus(attendence_status);
				att_pojo.setAttendancetype(status_type);
				att_pojo.setLocation(location);
				att_pojo.setProjectname(project_name);
				att_pojo.setIntime(inTime);
				att_pojo.setOuttime(outTime);
				att_pojo.setUsername(HelperClass.getCurrentUser(request));
				att_pojo.setUsercode(HelperClass.getCurrentUserID(request));
			
			String status=new AttendanceApprovalByDateBD().updateEmpAttendance(att_pojo);
			   
				JSONObject object=new JSONObject();
				object.put("status", status);
				
				response.getWriter().print(object);
			   

			} catch (Exception exception) {
				logger.error(exception.getMessage(),exception);
				exception.printStackTrace();
			}
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : updateEmpAttendance Ending");
			
			return null;

		}
		
		//update all employees attendance
		public ActionForward updateAllEmpAttendance(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AITrackerException, Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : updateAllEmpAttendance Starting");
			try {
				
				AttendenceApprovelPojo att_pojo=new AttendenceApprovelPojo();
				
				att_pojo.setEmployeeid(request.getParameter("empid"));
				att_pojo.setUsername(HelperClass.getCurrentUser(request));
				att_pojo.setUsercode(HelperClass.getCurrentUserID(request));  
				att_pojo.setAttendencedate(request.getParameter("attendanceDate"));
				att_pojo.setIntime(request.getParameter("inTime"));
				att_pojo.setOuttime(request.getParameter("outTime"));
				att_pojo.setAttendancestatus(request.getParameter("status"));
				att_pojo.setAttendancetype(request.getParameter("statustype"));
				att_pojo.setLocation(request.getParameter("location"));
				att_pojo.setProjectname(request.getParameter("projectName"));
				
			
			String status=new AttendanceApprovalByDateBD().updateAllEmpAttendance(att_pojo);
			   
				JSONObject object=new JSONObject();
				object.put("status", status);
				
				response.getWriter().print(object);
			   

			} catch (Exception exception) {
				logger.error(exception.getMessage(),exception);
				exception.printStackTrace();
			}
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : updateAllEmpAttendance Ending");
			
			return null;

		}
		
		//Get employee specific attendance attendence
		public ActionForward getEmployeeSpecificAttendence(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AITrackerException, Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getEmployeeSpecificAttendence Starting");
			
			String userType=HelperClass.getCurrentUserIDType(request);
			
			try {
				
				
				
				String empdetails=request.getParameter("empdetails");
				String selectattendance=request.getParameter("selectattendance");
				
				
				String empid=empdetails.split(",")[0];
				String startdate=empdetails.split(",")[1];
				String enddate=empdetails.split(",")[2];
				
				 String employeename=new AttendanceApprovalByDateBD().getSingleEmployee(empid);
				  
				 ArrayList<CurrentSearchVo> current_search_list=new ArrayList<CurrentSearchVo>();
				  CurrentSearchVo cvo=new CurrentSearchVo();
				  
				  cvo.setEmployeeid(empid);
				  cvo.setStartdate(startdate);
				  cvo.setEnddate(enddate);
				  cvo.setEmployeename(employeename);
				  cvo.setStatus(selectattendance);
				  
				  
				  
				  current_search_list.add(cvo);
				  
				  request.setAttribute("current_search_list", current_search_list);
				
				AttendenceApprovelPojo att_pojo=new AttendenceApprovelPojo();
				
				att_pojo.setEmployeeid(empid);
				att_pojo.setStartdate(HelperClass.convertUIToDatabase(startdate));
				att_pojo.setEnddate(HelperClass.convertUIToDatabase(enddate));
				if("all".equalsIgnoreCase(selectattendance)){
				att_pojo.setAttendancestatus("%%");
				}else{
					
					att_pojo.setAttendancestatus(selectattendance);
				}
				att_pojo.setUsercode(HelperClass.getCurrentUserID(request));
				
				  ArrayList<AttendenceApprovelVo> attendence_list=new AttendanceApprovalByDateBD().getEmployeeSpecificAttendence(att_pojo);
				
				request.setAttribute("attendence_list", attendence_list);
			   
			   

			} catch (Exception exception) {
				logger.error(exception.getMessage(),exception);
				exception.printStackTrace();
			}
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateAction : getEmployeeSpecificAttendence Ending");
			
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
				return mapping.findForward("attendenceapprovel_by_director_date");
			}else{
			return mapping.findForward("attendenceapprovel_by_date");
			}

		}
		

	
	

}
