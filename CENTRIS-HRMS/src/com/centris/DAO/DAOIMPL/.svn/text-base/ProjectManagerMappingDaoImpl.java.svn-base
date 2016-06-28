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
import com.centris.DAO.ProjectManagerMappingDao;
import com.centris.VO.ProjectHeadVo;
import com.centris.VO.ProjectManagerMappingVO;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.ProjectManagerMappingSQLutil;
import com.centris.util.constants.MessageConstants;

public class ProjectManagerMappingDaoImpl extends DBService implements
		ProjectManagerMappingDao {

	private static Logger logger = Logger
			.getLogger(ProjectManagerMappingDaoImpl.class);

	public  ArrayList<ProjectManagerMappingVO> getManager() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingDaoImpl:getManager Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rsmanager = null;
		ArrayList<ProjectManagerMappingVO> managerlist = new ArrayList<ProjectManagerMappingVO>();

		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ProjectManagerMappingSQLutil.GET_MANAGER);
			rsmanager = pstmt.executeQuery();

			while (rsmanager.next()) {
				ProjectManagerMappingVO managerVO = new ProjectManagerMappingVO();
				managerVO.setManagerId(rsmanager.getString("ManagerCode"));
				managerVO.setManagerName(rsmanager.getString("managername"));
				managerlist.add(managerVO);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rsmanager != null && !rsmanager.isClosed()) {
					rsmanager.close();
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
				+ " Control in ProjectManagerMappingDaoImpl:getManager Ending");
		return managerlist;
	}
	
	
	public  ArrayList<ProjectManagerMappingVO> getDirector() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingDaoImpl:getDirector Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rsmanager = null;
		ArrayList<ProjectManagerMappingVO> managerlist = new ArrayList<ProjectManagerMappingVO>();

		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ProjectManagerMappingSQLutil.GET_DIRECTOR);
			rsmanager = pstmt.executeQuery();

			while (rsmanager.next()) {
				ProjectManagerMappingVO managerVO = new ProjectManagerMappingVO();
				managerVO.setManagerId(rsmanager.getString("DirectorCode"));
				managerVO.setManagerName(rsmanager.getString("directorname"));
				managerlist.add(managerVO);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rsmanager != null && !rsmanager.isClosed()) {
					rsmanager.close();
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
				+ " Control in ProjectManagerMappingDaoImpl:getDirector Ending");
		return managerlist;
	}
	
	

	public  ArrayList<ProjectManagerMappingVO> getProject() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingDaoImpl:getProject Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rsproject = null;
		ArrayList<ProjectManagerMappingVO> projectlist = new ArrayList<ProjectManagerMappingVO>();
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ProjectManagerMappingSQLutil.GET_PROJECT_DATA);
			rsproject = pstmt.executeQuery();
			while (rsproject.next()) {
				ProjectManagerMappingVO projectVO = new ProjectManagerMappingVO();
				projectVO.setProjectId(rsproject.getString("ProjectCode"));
				projectVO.setProjectName(rsproject.getString("ProjectRefCode"));
			
				projectlist.add(projectVO);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rsproject != null && !rsproject.isClosed()) {
					rsproject.close();
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
				+ " Control in ProjectManagerMappingDaoImpl:getProject Ending");
		return projectlist;
	}

	public  String saveProjectManagerMapping(String managerId,
			JSONArray jsonproject, String username) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingDaoImpl:saveProjectManagerMapping Starting");
		PreparedStatement pstmtdelete = null;
		Connection connection = null;
		String result = null;
		PreparedStatement pstmtdelete1 = null;
		int value=0;
		try {
			
			
			connection = getConnection();
		
			pstmtdelete = connection
					.prepareStatement(ProjectManagerMappingSQLutil.DELETE_PROJECT_MANAGER);
			pstmtdelete.setString(1, managerId);
			pstmtdelete.executeUpdate();
			if (jsonproject.length() == 0) {
				return "success";
			}
					
			pstmtdelete1 = connection
					.prepareStatement(ProjectManagerMappingSQLutil.INSERT_PROJECT_MANAGER);
			for (int i = 0; i < jsonproject.length(); i++) {
					pstmtdelete1.setString(1, managerId);
					pstmtdelete1.setString(2, (String) jsonproject.get(i));
					pstmtdelete1.setString(3, username);
					value = pstmtdelete1.executeUpdate();
					
			}
		
			if(value>0){
				
				result = "success";
			}else{
				
				result = "failure";
			}
		

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
						
				if (pstmtdelete1 != null && !pstmtdelete1.isClosed()) {
					pstmtdelete1.close();
				}
							
				if (pstmtdelete != null && !pstmtdelete.isClosed()) {
					pstmtdelete.close();
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
				+ " Control in ProjectManagerMappingDaoImpl:saveProjectManagerMapping  Ending");
		return result;
	}

	public  ArrayList<ProjectManagerMappingVO> getMappedProject(
			String managerId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingDaoImpl:getMappedProject Starting");
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rsmappedproject = null;

		ArrayList<ProjectManagerMappingVO> mappedprojectlist = new ArrayList<ProjectManagerMappingVO>();
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ProjectManagerMappingSQLutil.GET_MAPPED_PROJECT);
			pstmt.setString(1, managerId);
			rsmappedproject = pstmt.executeQuery();
			
			System.out.println("pstmt"+pstmt);
			
			while (rsmappedproject.next()) {
				ProjectManagerMappingVO mappedprojectVO = new ProjectManagerMappingVO();
				mappedprojectVO.setProjectId(rsmappedproject
						.getString("ProjectCode"));
				mappedprojectVO.setProjectName(rsmappedproject
						.getString("ProjectRefCode"));
				mappedprojectlist.add(mappedprojectVO);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rsmappedproject != null && !rsmappedproject.isClosed()) {
					rsmappedproject.close();
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
				+ " Control in  ProjectManagerMappingDaoImpl:getMappedProject Ending");
		return mappedprojectlist;
	}
	
	
	public  ArrayList<ProjectHeadVo> getProjectHead() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingDaoImpl : getProjectHead Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rsmanager = null;
		ArrayList<ProjectHeadVo> managerlist = new ArrayList<ProjectHeadVo>();

		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ProjectManagerMappingSQLutil.GET_PROJECTHEAD);
			rsmanager = pstmt.executeQuery();

			while (rsmanager.next()) {
				ProjectHeadVo headVo = new ProjectHeadVo();
				headVo.setProjectHeadCode(rsmanager.getString("ProjectHeadCode"));
				headVo.setProjectHeadName(rsmanager.getString("FirstName"));
				managerlist.add(headVo);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rsmanager != null && !rsmanager.isClosed()) {
					rsmanager.close();
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
				+ " Control in ProjectManagerMappingDaoImpl : getProjectHead Ending");
		return managerlist;
	}
	
	

	public String getManagerIdByEmp(String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingDaoImpl : getManagerIdByEmp Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rsmanager = null;
		String magrId=null;
		
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ProjectManagerMappingSQLutil.GET_MGRID_BY_EMPID);
			pstmt.setString(1, empId);
			rsmanager = pstmt.executeQuery();

			while (rsmanager.next()) {
				
				magrId=rsmanager.getString("ManagerCode");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rsmanager != null && !rsmanager.isClosed()) {
					rsmanager.close();
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
				+ " Control in ProjectManagerMappingDaoImpl : getManagerIdByEmp Ending");
		return magrId;
	}


	public ArrayList<ProjectManagerMappingVO> getAllProjects() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingDaoImpl: getAllProjects Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rsproject = null;
		ArrayList<ProjectManagerMappingVO> projectlist = new ArrayList<ProjectManagerMappingVO>();
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(ProjectManagerMappingSQLutil.GET_ALL_PROJECTS);
			rsproject = pstmt.executeQuery();
			while (rsproject.next()) {
				
				ProjectManagerMappingVO projectVO = new ProjectManagerMappingVO();
				
				projectVO.setProjectId(rsproject.getString("ProjectCode"));
				projectVO.setProjectName(rsproject.getString("ProjectRefCode"));
			
				projectlist.add(projectVO);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rsproject != null && !rsproject.isClosed()) {
					rsproject.close();
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
				+ " Control in ProjectManagerMappingDaoImpl: getAllProjects Ending");
	
		
		return projectlist;
		
	}
	
	

}
