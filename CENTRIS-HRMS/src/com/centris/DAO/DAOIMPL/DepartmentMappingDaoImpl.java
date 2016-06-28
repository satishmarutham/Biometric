package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.DepartmentMappingDao;
import com.centris.VO.AddDesignationVO;
import com.centris.VO.DepartmentMappingVo;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.DepartmentMapping;
import com.centris.util.constants.MessageConstants;

public class DepartmentMappingDaoImpl extends DBService implements DepartmentMappingDao{

	private static Logger logger = Logger.getLogger(DepartmentMappingDaoImpl.class);

	public ArrayList<DepartmentMappingVo> getAllUsersUnderDesignation(String designation) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingDaoImpl : getAllUsersUnderDesignation:Starting");

		Connection connection=null;
		PreparedStatement pstmt_dept = null;
		ResultSet rs_dept = null;
		ArrayList<DepartmentMappingVo> userslist=new ArrayList<DepartmentMappingVo>();
		userslist.clear();
		try {
			connection=getConnection();
			
			DepartmentMappingVo departmentMappingVo=getUserIdentification(designation,connection);
			
			
			if(departmentMappingVo.getIs_manager().equalsIgnoreCase(MessageConstants.IS_MANAGER_YES)){

               pstmt_dept = connection.prepareStatement(DepartmentMapping.GET_ALL_MANAGERS);	
			
			}else if(departmentMappingVo.getIs_employee().equalsIgnoreCase(MessageConstants.IS_EMPLOYEE_YES)){
				
				 pstmt_dept = connection.prepareStatement(DepartmentMapping.GET_ALL_EMPLOYEES);	
				
			}else{
							
			}
			rs_dept=pstmt_dept.executeQuery();
			while(rs_dept.next()){
				DepartmentMappingVo departmentMappingVo1=new DepartmentMappingVo();
				
				departmentMappingVo1.setUserId(rs_dept.getString("code"));
				departmentMappingVo1.setUserName(rs_dept.getString("name"));
				userslist.add(departmentMappingVo1);
				
			}
    } catch (SQLException sqle) {
		logger.error(sqle.getMessage(),sqle);

	} catch (Exception e) {
		logger.error(e);
		e.printStackTrace();
	} finally {

		try {

			if (rs_dept != null && (!rs_dept.isClosed())) {

				rs_dept.close();
			}
			if (pstmt_dept != null && (!pstmt_dept.isClosed())) {

				pstmt_dept.close();
			}
			
			if(connection != null && (!connection.isClosed())){
				
				connection.close();
			}

		} catch (SQLException e) {

			logger.error(e.getMessage(),e);
		} catch (Exception e1) {

			logger.error(e1.getMessage(),e1);
		}
	}

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in DepartmentMappingDaoImpl : getAllUsersUnderDesignation: Ending");

