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

import com.centris.DAO.DAOIMPL.HolidayMasterDAOImpl;
import com.centris.POJO.HolidayMasterPojo;
import com.centris.VO.HolidayMasterVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.HolidayMasterBD;
import com.centris.form.HolidayMasterForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author seshuma
 * 
 */
public class HolidayMasterAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(HolidayMasterAction.class);

	// To get department and year
	public synchronized ActionForward getDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction : getDetails : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			String result = request.getParameter("status");
			String updateresult = request.getParameter("updatestatus");
			String deleteresult=request.getParameter("deleteMessage");
			
			if (result != null && result.equals("success")) {
				request.setAttribute("message", "Holiday Created Successfully");
			}
			if (result != null && result.equals("fail")) {
				request.setAttribute("errorMessage", "Holiday Creation Failed,Please try again");
			}

			if (updateresult != null && updateresult.equals("success")) {
				request.setAttribute("message", "Holiday Updated Successfully");
			}

			if (updateresult != null && updateresult.equals("fail")) {
				request.setAttribute("errorMessage", "Holiday Updation Failed,Please try again");
			}

			if(deleteresult!=null && deleteresult.equalsIgnoreCase("true")){
				request.setAttribute("message", "Holiday Deleted Successfully");
			}
			
			
			if(deleteresult!=null && deleteresult.equalsIgnoreCase("false")){
				request.setAttribute("errorMessage", "Holiday not Deleted,Please try again ");
			}	
			
			
			request.getSession(false).setAttribute("clientList",
					new HolidayMasterDAOImpl().getClientDetails());

			request.setAttribute("yearlist", new HolidayMasterBD().getYear());

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction: getDetails : Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = ApplicationConstants.HOLIDAY_MASTER_HOME;
		} else {
			forward = Director.DIRECTOR_HOLIDAY_MASTER_HOME;
		}

		return mapping.findForward(forward);

	}

	// To get department and year for group holiday
	public synchronized ActionForward AddGroupHoliday(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction : AddGroupHoliday : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			/*
			 * request.getSession(false).setAttribute("departmentlist", new
			 * DepartmentMasterBD().getDepartmentRecordsBD());
			 */
			request.setAttribute("yearlist", new HolidayMasterBD().getYear());

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :AddGroupHoliday: Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "addgroup";
		} else {
			forward = Director.DIRECTOR_HOLIDAY_MASTER_GROUP;
		}

		return mapping.findForward(forward);

	}

	// To validate date unique or not
	public ActionForward dateValidate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :dateValidate: Starting");

		try {
			String dateval = request.getParameter("date");
		String clientCode=request.getParameter("clientCode");

			String result = new HolidayMasterBD().dateValidate(dateval,clientCode);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("dateVal", result);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :dateValidate: Ending");

		return null;
	}

	// add single holiday
	public ActionForward addHolidayDetail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :addHolidayDetail: Starting");
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String usercode = userDetailVO.getUserCode();
			String clientCode = request.getParameter("clientCode");

			String date = request.getParameter("date");
			String weekday = request.getParameter("weekday");
			String holiday = request.getParameter("holiday");
		
			String year = request.getParameter("year");

			HolidayMasterPojo hpojo = new HolidayMasterPojo();
			hpojo.setCreateddate(HelperClass.getCurrentTimestamp());
			hpojo.setDate(date);
			
			hpojo.setHoliday(holiday);
			hpojo.setWeekday(weekday);
			hpojo.setYear(year);
			hpojo.setCreatedby(usercode);
			hpojo.setClientCode(clientCode);

			String result = new HolidayMasterBD().addSingleHoliday(hpojo);

			
			if (!result.equals("success")) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dateVal", result);
				response.getWriter().print(jsonObject);
			} else {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dateVal", result);
				response.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :addHolidayDetail: Ending");

		return null;

	}

	// Get all holidays for display
	public synchronized ActionForward getHolidayMasterDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :getHolidayMasterDetails: Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {
			String holidayyear = request.getParameter("holidayyearval");
			String clientCode = request.getParameter("clientCode");
			ArrayList<HolidayMasterVO> holidayMasterVOList = new HolidayMasterBD()
					.getHolidayList(holidayyear, clientCode);
			request.setAttribute("holidayMasterVOList", holidayMasterVOList);
		/*	request.getSession(false).setAttribute("departmentlist",
					new DepartmentMasterBD().getDepartmentRecordsBD());*/
			request.setAttribute("yearlist", new HolidayMasterBD().getYear());

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :getHolidayMasterDetails: Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = ApplicationConstants.HOLIDAY_MASTER_HOME;
		} else {
			forward = Director.DIRECTOR_HOLIDAY_MASTER_HOME;
		}

		return mapping.findForward(forward);

	}

	// To check douplicate array of dates
	public ActionForward getDistinctHolidayList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :getDistinctHolidayList: Starting");

		try {
			
			String clientcode=request.getParameter("ClientCode");
			String year=request.getParameter("Year");
			
			ArrayList<HolidayMasterVO> holidayDateList = new HolidayMasterBD().getDistinctHolidayList(clientcode,year);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("jsonResponse", holidayDateList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :getDistinctHolidayList: Ending");

		return null;

	}

	// Delete Holiday
	public ActionForward deleteHolidayData(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :deleteHolidayData: Starting");

		
		try {
			String holidaydate = request.getParameter("holidaydate");
			String clientcode =request.getParameter("clientcode");
			
			Boolean result = new HolidayMasterBD().deleteSingleHoliday(holidaydate,clientcode);
			String message = null;
			if (result) {

				message = "true";

			} else {

				message = "false";

			}

			JSONObject object = new JSONObject();
			object.put("message", message);
			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :deleteHolidayData: Ending");

		return null;

	}

	// Get edit holiday
	public ActionForward editHolidayMaster(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :editHolidayMaster: Starting");

		String holidaydate = request.getParameter("holidaydate");
		String clientCode=request.getParameter("clientCode");
	

		List<HolidayMasterVO> holidayMasterVOList = new HolidayMasterBD()
				.editHolidayDetail(holidaydate,clientCode);
		JSONObject jsonObject = new JSONObject(holidayMasterVOList);
		jsonObject.accumulate("holidayMasterVOList", holidayMasterVOList);
		response.getWriter().print(jsonObject);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :editHolidayMaster: Ending");

		return null;

	}

	// Update Holiday
	public ActionForward updateHoliday(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :updateHoliday: Starting");

		try {

			String weekday = request.getParameter("weekday");

			String date = request.getParameter("date");
			String holiday = request.getParameter("holiday");

			String clientCodeupdate = request.getParameter("clientCodeUpdate");
			
			String clientcode=request.getParameter("clienthidden");

			HolidayMasterPojo hpojo = new HolidayMasterPojo();

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String usercode = userDetailVO.getUserCode();

			hpojo.setModifiedby(usercode);
			hpojo.setModifieddate(HelperClass.getCurrentTimestamp());
			hpojo.setDate(date);
			hpojo.setWeekday(weekday);
			hpojo.setHoliday(holiday);
			hpojo.setClientCode(clientCodeupdate);
			hpojo.setHiddenclient(clientcode);
			/* hpojo.setDepartment(deptid); */

			String result = new HolidayMasterBD().updateHoliday(hpojo);
			JSONObject object = new JSONObject();
			object.put("success", result);
			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :updateHoliday: Ending");

		return null;
	}

	// To add group of holidays
	public synchronized ActionForward addgroupHoliday(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :addgroupHoliday: Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		String result = null;
		try {

			HolidayMasterForm holidayMasterForm = (HolidayMasterForm) form;
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String usercode = userDetailVO.getUserCode();

			result = new HolidayMasterBD().addHoliday(holidayMasterForm,
					usercode);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		
		if (result.equalsIgnoreCase("success")) {
			String succ = " Holiday Created Successfully";
			request.setAttribute("message", succ);
		
			request.setAttribute("yearlist", new HolidayMasterBD().getYear());

			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in HolidayMasterAction :addgroupHoliday: Ending");

			if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
				forward = ApplicationConstants.HOLIDAY_MASTER_HOME;
			} else {
				forward = Director.DIRECTOR_HOLIDAY_MASTER_HOME;
			}

			return mapping.findForward(forward);

		} else {

			String succ = "Holiday Creation Failed,Please Try Again";

			request.setAttribute("errorMessage", succ);

			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in HolidayMasterAction :addgroupHoliday: Ending");

			if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
				forward = ApplicationConstants.ADD_GROUP;
			} else {
				forward = Director.DIRECTOR_HOLIDAY_MASTER_GROUP;
			}

			return mapping.findForward(forward);

		}
	}
	
	
	
	public ActionForward getAcadamicYear(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :getAcadamicYear: Starting");

		try {
			
			String acadamicyear=request.getParameter("yearid");
			
			String result = new HolidayMasterBD().getAcadamicYear(acadamicyear);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("acadamicyear",result);
			response.getWriter().print(jsonObject);
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterAction :getAcadamicYear: Ending");

		return null;

	}

	
	
}