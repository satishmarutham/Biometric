package com.centris.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.VO.AuditReportEmpVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.ShiftVO;
import com.centris.VO.TimeSheetReportVO;
import com.centris.delegate.TimeSheetReportAuditBD;
import com.centris.form.TimeSheetReportForm;
import com.centris.util.StringUtils;

public class TimeSheetReportAuditAction extends DispatchAction 
{


	public synchronized ActionForward timeSheetReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	    List<ShiftVO> shiftlist =new TimeSheetReportAuditBD().getShiftDetails();
		request.setAttribute("ALLSHIFTS",shiftlist);
		
		List<DepartmentMasterVO> departmentlist =new TimeSheetReportAuditBD().getDepartmentDetails();
		
		request.setAttribute("ALLDEPT", departmentlist);
	
		return mapping.findForward("timesheet_report");
	}

	public synchronized ActionForward getEmployeeAttendanceInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TimeSheetReportForm timeSheetReportForm=(TimeSheetReportForm)form;
		List<TimeSheetReportVO> employeeAttendancelist =  new  TimeSheetReportAuditBD().getEmployeeAttendanceInfo(timeSheetReportForm);
	
		request.setAttribute("EmployeeList",employeeAttendancelist);
		return mapping.findForward(StringUtils.TIMESHEET_REPORT);
	}
	
	public synchronized ActionForward getEmpTimeSheet(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String empid=request.getParameter("empid");
		String date=request.getParameter("date");
		String updatetime=request.getParameter("time");
		List<TimeSheetReportVO> timesheetlist =  new  TimeSheetReportAuditBD().getEmpTimeSheet(empid,date,updatetime);
		
		JSONObject json=new JSONObject();
		json.accumulate("TimeSheet", timesheetlist);
		response.getWriter().print(json);
		
		/*JSONArray array=new JSONArray(timesheetlist);
		System.out.println(array);*/
		
		
		return null;
	}
	
	public synchronized ActionForward getEmpDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String shiftid = (String) request.getParameter("shiftid");
		String deptid = (String) request.getParameter("deptid");

		ArrayList<AuditReportEmpVO> emp_list = new TimeSheetReportAuditBD().getEmpDetails(shiftid, deptid);
		
		JSONObject emp_object = new JSONObject();

		emp_object.accumulate("EMPDETAILS", emp_list);

		response.getWriter().print(emp_object);

		return mapping.findForward(null);

	}
}
