package com.centris.DAO.DAOIMPL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.AddEmployeeDao;
import com.centris.DAO.DBService;
import com.centris.POJO.AddEmployeePojo;
import com.centris.VO.AllEmployeeVo;
import com.centris.VO.RemoveEmployeeVo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author seshuma
 *
 */
public class AddEmployeeDaoImpl extends DBService implements AddEmployeeDao{
	
	private static 	Logger logger = Logger.getLogger(AddEmployeeDaoImpl.class);
	
	

//To add employee	
public synchronized String addEmployee(AddEmployeePojo emppojo) {
		
		
		 logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AddEmployeeDaoImpl: addEmployee : Starting");
			
			PreparedStatement addemployeepreparedstatement=null;
			PreparedStatement ps_getusercode=null;
			PreparedStatement ps_locationmapping=null;
				 int no=0;
				 String status=null;
				 ResultSet rs_userid=null;
				 String userid=null;
				 Connection connection=null;
				 

		try {
			
			connection=getConnection();
			
			if(!(new AddEmployeeDaoImpl().checkEmpId( emppojo.getEmpid()))){
			
		if(emppojo.getSelectedllocations().length>0){
			
			if(!(emppojo.getSelectedllocations()[0].equalsIgnoreCase(""))){
			
				ps_getusercode = connection.prepareStatement(SQLutilConstants.GET_USERID);
				ps_getusercode.setString(1, emppojo.getCreateuser());
				rs_userid=ps_getusercode.executeQuery();
			while(rs_userid.next()){
				
				userid=rs_userid.getString("userCode");
				
			}
			
			
			
			ps_locationmapping = connection.prepareStatement(SQLutilConstants.EMP_LOCATION_MAPPING);
			
			for(int i=0;i<emppojo.getSelectedllocations().length;i++){
				
				ps_locationmapping.setString(1,  emppojo.getEmpid());
				ps_locationmapping.setString(2,  emppojo.getSelectedllocations()[i]);
				ps_locationmapping.setString(3,  userid);
			
				ps_locationmapping.executeUpdate();
			
			
			}
			
			}
			
		}
					
					addemployeepreparedstatement = connection.prepareStatement(SQLutilConstants.REGISTER_EMPLOYEE);
					
					addemployeepreparedstatement.setString(1, emppojo.getEmpid());
					addemployeepreparedstatement.setString(2, emppojo.getEmpname());
					addemployeepreparedstatement.setString(3, emppojo.getPhone());
					addemployeepreparedstatement.setString(4, emppojo.getEmail());
					addemployeepreparedstatement.setString(5, emppojo.getShift());
					addemployeepreparedstatement.setString(6, emppojo.getCreateuser());
					addemployeepreparedstatement.setTimestamp(7, emppojo.getCreatedate());
					addemployeepreparedstatement.setString(8, emppojo.getEmpaddress());
					addemployeepreparedstatement.setString(9, emppojo.getEmployeedesignation());
					addemployeepreparedstatement.setString(10, emppojo.getDepartment());
					addemployeepreparedstatement.setString(11, emppojo.getDob());
					addemployeepreparedstatement.setString(12, emppojo.getDoj());
					addemployeepreparedstatement.setString(13, emppojo.getFathername());
					addemployeepreparedstatement.setString(14, emppojo.getLocation());
					addemployeepreparedstatement.setString(15, emppojo.getIsemployeereginmultilocations());
					addemployeepreparedstatement.setString(16, emppojo.getEmpregnumber());
					addemployeepreparedstatement.setString(17, "Y");
					
					no=addemployeepreparedstatement.executeUpdate();
					
					if(no>0){
						
						status=MessageConstants.EMPLOYEE_ADD_SUCCESS;
					}else{
						
						status=MessageConstants.EMPLOYEE_ADD_FAIL;
					}
					
					if(addemployeepreparedstatement != null && (!addemployeepreparedstatement.isClosed())){
						addemployeepreparedstatement.getConnection().close();
					}
			
		}
		
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e);
		}
		finally{
			
	    try {
			
			
			if(rs_userid != null && (!rs_userid.isClosed())){
				
				rs_userid.close();
			}
			if(addemployeepreparedstatement != null && (!addemployeepreparedstatement.isClosed())){
							
				addemployeepreparedstatement.close();
						}
			if(ps_locationmapping != null && (!ps_locationmapping.isClosed())){
				
				ps_locationmapping.close();
			}
			if(ps_getusercode != null && (!ps_getusercode.isClosed())){
				
				ps_getusercode.close();
			}
			if(connection != null && (!connection.isClosed())){
				
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
					+ " Control in AddEmployeeDaoImpl: addEmployee : Ending");
		
		return status;
	}

	// validate email id
	public synchronized boolean checkEmail(String email) {
		
		 logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AddEmployeeDaoImpl: checkEmail : Starting");
			PreparedStatement checkEmailStatement = null;
			ResultSet checkemailresultset = null;
			boolean Status=false;
			int count=0;
			Connection connection=null;

	try {
		connection=getConnection();
		checkEmailStatement = connection.prepareStatement(SQLutilConstants.EMAILCOUNT);
		checkEmailStatement.setString(1, email);
		
		checkemailresultset = checkEmailStatement.executeQuery();
		
		while (checkemailresultset.next()) {
			count= checkemailresultset.getInt(1);
		}
	
	
	} catch (SQLException sqle) {
		
		sqle.printStackTrace();
		logger.error(sqle);
	} catch (Exception e) {
		e.printStackTrace();
		logger.error(e);
	}finally{
		
		 try {
				
				
				if(checkemailresultset != null && (!checkemailresultset.isClosed())){
					
					checkemailresultset.close();
				}
				if(checkEmailStatement != null && (!checkEmailStatement.isClosed())){
					
					checkEmailStatement.close();
				}
				if(connection != null && (!connection.isClosed())){
	
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
	
	if(count>0){
		
		Status=true;
		
	}else{
		
		Status=false;
	}
	
	 logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeDaoImpl: checkEmail : Ending");
	return Status;
}
	
	
	// validate checkEmpRegNo
	public synchronized boolean checkEmpRegNo(String empregno) {
		 logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AddEmployeeDaoImpl: checkEmpRegNo : Starting");
			PreparedStatement checkEmailStatement = null;
			ResultSet checkemailresultset = null;
			boolean Status=false;
			int count=0;
		Connection connection=null;

	try {
		connection=getConnection();
		checkEmailStatement = connection.prepareStatement(SQLutilConstants.EMPREGCOUNT);
		checkEmailStatement.setString(1, empregno);
		
		checkemailresultset = checkEmailStatement.executeQuery();
		
		while (checkemailresultset.next()) {
			count= checkemailresultset.getInt(1);
		}
	} catch (Exception e) {

		e.printStackTrace();
		logger.error(e);
	}finally{
		
		try{
			
			if(checkemailresultset != null && (!checkemailresultset.isClosed())){
				
				checkemailresultset.close();
			}
			if(checkEmailStatement != null && (!checkEmailStatement.isClosed())){
				
				checkEmailStatement.close();
			}
			if(connection != null && (!connection.isClosed())){

				connection.close();
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	if(count>0){
		
		Status=true;
		
	}else{
		
		Status=false;
	}
	
	 logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeDaoImpl: checkEmpRegNo : Ending");
	return Status;
}
	
	//validate employee id
	public synchronized boolean checkEmpId(String empid) {
		
		 logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AddEmployeeDaoImpl: checkEmpId : Starting");
			PreparedStatement checkEmpIdStatement = null;
			ResultSet checkempidresultset = null;
			boolean Status=false;
			int count=0;
			Connection connection=null;

	try {
		connection=getConnection();
		checkEmpIdStatement = connection.prepareStatement(SQLutilConstants.EMPIDCOUNT);
		checkEmpIdStatement.setString(1, empid);
		
		checkempidresultset = checkEmpIdStatement.executeQuery();
		
		while (checkempidresultset.next()) {
			count= checkempidresultset.getInt(1);
		}
	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle);
	} catch (Exception e) {
		e.printStackTrace();
		logger.error(e);
	}finally{
		
		 try {
				
			 if(checkempidresultset != null && (!checkempidresultset.isClosed())){
					
				 checkempidresultset.close();
				}
				if(checkEmpIdStatement != null && (!checkEmpIdStatement.isClosed())){
					
					checkEmpIdStatement.close();
				}
				if(connection != null && (!connection.isClosed())){

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
	
	if(count>0){
		
		Status=true;
		
	}else{
		
		Status=false;
	}
	
	 logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeDaoImpl: checkEmpId : Ending");
	return Status;
}
	
	//Get all emploee for removing
	public synchronized ArrayList<RemoveEmployeeVo> getAllEmployees(String searchemp,String maxrows,String groupcode)
			 {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeDaoImpl: getAllEmployees : Starting");
		PreparedStatement searchemployeeSatetement = null;
		ResultSet empResultSet = null;
		ArrayList<RemoveEmployeeVo> listofEmployees = new ArrayList<RemoveEmployeeVo>();
		Connection connection=null;
		
		try {
			connection=getConnection();
			searchemployeeSatetement = connection.prepareStatement(SQLutilConstants.GET_REMOVE_EMPLOYEE);
			
			searchemployeeSatetement.setString(1, "%" + searchemp + "%");
			searchemployeeSatetement.setString(2, groupcode);
			searchemployeeSatetement.setInt(3, Integer.parseInt(maxrows));
			

			empResultSet = searchemployeeSatetement.executeQuery();
			
			while (empResultSet.next()) {
				RemoveEmployeeVo vo = new RemoveEmployeeVo();

				vo.setEmpid(empResultSet.getString("EMPID"));
				vo.setEmpname(empResultSet.getString("EMPNAME"));
				vo.setPhone(empResultSet.getString("PHONE"));
				vo.setEmail(empResultSet.getString("EMAIL"));
				vo.setShiftid(empResultSet.getString("AI_SHIFT_ID"));
				vo.setShiftname(empResultSet.getString("AI_SHIFT_NAME"));
				vo.setDeptid(empResultSet.getString("DEPT_ID"));
				vo.setDeptname(empResultSet.getString("DEPT_NAME"));
				vo.setLocationid(empResultSet.getString("LocationCode"));
				vo.setLocationname(empResultSet.getString("Location"));
				
				listofEmployees.add(vo);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			logger.error(se);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			 try {
					
				 	if(empResultSet != null && (!empResultSet.isClosed())){
						
					 empResultSet.close();
					}
					if(searchemployeeSatetement != null && (!searchemployeeSatetement.isClosed())){
						
						searchemployeeSatetement.close();
					}
					if(connection != null && (!connection.isClosed())){

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
				+ " Control in AddEmployeeDaoImpl: getAllEmployees : Ending");
		return listofEmployees;
	}
	
	//Remove employee
	
	public synchronized String removeEmployee(String empid,String modifiedby,Timestamp modifieddate) {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeDaoImpl: removeEmployee : Starting");
		PreparedStatement removeEmployeePreparedStatement = null;
		int count=0;
		String Status=null;
		Connection connection=null;
		try {
			connection=getConnection();
			removeEmployeePreparedStatement = connection.prepareStatement(SQLutilConstants.REMOVE_EMPLOYEE);
			
			removeEmployeePreparedStatement.setString(1,modifiedby);
			removeEmployeePreparedStatement.setTimestamp(2, modifieddate);
			removeEmployeePreparedStatement.setString(3,empid);
			
			count =removeEmployeePreparedStatement.executeUpdate();
			
			if(count>0){
				
				Status=MessageConstants.EMPLOYEE_DELETE_SUCCESS;
				
				
			}else{
				
				Status=MessageConstants.EMPLOYEE_DELETE_FAIL;
				
			}
			

		} catch (SQLException se) {
			se.printStackTrace();
			logger.error(se);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			 try {
			
				if(removeEmployeePreparedStatement != null && (!removeEmployeePreparedStatement.isClosed())){
					
					removeEmployeePreparedStatement.close();
				}
				if(connection != null && (!connection.isClosed())){

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
				+ " Control in AddEmployeeDaoImpl: removeEmployee : Ending");

		return Status;
	}
	
	//Get all employees for display 
	
	public synchronized List<AllEmployeeVo> getAllDisplayEmployee(String groupid) {
	
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeDaoImpl: getAllDisplayEmployee : Starting");
		PreparedStatement allEmployeePreparedStatement = null;
		ResultSet allemployeesResultset=null;
		List<AllEmployeeVo> getEmployee = new ArrayList<AllEmployeeVo>();
		Connection connection=null;
		
		
		try {
			connection=getConnection();
			allEmployeePreparedStatement = connection.prepareStatement(SQLutilConstants.DISPLAY_ALL_EMPLOYEES);
			allEmployeePreparedStatement.setString(1, groupid);
			 allemployeesResultset = allEmployeePreparedStatement.executeQuery();

			while (allemployeesResultset.next()) {
				
				AllEmployeeVo ad = new AllEmployeeVo();
				ad.setEmpname(allemployeesResultset.getString("EMPNAME"));
				ad.setEmpid(allemployeesResultset.getString("EMPID"));
				ad.setShiftname(allemployeesResultset.getString("AI_SHIFT_NAME"));
				ad.setDepartment(allemployeesResultset.getString("DEPT_NAME"));
				ad.setLocation(allemployeesResultset.getString("Location"));
				getEmployee.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			 try {
				 	if(allemployeesResultset != null && (!allemployeesResultset.isClosed())){
						
					  allemployeesResultset.close();
					}
					if(allEmployeePreparedStatement != null && (!allEmployeePreparedStatement.isClosed())){
						
						allEmployeePreparedStatement.close();
					}
					if(connection != null && (!connection.isClosed())){

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
				+ " Control in AddEmployeeDaoImpl: getAllDisplayEmployee : Ending");
		return getEmployee;
	}
	
	
public synchronized List<AllEmployeeVo> getAllDeactiveEmployee(String groupid) {
	
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeDaoImpl: getAllDisplayEmployee : Starting");
		PreparedStatement allEmployeePreparedStatement = null;
		ResultSet allemployeesResultset=null;
		List<AllEmployeeVo> getEmployee = new ArrayList<AllEmployeeVo>();
		Connection connection=null;
		
		try {
			connection=getConnection();
			allEmployeePreparedStatement = connection.prepareStatement(SQLutilConstants.DEACTIVE_EMPLOYEES);
			
			allEmployeePreparedStatement.setString(1, groupid);
			
			 allemployeesResultset = allEmployeePreparedStatement.executeQuery();

			while (allemployeesResultset.next()) {
				
				AllEmployeeVo ad = new AllEmployeeVo();
				ad.setEmpname(allemployeesResultset.getString("EMPNAME"));
				ad.setEmpid(allemployeesResultset.getString("EMPID"));
				ad.setShiftname(allemployeesResultset.getString("AI_SHIFT_NAME"));
				ad.setDepartment(allemployeesResultset.getString("DEPT_NAME"));
				ad.setLocation(allemployeesResultset.getString("Location"));
				ad.setDesignation(allemployeesResultset.getString("designationName"));
				ad.setLocationid(allemployeesResultset.getString("LocationCode"));
				ad.setDesignationid(allemployeesResultset.getString("designationId"));
				getEmployee.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			 try {
				  
						if(allemployeesResultset != null && (!allemployeesResultset.isClosed())){
						
							allemployeesResultset.close();
						}
						if(allEmployeePreparedStatement != null && (!allEmployeePreparedStatement.isClosed())){
							
							allEmployeePreparedStatement.close();
						}
						if(connection != null && (!connection.isClosed())){

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
				+ " Control in AddEmployeeDaoImpl: getAllDisplayEmployee : Ending");
		return getEmployee;
	}
	
	//Get search employee from all employees
	
	public synchronized List<AllEmployeeVo> getSerachofAllEmployee(String reqname){
		
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeDaoImpl: getSerachofAllEmployee : Starting");
		
		String reqname1 = "%" + reqname + "%";
		List<AllEmployeeVo> getEmployeeModify = new ArrayList<AllEmployeeVo>();
		PreparedStatement searchAllEmployee=null;
		ResultSet allEmployeeResultset=null;
		Connection connection=null;
		
		try {
			connection =getConnection();
			searchAllEmployee = connection.prepareStatement(SQLutilConstants.SEARCH_DISPLAY_ALL_EMPLOYEE);
			
		
			searchAllEmployee.setString(1, reqname1);
			searchAllEmployee.setString(2, reqname1);
			searchAllEmployee.setString(3, reqname1);
			searchAllEmployee.setString(4, reqname1);
			searchAllEmployee.setString(5, reqname1);

			allEmployeeResultset = searchAllEmployee.executeQuery();

			while (allEmployeeResultset.next()) {
				AllEmployeeVo empadd = new AllEmployeeVo();
				empadd.setEmpname(allEmployeeResultset.getString("EMPNAME"));
				empadd.setEmpid(allEmployeeResultset.getString("EMPID"));
				empadd.setShiftname(allEmployeeResultset.getString("AI_SHIFT_NAME"));
				//empadd.setEmptype(allEmployeeResultset.getString("EMPLOYEETYPE"));
				empadd.setDepartment(allEmployeeResultset.getString("DEPT_NAME"));
				empadd.setLocation(allEmployeeResultset.getString("Location"));
				getEmployeeModify.add(empadd);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			
			try {
				 
				if(allEmployeeResultset != null && (!allEmployeeResultset.isClosed())){
					
					allEmployeeResultset.close();
				}
				if(searchAllEmployee != null && (!searchAllEmployee.isClosed())){
					
					searchAllEmployee.close();
				}
				if(connection != null && (!connection.isClosed())){

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
				+ " Control in AddEmployeeDaoImpl: getSerachofAllEmployee : Ending");
		
		return getEmployeeModify;

	}
	
	//active employees
	
		public synchronized String activateEmployee(String empid,String modifiedby) {
		
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AddEmployeeDaoImpl: activateEmployee : Starting");
			PreparedStatement allEmployeePreparedStatement = null;
			String status=null;
			int no=0;
			Connection connection=null;
			
			try {
				connection=getConnection();
				allEmployeePreparedStatement = connection.prepareStatement(SQLutilConstants.UPDATE_DEACTIVEEMPLOYEES);
				
				
				allEmployeePreparedStatement.setString(1, modifiedby);
				allEmployeePreparedStatement.setTimestamp(2, HelperClass.getCurrentTimestamp());
				allEmployeePreparedStatement.setString(3, empid);
				
				 no = allEmployeePreparedStatement.executeUpdate();

				if(no>0){
					
					status="Employee Activated Successfully";
				}else{
					
					status="Employee not activated successfully";
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			} finally {
				 try {
					 	
						if(allEmployeePreparedStatement != null && (!allEmployeePreparedStatement.isClosed())){
							
							allEmployeePreparedStatement.close();
						}
						if(connection != null && (!connection.isClosed())){

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
					+ " Control in AddEmployeeDaoImpl: activateEmployee : Ending");
			return status;
		}
		

		public synchronized ArrayList<String> getlocationnames(String[] locationsid) {
		
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AddEmployeeDaoImpl: getlocationnames : Starting");
			PreparedStatement allEmployeePreparedStatement = null;
			ResultSet locationsrs=null;
			ArrayList<String> list=new ArrayList<String>();
			Connection connection=null;
			
			try {
				connection=getConnection();
				allEmployeePreparedStatement = connection.prepareStatement(SQLutilConstants.GET_LOCATIONSNAMES);
				
				for(int i=0;i<locationsid.length;i++){
					
					allEmployeePreparedStatement.setString(1, locationsid[i]);
					locationsrs=allEmployeePreparedStatement.executeQuery();
					
					while(locationsrs.next()){
						
						list.add(locationsrs.getString("Location"));
					}
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			} finally {
				 try {
					 
						if(locationsrs != null && (!locationsrs.isClosed())){
							
							locationsrs.close();
						}
						if(allEmployeePreparedStatement != null && (!allEmployeePreparedStatement.isClosed())){
							
							allEmployeePreparedStatement.close();
						}
						if(connection != null && (!connection.isClosed())){

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
					+ " Control in AddEmployeeDaoImpl: getlocationnames : Ending");
			return list;
		}
		
		
public synchronized String chechkemployeeidformat(String empid,String location) {
		
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AddEmployeeDaoImpl: chechkemployeeidformat : Starting");
			PreparedStatement allEmployeePreparedStatement = null;
			ResultSet locationsrs=null;
			String indexid=null;
			Connection connection=null;
			
			try {
				connection=getConnection();
				allEmployeePreparedStatement = connection.prepareStatement(SQLutilConstants.GET_LOCATIONINDEXID);
				allEmployeePreparedStatement.setString(1, location);
				
				locationsrs=allEmployeePreparedStatement.executeQuery();
				
				while(locationsrs.next()){
					
					indexid=locationsrs.getString("Bio_Id_Index_Number")+","+locationsrs.getString("Location");
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			} finally {
				 try {
					  
					 	if(locationsrs != null && (!locationsrs.isClosed())){
							
							locationsrs.close();
						}
						if(allEmployeePreparedStatement != null && (!allEmployeePreparedStatement.isClosed())){
							
							allEmployeePreparedStatement.close();
						}
						if(connection != null && (!connection.isClosed())){

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
					+ " Control in AddEmployeeDaoImpl: chechkemployeeidformat : Ending");
			return indexid;
		}


public synchronized String checkDseCount(String locationid,String desid) {
	
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AddEmployeeDaoImpl: checkDseCount : Starting");
	PreparedStatement allEmployeePreparedStatement = null;
	PreparedStatement ps_desccount = null;
	ResultSet locationsrs=null;
	ResultSet rs_desccount=null;
	int empcount=0;
	int dsecount=0;
	Connection connection=null;
	String Status=null;
	
	try {
		connection=getConnection();
		allEmployeePreparedStatement = connection.prepareStatement(SQLutilConstants.GET_NOOFEMP);
		allEmployeePreparedStatement.setString(1, desid);
		allEmployeePreparedStatement.setString(2, locationid);
		
		locationsrs=allEmployeePreparedStatement.executeQuery();
		
		while(locationsrs.next()){
			
			empcount=locationsrs.getInt("employee");
			
		}
		
		
		
		ps_desccount = connection.prepareStatement(SQLutilConstants.GET_DES_COUNT);
		ps_desccount.setString(1, locationid);
		
		rs_desccount=ps_desccount.executeQuery();
		
		while(rs_desccount.next()){
			
			dsecount=rs_desccount.getInt("DSE_S_Count");
			
		}
		
		if(empcount>=dsecount){
			
			Status=MessageConstants.DSE_COUNT;
		}else{
			
			Status="false";
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		logger.error(e);
	} finally {
		 try {
			  
			 	if(locationsrs != null && (!locationsrs.isClosed())){
					
					locationsrs.close();
				}
			 	if(rs_desccount != null && (!rs_desccount.isClosed())){
					
			 		rs_desccount.close();
				}
				if(allEmployeePreparedStatement != null && (!allEmployeePreparedStatement.isClosed())){
					
					allEmployeePreparedStatement.close();
				}
				if(ps_desccount != null && (!ps_desccount.isClosed())){
					
					ps_desccount.close();
				}
				if(connection != null && (!connection.isClosed())){

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
			+ " Control in AddEmployeeDaoImpl: checkDseCount : Ending");
	return Status;
}
		
		

}
