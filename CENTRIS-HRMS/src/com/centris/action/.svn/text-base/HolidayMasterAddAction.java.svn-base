package com.centris.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.centris.DAO.DAOIMPL.HolidayMasterDAOImpl;
import com.centris.VO.UserDetailVO;
import com.centris.form.HolidayMasterForm;

public class HolidayMasterAddAction extends Action {

	public synchronized ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result=null;
		try{
		HttpSession hsession = request.getSession(false);
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String username=userDetailVO.getUserCode();
		HolidayMasterForm holidayMasterForm = (HolidayMasterForm) form;
		String[] date = holidayMasterForm.getDate();
		String[] weekday = holidayMasterForm.getWeekday();
		String[] holiday = holidayMasterForm.getHoliday();
		/*String department = holidayMasterForm.getDepartment();*/
		String year = holidayMasterForm.getYear();

		HolidayMasterDAOImpl holidayMasterDAOImpl = new HolidayMasterDAOImpl();
		 result = holidayMasterDAOImpl.addHolidayDaoImpl(
				holidayMasterForm, username);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (result == "success") {
			String succ = " Holiday  Successfully Add ";
			request.setAttribute("RESULT", succ);

			return mapping.findForward("success");
		} else {
			String succ = "Holiday Not Add ";

			request.setAttribute("RESULT", succ);

			return mapping.findForward("success");
		}
	}
}