		return userslist;
	}

	private DepartmentMappingVo getUserIdentification(String designation,Connection connection) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingDaoImpl : getUserIdentification : start");

		PreparedStatement pstmt_dept = null;
		ResultSet rs_dept = null;
		DepartmentMappingVo departmentMappingVo=new DepartmentMappingVo();
		try {
		
			pstmt_dept = connection.prepareStatement(DepartmentMapping.GET_USER_IDENTIFICATION);
			pstmt_dept.setString(1, designation);
			
			rs_dept=pstmt_dept.executeQuery();
			while (rs_dept.next()) {
					
				departmentMappingVo.setIs_manager(rs_dept.getString("isManager"));
				departmentMappingVo.setIs_employee(rs_dept.getString("isEmployee"));
			}

	} catch (SQLException sqle) {
		logger.error(sqle.getMessage(),sqle);

	} catch (Exception e) {
		logger.error(e);
		e.printStackTrace();
	} finally {
		try {
		if (rs_dept != null && (!rs_dept.isClosed())) {
				rs_dept.close();
			}
			if (pstmt_dept != null && (!pstmt_dept.isClosed())) {
				pstmt_dept.close();
			}
		} catch (SQLException e) {
		logger.error(e.getMessage(),e);
		} catch (Exception e1) {
			logger.error(e1.getMessage(),e1);
		}
	}

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in DepartmentMappingDaoImpl : getUserIdentification: Ending");

		return departmentMappingVo;
	}

	public ArrayList<DepartmentMappingVo> getAvailableDepartments(String usercode) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingDaoImpl : getAvailableDepartments :start");
		Connection connection=null;
		PreparedStatement pstmt_dept = null;
		ResultSet rs_dept = null;
		ArrayList<DepartmentMappingVo> getAvailableDepartments=new ArrayList<DepartmentMappingVo>();
		getAvailableDepartments.clear();
		try {
			 connection=getConnection();
			 if(MessageConstants.EMPLOYEE_SHORT_NAME.contains(usercode.substring(0,3))){
			   
				 String  manager=getManager(usercode,connection);
				 if(manager!=null){
					 pstmt_dept = connection.prepareStatement(DepartmentMapping.GET_DEPARTMENTS);	
					 pstmt_dept.setString(1,manager);
				 }
			 }else{
				 
				 pstmt_dept = connection.prepareStatement(DepartmentMapping.GET_DEPARTMENTS);
				 pstmt_dept.setString(1,usercode);
			 }
				 
			rs_dept=pstmt_dept.executeQuery();
			while(rs_dept.next()){
				DepartmentMappingVo departmentMappingVo=new DepartmentMappingVo();
				
				departmentMappingVo.setDept_id(rs_dept.getString("DEPT_ID"));
				departmentMappingVo.setDept_name(rs_dept.getString("DEPT_NAME"));
			
				getAvailableDepartments.add(departmentMappingVo);
				
			}
    } catch (SQLException sqle) {
		logger.error(sqle.getMessage(),sqle);

	} catch (Exception e) {
		logger.error(e);
		e.printStackTrace();
	} finally {

		try {

			if (rs_dept != null && (!rs_dept.isClosed())) {

				rs_dept.close();
			}
			if (pstmt_dept != null && (!pstmt_dept.isClosed())) {

				pstmt_dept.close();
			}
			
			if(connection != null && (!connection.isClosed())){
				
				connection.close();
			}

		} catch (SQLException e) {

			logger.error(e.getMessage(),e);
		} catch (Exception e1) {

			logger.error(e1.getMessage(),e1);
		}
	}

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in DepartmentMappingDaoImpl : getAvailableDepartments: Ending");

		return getAvailableDepartments;
	}

	
	private String getManager(String usercode,Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingDaoImpl : getUserIdentification : start");

		PreparedStatement pstmt_dept = null;
		ResultSet rs_dept = null;
		String manager=null;
		try {
		
			pstmt_dept = connection.prepareStatement(DepartmentMapping.GET_MANAGER_FOR_EMPLOYEE);
			pstmt_dept.setString(1, usercode);
			rs_dept=pstmt_dept.executeQuery();
			while (rs_dept.next()) {
				manager=rs_dept.getString("ManagerCode");
			
			}

	} catch (SQLException sqle) {
		logger.error(sqle.getMessage(),sqle);

	} catch (Exception e) {
		logger.error(e.getMessage(),e);
		e.printStackTrace();
	} finally {
		try {
		if (rs_dept != null && (!rs_dept.isClosed())) {
				rs_dept.close();
			}
			if (pstmt_dept != null && (!pstmt_dept.isClosed())) {
				pstmt_dept.close();
			}
		} catch (SQLException e) {
		logger.error(e.getMessage(),e);
		} catch (Exception e1) {
			logger.error(e1.getMessage(),e1);
		}
	}

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in DepartmentMappingDaoImpl : getUserIdentification: Ending");
		return manager;
	}

	
	public ArrayList<DepartmentMappingVo> getMappedDepartments(String usercode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingDaoImpl : getMappedDepartments :start");
		Connection connection=null;
		PreparedStatement pstmt_dept = null;
		ResultSet rs_dept = null;
		ArrayList<DepartmentMappingVo> mappedDepartments=new ArrayList<DepartmentMappingVo>();
		mappedDepartments.clear();
		try {
			 connection=getConnection();
				 pstmt_dept = connection.prepareStatement(DepartmentMapping.GET_MAPPED_DEPARTMENTS);
				 pstmt_dept.setString(1,usercode);
				rs_dept=pstmt_dept.executeQuery();
			while(rs_dept.next()){
				DepartmentMappingVo departmentMappingVo=new DepartmentMappingVo();
				
				departmentMappingVo.setDept_id(rs_dept.getString("DEPT_ID"));
				departmentMappingVo.setDept_name(rs_dept.getString("DEPT_NAME"));
			
				mappedDepartments.add(departmentMappingVo);
				
			}
    } catch (SQLException sqle) {
		logger.error(sqle.getMessage(),sqle);

	} catch (Exception e) {
		logger.error(e);
		e.printStackTrace();
	} finally {

		try {

			if (rs_dept != null && (!rs_dept.isClosed())) {

				rs_dept.close();
			}
			if (pstmt_dept != null && (!pstmt_dept.isClosed())) {

				pstmt_dept.close();
			}
			
			if(connection != null && (!connection.isClosed())){
				
				connection.close();
			}

		} catch (SQLException e) {

			logger.error(e.getMessage(),e);
		} catch (Exception e1) {

			logger.error(e1.getMessage(),e1);
		}
	}

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in DepartmentMappingDaoImpl : getMappedDepartments: Ending");

		return mappedDepartments;
	}

	public String saveDepartmentMapping(String userId, JSONArray jsonArray,String currentuser) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingDaoImpl : saveDepartmentMapping :start");

		Connection connection=null;
		PreparedStatement pstmt_dept = null;
		ResultSet rs_dept = null;
		PreparedStatement pstmt_delete = null;
		String result=null;
		
		
		try {
			 connection=getConnection();
			 pstmt_delete = connection.prepareStatement(DepartmentMapping.DELETE_MAPPED_DEPARTMENTS);
			 pstmt_delete.setString(1,userId);
			 pstmt_delete.executeUpdate();
	             if(jsonArray.length()==0){
	    	          return "success";
	             }
	         pstmt_dept = connection.prepareStatement(DepartmentMapping.INSERT_DEPARTMENT_MAPPING);
	        for (int i = 0; i < jsonArray.length(); i++) {
	        	  pstmt_dept .setString(1,(String)jsonArray.get(i));
	        	  pstmt_dept .setString(2,userId);
	        	  pstmt_dept .setString(3,currentuser);
	        	int value= pstmt_dept.executeUpdate();
	        	result = (value > 0) ? "success" : "failure";
	        }
	                    	     
    } catch (SQLException sqle) {
		logger.error(sqle.getMessage(),sqle);

	} catch (Exception e) {
		logger.error(e);
		e.printStackTrace();
	} finally {

		try {
		
			if (pstmt_dept != null && (!pstmt_dept.isClosed())) {

				pstmt_dept.close();
			}
			if (pstmt_delete != null && (!pstmt_delete.isClosed())) {

				pstmt_delete.close();
			}
			if(connection != null && (!connection.isClosed())){
				
				connection.close();
			}

		} catch (SQLException e) {

			logger.error(e.getMessage(),e);
		} catch (Exception e1) {

			logger.error(e1.getMessage(),e1);
		}
	}

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in DepartmentMappingDaoImpl : saveDepartmentMapping: Ending");

		return result;
	}

	public ArrayList<AddDesignationVO> getDesignationDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingDaoImpl : getDesignationDetails :start");
	
         Connection connection=null;
		PreparedStatement pstmt_des = null;
		ResultSet rs_des = null;
		ArrayList<AddDesignationVO> designations=new ArrayList<AddDesignationVO>();
		designations.clear();
		try {
			 connection=getConnection();
			 pstmt_des = connection.prepareStatement(DepartmentMapping.GET_DESIGNATIONS);
			 rs_des=pstmt_des.executeQuery();
			while(rs_des.next()){
					AddDesignationVO addDesignationVO=new AddDesignationVO();
					addDesignationVO.setDesgid(rs_des.getString("DesignationCode"));
					addDesignationVO.setDesgname(rs_des.getString("designationName"));
			
				designations.add(addDesignationVO);
			}
    } catch (SQLException sqle) {
		logger.error(sqle.getMessage(),sqle);

	} catch (Exception e) {
		logger.error(e);
		e.printStackTrace();
	} finally {

		try {

			if (rs_des != null && (!rs_des.isClosed())) {

				rs_des.close();
			}
			if (pstmt_des != null && (!pstmt_des.isClosed())) {

				pstmt_des.close();
			}
			
			if(connection != null && (!connection.isClosed())){
				
				connection.close();
			}

		} catch (SQLException e) {

			logger.error(e.getMessage(),e);
		} catch (Exception e1) {

			logger.error(e1.getMessage(),e1);
		}
	}

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in DepartmentMappingDaoImpl : getDesignationDetails: Ending");

		return designations;
	}

}
