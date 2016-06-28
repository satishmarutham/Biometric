package com.centris.service.serviceImpl;

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
import com.centris.DAO.DAOIMPL.AttendenceApprovelDaoImpl;
import com.centris.DAO.DAOIMPL.EmployeeAttendancePostingDaoImpl;
import com.centris.POJO.AttendenceApprovelPojo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.VO.ClientVO;
import com.centris.VO.EmployeeAttendancePostingVo;
import com.centris.form.AttendenceApprovelForm;
import com.centris.service.AttendenceApprovelService;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class AttendenceApprovelServiceImpl extends DBService implements AttendenceApprovelService{
	
	private static Logger logger = Logger.getLogger(AttendenceApprovelServiceImpl.class);
	
	public  ArrayList<AttendenceApprovelVo> getEmployees(String managerid,String usertype){
		
		return new AttendenceApprovelDaoImpl().getEmployees(managerid,usertype);
	}
	
	public  ArrayList<AttendenceApprovelVo> getEmployeeAttendance(AttendenceApprovelForm attform) {
		
		AttendenceApprovelPojo att_pojo=new AttendenceApprovelPojo();
		
		int totalDaysInMonth = HelperClass.getDaysByMonthAndYear(Integer.parseInt(attform.getMonth()), Integer.parseInt(attform.getYear()));
		
		att_pojo.setEmployeeid(attform.getEmplyeeid());
		att_pojo.setStartdate(attform.getYear()+"-"+attform.getMonth()+"-"+"01");
		att_pojo.setEnddate(attform.getYear()+"-"+attform.getMonth()+"-"+totalDaysInMonth);
		
		
		
		return new AttendenceApprovelDaoImpl().getEmployeeAttendance(att_pojo);
	}
	
	public  ArrayList<AttendenceApprovelVo> getEmployeeSpecificAttendence(AttendenceApprovelPojo att_pojo) {
		
		return new AttendenceApprovelDaoImpl().getEmployeeSpecificAttendence(att_pojo);
	}
	
	
	
	public  ArrayList<AttendenceApprovelVo> getAttendanceStatusTypeService() {
		
		
		return new AttendenceApprovelDaoImpl().getAttendanceStatusTypeDao();
	}
	
	public  ArrayList<AttendenceApprovelVo> getAttendanceStatus() {
		
		
		return new AttendenceApprovelDaoImpl().getAttendanceStatus();
	}
	
	public  String updateEmpAttendance(AttendenceApprovelPojo att_pojo) {
		
		
		String total_time=HelperClass.getTimeDifferenceinTimeFormat(att_pojo.getIntime(),att_pojo.getOuttime());
		
		att_pojo.setTotaltime(total_time);
		
		return new AttendenceApprovelDaoImpl().updateEmpAttendance(att_pojo);
	}
	
public  String updateAllEmpAttendance(AttendenceApprovelPojo att_pojo) {
		
		
		return new AttendenceApprovelDaoImpl().updateAllEmpAttendance(att_pojo);
	}
	
	
	public  String getSingleEmployee(String empid) {
		
		return new AttendenceApprovelDaoImpl().getSingleEmployee(empid);
	}
	
	public  List<ClientVO> getAllClients() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelServiceImpl : getAllClients Starting");

		List<ClientVO> clientList = new ArrayList<ClientVO>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;
		int sno = 1;
		try {

			con = getConnection();
			clientList=new EmployeeAttendancePostingDaoImpl().getAllClients(con);
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
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
				+ " Control in AttendenceApprovelServiceImpl : getAllClients Ending");
		
		return clientList;
	}

}
