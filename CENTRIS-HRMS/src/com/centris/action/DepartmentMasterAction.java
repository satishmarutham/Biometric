package com.centris.action;

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

import com.centris.POJO.DepartmentMasterPojo;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.EmpLocationVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.form.DepartmentMasterForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class DepartmentMasterAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(DepartmentMasterAction.class);

	public synchronized ActionForward getDepRecords(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction : addDesignation : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();

			DepartmentMasterBD depBd = new DepartmentMasterBD();
			List<DepartmentMasterVO> depRecords = depBd
					.getDepartmentRecordsBD();

			request.setAttribute("depRecords", depRecords);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction : getDepRecords : Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.getDepForward;
		} else {
			forward = Director.DIRECTOR_DEP_MASTER;
		}
		return mapping.findForward(forward);

	}

	public synchronized ActionForward deleteDepartment(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction: deleteDepartment : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			DepartmentMasterForm depForm = (DepartmentMasterForm) form;
			String depid = depForm.getDepId();
			EmpLocationVO empLocationVO = new EmpLocationVO();
			String emploc = empLocationVO.getLocation();
			DepartmentMasterBD depBd = new DepartmentMasterBD();
			String status = depBd.deleteDepartmentBD(depid, emploc);

			request.setAttribute("status", status);
			List<DepartmentMasterVO> depRecords = depBd
					.getDepartmentRecordsBD();

			request.setAttribute("depRecords", depRecords);
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction : deleteDepartment : Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.deleteDepForward;
		} else {
			forward = Director.DIRECTOR_DEP_MASTER;
		}
		return mapping.findForward(forward);
	}

	public synchronized ActionForward addDepartment(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction : addDepartment : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {
			DepartmentMasterBD depBd = new DepartmentMasterBD();

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String createdby = userDetailVO.getUserCode();

			DepartmentMasterForm depForm = (DepartmentMasterForm) form;
			String status = depBd.addDepartmentBD(depForm, createdby);
			request.setAttribute("status", status);

			List<DepartmentMasterVO> depRecords = depBd
					.getDepartmentRecordsBD();

			request.setAttribute("depRecords", depRecords);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction : addDepartment : Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.insertDepForward;
		} else {
			forward = Director.DIRECTOR_DEP_MASTER;
		}
		return mapping.findForward(forward);
	}

	public synchronized ActionForward updateDepartment(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction: updateDepartment : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String createdby = userDetailVO.getUserCode();

			DepartmentMasterBD depBd = new DepartmentMasterBD();

			DepartmentMasterForm depForm = (DepartmentMasterForm) form;

			String id = request.getParameter("depId");

			DepartmentMasterPojo dpojo = new DepartmentMasterPojo();

			dpojo.setModifiedby(createdby);
			dpojo.setDeptid(id);
			dpojo.setDeptname(depForm.getDepName());
			dpojo.setDeptdes(depForm.getDesc());
			dpojo.setHrManagerMail(depForm.getHrManagerMail());
			dpojo.setLocManagerMail(depForm.getLocManagerMail());
			dpojo.setOnsiteManagerMail(depForm.getOnsiteManagerMail());
			dpojo.setModifieddate(HelperClass.getCurrentTimestamp());

			String status = depBd.updateDepartmentBD(dpojo);

			request.setAttribute("status", status);

			List<DepartmentMasterVO> depRecords = depBd
					.getDepartmentRecordsBD();
			request.setAttribute("depRecords", depRecords);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction :  updateDepartment : Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.insertDepForward;
		} else {
			forward = Director.DIRECTOR_DEP_MASTER;
		}
		return mapping.findForward(forward);
	}

	public ActionForward validateDeptName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction: validateDeptName : Starting");
		try {
			String id = (String) request.getParameter("deptid");
			String name = (String) request.getParameter("deptname");

			boolean status = new DepartmentMasterBD()
					.validateDeptName(name, id);

			JSONObject object = new JSONObject();

			object.put("status", status);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterAction : validateDeptName : Ending");
		return null;
	}
}