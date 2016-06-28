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

import com.centris.VO.AllEmployeeVo;
import com.centris.VO.GetAllEmployeeVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.AddEmployeeBD;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.EmployeeBD;
import com.centris.delegate.GetAllEmployeeBD;
import com.centris.delegate.ProjectManagerMappingBD;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.exception.AITrackerException;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.constants.MessageConstants;

public class DirectorAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(DirectorAction.class);

	public ActionForward home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : home : Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ "Control in DirectorAction : home : Ending");
		return mapping.findForward(Director.DIRECTOR_LOGIN);
	}

	public ActionForward getEmployeePage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : getEmployeePage Starting");
		try {
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String userid =userDetailVO.getUserCode();
			request.getSession(false).setAttribute("designationDetails",
					new AddDesignationBD().getDesignationDetails());
			request.getSession(false).setAttribute("departmentDetails",
					new DepartmentMasterBD().getDepartmentRecordsBD());
			request.getSession(false).setAttribute("managerDetails",
					new ProjectManagerMappingBD().getManager());
			request.getSession().setAttribute("projectDetailsList",
					new ProjectMasterDelegate().getAllProjects(userid));
			
			String BioId=new EmployeeBD().getBioIdBD(); 
			if(BioId!=null){
				
				request.setAttribute("BioId", BioId);
			}
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : getEmployeePage Ending");
		return mapping.findForward(Director.DIRECTOR_EMPLOYEE_ADD);
	}

	public ActionForward getEmployeeAmendmentPage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : getEmployeeAmendmentPage Starting");
		try {
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String userid =userDetailVO.getUserCode();
			
			request.getSession(false).setAttribute("designationDetails",
					new AddDesignationBD().getDesignationDetails());
			request.getSession(false).setAttribute("departmentDetails",
					new DepartmentMasterBD().getDepartmentRecordsBD());
			request.getSession(false).setAttribute("managerDetails",
					new ProjectManagerMappingBD().getManager());
			request.getSession().setAttribute("projectDetailsList",
					new ProjectMasterDelegate().getAllProjects(userid));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : getEmployeeAmendmentPage Ending");
		return mapping.findForward(Director.DIRECTOR_EMPLOYEE_AMENDMENT);
	}
	
	public ActionForward getAllEmployeePage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : getAllEmployeePage Starting");
		ArrayList<GetAllEmployeeVO> list = new ArrayList<GetAllEmployeeVO>();

		try {
			list = new GetAllEmployeeBD().getDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		

		request.setAttribute("emplist", list);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : getAllEmployeePage Ending");
		return mapping.findForward(Director.DIRECTOR_GET_ALL_EMPLOYEES);
	}
	
	public ActionForward listofAllEmployeeSearch(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : listofAllEmployeeSearch : Starting");

		String name = request.getParameter("empName");

		List<AllEmployeeVo> getEmployee = null;
		try {

			getEmployee = new AddEmployeeBD().getSerachofAllEmployee(name);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		request.setAttribute("total_Size", getEmployee.size());
		request.setAttribute("getAllEmployee", getEmployee);

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorAction : listofAllEmployeeSearch : Ending");

		return mapping.findForward(Director.DIRECTOR_GET_ALL_EMPLOYEES);
	}
}