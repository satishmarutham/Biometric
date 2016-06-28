/**
 * 
 */
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
import com.centris.DAO.EmpWorkingLessThan8hrsReportDao;
import com.centris.POJO.EmpWorkingLessThan8hrsReportPojo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 *
 */
public class EmpWorkingLessThan8hrsReportDaoImpl extends DBService  implements EmpWorkingLessThan8hrsReportDao {
	private  static 	Logger logger = Logger.getLogger(EmpWorkingLessThan8hrsReportDaoImpl.class);
	@Override
	public synchronized List<EmpWorkingLessThan8hrsReportPojo> getEmpWorkinglessThen8hrs(
			
			EmpWorkingLessThan8hrsReportPojo pojo) throws Exception {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpWorkingLessThan8hrsReportDaoImpl :getEmpWorkinglessThen8hrs Starting");
		
	
Connection connection=null;
		 PreparedStatement psgetempReport=null;
		 ResultSet rsgetempReport=null;
			List<EmpWorkingLessThan8hrsReportPojo> getlReportList=new ArrayList<EmpWorkingLessThan8hrsReportPojo>();
		 try{
		
			 connection=getConnection();
			 psgetempReport=connection.prepareStatement(SQLutilConstants.GET_EMPLOYEE_WORKING_LESSTHAN_8HRS);
			 psgetempReport.setString(1,pojo.getEmployeeId());
			 psgetempReport.setString(2,HelperClass.convertUIToDatabase(pojo.getStartDate()));
			 psgetempReport.setString(3,HelperClass.convertUIToDatabase(pojo.getEndDate()));
		
		  rsgetempReport=psgetempReport.executeQuery();
		
		 while(rsgetempReport.next()){
			 EmpWorkingLessThan8hrsReportPojo workinglessThen8hrs=new EmpWorkingLessThan8hrsReportPojo();
			 workinglessThen8hrs.setEmployeeId(rsgetempReport.getString("EMPID"));
			 workinglessThen8hrs.setEmployeeName(rsgetempReport.getString("EMPNAME"));
			 workinglessThen8hrs.setLocationName(rsgetempReport.getString("Location"));
			 workinglessThen8hrs.setShiftName(rsgetempReport.getString("AI_SHIFT_NAME"));
			 workinglessThen8hrs.setAttendenceDate(HelperClass.convertDatabaseToUI(rsgetempReport.getString("ATTENDANCE_DATE")));
			 workinglessThen8hrs.setInTime(rsgetempReport.getString("IN_TIME"));
			 workinglessThen8hrs.setOutTime(rsgetempReport.getString("OUT_TIME"));
			 workinglessThen8hrs.setLateTime(rsgetempReport.getString("LATE_TIME"));
			 workinglessThen8hrs.setEarlyTime(rsgetempReport.getString("EARLY_TIME"));
		workinglessThen8hrs.setTotalWorkinghours(rsgetempReport.getString("TOTAL_WORKING_HOURS"));
		workinglessThen8hrs.setAttendenceStatus(rsgetempReport.getString("status"));
		 getlReportList.add(workinglessThen8hrs);
		
			 
		 }
		 }
	catch (Exception e) {
		logger.error(e);
		// TODO: handle exception
	}
		finally
		{
			try
			{
				 if(psgetempReport != null && (!psgetempReport.isClosed())){
					 psgetempReport.getConnection().close();
					}
			}
			catch(Exception exception){
				logger.error(exception);
			}
		}
					
	
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmpWorkingLessThan8hrsReportDaoImpl :getEmpWorkinglessThen8hrs Ending");
		
			
		// TODO Auto-generated method stub
		return getlReportList;
		
		
		
		// TODO Auto-generated method stub
	}

}
