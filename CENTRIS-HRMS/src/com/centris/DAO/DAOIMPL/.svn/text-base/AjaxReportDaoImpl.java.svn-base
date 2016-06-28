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

import com.centris.DAO.AjaxReportDao;
import com.centris.DAO.DBService;
import com.centris.VO.DirectorVo;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.ReportsAjaxVo;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AjaxReportsUtil;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.MonthReportSqlUtil;
import com.centris.util.constants.MessageConstants;

/**
 * @author satish
 *
 */
public class AjaxReportDaoImpl extends DBService implements AjaxReportDao {
	private static Logger logger = Logger.getLogger(AjaxReportDaoImpl.class);
	@Override
	public List<ReportsAjaxVo> getManagersByDirectorCode(String[] departmentCode,String userType,String userCode) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AjaxReportDaoImpl: getManagersByDirectorCode Starting");
		Connection connection = null;
		PreparedStatement ps = null;
	    ResultSet rs=null;
	    List<ReportsAjaxVo> reportsAjaxVos=new ArrayList<ReportsAjaxVo>();
	
	    
	    try{
	    	connection = getConnection();
	    	if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
	    		
	    		ps=connection.prepareStatement(MonthReportSqlUtil.GET_MANAGER_BY_DEPARTMENT_CODE_DIRECTOR);
	    		for(int i=0;i<departmentCode.length;i++){
	    		    ps.setString(1,departmentCode[i]);
	    		    ps.setString(2,userCode);
	    		   
	    		    rs= ps.executeQuery();	
	    		    
	    		    	while(rs.next()){
	    		    		ReportsAjaxVo managervo=new ReportsAjaxVo();
	    		    		managervo.setManagerid(rs.getString("ManagerCode").trim());
	    		    		managervo.setFirstname(rs.getString("FirstName"));
	    		    		reportsAjaxVos.add(managervo);
	    		    	}
	    		    	
	    		    }
	    	}
	    	else
	    	{
	    	
	    		ps=connection.prepareStatement(MonthReportSqlUtil.GET_MANAGER_BY_DEPARTMENT_CODE);
	    		for(int i=0;i<departmentCode.length;i++){
	    		    ps.setString(1,departmentCode[i]);
	    		    
	    		   
	    		    rs= ps.executeQuery();	
	    		    
	    		    	while(rs.next()){
	    		    		ReportsAjaxVo managervo=new ReportsAjaxVo();
	    		    		managervo.setManagerid(rs.getString("ManagerCode").trim());
	    		    		managervo.setFirstname(rs.getString("FirstName"));
	    		    		reportsAjaxVos.add(managervo);
	    		    	}
	    		    	
	    		    }
	    		
	    	}
	    
	    }
		catch(Exception  exception){
			
		}
		// TODO Auto-generated method stub
		return reportsAjaxVos;
	}
	@Override
	public List<ReportsAjaxVo> getProjectsByManagerCode(String[] managerCode) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AjaxReportDaoImpl: getProjectsByManagerCode Starting");
		Connection connection = null;
		PreparedStatement ps = null;
	    ResultSet rs=null;
	    List<ReportsAjaxVo> reportsAjaxVos=new ArrayList<ReportsAjaxVo>();
	
	    
	    try{
	    	connection = getConnection();
	    ps=connection.prepareStatement(AjaxReportsUtil.GET_PROJECT_BY_MANAGER_CODE);
	    for(int i=0;i<=managerCode.length;i++){
	    
	    
	    ps.setString(1,managerCode[i]);
	    rs= ps.executeQuery();	
	    
	    	while(rs.next()){
	    		ReportsAjaxVo reportsAjaxVo=new ReportsAjaxVo();
	    		reportsAjaxVo.setProjectCode(rs.getString("ProjectCode"));
	    	
	    		reportsAjaxVo.setProjectRefCode(rs.getString("ProjectRefCode"));
	    		reportsAjaxVos.add(reportsAjaxVo);
	    	}
	    }
	    }
		catch(Exception  exception){
			
		}
		// TODO Auto-generated method stub
		return reportsAjaxVos;
	}
	public List<DirectorVo> getDirectorsByAdmin(String adminCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DirectorDaoImpl : getDirectorsByAdmin Starting");

		DBService db = null;
		PreparedStatement getDirectorsPstm = null;
		ResultSet getDirectorsResultset  = null;
		List<DirectorVo> getDirectorsListByAdmin=new ArrayList<DirectorVo>();
		// TODO Auto-generated method stub
		try {
			db = new DBService();
			getDirectorsPstm = db
					.getPreparedStatement(AjaxReportsUtil.GET_DIRECTOR_DETAILS_BY_ADMIN);
			getDirectorsPstm.setString(1, adminCode);

			getDirectorsResultset = getDirectorsPstm.executeQuery();

			while (getDirectorsResultset.next()) {
				DirectorVo directorVo=new DirectorVo();
				directorVo.setDirectorCode(getDirectorsResultset.getString("DirectorCode"));
				directorVo.setDirectorName(getDirectorsResultset.getString("Username"));
				getDirectorsListByAdmin.add(directorVo);
			}

			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (getDirectorsPstm != null
						&& (!getDirectorsPstm.isClosed())) {
					getDirectorsPstm.getConnection().close();
				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordDaoImpl : getCurrentPassword Ending");
		return getDirectorsListByAdmin;
	}

	
	

}
