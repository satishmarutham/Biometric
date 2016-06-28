package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;
import com.centris.VO.EmpLocationVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.UserDetailVO;
import com.centris.VO.WeekOffVO;
import com.centris.delegate.WeekOffMasterBD;
import com.centris.form.WeekOffForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class WeekOffAction extends DispatchAction {

	private static final Logger logger = Logger.getLogger(WeekOffAction.class);

	public synchronized ActionForward Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffAction : Update Method Starting");
		try {
			WeekOffForm weekoffform = (WeekOffForm) form;
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String usercode=userDetailVO.getUserCode();

			EmployeeVO empWeekOff = new EmployeeVO();
			int sunday = 0;
			int monday = 0;
			int tuesday = 0;
			int wednesday = 0;
			int thursday = 0;
			int friday = 0;
			int saturday = 0;

			empWeekOff.setEmpid(weekoffform.getEmpid());

			if (weekoffform.getSunday().trim().equalsIgnoreCase("1"))
				sunday = 1;
			if (weekoffform.getMonday().trim().equalsIgnoreCase("1"))
				monday = 1;
			if (weekoffform.getTuesday().trim().equalsIgnoreCase("1"))
				tuesday = 1;
			if (weekoffform.getWednesday().trim().equalsIgnoreCase("1"))
				wednesday = 1;
			if (weekoffform.getThursday().trim().equalsIgnoreCase("1"))
				thursday = 1;
			if (weekoffform.getFriday().trim().equalsIgnoreCase("1"))
				friday = 1;
			if (weekoffform.getSaturday().trim().equalsIgnoreCase("1"))
				saturday = 1;

			empWeekOff.setSunday(sunday);
			empWeekOff.setMonday(monday);
			empWeekOff.setTuesday(tuesday);
			empWeekOff.setWednesday(wednesday);
			empWeekOff.setThursday(thursday);
			empWeekOff.setFriday(friday);
			empWeekOff.setSaturday(saturday);
			empWeekOff.setEmpid(weekoffform.getEmpid());
			empWeekOff.setUsercode(usercode);

			String msg = new WeekOffMasterBD().updateEmployeeWeekOffs(empWeekOff);
			request.setAttribute("message", msg);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffAction : Update Method Ending");
		return mapping.findForward("showWeekOff");
	}

	public  ActionForward getEmployeeNames(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffAction : Get All Employee Names Starting");
		try {
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String object = (String) e.nextElement();
			}
			String search = request.getParameter("name_startsWith").toString();
			String max = request.getParameter("maxRows").toString();
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String groupcode=userDetailVO.getGroupCode();
			

			EmpLocationVO empLocationVO = new EmpLocationVO();
			/*
			 * if (request.getSession(false).getAttribute(StringUtils.USER_ROLE)
			 * != null) { empLocationVO.setUserRole(request.getSession(false)
			 * .getAttribute(StringUtils.USER_ROLE).toString());
			 * empLocationVO.setLocation(request.getSession(false)
			 * .getAttribute(StringUtils.USER_LOCATION).toString()); } if
			 * (empLocationVO.getUserRole() != null &&
			 * empLocationVO.getUserRole().equals("ROL1")) {
			 * 
			 * String location = request.getParameter("Location"); if (location
			 * != null && location.indexOf(",") != -1) { String[] location_split
			 * = location.split(",");
			 * empLocationVO.setLocation(location_split[0]); } else if (location
			 * == null) { empLocationVO.setLocation("%%"); } else {
			 * 
			 * empLocationVO.setLocation(location); }
			 * 
			 * }
			 */
			if (empLocationVO.getUserRole() != null
					&& empLocationVO.getUserRole().equals("ROL1")) {

				String location = request.getParameter("Location");
				if (location != null && location.indexOf(",") != -1) {
					String[] location_split = location.split(",");
					empLocationVO.setLocation(location_split[0]);
				} else if (location == null) {
					empLocationVO.setLocation("%%");
				} else {

					empLocationVO.setLocation("LOC1");
				}

			}
			empLocationVO.setUserRole("LOC1");
			empLocationVO.setSearch(search);
			empLocationVO.setMax(max);
			empLocationVO.setGroup(groupcode);
			ArrayList<EmployeeVO> list = new WeekOffMasterBD()
					.getAllEmployeesDetails(empLocationVO);

			JSONObject jo = new JSONObject();

			jo.accumulate("list1", list);

			response.getWriter().print(jo);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffAction : Get All Employee Names Ending");
		return null;
	}

	public ActionForward getEmployeeWeekOffs(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffAction : Get Employee Week Off Details Starting");
		try {
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String object = (String) e.nextElement();
			}

			String empid = request.getParameter("empid").toString();
			WeekOffVO vo = new WeekOffMasterBD()
					.getEmployeeWeekOffsDetails(empid);

			JSONObject jo = new JSONObject();
			jo.accumulate("empid", vo.getEmpid());
			jo.accumulate("sun", vo.getSunday());
			jo.accumulate("mon", vo.getMonday());
			jo.accumulate("tue", vo.getTuesday());
			jo.accumulate("wed", vo.getWednesday());
			jo.accumulate("thu", vo.getThursday());
			jo.accumulate("fri", vo.getFriday());
			jo.accumulate("sat", vo.getSaturday());

			response.getWriter().print(jo);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffAction : Get Employee Week Off Details Ending");
		return null;
	}
}