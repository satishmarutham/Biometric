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
import com.centris.DAO.ManagerDirectorMappingDAO;
import com.centris.VO.ManagerDirectorMappingVo;
import com.centris.service.serviceImpl.ManagerDirectorMappingServiceImpl;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.ManagerDirectorMappingSQL;
import com.centris.util.constants.MessageConstants;

public class ManagerDirectorMappingDAOIMPL extends DBService implements
		ManagerDirectorMappingDAO {

	private static Logger logger = Logger
			.getLogger(ManagerDirectorMappingServiceImpl.class);

	public ArrayList<ManagerDirectorMappingVo> getDirector() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingDAOIMPL : getDirector Starting");
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs_employee = null;
		ArrayList<ManagerDirectorMappingVo> directorlist = new ArrayList<ManagerDirectorMappingVo>();
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ManagerDirectorMappingSQL.GET_DIRECTORS);
			rs_employee = pstmt.executeQuery();
			while (rs_employee.next()) {
				ManagerDirectorMappingVo VO = new ManagerDirectorMappingVo();
				VO.setDirectorId(rs_employee.getString("DirectorCode"));
				VO.setDirectorname(rs_employee.getString("First_Name") + "-"
						+ rs_employee.getString("bioid"));
				VO.setBioid(rs_employee.getString("bioid"));

				directorlist.add(VO);
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
				+ " Control in ManagerDirectorMappingDAOIMPL : getDirector Ending");
		return directorlist;

	}

	public ArrayList<ManagerDirectorMappingVo> getAvailableManagers() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingDAOIMPL : getAvailableManagers Starting");
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs_employee = null;
		ArrayList<ManagerDirectorMappingVo> directorlist = new ArrayList<ManagerDirectorMappingVo>();
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ManagerDirectorMappingSQL.GET_AVAILABLE_MANAGERS);
			rs_employee = pstmt.executeQuery();
			while (rs_employee.next()) {
				ManagerDirectorMappingVo VO = new ManagerDirectorMappingVo();
				VO.setManagerId(rs_employee.getString("ManagerCode"));
				VO.setManagerName(rs_employee.getString("FirstName") + "-"
						+ rs_employee.getString("bioid"));

				directorlist.add(VO);
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
				+ " Control in ManagerDirectorMappingDAOIMPL : getAvailableManagers Ending");
		return directorlist;
	}

	public String savemanagerDirectorMapping(String directorId,
			JSONArray jsonproject, String username) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingDAOIMPL :savemanagerDirectorMapping  Starting");

		Connection connection = null;
		PreparedStatement pstmt_insertmap = null;
		String result = null;
		PreparedStatement pstmt_delete = null;

		try {
			connection = getConnection();

			pstmt_delete = connection
					.prepareStatement(ManagerDirectorMappingSQL.DELETE_MANAGER_DIRECTOR_MAP);

			pstmt_delete.setString(1, directorId);
		    pstmt_delete.executeUpdate();

			if (jsonproject.length() == 0) {
				return "success";
			}
			pstmt_insertmap = connection
					.prepareStatement(ManagerDirectorMappingSQL.INSERT_MANAGER_DIRECTOR);

			for (int i = 0; i < jsonproject.length(); i++) {

				pstmt_insertmap.setString(1, (String) jsonproject.get(i));
				pstmt_insertmap.setString(2, directorId);
				pstmt_insertmap.setString(3, username);
				int value = pstmt_insertmap.executeUpdate();

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
				+ " Control in Control in ManagerDirectorMappingDAOIMPL :saveemployeeMangerMapping   Ending");
		return result;

	}
	
	
	public ArrayList<ManagerDirectorMappingVo> getMappedManagers(String directorId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingDAOIMPL : getMappedManagers Starting");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		Connection connection = null;
		ResultSet rs_employee = null;
		ResultSet rs_manager = null;
		
		ArrayList<ManagerDirectorMappingVo> mappedmanagers = new ArrayList<ManagerDirectorMappingVo>();
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ManagerDirectorMappingSQL.GET_MAPPED_MANAGERS);
			pstmt.setString(1,directorId);
			rs_employee = pstmt.executeQuery();
			while (rs_employee.next()) {
			
				pstmt1 = connection
						.prepareStatement(ManagerDirectorMappingSQL.GET_MAPPED_MANAGER_DETAILS);
				pstmt1.setString(1,rs_employee.getString("ManagerCode"));
				rs_manager=pstmt1.executeQuery();
				while(rs_manager.next())
				{
				ManagerDirectorMappingVo VO = new ManagerDirectorMappingVo();
				VO.setManagerName(rs_manager.getString("First_Name")+"-"+rs_manager.getString("bioid"));
				VO.setManagerId(rs_employee.getString("ManagerCode"));
				mappedmanagers.add(VO);
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
				+ " Control in ManagerDirectorMappingDAOIMPL : getMappedManagers Ending");
		return mappedmanagers;

	}

}
