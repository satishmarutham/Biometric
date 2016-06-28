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
import com.centris.DAO.KendoReportDao;
import com.centris.VO.KendoReportVo;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.KendoSQLtableconstants;
import com.centris.util.constants.MessageConstants;

public class KendoReportDaoImpl extends DBService implements KendoReportDao {

	private static Logger logger = Logger
			.getLogger(AddDesignationDaoImpl.class);

	public ArrayList<KendoReportVo> getReportCountDetails(String todaydate) {
		ArrayList<KendoReportVo> details = new ArrayList<KendoReportVo>();

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl:insertDesignationDetails:Starting");

		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = getConnection();
			pst = connection
					.prepareStatement(KendoSQLtableconstants.GET_EMP_ATTENDENCE_DETAILS);
			pst.setString(1, todaydate);
			ResultSet rst = pst.executeQuery();

			while (rst.next()) {
				KendoReportVo vo = new KendoReportVo();
				vo.setEmpAbsent(rst.getString("AbsentCount"));
				vo.setEmpPresent(rst.getString("PresentCount"));
				vo.setEmpDep(rst.getString("DEPT_NAME"));

				details.add(vo);
			}
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

			try {

				if (pst != null && (!pst.isClosed())) {

					pst.close();
				}

				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException e) {

				logger.error(e.getMessage(), e);
			} catch (Exception e1) {

				logger.error(e1.getMessage(), e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl:insertDesignationDetails: Ending");
		return details;
	}

}
