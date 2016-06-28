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
import com.centris.DAO.RoleMasterDao;
import com.centris.POJO.RoleMasterPojo;
import com.centris.VO.RoleMasterVo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.SQLUtils.UserRolePermission;
import com.centris.util.constants.MessageConstants;

public class RoleMasterDaoImpl  extends DBService implements RoleMasterDao{
	private static 	Logger logger = Logger.getLogger(RoleMasterDaoImpl.class);
	
	@Override
	public synchronized String addRole(RoleMasterPojo roleMasterPojo) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterDaoImpl:addRole Starting");
	
		
		PreparedStatement psrole =null;
		Connection conn=null;
		
		String successMessage=null;
		 
		int count=0;
		RoleMasterDaoImpl daoImpl=new RoleMasterDaoImpl();
	
		try{
			conn=getConnection();
		
				psrole=conn.prepareStatement(UserRolePermission.ADD_ROLE);
				psrole.setString(1,roleMasterPojo.getRoleCode());
				psrole.setString(2,roleMasterPojo.getRoleName());
				psrole.setString(3,roleMasterPojo.getRoleDescription());
				psrole.setString(4,roleMasterPojo.getCreatedBy());
				psrole.setTimestamp(5,HelperClass.getCurrentTimestamp());
				psrole.setTimestamp(6,HelperClass.getCurrentTimestamp());
				psrole.setString(7,roleMasterPojo.getCreatedBy());
									 if(!(daoImpl.validateRoleName(roleMasterPojo.getRoleName())))
											 {
											 
											  count=psrole.executeUpdate();

											 }
											  
											  if(count>0){
												  
												successMessage="Role Added SuccessFully";
												  
											  }
											  else{
												  
												  successMessage="Role Not Added ";
											  }
									

		 } catch (SQLException e) {
			 logger.error(e);
		        e.printStackTrace();
		      }catch (Exception e) {
		    	  logger.error(e);
					e.printStackTrace();
				}
				finally{
					
					 try {
		               
						 if(psrole!=null && !psrole.isClosed()){
							 
							 psrole.close();
						 }
						
						 if(conn!=null && (!conn.isClosed())){
							 conn.close();
							 
						 }
						
					
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}catch (Exception e) {
						logger.error(e);
						e.printStackTrace();
					}
			}
				
								
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterDaoImpl:addRole Ending");
				
	
		
	return  successMessage; 
	}
	
	public synchronized String updateRole(RoleMasterPojo roleMasterPojo) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterDaoImpl:updateRole Starting");
	
		
		PreparedStatement psrole =null;
		Connection conn=null;
		
		String successMessage=null;
		 
		int count=0;
	
		try{
			conn=getConnection();
		
				psrole =conn.prepareStatement(UserRolePermission.UPDATE_ROLE);
				
				psrole.setString(1,roleMasterPojo.getRoleName() );
				psrole.setString(2,roleMasterPojo.getRoleDescription());
				psrole.setString(3,roleMasterPojo.getModifiedBy());
				psrole.setTimestamp(4,HelperClass.getCurrentTimestamp());
				psrole.setString(5,roleMasterPojo.getRoleCode());
			count=psrole.executeUpdate();


			if(count>0){
				 successMessage="Role Updated SuccessFully";	
			}
			else
			{
			successMessage="Role is Not Updated";	 
			}
		
			
									

		 } catch (SQLException e) {
			 logger.error(e);
		        e.printStackTrace();
		      }catch (Exception e) {
		    	  logger.error(e);
					e.printStackTrace();
				}
				finally{
					
					 try {
		               
						 if(psrole!=null && !psrole.isClosed()){
							 
							 psrole.close();
						 }
						
						 if(conn!=null && (!conn.isClosed())){
							 conn.close();
							 
						 }
						
					
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}catch (Exception e) {
						logger.error(e);
						e.printStackTrace();
					}
			}
				
								
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterDaoImpl:addRole Ending");
				
	
		
	return  successMessage; 
	}
	
	

