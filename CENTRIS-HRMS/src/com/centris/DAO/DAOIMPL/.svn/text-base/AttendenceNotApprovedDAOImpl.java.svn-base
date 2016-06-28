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

import com.centris.DAO.AttendenceNotApprovedDAO;
import com.centris.DAO.DBService;
import com.centris.VO.AttendenceNotApprovedVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendenceDetails;
import com.centris.util.constants.MessageConstants;

public class AttendenceNotApprovedDAOImpl extends DBService implements AttendenceNotApprovedDAO {
	private static Logger logger = Logger.getLogger(AttendenceNotApprovedDAOImpl.class);
	@Override
	public List<AttendenceNotApprovedVO> getAttendanceNotApprovedByManager(String managerCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceNotApprovedDAOImpl: getAttendanceNotApprovedByManager: Starting");

		Connection connection=null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		List<AttendenceNotApprovedVO> attendenceNotApprovedVOList= new ArrayList<AttendenceNotApprovedVO>();

		try {
			
			connection=getConnection();
			pstm = connection.prepareStatement(AttendenceDetails.GET_ATTENDANCE_NOT_APPROVED_BY_MANAGER);
			pstm.setString(1, managerCode);
			System.out.println(pstm);
			rs = pstm.executeQuery();
			AttendenceNotApprovedVO attendenceNotApprovedVO=null;
			
			int count=1;
			while(rs.next()){
				attendenceNotApprovedVO= new AttendenceNotApprovedVO();
				attendenceNotApprovedVO.setSno(count+"");
				attendenceNotApprovedVO.setEmpId(rs.getString("EMPID"));
				attendenceNotApprovedVO.setEmpName(rs.getString("First_Name"));
				attendenceNotApprovedVO.setStartDate(HelperClass.convertDatabaseToUI(rs.getString("startDate")));
				attendenceNotApprovedVO.setEndDate(HelperClass.convertDatabaseToUI(rs.getString("endDate")));
				String datetime= rs.getString("PostedTime");
				attendenceNotApprovedVO.setPostedDate(datetime.substring(0,datetime.indexOf(".")));
				count++;
				attendenceNotApprovedVOList.add(attendenceNotApprovedVO);
			}

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
	
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if (pstm != null && (!pstm.isClosed())) {

					pstm.close();
				}
				
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e1) {

				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceNotApprovedDAOImpl: getAttendanceNotApprovedByManager: Ending");

		return attendenceNotApprovedVOList;
	}
	
	public int getNotApprovedEmployeeCount(String managerCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceNotApprovedDAOImpl: getNotApprovedEmployeeCount: Starting");

		Connection connection=null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		int count =0;
		try {
			
			connection=getConnection();
			pstm = connection.prepareStatement(AttendenceDetails.GET_NOT_APPROVED_ATTENDANCE_COUNT);
			pstm.setString(1, managerCode);
			
			System.out.println(pstm);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				count=rs.getInt(1);
			}

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
	
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if (pstm != null && (!pstm.isClosed())) {

					pstm.close();
				}
				
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e1) {

				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceNotApprovedDAOImpl: getNotApprovedEmployeeCount: Ending");

		return count;
	}
	
	

}
