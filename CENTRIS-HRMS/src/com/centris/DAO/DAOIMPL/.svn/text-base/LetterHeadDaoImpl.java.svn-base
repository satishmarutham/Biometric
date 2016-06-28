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
import com.centris.DAO.LetterHeadDao;
import com.centris.POJO.LetterHeadPOJO;
import com.centris.VO.LetterHeadVo;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LetterHeadSqlUtil;
import com.centris.util.constants.MessageConstants;

public class LetterHeadDaoImpl extends DBService implements LetterHeadDao{

	private static Logger logger = Logger.getLogger(LetterHeadDaoImpl.class);
	public String insertLetterHead(LetterHeadPOJO letterHeadPOJO) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LetterHeadDaoImpl : insertLetterHead : Starting");

		Connection connection=null;
		PreparedStatement pst_letterh = null;
		String status = null;
		ResultSet rs_letterh=null;
		int count=0;
		try {
			
	    	connection=getConnection();
	    	
	    	pst_letterh = connection.prepareStatement(LetterHeadSqlUtil.GET_lETTER_HEAD_COUNT);
	    	pst_letterh.setString(1, letterHeadPOJO.getLettertype());
			pst_letterh.setString(2, letterHeadPOJO.getPurpose());
			pst_letterh.setString(3, letterHeadPOJO.getDescription());
			pst_letterh.setString(4, letterHeadPOJO.getCreatedby());	
	    	
			rs_letterh=pst_letterh.executeQuery();
			while (rs_letterh.next()) {
				count=rs_letterh.getInt(1);
				
			}
			
			if (rs_letterh != null && (!rs_letterh.isClosed())) {

				rs_letterh.close();
			}
			
			if (pst_letterh != null && (!pst_letterh.isClosed())) {

				pst_letterh.close();
			}
			
			if(count == 0){
			pst_letterh = connection
						.prepareStatement(LetterHeadSqlUtil.INSERT_lETTER_HEAD);
			pst_letterh.setString(1, letterHeadPOJO.getLetterheadcode());
			pst_letterh.setString(2, letterHeadPOJO.getLettertype());
			pst_letterh.setString(3, letterHeadPOJO.getPurpose());
			pst_letterh.setString(4, letterHeadPOJO.getDescription());
			pst_letterh.setString(5, letterHeadPOJO.getCreatedby());
				
		     int no= pst_letterh.executeUpdate();
			

				if (no > 0) {

					status = MessageConstants.TRUE;

				} else {

					status = MessageConstants.FALSE;
				}
				
			}else{
				status = MessageConstants.TRUE;
			} 
			
			
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
	        sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if (rs_letterh != null && (!rs_letterh.isClosed())) {

					rs_letterh.close();
				}
				
				if (pst_letterh != null && (!pst_letterh.isClosed())) {

					pst_letterh.close();
				}
				
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
				e.printStackTrace();
			} catch (Exception e1) {

				logger.error(e1.getMessage(),e1);
				e1.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LetterHeadDaoImpl : insertLetterHead : Ending");

		return status;
	}
	public ArrayList<LetterHeadVo> getAllLetterHeads(String usercode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LetterHeadDaoImpl : getAllLetterHeads : Starting");

		Connection connection=null;
		PreparedStatement pst_letterh = null;
		String status = null;
		ResultSet rs_letterh=null;
		
		ArrayList<LetterHeadVo> letterheadlist= new ArrayList<LetterHeadVo>();
		
		try {
			
	    	connection=getConnection();
					
			pst_letterh = connection
						.prepareStatement(LetterHeadSqlUtil.GET_ALL_LETTERHEADS);
			pst_letterh.setString(1, usercode);
	
			rs_letterh= pst_letterh.executeQuery();
		
			while(rs_letterh.next()){
				
				LetterHeadVo letterHeadVo= new LetterHeadVo();
				
				letterHeadVo.setLettertype(rs_letterh.getString("LetterType"));
				letterHeadVo.setPurpose(rs_letterh.getString("Purpose"));
				letterHeadVo.setDescription(rs_letterh.getString("Description"));
				letterHeadVo.setStatus(rs_letterh.getString("Status"));
				letterHeadVo.setCreatetime(rs_letterh.getString("CreateDate"));
				
				letterheadlist.add(letterHeadVo);
			}

							
		
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
	        sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				

				if (rs_letterh != null && (!rs_letterh.isClosed())) {

					rs_letterh.close();
				}

				if (pst_letterh != null && (!pst_letterh.isClosed())) {

					pst_letterh.close();
				}
				
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
				e.printStackTrace();
			} catch (Exception e1) {

				logger.error(e1.getMessage(),e1);
				e1.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LetterHeadDaoImpl : getAllLetterHeads : Ending");

		return letterheadlist;
	}

}
