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
import org.json.JSONObject;

import com.centris.DAO.DBService;
import com.centris.DAO.DepartmentMasterDAO;
import com.centris.POJO.DepartmentMasterPojo;
import com.centris.VO.DepartmentMasterVO;
import com.centris.action.DepartmentMasterAction;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.DepartmentMaster;
import com.centris.util.SQLUtils.SQLtableconstants;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class DepartmentMasterDAOImpl extends DBService implements DepartmentMasterDAO {

	private static Logger logger = Logger
			.getLogger(DepartmentMasterAction.class);

	@Override
	public synchronized List<DepartmentMasterVO> getDepRecordsDao() {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : getDepRecordsDao : Starting");

		PreparedStatement departmenPstmt = null;
		ResultSet departmentsResultSet = null;
		List<DepartmentMasterVO> depRecords = new ArrayList<DepartmentMasterVO>();
		Connection connection=null;
		try {
			connection =getConnection();
			departmenPstmt = connection
					.prepareStatement(DepartmentMaster.GET_ALL_DEPARTMENT);

			departmentsResultSet = departmenPstmt.executeQuery();
			while (departmentsResultSet.next()) {

				DepartmentMasterVO depVO = new DepartmentMasterVO();
				depVO.setDepId(departmentsResultSet.getString("DEPT_ID"));
				depVO.setDepName(departmentsResultSet.getString("DEPT_NAME"));
				depVO.setDesc(departmentsResultSet.getString("DESCRIPTION"));
				depVO.setHrManagerMail(departmentsResultSet.getString("HR_MNGR_MAIL"));
				depVO.setOnsiteManagerMail(departmentsResultSet.getString("ONSITE_MNGR_MAIL"));
				depVO.setLocManagerMail(departmentsResultSet.getString("LOCAL_MNGR_MAIL"));
				depRecords.add(depVO);
				
				
			}

		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			
		} finally {

			try {
				
				if(departmentsResultSet != null && (!departmentsResultSet.isClosed())){
					
					departmentsResultSet.close();
				}
				if(departmenPstmt != null && (!departmenPstmt.isClosed())){
					
					departmenPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : getDepRecordsDao : Ending");

		return depRecords;

	}

	@Override
	public synchronized String deleteDepartmentDAO(String id, String loc) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : deleteDepartmentDAO : Starting");

		PreparedStatement departmenPstmt = null;
		
		PreparedStatement ps_delete = null;
		ResultSet departmentrs = null;
		
		Connection connection=null;
		String status = null;
		int count = 0;
		try {
			connection=getConnection();
			departmenPstmt = connection
					.prepareStatement(DepartmentMaster.EXIST_DEPARTMENT_EMP);
			departmenPstmt.setString(1, id);
			departmentrs = departmenPstmt.executeQuery();

			while (departmentrs.next()) {

				count = departmentrs.getInt(1);

				if (count > 0) {

					status = "Unable to Delete : Department is in Use";

				} else {

				ps_delete = connection
									.prepareStatement(DepartmentMaster.deleteDep);
							ps_delete.setString(1,id);
							ps_delete.setString(2,id);

							count = ps_delete.executeUpdate();

							if (count > 0) {
								status = "Department Deleted Successfully";
							} else {
								status = "Department Not Deleted";
							}

						}
					}
			if(departmenPstmt != null && (!departmenPstmt.isClosed())){
				departmenPstmt.getConnection().close();
			}
		} catch (SQLException sqle) {

			sqle.printStackTrace();
			logger.error(sqle);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {

			try {
				
				if(departmentrs != null && (!departmentrs.isClosed())){
					
					departmentrs.close();
				}
				if(ps_delete != null && (!ps_delete.isClosed())){

					ps_delete.close();
				}
				
				if(departmenPstmt != null && (!departmenPstmt.isClosed())){
					
					departmenPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				 

			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
			finally{
				
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : deleteDepartmentDAO : Ending");
		return status;
		}
	}

	public synchronized String addDepartmentDAO(DepartmentMasterPojo dpojo, String createdby) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : addDepartmentDAO : Starting");

		PreparedStatement departmenPstmt = null;
		IDGenerator idgenerator = new IDGenerator();
		int count1 = 0;
		String status = null;
		Connection connection=null;

		try {
			connection=getConnection();
			boolean isDeptDuplicate=checkDepartmentDuplicate(dpojo.getDeptname(),dpojo.getDeptdes());
			if(!isDeptDuplicate){
				departmenPstmt = connection.prepareStatement(DepartmentMaster.INSERT_DEPARTMENT);
				departmenPstmt.setString(1,idgenerator.getPrimaryKeyID("hrms_department"));
				departmenPstmt.setString(2,dpojo.getDeptname());
				departmenPstmt.setString(3,dpojo.getDeptdes());
				/*departmenPstmt.setString(4,dpojo.getLocManagerMail());
				departmenPstmt.setString(5,dpojo.getHrManagerMail());
				departmenPstmt.setString(6,dpojo.getOnsiteManagerMail());*/
				departmenPstmt.setTimestamp(4,HelperClass.getCurrentTimestamp());
				departmenPstmt.setString(5,createdby);
				
				count1 = departmenPstmt.executeUpdate();
	
				if (count1 > 0) {
	
					status = "Department added successfully";
				} else {
	
					status = "Department not added successfully";
				}
			}
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {

			try {
				
				if(departmenPstmt != null && (!departmenPstmt.isClosed())){
					
					departmenPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}


			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : addDepartmentDAO : Ending");
		return status;
	}

	public synchronized String updateDepartmentDAO(DepartmentMasterPojo dpojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : updateDepartmentDAO : Starting");

		PreparedStatement departmenPstmt = null;
		int count = 0;
		String status = null;
		Connection connection=null;

		try {
			connection=getConnection();
			departmenPstmt = connection
					.prepareStatement(DepartmentMaster.UPDATE_DEPARTMENT);
			departmenPstmt.setString(1,dpojo.getDeptname());
			departmenPstmt.setString(2,dpojo.getDeptdes());
		/*	departmenPstmt.setString(3,dpojo.getLocManagerMail());
			departmenPstmt.setString(4,dpojo.getHrManagerMail());
			departmenPstmt.setString(5,dpojo.getOnsiteManagerMail());*/
			departmenPstmt.setTimestamp(3, HelperClass.getCurrentTimestamp());
			departmenPstmt.setString(4,dpojo.getDeptid());
			count = departmenPstmt.executeUpdate();
			if (count > 0) {

				status = "Department Updated successfully";
			} else {

				status = "Department not Updated ";

			}

		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {

			try {
				
				if(departmenPstmt != null && (!departmenPstmt.isClosed())){
					
					departmenPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}


			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : updateDepartmentDAO : Ending");

		return status;

	}

	public synchronized boolean validateDeptName(String deptname, String deptid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : validateDeptName : Starting");
		PreparedStatement departmenPstmt = null;
		ResultSet resultSet = null;
		Connection connection=null;
		int count = 0;
		boolean status = false;

		try {
			connection=getConnection();
			if (deptid == null || deptid.equalsIgnoreCase("")) {
				departmenPstmt = connection
						.prepareStatement(DepartmentMaster.VALIDATE_DEPTNAME);
				departmenPstmt.setString(1, deptname);

				resultSet = departmenPstmt.executeQuery();
				while (resultSet.next()) {

					count = resultSet.getInt("deptname");
				}

				if (count > 0) {

					status = true;
				} else {

					status = false;
				}

			} else {

				departmenPstmt = connection
						.prepareStatement(DepartmentMaster.VALIDATE_DEPTNAME_UPDATE);
				departmenPstmt.setString(1, deptname);
				departmenPstmt.setString(2, deptid);

				resultSet = departmenPstmt.executeQuery();
				while (resultSet.next()) {

					count = resultSet.getInt("deptname");
				}

				if (count > 0) {

					status = true;
				} else {

					status = false;
				}

			}

		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {

			try {
				
				if(resultSet != null && (!resultSet.isClosed())){
					
					resultSet.close();
				}
				if(departmenPstmt != null && (!departmenPstmt.isClosed())){
					
					departmenPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}

				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : validateDeptName : Ending");

		return status;

	}
	
	public synchronized boolean checkDepartmentDuplicate(String deptName,String description){

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in DepartmentMasterDAOImpl : checkDepartmentDuplicate : Starting");

		PreparedStatement departmenPstmt = null;
		ResultSet resultSet = null;
		Connection connection=null;
		int count = 0;
		boolean status = false;

		try {
			connection=getConnection();
			
				departmenPstmt = connection.prepareStatement(DepartmentMaster.CHECK_DEPARTMENT_DUPLICATE);
				departmenPstmt.setString(1,deptName);
				departmenPstmt.setString(2,description);
			
				resultSet = departmenPstmt.executeQuery();
				while (resultSet.next()) {

					count = resultSet.getInt("count");
				}

				if (count > 0) {

					status = true;
				} else {
					status = false;
				}

		
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);

		} finally {

			try {

				
				if(resultSet != null && (!resultSet.isClosed())){
					
					resultSet.close();
				}
				if(departmenPstmt != null && (!departmenPstmt.isClosed())){
					
					departmenPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				

			} catch (SQLException e) {
				logger.error(e.getMessage(),e);
			
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in DepartmentMasterDAOImpl : checkDepartmentDuplicate : Ending");

		return status;

	}
	
	public ArrayList<DepartmentMasterVO> getSingleDeportmentDetails(String depid) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterDAOImpl : getSingleDeportmentDetails : Starting");
		DBService db=null;
		 PreparedStatement departmenPstmt=null;
			ResultSet departmentsResultSet=null;
			
			ArrayList<DepartmentMasterVO> departmentlist=new ArrayList<DepartmentMasterVO>();
			
		try {
			
			
			db=new DBService();
			
			departmenPstmt= db.getPreparedStatement(DepartmentMaster.GET_SINGLE_DEPT);
			
			departmenPstmt.setString(1, depid);
			
			 departmentsResultSet=departmenPstmt.executeQuery();
			 
			 while(departmentsResultSet.next())
				{
				 DepartmentMasterVO depVO=new DepartmentMasterVO();
					
				     depVO.setDepId(departmentsResultSet.getString("DEPT_ID"));
				     depVO.setDepName(departmentsResultSet.getString("DEPT_NAME"));
				     departmentlist.add(depVO);
				}
			 
		}catch (SQLException sqle) {
			
			sqle.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
			
			 try {
						 
				 if(db !=null){
						db.closeAll(departmenPstmt, departmentsResultSet);
					}
			
			} catch (SQLException e) {
				
				logger.error(e);
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		
		   JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in DepartmentMasterDAOImpl : getSingleDeportmentDetails : Ending");
		
	return departmentlist;

	}
		

}
