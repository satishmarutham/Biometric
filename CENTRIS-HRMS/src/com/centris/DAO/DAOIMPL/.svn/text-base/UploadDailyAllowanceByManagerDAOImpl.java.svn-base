package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.UploadDailyAllowanceByManagerDAO;
import com.centris.VO.DailyAllownaceDownloadVo;
import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Manager;
import com.centris.util.constants.MessageConstants;

public class UploadDailyAllowanceByManagerDAOImpl extends DBService implements
		UploadDailyAllowanceByManagerDAO {
	private static Logger logger = Logger
			.getLogger(UploadDailyAllowanceByManagerDAOImpl.class);

	public synchronized String insertDailyAllowance(
			Map<String, Object> employeeMap, String uploadedFilePath) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadDailyAllowanceByManagerDAOImpl: insertDailyAllowance Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String response = "Not Inserted";
		try {
			List<DailyEmployeeAllowanceVO> employeeDailyAllowanceList = (List<DailyEmployeeAllowanceVO>) employeeMap
					.get("EmployeeList");
			String date = (String) employeeMap.get("date");
			String[] allowanceDateManipulation = date.split(":");
			String managerCode = (String) employeeMap.get("ManagerCode");
			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(Manager.INSERT_DAILY_ALLOWANCE);
			for (int i = 0; i < employeeDailyAllowanceList.size(); i++) {

				if ((employeeDailyAllowanceList.get(i).getCode() != null)
						&& (employeeDailyAllowanceList.get(i).getNames() != null)) {

					int allowanceCount = checkAllowanceDetails(
							conn,
							employeeDailyAllowanceList.get(i).getCode().trim(),
							HelperClass.convertTitleToDatabase(
									allowanceDateManipulation[1]).trim());
					if (allowanceCount == 0) {
						pstmt.setString(1, employeeDailyAllowanceList.get(i)
								.getCode().trim());
						pstmt.setString(2, employeeDailyAllowanceList.get(i)
								.getNames().trim());
						pstmt.setString(3, employeeDailyAllowanceList.get(i)
								.getHdfcNo().trim());
						pstmt.setString(4, employeeDailyAllowanceList.get(i)
								.getAmount().trim());
						pstmt.setString(5, employeeDailyAllowanceList.get(i)
								.getProjectManager().trim());
						pstmt.setString(6, employeeDailyAllowanceList.get(i)
								.getClient().trim());
						pstmt.setString(7, employeeDailyAllowanceList.get(i)
								.getProject().trim());
						pstmt.setString(8, employeeDailyAllowanceList.get(i)
								.getTeamLead().trim());
						pstmt.setString(9, employeeDailyAllowanceList.get(i)
								.getLocation().trim());
						pstmt.setString(10, employeeDailyAllowanceList.get(i)
								.getRemarks().trim());
						pstmt.setString(
								11,
								HelperClass.convertTitleToDatabase(
										allowanceDateManipulation[1]).trim());
						pstmt.setTimestamp(12,
								HelperClass.getCurrentTimestamp());
						pstmt.setString(13, managerCode);

						int count = pstmt.executeUpdate();
						if (count > 0)
							response = "Inserted";
					} else {
						pstmt = conn
								.prepareStatement(Manager.UPDATE_DAILY_ALLOWANCE);

						pstmt.setString(1, employeeDailyAllowanceList.get(i)
								.getNames().trim());
						pstmt.setString(2, employeeDailyAllowanceList.get(i)
								.getHdfcNo().trim());
						pstmt.setString(3, employeeDailyAllowanceList.get(i)
								.getAmount().trim());
						pstmt.setString(4, employeeDailyAllowanceList.get(i)
								.getProjectManager().trim());
						pstmt.setString(5, employeeDailyAllowanceList.get(i)
								.getClient().trim());
						pstmt.setString(6, employeeDailyAllowanceList.get(i)
								.getProject().trim());
						pstmt.setString(7, employeeDailyAllowanceList.get(i)
								.getTeamLead().trim());
						pstmt.setString(8, employeeDailyAllowanceList.get(i)
								.getLocation().trim());
						pstmt.setString(9, employeeDailyAllowanceList.get(i)
								.getRemarks().trim());
						pstmt.setTimestamp(10,
								HelperClass.getCurrentTimestamp());
						pstmt.setString(11, managerCode);
						pstmt.setString(
								12,
								HelperClass.convertTitleToDatabase(
										allowanceDateManipulation[1]).trim());
						pstmt.setString(13, employeeDailyAllowanceList.get(i)
								.getCode().trim());
						int count = pstmt.executeUpdate();
						if (count > 0)
							response = "Inserted";
					}
				}

			}
			if (response.equalsIgnoreCase("Inserted")) {
				int pathCount = checkPathDetails(conn, managerCode, HelperClass
						.convertTitleToDatabase(allowanceDateManipulation[1])
						.trim());

				if (pathCount == 0) {
					pstmt = conn
							.prepareStatement(Manager.INSERT_DAILY_ALLOWANCE_FILEPATH);
					pstmt.setString(1, HelperClass.getCurrentSqlDate()
							.toString().trim());
					pstmt.setString(2, managerCode.trim());
					pstmt.setString(3, uploadedFilePath.trim());

					int count = pstmt.executeUpdate();
					if (count > 0) {
						conn.commit();
					}
				} else {
					pstmt = conn
							.prepareStatement(Manager.UPDATE_DAILY_ALLOWANCE_FILEPATH);
					pstmt.setString(1, uploadedFilePath.trim());
					pstmt.setString(2, HelperClass.getCurrentSqlDate()
							.toString().trim());
					pstmt.setString(3, managerCode.trim());

					int count = pstmt.executeUpdate();
					if (count > 0) {
						conn.commit();
					}
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);

			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
			}
			e.printStackTrace();
			response = "Not Inserted";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
			}
			response = "Not Inserted";
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (!conn.isClosed()) {
					conn.close();
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
				+ " Control in  UploadDailyAllowanceByManagerDAOImpl:insertDailyAllowance Ending");
		return response;
	}

	public List<DailyAllownaceDownloadVo> getUploadedFileDetails(
			String managerCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadDailyAllowanceByManagerDAOImpl : getUploadedFileDetails Starting");

		List<DailyAllownaceDownloadVo> uploadedFileDetails = new ArrayList<DailyAllownaceDownloadVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		int sno = 0;
		try {
			conn = getConnection();

			pstmt = conn
					.prepareStatement(Manager.SELECT_ALL_DAILY_ALLOWANCE_FILEPATH);
			pstmt.setString(1, managerCode.trim());
			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) {
				DailyAllownaceDownloadVo voObj = new DailyAllownaceDownloadVo();
				sno = sno + 1;
				voObj.setSlno(String.valueOf(sno));
				voObj.setUploadedDate(HelperClass.convertDatabaseToUI(rst
						.getString("date")));
				voObj.setUploadedFilePath(rst.getString("filePath"));
				voObj.setUploadedTime(HelperClass
						.convertDatabaseToUIWithDateTime(rst
								.getString("uploadedTime")));
				uploadedFileDetails.add(voObj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  UploadDailyAllowanceByManagerDAOImpl : getUploadedFileDetails Ending");
		return uploadedFileDetails;
	}

	public int checkPathDetails(Connection conn, String managerCode, String Date) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadDailyAllowanceByManagerDAOImpl : checkPathDetails Starting");

		Connection con = conn;
		PreparedStatement pstmt = null;
		int count = 0;
		try {

			pstmt = con.prepareStatement(Manager.CHECK_PATH_ADDED_OR_NOT);
			pstmt.setString(1, HelperClass.getCurrentSqlDate().toString()
					.trim());
			pstmt.setString(2, managerCode.trim());
			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) {
				count = rst.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  UploadDailyAllowanceByManagerDAOImpl : checkPathDetails Ending");
		return count;
	}

	public int checkAllowanceDetails(Connection conn, String employeeCode,
			String Date) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadDailyAllowanceByManagerDAOImpl : checkAllowanceDetails Starting");

		Connection con = conn;
		PreparedStatement pstmt = null;
		int count = 0;
		try {

			pstmt = con.prepareStatement(Manager.CHECK_ALLOWANCEDETAILSCount);

			pstmt.setString(1, employeeCode.trim());
			pstmt.setString(2, Date.trim());
			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) {
				count = rst.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  UploadDailyAllowanceByManagerDAOImpl : checkAllowanceDetails Ending");
		return count;
	}
}