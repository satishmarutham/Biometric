package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.LocationUpdateReportDAO;
import com.centris.VO.LocationUpdateReportVO;
import com.centris.form.LocationUpdateReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class LocationUpdateReportDAOImpl extends DBService implements
		LocationUpdateReportDAO {
	private static Logger logger = Logger
			.getLogger(LocationUpdateReportDAOImpl.class);

	@Override
	public synchronized List<LocationUpdateReportVO> getLocationUpdateReport(
			LocationUpdateReportForm locationUpdateReportForm) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationUpdateReportDAOImpl:getLocationUpdateReport Starting");
		List<LocationUpdateReportVO> locationUpdateReportVOList = new ArrayList<LocationUpdateReportVO>();
		Connection conn = null;
		PreparedStatement psmt = null;
		LocationUpdateReportVO locationUpdateReportVO = null;
		try {
			conn = getConnection();
			psmt = conn
					.prepareStatement(SQLutilConstants.GET_LOCATION_UPDATE_REPORT);
			psmt.setString(1, locationUpdateReportForm.getLocation());
			psmt.setString(2, locationUpdateReportForm.getGroup());
			System.out.println(psmt);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				locationUpdateReportVO = new LocationUpdateReportVO();
				locationUpdateReportVO.setLocationId(rs
						.getString("LOCATION_CODE"));
				locationUpdateReportVO
						.setLocationName(rs.getString("Location"));
				if(rs.getString("AI_EMP_DATE").trim().equals("-")){
					locationUpdateReportVO.setUpdateDate(rs.getString("AI_EMP_DATE"));
				}
				else{
					locationUpdateReportVO.setUpdateDate(HelperClass.convertDatabaseToUI(rs.getString("AI_EMP_DATE")));
				}
				locationUpdateReportVO.setLastUpdateTime(rs
						.getString("lastUpdateTime"));
				locationUpdateReportVOList.add(locationUpdateReportVO);
			}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			try {

				 if(psmt!=null && (!psmt.isClosed())){
					 psmt.getConnection().close();
					 
				 }
					

				

			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  Control in LocationUpdateReportDAOImpl:getLocationUpdateReport Ending");
		return locationUpdateReportVOList;
	}

}
