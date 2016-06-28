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

import com.centris.DAO.DBService;
import com.centris.DAO.WeekOffSettingDao;
import com.centris.VO.EmployVO;
import com.centris.VO.WeekOffSettingVo;
import com.centris.form.EmployeeForm;
import com.centris.form.WeekoffSettingForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.WeekOffSettings;
import com.centris.util.constants.MessageConstants;

/**
 * @author satish
 *
 */
public class WeekOffSettingDaoImpl extends DBService implements WeekOffSettingDao {
	private static Logger logger = Logger
			.getLogger(UploadDailyAllowanceByManagerDAOImpl.class);
	@Override
	public List<WeekOffSettingVo> getWeekofDetailsByEmployeeId(String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getEmpIdNameBySerachTerm Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		
		List<WeekOffSettingVo> weekOffSettingVos = new ArrayList<WeekOffSettingVo>();
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(WeekOffSettings.GET_WEEKOFFSETTING_BY_EMPID);
			pstmt.setString(1,empId);
		
			rs = pstmt.executeQuery();

		
			
			while (rs.next()) {
				
				WeekOffSettingVo weekOffSettingVo=new WeekOffSettingVo();
				weekOffSettingVo.setSunday(rs.getBoolean("SUNDAY"));
				weekOffSettingVo.setMonday(rs.getBoolean("MONDAY"));
				weekOffSettingVo.setTuesday(rs.getBoolean("TUESDAY"));
				weekOffSettingVo.setWednesday(rs.getBoolean("WEDNESDAY"));
				weekOffSettingVo.setThrusday(rs.getBoolean("THURSDAY"));
				weekOffSettingVo.setFriday(rs.getBoolean("FRIDAY"));
				weekOffSettingVo.setSaturday(rs.getBoolean("SATURDAY"));
				weekOffSettingVo.setEmpCode(rs.getString("EMPID"));
				weekOffSettingVo.setClientcode(rs.getString("CLIENTCODE"));
				weekOffSettingVo.setClientname(rs.getString("ClientName"));
			
				weekOffSettingVos.add(weekOffSettingVo);
			}
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getEmpIdNameBySerachTerm Ending");

		
	

		
		// TODO Auto-generated method stub
	return weekOffSettingVos;
	}
	public String updateWeekOffDetails(EmployeeForm employeeForm,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: updateWeekOffDetails Starting");

		PreparedStatement pstmt = null;
		String empStatus = "NOT_SAVED";
		try {

			pstmt = connection
					.prepareStatement(Employee.UPDATE_WEEKOFF_DETAILS);

			pstmt.setString(1, HelperClass.getCurrentYear());
			pstmt.setBoolean(2, employeeForm.isSunday());
			pstmt.setBoolean(3, employeeForm.isMonday());
			pstmt.setBoolean(4, employeeForm.isTuesday());
			pstmt.setBoolean(5, employeeForm.isWednesday());
			pstmt.setBoolean(6, employeeForm.isThrusday());
			pstmt.setBoolean(7, employeeForm.isFriday());
			pstmt.setBoolean(8, employeeForm.isSaturday());
			pstmt.setTimestamp(9, HelperClass.getCurrentTimestamp());
			pstmt.setString(10, employeeForm.getUserCode());
			pstmt.setString(11, employeeForm.getUserCode());
			pstmt.setTimestamp(12, HelperClass.getCurrentTimestamp());
			pstmt.setString(13, employeeForm.getEmpCode());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				empStatus = "SAVED";
			} else {
				empStatus = "NOT_SAVED";
			}
			employeeForm.setSunday(false);
			employeeForm.setMonday(false);
			employeeForm.setTuesday(false);
			employeeForm.setWednesday(false);
			employeeForm.setThrusday(false);
			employeeForm.setFriday(false);
			employeeForm.setSaturday(false);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: updateWeekOffDetails Ending");
		return empStatus;
	}
	
