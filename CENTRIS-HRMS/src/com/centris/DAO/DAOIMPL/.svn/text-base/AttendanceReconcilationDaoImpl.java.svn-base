package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.AttendanceReconcilationDao;
import com.centris.DAO.DBService;
import com.centris.VO.AttendanceReconcilationVO;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GroupMasterVO;
import com.centris.VO.LocationMasterVo;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.ProjectFilterVo;
import com.centris.VO.ShiftMasterVO;
import com.centris.action.AttendanceReConcilationAction;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendanceReconcilationSqlUtil;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class AttendanceReconcilationDaoImpl extends DBService implements
		AttendanceReconcilationDao {
	


	private static Logger logger = Logger.getLogger(AttendanceReconcilationDaoImpl.class);

	public synchronized ArrayList<AttendanceReconcilationVO> getEmployeeAttendance(String employeeId,
			String date) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReconcilationDaoImpl:getEmployeeAttendance Starting");
		Connection con = null;
		PreparedStatement psmt_attendance = null;
		ResultSet rs_attendance=null;
		ArrayList<AttendanceReconcilationVO> empInfoList = new ArrayList<AttendanceReconcilationVO>();

		try {

			con = getConnection();
			String temp_emp= "'" + employeeId.replaceAll(",", "','") + "'";
			
			psmt_attendance = con.prepareStatement("select a.EMPID,a.Attedence_Status,e.First_Name from hrms_employee_attendance a left outer join hrms_employee e on e.EMPID=a.EMPID  where a.EMPID in ("+temp_emp+") and a.Attedence_Status='Absent' and a.isRecouncil='N' and  a.Attendence_Date=? order by a.EMPID asc");
			psmt_attendance.setDate(1,HelperClass.getSqlDate(date));
			rs_attendance = psmt_attendance.executeQuery();
			
			System.out.println("psmt_attendance"+psmt_attendance);
		
				while (rs_attendance.next()) {
				AttendanceReconcilationVO attendanceReconcilationVO = new AttendanceReconcilationVO();
					attendanceReconcilationVO.setEmpid(rs_attendance.getString("EMPID"));
					attendanceReconcilationVO.setEmpname(rs_attendance.getString("First_Name"));
					attendanceReconcilationVO.setStatus(rs_attendance
							.getString("Attedence_Status"));
					empInfoList.add(attendanceReconcilationVO);
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}finally{
			try{
				
				if(rs_attendance != null && (!rs_attendance.isClosed())){
					rs_attendance.close();
				
				 }
				 if(psmt_attendance != null && (!psmt_attendance.isClosed())){
					 psmt_attendance.close();
				
				 }
				 if(con != null && (!con.isClosed())){
					 con.close();
				 }
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		
		 JLogger.log(0, JDate.getTimeString(new Date())
	  				+ MessageConstants.END_POINT);
	  		logger.info(JDate.getTimeString(new Date())
	  				+ " Control in  AttendanceReconcilationDaoImpl:getEmployeeAttendance Ending");
		return empInfoList;

	}

	

	public synchronized String attendnaceReconcilInsertion(String[] employeeids,
			String[] paybleVal, String[] notpaybleVal, String reason,
			String shortname, java.sql.Date dbdate, String createdby) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReconcilationDaoImpl:attendnaceReconcilInsertion Starting");
		Connection con = null;
		PreparedStatement reconcileinsertpsmt = null;
		PreparedStatement isRconciledpstmt = null;
		int updateresult=0;
		int result;
		String status=null;
		
		
		try {
			con = getConnection();
			reconcileinsertpsmt = con
					.prepareStatement(AttendanceReconcilationSqlUtil.INSERT_ATTENDANCE_RECONCIL);
			for (int i = 0; i < employeeids.length; i++) {
				for (int j = i; j <= i; j++) {
					for (int k = j; k <= j; k++) {

						if (!paybleVal[j].equalsIgnoreCase("")) {
							reconcileinsertpsmt.setString(1, employeeids[i]);
							reconcileinsertpsmt.setDate(2, dbdate);
							reconcileinsertpsmt.setString(3,MessageConstants.ATTENDANCE_PRESENT);
							reconcileinsertpsmt.setString(4, reason);
							reconcileinsertpsmt.setString(5, shortname);
							reconcileinsertpsmt.setString(6, createdby);
							result = reconcileinsertpsmt.executeUpdate();
							
							if (result > 0) {

								isRconciledpstmt = con
										.prepareStatement(AttendanceReconcilationSqlUtil.UPDATE_ATTENDANCE_ISRECONCILED);

								isRconciledpstmt.setString(1, createdby);
								isRconciledpstmt.setString(2,employeeids[i]);
								isRconciledpstmt.setDate(3, dbdate);
								updateresult = isRconciledpstmt.executeUpdate();
								
								 if(isRconciledpstmt != null && (!isRconciledpstmt.isClosed())){
									 isRconciledpstmt.getConnection().close();
									}
							}
						} else {
							reconcileinsertpsmt.setString(1, employeeids[i]);
							reconcileinsertpsmt.setDate(2, dbdate);
							reconcileinsertpsmt.setString(3, MessageConstants.ATTENDANCE_ABSENT);
							reconcileinsertpsmt.setString(4, reason);
							reconcileinsertpsmt.setString(5, shortname);
							reconcileinsertpsmt.setString(6,createdby);
							result = reconcileinsertpsmt.executeUpdate();
							
							if (result > 0) {
								
								isRconciledpstmt = con
										.prepareStatement(AttendanceReconcilationSqlUtil.UPDATE_ATTENDANCE_ISRECONCILED);
							    isRconciledpstmt.setString(1, createdby);
								isRconciledpstmt.setString(2,employeeids[i]);
								isRconciledpstmt.setDate(3, dbdate);
								updateresult = isRconciledpstmt.executeUpdate();
								
								 if(isRconciledpstmt != null && (!isRconciledpstmt.isClosed())){
									 isRconciledpstmt.getConnection().close();
									}
							}
						}

					}
				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
			updateresult=0;
		}finally{
			try{
				 if(reconcileinsertpsmt != null && (!reconcileinsertpsmt.isClosed())){
					 reconcileinsertpsmt.close();
					}
				 if(isRconciledpstmt != null && (!isRconciledpstmt.isClosed())){
					 isRconciledpstmt.close();
					}
				 if(con != null && (!con.isClosed())){
					 con.close();
					}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		
		if (updateresult > 0) {
			status = "true";
		} else {
			status = "false";
		}
		
	
		JLogger.log(0, JDate.getTimeString(new Date())
  				+ MessageConstants.END_POINT);
  		logger.info(JDate.getTimeString(new Date())
  				+ " Control in  AttendanceReconcilationDaoImpl:attendnaceReconcilInsertion Ending");
 		
  		
  		return status;
	}

	

	
	
	public ArrayList<DepartmentFilterVO> getAllDepartments() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReconcilationDaoImpl: getAllDepartments Starting");
		Connection con = null;
		PreparedStatement pst_dept = null;
		ResultSet rs_dept=null;
		ArrayList<DepartmentFilterVO> deptlist =new ArrayList<DepartmentFilterVO>();
		try {
			con = getConnection();
			pst_dept = con.prepareStatement(AttendanceReconcilationSqlUtil.GET_ALL_DEPT);
			rs_dept = pst_dept.executeQuery();
			while (rs_dept.next()) {
				DepartmentFilterVO deptvo = new DepartmentFilterVO();
				deptvo.setDeptid(rs_dept.getString("DEPT_ID"));
				deptvo.setDeptname(rs_dept.getString("DEPT_NAME"));
				
				deptlist.add(deptvo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}finally{
			try{
				
				if(rs_dept != null && (!rs_dept.isClosed())){
					rs_dept.close();
				
				 }
				 if(pst_dept != null && (!pst_dept.isClosed())){
					 pst_dept.close();
				
				 }
				 if(con != null && (!con.isClosed())){
					 con.close();
				
				 }
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
  				+ MessageConstants.END_POINT);
  		logger.info(JDate.getTimeString(new Date())
  				+ " Control in  AttendanceReconcilationDaoImpl : getAllDepartments Ending");

		return deptlist;
	}


	public ArrayList<ManagerFilterVO> getManagersByDept(String depts) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReconcilationDaoImpl: getManagersByDept Starting");
		Connection con = null;
		PreparedStatement pst_mang = null;
		ResultSet rs_mang=null;
		ArrayList<ManagerFilterVO> manglist =new ArrayList<ManagerFilterVO>();
		try {
			con = getConnection();
			String temp_dept = "'" + depts.replaceAll(",", "','") + "'";
			pst_mang = con.prepareStatement("select ManagerCode,FirstName from hrms_manager where isActive='Y' and ManagerCode in (select UserCode from hrms_department_mapping where DepartmentCode in("+temp_dept+"))");
			rs_mang = pst_mang.executeQuery();
			
			while (rs_mang.next()) {
				ManagerFilterVO managvo = new ManagerFilterVO();
				managvo.setManagerid(rs_mang.getString("ManagerCode"));
				managvo.setManagername(rs_mang.getString("FirstName"));
				
				manglist.add(managvo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}finally{
			try{
				
				if(rs_mang != null && (!rs_mang.isClosed())){
					rs_mang.close();
				
				 }
				 if(pst_mang != null && (!pst_mang.isClosed())){
					 pst_mang.close();
				
				 }
				 if(con != null && (!con.isClosed())){
					 con.close();
				
				 }
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
  				+ MessageConstants.END_POINT);
  		logger.info(JDate.getTimeString(new Date())
  				+ " Control in  AttendanceReconcilationDaoImpl : getManagersByDept Ending");

		return manglist;
	}

	



	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReconcilationDaoImpl: getEmployeesByMang Starting");
		Connection con = null;
		PreparedStatement pst_emp= null;
		ResultSet rs_emp=null;
		ArrayList<EmployeeFilterVO> emplist =new ArrayList<EmployeeFilterVO>();
		try {
			con = getConnection();
			String temp_manager= "'" + manager.replaceAll(",", "','") + "'";
			pst_emp = con.prepareStatement("select EMPID,First_Name from hrms_employee where isActive='Y' and EMPID in(select EmployeeId from hrms_employee_manager_mapping where ManagerId in ("+temp_manager+") ) ");
			rs_emp = pst_emp.executeQuery();
			
			System.out.println("pst_proj ----"+pst_emp);
			
			while (rs_emp.next()) {
				EmployeeFilterVO empvo = new EmployeeFilterVO();
				empvo.setEmpid(rs_emp.getString("EMPID"));
				empvo.setEmpname(rs_emp.getString("First_Name"));
				
				emplist.add(empvo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}finally{
			try{
				
				if(rs_emp != null && (!rs_emp.isClosed())){
					rs_emp.close();
				
				 }
				 if(pst_emp != null && (!pst_emp.isClosed())){
					 pst_emp.close();
				
				 }
				 if(con != null && (!con.isClosed())){
					 con.close();
				 }
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
  				+ MessageConstants.END_POINT);
  		logger.info(JDate.getTimeString(new Date())
  				+ " Control in  AttendanceReconcilationDaoImpl : getEmployeesByMang Ending");

  		return emplist;
	}

	

	

	
	
}
