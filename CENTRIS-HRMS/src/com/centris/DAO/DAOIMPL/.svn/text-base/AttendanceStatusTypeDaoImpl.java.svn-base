package com.centris.DAO.DAOIMPL;

import com.centris.DAO.AttendanceStatusTypeDao;
import com.centris.DAO.DBService;
import com.centris.POJO.AttendanceStatusTypePojo;
import com.centris.VO.AttendanceStatusTypeVO;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendanceStatusType;
import com.centris.util.constants.MessageConstants;
import com.centris.util.HelperClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class AttendanceStatusTypeDaoImpl extends DBService implements
		AttendanceStatusTypeDao {

	private static Logger logger = Logger
			.getLogger(AttendanceStatusTypeDaoImpl.class);

	public String AddDetails(AttendanceStatusTypePojo attendanceStatusTypePojo) {
		String successmessage = "";
		Connection con = null;
		PreparedStatement psmt = null;
		int count = 0;
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : AddDetails Starting");
		try {
			if (!validationStatusType(attendanceStatusTypePojo
					.getStatustypename())) {
				con = getConnection();
				psmt = con
						.prepareStatement(AttendanceStatusType.ADD_ATTENDANCE_STATUS_DETAILS);
				psmt.setString(1, attendanceStatusTypePojo.getStatustypecode());
				psmt.setString(2, attendanceStatusTypePojo.getStatustypename());
				psmt.setString(3, attendanceStatusTypePojo.getShortname());
				psmt.setString(4, attendanceStatusTypePojo.getDescription());
				psmt.setString(5, attendanceStatusTypePojo.getCreatedby());
				count = psmt.executeUpdate();
				if (count > 0) {
					successmessage = MessageConstants.ADD_SUCECCESS_MESSAGE;
				} else {
					successmessage = MessageConstants.ADD_FAILD_MESSAGE;
				}

			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (psmt != null && (!psmt.isClosed())) {
					psmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : AddDetails Ending");

		return successmessage;
	}

	public List<AttendanceStatusTypeVO> getAttendanceStatusDetails() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : getAttendanceStatusDetails Starting");

		List<AttendanceStatusTypeVO> attendancestatuslist = new ArrayList<AttendanceStatusTypeVO>();
		try {
			con = getConnection();
			psmt = con
					.prepareStatement(AttendanceStatusType.GET_ATTENDANCE_STATUS_DETAILS);
			rs = psmt.executeQuery();
			while (rs.next()) {
				AttendanceStatusTypeVO attendancestatustypeVO = new AttendanceStatusTypeVO();

				attendancestatustypeVO.setStatustypecode(rs
						.getString("ASTCode"));
				attendancestatustypeVO.setStatustypename(rs
						.getString("StatusType"));
				attendancestatustypeVO.setShortname(rs.getString("ShortName"));
				attendancestatustypeVO.setDescription(rs
						.getString("Description"));
				attendancestatuslist.add(attendancestatustypeVO);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (psmt != null && (!psmt.isClosed())) {
					psmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : getAttendanceStatusDetails Ending");

		return attendancestatuslist;
	}

	public boolean deleteAttendanceStatus(String[] attendancestatuscode) {
		boolean status = false;
		int count = 0;
		Connection con = null;
		PreparedStatement psmt = null;

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : deleteAttendanceStatus Starting");
		try {
			con = getConnection();
			for (int i = 0; i < attendancestatuscode.length; i++) {
				psmt = con
						.prepareStatement(AttendanceStatusType.DELETE_ATTENDANCE_STATUS_DETAILS);
				psmt.setString(1, attendancestatuscode[i]);
				count = psmt.executeUpdate();
			}
			if (count > 0) {
				status = true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (psmt != null && (!psmt.isClosed())) {
					psmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : deleteAttendanceStatus Ending");

		return status;
	}

	public List<AttendanceStatusTypeVO> editAttendanceStatus(
			String attendancecode) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : editAttendanceStatus Starting");

		List<AttendanceStatusTypeVO> editstatuslist = new ArrayList<AttendanceStatusTypeVO>();
		try {
			con = getConnection();
			psmt = con
					.prepareStatement(AttendanceStatusType.EDIT_ATTENDANCE_STATUS_DETAILS);
			psmt.setString(1, attendancecode);
			rs = psmt.executeQuery();
			while (rs.next()) {
				AttendanceStatusTypeVO attendancestatustypeVO = new AttendanceStatusTypeVO();

				attendancestatustypeVO.setStatustypecode(rs
						.getString("ASTCode"));
				attendancestatustypeVO.setStatustypename(rs
						.getString("StatusType"));
				attendancestatustypeVO.setShortname(rs.getString("ShortName"));
				attendancestatustypeVO.setDescription(rs
						.getString("Description"));
				editstatuslist.add(attendancestatustypeVO);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (psmt != null && (!psmt.isClosed())) {
					psmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : editAttendanceStatus Ending");

		return editstatuslist;
	}

	public boolean UpdateAttendanceStatus(
			AttendanceStatusTypePojo attendanceStatusTypePojo) {
		boolean status = false;
		boolean Status2 = false;
		Connection con = null;
		PreparedStatement psmt = null;
		int count = 0;
		ResultSet rs = null;

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : UpdateAttendanceStatus Starting");
		try {
			con = getConnection();
			psmt = con
					.prepareStatement(AttendanceStatusType.VALIDATE_STATUS_TYPE_AND_SHORT_NAME);
			psmt.setString(1, attendanceStatusTypePojo.getStatustypename());
			psmt.setString(2, attendanceStatusTypePojo.getStatustypecode());
			psmt.setString(3, attendanceStatusTypePojo.getShortname());
			psmt.setString(4, attendanceStatusTypePojo.getStatustypecode());
			rs = psmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				Status2 = true;
			}
			if (!Status2) {
				con = getConnection();
				psmt = con
						.prepareStatement(AttendanceStatusType.UPDATE_ATTENDANCE_STATUS_DETAILS);

				psmt.setString(1, attendanceStatusTypePojo.getStatustypename());
				psmt.setString(2, attendanceStatusTypePojo.getShortname());
				psmt.setString(3, attendanceStatusTypePojo.getDescription());
				psmt.setString(4, attendanceStatusTypePojo.getUpdatedby());
				psmt.setTimestamp(5, HelperClass.getCurrentTimestamp());
				psmt.setString(6, attendanceStatusTypePojo.getStatustypecode());
				count = psmt.executeUpdate();
				if (count > 0) {
					status = true;
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (psmt != null && (!psmt.isClosed())) {
					psmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : UpdateAttendanceStatus Ending");

		return status;
	}

	public boolean validationStatusType(String statustypename) {
		boolean status = false;
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : validationStatusType Starting");
		try {
			con = getConnection();
			psmt = con
					.prepareStatement(AttendanceStatusType.VALIDATE_ATTENDANCE_STATUS_TYPE);
			psmt.setString(1, statustypename);
			rs = psmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (psmt != null && (!psmt.isClosed())) {
					psmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : validationStatusType Ending");
		return status;
	}

	public boolean validationshortname(String shortname) {
		boolean status = false;
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : validationshortname Starting");
		try {
			con = getConnection();
			psmt = con
					.prepareStatement(AttendanceStatusType.VALIDATE_ATTENDANCE_SHORT_NAME);
			psmt.setString(1, shortname);
			rs = psmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (psmt != null && (!psmt.isClosed())) {
					psmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeDaoImpl : validationshortname Ending");

		return status;
	}
}