public synchronized List<RoleMasterPojo> getRoles()
		throws Exception {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:getRoles Starting");
	List<RoleMasterPojo> getRoleList=new ArrayList<RoleMasterPojo>();
	
	Connection conn=null;
	 PreparedStatement psgetUsers=null;
	 ResultSet rsgetRoles=null;
	 try{
		 
		 conn=getConnection();
		 
  psgetUsers=conn.prepareStatement(UserRolePermission.GET_ROLES);
	  rsgetRoles=psgetUsers.executeQuery();
	 while(rsgetRoles.next()){
		 RoleMasterPojo masterPojo=new RoleMasterPojo();
		 masterPojo.setRoleCode(rsgetRoles.getString("RoleCode"));
		 masterPojo.setRoleName(rsgetRoles.getString("RoleName"));
		 masterPojo.setRoleDescription(rsgetRoles.getString("Description"));
		 getRoleList.add(masterPojo);
	 }
	 }
		 catch (SQLException e) {
			 logger.error(e);
		        e.printStackTrace();
		      }catch (Exception e) {
		    	  logger.error(e);
					e.printStackTrace();
				}
				finally{
					
					 try {
		               if(rsgetRoles!=null && !rsgetRoles.isClosed()){
		            	   rsgetRoles.close();
		               }
                        
		               if(psgetUsers!=null && !psgetUsers.isClosed()){
		            	   psgetUsers.close();
		               }
		               if(conn!=null && (!conn.isClosed())){
							 conn.close();
							 
						 }
						
					
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}catch (Exception e) {
						logger.error(e);
						e.printStackTrace();
					}
			}
				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterDaoImpl:getRoles Ending");
		
	// TODO Auto-generated method stub
	return getRoleList;
}




@Override
public synchronized String deleteRole(RoleMasterPojo roleMasterPojo) throws Exception {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:deleteRole Starting");
	// TODO Auto-generated method stub
	
	 PreparedStatement psdeleteRole=null;
	 PreparedStatement psdeleteRole1=null;
	 PreparedStatement psdeleteRole2=null;
	  int result=0;
	  int result1=0;
	String successMessage=null;
	ResultSet rolers=null;
	ResultSet rolers2=null;
	Connection conn=null;
	String status=null;
	try{
		conn=getConnection();
			 
		 psdeleteRole=conn.prepareStatement(UserRolePermission.CHECK_ROLE_USER_MAPPING);
		psdeleteRole.setString(1,roleMasterPojo.getRoleCode());
		rolers=psdeleteRole.executeQuery();
		while(rolers.next()){
			
			result=rolers.getInt(1);
			
			
		}
			
			if(result>0){
				
				successMessage="Unable to Delete : Role is mapped with user";
				status="false";
				
			}else{
				
				psdeleteRole2=conn.prepareStatement(UserRolePermission.CHECK_ROLE_PERMISSION_MAPPING);
				psdeleteRole2.setString(1,roleMasterPojo.getRoleCode());
					
					rolers2=psdeleteRole2.executeQuery();
					while(rolers2.next()){
						
						result1=rolers2.getInt(1);
					}
						
						if(result1>0){
							
							successMessage="Unable to Delete : Role is mapped with permissions";
							status="false";
							
						}else{
				
				
				
				psdeleteRole1=conn.prepareStatement(UserRolePermission.DELETE_ROLE);
				psdeleteRole1.setString(1,roleMasterPojo.getRoleCode());
				
				System.out.println("role detion :: "+psdeleteRole.toString());
				
					result=psdeleteRole1.executeUpdate();
				
				
				if(result>0){
					successMessage="Role Deleted SuccessFully";
					status="true";
				}
				else
				{
					successMessage="Default role should not delete";
					status="false";
				}
				
						}
				
			}
		
		 
		
}
	 catch (SQLException e) {
		 logger.error(e);
	        e.printStackTrace();
	        status="false";
	        successMessage="Error in deleting role check manually";
	        
	      }catch (Exception e) {
	    	  logger.error(e);
				e.printStackTrace();
				
				  status="false";
			      successMessage="Error in deleting role check manually";
				
			}
			finally{
				
				 try {
	               
					 if(psdeleteRole1!=null && !psdeleteRole1.isClosed()){
						 psdeleteRole1.close();
					 }
					 if(psdeleteRole!=null && !psdeleteRole.isClosed()){
						 psdeleteRole.close();
					 }
					 if(conn!=null && (!conn.isClosed())){
						 conn.close();
						 
					 }
					
				
				} catch (SQLException e) {
					logger.error(e);
					e.printStackTrace();
				}catch (Exception e) {
					logger.error(e);
					e.printStackTrace();
				}
		}
			

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:deleteRole Ending");
	
	return successMessage+",,"+status;
}
@Override
public synchronized List<RoleMasterPojo> updateRoles(String roleCodeId) throws Exception {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:updateRoles Starting");
	// TODO Auto-generated method stub

List<RoleMasterPojo> updateRoleList=new ArrayList<RoleMasterPojo>();
ResultSet rsgetRoles=null;
Connection conn=null;
 PreparedStatement psgetrolesUpdate=null;
 try{
	 conn=getConnection();
	
psgetrolesUpdate=conn.prepareStatement(UserRolePermission.UPDATE_ROLES);

psgetrolesUpdate.setString(1,roleCodeId);

System.out.println("role updation :: "+psgetrolesUpdate.toString());

  rsgetRoles=psgetrolesUpdate.executeQuery();
 while(rsgetRoles.next()){
	 RoleMasterPojo masterPojo=new RoleMasterPojo();
	 masterPojo.setRoleCode(rsgetRoles.getString("RoleCode"));
	 masterPojo.setRoleName(rsgetRoles.getString("RoleName"));
	 masterPojo.setRoleDescription(rsgetRoles.getString("Description"));
	 updateRoleList.add(masterPojo);
	
 }
 }
 catch (SQLException e) {
	 logger.error(e);
     e.printStackTrace();
   }catch (Exception e) {
	   logger.error(e);
			e.printStackTrace();
		}
		finally{
			
			 try {
				
				 if(rsgetRoles!=null && !rsgetRoles.isClosed()){
					 rsgetRoles.close();
				 }
				 
				 if(psgetrolesUpdate!=null && !psgetrolesUpdate.isClosed()){
					 psgetrolesUpdate.close();
				 }
				 
				 if(conn!=null && (!conn.isClosed())){
					 conn.close();
					 
				 }
				
			
			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			}catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
	}
 logger.setLevel(Level.DEBUG);
 JLogger.log(0, JDate.getTimeString(new Date())
 		+ MessageConstants.END_POINT);
 logger.info(JDate.getTimeString(new Date())
 		+ " Control in RoleMasterDaoImpl:updateRoles Ending");
// TODO Auto-generated method stub
return updateRoleList;


}

