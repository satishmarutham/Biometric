package com.centris.action;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;
import com.centris.VO.AttendanceTimeSheetReportVo;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.delegate.TimesheetReconciliationBD;
import com.centris.exception.AITrackerException;
import com.centris.form.AttendanceTimeSheetReportForm;
import com.centris.util.HelperClass;
import com.centris.util.TimesheetReportExcel;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class TimeSheetReportAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(TimeSheetReportAction.class);

	public ActionForward getProjects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : getProjects Starting");
		try {

			String managerid = request.getParameter("managerid");

			String[] managerid_array = managerid.split(",");

			ArrayList<ProjectMasterVo> projectlist = new ProjectMasterDelegate()
					.getProjectsByManager(managerid_array);

			JSONObject object = new JSONObject();
			object.put("projectlist", projectlist);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : getProjects Ending");

		return null;

	}

	// to get timesheet report
	public ActionForward Submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : getTimesheetReport Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			AttendanceTimeSheetReportForm att_time_form = (AttendanceTimeSheetReportForm) form;

			String[] empoyeeArray=request.getParameterValues("employee");
			String[] departmentarray=request.getParameterValues("department");
			String[] managerarray=request.getParameterValues("manager");
		
			
			
			ArrayList<AttendanceTimeSheetReportVo> timesheet_list = new TimeSheetReportBD()
					.getTimesheetReport(empoyeeArray,att_time_form.getMonth(),
							att_time_form.getYear());

			request.setAttribute("timesheet_list", timesheet_list);
			request.setAttribute(
					"days",
					HelperClass.getDaysByMonthAndYear(
							Integer.parseInt(att_time_form.getMonth()),
							Integer.parseInt(att_time_form.getYear())));

			ArrayList< DepartmentFilterVO > deptlist = new TimesheetReconciliationBD().getAllDepartments();
	    	request.setAttribute("AllDepartments", deptlist); 
			request.setAttribute("ACC_YEAR",
					new TimeSheetReportBD().getAccYear());
			
			String empId=null;
			
			for(int i=0;i<empoyeeArray.length;i++){
				
				if(empId==null){
					
					empId=empoyeeArray[i];
				}else{
					
					empId=empId+","+empoyeeArray[i];
					
				}
			}
			
			String depId=null;
						
						for(int i=0;i<departmentarray.length;i++){
							
							if(depId==null){
								
								depId=departmentarray[i];
							}else{
								
								depId=depId+","+departmentarray[i];
								
							}
						}
			
			
				String mgrId=null;
							
							for(int i=0;i<managerarray.length;i++){
								
								if(mgrId==null){
									
									mgrId=managerarray[i];
								}else{
									
									mgrId=mgrId+","+managerarray[i];
									
								}
							}
							
							request.setAttribute("hEmpId", empId);
							request.setAttribute("hDepId", depId);
							request.setAttribute("hMgrId", mgrId);
							request.setAttribute("hmonth", att_time_form.getMonth());
							request.setAttribute("hyear",  att_time_form.getYear());

			if (timesheet_list.size() == 0) {

				request.setAttribute("message",
						MessageConstants.MONTHLY_LEGEND_MSG);

			}

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, 1);
			cal.set(Calendar.MONTH, Integer.parseInt(att_time_form.getMonth()));
			cal.set(Calendar.YEAR, Integer.parseInt(att_time_form.getYear()));
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			int days = cal.get(Calendar.DATE);
			java.util.Date d = new java.util.Date(cal.getTimeInMillis());

			String filePath = getServlet().getServletContext().getRealPath("")
					+ "\\TimesheetReport\\TimesheetReport.xls";

			HttpSession session = request.getSession(false);
			session.setAttribute("year1", att_time_form.getYear());
			session.setAttribute("month1",
					new SimpleDateFormat("MMMM").format(d));

			TimesheetReportExcel excelfile = new TimesheetReportExcel();
			excelfile.download(timesheet_list, days, filePath);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : getTimesheetReport Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "attendancetimesheetreport";
		} else {
			forward = Director.DIRECTOR_GET_TIMESHEETREPORT;
		}
		return mapping.findForward(forward);

	}

	public ActionForward Download(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		String filePath = getServlet().getServletContext().getRealPath("")
				+ "\\TimesheetReport\\TimesheetReport.xls";
		ServletOutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(filePath);
		HttpSession ses = request.getSession();
		String year1 = (String) ses.getAttribute("year1");
		String month1 = (String) ses.getAttribute("month1");
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("content-disposition", "attachment; filename="
				+ "TimesheetReport" + year1 + "_" + month1 + ".xls");

		int octet;
		while ((octet = in.read()) != -1)
			out.write(octet);

		/*in.close();*/

	/*	if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "attendancetimesheetreport";
		} else {
			forward = Director.DIRECTOR_GET_TIMESHEETREPORT;
		}
		return mapping.findForward(forward);*/
		
		return null;
	}


	public synchronized  ActionForward getManagersByDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeSheetReportAction: getManagersByDept Starting");
     try{
    
    	 String depts = request.getParameter("dept");
    	 ArrayList<ManagerFilterVO> manglist=new ArrayList<ManagerFilterVO>();
    	 
    	 String userType=HelperClass.getCurrentUserIDType(request);
    	 
    		 
    	 manglist = new TimeSheetReportBD().getManagersByDept(depts,HelperClass.getCurrentUserID(request),userType);
    		 
    	 
		
	
		JSONObject jsonobject = new JSONObject();
		jsonobject.accumulate("ManagerList", manglist);
		response.getWriter().print(jsonobject);
			
         }catch(Exception e){
        	 logger.error(e.getMessage(),e);
 		     e.printStackTrace();
 	     }
 	   
 	   JLogger.log(0, JDate.getTimeString(new Date())
 				+ MessageConstants.END_POINT);
 		logger.info(JDate.getTimeString(new Date())
 				+ " Control in TimesheetReconciliationAction : getManagersByDept Ending");
		return null;
	}
	
	public synchronized  ActionForward getEmployeeByMang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeSheetReportAction: getEmployeeByMang Starting");
     try{
    
    	 String manager = request.getParameter("manager");
    	 
		ArrayList<EmployeeFilterVO> emplist = new TimeSheetReportBD().getEmployeesByMang(manager);
	
		JSONObject jsonobject = new JSONObject();
		jsonobject.accumulate("employeeList", emplist);
		response.getWriter().print(jsonobject);
			
         }catch(Exception e){
        	 logger.error(e.getMessage(),e);
 		     e.printStackTrace();
 	     }
 	   
 	   JLogger.log(0, JDate.getTimeString(new Date())
 				+ MessageConstants.END_POINT);
 		logger.info(JDate.getTimeString(new Date())
 				+ " Control in TimeSheetReportAction : getEmployeeByMang Ending");
		return null;
	}
	

}