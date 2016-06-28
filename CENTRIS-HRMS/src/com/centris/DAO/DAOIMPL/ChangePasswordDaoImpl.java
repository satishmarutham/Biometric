package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.ChangePasswordDao;
import com.centris.DAO.DBService;
import com.centris.VO.ChangePasswordVo;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.ChangePassword;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class ChangePasswordDaoImpl implements ChangePasswordDao {
	private static Logger logger = Logger
			.getLogger(ChangePasswordDaoImpl.class);

	@Override
	public synchronized boolean checkManagerCurrentPassword(String username,
			String password) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : getCurrentPassword Starting");

		DBService db = null;
		PreparedStatement checkPasswordStatement = null;
		ResultSet checkPasswordResultset = null;
		boolean Status = false;
		String db_password = null;

		try {
			db = new DBService();
			checkPasswordStatement = db
					.getPreparedStatement(ChangePassword.GET_CURRENT_MANAGER_PASSWORD);
			checkPasswordStatement.setString(1, username);

			checkPasswordResultset = checkPasswordStatement.executeQuery();

			while (checkPasswordResultset.next()) {
				db_password = checkPasswordResultset.getString(1);
			}

			if (db_password.equalsIgnoreCase(password)) {
				Status = false;
			} else {
				Status = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (checkPasswordStatement != null
						&& (!checkPasswordStatement.isClosed())) {
					checkPasswordStatement.getConnection().close();
				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : getCurrentPassword Ending");
		return Status;
	}

	@Override
	public synchronized String updateManagerPassword(ChangePasswordVo voObj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : updateManagerPassword Starting");

		DBService db = null;
		PreparedStatement checkPasswordStatement = null;
		ResultSet checkPasswordResultset = null;
		int result = 0;
		String successMsg = null;

		try {
			db = new DBService();
			checkPasswordStatement = db
					.getPreparedStatement(ChangePassword.UPDATE_CURRENT_MANAGER_PASSWORD);
			checkPasswordStatement.setString(1, voObj.getNew_Password());
			checkPasswordStatement.setString(2, voObj.getUserName());
			checkPasswordStatement.setString(3, voObj.getCurrent_Password());
			checkPasswordStatement.setString(4, voObj.getEmial());
			System.out.println("checkPasswordStatement"
					+ checkPasswordStatement);

			result = checkPasswordStatement.executeUpdate();
			if (result > 0) {
				String emailId = getEMailIdByUserName(voObj.getUserName());
				String success = sendPasswordEmail(emailId,
						voObj.getNew_Password());
				successMsg = "successMessage";
			} else {
				successMsg = "errorMessage";
			}

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (checkPasswordStatement != null
						&& (!checkPasswordStatement.isClosed())) {
					checkPasswordStatement.getConnection().close();
				}
			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : updateManagerPassword Ending");
		return successMsg;
	}

	@Override
	public boolean checkAdminCurrentPassword(String username, String password,
			String type) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : checkAdminCurrentPassword Starting");

		DBService db = null;
		PreparedStatement checkPasswordStatement = null;
		ResultSet checkPasswordResultset = null;
		boolean Status = false;
		String db_password = null;

		try {
			db = new DBService();
			if (type.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
				checkPasswordStatement = db
						.getPreparedStatement(ChangePassword.GET_CURRENT_ADMIN_PASSWORD);
				checkPasswordStatement.setString(1, username);
			} else {
				checkPasswordStatement = db
						.getPreparedStatement(ChangePassword.GET_CURRENT_DIRECTOR_PASSWORD);
				checkPasswordStatement.setString(1, username);
			}
			checkPasswordResultset = checkPasswordStatement.executeQuery();

			while (checkPasswordResultset.next()) {
				db_password = checkPasswordResultset.getString(1);
			}

			if (db_password.equalsIgnoreCase(password)) {
				Status = false;
			} else {
				Status = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (checkPasswordStatement != null
						&& (!checkPasswordStatement.isClosed())) {
					checkPasswordStatement.getConnection().close();
				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : checkAdminCurrentPassword Ending");
		return Status;
	}

	@Override
	public String updateAdminPassword(ChangePasswordVo obj) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : updateAdminPassword Starting");

		DBService db = null;
		PreparedStatement checkPasswordStatement = null;
		int result = 0;
		String successMsg = null;

		try {
			db = new DBService();

			if (obj.getCurrentUserId().trim().substring(0, 3)
					.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
				checkPasswordStatement = db
						.getPreparedStatement(ChangePassword.UPDATE_CURRENT_ADMIN_PASSWORD);
				checkPasswordStatement.setString(1, obj.getNew_Password());
				checkPasswordStatement.setString(2, obj.getUserName());
				checkPasswordStatement.setString(3, obj.getCurrent_Password());
			} else {
				checkPasswordStatement = db
						.getPreparedStatement(ChangePassword.UPDATE_DIRECTOR_PASSWORD);
				checkPasswordStatement.setString(1, obj.getNew_Password());
				checkPasswordStatement.setString(2, obj.getCurrentUserId());
				checkPasswordStatement.setString(3, HelperClass
						.getCurrentTimestamp().toString().substring(0, 19));
				checkPasswordStatement.setString(4, obj.getUserName());
				checkPasswordStatement.setString(5, obj.getCurrent_Password());
			}
			result = checkPasswordStatement.executeUpdate();
			if (result > 0) {
				successMsg = "successMessage";
			} else {
				successMsg = "errorMessage";
			}

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} finally {
			try {
				if (checkPasswordStatement != null
						&& (!checkPasswordStatement.isClosed())) {
					checkPasswordStatement.getConnection().close();
				}
			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : updateAdminPassword Ending");
		return successMsg;
	}

	public String checkManagerMail(String email, String username) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : checkManagerMail Starting");

		DBService db = null;
		PreparedStatement checkemailStatement = null;
		ResultSet checkMailResultset = null;
		boolean Status = false;
		String successMessage = null;
		int count = 0;
		try {
			db = new DBService();
			checkemailStatement = db
					.getPreparedStatement(ChangePassword.MANAGER_MAIL_CHECK);
			checkemailStatement.setString(1, username);
			checkemailStatement.setString(2, email);

			checkMailResultset = checkemailStatement.executeQuery();

			while (checkMailResultset.next()) {
				count = checkMailResultset.getInt(1);
			}

			if (count > 0) {

			} else {
				successMessage = "Please Check Email";
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (checkMailResultset != null
						&& (!checkMailResultset.isClosed())) {
					checkemailStatement.getConnection().close();
				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : checkManagerMail Ending");
		return successMessage;
	}

	@Override
	public boolean checkEmployeeCurrentPassword(String username, String password) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : checkAdminCurrentPassword Starting");

		DBService db = null;
		PreparedStatement checkPasswordStatement = null;
		ResultSet checkPasswordResultset = null;
		boolean Status = false;
		String db_password = null;
		int count = 0;

		try {
			db = new DBService();
			checkPasswordStatement = db
					.getPreparedStatement(ChangePassword.GET_CURRENT_EMPLOYEE_PASSWORD);
			checkPasswordStatement.setString(1, username);
			checkPasswordStatement.setString(2, password);

			checkPasswordResultset = checkPasswordStatement.executeQuery();

			while (checkPasswordResultset.next()) {
				count = checkPasswordResultset.getInt(1);
				System.out.println("db_passwor" + db_password);
			}

			if (count > 0) {
				Status = false;
			} else {
				Status = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (checkPasswordStatement != null
						&& (!checkPasswordStatement.isClosed())) {
					checkPasswordStatement.getConnection().close();
				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : checkAdminCurrentPassword Ending");
		return Status;
	}

	@Override
	public String updateEmployeePassword(ChangePasswordVo obj) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : updateAdminPassword Starting");

		DBService db = null;
		PreparedStatement checkPasswordStatement = null;
		ResultSet checkPasswordResultset = null;
		int result = 0;
		String successMsg = null;

		try {
			db = new DBService();
			checkPasswordStatement = db
					.getPreparedStatement(ChangePassword.UPDATE_CURRENT_EMPLOYEE_PASSWORD);
			checkPasswordStatement.setString(1, obj.getNew_Password());
			checkPasswordStatement.setString(2, obj.getCurrent_Password());
			checkPasswordStatement.setString(3, obj.getEmial());

			result = checkPasswordStatement.executeUpdate();
			if (result > 0) {
				successMsg = sendPasswordEmail(obj.getUserName(),
						obj.getNew_Password());
				successMsg = "successMessage";
			} else {
				successMsg = "errorMessage";
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (checkPasswordStatement != null
						&& (!checkPasswordStatement.isClosed())) {
					checkPasswordStatement.getConnection().close();
				}
			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : updateAdminPassword Ending");
		return successMsg;
	}

	public String getEmployeeDOB(String empId, String dob) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : checkManagerMail Starting");

		DBService db = null;
		PreparedStatement checkemailStatement = null;
		ResultSet checkDOBResultset = null;
		boolean Status = false;
		String successMessage = null;
		int count = 0;
		try {
			db = new DBService();
			checkemailStatement = db
					.getPreparedStatement(ChangePassword.GET_EMPLOYEE_DOB);
			checkemailStatement.setString(1,
					HelperClass.convertUIToDatabase(dob));
			checkemailStatement.setString(2, empId);
			System.out.println(checkemailStatement);
			checkDOBResultset = checkemailStatement.executeQuery();

			while (checkDOBResultset.next()) {
				count = checkDOBResultset.getInt(1);
			}

			if (count > 0) {

			} else {
				successMessage = "Check Date of Birth";
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (checkDOBResultset != null
						&& (!checkDOBResultset.isClosed())) {
					checkemailStatement.getConnection().close();
				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : getEmployeeDOB Ending");
		return successMessage;
	}

	public String sendPasswordEmail(String emailId, String password) {
		try {
			EmailContent em = new EmailContent();
			String[] mails = { emailId };

			em.setMailids(mails);
			em.setSubject("Change Password Confirmation");
			em.setMessage("Greetings from TeleIndia. \n"
					+ " You have successfully Changed your Password. \n"
					+ " Your New Password	: " + password + "\n\n");
			new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "sent";
	}

	public String getEMailIdByUserName(String username) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : getEMailIdByUserName Starting");

		PreparedStatement pstm = null;
		ResultSet rs = null;
		String emailId = "";
		try {
			pstm = new DBService()
					.getPreparedStatement(ChangePassword.GET_EMAIL_ID_BY_USERNAME);
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			while (rs.next()) {
				emailId = rs.getString(1);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (pstm.getConnection() != null
						&& !pstm.getConnection().isClosed()) {
					pstm.getConnection().close();
				}
			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : getEMailIdByUserName Ending");
		return emailId;
	}
}