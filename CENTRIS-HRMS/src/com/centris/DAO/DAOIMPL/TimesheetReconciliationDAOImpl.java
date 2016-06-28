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
import com.centris.DAO.TimesheetReconciliationDAO;
import com.centris.POJO.TimesheetReconcilationPojo;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.TimesheetReconciliationVO;
import com.centris.form.TimesheetReconciliationForm;
import com.centris.util.EmpDetails;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendanceReconcilationSqlUtil;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.SQLUtils.TimesheetReconcilSqlUtil;
import com.centris.util.constants.MessageConstants;

public class TimesheetReconciliationDAOImpl extends DBService implements
		TimesheetReconciliationDAO {
	
	private static Logger logger = Logger.getLogger(TimesheetReconciliationDAOImpl.class);

	
	public synchronized List<TimesheetReconciliationVO> getTimesheetData(
			TimesheetReconcilationPojo timesheetReconcilationPojo,String[] empArray) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl:getTimesheetData Starting");
		PreparedStatement ps_timesheet = null;
		ResultSet rs_timesheet = null;
		Connection connection = null;
		List<TimesheetReconciliationVO> timesheetReconciliationList = new ArrayList<TimesheetReconciliationVO>();
		try {
			connection = getConnection();
		
			String empId=null;
			
			for(int i=0;i<empArray.length;i++){
				
				if(empId==null){
					
					empId=empArray[i];
				}else{
					
					empId=empId+","+empArray[i];
					
				}
			}
			
			
			String temp_emp= "'" +empId.replaceAll(",", "','") + "'";

			ps_timesheet = connection.prepareStatement("select a.EMPID,a.Attendence_Date,a.intime,a.outtime,a.totaltime,e.First_Name,e.bioid from hrms_employee_attendance a left outer join hrms_employee e on e.EMPID=a.EMPID where  a.EMPID in ("+temp_emp+") and a.Attendence_Date>=?and a.Attendence_Date<=? and  a.isPosted='Y' and a.isAproved='Y'  order by a.Attendence_Date");
			ps_timesheet.setString(1, timesheetReconcilationPojo.getSdate());
		    ps_timesheet.setString(2, timesheetReconcilationPojo.getEdate());
		    
		
			rs_timesheet = ps_timesheet.executeQuery();
	
				
			while (rs_timesheet.next()) {
				
				TimesheetReconciliationVO	timesheetReconciliationVO = new TimesheetReconciliationVO();
				
				timesheetReconciliationVO.setEmpId(rs_timesheet.getString("EMPID"));
				timesheetReconciliationVO.setAttendancedate(HelperClass.convertDatabaseToUI(rs_timesheet.getString("Attendence_Date")));
				timesheetReconciliationVO.setInTime(rs_timesheet.getString("intime"));
				timesheetReconciliationVO.setOutTime(rs_timesheet.getString("outtime"));
				timesheetReconciliationVO.setWorkingHours(rs_timesheet.getString("totaltime"));
				timesheetReconciliationVO.setEmpName(rs_timesheet.getString("First_Name"));
				timesheetReconciliationVO.setDate((timesheetReconcilationPojo.getSdate()));
				timesheetReconciliationVO.setBioid(rs_timesheet.getString("bioid"));
				
				timesheetReconciliationList.add(timesheetReconciliationVO);
			}

		} catch (SQLException se) {
			logger.error(se.getMessage(),se);
			se.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		} finally {

			try {

				if(rs_timesheet !=null && (!rs_timesheet.isClosed())){

					rs_timesheet.close();
				}

				if(ps_timesheet !=null && (!ps_timesheet.isClosed())){

					ps_timesheet.close();
				}

				if(connection !=null && (!connection.isClosed())){

					connection.close();
				}

			} catch (SQLException se) {
				logger.error(se.getMessage(),se);
				se.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl:getTimesheetData Ending");

		return timesheetReconciliationList;

	}

	public synchronized void updateTimeSheetDetails(String id, String intime,
			String outtime, String date, String mlate, String early,
			String totalhours, String workinghours) {/*
													 * 
													 * Connection con = null;
													 * PreparedStatement ps =
													 * null; PreparedStatement
													 * ps_timesheet = null;
													 * String shift_start =
													 * null; String shift_end =
													 * null; try { con =
													 * getConnection();
													 * 
													 * ps =
													 * con.prepareStatement(
													 * "select S.AI_SHIFT_LTOC,S.AI_SHIFT_END_TIME from ai_shift_deatails S join ai_emp_details E on S.AI_SHIFT_ID=E.SHIFT_ID where E.EMPID=?"
													 * ); ps.setString(1, id);
													 * ResultSet rst =
													 * ps.executeQuery(); while
													 * (rst.next()) {
													 * shift_start =
													 * rst.getString
													 * ("AI_SHIFT_LTOC");
													 * shift_end =
													 * rst.getString(
													 * "AI_SHIFT_END_TIME"); }
													 * 
													 * String actual_early_Time
													 * = null; String
													 * actual_late_Time = null;
													 * if
													 * (shift_start.compareTo(
													 * intime) < 0) {
													 * actual_late_Time =
													 * HelperClass.
													 * getTimeFormatinTimeDifference
													 * (shift_start, intime);
													 * 
													 * mlate = "1"; } else {
													 * actual_late_Time =
													 * "00:00:00"; mlate = "0";
													 * } if
													 * (shift_end.compareTo(
													 * outtime) > 0) {
													 * actual_early_Time =
													 * HelperClass.
													 * getTimeFormatinTimeDifference
													 * (outtime, shift_end);
													 * early = "1"; } else {
													 * actual_early_Time =
													 * "00:00:00"; early = "0";
													 * }
													 * System.out.println("latetime"
													 * +actual_late_Time);
													 * System
													 * .out.println("earlttime"
													 * +actual_early_Time);
													 * ps_timesheet = con
													 * .prepareStatement(
													 * "UPDATE ai_bio_timesheet SET IN_TIME=? ,OUT_TIME=?,MORNING_LATE=?, EVENING_EARLY=?,TOTAL_HOURS=?,TOTAL_WORKING_HOURS=?,LATE_TIME=?,EARLY_TIME=? WHERE  EMP_ID=? and ATTENDANCE_DATE=?"
													 * );
													 * ps_timesheet.setString(1,
													 * intime);
													 * ps_timesheet.setString(2,
													 * outtime);
													 * ps_timesheet.setString(3,
													 * mlate);
													 * ps_timesheet.setString(4,
													 * early);
													 * ps_timesheet.setString(5,
													 * totalhours);
													 * ps_timesheet.setString(6,
													 * workinghours);
													 * ps_timesheet.setString(7,
													 * actual_late_Time);
													 * ps_timesheet.setString(8,
													 * actual_early_Time);
													 * ps_timesheet.setString(9,
													 * id);
													 * ps_timesheet.setString
													 * (10, HelperClass.
													 * convertUIToDatabase
													 * (date));
													 * System.out.println
													 * (ps_timesheet); int n =
													 * ps_timesheet
													 * .executeUpdate();
													 * System.out.println(
													 * "Data Updated Successfully = "
													 * + n);
													 * 
													 * } catch (Exception e) {
													 * e.printStackTrace(); }
													 * finally { try {
													 * con.close(); } catch
													 * (SQLException e) { //
													 * TODO Auto-generated catch
													 * block
													 * e.printStackTrace(); } }
													 */
	}

	@Override
	public synchronized String updateTimeSheet(TimesheetReconcilationPojo timesheetPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl:updateTimeSheet Starting");

		Connection connection = null;
		String status = null;
		PreparedStatement ps_timesheet = null;
		ResultSet rst = null;
		try {
			connection = getConnection();
		/*	ps_timesheet = connection
					.prepareStatement(TimesheetReconcilSqlUtil.CHECK_TIMESHEET_EMPLOYEE);
			ps_timesheet.setString(1, timesheetPojo.getEmpId());
			ps_timesheet
					.setString(2, HelperClass
							.convertUIToDatabase(timesheetPojo
									.getDate()));
			rst = ps_timesheet.executeQuery();
			while (rst.next()) {
				if (rst.getInt(1) > 0) {*/

					ps_timesheet = connection
							.prepareStatement(TimesheetReconcilSqlUtil.UPDATE_TIMESHEET);
					ps_timesheet.setString(1,timesheetPojo.getIntime());
					ps_timesheet.setString(2,timesheetPojo.getOuttime());
					ps_timesheet.setString(3,timesheetPojo.getWorkinghours());
					ps_timesheet.setString(4,timesheetPojo.getCurrentUserCode());
					ps_timesheet.setTimestamp(5, HelperClass.getCurrentTimestamp());
					ps_timesheet.setString(6, timesheetPojo.getEmpId());
					ps_timesheet.setString(7,HelperClass.convertUIToDatabase(timesheetPojo.getDate()));
					
					
					int n = ps_timesheet.executeUpdate();
					
					if (n > 0) {
						status = "Updated";
					} else {
						status = "Not Updated";
					}
					
				
					
				/*}*/ /*else {

					ps_timesheet = connection
							.prepareStatement(SQLutilConstants.INSERT_TIMESHEET);
					ps_timesheet.setString(1,
							timesheetReconciliationform.getId());
					ps_timesheet.setString(2, HelperClass
							.convertUIToDatabase(timesheetReconciliationform
									.getDate()));
					ps_timesheet.setString(3,
							timesheetReconciliationform.getInTime());
					ps_timesheet.setString(4,
							timesheetReconciliationform.getOutTime());
					ps_timesheet.setString(5,
							timesheetReconciliationform.getTotalhours());
					ps_timesheet.setString(6,
							timesheetReconciliationform.getWorkinghours());
					int n = ps_timesheet.executeUpdate();
					if (n > 0) {
						status = "Updated";
					} else {
						status = "Not Updated";
					}
					// closeAll(ps_timesheet);
				}*/
			/*}*/

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if(ps_timesheet !=null && (!ps_timesheet.isClosed())){
					ps_timesheet.getConnection().close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl:updateTimeSheet Ending");
		return status;
	}

	public synchronized ArrayList<EmpDetails> getAllEmpNames() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl:getAllEmpNames Starting");

		Connection connection = null;
		PreparedStatement ps_emp = null;
		ResultSet rs_emp = null;
		ArrayList<EmpDetails> al = new ArrayList<EmpDetails>();
		try {
			connection = getConnection();
			ps_emp = connection
					.prepareStatement(SQLutilConstants.AI_BIO_MONTH_REPORT_ALL);
			rs_emp = ps_emp.executeQuery();
			while (rs_emp.next()) {
				EmpDetails emp = new EmpDetails();
				emp.setId(rs_emp.getString(1));
				emp.setName(rs_emp.getString(2));
				al.add(emp);

			}

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if(ps_emp !=null && (!ps_emp.isClosed())){
					ps_emp.getConnection().close();
				}
			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl : getAllEmpNames Ending");
		return al;
	}

	
	public ArrayList<DepartmentFilterVO> getAllDepartments() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl: getAllDepartments Starting");
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
  				+ " Control in  TimesheetReconciliationDAOImpl : getAllDepartments Ending");

		return deptlist;
	}


	public ArrayList<ManagerFilterVO> getManagersByDept(String depts) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl: getManagersByDept Starting");
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
  				+ " Control in  TimesheetReconciliationDAOImpl : getManagersByDept Ending");

		return manglist;
	}


	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationDAOImpl: getEmployeesByMang Starting");
		Connection con = null;
		PreparedStatement pst_emp= null;
		ResultSet rs_emp=null;
		ArrayList<EmployeeFilterVO> emplist =new ArrayList<EmployeeFilterVO>();
		try {
			con = getConnection();
			String temp_manager= "'" + manager.replaceAll(",", "','") + "'";
			pst_emp = con.prepareStatement("select EMPID,First_Name from hrms_employee where isActive='Y' and EMPID in(select EmployeeId from hrms_employee_manager_mapping where ManagerId in ("+temp_manager+") ) ");
			rs_emp = pst_emp.executeQuery();
			
			
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
  				+ " Control in  TimesheetReconciliationDAOImpl : getEmployeesByMang Ending");

  		return emplist;
	}
}
