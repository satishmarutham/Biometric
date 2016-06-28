package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.LeaveBankDao;

import com.centris.POJO.LeaveBankPojo;
import com.centris.VO.LeaveBankVo;
import com.centris.VO.getAccYearVO;

import com.centris.form.GetLeavesform;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;

import com.centris.util.constants.MessageConstants;

public class LeaveBankDAOImpl extends DBService implements LeaveBankDao {

	private static Logger logger = Logger.getLogger(LeaveBankDAOImpl.class);

	public ArrayList<getAccYearVO> getYear() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:getYear Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<getAccYearVO> arr = new ArrayList<getAccYearVO>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.GET_ACC_YEAR);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				getAccYearVO vo = new getAccYearVO();
				vo.setAccyearcode(rs.getString("AccyearCode"));
				vo.setAccyear(rs.getString("AccadamicYear"));
				arr.add(vo);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

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
				+ " Control in LeaveBankDAOImpl:getyear Ending");
		return arr;
	}

	public String addLeave(LeaveBankPojo pojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:addLeave Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		String addstatus = "";
		if (!(addvalid(pojo.getAccyearCode()))) {

			try {
				con = getConnection();
				pstmt = con.prepareStatement(SQLutilConstants.ADD_LEAVE);
				pstmt.setString(1, pojo.getAccyearCode());
				pstmt.setDouble(2, pojo.getTotal_leaves());
				pstmt.setDouble(3, pojo.getAllowed_per_month());
				pstmt.setString(4, pojo.getCreatedBy());
				pstmt.setDouble(5, pojo.getSl());
				pstmt.setDouble(6, pojo.getPl());
				pstmt.setDouble(7, pojo.getCl());
				
				int res = pstmt.executeUpdate();
				if (res > 0) {
					addstatus = "Added successfully";
				}

			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			} finally {
				try {

					if (pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}

					if (con != null && (!con.isClosed())) {
						con.close();

					}

				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle.getMessage(), sqle);
				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error(e1.getMessage(), e1);
				}
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOImpl:addLeave Ending");
		return addstatus;
	}

	public ArrayList<LeaveBankVo> getAllLeaves() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:getAllLeaves Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LeaveBankVo> leavelist = new ArrayList<LeaveBankVo>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.GET_ALL_LEAVES);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				LeaveBankVo vo = new LeaveBankVo();
				vo.setSno(rs.getString("sno"));
				vo.setAccyear(rs.getString("AccadamicYear"));
				vo.setTotal_leaves(rs.getString("total_leaves"));
				vo.setAllowed_per_month(rs.getString("allowed_per_month"));
				vo.setSl(rs.getDouble("SL"));
				vo.setPl(rs.getDouble("PL"));
				vo.setCl(rs.getDouble("CL"));
				
				leavelist.add(vo);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

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
				+ " Control in LeaveBankDAOImpl:getAllLeaves Ending");
		return leavelist;
	}

	public ArrayList<LeaveBankVo> editLeave(GetLeavesform frm, String sno) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:editLeave Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LeaveBankVo> specificleavelist = new ArrayList<LeaveBankVo>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.GET_SPECIFIC_LEAVE);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				LeaveBankVo vo = new LeaveBankVo();
				vo.setSno(rs.getString("sno"));

				vo.setAccyear(rs.getString("AccyearCode"));
				vo.setTotal_leaves(rs.getString("total_leaves"));
				vo.setAllowed_per_month(rs.getString("allowed_per_month"));
				vo.setSl(rs.getDouble("SL"));
				vo.setPl(rs.getDouble("PL"));
				vo.setCl(rs.getDouble("CL"));
				
				specificleavelist.add(vo);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

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
				+ " Control in LeaveBankDAOImpl:editLeave Ending");
		return specificleavelist;
	}

	public String updateLeave(LeaveBankPojo pojo) {
		System.out.println("update.............leave");
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:updateLeave Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		String updatestatus = "";
		if (!(validUpdateLeave(pojo.getAccyearCode(), pojo.getSno()))) {
			try {
				con = getConnection();
				pstmt = con.prepareStatement(SQLutilConstants.UPDATE_LEAVE);
				pstmt.setString(1, pojo.getAccyearCode());
				pstmt.setDouble(2, pojo.getTotal_leaves());
				pstmt.setDouble(3, pojo.getAllowed_per_month());
				pstmt.setString(4, pojo.getModifiedBy());
				pstmt.setDouble(5, pojo.getSl());
				pstmt.setDouble(6, pojo.getPl());
				pstmt.setDouble(7, pojo.getCl());
				
				pstmt.setString(8, pojo.getSno());
				int res = pstmt.executeUpdate();
				if (res > 0) {
					updatestatus = "updated successfully";
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			} finally {
				try {

					if (pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}

					if (con != null && (!con.isClosed())) {
						con.close();

					}

				} catch (SQLException sqle) {

					logger.error(sqle.getMessage(), sqle);
					sqle.printStackTrace();

				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error(e1.getMessage(), e1);
				}
			}
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in LeaveBankDAOImpl:updateLeave Ending");
		}
		return updatestatus;
	}

	public Boolean addvalid(String accyear) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:addLeaveValidation Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Boolean status = false;
		try {
			con = getConnection();

			pstmt = con.prepareStatement(SQLutilConstants.COUNT_LEAVE_YEAR);
			pstmt.setString(1, accyear);

			res = pstmt.executeQuery();
			int yearCount = 0;
			while (res.next()) {
				yearCount = res.getInt(1);

			}
			if (yearCount > 0) {
				status = true;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}
			} catch (SQLException sql) {
				logger.error(sql.getMessage(), sql);
				sql.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOImpl:addLeaveValidation  Ending");
		return status;
	}

	public Boolean validUpdateLeave(String accyear, String sno) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:updateLeaveValidation Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Boolean status = false;
		int sno1 = Integer.parseInt(sno);
		try {
			con = getConnection();

			pstmt = con
					.prepareStatement(SQLutilConstants.UPDATE_COUNT_LEAVE_YEAR);
			pstmt.setString(1, accyear);
			pstmt.setInt(2, sno1);
			res = pstmt.executeQuery();
			int yearCount = 0;
			while (res.next()) {
				yearCount = res.getInt(1);

			}
			if (yearCount > 0) {
				status = true;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}
			} catch (SQLException sql) {
				logger.error(sql.getMessage(), sql);
				sql.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOImpl:updateLeaveValidation  Ending");
		return status;
	}

	public Boolean deleteLeave(String[] deletelist) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:delete Leave Starting");

		Connection con = null;
		PreparedStatement pstmt = null;

		Boolean deletestatus = false;

		try {
			con = getConnection();
			for (int i = 0; i < deletelist.length; i++) {
				pstmt = con.prepareStatement(SQLutilConstants.DELETE_LEAVE);
				pstmt.setString(1, deletelist[i]);
				int count = pstmt.executeUpdate();
				if (count > 0) {
					deletestatus = true;
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}
			} catch (SQLException sql) {
				logger.error(sql.getMessage(), sql);
				sql.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOImpl:deleteLeave  Ending");
		return deletestatus;
	}

}