	public String insertWeekOffDetails(WeekoffSettingForm weekoffSettingForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: insertWeekOffDetails Starting");
		PreparedStatement pstmt = null;
		Connection connection=null;
		String empStatus = "NOT_SAVED";
		try {
connection=getConnection();
int count=0;
pstmt=connection.prepareStatement(WeekOffSettings.GET__EMP_COUNT);
pstmt.setString(1,weekoffSettingForm.getEmpCode());
ResultSet resultSet=pstmt.executeQuery();
while(resultSet.next()){
	count=resultSet.getInt(1);
}

if(count>0){

	pstmt = connection
			.prepareStatement(Employee.UPDATE_WEEKOFF_DETAILS);

	pstmt.setString(1, HelperClass.getCurrentYear());
	pstmt.setBoolean(2, weekoffSettingForm.isSunday());
	pstmt.setBoolean(3, weekoffSettingForm.isMonday());
	pstmt.setBoolean(4, weekoffSettingForm.isTuesday());
	pstmt.setBoolean(5, weekoffSettingForm.isWednesday());
	pstmt.setBoolean(6, weekoffSettingForm.isThrusday());
	pstmt.setBoolean(7, weekoffSettingForm.isFriday());
	pstmt.setBoolean(8, weekoffSettingForm.isSaturday());
	pstmt.setString(9, weekoffSettingForm.getMappedcalencode());
	pstmt.setTimestamp(10, HelperClass.getCurrentTimestamp());
	pstmt.setString(11, weekoffSettingForm.getUserCode());
	pstmt.setString(12, weekoffSettingForm.getUserCode());
	pstmt.setTimestamp(13, HelperClass.getCurrentTimestamp());
	pstmt.setString(14, weekoffSettingForm.getEmpCode());

	int i = pstmt.executeUpdate();
	
	if (i > 0) {
		empStatus = "WeefOff Settings Updated Successfully";
	} else {
		empStatus = "WeefOff Settings Not Updated";
	}
	weekoffSettingForm.setSunday(false);
	weekoffSettingForm.setMonday(false);
	weekoffSettingForm.setTuesday(false);
	weekoffSettingForm.setWednesday(false);
	weekoffSettingForm.setThrusday(false);
	weekoffSettingForm.setFriday(false);
	weekoffSettingForm.setSaturday(false);



			
}
else
{
	pstmt = connection.prepareStatement(Employee.INSERT_WEEKOFF_DETAILS);
	pstmt.setString(1, weekoffSettingForm.getEmpCode());
	pstmt.setString(2, HelperClass.getCurrentYear());
	pstmt.setBoolean(3, weekoffSettingForm.isSunday());
	pstmt.setBoolean(4, weekoffSettingForm.isMonday());
	pstmt.setBoolean(5, weekoffSettingForm.isTuesday());
	pstmt.setBoolean(6, weekoffSettingForm.isWednesday());
	pstmt.setBoolean(7, weekoffSettingForm.isThrusday());
	pstmt.setBoolean(8, weekoffSettingForm.isFriday());
	pstmt.setBoolean(9, weekoffSettingForm.isSaturday());
	pstmt.setString(10, weekoffSettingForm.getMappedcalencode());
	pstmt.setTimestamp(11, HelperClass.getCurrentTimestamp());
	pstmt.setString(12,weekoffSettingForm.getUserCode());
	pstmt.setString(13,weekoffSettingForm.getUserCode());
	pstmt.setTimestamp(14, HelperClass.getCurrentTimestamp());

	int i = pstmt.executeUpdate();

	if (i > 0) {
		empStatus = "WeefOff Settings Saved Successfully";
	} else {
		empStatus = "WeefOff Settings Not Saved,Please try again";
	}
	weekoffSettingForm.setSunday(false);
	weekoffSettingForm.setMonday(false);
	weekoffSettingForm.setTuesday(false);
	weekoffSettingForm.setWednesday(false);
	weekoffSettingForm.setThrusday(false);
	weekoffSettingForm.setFriday(false);
	weekoffSettingForm.setSaturday(false);
}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: insertWeekOffDetails Ending");
		return empStatus;
	}

}
