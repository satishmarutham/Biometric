package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.LoginDAO;
import com.centris.VO.LoginVO;
import com.centris.VO.UserDetailVO;
import com.centris.exception.AITrackerException;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class LoginDAOIMPL extends DBService implements LoginDAO {
	private static Logger logger = Logger.getLogger(LoginDAOIMPL.class);
	public LoginVO lvo;

	@Override
	public synchronized String userValid(String username, String password,
			String type) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : userValid Starting");

		lvo = new LoginVO();
		String result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;

		if (ApplicationConstants.USER_ADMIN.equalsIgnoreCase(type)) {
			query = LoginDetails.ADMIN_DETAILSCHECK;
		}
		if (ApplicationConstants.USER_MANAGER.equalsIgnoreCase(type)) {
			query = LoginDetails.MANAGER_LOGINCHECK;
		}
		if (ApplicationConstants.USER_EMPLOYEE.equalsIgnoreCase(type)) {
			query = LoginDetails.EMPLOYEE_LOGINCHECK;
		}
		if (ApplicationConstants.USER_DIRECTOR.equalsIgnoreCase(type)) {
			query = LoginDetails.DIRECTOR_LOGINCHECK;
		}

		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			logger.error(pstmt);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				lvo.setUserName(rs.getString(StringUtils.DB_USERNAME));
				lvo.setPassWord(rs.getString(StringUtils.DB_PASSWORD));
				lvo.setUserCode(rs.getString(StringUtils.DB_USERCODE));

				result = StringUtils.LOGIN_TRUE;

			} else {
				result = StringUtils.LOGIN_FALSE;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}

			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL: userValid Ending");
		return result;
	}

	public synchronized String userValidCase(String username, String password,
			String type) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL:userValid Starting");

		lvo = new LoginVO();
		String userexist = null;
		String query = null;

		if (ApplicationConstants.USER_ADMIN.equalsIgnoreCase(type)) {
			query = LoginDetails.ADMIN_LOGINCHECK;
		}
		if (ApplicationConstants.USER_MANAGER.equalsIgnoreCase(type)) {
			query = LoginDetails.MANAGER_LOGINCHECK;
		}
		if (ApplicationConstants.USER_EMPLOYEE.equalsIgnoreCase(type)) {
			query = LoginDetails.EMPLOYEE_LOGINCHECK;
		}
		if (ApplicationConstants.USER_DIRECTOR.equalsIgnoreCase(type)) {
			query = LoginDetails.DIRECTOR_LOGINCHECK;
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			logger.error(pstmt);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				lvo.setUserName(rs.getString(StringUtils.DB_USERNAME));
				lvo.setPassWord(rs.getString(StringUtils.DB_PASSWORD));
				lvo.setUserCode(rs.getString(StringUtils.DB_USERCODE));

				if (username.equals(rs.getString(StringUtils.DB_USERNAME))
						&& password.equals(rs
								.getString(StringUtils.DB_PASSWORD))) {

					userexist = StringUtils.LOGIN_TRUE;

				} else {
					userexist = StringUtils.LOGIN_FALSE;
				}
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}

			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL: userValid Ending");
		return userexist;
	}

	public synchronized UserDetailVO getUserAdminDetails(String userName,
			String password) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : getUserAdminDetails Starting");

		UserDetailVO userDetailVO = null;
		HashMap<String, String> permissionmap = new HashMap<String, String>();

		String query = LoginDetails.GET_ADMIN_DETAILS;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;

		try {
			
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
		
			rs = pstmt.executeQuery();
			
			System.out.println("pstmt"+pstmt);
			
			if (rs.next()) {
				userDetailVO = new UserDetailVO();
				userDetailVO.setUserFirstName(rs.getString("First_Name"));
				userDetailVO.setLocation("LOC1");
				userDetailVO.setLocationName("LOC1");
				userDetailVO.setGroupCode("GRP1");
				userDetailVO.setGroupName("GRP1");
				userDetailVO.setRoleCode(rs.getString("roleCode"));
				userDetailVO.setRoleName(rs.getString("RoleName"));
				userDetailVO.setUserCode(rs.getString("userCode"));
				userDetailVO.setUserName(rs.getString("username"));
				userDetailVO.setUserType(rs.getString("UserType"));
				userDetailVO.setEmpId(rs.getString("empId"));
				userDetailVO.setEmployeeImage(rs.getString("Employee_image"));
				
				userDetailVO.setUserExist(true);
				
				pstmt1=con.prepareStatement(LoginDetails.GET_PERMISSIONS);
				pstmt1.setString(1, rs.getString("roleCode"));
				
				rs1=pstmt1.executeQuery();
			
				
				ArrayList<String> permissionCodeArray=new ArrayList<String>();
				ArrayList<String> permissionShortNamArray=new ArrayList<String>();
				ArrayList<String> pPermissionNameArray=new ArrayList<String>();
				ArrayList<String> pPermissionStatusArray=new ArrayList<String>();
				
				while(rs1.next()){
					
					permissionCodeArray.add(rs1.getString("PermissionCode"));
					permissionShortNamArray.add(rs1.getString("shortName"));
					pPermissionNameArray.add(rs1.getString("permission"));
					pPermissionStatusArray.add(rs1.getString("isApplicable"));
					
					
				}
					
					
				for (int i = 0; i < permissionCodeArray.size(); i++) {
					
					permissionmap.put(permissionShortNamArray.get(i),
							pPermissionStatusArray.get(i));
				}

				userDetailVO.setPermissionCodeList(permissionCodeArray);
				userDetailVO.setPermissionNameList(pPermissionNameArray);
				userDetailVO.setPermissionShortNameList(permissionShortNamArray);

				userDetailVO.setPermissionmap(permissionmap);
			} else {
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : getUserAdminDetails Ending");

		return userDetailVO;
	}

	@Override
	public synchronized UserDetailVO getUserManagerDetails(String userName,
			String password, String userType) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : getUserManagerDetails Starting");
		UserDetailVO userDetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = LoginDetails.GET_MANAGER_DETAILS;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			logger.error(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userDetailVO = new UserDetailVO();
				userDetailVO.setUserCode(rs.getString("userCode"));
				userDetailVO.setUserName(rs.getString("UserName"));
				userDetailVO.setUserFirstName(rs.getString("ManagerName"));
				userDetailVO.setUserExist(true);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		return userDetailVO;
	}

	@Override
	public synchronized UserDetailVO getUserEmployeeDetails(String userName,
			String password, String userType) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : getUserEmployeeDetails Starting");

		UserDetailVO userDetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = LoginDetails.GET_EMPLOYEE_DETAILS;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			logger.error(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userDetailVO = new UserDetailVO();
				userDetailVO.setUserCode(rs.getString("userCode"));
				userDetailVO.setUserName(rs.getString("UserName"));
				userDetailVO.setUserFirstName(rs.getString("EmployeeName"));
				userDetailVO.setEmployeeImage(rs.getString("Employee_image"));
				userDetailVO.setUserExist(true);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		return userDetailVO;
	}

	@Override
	public synchronized UserDetailVO getUserDirectorDetails(String userName,
			String password, String userType) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : getUserDirectorDetails Starting");
		UserDetailVO userDetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;

		HashMap<String, String> permissionmap = new HashMap<String, String>();

		String query = LoginDetails.GET_DIRECTOR_DETAILS;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			logger.error(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userDetailVO = new UserDetailVO();
				userDetailVO.setUserCode(rs.getString("userCode"));
				userDetailVO.setUserName(rs.getString("UserName"));
				userDetailVO.setUserFirstName(rs.getString("DirectorName"));
				userDetailVO.setUserExist(true);

				userDetailVO.setLocation("LOC1");
				userDetailVO.setLocationName("LOC1");
				userDetailVO.setGroupCode("GRP1");
				userDetailVO.setGroupName("GRP1");
				userDetailVO.setRoleCode(rs.getString("roleCode"));
				userDetailVO.setRoleName(rs.getString("RoleName"));

				pstmt1=con.prepareStatement(LoginDetails.GET_PERMISSIONS);
				pstmt1.setString(1, rs.getString("roleCode"));
				
				rs1=pstmt1.executeQuery();
			
				
				ArrayList<String> permissionCodeArray=new ArrayList<String>();
				ArrayList<String> permissionShortNamArray=new ArrayList<String>();
				ArrayList<String> pPermissionNameArray=new ArrayList<String>();
				ArrayList<String> pPermissionStatusArray=new ArrayList<String>();
				
				while(rs1.next()){
					
					permissionCodeArray.add(rs1.getString("PermissionCode"));
					permissionShortNamArray.add(rs1.getString("shortName"));
					pPermissionNameArray.add(rs1.getString("permission"));
					pPermissionStatusArray.add(rs1.getString("isApplicable"));
					
					
				}
					
					
				for (int i = 0; i < permissionCodeArray.size(); i++) {
					
					permissionmap.put(permissionShortNamArray.get(i),
							pPermissionStatusArray.get(i));
				}

				userDetailVO.setPermissionCodeList(permissionCodeArray);
				userDetailVO.setPermissionNameList(pPermissionNameArray);
				userDetailVO.setPermissionShortNameList(permissionShortNamArray);

				userDetailVO.setPermissionmap(permissionmap);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				
				
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		return userDetailVO;
	}
	
	
	public HashMap<String,String> getLoginEmployeePrivilegesDao(String employeeId){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : getUserDirectorDetails Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		HashMap<String, String> privilagesmap = new HashMap<String, String>();
		
		String query=null;
		
		if(employeeId.toString().trim().substring(0, 3).equalsIgnoreCase("EMP")){
			
			 query = LoginDetails.GET_EMPLOYEE_PREVILLEGES;
			
		}else if(employeeId.toString().trim().substring(0, 3).equalsIgnoreCase("MAN")){
			
			 query = LoginDetails.GET_MANAGER_PREVILLEGES;
			
		}else if(employeeId.toString().trim().substring(0, 3).equalsIgnoreCase("DIR")){
			
			 query = LoginDetails.GET_DIRECTOR_PREVILLEGES;
			
		}else{
			
			 query = LoginDetails.GET_ADMIN_PREVILLEGES;
			
			
		}

		
		boolean flag=false;
		try {
			
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, employeeId);
			logger.error(pstmt);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				flag=true;
				
				if(!(rs.getString("director").equalsIgnoreCase(""))){
					
					privilagesmap.put(MessageConstants.DIRECTOR,"Y");
				}else{
					
					privilagesmap.put(MessageConstants.DIRECTOR,"N");
				}
				
				
				
				if(!(rs.getString("admin").equalsIgnoreCase(""))){
					
					privilagesmap.put(MessageConstants.ADMIN,"Y");
				}else{
					
					privilagesmap.put(MessageConstants.ADMIN,"N");
				}
				
				
				if(!(rs.getString("manager").equalsIgnoreCase(""))){
					
					privilagesmap.put(MessageConstants.MANAGER,"Y");
				}else{
					
					privilagesmap.put(MessageConstants.MANAGER,"N");
				}
				
				}
			
			
			if(!flag){
				
				privilagesmap.put(MessageConstants.DIRECTOR,"N");
				privilagesmap.put(MessageConstants.ADMIN,"N");
				privilagesmap.put(MessageConstants.MANAGER,"N");
			}
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : getUserDirectorDetails Ending");
		
		return privilagesmap;
	}
	

}