package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.AddDesignationDao;
import com.centris.DAO.DBService;
import com.centris.POJO.AddDesignationPojo;
import com.centris.VO.AddDesignationVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.DesignationMaster;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class AddDesignationDaoImpl extends DBService implements
		AddDesignationDao {

	private static Logger logger = Logger
			.getLogger(AddDesignationDaoImpl.class);

	public synchronized String insertDesignationDetails(AddDesignationPojo apojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl:insertDesignationDetails:Starting");

		AddDesignationDaoImpl des = new AddDesignationDaoImpl();
		int no = 0;
		Connection connection=null;
		PreparedStatement designationStatement = null;
		String status = null;

		try {
			
			connection=getConnection();
	
				if (!(des.validateDesName(apojo.getDesgname(), apojo.getDesgid()))) {
					
				designationStatement = connection
						.prepareStatement(DesignationMaster.INSERT_DESIGNATION_DETAILS);
				designationStatement.setString(1, apojo.getDesgid());
				designationStatement.setString(2, apojo.getDesgname());
				designationStatement.setString(3, apojo.getDesgdes());
				designationStatement.setTimestamp(4, HelperClass.getCurrentTimestamp());
				designationStatement.setString(5, "Y");
				designationStatement.setString(6, apojo.getCreatedBy());
				designationStatement.setString(7,apojo.getReportingTo());
					no = designationStatement.executeUpdate();
			

				if (no > 0) {

					status = MessageConstants.ADD_DESIGNATION_SUCCESS;

				} else {

					status = MessageConstants.ADD_DESIGNATION_FAIL;
				}
				
			}

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
	
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if (designationStatement != null && (!designationStatement.isClosed())) {

					designationStatement.close();
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
				+ " Control in AddDesignationDaoImpl:insertDesignationDetails: Ending");

		return status;
	}
	
	
	public synchronized String updateDesignationDetails(AddDesignationPojo apojo) {
		


		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl:updateDesignationDetails:Starting");

		int no = 0;
		Connection connection=null;
		PreparedStatement designationStatement = null;
		String status = null;

		try {
			connection=getConnection();

				designationStatement = connection
						.prepareStatement(DesignationMaster.UPDATE_DESIGNATION);

				designationStatement.setString(1, apojo.getDesgname());
				designationStatement.setString(2, apojo.getDesgdes());
				designationStatement.setString(3, "Y");
				designationStatement.setString(4,apojo.getReportingTo());
				designationStatement.setString(5, apojo.getCreatedBy());
				designationStatement.setTimestamp(6,HelperClass.getCurrentTimestamp());
				designationStatement.setString(7,apojo.getDesgid());
				

				no = designationStatement.executeUpdate();

				if (no > 0) {

					status = MessageConstants.UPDATE_DESIGNATION_SUCCESS;

				} else {

					status = MessageConstants.UPDATE_DESIGNATION_FAIL;

				}


		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {

			try {

				if (designationStatement != null && (!designationStatement.isClosed())) {

					designationStatement.close();
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
				+ " Control in AddDesignationDaoImpl:updateDesignationDetails: Ending");

		return status;
	
		
		
	}

	public synchronized ArrayList<AddDesignationVO> getDesignationDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: getDesignationDetails : Starting");
		PreparedStatement designationStatement = null;
		ResultSet designationResultSet = null;
		Connection connection=null;
		ArrayList<AddDesignationVO> list = new ArrayList<AddDesignationVO>();

		try {
			connection=getConnection();
			designationStatement = connection
					.prepareStatement(DesignationMaster.GET_DESIGNATION_DETAILS);

			designationResultSet = designationStatement.executeQuery();

			while (designationResultSet.next()) {
				AddDesignationVO addDesignationVO = new AddDesignationVO();

				addDesignationVO.setDesgid(designationResultSet
						.getString("DesignationCode"));
				addDesignationVO.setDesgname(designationResultSet
						.getString("designationName"));
				addDesignationVO.setDesgdes(designationResultSet
						.getString("description"));
				addDesignationVO.setCreatedate(designationResultSet
						.getString("createdate"));
				addDesignationVO.setCreateuser(designationResultSet
						.getString("CreatedBy"));
				String reportingTo=designationResultSet
						.getString("ReportingTo");
				addDesignationVO.setReportingTo(reportingTo);
				String getReportingName=getReportingNameById(reportingTo);
				addDesignationVO.setReportingToName(getReportingName);
				list.add(addDesignationVO);

			}
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);

		} catch (Exception e) {

			logger.error(e.getMessage(),e);
		} finally {

			try {

				if (designationResultSet != null && (!designationResultSet.isClosed())) {

					designationResultSet.close();
				}
				if(designationStatement != null && (!designationStatement.isClosed())){
					
					designationStatement.close();
				}
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException sqle) {

				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {

				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: getDesignationDetails : Ending");
		return list;
	}

	public synchronized  boolean validateDesName(String desname, String desid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: validateDesName : Starting");

		PreparedStatement designationStatement = null;
		ResultSet designationResultSet = null;
		Connection connection=null;

		boolean desname_available = false;
		int count = 0;

		try {
			connection=getConnection();
			designationStatement = connection
					.prepareStatement(DesignationMaster.VALIDE_DES_NAME);
			designationStatement.setString(1,desname);

			designationResultSet = designationStatement.executeQuery();

			while (designationResultSet.next()) {

				count = designationResultSet.getInt(1);
			}

			if (count > 0) {

				desname_available = true;

			} else {

				desname_available = false;
			}

		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {

			try {
				if (designationResultSet != null && (!designationResultSet.isClosed())) {

					designationResultSet.close();
				}
				if(designationStatement != null && (!designationStatement.isClosed())){
					
					designationStatement.close();
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
				+ " Control in AddDesignationDaoImpl: validateDesName : Ending");

		return desname_available;
	}

	public synchronized boolean validateDesNameUpdate(String desname, String desid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: validateDesNameUpdate : Starting");

		PreparedStatement designationStatement = null;
		ResultSet designationResultSet = null;
		boolean desname_available = false;
		int count = 0;
		Connection connection=null;

		try {
			connection=getConnection();
			designationStatement = connection
					.prepareStatement(DesignationMaster.VALIDATE_DESIGNATION_UPDATE);
			designationStatement.setString(1, desname);
			designationStatement.setString(2, desid);

			designationResultSet = designationStatement.executeQuery();

			while (designationResultSet.next()) {

				count = designationResultSet.getInt("desname");
			}

			if (count > 0) {

				desname_available = true;

			} else {

				desname_available = false;

			}

		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {

			try {
				if (designationResultSet != null && (!designationResultSet.isClosed())) {

					designationResultSet.close();
				}
				if(designationStatement != null && (!designationStatement.isClosed())){
					
					designationStatement.close();
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
				+ " Control in AddDesignationDaoImpl: validateDesNameUpdate : Ending");

		return desname_available;
	}

	public synchronized ArrayList<AddDesignationVO> getEditDesignationDetails(String des_id) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: getEditDesignationDetails : Starting");

		PreparedStatement designationStatement = null;
		ResultSet designationResultSet = null;
		ArrayList<AddDesignationVO> list = new ArrayList<AddDesignationVO>();
		Connection connection=null;

		try {
			connection=getConnection();
			designationStatement = connection.prepareStatement(DesignationMaster.EDIT_DESIGNATION);

			designationStatement.setString(1, des_id);

			designationResultSet = designationStatement.executeQuery();
String reportingTo=null;
			while (designationResultSet.next()) {
				AddDesignationVO addDesignationVO = new AddDesignationVO();

				addDesignationVO.setDesgid(designationResultSet
						.getString("DesignationCode"));
				addDesignationVO.setDesgname(designationResultSet
						.getString("designationName"));
				addDesignationVO.setDesgdes(designationResultSet
						.getString("description"));
				addDesignationVO.setCreatedate(designationResultSet
						.getString("createdate"));
				addDesignationVO.setCreateuser(designationResultSet.getString("CreatedBy"));
				reportingTo=designationResultSet.getString("ReportingTo");
				
				addDesignationVO.setReportingTo(reportingTo);
				
				
				String reportingName=getReportingNameById(reportingTo);
				
				addDesignationVO.setReportingToName(reportingName);
				

				list.add(addDesignationVO);

			}
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e) {

			logger.error(e.getMessage(),e);
		} finally {

			try {

				if (designationResultSet != null && (!designationResultSet.isClosed())) {

					designationResultSet.close();
				}
				if(designationStatement != null && (!designationStatement.isClosed())){
					
					designationStatement.close();
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
				+ " Control in AddDesignationDaoImpl: getEditDesignationDetails : Ending");

		return list;
	}

	public synchronized String deleteDesignationDetails(String[] desid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: deleteDesignationDetails : Starting");
		
		ResultSet designationResultSet = null;
		ResultSet rs_deletedesignation=null;
		PreparedStatement deleteDesignationStatement = null;
		PreparedStatement ps_deletedesignation = null;
		int no = 0;
		String status = null;
		Connection connection=null;

		try {
			connection=getConnection();
			deleteDesignationStatement = connection.prepareStatement(DesignationMaster.CHECK_DESIGNATION_MAP);
			for (int i = 0; i < desid.length; i++) {

				
				deleteDesignationStatement.setString(1, desid[i]);
				designationResultSet = deleteDesignationStatement
						.executeQuery();

				while (designationResultSet.next()) {

					no = designationResultSet.getInt("desname");
					if (no > 0) {

						ps_deletedesignation = connection.prepareStatement(DesignationMaster.GET_SINGLE_DESIGNATION);
						ps_deletedesignation.setString(1, desid[i]);
						rs_deletedesignation = ps_deletedesignation.executeQuery();
						while (rs_deletedesignation.next()) {

							String name = rs_deletedesignation.getString("designationName");

							status = "Unable to Delete : "+ name +" Designation is in Use";

						}
						
					} else {

						ps_deletedesignation = connection.prepareStatement(DesignationMaster.DELETE_DESIGNATION);
						ps_deletedesignation.setString(1,"N");
						ps_deletedesignation.setString(2, desid[i]);
					
						
						no = ps_deletedesignation.executeUpdate();

						if (no > 0) {

							status = MessageConstants.DESIGNATION_DELETE_SUCCESS;
						} else {

							status = MessageConstants.DESIGNATION_DELETE_FAIL;
						}
						
						

					}

				}

			}

		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);

		} catch (Exception e) {

		
			logger.error(e.getMessage(),e);
		} finally {

			try {

				if (rs_deletedesignation != null && (!rs_deletedesignation.isClosed())) {
					
					rs_deletedesignation.close();
				}
				if(designationResultSet != null && (!designationResultSet.isClosed())){
					
					designationResultSet.close();
				}
				if(ps_deletedesignation != null && (!ps_deletedesignation.isClosed())){
									
					ps_deletedesignation.close();
								}
				if(deleteDesignationStatement != null && (!deleteDesignationStatement.isClosed())){
					
					deleteDesignationStatement.close();
				}
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {

				logger.error(e);
				e.printStackTrace();
			} catch (Exception e1) {

				logger.error(e1.getMessage(),e1);
		
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: deleteDesignationDetails : Ending");

		return status;
	}

	public synchronized boolean validateDesId(String desid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: validateDesId : Starting");
		PreparedStatement designationStatement = null;
		ResultSet designationResultSet = null;
		boolean desname_available = false;
		int count = 0;
		Connection connection=null;

		try {
			connection=getConnection();
			designationStatement = connection
					.prepareStatement(DesignationMaster.VALIDATE_DESID);
			designationStatement.setString(1, desid);

			designationResultSet = designationStatement.executeQuery();

			while (designationResultSet.next()) {

				count = designationResultSet.getInt("desname");
			}

			if (count > 0) {

				desname_available = true;

			}

		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
		} catch (Exception e) {

			logger.error(e.getMessage(),e);
			
		} finally {

			try {
			
				if (designationResultSet != null && (!designationResultSet.isClosed())) {

					designationResultSet.close();
				}
				if(designationStatement != null && (!designationStatement.isClosed())){
					designationStatement.close();
				}
				if(connection != null && (!connection.isClosed())){
					connection.close();
				}

			} catch (SQLException sqle) {

				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {

				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: validateDesId : Ending");

		return desname_available;
	}
	
	public synchronized String getReportingNameById(String reportingCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: getReportingNameById : Starting");
		PreparedStatement designationStatement = null;
		ResultSet designationResultSet = null;
	
		String reportingName=null;
		Connection connection=null;

		try {
			connection=getConnection();
			designationStatement = connection
					.prepareStatement(DesignationMaster.GET_REPORTINGTO_BY_ID);
			designationStatement.setString(1,reportingCode);

			designationResultSet = designationStatement.executeQuery();

			while (designationResultSet.next()) {

				reportingName = designationResultSet.getString("designationName");
			}

			
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
		} catch (Exception e) {

			logger.error(e.getMessage(),e);
			
		} finally {

			try {
			
				if (designationResultSet != null && (!designationResultSet.isClosed())) {

					designationResultSet.close();
				}
				if(designationStatement != null && (!designationStatement.isClosed())){
					designationStatement.close();
				}
				if(connection != null && (!connection.isClosed())){
					connection.close();
				}

			} catch (SQLException sqle) {

				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {

				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl: getReportingNameById : Ending");

		return reportingName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
