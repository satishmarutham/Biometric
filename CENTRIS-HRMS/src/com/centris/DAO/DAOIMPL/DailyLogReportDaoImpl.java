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

import com.centris.DAO.DBService;
import com.centris.DAO.DailyLogReportDao;
import com.centris.VO.DailyLogReportVO;
import com.centris.form.DailyLogReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;


public class DailyLogReportDaoImpl extends DBService implements DailyLogReportDao {

	/**
	 * @author Swathi
	 * @param dailyLogReportform
	 * @return
	 */
	private static Logger logger = Logger
			.getLogger(DailyLogReportDaoImpl.class);
	
	public synchronized List<DailyLogReportVO> getDailyLogReport(DailyLogReportForm dailyLogReportform) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getDailyLogReport Starting");
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		
		
		
		List<DailyLogReportVO> dailylogreportList=new ArrayList<DailyLogReportVO>();
	
		
		
		try{
			conn= getConnection();
			int locationCount=getcountLocationByGroup(dailyLogReportform,conn);
				
			
		if(locationCount>0){
					
					
					
			if(dailyLogReportform.getEmployee().equals("%%")){
						
						 List<String> empidslist= getAllEmpidsByDesiWithLocation(dailyLogReportform.getDesignation(),dailyLogReportform.getLocation(),conn,dailyLogReportform.getGroup());
				
						 
				for(int i=0;i<empidslist.size();i++){
						
						 if(dailyLogReportform.getStartDate().equals("")){
							 
							 pstmt=conn.prepareStatement(SQLutilConstants.GET_DAILY_LOG_REPORT_END_DATE);

								pstmt.setString(1,empidslist.get(i));
								pstmt.setString(2,HelperClass.convertUIToDatabase(dailyLogReportform.getEndDate()));
								pstmt.setString(3,dailyLogReportform.getLocation());
							 
						 }else if(dailyLogReportform.getEndDate().equals("")){
							 
							 pstmt=conn.prepareStatement(SQLutilConstants.GET_DAILY_LOG_REPORT_START_DATE);

								pstmt.setString(1,empidslist.get(i) );
								pstmt.setString(2,HelperClass.convertUIToDatabase(dailyLogReportform.getStartDate()));
								pstmt.setString(3,dailyLogReportform.getLocation());
						 }else{
							 
							 pstmt=conn.prepareStatement(SQLutilConstants.GET_DAILY_LOG_REPORT);

								pstmt.setString(1,empidslist.get(i) );
								pstmt.setString(2,HelperClass.convertUIToDatabase(dailyLogReportform.getStartDate()));
								pstmt.setString(3,HelperClass.convertUIToDatabase(dailyLogReportform.getEndDate()));
								pstmt.setString(4,dailyLogReportform.getLocation());
						 }
						
						 rs=pstmt.executeQuery();
							
							
							
							DailyLogReportVO dailylogReportVO=null;
							int j=1;
							String temp_time="";
							while(rs.next()){ 
						
								dailylogReportVO=new DailyLogReportVO();
								dailylogReportVO.setsNo(j+"");
							
								dailylogReportVO.setDate(HelperClass.convertDatabaseToUI(rs.getString("AI_EMP_DATE")));
								dailylogReportVO.setEmpid(rs.getString("AI_EMP_ID"));
								Map<String,String> empinfo= getEmpInfoByEmpId(rs.getString("AI_EMP_ID"),conn);
								dailylogReportVO.setEmpname(empinfo.get("EmpName"));
								dailylogReportVO.setLocation(empinfo.get("Location"));
								dailylogReportVO.setDesignation(empinfo.get("Designation"));
																		
								dailylogReportVO.setFirstLogInTime("");
								dailylogReportVO.setFirstLogOutTime("");
								dailylogReportVO.setSecondLogInTime("");
								dailylogReportVO.setSecondLogOutTime("");
								dailylogReportVO.setThirdLogInTime("");
								dailylogReportVO.setThirdLogOutTime("");
								dailylogReportVO.setFourthLogInTime("");
								dailylogReportVO.setFourthLogOutTime("");
								dailylogReportVO.setFifthLogInTime("");
								dailylogReportVO.setFifthLogOutTime("");
								
								temp_time=rs.getString("time");
								String time[] = temp_time.split(",");
								for(int c=0;c<time.length;c++){
									String logTime=time[c];
									if(c==0)
										dailylogReportVO.setFirstLogInTime(logTime);
									if(c==1)
										dailylogReportVO.setFirstLogOutTime(logTime);
									if(c==2)
										dailylogReportVO.setSecondLogInTime(logTime);
									if(c==3)
										dailylogReportVO.setSecondLogOutTime(logTime);
									if(c==4)
										dailylogReportVO.setThirdLogInTime(logTime);
									if(c==5)
										dailylogReportVO.setThirdLogOutTime(logTime);
									if(c==6)
										dailylogReportVO.setFourthLogInTime(logTime);
									if(c==7)
										dailylogReportVO.setFourthLogOutTime(logTime);
									if(c==8)
										dailylogReportVO.setFifthLogInTime(logTime);
									if(c==9)
										dailylogReportVO.setFifthLogOutTime(logTime);
								}
								if(time.length>0){
									dailylogReportVO.setStatus("Present");
					}
								else{
									dailylogReportVO.setStatus("Absent");
								}
								
								dailylogReportVO.setHgroup(dailyLogReportform.getGroup());
								dailylogReportVO.setHlocation(dailyLogReportform.getLocation());
								dailylogReportVO.setHdesignation(dailyLogReportform.getDesignation());
								dailylogReportVO.setHemployee(dailyLogReportform.getEmployee());
								dailylogReportVO.setHstartdate(dailyLogReportform.getStartDate());
								dailylogReportVO.setHenddate(dailyLogReportform.getEndDate());
								
								
								dailylogreportList.add(dailylogReportVO);
							
								j++;
							}
					
						}
					
						
						
					}
					
					
					
			
			else{
			
				 if(dailyLogReportform.getStartDate().equals("")){
					 
					 pstmt=conn.prepareStatement(SQLutilConstants.GET_DAILY_LOG_REPORT_END_DATE);

						pstmt.setString(1,dailyLogReportform.getEmployee() );
						pstmt.setString(2,HelperClass.convertUIToDatabase(dailyLogReportform.getEndDate()));
						pstmt.setString(3,dailyLogReportform.getLocation());
					 
				 }else if(dailyLogReportform.getEndDate().equals("")){
					 
					 pstmt=conn.prepareStatement(SQLutilConstants.GET_DAILY_LOG_REPORT_START_DATE);

						pstmt.setString(1,dailyLogReportform.getEmployee() );
						pstmt.setString(2,HelperClass.convertUIToDatabase(dailyLogReportform.getStartDate()));
						pstmt.setString(3,dailyLogReportform.getLocation());
				 }else{
					 
					 pstmt=conn.prepareStatement(SQLutilConstants.GET_DAILY_LOG_REPORT);

						pstmt.setString(1,dailyLogReportform.getEmployee() );
						pstmt.setString(2,HelperClass.convertUIToDatabase(dailyLogReportform.getStartDate()));
						pstmt.setString(3,HelperClass.convertUIToDatabase(dailyLogReportform.getEndDate()));
						pstmt.setString(4,dailyLogReportform.getLocation());
				 }
				
				
			
					
					rs=pstmt.executeQuery();
					
				
					
					DailyLogReportVO dailylogReportVO=null;
					int j=1;
					String temp_time="";
					while(rs.next()){ 
				
						dailylogReportVO=new DailyLogReportVO();
						dailylogReportVO.setsNo(j+"");
					
						dailylogReportVO.setDate(HelperClass.convertDatabaseToUI(rs.getString("AI_EMP_DATE")));
						dailylogReportVO.setEmpid(rs.getString("AI_EMP_ID"));
						Map<String,String> empinfo= getEmpInfoByEmpId(rs.getString("AI_EMP_ID"),conn);
						dailylogReportVO.setEmpname(empinfo.get("EmpName"));
						dailylogReportVO.setLocation(empinfo.get("Location"));
						dailylogReportVO.setDesignation(empinfo.get("Designation"));
																
						dailylogReportVO.setFirstLogInTime("");
						dailylogReportVO.setFirstLogOutTime("");
						dailylogReportVO.setSecondLogInTime("");
						dailylogReportVO.setSecondLogOutTime("");
						dailylogReportVO.setThirdLogInTime("");
						dailylogReportVO.setThirdLogOutTime("");
						dailylogReportVO.setFourthLogInTime("");
						dailylogReportVO.setFourthLogOutTime("");
						dailylogReportVO.setFifthLogInTime("");
						dailylogReportVO.setFifthLogOutTime("");
						
						temp_time=rs.getString("time");
						String time[] = temp_time.split(",");
						for(int c=0;c<time.length;c++){
							String logTime=time[c];
							if(c==0)
								dailylogReportVO.setFirstLogInTime(logTime);
							if(c==1)
								dailylogReportVO.setFirstLogOutTime(logTime);
							if(c==2)
								dailylogReportVO.setSecondLogInTime(logTime);
							if(c==3)
								dailylogReportVO.setSecondLogOutTime(logTime);
							if(c==4)
								dailylogReportVO.setThirdLogInTime(logTime);
							if(c==5)
								dailylogReportVO.setThirdLogOutTime(logTime);
							if(c==6)
								dailylogReportVO.setFourthLogInTime(logTime);
							if(c==7)
								dailylogReportVO.setFourthLogOutTime(logTime);
							if(c==8)
								dailylogReportVO.setFifthLogInTime(logTime);
							if(c==9)
								dailylogReportVO.setFifthLogOutTime(logTime);
						}
						if(time.length>0){
							dailylogReportVO.setStatus("Present");
			}
						else{
							dailylogReportVO.setStatus("Absent");
						}
						
						dailylogReportVO.setHgroup(dailyLogReportform.getGroup());
						dailylogReportVO.setHlocation(dailyLogReportform.getLocation());
						dailylogReportVO.setHdesignation(dailyLogReportform.getDesignation());
						dailylogReportVO.setHemployee(dailyLogReportform.getEmployee());
						dailylogReportVO.setHstartdate(dailyLogReportform.getStartDate());
						dailylogReportVO.setHenddate(dailyLogReportform.getEndDate());
						
						
						dailylogreportList.add(dailylogReportVO);
					
						j++;
					}
			
				}
		
				}
		}catch(SQLException se)
		{
		se.printStackTrace();
		logger.error(se);
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}finally{
			try{
				if(rs!=null && !rs.isClosed()){
					rs.close();
					
				}
				if(pstmt!=null && !pstmt.isClosed()){
					pstmt.close();
					
				}
				if(conn != null && (!conn.isClosed())){
					conn.close();
					
					
				}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
				
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
				
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getDailyLogReport Ending");
		System.out.println(" control in DailyLogReportDaoImpl:getDailyLogReport END");
		return dailylogreportList;
	}
	
	private List<String> getAllEmpidsByDesiWithLocation(
			String designation, String location, Connection conn, String group) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getAllEmpidsByDesiWithLocation Starting");
		
      ArrayList<String> emplist=new ArrayList<String>();		
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try{
			
			pstmt=conn.prepareStatement(SQLutilConstants.GET_EMP_IDS_BY_LOCATION_AND_DESIGNATION);
			
			pstmt.setString(1,group);
			pstmt.setString(2,designation);
			pstmt.setString(3,location);
			
			rs=pstmt.executeQuery();
			
			
		while(rs.next()){
			
			emplist.add(rs.getString("EMPID"));
					
			
		}
			
			
		}catch(SQLException se)
		{
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}finally{
			try{
				
				if(rs!=null && !rs.isClosed()){
					rs.close();				
				}
				if(pstmt!=null && !pstmt.isClosed()){
					pstmt.close();
					
				}
				
				
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
				
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
				
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getAllEmpidsByDesiWithLocation  Ending");
		
		
		return emplist;
	}
	


	public synchronized Map<String,String> getEmpInfoByEmpId(String empId,Connection conn) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getEmpInfoByEmpId Starting");
		//Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Map<String,String> empmap = new HashMap<String, String>();
		try{
	
			
				pstmt=conn.prepareStatement(SQLutilConstants.GET_EMP_INFO_BY_EMPIDS);
				pstmt.setString(1,empId);
					
			rs=pstmt.executeQuery();
		
			while(rs.next()){
				empmap.put("EmpId", rs.getString("EMPID").trim());
				empmap.put("EmpName", rs.getString("EMPNAME").trim());
				empmap.put("Location", rs.getString("Location").trim());
				empmap.put("Designation", rs.getString("designationName").trim());
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}finally{
			
               try{
				
				if(rs!=null && !rs.isClosed()){
					rs.close();				
				}
				if(pstmt!=null && !pstmt.isClosed()){
					pstmt.close();
					
				}
				
				
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
				
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
				
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getEmpInfoByEmpId  Ending");
	
		return empmap;
	}
	
	private synchronized int getcountLocationByGroup(DailyLogReportForm dailyLogReportform,Connection con) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getcountLocationByGroup Starting");
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		 int locationcount = 0;
	
		 try{
			
			pstmt=con.prepareStatement(SQLutilConstants.GET_LOCATION_COUNT_BY_GROUP);
			pstmt.setString(1,dailyLogReportform.getLocation());
			pstmt.setString(2,dailyLogReportform.getGroup());
			rs=pstmt.executeQuery();
			while(rs.next()){
				locationcount =rs.getInt(1);
			}
			
		}catch(SQLException se)
		{
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}finally{
			try{
				
				if(rs!=null && !rs.isClosed()){
					rs.close();				
				}
				if(pstmt!=null && !pstmt.isClosed()){
					pstmt.close();
					
				}
				
				
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
				
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
				
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getcountLocationByGroup  Ending");
		return locationcount;
	}

			


	public List<DailyLogReportVO> getEmpDetailsByDesiWithLocation(String designation, String group, String location) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getcountLocationByGroup Starting");
		
      ArrayList<DailyLogReportVO> emplist=new ArrayList<DailyLogReportVO>();		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.GET_EMPLOYEE_BY_LOCATION_AND_DESIGNATION);
			
			pstmt.setString(1,group);
			pstmt.setString(2,designation);
			pstmt.setString(3,location);
			
			rs=pstmt.executeQuery();
		
		while(rs.next()){
			
			DailyLogReportVO dailyLogReportVO=new DailyLogReportVO();
			dailyLogReportVO.setEmpid(rs.getString("EMPID"));
			dailyLogReportVO.setEmpname(rs.getString("EMPNAME"));
			emplist.add(dailyLogReportVO);
			
			
		}
			
			
		}catch(SQLException se)
		{
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}finally{
			try{
				
				if(rs!=null && !rs.isClosed()){
					rs.close();				
				}
				if(pstmt!=null && !pstmt.isClosed()){
					pstmt.close();
					
				}
				
				if(conn != null && (!conn.isClosed())){
					conn.close();
					
				}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
				
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
				
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportDaoImpl:getcountLocationByGroup  Ending");
		
		
		return emplist;
	}
	
	
	
	
	
	}
	
	
	

