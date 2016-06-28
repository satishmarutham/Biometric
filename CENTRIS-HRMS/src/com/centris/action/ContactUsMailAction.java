package com.centris.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.centris.form.ContactUsMailForm;
import com.centris.util.EmailContent;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ContactUsMailAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(ContactUsMailAction.class);

	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/properties/CENTRIS-HRMS");
	private static String TeleIndia_SendMail_Dir = res.getString("TeleIndia_SendMail_Dir");
	
	public synchronized ActionForward sendMail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ContactUsMailAction : sendMail Starting");
		
	try {
			ContactUsMailForm contactUsMailForm = (ContactUsMailForm) form;
			if (isNetworkAvailable()) {
				EmailContent em = new EmailContent();
				String[] mails = { contactUsMailForm.getMailTo() };
				em.setMailids(mails);
				
				
				String fileName = contactUsMailForm.getAttachFile()
						.getFileName();
				
				if(!fileName.isEmpty()){
						
				File of = new File(TeleIndia_SendMail_Dir);
				of.mkdir();
				File of1 = new File(of,fileName);
				
				if (contactUsMailForm.getAttachFile().getFileSize() > 0) {
					byte[] btDataFile = contactUsMailForm.getAttachFile()
							.getFileData();
					FileOutputStream osf = new FileOutputStream(of1);
					osf.write(btDataFile);
					osf.flush();
				}
				String filePath = of1.getAbsolutePath().replace("\\", "/");
				
				List<String> filesPathList = new ArrayList<String>();
				filesPathList.add(filePath);
				em.setAttachmultpleFiles(filesPathList);
				of1.delete();
				}
				
				em.setSubject(contactUsMailForm.getMailSub());
		
				em.setMessage("Greetings from TeleIndia. \n\n"
						+ "Mail From  "+contactUsMailForm.getMailFrom()+"\n"
						+ "From MobileNo : " + contactUsMailForm.getCusMobile() + "\n\n"
						+ contactUsMailForm.getMailContent()+"\n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
				
							
			 String status =new SendMailWithMultipleAttachment().sendReportToMail(em);
		
			   if(status=="true"){
			    
				   request.getSession(false).setAttribute("NetworkStatus","Mail Sent Successfully");
			   }else{
						request.getSession(false).setAttribute("NetworkError", "Network Available,Mail not Sent");
				
				}
				
			} else {
				request.getSession(false).setAttribute("NetworkStatus", null);
				request.getSession(false).setAttribute("NetworkError",
						"Please Check Internet Connection");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ContactUsMailAction : sendMail Ending");
		return mapping.findForward("ContactUsMail");
	}

	private synchronized boolean isNetworkAvailable()
			throws InterruptedException {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ContactUsMailAction : isNetworkAvailable Starting");
		boolean isNetworkAvailable = false;
		Socket socket = null;
		try {
			socket = new Socket("www.google.com", 80);
			if (socket != null)
				isNetworkAvailable = true;
		} catch (IOException e) {
			isNetworkAvailable = false;
			e.printStackTrace();
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ContactUsMailAction : isNetworkAvailable Ending");
		return isNetworkAvailable;
	}

	public synchronized ActionForward removeSessionObject(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ContactUsMailAction : removeSessionObject Starting");
		try {
			request.getSession(false).setAttribute("NetworkStatus", null);
			request.getSession(false).setAttribute("NetworkError", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ContactUsMailAction : removeSessionObject Ending");
		return null;
	}

}
