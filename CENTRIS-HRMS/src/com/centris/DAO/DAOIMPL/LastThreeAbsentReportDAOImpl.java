package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.VO.LastThreeAbsentReportVO;
import com.centris.form.LastThreeAbsentReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class LastThreeAbsentReportDAOImpl extends DBService {
	
	private static 	Logger logger = Logger.getLogger(LastThreeAbsentReportDAOImpl.class);
	
	public Map<String,List<LastThreeAbsentReportVO>> getLastThreeAbsentReport(LastThreeAbsentReportForm lastThreeAbsentReportForm){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LastThreeAbsentReportDAOImpl :getLastThreeAbsentReport: Starting");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection=null;
		LastThreeAbsentReportVO lastThreeAbsentReportVO=null;
		Map<String,List<LastThreeAbsentReportVO>> lastThreeAbsentReporMapList = new  LinkedHashMap<String,List<LastThreeAbsentReportVO>>();
		try{
			connection=getConnection();
			List<LastThreeAbsentReportVO> lastThreeAbsentReportVOList = new ArrayList<LastThreeAbsentReportVO>();
			List<String> lastThreeDateList=HelperClass.getLastThreeDateFromNow(HelperClass.convertUIToDatabase(lastThreeAbsentReportForm.getDate()));
			String lastThreeDate="'"+lastThreeDateList.get(0)+"','"+lastThreeDateList.get(1)+"','"+lastThreeDateList.get(2)+"'";
			String displayDateFormate=lastThreeDateList.get(0).substring(8, 10)+","+lastThreeDateList.get(1).substring(8, 10)+","+HelperClass.convertDatabaseToTitle(lastThreeDateList.get(2));
			String temp_location="'"+lastThreeAbsentReportForm.getLocation().replaceAll(",","','")+"'";
			pstmt = connection.prepareStatement("select ed.empid,ed.EMPNAME,group_concat(ea.DATE order by ea.DATE) Date,el.Location,ea.status from ai_emp_attendance ea,ai_emp_location el,ai_emp_details ed where ea.empid=ed.EMPID and ea.LOCATION_CODE=el.LocationCode and LOCATION_CODE in ("+temp_location+") and LOCATION_CODE in (select LocationCode from onsite_groupmapping where Groupid=?) and status='absent' and DATE in ("+lastThreeDate+") group by empid,EMPNAME,Location,status order by Location,empid  "); 
			pstmt.setString(1, lastThreeAbsentReportForm.getGroup());
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			String prevLocation="";
			String nextLocation="";
			while(rs.next())
			{
				 nextLocation=rs.getString("Location");
				 
				if(!prevLocation.equals("") && !prevLocation.equals(nextLocation)){
					if(lastThreeAbsentReportVOList.size()>0)
					lastThreeAbsentReporMapList.put(prevLocation, lastThreeAbsentReportVOList) ;
					lastThreeAbsentReportVOList=new ArrayList<LastThreeAbsentReportVO>();
				}
			
				lastThreeAbsentReportVO= new LastThreeAbsentReportVO();
				lastThreeAbsentReportVO.setEmpId(rs.getString("empid"));
				lastThreeAbsentReportVO.setEmpName(rs.getString("EMPNAME"));
				String dateString=rs.getString("DATE");
				
				lastThreeAbsentReportVO.setDate(displayDateFormate);
				lastThreeAbsentReportVO.setLocation(nextLocation);
				lastThreeAbsentReportVO.setStatus(rs.getString("status"));
				
				String[] dateStringArray = dateString.split(",");
				
				if(dateStringArray.length==3)
					lastThreeAbsentReportVOList.add(lastThreeAbsentReportVO);
				
				prevLocation=nextLocation;
			}
			if(lastThreeAbsentReportVOList.size()>0)
			lastThreeAbsentReporMapList.put(prevLocation, lastThreeAbsentReportVOList) ;
       
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		}finally{
			try{
				

				if(rs != null && (!rs.isClosed())){
					
					rs.close();
				}
				if(pstmt != null && (!pstmt.isClosed())){
					
					pstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in LastThreeAbsentReportDAOImpl: getLastThreeAbsentReport : Ending");
		return lastThreeAbsentReporMapList;
	}
	
	
	
	public synchronized List<LastThreeAbsentReportVO> getLastThreeAbsentReport( String group,String date){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LastThreeAbsentReportDAOImpl :getLastThreeAbsentReport: Starting");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection=null;
		LastThreeAbsentReportVO lastThreeAbsentReportVO=null;
		List<LastThreeAbsentReportVO> lastThreeAbsentReportVOList = new ArrayList<LastThreeAbsentReportVO>();
		try{
			connection=getConnection();
			
			List<String> lastThreeDateList=HelperClass.getLastThreeDateFromNow(date);
			String lastThreeDate="'"+lastThreeDateList.get(0)+"','"+lastThreeDateList.get(1)+"','"+lastThreeDateList.get(2)+"'";
			String displayDateFormate=lastThreeDateList.get(0).substring(8, 10)+","+lastThreeDateList.get(1).substring(8, 10)+","+HelperClass.convertDatabaseToTitle(lastThreeDateList.get(2));
			pstmt = connection.prepareStatement("select ed.empid,ed.EMPNAME,group_concat(ea.DATE order by ea.DATE) Date,el.Location,ea.status from ai_emp_attendance ea,ai_emp_location el,ai_emp_details ed where ea.empid=ed.EMPID and ea.LOCATION_CODE=el.LocationCode and LOCATION_CODE in (select LocationCode from onsite_groupmapping where Groupid=?) and status='absent' and DATE in ("+lastThreeDate+") group by empid,EMPNAME,Location,status order by Location,empid  "); 
			pstmt.setString(1, group);
			rs = pstmt.executeQuery();
			
				String prevLocation="";
				String nextLocation="";
				while(rs.next())
				{
					 nextLocation=rs.getString("Location");
					 
					if(!prevLocation.equals("") && !prevLocation.equals(nextLocation)){
						lastThreeAbsentReportVOList=new ArrayList<LastThreeAbsentReportVO>();
					}
				
					lastThreeAbsentReportVO= new LastThreeAbsentReportVO();
					lastThreeAbsentReportVO.setEmpId(rs.getString("empid"));
					lastThreeAbsentReportVO.setEmpName(rs.getString("EMPNAME"));
					String dateString=rs.getString("DATE");
					
					lastThreeAbsentReportVO.setDate(displayDateFormate);
					lastThreeAbsentReportVO.setLocation(nextLocation);
					lastThreeAbsentReportVO.setStatus(rs.getString("status"));
					
					String[] dateStringArray = dateString.split(",");
					
					if(dateStringArray.length==3)
						lastThreeAbsentReportVOList.add(lastThreeAbsentReportVO);
					
					prevLocation=nextLocation;
				
				
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		}finally{
			try{
				

				if(rs != null && (!rs.isClosed())){
					
					rs.close();
				}
				if(pstmt != null && (!pstmt.isClosed())){
					
					pstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in LastThreeAbsentReportDAOImpl: getLastThreeAbsentReport : Ending");
		return lastThreeAbsentReportVOList;
	}
	
	
	public Map<String,LastThreeAbsentReportVO> getUserDetails(){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LastThreeAbsentReportDAOImpl :getUserDetails: Starting");
		Map<String,LastThreeAbsentReportVO> LastThreeAbsentReportMap = new HashMap<String, LastThreeAbsentReportVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LastThreeAbsentReportVO lastThreeAbsentReportVO=null;
		Connection connection=null;
		try{
			connection=getConnection();
			pstmt = connection.prepareStatement("select userCode,username,groupCode,mob_no,email_id,CC1,CC2,CC3 from ai_user  where userCode<>'USR1'"); 
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				lastThreeAbsentReportVO=new LastThreeAbsentReportVO();
				lastThreeAbsentReportVO.setEmail(rs.getString("email_id"));
				lastThreeAbsentReportVO.setCcEmail_1(rs.getString("CC1"));
				lastThreeAbsentReportVO.setCcEmail_2(rs.getString("CC2"));
				lastThreeAbsentReportVO.setCcEmail_3(rs.getString("CC3"));
				lastThreeAbsentReportVO.setMobileNo(rs.getString("mob_no"));
				lastThreeAbsentReportVO.setGroupId(rs.getString("groupCode"));
				lastThreeAbsentReportVO.setUserId(rs.getString("userCode"));
				lastThreeAbsentReportVO.setUserName(rs.getString("username"));
				LastThreeAbsentReportMap.put(lastThreeAbsentReportVO.getUserId(), lastThreeAbsentReportVO);
			}
       
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		}
		finally{

			try{
				

				if(rs != null && (!rs.isClosed())){
					
					rs.close();
				}
				if(pstmt != null && (!pstmt.isClosed())){
					
					pstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in LastThreeAbsentReportDAOImpl: getUserDetails : Ending");
		return LastThreeAbsentReportMap;
	}
	
}
