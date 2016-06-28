package com.centris.service.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import com.centris.DAO.DBService;
import com.centris.DAO.DAOIMPL.MonthlyLagendReportDaoImpl;
import com.centris.VO.MonthlyLagendReportVo;
import com.centris.form.MonthlyLagendReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class MonthlyLagendReportServiceImpl extends DBService{

	
	private static Logger logger = Logger
			.getLogger(MonthlyLagendReportServiceImpl.class);
	
	public ArrayList<MonthlyLagendReportVo> getShiftBasedLocation(String locId,String groupid){
		
		return new MonthlyLagendReportDaoImpl().getShiftBasedLocation(locId,groupid);
	}
	
	public ArrayList<MonthlyLagendReportVo> getDeptBasedLocation() {
		
		return new MonthlyLagendReportDaoImpl().getDeptBasedLocation();
	}
	
	public ArrayList<MonthlyLagendReportVo> getLocationbyGroup(String groupid) {
		return new MonthlyLagendReportDaoImpl().getLocationbyGroup(groupid);
	}

	public ArrayList<MonthlyLagendReportVo> internalMonthlyLagendReport(MonthlyLagendReportForm mform) {
		

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportServiceImpl:internalMonthlyLagendReport Starting");
		
		Connection connection=null;
	
		try{
			
		connection=getConnection();
			
		ArrayList<MonthlyLagendReportVo> monthlist=new ArrayList<MonthlyLagendReportVo>();
		ArrayList<MonthlyLagendReportVo> listdata=new MonthlyLagendReportDaoImpl().getEmpIds(mform,connection);
		monthlist.clear();
		if(!listdata.get(0).getErrormsg().equals(MessageConstants.MONTHLY_LEGEND_ATTENDANCE_NOT_EXIST_MSG)){
		
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, 1);
			cal.set(Calendar.MONTH, Integer.parseInt(mform.getMonth()));
			cal.set(Calendar.YEAR, Integer.parseInt(mform.getYear()));
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			int days = cal.get(Calendar.DATE);
			
			
			MonthlyLagendReportVo monthlyLagendReportVo=new MonthlyLagendReportVo();
				monthlyLagendReportVo.setEmplist(listdata);
				monthlyLagendReportVo.setMonthdays(days);
				monthlyLagendReportVo.setYear(mform.getYear());
				monthlyLagendReportVo.setMonth(mform.getMonth());
				
				monthlist=new MonthlyLagendReportDaoImpl().internalMonthlyLagendReport(monthlyLagendReportVo,connection);
			
				
		
			return monthlist;
				
			
			
		}else{
			
					
			return listdata;
		}
		}catch (SQLException sqle) {

			sqle.printStackTrace();
			logger.error(sqle);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		finally {

			try {

				if (!connection.isClosed()) {
					connection.close();
				}

			} catch (SQLException sqle) {

				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e) {

				e.printStackTrace();
				logger.error(e);
			}
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportServiceImpl:internalMonthlyLagendReport Ending");
		return null;
	}
	public ArrayList<MonthlyLagendReportVo> externalMonthlyLagendReport(
			MonthlyLagendReportForm mform) {
     
		Connection connection=null;
		
		try{
			connection=getConnection();
		ArrayList<MonthlyLagendReportVo> monthlist=new ArrayList<MonthlyLagendReportVo>();
		ArrayList<MonthlyLagendReportVo> listdata=new MonthlyLagendReportDaoImpl().getEmpIds(mform,connection);
		if(listdata.size()!=0){
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, 1);
			cal.set(Calendar.MONTH, Integer.parseInt(mform.getMonth()));
			cal.set(Calendar.YEAR, Integer.parseInt(mform.getYear()));
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			int days = cal.get(Calendar.DATE);
			
				MonthlyLagendReportForm mform1=new MonthlyLagendReportForm();
				mform1.setEmpid(listdata);
				mform1.setDays(days);
				mform1.setYear(mform.getYear());
				mform1.setMonth(mform.getMonth());
				monthlist=new MonthlyLagendReportDaoImpl().externalMonthlyLagendReport(mform1);
			
			
			return monthlist;
		}else{
			
			return monthlist;
		}
      }catch(Exception e){
			
			e.printStackTrace();
		}
		return null;
		
		}
		
		
}
