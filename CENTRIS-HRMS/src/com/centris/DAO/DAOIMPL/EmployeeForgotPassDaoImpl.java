package com.centris.DAO.DAOIMPL;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.VO.UsermanagementEmployeeVo;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.EmployeeForgotPassword;
import com.centris.util.constants.MessageConstants;

public class EmployeeForgotPassDaoImpl extends DBService {

	private static Logger logger = Logger
			.getLogger(EmployeeForgotPassDaoImpl.class);

	public int checkEmployeeDao(String dateofbirth,
			String emp_official_emailid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeForgotPassDaoImpl: checkEmployeeDao Starting");

		PreparedStatement ps_emp_get = null;
		PreparedStatement update_password_pstmt=null;
		Connection connection = null;
		UsermanagementEmployeeVo voObj=null;
		ResultSet rs = null;
		int count = 0;
		String pass = null;
		String status=null;
		try {
			connection = getConnection();

			ps_emp_get = connection
					.prepareStatement(EmployeeForgotPassword.EMPLOYEE_COUNT);
			ps_emp_get.setString(1,
					HelperClass.convertUIToDatabase(dateofbirth));
			ps_emp_get.setString(2, emp_official_emailid);

			rs = ps_emp_get.executeQuery();
			rs.next();
			count = rs.getInt(1);

			if (count > 0) {
				
				count=0;
				
				ps_emp_get = connection
						.prepareStatement(EmployeeForgotPassword.GET_EMPLOYEE_DETAILS);
				ps_emp_get.setString(1,
						HelperClass.convertUIToDatabase(dateofbirth));
				ps_emp_get.setString(2, emp_official_emailid);
				rs = ps_emp_get.executeQuery();

				while (rs.next()) {
				voObj=new UsermanagementEmployeeVo();
				voObj.setEmpname(rs.getString("First_Name"));
				voObj.setMobilenumber(rs.getString("Mobile_Number"));
				voObj.setBioid(rs.getString("bioid"));
				voObj.setOfficialmailId(rs.getString("Official_Email_ID"));
				}
				
				pass=HelperClass.genaratePasswordForUser(voObj);
				
				status=new EmployeeForgotPassDaoImpl().sendEmailToEmployee(
						emp_official_emailid, emp_official_emailid, pass);
				
				update_password_pstmt = connection
						.prepareStatement(EmployeeForgotPassword.UPDATE_EMPLOYEE_PASSWORD);
				update_password_pstmt.setString(1, pass);
				update_password_pstmt.setString(2, emp_official_emailid);
				
				int update=update_password_pstmt.executeUpdate();
				System.out.println("status in dao impl " +status);
				if(update > 0 && status.equals("true"))
				{
				count=1;
				}
				else if(update > 0 && !status.equals("true"))
				{
				count=2;
				}
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (ps_emp_get != null && !ps_emp_get.isClosed()) {
					ps_emp_get.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in Control in EmployeeForgotPassDaoImpl: checkEmployeeDao Ending");

		return count;
	}

	public synchronized String sendEmailToEmployee(String emailId,
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
					+ "This mail regarding 'forgot/reset password' mail triggered on the server.Employee login credentials are given below.\n"
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

			status= new SendMailWithMultipleAttachment().sendReportToMail(em);
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
