/**
 * 
 */
package com.centris.action;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.POJO.ManagerLeaveConfirmationPojo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ManagerLeaveConfirmationBD;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 *
 */
public class ManagerLeaveConfirmationAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(ManagerLeaveConfirmationAction.class);

	public ActionForward confirm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : confirm Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String usercode=userDetailVO.getUserCode();
ManagerLeaveConfirmationPojo confirmationPojo=new ManagerLeaveConfirmationPojo();
confirmationPojo.setSno(Integer.parseInt(request.getParameter("sno")));
confirmationPojo.setTotalleavesApproved(Double.parseDouble(request.getParameter("TotalLeavesApproved")));
confirmationPojo.setApprovedStartDate(request.getParameter("ApprovedStartdate"));
confirmationPojo.setApprovedEndDate(request.getParameter("ApprovedEndDate"));
confirmationPojo.setComments(request.getParameter("comments"));
confirmationPojo.setApprovedDate(new Timestamp(new Date().getTime()));
confirmationPojo.setApprovedBy(usercode);
confirmationPojo.setApprovedStatus("APPROVED");


		ManagerLeaveConfirmationBD confirmationBD=new ManagerLeaveConfirmationBD();
		String success=confirmationBD.confirm(confirmationPojo);
		JSONObject  jsonObject=new JSONObject();
		jsonObject.accumulate("success",success);
		response.getWriter().print(jsonObject);
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerLeaveConfirmationAction: confirm Ending");
		return null;
	}


public ActionForward hold(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeMenuAction : hold Starting");
	UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
	String userName=userDetailVO.getUserName();
System.out.println("Hold Action:::Start:::");
ManagerLeaveConfirmationPojo confirmationPojo=new ManagerLeaveConfirmationPojo();

	confirmationPojo.setSno(Integer.parseInt(request.getParameter("sno")));
	confirmationPojo.setRequestedBy(request.getParameter("requestedBy"));
	confirmationPojo.setStartDate(request.getParameter("startDate"));
	confirmationPojo.setEndDate(request.getParameter("endDate"));
	confirmationPojo.setRequestedDate(request.getParameter("requestedDate"));
	confirmationPojo.setNoofLeaves(Double.parseDouble(request.getParameter("noOfLeaves")));
confirmationPojo.setComments(request.getParameter("comments"));
confirmationPojo.setReasonforLeave(request.getParameter("reassonLeave"));
confirmationPojo.setApprovedBy(userName);
	confirmationPojo.setApprovedStatus("HOLD");
	ManagerLeaveConfirmationBD confirmationBD=new ManagerLeaveConfirmationBD();
	String success=confirmationBD.hold(confirmationPojo);
	
	JSONObject jsonObject=new JSONObject();
	jsonObject.accumulate("success",success);
	
	response.getWriter().print(jsonObject);
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ManagerLeaveConfirmationAction: hold Ending");
	return null;
}

public ActionForward reject(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeMenuAction : reject Starting");

	ManagerLeaveConfirmationPojo confirmationPojo=new ManagerLeaveConfirmationPojo();


confirmationPojo.setSno(Integer.parseInt(request.getParameter("sno")));

confirmationPojo.setComments(request.getParameter("comments"));

confirmationPojo.setApprovedStatus("REJECT");
	
	
	ManagerLeaveConfirmationBD confirmationBD=new ManagerLeaveConfirmationBD();
	String success=confirmationBD.reject(confirmationPojo);
	
	JSONObject jsonObject=new JSONObject();
	jsonObject.accumulate("success", success);
	response.getWriter().print(jsonObject);
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ManagerLeaveConfirmationAction: reject Ending");
	return null;
}

public ActionForward getSingleLeaveDetails(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeMenuAction : getSingleLeaveDetails Starting");

	ManagerLeaveConfirmationBD leaveConfirmationBD=new ManagerLeaveConfirmationBD();

	int sno=Integer.parseInt(request.getParameter("Sno"));
	



	List<ManagerLeaveConfirmationPojo> getLeaveDetailsById=leaveConfirmationBD.getLeaveDetailsBySno(sno);
	JSONObject jsonObject=new JSONObject();
	jsonObject.accumulate("leaveDetailsBySno", getLeaveDetailsById);
	
response.getWriter().println(jsonObject);
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ManagerLeaveConfirmationAction: getSingleLeaveDetails Ending");
	return null;
}

public ActionForward download(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

	
	try {
		String filePath = request.getParameter("filepath");
		
		String EmployeeId = request.getParameter("sno");
	String fullpath=getServlet().getServletContext().getRealPath("")+ "/"+filePath;
	
		if ((new File(fullpath)).exists()) {
		
			ServletOutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(fullpath);
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.addHeader("content-disposition","outline; filename=" + EmployeeId+ "." + "docx");
			int octet;
			while ((octet = in.read())!= -1)
				out.write(octet);
			in.close();
			out.close();
			in = null;
			out = null;
		} else {
			response.getWriter().print("File Not Found");
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;

}
}