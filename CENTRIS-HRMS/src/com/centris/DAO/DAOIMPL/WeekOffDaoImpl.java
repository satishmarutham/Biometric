/**
 * 
 */
package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.VO.EmpLocationVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.WeekOffVO;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author Ratna
 * 
 */
public class WeekOffDaoImpl extends DBService {

	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(WeekOffDaoImpl.class);;
	public WeekOffDaoImpl() {
		// TODO Auto-generated constructor stub
	}


	public synchronized String updateDaoImpl(EmployeeVO vo) throws Exception {

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffDaoImpl: updateDaoImpl : Starting");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pst = null;
		PreparedStatement stmt=null;
		ResultSet empcount=null;
		ResultSet date = null;
		int count = 0;

		ArrayList<EmployeeVO> listofEmployees = new ArrayList<EmployeeVO>();
		try {

			con = getConnection();

			 stmt = con
					.prepareStatement(SQLutilConstants.checkEmpinWeekOffMaster);
			stmt.setString(1, vo.getEmpid());
			 empcount = stmt.executeQuery();
			
			while (empcount.next()) {
				count = empcount.getInt(1);
			}
			DateFormat dateFormat = new SimpleDateFormat(StringUtils.DATEFORMAT);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			if (count == 1) {

				String currentdate = null;

				pst = con
						.prepareStatement(SQLutilConstants.CheckCreatedDateWeekOff);
				pst.setString(1, vo.getEmpid());
				date = pst.executeQuery();

				while (date.next()) {
					currentdate = date.getString("CREATEDDATE");
				}

				pstmt = con
						.prepareStatement(SQLutilConstants.updateEmpIntoWeekOff);

				pstmt.setInt(1, vo.getSunday());
				pstmt.setInt(2, vo.getMonday());
				pstmt.setInt(3, vo.getTuesday());
				pstmt.setInt(4, vo.getWednesday());
				pstmt.setInt(5, vo.getThursday());
				pstmt.setInt(6, vo.getFriday());
				pstmt.setInt(7, vo.getSaturday());
				pstmt.setString(8, vo.getUsercode());
				pstmt.setString(9,
						dateFormat.format(cal.getTime()).replace("/", "-"));
				pstmt.setString(10, currentdate);
				pstmt.setString(11, Integer.toString(year));
				pstmt.setString(12, vo.getEmpid());

			} else {

				pstmt = con
						.prepareStatement(SQLutilConstants.insertEmpIntoWeekOff);

				pstmt.setString(1, vo.getEmpid());
				pstmt.setInt(2, vo.getSunday());
				pstmt.setInt(3, vo.getMonday());
				pstmt.setInt(4, vo.getTuesday());
				pstmt.setInt(5, vo.getWednesday());
				pstmt.setInt(6, vo.getThursday());
				pstmt.setInt(7, vo.getFriday());
				pstmt.setInt(8, vo.getSaturday());
				pstmt.setString(9, Integer.toString(year));
				pstmt.setString(10,  vo.getUsercode());

			}

			int co = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e);
		} 
		finally {
			try {
				
				
                if(empcount !=null && (!empcount.isClosed())){
					
                	empcount.close();
				}
				
				if(date !=null && (!date.isClosed()) ){
					
					date.close();
				}
				
                if(pst !=null && (!pst.isClosed())){
					
					pstmt.close();
				} 
				if(pstmt !=null && (!pst.isClosed())){
					
					pstmt.close();
				}
				if(stmt !=null && (!stmt.isClosed())){
					
					closeAll(stmt, null);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}catch(Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffDaoImpl: updateDaoImpl : Ending");
		
		return "Week Off Details Updated Successfully";
	}

	public synchronized WeekOffVO getEmployeeWeekOffsDaoImpl(String empid) throws Exception {

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffDaoImpl: getEmployeeWeekOffsDaoImpl : Starting");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet weekoff = null;
		int count = 0;
		WeekOffVO vo = new WeekOffVO();
		ArrayList<EmployeeVO> listofEmployees = new ArrayList<EmployeeVO>();
		try {

			con = getConnection();

			PreparedStatement stmt = con
					.prepareStatement(SQLutilConstants.getweekoffs);
			stmt.setString(1, empid);
			 weekoff = stmt.executeQuery();

			while (weekoff.next()) {

				vo.setEmpid(weekoff.getString("EMP_ID"));
				vo.setAccyear(weekoff.getString("CURRENT_YEAR"));
				vo.setSunday(weekoff.getInt("SUNDAY"));
				vo.setMonday(weekoff.getInt("MONDAY"));
				vo.setTuesday(weekoff.getInt("TUESDAY"));
				vo.setWednesday(weekoff.getInt("WEDNESDAY"));
				vo.setThursday(weekoff.getInt("THURSDAY"));
				vo.setFriday(weekoff.getInt("FRIDAY"));
				vo.setSaturday(weekoff.getInt("SATURDAY"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e);
		} 
		finally {
			try {
				
				   if(weekoff !=null && (!weekoff.isClosed())){
						
					   weekoff.close();
					} 
					if(pstmt !=null && (!pstmt.isClosed())){
						
						pstmt.close();
					}
					if(con !=null && (!con.isClosed())){
						
						con.close();
						
					}
				
				/*if(con !=null){
					
					closeAll(pstmt, weekoff);
					
				}*/
				
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}catch(Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffDaoImpl: getEmployeeWeekOffsDaoImpl : Ending");
		
		return vo;
	}

	public synchronized ArrayList<EmployeeVO> getAllEmployee(EmpLocationVO empLocationVO)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffDaoImpl: getAllEmployee : Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet empResultSet = null;
		String search=empLocationVO.getSearch();
		String max=empLocationVO.getMax();
		ArrayList<EmployeeVO> listofEmployees = new ArrayList<EmployeeVO>();
		try {

			con = getConnection();

			pstmt = con
					.prepareStatement(SQLutilConstants.GET_ALL_EMPLOYESS_WEEKOFF);
	
			pstmt.setString(1, "%" + search + "%");
			pstmt.setString(2, empLocationVO.getGroup());
			pstmt.setInt(3, Integer.parseInt(max));
			System.out.println(pstmt.toString());
			empResultSet = pstmt.executeQuery();
			
			while (empResultSet.next()) {
				EmployeeVO vo = new EmployeeVO();

				vo.setEmpid(empResultSet.getString("EMPID"));
				vo.setEmpname(empResultSet.getString("EMPNAME"));
				vo.setPhone(empResultSet.getString("PHONE"));
				vo.setEmail(empResultSet.getString("EMAIL"));
				vo.setShiftid(empResultSet.getString("AI_SHIFT_ID"));
				vo.setShiftname(empResultSet.getString("AI_SHIFT_NAME"));
				vo.setDeptid(empResultSet.getString("DEPT_ID"));
				vo.setDeptname(empResultSet.getString("DEPT_NAME"));
				vo.setEmplocation(empResultSet.getString("Location"));
				vo.setEmplocationid(empResultSet.getString("LocationCode"));
				
			

				listofEmployees.add(vo);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e);
		} 
		finally {
			try {
				
				if(empResultSet !=null && (!empResultSet.isClosed())){
					
					empResultSet.close();
					} 
					if(pstmt !=null && (!pstmt.isClosed())){
						
						pstmt.close();
					}
					if(con !=null && (!con.isClosed())){
						
						con.close();
						
					}
					
				/*if(con !=null){
					
					closeAll(pstmt, empResultSet);
					
				}*/
				
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}catch(Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffDaoImpl: getAllEmployee : Ending");
		
		return listofEmployees;
	}
}