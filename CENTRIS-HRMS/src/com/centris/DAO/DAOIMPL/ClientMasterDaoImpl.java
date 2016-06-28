/**
 * 
 */
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

import com.centris.DAO.ClientMasterDao;
import com.centris.DAO.DBService;
import com.centris.POJO.ClientMasterPojo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.ClientMaster;
import com.centris.util.SQLUtils.Manager;
import com.centris.util.constants.MessageConstants;

/**
 * @author satish
 *
 */
public class ClientMasterDaoImpl extends DBService implements ClientMasterDao{
	private static Logger logger = Logger.getLogger(ProjectMasterDaoImpl.class);
	@Override
	public String insertClientDetails(ClientMasterPojo clientMasterPojo) {
		
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ClientMasterDaoImpl:insertClientDetails : Starting");
			
			PreparedStatement preparedStatement = null;
			Connection connection = null;
			int insertCount=0;
			String status = null;

			try {
				connection = getConnection();
			

				preparedStatement = connection.prepareStatement(ClientMaster.INSERT_CLIENT_DETAILS);
				preparedStatement.setString(1,clientMasterPojo.getClientCode());
				preparedStatement.setString(2,clientMasterPojo.getClientName());
				preparedStatement.setString(3,clientMasterPojo.getCountry());
				preparedStatement.setString(4,clientMasterPojo.getState());
				preparedStatement.setString(5,clientMasterPojo.getAddress());
				preparedStatement.setString(6,clientMasterPojo.getPhoneNo());
				preparedStatement.setString(7,clientMasterPojo.getCreatedBy());
				preparedStatement.setTimestamp(8,clientMasterPojo.getCreateDate());
				insertCount=preparedStatement.executeUpdate();
				
				if(insertCount>0){
					status="Client Details Saved Successfully";	
				}
				else
				{
					status="Client Details Not  Saved";	
				}
			} 
		
			catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
			
			
			
			
			finally {
				try {

					
					if (preparedStatement != null && (!preparedStatement.isClosed())) {

						preparedStatement.close();
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
					+ " Control in Control in ClientMasterDaoImpl:insertClientDetails : Ending");
			
			return status;

		}
	@Override
	public boolean checkClientName(String clientName) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterDaoImpl:checkClientName : Starting");
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		int count = 0;
		boolean status=false;

		try {
			connection = getConnection();
		preparedStatement = connection.prepareStatement(ClientMaster.CHECK_CLIENT_NAME);
			preparedStatement.setString(1,clientName);
ResultSet resultSet=preparedStatement.executeQuery();
while(resultSet.next()){
	count=resultSet.getInt(1);
}

if(count>0){
	status=true;	
}
else
{
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

				
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in Control in ClientMasterDaoImpl:checkClientName  : Ending");
		
		return status;

	}
	@Override
	public String updateClientDetails(ClientMasterPojo clientMasterPojo) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterDaoImpl:updateClientDetails : Starting");
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		int count=0;
		String status = null;

		try {
			connection = getConnection();
		

			preparedStatement = connection.prepareStatement(ClientMaster.UPDATE_CLIENT_DETAILS);
		
					preparedStatement.setString(1,clientMasterPojo.getClientName());
			preparedStatement.setString(1,clientMasterPojo.getClientName());
			preparedStatement.setString(2,clientMasterPojo.getCountry());
			preparedStatement.setString(3,clientMasterPojo.getState());
			preparedStatement.setString(4,clientMasterPojo.getAddress());
			preparedStatement.setString(5,clientMasterPojo.getPhoneNo());
			preparedStatement.setString(6,clientMasterPojo.getCreatedBy());
			preparedStatement.setTimestamp(7,HelperClass.getCurrentTimestamp());
			preparedStatement.setString(8,clientMasterPojo.getClientCode());
			count=preparedStatement.executeUpdate();
			
			if(count>0){
				status="Client Details Updated Successfully";
			}
			else
			{
				status="Cleint Details Not Updated";
			}
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in Control in  ClientMasterDaoImpl:updateClientDetails  Ending");
		return status;
	}
	@Override
	public String deleteClientDetails(String[] clientCodeArray) {
		// TODO Auto-generated method stub
	
			// TODO Auto-generated method stub
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ClientMasterDaoImpl:deleteClientDetails : Starting");
			
			PreparedStatement preparedStatement = null;
			Connection connection = null;
			int count=0;
			String status = null;

			try {
				connection = getConnection();
			

				preparedStatement = connection.prepareStatement(ClientMaster.DELETE_CLIENT_DETAILS);
				for(int i=0;i<clientCodeArray.length;i++){
					preparedStatement.setString(1,clientCodeArray[i]);
					
					count=preparedStatement.executeUpdate();
				
				}
				if(count>0){
					status="Client Details Deleted Successfully";
				}
				else
				{
					status="Client Details Not Deleted";
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			} finally {
				try {

					
					if (preparedStatement != null && (!preparedStatement.isClosed())) {

						preparedStatement.close();
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
					+ " Control in Control in ClientMasterDaoImpl:deleteClientDetails : Ending");
			return status;
		}
	@Override
	public List<ClientMasterPojo> editClientDetails(String clientCode) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterDaoImpl:editClientDetails: Starting");
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ArrayList<ClientMasterPojo> getClientDetails=new ArrayList<ClientMasterPojo>();
		

		try {
			connection = getConnection();
		

			preparedStatement = connection.prepareStatement(ClientMaster.GET_EDIT_CLIENT_DETAILS);
			preparedStatement.setString(1,clientCode);
			ResultSet resultSet=preparedStatement.executeQuery();
			
while(resultSet.next()){
	
	ClientMasterPojo clientMasterPojo=new ClientMasterPojo();
	clientMasterPojo.setClientCode(resultSet.getString("ClientCode"));
	clientMasterPojo.setClientName(resultSet.getString("ClientName"));
	clientMasterPojo.setCountry(resultSet.getString("Country"));
	clientMasterPojo.setState(resultSet.getString("State"));
	clientMasterPojo.setPhoneNo(resultSet.getString("PhoneNo"));
	clientMasterPojo.setAddress(resultSet.getString("Address"));
	getClientDetails.add(clientMasterPojo);
	
}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in Control in ClientMasterDaoImpl:editClientDetails: Ending");
		return getClientDetails;
	
	}
	@Override
	public ArrayList<ClientMasterPojo> getClientDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterDaoImpl:getClientDetails : Starting");
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ArrayList<ClientMasterPojo> getClientDetails=new ArrayList<ClientMasterPojo>();
		

		try {
			connection = getConnection();
		

			preparedStatement = connection.prepareStatement(ClientMaster.GET_CLIENT_DETAILS);
			ResultSet resultSet=preparedStatement.executeQuery();
while(resultSet.next()){
	
	ClientMasterPojo clientMasterPojo=new ClientMasterPojo();
	clientMasterPojo.setClientCode(resultSet.getString("ClientCode"));
	clientMasterPojo.setClientName(resultSet.getString("ClientName"));
	clientMasterPojo.setCountry(resultSet.getString("Country"));
	clientMasterPojo.setState(resultSet.getString("State"));
	clientMasterPojo.setPhoneNo(resultSet.getString("PhoneNo"));
	clientMasterPojo.setAddress(resultSet.getString("Address"));
	getClientDetails.add(clientMasterPojo);
	
}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in Control in ClientMasterDaoImpl:getClientDetails : Ending");
		return getClientDetails;
	}
	@Override
	public boolean checkUpdateClientName(String clientName,String clientCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterDaoImpl:checkClientName : Starting");
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		int count = 0;
		boolean status=false;

		try {
			connection = getConnection();
		preparedStatement = connection.prepareStatement(ClientMaster.CHECK_UPDATE_CLIENT_NAME);
			preparedStatement.setString(1,clientName);
			preparedStatement.setString(2,clientCode);
			
ResultSet resultSet=preparedStatement.executeQuery();
while(resultSet.next()){
	count=resultSet.getInt(1);
}

if(count>1){
	status=true;	
}
else
{
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

				
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in Control in ClientMasterDaoImpl:checkClientName : Ending");
		
		return status;
	}
	

}
