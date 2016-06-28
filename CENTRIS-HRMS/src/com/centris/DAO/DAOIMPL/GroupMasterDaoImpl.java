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
import com.centris.DAO.GroupMasterDao;
import com.centris.POJO.GroupMasterPOJO;
import com.centris.VO.GroupMasterVO;

import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class GroupMasterDaoImpl extends DBService implements GroupMasterDao{
	
	
	
	
	private static Logger logger = Logger.getLogger(GroupMasterDaoImpl.class);
	public synchronized int addGroupDetails(GroupMasterPOJO groupMasterPOJO) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterDaoImpl:addGroupDetails Starting");
		int countval = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int value=0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.GET_GROUP_COUNT);
			pstmt.setString(1, groupMasterPOJO.getGroupName());
			 rs = pstmt.executeQuery();
			rs.next();
			countval = rs.getInt(1);
			if (countval > 0) {

			} else {
				pstmt = con.prepareStatement(SQLutilConstants.ADD_GROUP_DETAILS);
				pstmt.setString(1, groupMasterPOJO.getGroupId());
				pstmt.setString(2, groupMasterPOJO.getGroupName());
				pstmt.setString(3, groupMasterPOJO.getDescription());
				pstmt.setString(4, groupMasterPOJO.getUser());
				value = pstmt.executeUpdate();
				
			}

		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					if(rs!=null && !rs.isClosed()){
						rs.close();
					}
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					if(con != null && (!con.isClosed())){
						con.close();
						
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
				+ " Control in GroupMasterDaoImpl:addGroupDetails Ending");
		return value;
	}
	

	public synchronized ArrayList<GroupMasterVO> getGroupDetails() {
		ArrayList<GroupMasterVO> grouplist = new ArrayList<GroupMasterVO>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterDaoImpl:getGroupDetails Starting");
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsgroup = null;
		
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.GET_GROUP_DETAILS);
			 rsgroup = pstmt.executeQuery();
			while (rsgroup.next()) {
				GroupMasterVO groupmasterVO= new GroupMasterVO();
				groupmasterVO.setGroupId(rsgroup.getString("Gorupid"));
				groupmasterVO.setGroupName(rsgroup.getString("GroupName"));
				groupmasterVO.setDescription(rsgroup.getString("Description"));
			grouplist.add(groupmasterVO);
			}

		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					if(rsgroup!=null && !rsgroup.isClosed()){
						rsgroup.close();
					}
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					if(con != null && (!con.isClosed())){
						con.close();
						
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
				+ " Control in GroupMasterDaoImpl:getGroupDetails Ending");
		return grouplist;
	}



	public synchronized ArrayList<GroupMasterVO> editGroupDetails(String groupID) {
		ArrayList<GroupMasterVO> grouplist = new ArrayList<GroupMasterVO>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterDaoImpl:editGroupDetails Starting");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsgroup = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.EDIT_GROUP_DETAILS);
			pstmt.setString(1, groupID);
			 rsgroup = pstmt.executeQuery();
			while (rsgroup.next()) {
				GroupMasterVO groupmasterVO = new GroupMasterVO();
				groupmasterVO.setGroupId(rsgroup.getString("Gorupid"));
				groupmasterVO.setGroupName(rsgroup.getString("GroupName"));
				groupmasterVO.setDescription(rsgroup.getString("Description"));
				grouplist.add(groupmasterVO);
			}

		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					
					if(rsgroup!=null && !rsgroup.isClosed()){
						rsgroup.close();
					}
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					if(con != null && (!con.isClosed())){
						con.close();
						
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
				+ " Control in GroupMasterDaoImpl:editGroupDetails Ending");
		return grouplist;
	}


	public synchronized String updateGroupDetailsVal(GroupMasterPOJO groupMasterPOJO) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterDaoImpl:updateGroupDetailsVal Starting");
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.UPDATE_GROUP_DETAILS);
			pstmt.setString(1, groupMasterPOJO.getGroupName());
			pstmt.setString(2, groupMasterPOJO.getDescription());
			pstmt.setString(3, groupMasterPOJO.getModifiedby());
			pstmt.setTimestamp(4, groupMasterPOJO.getModifieddate());
			pstmt.setString(5, groupMasterPOJO.getGroupId());
		int result = pstmt.executeUpdate();
		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					
					
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					if(con != null && (!con.isClosed())){
						con.close();
						
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
				+ " Control in GroupMasterDaoImpl:updateGroupDetailsVal Ending");
		return null;
	}

	public synchronized String deleteGroupDetailsVal(String[] groupIdval) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterDaoImpl:deleteGroupDetailsVal Starting");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet grouprs=null;
		int no=0;
		String status=null;
		
		
		try {
			con = getConnection();
			
			
			
			pstmt = con.prepareStatement(SQLutilConstants.CHECK_GROUP_USER_MAPPING);
			
			for (int i = 0; i < groupIdval.length; i++) {
				
			
				pstmt.setString(1, groupIdval[i]);
				grouprs=pstmt.executeQuery();
				
				while(grouprs.next()){
					
					no=grouprs.getInt(1);
				}
				
				if(no>0){
					
					status="Unable to Delete : Group is in Use";
					
				}else{
					
					pstmt = con.prepareStatement(SQLutilConstants.DELETE_GROUP);
					pstmt.setString(1, groupIdval[i]);
					no=pstmt.executeUpdate();
					
					if(no>0){
						
						status="Group Deleted Successfully";
					}else{
						
						status="Group not Deleted";
					}
					
					if(pstmt != null && (!pstmt.isClosed())){
						pstmt.getConnection().close();
					}
				}
				
				
				
			}
			
			if(pstmt != null && (!pstmt.isClosed())){
				pstmt.getConnection().close();
			}

		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					if(grouprs!=null && !grouprs.isClosed()){
						grouprs.close();
					}
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					if(con != null && (!con.isClosed())){
						con.close();
						
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
				+ " Control in GroupMasterDaoImpl:deleteGroupDetailsVal Ending");
		return status;
	}
	

	public synchronized String validateGroupDetailsVal(GroupMasterPOJO groupMasterPOJO) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterDaoImpl:validateGroupDetailsVal Starting");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		int countval = 0;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.CHECK_GROUP_NAME);
			pstmt.setString(1, groupMasterPOJO.getGroupName());
			pstmt.setString(2, groupMasterPOJO.getGroupId());
			 rs = pstmt.executeQuery();
			rs.next();
			countval = rs.getInt(1);
          System.out.println(pstmt.toString());
		
		} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					
					if(rs!=null && !rs.isClosed()){
						rs.close();
					}
					
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					if(con != null && (!con.isClosed())){
						con.close();
						
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
				+ " Control in GroupMasterDaoImpl:validateGroupDetailsVal Ending");
		if (countval > 0) {
			return "Exit";
		} else {
			return "NotExit";
		}
	
	}


	@Override
	public synchronized ArrayList<GroupMasterVO>  getGroupDetailsbyCurrentUser(String currentUserId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterDaoImpl:getGroupDetailsbyCurrentUser  Starting");
	ArrayList<GroupMasterVO> getGroupByUser=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		
		try {
			getGroupByUser=	new ArrayList<GroupMasterVO>();
			con = getConnection();
			pstmt = con.prepareStatement(SQLutilConstants.GET_GROUP_BY_CURRENTUSER);
			pstmt.setString(1,currentUserId);
			System.out.println("Pstmt"+pstmt);
			 rs = pstmt.executeQuery();
			while(rs.next()){
				GroupMasterVO groupMasterVO=new GroupMasterVO();
				groupMasterVO.setGroupId(rs.getString("Gorupid"));
				groupMasterVO.setGroupName(rs.getString("GroupName"));
				System.out.println("GId in Dao:::"+rs.getString("Gorupid"));
				System.out.println("GName in Dao:::"+rs.getString("GroupName"));
				getGroupByUser.add(groupMasterVO);
			}
			
		
          System.out.println(pstmt.toString());
		
		} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
				try{
					

					
					if(rs!=null && !rs.isClosed()){
						
						rs.close();
					}
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					if(con != null && (!con.isClosed())){
						con.close();
						
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
				+ " Control in GroupMasterDaoImpl:getGroupDetailsbyCurrentUser Ending");
		// TODO Auto-generated method stub
		return getGroupByUser;
	}

}
