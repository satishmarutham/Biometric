package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.centris.DAO.AdminForgotPasswordDAO;
import com.centris.DAO.DBService;
import com.centris.VO.UsermanagementEmployeeVo;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AdminForgotPassword;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.constants.MessageConstants;

public class AdminForgotPasswordDAOIMPL extends DBService implements
		AdminForgotPasswordDAO {
	private static Logger logger = Logger
			.getLogger(AdminForgotPasswordDAOIMPL.class);

	@Override
	public synchronized int resetAdminPassword(String username, String email) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminForgotPasswordDAOIMPL : resetAdminPassword Starting");
		PreparedStatement pstmt = null;
		PreparedStatement update_password_pstmt = null;
		String status=null;
		ResultSet forgetMngpwd = null;
		Connection connection = null;
		int count = 0;
		String password = null;
		UsermanagementEmployeeVo voObj=null;
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(AdminForgotPassword.ADMIN_FORGET_PASSWORD);
			pstmt.setString(1, username);
			pstmt.setString(2, email);

			forgetMngpwd = pstmt.executeQuery();
			while (forgetMngpwd.next()) {
				count = forgetMngpwd.getInt(1);
			}

			if (count == 1) {
				count=0;
				pstmt = connection
						.prepareStatement(AdminForgotPassword.GET_ADMIN_DETAILS);
				pstmt.setString(1, username);
				pstmt.setString(2, email);

				forgetMngpwd = pstmt.executeQuery();
				while (forgetMngpwd.next()) {
					voObj=new UsermanagementEmployeeVo();
					voObj.setEmpname(forgetMngpwd.getString("First_Name"));
					voObj.setMobilenumber(forgetMngpwd.getString("Mobile_Number"));
					voObj.setBioid(forgetMngpwd.getString("bioid"));
					voObj.setOfficialmailId(forgetMngpwd.getString("Official_Email_ID"));
				}
				
				password=HelperClass.genaratePasswordForUser(voObj);
				status=new AdminForgotPasswordDAOIMPL().sendEmailToAdmin(voObj.getOfficialmailId(),
						username, password);
				System.out.println("status in admin password dao impl " +status);
				
				update_password_pstmt = connection
						.prepareStatement(AdminForgotPassword.UPDATE_ADMIN_PASSWORD);
				update_password_pstmt.setString(1, password);
				update_password_pstmt.setString(2, username);
				update_password_pstmt.setString(3, email);
				int update=update_password_pstmt.executeUpdate();
				System.out.println("update in admin password dao impl " +update);
				if(update > 0 && status.equals("true"))
				{
				count=1;
				}
				else if(update > 0 && !status.equals("true"))
				{
				count=2;
				}
				
				
			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {
			try {

				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminForgotPasswordDAOIMPL : resetAdminPassword Ending");
		return count;
	}


	
	public synchronized String sendEmailToAdmin(String emailId,
			String username, String password) {

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeForgotPassDaoImpl : sendEmailToEmployee Starting");
		
		Connection connection = null;
        String status=null;
		try {
			
			connection = getConnection();
			String url = getServerUrlFromBD(connection);
			

			EmailContent em = new EmailContent();
			String[] mails = { emailId };

			em.setMailids(mails);
			em.setSubject("Login Credentials");

			em.setMessage("Greetings from TeleIndia... \n\n"
					+ "This mail regarding 'forgot/reset password' mail triggered on the server.Admin login credentials are given below.\n"
					+ "\n"
					+ "Username	: "
					+ username
					+ "\n"
					+ "Password	: "
					+ password
					+ "\n"
					+ "Url      : "
					+ url
					+ "\n\n"
					+ "Have a nice day.\n\n"
					+ "e-AttendancePro \n"  
					+"\n----------------------------------------------------------------"
					+"\nThis is System generated mail, Please do not reply");

			status=new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeForgotPassDaoImpl : sendEmailToEmployee Ending");
		return status;
	}
	
	
	public String getServerUrlFromBD(Connection connection) {
		String url = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(Employee.GET_SERVER_URL);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				url = rs.getString("URL");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return url;
	}

}
