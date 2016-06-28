package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.centris.DAO.AbstractConnectionFactory;
import com.centris.DAO.TodayReportDAO;
import com.centris.VO.TodayReportVO;
import com.centris.form.TodayReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class TodayReportDAOImpl extends AbstractConnectionFactory  implements TodayReportDAO {
	private static 	Logger logger = Logger.getLogger(TodayReportDAOImpl.class);
	
	public synchronized List<TodayReportVO> getEmpDetailsByLocation(String group,String location){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportDAOImpl:getEmpDetailsByShift Starting");
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames=null;
		
		List<TodayReportVO> empList=new ArrayList<TodayReportVO>();
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.GET_TODAYS_EMP_BY_LOCATION);
			pstmt.setString(1,location);
			pstmt.setString(2,group);
		
			 rsshiftnames=pstmt.executeQuery();
			TodayReportVO todayReportVo=null;
			while(rsshiftnames.next()){
				todayReportVo=new TodayReportVO();
				todayReportVo.setEmpid(rsshiftnames.getString("EMPID"));
				todayReportVo.setEmpname(rsshiftnames.getString("EMPNAME"));
				empList.add(todayReportVo);
			}
		}catch(SQLException se)
		{
			logger.error(se);
		}catch(Exception e)
		{
			logger.error(e);
		}finally{
			try{
				
				if(pstmt !=null && (!pstmt.isClosed()))
				{
					pstmt.getConnection().close();
				}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportDAOImpl:getEmpDetailsByShift Ending");
		
		return empList;
	}
	
	@Override
	public synchronized List<TodayReportVO> getTodayReport(TodayReportForm todayReportForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportDAOImpl:getTodayReport Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<TodayReportVO> todayReportList=new ArrayList<TodayReportVO>();
		try{
			conn= getLogConnection();
			String machineNoList=getMachineNoByLocation(todayReportForm);
			String currentDate=HelperClass.getCurrentSqlDate()+"";
			pstmt=conn.prepareStatement("select badgenumber,group_concat(checktime order by checktime) datetime from checkinout cio,userinfo ui where cio.userid=ui.userid and cio.SN in ( "+machineNoList+" ) and badgenumber like '"+"%0"+todayReportForm.getEmployee()+"' and cio.checktime like '"+currentDate+"%' group by badgenumber order by badgenumber ");
			
			rs=pstmt.executeQuery();
			TodayReportVO todayReportVO=null;
			int i=1;
			String temp_time="";
			while(rs.next()){ 
		
				todayReportVO=new TodayReportVO();
				todayReportVO.setsNo(i+"");
				int empId=Integer.parseInt(rs.getString("badgenumber"));
				todayReportVO.setEmpid(empId+"");
				Map<String,String> empinfo= getEmpInfoByEmpId(empId+"");
				todayReportVO.setEmpname(empinfo.get("EmpName"));
				todayReportVO.setLocation(empinfo.get("Location"));
				todayReportVO.setFirstLogInTime("");
				todayReportVO.setFirstLogOutTime("");
				todayReportVO.setSecondLogInTime("");
				todayReportVO.setSecondLogOutTime("");
				todayReportVO.setThirdLogInTime("");
				todayReportVO.setThirdLogOutTime("");
				todayReportVO.setFourthLogInTime("");
				todayReportVO.setFourthLogOutTime("");
				todayReportVO.setFifthLogInTime("");
				todayReportVO.setFifthLogOutTime("");
				
				temp_time=rs.getString("datetime");
				String time[] = temp_time.split(",");
				for(int c=0;c<time.length;c++){
					String logTime=time[c].substring(time[c].indexOf(" "),time[c].length());
					if(c==0)
						todayReportVO.setFirstLogInTime(logTime);
					if(c==1)
						todayReportVO.setFirstLogOutTime(logTime);
					if(c==2)
						todayReportVO.setSecondLogInTime(logTime);
					if(c==3)
						todayReportVO.setSecondLogOutTime(logTime);
					if(c==4)
						todayReportVO.setThirdLogInTime(logTime);
					if(c==5)
						todayReportVO.setThirdLogOutTime(logTime);
					if(c==6)
						todayReportVO.setFourthLogInTime(logTime);
					if(c==7)
						todayReportVO.setFourthLogOutTime(logTime);
					if(c==8)
						todayReportVO.setFifthLogInTime(logTime);
					if(c==9)
						todayReportVO.setFifthLogOutTime(logTime);
				}
				if(time.length>0)
					todayReportVO.setStatus("Present");
				else
					todayReportVO.setStatus("Absent");
				if(empinfo.get("EmpName")!=null && !empinfo.get("EmpName").trim().equals("")){
					todayReportList.add(todayReportVO);
					i++;
				}
			}
		}catch(SQLException se)
		{
			logger.error(se);
		}catch(Exception e)
		{
			logger.error(e);
		}finally{
			try{
				
				if(pstmt !=null && !pstmt.isClosed())
				{
					pstmt.getConnection().close();
				}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportDAOImpl:getTodayReport Ending");
		
		return todayReportList;
	}
	

	public synchronized String getMachineNoByLocation(TodayReportForm todayReportForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportDAOImpl:getMachineNoByLocation Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		 String machineList = "";
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.GET_MACHINE_NO_BY_LOCATION);
			pstmt.setString(1,todayReportForm.getLocation());
			pstmt.setString(2,todayReportForm.getGroup());
			rs=pstmt.executeQuery();
			while(rs.next()){
				machineList = machineList +",'"+rs.getString("BioMachineNumber")+"'";
			}
			if(!machineList.equals("")){
				machineList=machineList.substring(1);
			}
		}catch(SQLException se)
		{
			logger.error(se);
		}catch(Exception e)
		{
			logger.error(e);
		}finally{
			try{
				
				if(pstmt !=null && (!pstmt.isClosed()))
				{
					pstmt.getConnection().close();
				}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportDAOImpl:getMachineNoByLocation Ending");
		
		return machineList;
	}
	

	public synchronized Map<String,String> getEmpInfoByEmpId(String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportDAOImpl:getEmpInfoByEmpId Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Map<String,String> empmap = new HashMap<String, String>();
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.GET_EMP_INFO_BY_EMPID);
			pstmt.setString(1,empId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				empmap.put("EmpName", rs.getString("EMPNAME"));
				empmap.put("Shift", rs.getString("AI_SHIFT_NAME"));
				empmap.put("Location", rs.getString("Location"));
			}
		}catch(SQLException se)
		{
			logger.error(se);
		}catch(Exception e)
		{
			logger.error(e);
		}finally{
			try{
				
				if(pstmt !=null && (!pstmt.isClosed()))
				{
					pstmt.getConnection().close();
				}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportDAOImpl:getEmpInfoByEmpId Ending");
		
		return empmap;
	}	
}