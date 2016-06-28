/**
 * 
 */
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

import com.centris.POJO.AttendenceApprovelPojo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.VO.CurrentSearchVo;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AttendenceApprovelBD;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.exception.AITrackerException;
import com.centris.form.AttendenceApprovelForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author seshuma
 * 
 */
public class AttendenceApprovelAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(AttendenceApprovelAction.class);

	// Get employee attendence
	public ActionForward getEmployeeAttendence(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : getEmployeeAttendence Starting");
		try {

			AttendenceApprovelForm att_fprm = (AttendenceApprovelForm) form;

			String monthfullname = HelperClass.getMonthFullName(att_fprm
					.getMonth());
			String employeename = new AttendenceApprovelBD()
					.getSingleEmployee(att_fprm.getEmplyeeid());

			ArrayList<CurrentSearchVo> current_search_list = new ArrayList<CurrentSearchVo>();
			CurrentSearchVo cvo = new CurrentSearchVo();

			cvo.setEmployeeid(att_fprm.getEmplyeeid());
			cvo.setMonth(monthfullname);
			cvo.setYear(att_fprm.getYear());
			cvo.setEmployeename(employeename);
			cvo.setMonthnumber(att_fprm.getMonth());

			current_search_list.add(cvo);

			request.setAttribute("current_search_list", current_search_list);

			ArrayList<AttendenceApprovelVo> attendence_list = new AttendenceApprovelBD()
					.getEmployeeAttendance(att_fprm);

			if (attendence_list.size() != 0) {
				request.setAttribute("attendence_list", attendence_list);
			} else {

				request.setAttribute("Nothing", "Nothing found to display");
			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : getEmployeeAttendence Ending");

		return mapping.findForward("attendenceapprovel");

	}

	// Get attendence status type
	public ActionForward getAttendanceStatusType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : getAttendanceStatusType Starting");
		try {

			ArrayList<AttendenceApprovelVo> att_status_typ_list = new AttendenceApprovelBD()
					.getAttendanceStatusTypeBD();

			JSONObject object = new JSONObject();
			object.put("ATT_TYPE_LIST", att_status_typ_list);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : getAttendanceStatusType Ending");

		return null;

	}

	// Get project
	public ActionForward getProject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : getProject Starting");
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String userid =userDetailVO.getUserCode();
			ArrayList<ProjectMasterVo> project_list = new ProjectMasterDelegate()
					.getAllProjects(userid);

			JSONObject object = new JSONObject();
			object.put("project_list", project_list);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : getProject Ending");

		return null;

	}

	// Get Attendance status
	public ActionForward getAttendanceStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : attendanceStatus Starting");
		try {

			ArrayList<AttendenceApprovelVo> att_status = new AttendenceApprovelBD()
					.getAttendanceStatus();

			JSONObject object = new JSONObject();
			object.put("att_status", att_status);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : attendanceStatus Ending");

		return null;

	}

	// updateEmpAttendance
	public ActionForward updateEmpAttendance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : updateEmpAttendance Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String empid = request.getParameter("empid");
			String attendencedate = request.getParameter("attendencedate");
			String attendence_status = request
					.getParameter("attendence_status");
			String status_type = request.getParameter("status_type");
			String location = request.getParameter("location");
			String project_name = request.getParameter("project_name");
			String inTime = request.getParameter("inTime");
			String outTime = request.getParameter("outTime");

			AttendenceApprovelPojo att_pojo = new AttendenceApprovelPojo();

			att_pojo.setEmployeeid(empid);
			att_pojo.setAttendencedate(HelperClass
					.convertUIToDatabase(attendencedate));
			att_pojo.setAttendancestatus(attendence_status);
			att_pojo.setAttendancetype(status_type);
			att_pojo.setLocation(location);
			att_pojo.setProjectname(project_name);
			att_pojo.setIntime(inTime);
			att_pojo.setOuttime(outTime);
			att_pojo.setUsername(HelperClass.getCurrentUser(request));
			att_pojo.setUsercode(HelperClass.getCurrentUserID(request));
			String status = new AttendenceApprovelBD()
					.updateEmpAttendance(att_pojo);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : updateEmpAttendance Ending");

		return null;

	}

	// update all employees attendance
	public ActionForward updateAllEmpAttendance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : updateAllEmpAttendance Starting");
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

			String status = new AttendenceApprovelBD()
					.updateAllEmpAttendance(att_pojo);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : updateAllEmpAttendance Ending");

		return null;

	}

	// Get employee specific attendance attendence
	public ActionForward getEmployeeSpecificAttendence(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : getEmployeeSpecificAttendence Starting");
		try {

			String empdetails = request.getParameter("empdetails");
			String selectattendance = request.getParameter("selectattendance");

			String empid = empdetails.split(",")[0];

			int totaldays_in_month = HelperClass.getDaysByMonthAndYear(
					Integer.parseInt(empdetails.split(",")[1]),
					Integer.parseInt(empdetails.split(",")[2]));

			String start_date = empdetails.split(",")[2] + "-"
					+ empdetails.split(",")[1] + "-" + "01";
			String end_date = empdetails.split(",")[2] + "-"
					+ empdetails.split(",")[1] + "-" + totaldays_in_month;

			String monthfullname = HelperClass.getMonthFullName(empdetails
					.split(",")[1]);
			String employeename = new AttendenceApprovelBD()
					.getSingleEmployee(empid);

			ArrayList<CurrentSearchVo> current_search_list = new ArrayList<CurrentSearchVo>();
			CurrentSearchVo cvo = new CurrentSearchVo();

			cvo.setEmployeeid(empid);
			cvo.setMonth(monthfullname);
			cvo.setYear(empdetails.split(",")[2]);
			cvo.setEmployeename(employeename);
			cvo.setMonthnumber(empdetails.split(",")[1]);
			cvo.setStatus(selectattendance);

			current_search_list.add(cvo);

			request.setAttribute("current_search_list", current_search_list);

			AttendenceApprovelPojo att_pojo = new AttendenceApprovelPojo();

			att_pojo.setEmployeeid(empid);
			att_pojo.setStartdate(start_date);
			att_pojo.setEnddate(end_date);
			if ("all".equalsIgnoreCase(selectattendance)) {
				att_pojo.setAttendancestatus("%%");
			} else {

				att_pojo.setAttendancestatus(selectattendance);
			}

			ArrayList<AttendenceApprovelVo> attendence_list = new AttendenceApprovelBD()
					.getEmployeeSpecificAttendence(att_pojo);

			request.setAttribute("attendence_list", attendence_list);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelAction : getEmployeeSpecificAttendence Ending");

		return mapping.findForward("attendenceapprovel");

	}

}