public synchronized boolean validateRoleCode(String roleCodeId) throws Exception {


	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:validateRoleCode Starting");
	
	 boolean role_Code_Available=false;
	 int count=0;
	 PreparedStatement pscheckRoleCode =null;
	 ResultSet rsCheckRoleName=null;
	 Connection conn=null; 
	try{
		conn=getConnection();
		
		pscheckRoleCode = conn.prepareStatement(UserRolePermission.VALIDATE_ROLE_CODE);
		pscheckRoleCode.setString(1,roleCodeId);
		  rsCheckRoleName=pscheckRoleCode.executeQuery();
	while(rsCheckRoleName.next()){
		count=rsCheckRoleName.getInt("RoleCode");
	
	}
		if(count>0){
			
			role_Code_Available=true;
			
		}
		

	} catch (SQLException e) {
		logger.error(e);
	     e.printStackTrace();
	   }catch (Exception e) {
		   logger.error(e);
				e.printStackTrace();
			}
			finally{
				
				 try {
					 
					 if(rsCheckRoleName!=null && !rsCheckRoleName.isClosed()){
						 rsCheckRoleName.close();
					 }
					 
					 if(pscheckRoleCode!=null && !pscheckRoleCode.isClosed()){
						 pscheckRoleCode.close();
					 }
					 
					 if(conn!=null && (!conn.isClosed())){
						 conn.close();
						 
					 }
					 
					
					
				
				} catch (SQLException e) {
					logger.error(e);
					e.printStackTrace();
				}catch (Exception e) {
					logger.error(e);
					e.printStackTrace();
				}
		}
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:validateRoleCode Ending");
	return role_Code_Available;
}





