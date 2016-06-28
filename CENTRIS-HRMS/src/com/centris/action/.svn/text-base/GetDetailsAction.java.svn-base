package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.POJO.ClientMasterPojo;
import com.centris.POJO.RoleMasterPojo;
import com.centris.POJO.UserMasterPojo;
import com.centris.VO.AddDesignationVO;
import com.centris.VO.AdvanceSalaryRequestVo;
import com.centris.VO.AllEmployeeVo;
import com.centris.VO.AttendanceStatusTypeVO;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.EmployeeDeleteAuditVo;
import com.centris.VO.GetAllEmployeeVO;
import com.centris.VO.GroupMasterVO;
import com.centris.VO.LocationMasterVo;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.SalaryDetailsVo;
import com.centris.VO.ShiftMasterVO;
import com.centris.VO.UserDetailVO;
import com.centris.VO.UserRolePermissionVO;
import com.centris.VO.getAccYearVO;
import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.AddEmployeeBD;
import com.centris.delegate.AdvanceSalaryRequestBD;
import com.centris.delegate.AttendanceReconcillationBD;
import com.centris.delegate.AttendanceStatusTypeBD;
import com.centris.delegate.AttendenceApprovelBD;
import com.centris.delegate.ClientMasterBD;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.EmployeeBD;
import com.centris.delegate.EmployeeSalaryDetailsBD;
import com.centris.delegate.GetAllEmployeeBD;
import com.centris.delegate.GroupMasterBD;
import com.centris.delegate.LeaveBankBD;
import com.centris.delegate.LocationMasterBD;
import com.centris.delegate.ManagerMasterBD;
import com.centris.delegate.ProjectManagerMappingBD;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.delegate.RoleMasterBD;
import com.centris.delegate.ShiftMasterBD;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.delegate.TimesheetReconciliationBD;
import com.centris.delegate.UserManagementBD;
import com.centris.delegate.UserMasterBD;
import com.centris.delegate.UserRolePermissionBD;
import com.centris.exception.AITrackerException;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.EmployeePayroll;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.Manager;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;
import com.itextpdf.text.log.SysoLogger;

public class GetDetailsAction extends DispatchAction {

	List<String> empid = new ArrayList<String>();
	List<String> empname = new ArrayList<String>();
	List<String> phone = new ArrayList<String>();
	List<String> email = new ArrayList<String>();

	private static Logger logger = Logger.getLogger(GetDetailsAction.class);

