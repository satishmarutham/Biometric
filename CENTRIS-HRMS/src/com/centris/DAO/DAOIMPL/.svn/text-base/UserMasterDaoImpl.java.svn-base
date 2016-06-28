package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.centris.DAO.DBService;
import com.centris.DAO.UserMasterDao;
import com.centris.POJO.UserMasterPojo;
import com.centris.action.UserMasterAction;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class UserMasterDaoImpl extends DBService implements UserMasterDao {

	private static Logger logger = Logger.getLogger(UserMasterDaoImpl.class);;

	@Override
	public synchronized List<UserMasterPojo> getUserDetails() {

		List<UserMasterPojo> getUserList = new ArrayList<UserMasterPojo>();

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: getUserDetails : Starting");
		Connection connection = null;
		PreparedStatement userpreparedstatement = null;
		ResultSet userresultset = null;
		try {
			connection = getConnection();
			userpreparedstatement = connection
					.prepareStatement(SQLutilConstants.GET_USERS);
			userresultset = userpreparedstatement.executeQuery();
			while (userresultset.next()) {

				UserMasterPojo masterPojo = new UserMasterPojo();
				masterPojo.setUsername(userresultset.getString("username"));
				masterPojo.setUserCode(userresultset.getString("userCode"));
				masterPojo.setPassword(userresultset.getString("password"));
				masterPojo.setRoleCode(userresultset.getString("roleCode"));
				masterPojo.setRoleName(userresultset.getString("RoleName"));
				masterPojo.setLocationName(userresultset.getString("Location"));
				masterPojo.setLocationCode(userresultset
						.getString("LocationCode"));
				masterPojo.setGroupName(userresultset.getString("GroupName"));
				masterPojo.setGroupCode(userresultset.getString("Gorupid"));
				getUserList.add(masterPojo);

			}

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if(userresultset!=null && !userresultset.isClosed()){
					userresultset.close();
				}
				
				if(userpreparedstatement!=null && !userpreparedstatement.isClosed()){
					userpreparedstatement.close();
				}
				
				if (connection!=null &&( !connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: getUserDetails : Ending");

		return getUserList;
	}

	@Override
	public synchronized String addUser(UserMasterPojo userMasterPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: addUser : Starting");
		Connection connection = null;
		PreparedStatement userpreparedstatement = null;
		ResultSet userresultset = null;
		PreparedStatement pscheckUserName = null;
		int userCount = 0;
		String successMessage = null;
		int insercount = 0;

		try {
			connection = getConnection();
			userpreparedstatement = connection
					.prepareStatement(SQLutilConstants.ADD_USER);

			userpreparedstatement.setString(1, userMasterPojo.getUserCode());
			userpreparedstatement.setString(2, userMasterPojo.getUsername());
			userpreparedstatement.setString(3, userMasterPojo.getPassword());
			userpreparedstatement.setString(4, userMasterPojo.getCreateuser());
			userpreparedstatement.setString(5, userMasterPojo.getRoleCode());
			userpreparedstatement
					.setString(6, userMasterPojo.getLocationCode());
			userpreparedstatement.setString(7, userMasterPojo.getGroupCode());

			pscheckUserName = connection
					.prepareStatement(SQLutilConstants.VALIDATE_USER_NAME);
			pscheckUserName.setString(1, userMasterPojo.getUsername());

			userresultset = pscheckUserName.executeQuery();
			while (userresultset.next()) {
				userCount = userresultset.getInt("username");
			}

			if (userCount == 0) {

				insercount = userpreparedstatement.executeUpdate();
				if (insercount > 0) {
					successMessage = MessageConstants.USER_ADD_SUCCESS;
				} else {

					successMessage = MessageConstants.USER_ADD_FAIL;
				}
			} else {
				successMessage = "UserName" + userMasterPojo.getUsername()
						+ "Already Exits";
			}
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				
				if (pscheckUserName != null && !pscheckUserName.isClosed()) {

					pscheckUserName.close();
				}

				if(userresultset!=null && !userresultset.isClosed()){
					userresultset.close();
				}
				
				if(userpreparedstatement!=null && !userpreparedstatement.isClosed()){
					userpreparedstatement.close();
				}
				
				if (connection!=null &&( !connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: addUser : Ending");

		return successMessage;
	}

	@Override
	public synchronized String editUser(UserMasterPojo userMasterPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: editUser : Starting");
		Connection connection = null;
		PreparedStatement userpreparedstatement = null;
		ResultSet userresultset = null;
		PreparedStatement pscheckUserName = null;
		String successMsg = null;
		int userNamecount = 0;
		int count = 0;

		try {
			connection = getConnection();
			userpreparedstatement = connection
					.prepareStatement(SQLutilConstants.EDIT_USER);
			userpreparedstatement.setString(1, userMasterPojo.getUsername());
			userpreparedstatement.setString(2, userMasterPojo.getPassword());
			userpreparedstatement.setString(3, userMasterPojo.getModifyuser());
			userpreparedstatement.setTimestamp(4,
					HelperClass.getCurrentTimestamp());
			userpreparedstatement.setString(5, userMasterPojo.getRoleCode());
			userpreparedstatement
					.setString(6, userMasterPojo.getLocationCode());
			userpreparedstatement.setString(7, userMasterPojo.getGroupCode());
			userpreparedstatement.setString(8, userMasterPojo.getUserCode());

			pscheckUserName = connection
					.prepareStatement(SQLutilConstants.VALIDATE_USER_NAME_UPDATE);
			pscheckUserName.setString(1, userMasterPojo.getUsername());
			pscheckUserName.setString(2, userMasterPojo.getUserCode());

			userresultset = pscheckUserName.executeQuery();

			while (userresultset.next()) {
				userNamecount = userresultset.getInt("username");

			}
			if (userNamecount == 0) {
				count = userpreparedstatement.executeUpdate();
				if (count > 0) {
					successMsg = MessageConstants.USER_UPDATE_SUCCESS;
				} else {
					successMsg = MessageConstants.USER_UPDATE_FAIL;
				}
				userMasterPojo.setSuccessMessage(successMsg);
			} else {
				successMsg = "User Name " + userMasterPojo.getUsername()
						+ "Already Exists,  Change User Name";
				
				userMasterPojo.setSuccessMessage(successMsg);
			}

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if (pscheckUserName != null && !pscheckUserName.isClosed()) {
					pscheckUserName.close();
				}

				if (userresultset != null && !userresultset.isClosed()) {

					userresultset.close();
				}
				if (userpreparedstatement != null && !userpreparedstatement.isClosed()) {

					userpreparedstatement.close();
				}
							
				if (connection!=null &&( !connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: editUser : Ending");
		return successMsg;
	}

	@Override
	public synchronized String deleteUser(UserMasterPojo userMasterPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: deleteUser : Starting");
		Connection connection = null;
		PreparedStatement userpreparedstatement = null;

		int result = 0;
		String successMessage = null;

		try {

			connection = getConnection();
			userpreparedstatement = connection
					.prepareStatement(SQLutilConstants.DELETE_USER);
			List<String> userCode = userMasterPojo.getUserCodeList();

			for (int i = 0; i < userCode.size(); i++) {
				userpreparedstatement.setString(1, userCode.get(i));
				result = userpreparedstatement.executeUpdate();
			}
			if (result > 0) {
				successMessage = MessageConstants.USER_DELETE_SUCCESS;
				userMasterPojo.setSuccessMessage(successMessage);
			} else {
				successMessage = MessageConstants.USER_DELETE_FAIL;
				userMasterPojo.setSuccessMessage(successMessage);
			}

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if(userpreparedstatement!=null && !userpreparedstatement.isClosed()){
					userpreparedstatement.close();
				}
				
				if (connection!=null &&( !connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: deleteUser : Ending");

		return successMessage;
	}

	@Override
	public synchronized ArrayList<UserMasterPojo> getGroupDetails() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<UserMasterPojo> getGroupDetails = new ArrayList<UserMasterPojo>();

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: getGroupDetails : Starting");
		Connection connection = null;
		PreparedStatement userpreparedstatement = null;
		ResultSet userresultset = null;
		try {
			connection = getConnection();
			userpreparedstatement = connection
					.prepareStatement(SQLutilConstants.GET_GROUP_CODE);
			userresultset = userpreparedstatement.executeQuery();
			while (userresultset.next()) {

				UserMasterPojo masterPojo = new UserMasterPojo();
				masterPojo.setGroupName(userresultset.getString("GroupName"));
				masterPojo.setGroupCode(userresultset.getString("Gorupid"));
				getGroupDetails.add(masterPojo);

			}

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if(userresultset!=null && !userresultset.isClosed()){
					userresultset.close();
				}
				if(userpreparedstatement!=null && !userpreparedstatement.isClosed()){
					userpreparedstatement.close();
				}
				if (connection!=null &&( !connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl: getGroupDetails : Ending");

		return getGroupDetails;
	}

	public synchronized boolean CurrentUserNameCkeck(String username) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl : CurrentUserNameCkeck Starting");

		Connection connection = null;
		PreparedStatement checkUserNameStatement = null;
		ResultSet checkPasswordResultset = null;
		boolean Status = false;
		int count = 0;
		try {
			connection=getConnection();
		
			checkUserNameStatement = connection
					.prepareStatement(SQLutilConstants.GET_USERNAME_CHECK);
			checkUserNameStatement.setString(1, username);

			checkPasswordResultset = checkUserNameStatement.executeQuery();

			while (checkPasswordResultset.next()) {
				count = checkPasswordResultset.getInt(1);
			}
			if (count == 1) {
				Status = true;
			} else {
				Status = false;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				
				if(checkPasswordResultset!=null && !checkPasswordResultset.isClosed()){
					checkPasswordResultset.close();
				}
				if(checkUserNameStatement!=null && !checkUserNameStatement.isClosed()){
					checkUserNameStatement.close();
				}
				if (connection!=null &&( !connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterDaoImpl : CurrentUserNameCkeck Ending");
		
		return Status;
	}
}