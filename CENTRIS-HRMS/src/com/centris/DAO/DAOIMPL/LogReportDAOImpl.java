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
import com.centris.DAO.LogReportDAO;
import com.centris.POJO.GroupLogReportPojo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GroupLogReportVo;
import com.centris.VO.LogReportVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.form.LogReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AjaxReportsUtil;
import com.centris.util.SQLUtils.LogReportSqlUtil;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.MonthReportSqlUtil;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class LogReportDAOImpl extends DBService implements LogReportDAO {
	private static Logger logger = Logger.getLogger(LogReportDAOImpl.class);

	@Override
	public synchronized List<EmployeeVO> getEmployeeByDesignation(
			String designationId) {
		List<EmployeeVO> empVOList = new ArrayList<EmployeeVO>();
		PreparedStatement ps_emp = null;
		ResultSet rs_emp = null;
		try {

			ps_emp = (PreparedStatement) new DBService()
					.getPreparedStatement(SQLutilConstants.GET_EMPLOYEE_BY_DESIGNATION);
			ps_emp.setString(1, designationId);
			rs_emp = ps_emp.executeQuery();
			EmployeeVO employeeVO = null;
			while (rs_emp.next()) {
				employeeVO = new EmployeeVO();
				employeeVO.setEmpid(rs_emp.getString("EMPID"));
				employeeVO.setEmpname(rs_emp.getString("EMPNAME"));
				empVOList.add(employeeVO);
			}

		} catch (SQLException sqle) {
			logger.error(sqle);
			sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				if(ps_emp!=null && (!ps_emp.isClosed())){
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

		return empVOList;
	}

	@Override
	public synchronized List<EmployeeVO> getMangerInfo() {
		List<EmployeeVO> empVOList = new ArrayList<EmployeeVO>();
		PreparedStatement ps_emp = null;
		ResultSet rs_emp = null;
		try {

			ps_emp = (PreparedStatement) new DBService()
					.getPreparedStatement(SQLutilConstants.GET_MANAGER_INFO);
			rs_emp = ps_emp.executeQuery();
			EmployeeVO employeeVO = null;
			while (rs_emp.next()) {
				employeeVO = new EmployeeVO();
				employeeVO.setEmpid(rs_emp.getString("EMPID"));
				employeeVO.setEmpname(rs_emp.getString("EMPNAME"));
				empVOList.add(employeeVO);
			}

		} catch (SQLException sqle) {
			logger.error(sqle);
			sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				if(ps_emp!=null && (!ps_emp.isClosed())){
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

		return empVOList;
	}

	@Override
	public synchronized List<LogReportVO> getLogReport(
			LogReportForm logReportForm) {
		List<LogReportVO> logReportVOList = new ArrayList<LogReportVO>();
		PreparedStatement ps_emp = null;
		ResultSet rs_emp = null;
		int count=0;
		try {

			ps_emp = (PreparedStatement) new DBService().getPreparedStatement(LogReportSqlUtil.GET_LOG_REPORT);
			
			for(int k=0;k<logReportForm.getEmployee().length;k++){
				
			int dateDiff = Integer.parseInt(HelperClass.getDateDifference(HelperClass.convertUIToDatabase(logReportForm.getStartDate()), HelperClass.convertUIToDatabase(logReportForm.getEndDate())));
			ps_emp.setString(1,HelperClass.convertUIToDatabase(logReportForm.getStartDate()).trim());
			ps_emp.setInt(2, dateDiff);
			ps_emp.setString(3, logReportForm.getEmployee()[k].trim());
			ps_emp.setString(4,HelperClass.convertUIToDatabase(logReportForm.getStartDate()).trim());
		    ps_emp.setString(5,HelperClass.convertUIToDatabase(logReportForm.getEndDate()).trim());
		    ps_emp.setString(6, logReportForm.getEmployee()[k].trim());
		
			System.out.println("Log Report::::"+ps_emp);
			
			
			rs_emp = ps_emp.executeQuery();
			LogReportVO logReportVO = null;
			int i = 1;
			int j = 1;
			String temp_date = "";


			while (rs_emp.next()) {
				
				count++;
				
				String date = rs_emp.getString("Date");
				if (date != null && !date.equals(temp_date)) {
					j = 1;
				}
				logReportVO = new LogReportVO();
				logReportVO.setsNo(count + "");
				logReportVO.setEmpId(rs_emp.getString("bioid"));
				logReportVO.setEmpName(rs_emp.getString("First_Name"));
				if (date != null) {
					logReportVO.setLogDate(HelperClass.convertDatabaseToUI(date));
				}

				//logReportVO.setLocation(rs_emp.getString("Location"));
				String logTime = rs_emp.getString("AI_EMP_TIME");
				
		
				if (logTime != null) {
					String logTimeArray[] = logTime.split(",");
					System.out.println("logTimeArray :"+logTimeArray[0]);
					logReportVO.setInTime(logTimeArray[0]);
					if (logTimeArray[logTimeArray.length - 1] != null
							&& logTimeArray[logTimeArray.length - 1]
									.equals(logTimeArray[0]))
						logReportVO.setOutTime("-");
					else {
						logReportVO
								.setOutTime(logTimeArray[logTimeArray.length - 1]);
					}
					logReportVO.setStatus("Present");
				}
				else {
					logReportVO.setInTime("-");
					logReportVO.setOutTime("-");
					logReportVO.setStatus("Absent");
				}

				logReportVOList.add(logReportVO);
				
				
				temp_date = date;
				i++;
				j++;
			}
			
			}

		} catch (SQLException sqle) {
			logger.error(sqle);
			sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				if(ps_emp!=null && (!ps_emp.isClosed())){
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
		return logReportVOList;
	}

	@Override
	public synchronized List<EmployeeVO> getEmpDetailsByLocation(
			LogReportForm logReportForm) {
		List<EmployeeVO> empVOList = new ArrayList<EmployeeVO>();
		PreparedStatement ps_emp = null;
		ResultSet rs_emp = null;
		try {

			ps_emp = (PreparedStatement) new DBService()
					.getPreparedStatement(SQLutilConstants.GET_EMPLOYEE_BY_LOCATION);
			ps_emp.setString(1, logReportForm.getLocation());
			ps_emp.setString(2, logReportForm.getGroup());
			rs_emp = ps_emp.executeQuery();
			EmployeeVO employeeVO = null;
			while (rs_emp.next()) {
				employeeVO = new EmployeeVO();
				employeeVO.setEmpid(rs_emp.getString("EMPID"));
				employeeVO.setEmpname(rs_emp.getString("EMPNAME"));
				empVOList.add(employeeVO);
			}

		} catch (SQLException sqle) {
			logger.error(sqle);
			sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				if(ps_emp!=null && (!ps_emp.isClosed())){
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

		return empVOList;
	}

	public synchronized List<GroupLogReportVo> getGroupLogReportDetails(
			GroupLogReportPojo groupLogReportPojo, String selectedDate,
			String location,Connection dbconn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		List<GroupLogReportVo> empList = new ArrayList<GroupLogReportVo>();
		try {
			conn = dbconn;
			pstmt = conn.prepareStatement(SQLutilConstants.GETGROUP_LOGREPORT);
			pstmt.setString(1, groupLogReportPojo.getGroupName().trim());
			pstmt.setString(2, location.trim());
			pstmt.setString(3, groupLogReportPojo.getDesignation().trim());
			pstmt.setString(4, groupLogReportPojo.getEmployeeName().trim());
			pstmt.setString(5, selectedDate.trim());
			rst = pstmt.executeQuery();
			while (rst.next()) {
				GroupLogReportVo grpVo = new GroupLogReportVo();
				grpVo.setReport_Date(rst.getString("DATE").trim());
				grpVo.setReport_Group(rst.getString("GroupName").trim());
				grpVo.setReport_Location(rst.getString("Location").trim());
				grpVo.setReport_TotalAbsent(rst.getString("TotalAbsent").trim());
				grpVo.setReport_TotalPresent(rst.getString("TotalPresent")
						.trim());
				grpVo.setReport_TotalEmployee(rst.getString("TotalEmployee")
						.trim());
				grpVo.setReport_LocationCode(rst.getString("LocationCode")
						.trim());
				empList.add(grpVo);
	
			}
			pstmt.close();
		} catch (SQLException se) {
			logger.error(se);
			se.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			
			
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		return empList;
	}

	public synchronized List<String> getAllLocationDetails(
			GroupLogReportPojo groupLogReportPojo,Connection conn) {
		List<String> empVOList = new ArrayList<String>();
		PreparedStatement ps_emp = null;
		ResultSet rs_emp = null;
		try {

			ps_emp = conn.prepareStatement(SQLutilConstants.GET_MAPPEDLOCATIONS);
			ps_emp.setString(1, groupLogReportPojo.getGroupName());
			rs_emp = ps_emp.executeQuery();
			while (rs_emp.next()) {
				empVOList.add(rs_emp.getString("LocationCode"));
			}
			ps_emp.close();
		} catch (SQLException sqle) {
			logger.error(sqle);
			sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
		}
		return empVOList;
	}

	public synchronized List<GroupLogReportVo> getLogDetailsForThisDate(
			GroupLogReportPojo pojoObj) {
		List<GroupLogReportVo> empVOList = new ArrayList<GroupLogReportVo>();
		PreparedStatement ps_emp = null;
		ResultSet rs_emp = null;
		try {

			ps_emp = (PreparedStatement) new DBService()
					.getPreparedStatement(SQLutilConstants.GET_LOGREPORT_FORTHISDATE);
			ps_emp.setString(1, pojoObj.getSelectedLocation());
			ps_emp.setString(2,
					HelperClass.convertUIToDatabase(pojoObj.getSelectedDate()));
			ps_emp.setString(3, pojoObj.getGroupName());
			rs_emp = ps_emp.executeQuery();
			GroupLogReportVo logVo = null;
			while (rs_emp.next()) {
				logVo = new GroupLogReportVo();
				logVo.setRep_EmployeeId(rs_emp.getString("EMPID"));
				logVo.setRep_EmployeeName(rs_emp.getString("EMPNAME"));
				logVo.setRep_Date(rs_emp.getString("ATTENDANCE_DATE"));
				logVo.setRep_WorkingHours(rs_emp.getString("WorkingHours"));
				logVo.setRep_Intime(rs_emp.getString("IN_TIME"));
				logVo.setRep_Outtime(rs_emp.getString("OUT_TIME"));
				logVo.setRep_AttStatus(rs_emp.getString("Status"));
				logVo.setRep_earlyHours(rs_emp.getString("EARLY_TIME"));
				logVo.setRep_lateHours(rs_emp.getString("LATE_TIME"));
				logVo.setRep_totalHours(rs_emp.getString("TotalHours"));
				empVOList.add(logVo);
			}
		} catch (SQLException sqle) {
			logger.error(sqle);
			sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				if(ps_emp!=null && (!ps_emp.isClosed())){
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
		return empVOList;
	}
	
	 public  ArrayList<ManagerFilterVO> getManagersByDepartment(String[] departmentid,String userType,String userCode) {

			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in LogReportAction: getManagersByDepartment : Starting");
			
			PreparedStatement ps_managerList = null;
			ResultSet rs_managerList = null;
			Connection connection = null;
			ArrayList<ManagerFilterVO> manager_list=new ArrayList<ManagerFilterVO>();

			try {
				connection = getConnection();
				if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
		    		
					ps_managerList=connection.prepareStatement(LogReportSqlUtil.GET_MANAGER_BY_DEPARTMENT_CODE_DIRECTOR);
					for(int i=0;i<departmentid.length;i++){
		    		    ps_managerList.setString(1,departmentid[i]);
		    		    ps_managerList.setString(2,userCode);
		    		   
		    		    rs_managerList= ps_managerList.executeQuery();	
		    		    
		    		    	while(rs_managerList.next()){
		    		    		ManagerFilterVO managervo=new ManagerFilterVO();
		    		    		managervo.setManagerid(rs_managerList.getString("ManagerCode").trim());
		    		    		managervo.setManagername(rs_managerList.getString("FirstName"));
		    		    		manager_list.add(managervo);
		    		    	}
		    		    	
		    		    }
		    	}
		    	else
		    	{
		    	
		    		ps_managerList=connection.prepareStatement(LogReportSqlUtil.GET_MANAGER_BY_DEPARTMENT_CODE);
		    		for(int i=0;i<departmentid.length;i++){
		    		    ps_managerList.setString(1,departmentid[i]);
		    		    
		    		   
		    		    rs_managerList= ps_managerList.executeQuery();	
		    		    
		    		    	while(rs_managerList.next()){
		    		    		ManagerFilterVO managervo=new ManagerFilterVO();
		    		    		managervo.setManagerid(rs_managerList.getString("ManagerCode").trim());
		    		    		managervo.setManagername(rs_managerList.getString("FirstName"));
		    		    		manager_list.add(managervo);
		    		    	}
		    		    	
		    		    }
		    	}
				
				//ps_managerList = connection.prepareStatement(LogReportSqlUtil.GET_ALL_MANAGERS_BY_DEPT);
		

	          System.out.println("manager list size in dao impl " +manager_list.size());
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			} finally {
				try {

					if (ps_managerList != null && (!ps_managerList.isClosed())) {

						ps_managerList.close();
					}
					if (rs_managerList != null && (!rs_managerList.isClosed())) {

						rs_managerList.close();
					}
					if (connection != null && (!connection.isClosed())) {

						connection.close();
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
					+ " Control in LogReportAction: getManagersByDepartment : Ending");
			
			return manager_list;

		}
	 
	 public ArrayList<EmployeeVO> getEmployees(String managerid_array,
				String[] departmentid_array) {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in MonthReportDaoImpl : getEmployees Starting");
			
			
			Connection connection=null;
			PreparedStatement ps_emp_get=null;
			ResultSet rs_emp_get=null;
			
			 ArrayList<EmployeeVO> employeelist=new  ArrayList<EmployeeVO>();
			 
			try {
			
				connection = getConnection();
				String temp_manager= "'" + managerid_array.replaceAll(",", "','") + "'";
				ps_emp_get = connection.prepareStatement("select EMPID,First_Name from hrms_employee where isActive='Y' and (EMPID in (select EMPID from hrms_manager where ManagerCode in ("+temp_manager+")) or EMPID in (select EmployeeId from hrms_employee_manager_mapping where ManagerId in ("+temp_manager+") )) ");
				
				System.out.println("all employees with mgr :::  "+ps_emp_get);
				
				rs_emp_get = ps_emp_get.executeQuery();
							
															
								while(rs_emp_get.next()){
									
									EmployeeVO employeevo=new EmployeeVO();
									employeevo.setEmpid(rs_emp_get.getString("EMPID"));
									employeevo.setEmpname(rs_emp_get.getString("First_Name"));
									
									employeelist.add(employeevo);
								}
								
		
							
						
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(exception.getMessage(), exception);
			}finally{
				
				try {
					
					if(rs_emp_get!=null && (!rs_emp_get.isClosed())){
						rs_emp_get.close();
					}
					if(ps_emp_get!=null && (!ps_emp_get.isClosed())){
						 ps_emp_get.close();
					}
					if(connection!=null && (!connection.isClosed())){
						connection.close();
					}
					
					
					
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle.getMessage(), sqle);
				} catch (Exception exception) {
					exception.printStackTrace();
					logger.error(exception.getMessage(), exception);
				}
				
			}
			
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in MonthReportDaoImpl : getEmployees Ending");
			
			return employeelist;
		}
}