	// Home
	public ActionForward home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward(StringUtils.HOME);
	}

	// Add Employee written by seshu

	public ActionForward addEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: addEmployee : Starting");
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();

			request.getSession(false).setAttribute("DESIGNATIONLIST",
					new AddDesignationBD().getDesignationDetails());
			request.getSession(false).setAttribute("LOCATIONLIST",
					new LocationMasterBD().getLocationByGroup(groupcode));
			request.getSession(false).setAttribute("DEPARTMENTLIST",
					new DepartmentMasterBD().getDepartmentRecordsBD());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: addEmployee : Ending");
		return mapping.findForward(ApplicationConstants.EMP_ADD);
	}

	// Modify Employee written by seshu
	public ActionForward modifyEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: modifyEmployee : Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();

			request.getSession(false).setAttribute("DESIGNATIONLIST",
					new AddDesignationBD().getDesignationDetails());
			request.getSession(false).setAttribute("LOCATIONLIST",
					new LocationMasterBD().getLocationByGroup(groupcode));
			request.getSession(false).setAttribute("DEPARTMENTLIST",
					new DepartmentMasterBD().getDepartmentRecordsBD());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: modifyEmployee : Ending");

		return mapping.findForward(ApplicationConstants.EMP_MODIFY);
	}

	public ActionForward removeEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("removeEmployee");
	}

	public ActionForward shiftHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * TITLE:Shift Master Author:Swathi
		 */
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction:shiftHome Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();

			ArrayList<ShiftMasterVO> shiftList = new ShiftMasterBD()
					.getAllShifts(groupcode);
			request.setAttribute(StringUtils.SHIFTLIST, shiftList);
			JSONArray array = new JSONArray(shiftList);
			System.out.println(array);
			ArrayList<LocationMasterVo> location = new LocationMasterBD()
					.getLocation(groupcode);
			request.setAttribute("location", location);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction:shiftHome Ending");

		return mapping.findForward(ApplicationConstants.SHIFT_MASTER);
	}

	// Help
	public ActionForward help(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			String prop_path = JLogger.getlog4JPropertyPath();
			PropertyConfigurator.configure(prop_path);
			Logger log = Logger.getLogger(AddEmployeeAction.class);
			log.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			log.info(JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return mapping.findForward(StringUtils.HELP);
	}

	// Change password
	public ActionForward changePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : changePassword Starting");

		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : changePassword Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = StringUtils.CHANGEPASSWORD;
		} else {
			forward = Director.DIRECTOR_CHANGEPASSWORD;
		}

		return mapping.findForward(forward);
	}

	// written by seshu to get all users
	public ActionForward getUsers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getUsers : Starting");

		try {
			UserMasterBD masterBD = new UserMasterBD();
			List<UserMasterPojo> masterPojos = new ArrayList<UserMasterPojo>();
			masterPojos = masterBD.getUserDetails();

			String success = (String) request.getParameter("success");

			request.setAttribute("usersList", masterPojos);
			request.setAttribute("status", success);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getUsers : Ending");

		return mapping.findForward("usermaster");

	}

	public ActionForward getRoles(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getRoles : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {
			List<RoleMasterPojo> roleMasterList = new ArrayList<RoleMasterPojo>();
			RoleMasterBD masterBD = new RoleMasterBD();
			roleMasterList = masterBD.getRoles();
			request.setAttribute("roleMasterList", roleMasterList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getRoles : Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "roleMaster";
		} else {
			forward = Director.DIRECTOR_ROLE_MASTER;
		}

		return mapping.findForward(forward);

	}

	public ActionForward getPermissiions(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getPermissiions : Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getPermissiions : Ending");
		return mapping.findForward("permissionmaster");

	}

	public ActionForward sendMailToCustomerSupport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: sendMailToCustomerSupport : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {
			request.getSession(false).setAttribute("NetworkStatus",
					request.getSession(false).getAttribute("NetworkStatus"));
			request.getSession(false).setAttribute("NetworkError",
					request.getSession(false).getAttribute("NetworkError"));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {

			forward = "ContactUsMail";
		} else if (usertype.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)) {

			forward = Director.DIRECTOR_CONTACT_US_MAIL;

		} else if (usertype.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {

			forward = Manager.MANAGER_CONTACT_US_MAIL;
		} else {

			forward = Employee.EMPLOYEE_CONTACT_US_MAIL;
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: sendMailToCustomerSupport : Ending");

		return mapping.findForward(forward);

	}

	public ActionForward getShiftBylocation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		try {
			// String location = request.getParameter("Location");
			// List<ShiftVO> shiftList = new
			// ShiftDAOIMPL().getShiftBylocation(location);
			/*
			 * JSONObject jsonObject = new JSONObject();
			 * jsonObject.put("shiftList",shiftList);
			 * response.getWriter().print(jsonObject);
			 */
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return null;
	}

	public ActionForward getEmpBylocationShift(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getEmpBylocationShift : Starting");

		try {
			/*
			 * String location = request.getParameter("Location"); String shift
			 * = request.getParameter("Shift"); List<EmpVO> empList = new
			 * ShiftDAOIMPL().getEmpBylocationShift(location,shift); JSONObject
			 * jsonObject = new JSONObject(); jsonObject.put("empList",empList);
			 * response.getWriter().print(jsonObject);
			 */
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getEmpBylocationShift : Ending");
		return null;

	}

	public ActionForward getLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getLocation : Starting");
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();

			List<LocationMasterVo> locationList = new LocationMasterBD()
					.getLocation(groupcode);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("locationList", locationList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getLocation : Ending");
		return null;

	}

	public ActionForward getUserRolePermission(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getUserRolePermission : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			request.getSession().setAttribute("RolePermission",
					new UserRolePermissionBD().getUserRolePermission());
			UserRolePermissionVO VO = new UserRolePermissionBD()
					.getUserRolePermission();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getUserRolePermission : Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "userRolePermission";
		} else {
			forward = Director.DIRECTOR_USER_ROLE_PERM;
		}
		return mapping.findForward(forward);

	}

	// written by seshu for display all employees
	public ActionForward listofEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: listofEmployee : Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();

			// System.out.println("Group Code = " + groupcode);

			List<AllEmployeeVo> getEmployee = null;

			getEmployee = new AddEmployeeBD().getAllDisplayEmployee(groupcode);

			// System.out.println(getEmployee.size());

			request.setAttribute("total_Size", getEmployee.size());
			request.setAttribute("getAllEmployee", getEmployee);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: listofEmployee : Ending");
		return mapping.findForward(ApplicationConstants.EMP_ALL);
	}

	// written by seshu to search one employee from all employees
	public ActionForward listofAllEmployeeSearch(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: listofAllEmployeeSearch : Starting");

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
				+ " Control in GetDetailsAction: listofAllEmployeeSearch : Ending");

		return mapping.findForward(ApplicationConstants.EMP_ALL);
	}

	public ActionForward getConsolidateDetailedMonthReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getConsolidateDetailedMonthReport : Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String currentUserId = userDetailVO.getUserCode();

			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);

			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getConsolidateDetailedMonthReport : Ending");
		return mapping.findForward("consolidateDetailedMonthReport");

	}

	public ActionForward getEmployeeWeekOff(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getEmployeeWeekOff Starting");

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getEmployeeWeekOff Ending");
		return mapping.findForward(MessageConstants.GETEMPLOYEE_WEEKOFF);
	}

	/*
	 * public ActionForward getDayReport(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * AITrackerException, Exception { logger.setLevel(Level.DEBUG);
	 * JLogger.log(0, JDate.getTimeString(new Date()) +
	 * MessageConstants.START_POINT); logger.info(JDate.getTimeString(new
	 * Date()) + " Control in GetDetailsAction : getDayReport Starting"); try {
	 * UserDetailVO userDetailVO = (UserDetailVO) request
	 * .getSession(false).getAttribute("UserDetails");
	 * 
	 * String currentUserId = userDetailVO.getUserCode();
	 * 
	 * GroupMasterBD groupMasterBD = new GroupMasterBD();
	 * ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
	 * .getGroupDetailsbyCurrentUser(currentUserId);
	 * 
	 * request.getSession(false).setAttribute("groupDetails",
	 * getGroupDetailsList);
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(), e);
	 * e.printStackTrace(); } JLogger.log(0, JDate.getTimeString(new Date()) +
	 * MessageConstants.END_POINT); logger.info(JDate.getTimeString(new Date())
	 * + " Control in GetDetailsAction : getDayReport Ending"); return
	 * mapping.findForward("dayReport");
	 * 
	 * }
	 */

	public ActionForward getLatecommers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLatecommers Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String currentUserId = userDetailVO.getUserCode();

			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);

			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLatecommers Ending");
		return mapping.findForward("latecommersreport");

	}

	public ActionForward mothlyLagendReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : mothlyLagendReport Starting");
		try {

			String username = (String) request.getSession(false).getAttribute(
					StringUtils.USERNAME);
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();

			request.getSession(false).setAttribute("LOCATIONLIST",
					new LocationMasterBD().getLocation(groupcode));
			/*
			 * GroupMasterVO groupData = new AttendanceReconcillationBD()
			 * .getGroup(username);
			 * request.getSession(false).setAttribute("Groups", groupData);
			 */
			ArrayList<AddDesignationVO> designationlist = new AddDesignationBD()
					.getDesignationDetails();
			request.getSession(false).setAttribute("designationList",
					designationlist);

		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : mothlyLagendReport Ending");
		return mapping.findForward(MessageConstants.MOONTHLY_LEGEND_REPORT);

	}

	public ActionForward getEarlyTimeReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getEarlyTimeReport Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String currentUserId = userDetailVO.getUserCode();

			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);

			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getEarlyTimeReport Ending");
		return mapping.findForward("earlytimeReport");

	}

	public ActionForward getLogReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLogReport Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			/*
			 * GroupMasterVO groupData = new AttendanceReconcillationBD()
			 * .getGroup(username);
			 * request.getSession(false).setAttribute("groupDetails",
			 * groupData);
			 */
			request.setAttribute("DEPARTMENT_LIST",
					new DepartmentMasterBD().getDepartmentRecordsBD());
			/*
			 * request.getSession(false).setAttribute("groupDetails", new
			 * GroupMasterBD().getGroupDetails());
			 * request.getSession(false).setAttribute("groupDetails", new
			 * GroupMasterBD().getGroupDetails());
			 */
			// request.getSession(false).setAttribute("managerEmployeeList", new
			// LogReportBD().getMangerInfo());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLogReport Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.ADMIN_LOG_REPORT;
		} else {
			forward = Director.DIRECTOR_LOG_REPORT;
		}

		return mapping.findForward(forward);

	}

	public ActionForward getworkingLessThen8hours(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getworkingLessThen8hourst Starting");

		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String currentUserId = userDetailVO.getUserCode();

			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);

			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction :getworkingLessThen8hourst Ending");
		return mapping.findForward("lessthan8hrs");

	}

	// written by seshu for display all deactive employees
	public ActionForward listofDeactiveEmployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: listofDeactiveEmployee : Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String groupid = userDetailVO.getGroupCode();

			String message = (String) request.getParameter("status");

			List<AllEmployeeVo> getEmployee = null;

			getEmployee = new AddEmployeeBD().getAllDeactiveEmployee(groupid);

			request.setAttribute("getAllEmployee", getEmployee);
			request.setAttribute("message", message);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: listofDeactiveEmployee : Ending");
		return mapping.findForward(ApplicationConstants.DEACTIVE_EMP_ALL);
	}

	public ActionForward getTodayReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getTodayReport : Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();
			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);
			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getTodayReport : Ending");
		return mapping.findForward("todayReport");

	}

	public ActionForward getDailyLogReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getDailyLogReport Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();
			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);
			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getDailyLogReport Ending");
		return mapping.findForward(ApplicationConstants.DAILY_LOG_REPORT);

	}

	public ActionForward getYearlyReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getYearlyReport Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String currentUserId = userDetailVO.getUserCode();

			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);

			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getYearlyReport Ending");
		return mapping.findForward("yearlyReport");

	}

	public ActionForward getLocationUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLocationUpdate Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();
			List<GroupMasterVO> getGroupDetailsList = new GroupMasterBD()
					.getGroupDetailsbyCurrentUser(currentUserId);
			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLocationUpdate Ending");
		return mapping.findForward("locationUpdateReport");

	}

	public ActionForward getGroupLogReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getGroupLogReport Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String currentUserId = userDetailVO.getUserCode();

			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);

			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getGroupLogReport Ending");
		return mapping.findForward("groupLogReport");

	}

	public ActionForward getIncorrectPunchReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getIncorrectPunchReport Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();
			List<GroupMasterVO> getGroupDetailsList = new GroupMasterBD()
					.getGroupDetailsbyCurrentUser(currentUserId);
			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getIncorrectPunchReport Ending");
		return mapping.findForward("incorrectPunchReport");

	}

	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getIncorrectPunchReport Starting");
		try {

			HttpSession ses = request.getSession(false);
			if (ses == null) {
				System.err.println("invalid session");
				return mapping.findForward("HOMEPAGE");
			}

			ses.invalidate();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getIncorrectPunchReport Ending");
		return mapping.findForward("HOMEPAGE");

	}

	public ActionForward getLastThreeAbsentReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLastThreeAbsentReport Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();
			List<GroupMasterVO> getGroupDetailsList = new GroupMasterBD()
					.getGroupDetailsbyCurrentUser(currentUserId);
			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLastThreeAbsentReport Ending");
		return mapping.findForward("lastThreeAbsentReport");

	}

	public ActionForward getRegistrationTimeReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getRegistrationTimeReport Starting");

		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String currentUserId = userDetailVO.getUserCode();

			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);

			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getRegistrationTimeReport Ending");
		return mapping.findForward("getRegistrationTime");

	}

	public ActionForward getManualAttendance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getManualAttendance Starting");

		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String currentUserId = userDetailVO.getUserCode();

			GroupMasterBD groupMasterBD = new GroupMasterBD();
			ArrayList<GroupMasterVO> getGroupDetailsList = groupMasterBD
					.getGroupDetailsbyCurrentUser(currentUserId);

			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getManualAttendance Ending");
		return mapping.findForward("getManualAttendance");

	}

	public ActionForward getMachineStatusReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getMachineStatusReport Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();
			List<GroupMasterVO> getGroupDetailsList = new GroupMasterBD()
					.getGroupDetailsbyCurrentUser(currentUserId);
			request.getSession(false).setAttribute("groupDetails",
					getGroupDetailsList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getMachineStatusReport Ending");
		return mapping.findForward("machineStatusReport");

	}

	// for teleindia project master
	public ActionForward getProjectMaster(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getProjectMaster Starting");
		String forward = null;
		String usertype = HelperClass.getCurrentUserIDType(request);
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userid = userDetailVO.getUserCode();

			ArrayList<ProjectMasterVo> pjt_list = new ProjectMasterDelegate()
					.getAllProjects(userid);

			request.setAttribute("PROJECTLIST", pjt_list);

			String status = request.getParameter("status");

			if (status != null) {

				if (MessageConstants.PROJECT_MGR_MAP.equalsIgnoreCase(status)) {

					request.setAttribute("errorMessage",
							MessageConstants.PROJECT_MGR_MAP);
				} else if (MessageConstants.PROJECT_DELETE_SUCCESS
						.equalsIgnoreCase(status)) {

					request.setAttribute("message",
							MessageConstants.PROJECT_DELETE_SUCCESS);
				} else {

					request.setAttribute("errorMessage",
							MessageConstants.PROJECT_DELETE_FAILED);
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "projectmaster";
		} else if (usertype.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {

			forward = ApplicationConstants.PROJECT_CREATION_BY_MANAGER;
		} else {
			forward = Director.DIRECTOR_PROJECT;
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getProjectMaster Ending");

		return mapping.findForward(forward);

	}

	/** Mritunjay TeleIndia Start */

	public ActionForward getEmployeePage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getEmployeePage Starting");
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userid = userDetailVO.getUserCode();
			request.getSession(false).setAttribute("designationDetails",
					new AddDesignationBD().getDesignationDetails());
			request.getSession(false).setAttribute("departmentDetails",
					new DepartmentMasterBD().getDepartmentRecordsBD());
			request.getSession(false).setAttribute("managerDetails",
					new ProjectManagerMappingBD().getManager());
			request.getSession().setAttribute("projectDetailsList",
					new ProjectMasterDelegate().getAllProjects(userid));

			String BioId = new EmployeeBD().getBioIdBD();
			if (BioId != null) {

				request.setAttribute("BioId", BioId);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getEmployeePage Ending");
		return mapping.findForward(Employee.EMPLOYEE);

	}

	public ActionForward getEmployeeAmendmentPage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getEmployeeAmendmentPage Starting");
		try {
			/*
			 * UserDetailVO userDetailVO = (UserDetailVO)
			 * request.getSession(false).getAttribute("UserDetails"); String
			 * currentUserId = userDetailVO.getUserCode(); List<GroupMasterVO>
			 * getGroupDetailsList = new
			 * GroupMasterBD().getGroupDetailsbyCurrentUser(currentUserId);
			 * request
			 * .getSession(false).setAttribute("groupDetails",getGroupDetailsList
			 * );
			 */

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userid = userDetailVO.getUserCode();
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
				+ " Control in GetDetailsAction : getEmployeeAmendmentPage Ending");
		return mapping.findForward(Employee.EMPLOYEE_AMENDMENT);

	}

	public ActionForward getAttendanceStatusDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAttendanceStatusDetails Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {
			List<AttendanceStatusTypeVO> attendancestatuslist = new AttendanceStatusTypeBD()
					.getAttendanceStatusDetails();
			request.setAttribute("attendancestatuslist", attendancestatuslist);

			String deletemeggage = request.getParameter("deletemeggage");
			request.setAttribute("deletemeggage", deletemeggage);

			String updateMessage = request.getParameter("updateMessage");
			request.setAttribute("updateMessage", updateMessage);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAttendanceStatusDetails Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.ADDTENDANCE_STATUS_TPYE_MESSAGE;
		} else {
			forward = Director.DIRECTOR_ATT_STATUS_TYPE;
		}

		return mapping.findForward(forward);
	}

	/** Mritunjay TeleIndia End */

	// for teleindia ATTENDANCE APPROVAL
	public ActionForward getAttendanceApproval(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())

		+ " Control in GetDetailsAction : getAttendanceApproval Starting");

		String userType = HelperClass.getCurrentUserIDType(request);

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();

			request.getSession(false).setAttribute(
					"emp_list",
					new AttendenceApprovelBD().getEmployees(currentUserId,
							userType));
			String status = request.getParameter("status");

			if (status != null) {

				if (status.equalsIgnoreCase("attendence updated success fully")) {

					request.setAttribute("message", status);
				} else {

					request.setAttribute("errorMessage", status);
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAttendanceApproval Ending");

		if (userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {

			return mapping.findForward("attendenceapprovel");

		} else {

			return mapping.findForward("Adminattendenceapprovel");
		}
	}

	// for teleindia ATTENDANCE APPROVAL by date
	public ActionForward getAttendanceApprovalByDate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAttendanceApprovalBy Starting");

		String userType = HelperClass.getCurrentUserIDType(request);

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();

			request.getSession(false).setAttribute(
					"emp_list",
					new AttendenceApprovelBD().getEmployees(currentUserId,
							userType));
			String status = request.getParameter("status");

			if (status != null) {
				if (status.trim().equalsIgnoreCase(
						"attendence updated success fully")) {

					request.setAttribute("message", status);
				} else {

					request.setAttribute("errorMessage", status);
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAttendanceApprovalBy Ending");

		if (userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)) {

			return mapping.findForward("admin_attendenceapprovel_by_date");

		} else {

			return mapping.findForward("attendenceapprovel_by_date");

		}

	}

	// for teleindia Timesheet report
	public ActionForward getTimeSheetReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getTimeSheetReport Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			ArrayList<DepartmentFilterVO> deptlist = new TimesheetReconciliationBD()
					.getAllDepartments();
			request.setAttribute("AllDepartments", deptlist);
			request.setAttribute("ACC_YEAR",
					new TimeSheetReportBD().getAccYear());

		} catch (Exception exception) {
			logger.error(exception);
			logger.error(exception.getMessage(), exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getTimeSheetReport Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "attendancetimesheetreport";
		} else {
			forward = Director.DIRECTOR_GET_TIMESHEETREPORT;
		}
		return mapping.findForward(forward);

	}

	public ActionForward getDayReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getTimeSheetReport Starting");
		try {
			request.setAttribute("MANAGER_LIST",
					new ManagerMasterBD().getAllManagersBD());
			request.setAttribute("DESIGNATION_LIST",
					new AddDesignationBD().getDesignationDetails());
			request.setAttribute("DEPARTMENT_LIST",
					new DepartmentMasterBD().getDepartmentRecordsBD());
			request.setAttribute("ACC_YEAR",
					new TimeSheetReportBD().getAccYear());

		} catch (Exception exception) {
			logger.error(exception);
			logger.error(exception.getMessage(), exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getTimeSheetReport Ending");

		return mapping.findForward(StringUtils.ADMIN_DAY_REPORT);

	}

	public ActionForward getAllEmployeePage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAllEmployeePage Starting");
		ArrayList<GetAllEmployeeVO> list = new ArrayList<GetAllEmployeeVO>();
		String forward = null;
		String usertype = HelperClass.getCurrentUserIDType(request);

		try {
			list = new GetAllEmployeeBD().getDetails();
			request.setAttribute("emplist", list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAllEmployeePage Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.GET_ALL_EMPLOYEES;
		} else {
			forward = Director.DIRECTOR_GET_ALL_EMPLOYEES;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getLeaveDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLeaveDetails Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			ArrayList<DepartmentFilterVO> deptlist = new TimesheetReconciliationBD()
					.getAllDepartments();
			request.setAttribute("AllDepartments", deptlist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLeaveDetails Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.LEAVE_DETAILS_HOME;
		} else {
			forward = Director.DIRECTOR_LEAVE_DETAILS;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getEmployeeDailyAllowance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getEmployeeDailyAllowance Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getEmployeeDailyAllowance Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.EMPLOYEE_DAILY_ALLOWANCE;
		} else {
			forward = Director.DIRECTOR_EMP_DAILY_ALLOW;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getEmployeeSalaryDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getEmployeeSalaryDetails Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			String empid = request.getParameter("empid");
			String empname = request.getParameter("empname");
			String empsalary = request.getParameter("empsal");
			String accountNo = request.getParameter("accountNo");

			request.setAttribute("EMPID", empid);
			request.setAttribute("EMPNAME", empname);
			request.setAttribute("EMPSALARY", empsalary);
			request.setAttribute("accountNo", accountNo);

			System.out.println("accountNo :::" + accountNo);

			request.setAttribute("EMPSTATUS", "ALLEMP");

			SalaryDetailsVo salaryDetailsVo = new EmployeeSalaryDetailsBD()
					.getSalaryDetails(empid);

			request.setAttribute("slarydetails", salaryDetailsVo);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getEmployeeSalaryDetails Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = Employee.EMPLOYEE_SALARY_DETAILS;
		} else {
			forward = Director.DIRECTOR_EMPLOYEE_SALARY_DETAILS;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getPayroll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getPayroll Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			List<DepartmentMasterVO> depRecords = new DepartmentMasterBD()
					.getDepartmentRecordsBD();

			request.setAttribute("departmentlist", depRecords);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getPayroll Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = EmployeePayroll.GET_PAYROLL;
		} else {
			forward = Director.DIRECTOR_GET_PAYROLL;
		}
		return mapping.findForward(forward);
	}

	public ActionForward projectCreationByManager(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : projectCreationByManager Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userid = userDetailVO.getUserCode();

			ArrayList<ProjectMasterVo> pjt_list = new ProjectMasterDelegate()
					.getAllProjects(userid);

			request.setAttribute("PROJECTLIST", pjt_list);

			String status = request.getParameter("status");

			if (status != null) {

				request.setAttribute("message", status);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: projectCreationByManager Ending");
		return mapping
				.findForward(ApplicationConstants.PROJECT_CREATION_BY_MANAGER);
	}

	public ActionForward getAdvanceSalaryRequest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAdvanceSalaryRequest Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		String userCode = HelperClass.getCurrentUserID(request);

		AdvanceSalaryRequestBD advanceSalaryRequestBD = new AdvanceSalaryRequestBD();
		List<AdvanceSalaryRequestVo> getAdvanceSalaryRequest = new ArrayList<AdvanceSalaryRequestVo>();
		String successMsg = null;

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			getAdvanceSalaryRequest = advanceSalaryRequestBD
					.getAdvanceSalaryRequest();
			request.setAttribute("salaryRequestDetails",
					getAdvanceSalaryRequest);
			successMsg = request.getParameter("successMessage");

			forward = StringUtils.GET_ADVANCE_SALARY_APPROVAL;
		} else {
			getAdvanceSalaryRequest = advanceSalaryRequestBD
					.getAdvanceSalaryRequestByDirector(userCode);
			request.setAttribute("salaryRequestDetails",
					getAdvanceSalaryRequest);
			successMsg = request.getParameter("successMessage");

			if (successMsg != null && successMsg.equals("2")) {
				request.setAttribute("success",
						"Advance Salary Approved Successfully");

			}

			if (successMsg != null && successMsg.equals("1")) {
				request.setAttribute("error",
						"Advance Salary Approved Successfully,Mail Not Sent");

			}

			if (successMsg != null && successMsg.equals("holdSuccess")) {
				request.setAttribute("success",
						"Advance Salary Hold Successfully");

			}

			if (successMsg != null && successMsg.equals("holdTryAgain")) {
				request.setAttribute("error", "Try Again");

			}
			if (successMsg != null && successMsg.equals("rejectSuccess")) {
				request.setAttribute("success",
						"Advance Salary Rejected Successfully");

			}

			if (successMsg != null
					&& successMsg.equals("rejectSuccessMailNotSend")) {
				request.setAttribute("error",
						"Advance Salary Rejected Successfully,Mail Not Sent");

			}
			if (successMsg != null && successMsg.equals("rejectTryAgain")) {
				request.setAttribute("error", "Try Again");

			}
			forward = Director.DIRECTOR_ADV_SAL_APPROVAL;
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getAdvanceSalaryRequest Ending");
		return mapping.findForward(forward);
	}

	public ActionForward employeeWeekofSetting(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : employeeWeekofSetting Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: employeeWeekofSetting Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = StringUtils.WEEK_OFFSETTING;
		} else {
			forward = Director.DIRECTOR_WEEK_OFFSETTING;
		}

		return mapping.findForward(forward);
	}

	public ActionForward getClientDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getClientDetails Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {
			ClientMasterBD clientMasterBD = new ClientMasterBD();

			ArrayList<ClientMasterPojo> clientDetails = clientMasterBD
					.getClientDetails();

			request.setAttribute("clientDetails", clientDetails);
			String status = request.getParameter("status");
			if (status != null) {
				request.setAttribute("message", status);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getClientDetails Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = StringUtils.CLIENT_MASTER;
		} else {
			forward = Director.DIRECTOR_CLIENT_MASTER;
		}

		return mapping.findForward(forward);
	}

	public ActionForward getDailyAllowancesForApprove(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getDailyAllowancesForApprove Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			String status = request.getParameter("status");

			if (status != null) {

				if (status.equalsIgnoreCase("true")) {

					request.setAttribute("errorMessage",
							"Allowances approved Successfully,Mail not sent");

				} else if (status.equalsIgnoreCase(MessageConstants.MAIL_SENT)) {

					request.setAttribute("successMessage",
							"Allowances Approved Successfully");
				} else {

					request.setAttribute("errorMessage",
							"Allowances not approved,Try again");
				}
			}

		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getDailyAllowancesForApprove Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = StringUtils.GET_DAILY_ALLOWANCES;
		} else {
			forward = Director.DIRECTOR_GET_DAILY_ALLOWANCES;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getUsermanagement(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getUsermanagement Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		request.setAttribute("DESIGNATIONLIST",
				new AddDesignationBD().getDesignationDetails());

		request.setAttribute("RolesList", new RoleMasterBD().getAllNRoles());

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getUsermanagement Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.USER_MANGEMENT;
		} else {
			forward = Director.DIRECTOR_USER_MANGEMENT;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getTravelBookingDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getTravelBookingDetails Starting");

		String userType = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			String status = request.getParameter("status");

			if (status != null) {

				if (status.equalsIgnoreCase("true")) {

					request.setAttribute("errorMessage",
							"TravelBooking Details Approved successfully,Mail not sent");

				} else if (status.equalsIgnoreCase(MessageConstants.MAIL_SENT)) {

					request.setAttribute("successMessage",
							"TravelBooking Details Approved successfully");

				} else {

					request.setAttribute("errorMessage",
							"TravelBooking Details not Approved,Try again");
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getTravelBookingDetails Ending");

		if (userType.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.GET_TRAVEL_BOOKING;
		} else {

			System.out.println("userType " + userType);
			forward = Director.DIRECTOR_TRAVEL_BOOKING;
		}
		return mapping.findForward(forward);
	}

	public synchronized ActionForward getDeleteEmployeeAudit(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getDeleteEmployeeAudit Starting");

		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userCode = userDetailVO.getUserCode();
			List<EmployeeDeleteAuditVo> getDeleteEmployeesAudit = new ArrayList<EmployeeDeleteAuditVo>();
			getDeleteEmployeesAudit = new EmployeeBD()
					.getDeleteEmployeeAudit(userCode);

			request.setAttribute("deleteEmployeeAuditList",
					getDeleteEmployeesAudit);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getDeleteEmployeeAudit Ending");

		return mapping.findForward(ApplicationConstants.DELETE_EMPLOYEE_AUDIT);
	}

	public synchronized ActionForward advanceSalaryConsolidateReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: advanceSalaryConsolidateReport Starting");

		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userCode = userDetailVO.getUserCode();
			List<EmployeeDeleteAuditVo> getDeleteEmployeesAudit = new ArrayList<EmployeeDeleteAuditVo>();
			getDeleteEmployeesAudit = new EmployeeBD()
					.getDeleteEmployeeAudit(userCode);

			request.setAttribute("deleteEmployeeAuditList",
					getDeleteEmployeesAudit);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: advanceSalaryConsolidateReport Ending");

		return mapping
				.findForward(ApplicationConstants.ADVANCE_SALARY_CONSOLIDATE_REPORT);
	}

	public synchronized ActionForward getAdvanceSalaryDetailsFromDashBoard(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getAdvanceSalaryDetailsFromDashBoard Starting");

		String userType = null;
		String forward = null;
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();

			userType = HelperClass.getCurrentUserIDType(request);

			ArrayList<getAccYearVO> arr = new ArrayList<getAccYearVO>();
			arr = new LeaveBankBD().getYear();
			request.getSession(false).setAttribute("accyear", arr);

			if (userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {

				request.setAttribute("hemiid", request.getParameter("empId"));
				request.getSession(false).setAttribute(
						"emp_list",
						new AttendenceApprovelBD().getEmployees(currentUserId,
								userType));

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getAdvanceSalaryDetailsFromDashBoard Ending");

		if (userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {

			forward = ApplicationConstants.EMPLOYEE_ADVANCE_SALARY_DETAILS;
		} else {

			forward = ApplicationConstants.EMPLOYEEDASHBOARD_ADVANCE_SALARY_DETAILS;
		}
		return mapping.findForward(forward);
	}

	public ActionForward moreExpensesDeatailsHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : moreExpensesDeatailsHome: Starting");

		ArrayList<getAccYearVO> arr = new ArrayList<getAccYearVO>();
		arr = new LeaveBankBD().getYear();
		request.getSession(false).setAttribute("accyear", arr);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction :moreExpensesDeatailsHome: Ending");

		return mapping.findForward(ApplicationConstants.EXPENSES_VIEW);
	}

	public ActionForward getMoreAttendanceDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getMoreAttendanceDetails: Starting");

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction :getMoreAttendanceDetails: Ending");

		return mapping.findForward(MessageConstants.MOREATTENDANCE);
	}

	public ActionForward moreTravelAllowanceDeatailsHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : moreTravelAllowanceDeatailsHome: Starting");

		String userType = null;
		String forward = null;
		try {

			userType = HelperClass.getCurrentUserIDType(request);

			if (userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {

				request.setAttribute("empId", request.getParameter("empId"));
				request.setAttribute("goBackToManager", "Manager");
				String empname = (String) request.getSession().getAttribute(
						"DashboardEmployeeName");
				request.setAttribute("empName", empname);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction :moreTravelAllowanceDeatailsHome: Ending");

		if (userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {

			forward = MessageConstants.MORETRAVELALLOWANCE_IN_MANAGER;
		} else {

			forward = MessageConstants.MORETRAVELALLOWANCE;
		}
		return mapping.findForward(forward);

	}

	public ActionForward getTodayGraffReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLogReport Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getLogReport Ending");

		return mapping.findForward(Director.TODAY_GRAFF_REPORT);

	}

	public ActionForward orgStructure(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : orgStructure: Starting");

		try {

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction :orgStructure: Ending");

		return mapping.findForward("orgSubModules");

	}

	public ActionForward getProductivityReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getProductivityReport Starting");
	//	String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			System.out.println("Action is working");
			ArrayList<DepartmentFilterVO> deptlist = new TimesheetReconciliationBD()
					.getAllDepartments();
			System.out.println(deptlist);
			request.getSession().setAttribute("AllDepartments", deptlist);
			request.getSession().setAttribute("ACC_YEAR",
					new TimeSheetReportBD().getAccYear());

		} catch (Exception exception) {
			logger.error(exception);
			logger.error(exception.getMessage(), exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getProductivityReport Ending");

		return mapping.findForward(Director.getProductivityReporttimesheetreport);

	}

	 public ActionForward menu(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in GetDetailsAction : menu: Starting");
			 
			
			try {
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
			
			
			JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in GetDetailsAction :menu: Ending");
				
				
				return mapping.findForward("menu");
			
		}
	
}