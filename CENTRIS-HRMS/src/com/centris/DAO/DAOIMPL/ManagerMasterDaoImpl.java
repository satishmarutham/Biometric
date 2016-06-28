package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.ManagerMasterDao;
import com.centris.POJO.ManagerMasterPojo;
import com.centris.POJO.ProjectMasterPojo;
import com.centris.VO.ManagerMasterVO;
import com.centris.VO.ProjectMasterVo;

import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.Manager;
import com.centris.util.SQLUtils.ProjectDetails;
import com.centris.util.constants.MessageConstants;

public class ManagerMasterDaoImpl extends DBService implements ManagerMasterDao {
	
	private static Logger logger = Logger.getLogger(ProjectMasterDaoImpl.class);
	public ArrayList<ManagerMasterVO> getmanagerDetailsDao(){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: getmanagerDetailsDao : Starting");
		
		
		PreparedStatement ps_manager = null;
		ResultSet rs_manager = null;
		Connection connection = null;
	
		ArrayList<ManagerMasterVO> managerDataList=new ArrayList<ManagerMasterVO>();
		try {
			connection = getConnection();
			
		

			ps_manager = connection.prepareStatement(Manager.GET_ALL_MANAGERS);
			
			rs_manager = ps_manager.executeQuery();

				while(rs_manager.next()){
					
					ManagerMasterVO managerVO=new ManagerMasterVO();
					
					managerVO.setManagerid(rs_manager.getString("ManagerCode"));
					managerVO.setFirstname(rs_manager.getString("FirstName"));
					managerVO.setLastname(rs_manager.getString("LastName"));
					managerVO.setMobileno(rs_manager.getString("phoneno"));
					managerVO.setUsername(rs_manager.getString("Username"));
					managerVO.setManageremail(rs_manager.getString("email"));
					managerVO.setDepartmentName(rs_manager.getString("DEPT_NAME"));
					managerVO.setDepartment(rs_manager.getString("DepartmentId"));
					managerDataList.add(managerVO);
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (rs_manager != null && (!rs_manager.isClosed())) {

					rs_manager.close();
				}
				if (ps_manager != null && (!ps_manager.isClosed())) {

					ps_manager.close();
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

				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: getmanagerDetailsDao : Ending");
		
		return managerDataList;
	}

	public  String addManagerDao(ManagerMasterPojo managerpojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl:addManagerDao : Starting");
		
		PreparedStatement ps_manager_add = null;
		Connection connection = null;
		int no = 0;
		String status = null;

		try {
			connection = getConnection();
		

			ps_manager_add = connection.prepareStatement(Manager.ADD_MANAGER);
			
			if(!new ManagerMasterDaoImpl().checkManagerCountDao(managerpojo.getUsername())){
			
				ps_manager_add.setString(1,managerpojo.getManagerid());
				ps_manager_add.setString(2,managerpojo.getFirstname());
				ps_manager_add.setString(3,managerpojo.getLastname());
				ps_manager_add.setString(4,managerpojo.getMobileno());
				ps_manager_add.setString(5,MessageConstants.MANAGER_PASSWORD);
				ps_manager_add.setString(6,managerpojo.getUsername());
				ps_manager_add.setString(7,managerpojo.getManageremail());
				ps_manager_add.setString(8, managerpojo.getDepartment());
				ps_manager_add.setString(9, MessageConstants.MANAGER_STATUS);
				ps_manager_add.setString(10, managerpojo.getCreatedby());

				no = ps_manager_add.executeUpdate();
				
				if (no > 0) {
					String url=getServerUrlFromBD(connection);
					String result=sendEmailToManager(managerpojo.getManageremail(),managerpojo.getUsername(),MessageConstants.MANAGER_PASSWORD,url);
					status = MessageConstants.MANAGER_ADD_SUCCESS;
					
				} else {

					status = MessageConstants.MANAGER_ADD_FAILED;
				}
			}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (ps_manager_add != null && (!ps_manager_add.isClosed())) {

					ps_manager_add.close();
				}
				if (connection != null && (!connection.isClosed())) {

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

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in Control in ManagerMasterDaoImpl: addManagerDao : Ending");
		
		return status;

	}

	
	public boolean checkManagerCountDao(String username) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: checkManagerCount : Starting");
		
		PreparedStatement ps_manager_count = null;
		Connection connection = null;
		ResultSet rs_manager_count=null;
		int no = 0;
		boolean status=false;
		
		try {
			connection = getConnection();

			ps_manager_count = connection.prepareStatement(Manager.COUNT_MANAGER_USERNAME);
			
			ps_manager_count.setString(1, username);
				

			rs_manager_count = ps_manager_count.executeQuery();
			
		

				while(rs_manager_count.next()){
					
					no=rs_manager_count.getInt(1);
				}
				
				if(no>0){
					
					status=true;
				}else{
					
					status=false;
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_manager_count != null && (!rs_manager_count.isClosed())) {

					rs_manager_count.close();
				}
				if (ps_manager_count != null && (!ps_manager_count.isClosed())) {

					ps_manager_count.close();
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

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: checkManagerCount : Ending");
		
		return status;
	}
	
	
	public boolean checkMangerCountUpdateDao(String userName,String managerid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: checkMangerCountUpdate : Starting");
		
		PreparedStatement ps_manager_count = null;
		Connection connection = null;
		ResultSet rs_manager_count=null;
		int no = 0;
		boolean status=false;
		
		try {
			connection = getConnection();

			ps_manager_count = connection.prepareStatement(Manager.COUNT_MANAGER_UPDATE);
			
			ps_manager_count.setString(1, userName);
			ps_manager_count.setString(2, managerid);
				

			rs_manager_count = ps_manager_count.executeQuery();

				while(rs_manager_count.next()){
					
					no=rs_manager_count.getInt(1);
				}
				
				if(no>0){
					
					status=true;
					
				}else{
					
					status=false;
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_manager_count != null && (!rs_manager_count.isClosed())) {

					rs_manager_count.close();
				}
				if (ps_manager_count != null && (!ps_manager_count.isClosed())) {

					ps_manager_count.close();
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

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: checkMangerCountUpdate : Ending");
		
		return status;

	}
	
	public  ArrayList<ManagerMasterVO> editManagerDetailsDao(String managerID){

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: editManagerDetails : Starting");
		
		PreparedStatement ps_manager_get = null;
		ResultSet rs_manager_get = null;
		Connection connection = null;
		ArrayList<ManagerMasterVO> managerList=new ArrayList<ManagerMasterVO>();

		try {
			connection = getConnection();
			
			ps_manager_get = connection.prepareStatement(Manager.GET_SINGLE_MANAGER);
			ps_manager_get.setString(1, managerID);
			
			rs_manager_get = ps_manager_get.executeQuery();

				while(rs_manager_get.next()){
					
					ManagerMasterVO managerVO=new ManagerMasterVO();
					managerVO.setManagerid(rs_manager_get.getString("ManagerCode"));
					managerVO.setFirstname(rs_manager_get.getString("FirstName"));
					managerVO.setLastname(rs_manager_get.getString("LastName"));
					managerVO.setMobileno(rs_manager_get.getString("phoneno"));
					managerVO.setUsername(rs_manager_get.getString("Username"));
					managerVO.setManageremail(rs_manager_get.getString("email"));
					managerVO.setDepartmentName(rs_manager_get.getString("DEPT_NAME"));
					managerVO.setDepartment(rs_manager_get.getString("DepartmentId"));
					
					
					
					
					managerList.add(managerVO);
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_manager_get != null && (!rs_manager_get.isClosed())) {

					rs_manager_get.close();
				}
				if (ps_manager_get != null && (!ps_manager_get.isClosed())) {

					ps_manager_get.close();
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

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: editManagerDetails : Ending");
		
		return managerList;

	}

	public  String UpdateManagerDao(ManagerMasterPojo managerpojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: UpdateManager : Starting");
		
		PreparedStatement ps_manager_update = null;
		Connection connection = null;
		int no = 0;
		String status = null;

		try {
			connection = getConnection();
			
		

			ps_manager_update = connection.prepareStatement(Manager.UPDATE_MANAGER);
			
			
			ps_manager_update.setString(1,managerpojo.getFirstname());
			ps_manager_update.setString(2,managerpojo.getLastname());
			ps_manager_update.setString(3,managerpojo.getMobileno());
			ps_manager_update.setString(4,managerpojo.getUsername());
			ps_manager_update.setString(5,managerpojo.getManageremail());
			ps_manager_update.setString(6,managerpojo.getDepartment());
			ps_manager_update.setString(7,managerpojo.getCreatedby());
			ps_manager_update.setString(8,managerpojo.getManagerid());
			
				

				no = ps_manager_update.executeUpdate();

				if (no > 0) {

					status = MessageConstants.MANAGET_UPDATE_SUCCESS;
				} else {

					status = MessageConstants.MANAGER_UPDATE_FAILED;
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (ps_manager_update != null && (!ps_manager_update.isClosed())) {

					ps_manager_update.close();
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

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: UpdateManager : Ending");
		
		return status;

	}


	public  String deleteManagerDao(String[] managerId){

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: deleteManagerDao : Starting");
		
		PreparedStatement ps_manager_get = null;
		PreparedStatement ps_manager_delete = null;
		
		PreparedStatement ps_manager_get1=null;
		PreparedStatement ps_manager_get2=null;
		
		ResultSet rs_manager_get = null;
		ResultSet rs_manager_get1 = null;
		ResultSet rs_manager_get2 = null;
		
		
		Connection connection = null;
		int count=0;
		String status=null;
		int no=0;
		
		

		try {
			connection = getConnection();
			
			ps_manager_get = connection.prepareStatement(Manager.PROJECT_MANAGER_MAPPING_COUNT);
			ps_manager_delete=connection.prepareStatement(Manager.DELETE_MANAGER);
			
			for(int i=0;i<managerId.length;i++){
			
				ps_manager_get.setString(1, managerId[i]);
			
		
			
			rs_manager_get = ps_manager_get.executeQuery();

			rs_manager_get.next();
					
			count=rs_manager_get.getInt(1);
			
			
			if(count==0){
				ps_manager_get1 = connection.prepareStatement(Manager.MANAGER_COUNT_IN_EMPLOYEE_TABLE);
				ps_manager_get1.setString(1, managerId[i]);
				
				
				
				rs_manager_get1 = ps_manager_get1.executeQuery();

				rs_manager_get1.next();
						
				count=rs_manager_get1.getInt(1);
				
			
				if(count==0){
					
					ps_manager_get2 = connection.prepareStatement(Manager.MANAGER_COUNT_IN_EMPLOYEE_ATTENDANCE_TABLE);
					ps_manager_get2.setString(1, managerId[i]);
					
				
					
					rs_manager_get2 = ps_manager_get2.executeQuery();

					rs_manager_get2.next();
							
					count=rs_manager_get2.getInt(1);
				
				
					if(count>0){
						
						 status=MessageConstants.MANAGER_USED_STATUS;
					}else{
						
						ps_manager_delete.setString(1, managerId[i]);
						
						
						
						no=ps_manager_delete.executeUpdate();
						
						if(no>0){
							
							status=MessageConstants.MANAGER_DELETE_SUCCESS;
							
						}else{
							
							status=MessageConstants.MANAGER_DELETE_FAILED;
						}
					}
				
				
				}else{
					
					 status=MessageConstants.MANAGER_USED_STATUS;
					
				}
				
				
				
				
			}else{
				
				 status=MessageConstants.MANAGER_USED_STATUS;
			}	
			
			
			
				
				
				
			}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {
				if (ps_manager_delete != null && (!ps_manager_delete.isClosed())) {

					ps_manager_delete.close();
				}
				if (rs_manager_get2 != null && (!rs_manager_get2.isClosed())) {

					rs_manager_get2.close();
				}
				if (ps_manager_get2 != null && (!ps_manager_get2.isClosed())) {

					ps_manager_get2.close();
				}
				
				  if (rs_manager_get1 != null && (!rs_manager_get1.isClosed())) {

						rs_manager_get1.close();
					}
					if (ps_manager_get1 != null && (!ps_manager_get1.isClosed())) {

						ps_manager_get1.close();
					}
									
				if (rs_manager_get != null && (!rs_manager_get.isClosed())) {

					rs_manager_get.close();
				}
				if (ps_manager_get != null && (!ps_manager_get.isClosed())) {

					ps_manager_get.close();
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

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ManagerMasterDaoImpl: deleteManagerDao : Ending");
		
		return status;

	}
    public boolean checkManagerEmailCountDao(String email) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: checkManagerEmailCountDao : Starting");
		
		PreparedStatement ps_manager_email_count = null;
		Connection connection = null;
		ResultSet rs_manager_email_count=null;
		int no = 0;
		boolean  status=false;
		
		try {
			connection = getConnection();

			ps_manager_email_count = connection.prepareStatement(Manager.COUNT_MANAGER_EMAIL);
			
			ps_manager_email_count.setString(1, email);
				

			rs_manager_email_count = ps_manager_email_count.executeQuery();

				while(rs_manager_email_count.next()){
					
					no=rs_manager_email_count.getInt(1);
				}
				
				if(no>0){
					
					status=true;
				}else{
					
					status=false;
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_manager_email_count != null && (!rs_manager_email_count.isClosed())) {

					rs_manager_email_count.close();
				}
				if (ps_manager_email_count != null && (!ps_manager_email_count.isClosed())) {

					ps_manager_email_count.close();
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

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: checkManagerEmailCountDao : Ending");
		
		return status;
	}
    
    
 public boolean checkManagerEmailUpdateCountDao(String email,String managerID) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: checkManagerEmailUpdateCountDao : Starting");
		
		PreparedStatement ps_manager_email_count = null;
		Connection connection = null;
		ResultSet rs_manager_email_count=null;
		int no = 0;
		boolean  status=false;
		
		try {
			connection = getConnection();

			ps_manager_email_count = connection.prepareStatement(Manager.COUNT_MANAGER_UPDATE_EMAIL);
			
			ps_manager_email_count.setString(1, email);
			ps_manager_email_count.setString(2, managerID);
			
				

			rs_manager_email_count = ps_manager_email_count.executeQuery();
			
		
				while(rs_manager_email_count.next()){
					
					no=rs_manager_email_count.getInt(1);
				}
				
				if(no>0){
					
					status=true;
				}else{
					
					status=false;
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_manager_email_count != null && (!rs_manager_email_count.isClosed())) {

					rs_manager_email_count.close();
				}
				if (ps_manager_email_count != null && (!ps_manager_email_count.isClosed())) {

					ps_manager_email_count.close();
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

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterDaoImpl: checkManagerEmailUpdateCountDao : Ending");
		
		return status;
	}

	
	public String sendEmailToManager(String emailId,String userName,String password,String url) {
		try{
			EmailContent em = new EmailContent();
			String[] mails={emailId};
			
			em.setMailids(mails);
			em.setSubject("Registration Details");

			em.setMessage("Greetings from TeleIndia. \n" +
					" You have successfully registered in portal. \n" +
					"Please use the below credentials to approve employee Attendance and other features.\n\n" +
					"URL		: "+url+"\n"+
					"UserId		: "+userName+"\n"+
					"Password	: "+password+"\n\n");
				new SendMailWithMultipleAttachment().sendReportToMail(em);
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "sent";
	}
	
	public String getServerUrlFromBD(Connection connection) {
		String url="";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=connection.prepareStatement(Employee.GET_SERVER_URL);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				url=rs.getString("URL");
			}
			
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return url;
	}

}
