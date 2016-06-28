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
import com.centris.VO.EmployVO;
import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.DisplayDeactiveEmployeeDetailsBD;
import com.centris.delegate.ProjectManagerMappingBD;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class DisplayDeactiveEmployeeDetailsAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(DisplayDeactiveEmployeeDetailsAction.class);
	
	public ActionForward getDeactiveEmployeeDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DisplayDeactiveEmployeeDetailsAction : getDeactiveEmployeeDetails Starting");
		String usertype=HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {
			
			String empid = request.getParameter("selectEmployee");

			ArrayList<EmployVO> displayList = new ArrayList<EmployVO>();
			
			displayList = new DisplayDeactiveEmployeeDetailsBD().getDeactiveEmployeeDetails(empid);
			
			if(displayList.size()!=0){
				
			EmployVO voObject = displayList.get(0);
			request.setAttribute("employeeDetails", voObject);
			
			}

			request.getSession(false).setAttribute("designationDetails",
					new AddDesignationBD().getDesignationDetails());
			request.getSession(false).setAttribute("departmentDetails",
					new DepartmentMasterBD().getDepartmentRecordsBD());
			request.getSession(false).setAttribute("managerDetails",
					new ProjectManagerMappingBD().getManager());
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DisplayDeactiveEmployeeDetailsAction : getDeactiveEmployeeDetails Ending");
		System.out.println("usertype :: "+usertype);
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "DisplayDeactiveEmployees";
		} else {
			forward ="DisplayDeactiveEmployeesInDirector";
		}
		
		System.out.println("forward ::: "+forward);
		return mapping.findForward(forward);
	}

}
