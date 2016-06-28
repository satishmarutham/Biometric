package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.EmployeeManagerMappingDao;
import com.centris.VO.EmployeeManagerMappingVO;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.EmployeeManagerMapping;
import com.centris.util.constants.MessageConstants;

public class EmployeeManagerMappingDaoImpl extends DBService implements EmployeeManagerMappingDao{
	
	private static Logger logger = Logger.getLogger(EmployeeManagerMappingDaoImpl.class);

	public ArrayList<EmployeeManagerMappingVO> getAvailableEmployees() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingDaoImpl:getAvailableEmployees  Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs_employee= null;
		 ArrayList<EmployeeManagerMappingVO> employeelist = new  ArrayList<EmployeeManagerMappingVO>();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeManagerMapping.GET_EMPLOYEES);
			rs_employee = pstmt.executeQuery();
			while (rs_employee.next()) {
				EmployeeManagerMappingVO employeemangermapVO = new EmployeeManagerMappingVO();
				employeemangermapVO.setEmployeeId(rs_employee.getString("EMPID"));
				employeemangermapVO.setEmployeeName(rs_employee.getString("firstname"));
			
				employeelist.add(employeemangermapVO);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs_employee != null && !rs_employee.isClosed()) {
					rs_employee.close();
				}

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in EmployeeManagerMappingDaoImpl  : getAvailableEmployees   Ending");
		return employeelist;
	}


	public String saveemployeeMangerMapping(String managerId,
			JSONArray jsonproject, String username) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingDaoImpl :saveemployeeMangerMapping  Starting");
	
		Connection connection = null;
		PreparedStatement pstmt_insertmap = null;
		String result = null;
		PreparedStatement pstmt_delete = null;
		
		try {
			connection = getConnection();
			
			pstmt_delete=connection
					.prepareStatement(EmployeeManagerMapping.DELETE_EMPLOYEE_MANAGER_MAP);
			
			pstmt_delete.setString(1, managerId);
			pstmt_delete.executeUpdate();
			if (jsonproject.length() == 0) {
				return "success";
			}	
		    pstmt_insertmap = connection
					.prepareStatement(EmployeeManagerMapping.INSERT_EMPLOYEE_MANAGER);
	
		for (int i = 0; i < jsonproject.length(); i++) {
		
			pstmt_insertmap.setString(1, (String)jsonproject.get(i));
			pstmt_insertmap.setString(2, managerId);
			pstmt_insertmap.setString(3, username);
			int value=pstmt_insertmap.executeUpdate();
				result = (value > 0) ? "success" : "failure";
				
		}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
						
				if (pstmt_delete != null && !pstmt_delete.isClosed()) {
					pstmt_delete.close();
				}
				
				if (pstmt_insertmap != null && !pstmt_insertmap.isClosed()) {
					pstmt_insertmap.close();
				}
			
				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in Control in EmployeeManagerMappingDaoImpl :saveemployeeMangerMapping   Ending");
		return result;
			
	}

	

	public ArrayList<EmployeeManagerMappingVO> getMappedEmployees(
			String managerId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingDaoImpl:getMappedEmployees  Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs_employee= null;
		 ArrayList<EmployeeManagerMappingVO> employeelist = new  ArrayList<EmployeeManagerMappingVO>();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeManagerMapping.GET_MAPPED_EMPLOYEES);
			pstmt.setString(1,managerId);
			
			rs_employee = pstmt.executeQuery();
			while (rs_employee.next()) {
				EmployeeManagerMappingVO employeemangermapVO = new EmployeeManagerMappingVO();
				employeemangermapVO.setEmployeeId(rs_employee.getString("EMPID"));
				employeemangermapVO.setEmployeeName(rs_employee.getString("firstname"));
			
				employeelist.add(employeemangermapVO);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs_employee != null && !rs_employee.isClosed()) {
					rs_employee.close();
				}

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in EmployeeManagerMappingDaoImpl  : getMappedEmployees   Ending");
		return employeelist;
		
	}

}