public synchronized boolean validateRoleName(String roleName) throws Exception {


	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:validateRoleName Starting");
	
	 boolean 
		role_Name_Available=false;
	 int count=0;
	 PreparedStatement pscheckRoleName =null;
	 ResultSet rsCheckRoleName=null;
	 Connection conn=null; 
	 try{
		 conn=getConnection();
		 pscheckRoleName = conn.prepareStatement(UserRolePermission.VALIDATE_ROLE_NAME);
		 pscheckRoleName.setString(1,roleName);
		  rsCheckRoleName=pscheckRoleName.executeQuery();
	while(rsCheckRoleName.next()){
		count=rsCheckRoleName.getInt("RoleName");
		
	}
		if(count>0){
			
			role_Name_Available=true;
			
		}
		

	} catch (SQLException e) {
		logger.error(e);
	     e.printStackTrace();
	   }catch (Exception e) {
		   logger.error(e);
				e.printStackTrace();
			}
			finally{
				
				 try {
					
					 if(rsCheckRoleName!=null && !rsCheckRoleName.isClosed()){
						 rsCheckRoleName.close();
					 }
					 
					 if(pscheckRoleName!=null && !pscheckRoleName.isClosed()){
						 pscheckRoleName.close();
					 }
					 
					 if(conn!=null && (!conn.isClosed())){
						 conn.close();
						 
					 }
					 
					
					
				
				} catch (SQLException e) {
					logger.error(e);
					e.printStackTrace();
				}catch (Exception e) {
					logger.error(e);
					e.printStackTrace();
				}
		}
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:validateRoleName Ending");
	return  role_Name_Available;
}


public synchronized boolean validateRoleNameUpdate(String roleName,String roleid) throws Exception {


	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:validateRoleNameUpdate Starting");
	 boolean 
		role_Name_Available=false;
	 int count=0;
	 PreparedStatement pscheckRoleName =null;
	 ResultSet rsCheckRoleName=null;
	 Connection conn=null; 
	try{
		conn=getConnection();
		 pscheckRoleName = conn.prepareStatement(UserRolePermission.VALIDATE_ROLE_NAME_UPDATE);
		 pscheckRoleName.setString(1,roleName);
		 pscheckRoleName.setString(2,roleid);
		 
		  rsCheckRoleName=pscheckRoleName.executeQuery();
	while(rsCheckRoleName.next()){
		count=rsCheckRoleName.getInt("RoleName");
		
	}
		if(count>0){
			
			role_Name_Available=true;
			
		}
		

	}catch (SQLException e) {
		logger.error(e);
	     e.printStackTrace();
	   }catch (Exception e) {
		   logger.error(e);
				e.printStackTrace();
			}
			finally{
				
				 try {
					 
					 if(rsCheckRoleName!=null && !rsCheckRoleName.isClosed()){
						 rsCheckRoleName.close();
					 }
					 
					 if(pscheckRoleName!=null && !pscheckRoleName.isClosed()){
						 pscheckRoleName.close();
					 }
					 
					 if(conn!=null && (!conn.isClosed())){
						 conn.close();
						 
					 }
					 
					
					
				
				} catch (SQLException e) {
					logger.error(e);
					e.printStackTrace();
				}catch (Exception e) {
					logger.error(e);
					e.printStackTrace();
				}
		}
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in RoleMasterDaoImpl:validateRoleNameUpdate Ending");
	return  role_Name_Available;
}



   public List<RoleMasterVo> getAllNRolesDao() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in RoleMasterDaoImpl : getAllNRolesDao Starting");
		
		 Connection conn=null;
		 PreparedStatement ps_roles=null;
		 ResultSet rs_roles=null;
		 
		List<RoleMasterVo> NRoleList=new ArrayList<RoleMasterVo>();
		 try{
			 conn=getConnection();
			 ps_roles=conn.prepareStatement(UserRolePermission.GET_N_ROLES);
			 rs_roles=ps_roles.executeQuery();
		 while(rs_roles.next()){
			 RoleMasterVo roleMasterVo=new RoleMasterVo();
		
			 roleMasterVo.setRoleId(rs_roles.getString("RoleCode"));
			 roleMasterVo.setRoleName(rs_roles.getString("RoleName"));
				
			 NRoleList.add(roleMasterVo);
		 }
		
		 } catch (SQLException e) {
				 logger.error(e);
			        e.printStackTrace();
			      }catch (Exception e) {
			    	  logger.error(e);
						e.printStackTrace();
					}
					finally{
						
						 try {
			               if(rs_roles!=null && !rs_roles.isClosed()){
			            	   rs_roles.close();
			               }
	                        
			               if(ps_roles!=null && !ps_roles.isClosed()){
			            	   ps_roles.close();
			               }
			               if(conn!=null && (!conn.isClosed())){
								 conn.close();
								 
							 }
							
						
						} catch (SQLException e) {
							logger.error(e);
							e.printStackTrace();
						}catch (Exception e) {
							logger.error(e);
							e.printStackTrace();
						}
				}
					
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RoleMasterDaoImpl : getAllNRolesDao Ending");
		
		return NRoleList;
}










}











