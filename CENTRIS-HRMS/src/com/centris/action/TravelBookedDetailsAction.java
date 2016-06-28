package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.TravelBookedDetailsPOJO;
import com.centris.VO.EmployeeSearchInTravelBookedVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.TravelBookedDetailsBD;
import com.centris.form.TravelBookedDetailsForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;
import com.itextpdf.text.pdf.events.IndexEvents.Entry;

public class TravelBookedDetailsAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(TravelBookedDetailsAction.class);

	public ActionForward travelBookedDetailsHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : travelBookedDetailsHome Starting");
		
		try{
				
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			
		ArrayList<TravelBookedDetailsVo> ticketbookeddetails=new TravelBookedDetailsBD().getBookedDetails(userDetailVO.getUserCode());
		request.setAttribute("TicketBookedDetails", ticketbookeddetails);
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
	
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : travelBookedDetailsHome Ending");
	
		return mapping.findForward(MessageConstants.TREVEL_BOOKED_DETAILS);
	}
	
	public ActionForward getEmployeeSearch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : getEmployeeSearch Starting");
		
		
		try{
			
		String searchTerm=request.getParameter("name_startsWith");
		
		ArrayList<EmployeeSearchInTravelBookedVO> employeesearchList=new TravelBookedDetailsBD().getSearchEmployee(searchTerm);
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.accumulate("response", employeesearchList);
		response.getWriter().print(jsonobject);
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : getEmployeeSearch Ending");
		return null;
	}
	public ActionForward getAllprojects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : getAllprojects Starting");
		
		try{
		ArrayList<ProjectMasterVo> projectlist=new TravelBookedDetailsBD().getAllprojects();
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.accumulate("ProjectList", projectlist);
		response.getWriter().print(jsonobject);
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : getAllprojects Ending");
		return null;
	}
	
	
	public ActionForward saveTravelBookedDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : saveTravelBookedDetails Starting");
		
		try{
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			
		TravelBookedDetailsForm travelBookedDetailsForm=(TravelBookedDetailsForm)form;
		
		TravelBookedDetailsPOJO travelBookedDetailsPOJO=new TravelBookedDetailsPOJO();
	
		if(travelBookedDetailsForm.getTicketbookedby()!=null){
		
		travelBookedDetailsPOJO.setBooked_by_bioid(travelBookedDetailsForm.getTicketbookedby().split("-")[1]);
		travelBookedDetailsPOJO.setBooked_by_empid(travelBookedDetailsForm.getTicketbookedbyempid());
		travelBookedDetailsPOJO.setWho_on_travel_bioid(travelBookedDetailsForm.getWhoisontravel().split("-")[1]);
		travelBookedDetailsPOJO.setWho_on_travel_empid(travelBookedDetailsForm.getWhoisontravelempid());
		travelBookedDetailsPOJO.setTravel_mode(travelBookedDetailsForm.getTravelmode());
		travelBookedDetailsPOJO.setTravelling_date(travelBookedDetailsForm.getTravellingdate());
		travelBookedDetailsPOJO.setBooked_date(travelBookedDetailsForm.getBookingdate());
		travelBookedDetailsPOJO.setTravel_from(travelBookedDetailsForm.getTravelfrom());
		travelBookedDetailsPOJO.setTravel_to(travelBookedDetailsForm.getTravelto());
		travelBookedDetailsPOJO.setAmount(travelBookedDetailsForm.getAmount());
		travelBookedDetailsPOJO.setProject_Ref_code(travelBookedDetailsForm.getProjectrefcode());
		travelBookedDetailsPOJO.setProjectcode(travelBookedDetailsForm.getProjectcode());
		
	    travelBookedDetailsPOJO.setDebit_card_used_by_bioid(travelBookedDetailsForm.getDebitorcreditcardused().split("-")[1]);
		travelBookedDetailsPOJO.setDebit_card_used_by_empid(travelBookedDetailsForm.getDebitorcreditcardusedempid());
		travelBookedDetailsPOJO.setTkt_book_code(new IDGenerator().getPrimaryKeyID("hrms_ticket_booking"));
		
	
		travelBookedDetailsPOJO.setPosted_by(userDetailVO.getUserCode());
		
		if(travelBookedDetailsForm.getConflict()!=""){
		   if(MessageConstants.TRAVEL_BOOKED_IS_CONFLICT_YES.equalsIgnoreCase(travelBookedDetailsForm.getConflict())){
			travelBookedDetailsPOJO.setIsConflict(MessageConstants.TRAVEL_BOOKED_IS_CONFLICT_YES);
		   }else{
			travelBookedDetailsPOJO.setIsConflict(MessageConstants.TRAVEL_BOOKED_IS_CONFLICT_NO);
		   }
	    }
		if(travelBookedDetailsForm.getRemarks()!=""){
		travelBookedDetailsPOJO.setRemarks(travelBookedDetailsForm.getRemarks()); 
		}
		
	    
		FormFile file = travelBookedDetailsForm.getFile();
		String realPath = null;
		String filePath =null;
		 
			
		 
		 String extension = "";

		 int i = file.getFileName().lastIndexOf('.');
		 if (i >= 0) {
		     extension = file.getFileName().substring(i+1);
		 }
		 
		 if(extension.equals(MessageConstants.DOCX) || extension.equals(MessageConstants.DOC)){
			 realPath = "UploadedImage/TravelFileUpload/Doc__" + travelBookedDetailsPOJO.getTkt_book_code()	+ ".doc";
			 
			 filePath = request.getRealPath("/")+ "UploadedImage/TravelFileUpload/Doc__"
						+ travelBookedDetailsPOJO.getTkt_book_code() +".doc";
		 }else if(extension.equals(MessageConstants.JPG)){
			 
			 realPath = "UploadedImage/TravelFileUpload/Doc__" + travelBookedDetailsPOJO.getTkt_book_code()	+ ".jpg";
			 
			 filePath = request.getRealPath("/")+ "UploadedImage/TravelFileUpload/Doc__"
						+ travelBookedDetailsPOJO.getTkt_book_code() +".jpg";
		 }else if(extension.equals(MessageConstants.XLSX) || extension.equals(MessageConstants.XLS)){
			
			 realPath = "UploadedImage/TravelFileUpload/Doc__" + travelBookedDetailsPOJO.getTkt_book_code()	+ ".xlsx";
			 
			 filePath = request.getRealPath("/")+ "UploadedImage/TravelFileUpload/Doc__"
						+ travelBookedDetailsPOJO.getTkt_book_code() +".xlsx";
		}else {
			 realPath = "UploadedImage/TravelFileUpload/Doc__" + travelBookedDetailsPOJO.getTkt_book_code()	+ ".pdf";
			
			filePath = request.getRealPath("/")+ "UploadedImage/TravelFileUpload/Doc__"
					+ travelBookedDetailsPOJO.getTkt_book_code() +".pdf";
		}
		 
		 
		 
		 
		 
	    		if (file.getFileSize() > 0) {
					byte[] btDataFile = file.getFileData();
					File of = new File(filePath);
					FileOutputStream osf = new FileOutputStream(of);
					osf.write(btDataFile);
					osf.flush();
				} else {
					realPath = "";
				}
			
		
		
		travelBookedDetailsPOJO.setFilepath(realPath);
		
     //Save the  travel allowance data
		String result= new TravelBookedDetailsBD().saveTravelBookedDetails(travelBookedDetailsPOJO);
	    
	  
		ArrayList<TravelBookedDetailsVo> ticketbookeddetails=new TravelBookedDetailsBD().getBookedDetails(userDetailVO.getUserCode());
			
	     request.setAttribute("TicketBookedDetails", ticketbookeddetails);	
	  
	 
	   
	     
	     if(MessageConstants.TRUE.equalsIgnoreCase(result)){
	    	 
	    	 request.setAttribute("successmessage", MessageConstants.TRAVEL_BOOKED_INSERT_SUCCESS);
	    
	     }else if(MessageConstants.MAIL_NOT_SENT.equalsIgnoreCase(result)){
	    	 
	    	 request.setAttribute("errormessage", MessageConstants.TRAVEL_BOOKED_INSERT_SUCCESS_MAIL_NOT_SENT);
	  
	     }else{
	    	 
	    	 request.setAttribute("errormessage", MessageConstants.TRAVEL_BOOKED_INSERT_FAILURE);
	     }
		
		
		}else{
			  
			ArrayList<TravelBookedDetailsVo> ticketbookeddetails=new TravelBookedDetailsBD().getBookedDetails(userDetailVO.getUserCode());
				
		     request.setAttribute("TicketBookedDetails", ticketbookeddetails);	
		}
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
	     
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : saveTravelBookedDetails Ending");
		
		return mapping.findForward(MessageConstants.TREVEL_BOOKED_DETAILS);
	}
	
	
	public ActionForward checkManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : checkManager Starting");
		
		try{
		String projectcode=request.getParameter("projectCode");
		
		boolean flag=new TravelBookedDetailsBD().checkManager(projectcode);
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.accumulate("status", flag);
		response.getWriter().print(jsonobject);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : checkManager Ending");
		return null;
	}

	public ActionForward checkvalidateTravelDate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : checkvalidateTravelDate Starting");
		
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String postedby=userDetailVO.getUserCode();
			
			
		String whoisontravelempid=request.getParameter("whoisontravelempid");
		String travellingDate=request.getParameter("travellingDate");
		
		
		TravelBookedDetailsVo travelBookedDetailsVo=new TravelBookedDetailsBD().checkvalidateTravelDate(travellingDate,whoisontravelempid,postedby);
		
		ArrayList<TravelBookedDetailsVo> travellist=new ArrayList<TravelBookedDetailsVo>();
		travellist.add(travelBookedDetailsVo);
			
		JSONObject jsonobject=new JSONObject();
		jsonobject.accumulate("TravelBookedDetailsVo", travellist);
		response.getWriter().print(jsonobject);
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : checkvalidateTravelDate Ending");
		return null;
	}
	
	
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : download Starting");
		
			try {
			String docPath = request.getParameter("filepath");
			response.setContentType("application/octet-stream");
			String fileName = "FileName";
			if (docPath != null) {
				String[] docPathArray = docPath.split("__");
				fileName = docPathArray[1];
			}
			
			response.addHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			File docFile = new File(request.getRealPath("/") + docPath);
			response.setContentLength((int) docFile.length());

			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())	+ " Control in TravelBookedDetailsAction : download Ending");
		return null;

	}
}
