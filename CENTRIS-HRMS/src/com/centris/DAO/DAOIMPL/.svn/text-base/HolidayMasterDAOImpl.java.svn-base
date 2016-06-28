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
import com.centris.DAO.HolidayMasterDAO;
import com.centris.POJO.HolidayMasterPojo;
import com.centris.VO.AuditReportDeptVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.HolidayMasterVO;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.form.HolidayMasterForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.HolidayMaster;
import com.centris.util.constants.MessageConstants;

/**
 * @author swathi
 * 
 */
public class HolidayMasterDAOImpl extends DBService implements HolidayMasterDAO {

	private static Logger logger = Logger.getLogger(HolidayMasterDAOImpl.class);

	// To get all years
	public synchronized ArrayList<HolidayMasterVO> getYearDAO() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :getYearDAO: Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		HolidayMasterVO holidayMasterVO = null;
		ArrayList<HolidayMasterVO> listHolidayMasterVO = new ArrayList<HolidayMasterVO>();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(HolidayMaster.GET_ALL_YEARS);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				holidayMasterVO = new HolidayMasterVO();
				holidayMasterVO.setYear(rs.getString("AccadamicYear"));
				holidayMasterVO.setAccademicYearCode(rs.getString("AccyearCode"));
				
				
				listHolidayMasterVO.add(holidayMasterVO);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: getYearDAO : Ending");
		return listHolidayMasterVO;
	}

	// Add group holidays
	public synchronized String addHolidayDaoImpl(
			HolidayMasterForm holidayMasterForm, String username) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :addHolidayDaoImpl: Starting");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ArrayList<AuditReportDeptVO> departmentList = new ArrayList<AuditReportDeptVO>();
		Connection connection = null;
		ResultSet rs = null;
        int count=0;
        String result=null;
		try {

			connection = getConnection();
			pstmt1 = connection
					.prepareStatement(HolidayMaster.GET_HOLIDAY_COUNT);
			pstmt = connection.prepareStatement(HolidayMaster.INSERT_HOLIDAY);

			String client = holidayMasterForm.getClient();
		
			String year = holidayMasterForm.getYear();
			String[] date = holidayMasterForm.getDate();
			String[] weekday = holidayMasterForm.getWeekday();
			String[] holiday = holidayMasterForm.getHoliday();

		
				for (int i = 0; i < date.length; i++) {

					if (date[i] != "") {
						pstmt1.setString(1,
								HelperClass.convertUIToDatabase(date[i]));
						pstmt1.setString(2,	client);
						rs = pstmt1.executeQuery();

						rs.next();
						if (rs.getInt(1) == 0) {

							pstmt.setString(1, year);
							pstmt.setString(2,
									HelperClass.convertUIToDatabase(date[i]));
							pstmt.setString(3, weekday[i]);
							pstmt.setString(4, holiday[i]);
							pstmt.setString(5, username);
							pstmt.setString(6, client);
							
							count=pstmt.executeUpdate();
							
							
						}else{
							
							count=1;
						}
					}
				}
				
				
				
				if (count > 0) {

					result = "success";

				} else {

					result = "fail";
				}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				if (pstmt1 != null && (!pstmt1.isClosed())) {

					pstmt1.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: addHolidayDaoImpl : Ending");

		return result;
	}

	// add single holiday
	public synchronized String addSingleHolidayDetailDaoImpl(
			HolidayMasterPojo hpojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :addSingleHolidayDetailDaoImpl: Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		int count = 0;
		String success = null;
		try {
			connection = getConnection();
		
			
			pstmt = connection.prepareStatement(HolidayMaster.INSERT_HOLIDAY);
			 
						pstmt.setString(1, hpojo.getYear());
						pstmt.setString(2, HelperClass
								.convertUIToDatabase(hpojo.getDate()));
						pstmt.setString(3, hpojo.getWeekday());
						pstmt.setString(4, hpojo.getHoliday());
						pstmt.setString(5, hpojo.getCreatedby());
						pstmt.setString(6, hpojo.getClientCode());
						count = pstmt.executeUpdate();
				
			
                  
			if (count > 0) {

				success = "success";

			} else {

				success = "fail";
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				
				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: addSingleHolidayDetailDaoImpl : Ending");

		return success;
	}

	public synchronized String updateHolidayDaoImpl(HolidayMasterPojo hpojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :updateHolidayDaoImpl: Starting");
		PreparedStatement pstmt = null;
		int no = 0;
		String Status = null;
		Connection connection = null;

		try {
			connection = getConnection();

			pstmt = connection.prepareStatement(HolidayMaster.UPDATE_HOLIDAY);
			pstmt.setString(1,hpojo.getWeekday());
			pstmt.setString(2,hpojo.getHoliday());
			pstmt.setString(3,hpojo.getModifiedby());
			pstmt.setString(4,hpojo.getClientCode());
			pstmt.setString(5,HelperClass.convertUIToDatabase(hpojo.getDate()));
			pstmt.setString(6,hpojo.getHiddenclient());

			no = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && (!pstmt.isClosed())) {

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
		if (no > 0) {

			Status = "success";
		} else {

			Status = "fail";
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl: updateHolidayDaoImpl : Ending");

		return Status;
	}

	public synchronized List<HolidayMasterVO> editHolidayDetailDaoImpl(
			String holidaydate,String clientCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :editHolidayDetailDaoImpl: Starting");

		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<HolidayMasterVO> holidayMasterVOList = new ArrayList<HolidayMasterVO>();
		Connection connection = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(HolidayMaster.GET_EDIT_HOLIDAY);
			pstmt.setString(1, HelperClass.convertUIToDatabase(holidaydate));
			pstmt.setString(2,clientCode);
			

			rs = pstmt.executeQuery();

			while (rs.next()) {

				HolidayMasterVO holidayMasterVO = new HolidayMasterVO();
				holidayMasterVO.setHolidaysName(rs.getString("HOLIDAY_NAME"));
				holidayMasterVO.setDate(HelperClass.convertDatabaseToUI(rs
						.getString("HOLIDAY_DATE")));
				holidayMasterVO.setWeekDay(rs.getString("WEEKDAY"));
				holidayMasterVO.setClientCode(rs.getString("ClientCode"));
				holidayMasterVO.setClientName(rs.getString("ClientName"));
				holidayMasterVOList.add(holidayMasterVO);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: editHolidayDetailDaoImpl : Ending");

		return holidayMasterVOList;

	}

	public synchronized ArrayList<HolidayMasterVO> getHolidayDetailDaoImpl(
			String holidayyear,String clientCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :getHolidayDetailDaoImpl: Starting");

		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<HolidayMasterVO> holidayMasterVOList = new ArrayList<HolidayMasterVO>();
		Connection connection = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(HolidayMaster.GET_ALL_HOLIDAYS);

			
			pstmt.setString(1,holidayyear);
			pstmt.setString(2,clientCode);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				HolidayMasterVO holidayMasterVO = new HolidayMasterVO();
				holidayMasterVO.setHolidaysName(rs.getString("HOLIDAY_NAME"));
				holidayMasterVO.setDate(HelperClass.convertDatabaseToUI(rs
						.getString("HOLIDAY_DATE")));
				holidayMasterVO.setWeekDay(rs.getString("WEEKDAY"));
				holidayMasterVO.setClientCode(rs.getString("ClientCode"));
				holidayMasterVO.setClientName(rs.getString("ClientName"));
				
				
				holidayMasterVOList.add(holidayMasterVO);
			}
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: getHolidayDetailDaoImpl : Ending");

		return holidayMasterVOList;

	}

	public synchronized boolean deleteSingleHoliday(String depdate, String clientcode) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :deleteSingleHoliday: Starting");

		PreparedStatement pstmt = null;
		boolean status = false;
		Connection connection = null;
         int count=0;
		try {

			connection = getConnection();
			pstmt = connection
					.prepareStatement(HolidayMaster.DELETE_SINGLE_HOLIDAY);
			pstmt.setString(1, HelperClass.convertUIToDatabase(depdate));
			pstmt.setString(2, clientcode);
			count = pstmt.executeUpdate();
			
			if (count > 0){

				status = true;
			}else{
				status = false;
			}
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: deleteSingleHoliday : Ending");

		return status;

	}

	public synchronized ArrayList<HolidayMasterVO> getDistinctHolidayList(String clientcode, String year) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :getDistinctHolidayList: Starting");
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<HolidayMasterVO> holidayList = new ArrayList<HolidayMasterVO>();
		Connection connection = null;
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(HolidayMaster.GET_DISTINCT_HOLIDAYLIST);
			pstmt.setString(1, clientcode);
			pstmt.setString(2, year);
			rs = pstmt.executeQuery();
             
			while (rs.next()) {
				HolidayMasterVO vo = new HolidayMasterVO();
				vo.setDate(HelperClass.convertDatabaseToUI(rs.getString("HOLIDAY_DATE")));
				holidayList.add(vo);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {

			try {

				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: getDistinctHolidayList : Ending");
		return holidayList;

	}

	public synchronized String dateValidate(String dateval,String clientCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :dateValidate: Starting");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int datevalexit = 0;
		String status = null;
		Connection connection = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(HolidayMaster.DATE_VALIDATE);
			pstmt.setString(1,HelperClass.convertUIToDatabase(dateval));
			pstmt.setString(2,clientCode);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				datevalexit = rs.getInt(1);
			}

			if (datevalexit > 0) {

				status = "exit";
			} else {
				status = "not exit";

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: dateValidate : Ending");

		return status;
	}
	public synchronized ArrayList<HolidayMasterVO> getClientDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :getClientDetails: Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		HolidayMasterVO holidayMasterVO = null;
		ArrayList<HolidayMasterVO> listHolidayMasterVO = new ArrayList<HolidayMasterVO>();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(HolidayMaster.GET_CLIENT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				holidayMasterVO = new HolidayMasterVO();
				holidayMasterVO.setClientName(rs.getString("ClientName"));
				holidayMasterVO.setClientCode(rs.getString("ClientCode"));
				listHolidayMasterVO.add(holidayMasterVO);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: getClientDetails : Ending");
		return listHolidayMasterVO;
	}

	public String getAcadamicYear(String acadamicyear) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in HolidayMasterDAOImpl :getAcadamicYear: Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		String acadamicYear=null;
		
			try {
			connection = getConnection();
			pstmt = connection.prepareStatement(HolidayMaster.GET_ACADAMIC_YEAR);
			pstmt.setString(1, acadamicyear);
			rs = pstmt.executeQuery();

			while (rs.next()) {
						acadamicYear=rs.getString("AccadamicYear");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {

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
				+ " Control in HolidayMasterDAOImpl: getAcadamicYear : Ending");
		
		return acadamicYear;
	}

	

	

}
