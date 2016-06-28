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
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.GroupLocationMapDao;
import com.centris.VO.GroupLocationMapVO;
import com.centris.action.GroupLocationMapAction;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author Swathi
 *
 */
public class GroupLocationMapDaoImpl extends DBService implements GroupLocationMapDao{
	
	
	
 private static Logger logger = Logger.getLogger(GroupLocationMapDaoImpl.class);

 public synchronized List<GroupLocationMapVO> getGroup() {
	logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:getGroup Starting");
	
		PreparedStatement pstmt=null;
		 Connection connection=null;
		 ResultSet rsgroup=null;
		 ArrayList<GroupLocationMapVO> grouplocationlist=new ArrayList<GroupLocationMapVO>();

		 
		 try{
	      connection = getConnection();
		 pstmt=connection.prepareStatement(SQLutilConstants.GET_GROUP);
	      rsgroup=   pstmt.executeQuery();
	   
	     while(rsgroup.next()){
	    	 GroupLocationMapVO groupvo=new GroupLocationMapVO();
	    	 groupvo.setGroupId(rsgroup.getString("Gorupid"));
	    	 groupvo.setGroupName(rsgroup.getString("GroupName"));
	    	 grouplocationlist.add(groupvo);
	     }
		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					if(rsgroup!=null && !rsgroup.isClosed() ){
						rsgroup.close();
					}
					
					if(pstmt!=null && !pstmt.isClosed()){
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
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GroupLocationMapAction:getGroup Ending");
		return grouplocationlist;
	}
	
	
	
	
	public synchronized List<GroupLocationMapVO> getLocation() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:getLocation Starting");
		
		PreparedStatement pstmt=null;
		 Connection connection=null;
		 ResultSet rslocation=null;
		 ArrayList<GroupLocationMapVO> grouplocationlist=new ArrayList<GroupLocationMapVO>();
		try{
		 connection = getConnection();
		 pstmt=connection.prepareStatement(SQLutilConstants.GET_LOCATION_DATA);
		 rslocation=   pstmt.executeQuery();
	     while(rslocation.next()){
	    	 GroupLocationMapVO groupvo=new GroupLocationMapVO();
	    	 groupvo.setLocationId(rslocation.getString("LocationCode"));
	    	 groupvo.setLocationName(rslocation.getString("Location"));
	    	 grouplocationlist.add(groupvo);
	     }
		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					if(rslocation!=null && !rslocation.isClosed()){
						rslocation.close();
					}
					
					if(pstmt!=null && !pstmt.isClosed()){
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupLocationMapAction:getLocation Ending");
		return grouplocationlist;
	}
	public synchronized String saveGroupLocationMapping(String groupId, JSONArray jsonloc) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:saveGroupLocationMapping Starting");
		PreparedStatement pstmtdelete=null;
		 Connection connection=null;
		 String result=null;
		 PreparedStatement pstmtdelete1=null;
		 
		
		try{
			 connection = getConnection();
			  pstmtdelete=connection.prepareStatement(SQLutilConstants.DELETE_GROUP_MAPPPING);
			 pstmtdelete.setString(1, groupId);
		   int count= pstmtdelete.executeUpdate();
			 	 if(jsonloc.length()==0){
				 return "success";
			 }
			 	
			 	pstmtdelete1=connection.prepareStatement(SQLutilConstants.INSERT_GROUP_LOCATION);
			for (int i = 0; i < jsonloc.length(); i++) {
					String deptid = (String)jsonloc.get(i);
					if(count>0){
						
						pstmtdelete1.setString(1, deptid);
						pstmtdelete1.setString(2, groupId);
					int	value=pstmtdelete1.executeUpdate();
					result=(value>0)?"success":"failure";
					}else{
						
						pstmtdelete1.setString(1, deptid);
						pstmtdelete1.setString(2, groupId);
					int	value=pstmtdelete1.executeUpdate();
					System.out.println(pstmtdelete1.toString());
					result=(value>0)?"success":"failure";
					}
			
			}	
			 if(pstmtdelete != null && (!pstmtdelete.isClosed())){
			 		pstmtdelete.getConnection().close();
			 	 }
			
		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					
					if(pstmtdelete1!=null && !pstmtdelete1.isClosed()){
						pstmtdelete1.close();
						
					}
					if(pstmtdelete!=null && !pstmtdelete.isClosed()){
						pstmtdelete.close();
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupLocationMapAction:saveGroupLocationMapping Ending");
			return result;
		}
	public synchronized List<GroupLocationMapVO> getMappedLoc(String groupId) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:getMappedLoc Starting");
		PreparedStatement pstmt=null;
		 Connection connection=null;
		 ResultSet rslocation=null;
		 
		 ArrayList<GroupLocationMapVO> grouplocationlist=new ArrayList<GroupLocationMapVO>();
		try{
		 connection = getConnection();
		 pstmt=connection.prepareStatement(SQLutilConstants.GET_MAPPED_LOCATION);
		 pstmt.setString(1, groupId);
		 rslocation=   pstmt.executeQuery();
	     while(rslocation.next()){
	    	 GroupLocationMapVO groupvo=new GroupLocationMapVO();
	    	 groupvo.setLocationId(rslocation.getString("LocationCode"));
	    	 groupvo.setLocationName(rslocation.getString("Location"));
	    	 grouplocationlist.add(groupvo);
	     }
		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					if(rslocation!=null && !rslocation.isClosed()){
						rslocation.close();
					}
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					
					if(connection != null && (!connection.isClosed()) ){
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupLocationMapAction:getMappedLoc Ending");
		return grouplocationlist;
	}


	

}
