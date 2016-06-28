package com.centris.DAO.DAOIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.ModifyEmployeeDao;
import com.centris.POJO.AddEmployeePojo;
import com.centris.VO.EmpVO;
import com.centris.VO.LocationMasterVo;
import com.centris.service.serviceImpl.ModifyEmployeeServiceImpl;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author seshuma
 * 
 */
public class ModifyEmployeeDaoImpl implements ModifyEmployeeDao {

	private static Logger logger = Logger
			.getLogger(ModifyEmployeeDaoImpl.class);

	// Get modify employee
	public synchronized ArrayList<EmpVO> getModifyEmployeeList(String empname) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: getModifyEmployeeList : Starting");
		DBService db = null;
		PreparedStatement getmodifyempstatement = null;
		ResultSet getmodifyempresultset = null;
		ArrayList<EmpVO> modifyemplist = new ArrayList<EmpVO>();
		PreparedStatement locationstatement = null;
		ResultSet locatinrs = null;

		try {
			db = new DBService();
			getmodifyempstatement = db
					.getPreparedStatement(SQLutilConstants.GET_MODIFYEMPLOYEE_DETAILS);
			getmodifyempstatement.setString(1, empname);

			getmodifyempresultset = getmodifyempstatement.executeQuery();

			while (getmodifyempresultset.next()) {

				EmpVO empVO = new EmpVO();

				empVO.setEmpname(getmodifyempresultset
						.getString(StringUtils.EMPNAME));
				empVO.setEmpid(getmodifyempresultset
						.getString(StringUtils.EMPID));
				empVO.setPhone(getmodifyempresultset
						.getString(StringUtils.PHONE));
				empVO.setEmail(getmodifyempresultset
						.getString(StringUtils.EMAIL));
				empVO.setDesignation(getmodifyempresultset
						.getString("EMPDESIGNATION"));
				empVO.setDeptid(getmodifyempresultset.getString("DEPARTMENT"));

				empVO.setShiftid(getmodifyempresultset.getString("SHIFT_ID"));
				empVO.setAddress(getmodifyempresultset.getString("EMPADDRESS"));
				empVO.setDob(HelperClass
						.convertDatabaseToUI(getmodifyempresultset
								.getString("DOB")));
				empVO.setDoj(HelperClass
						.convertDatabaseToUI(getmodifyempresultset
								.getString("DOJ")));
				empVO.setFathername(getmodifyempresultset
						.getString("FATHERNAME"));
				empVO.setEmplocation(getmodifyempresultset
						.getString("Location"));
				empVO.setLocationid(getmodifyempresultset.getString("Location"));
				empVO.setIsempreginmultilocations(getmodifyempresultset
						.getString("iSinMultiLocations"));
				empVO.setEmpregnumber(getmodifyempresultset
						.getString("EMP_REGISTRATION_NUMBER"));
				empVO.setShiftname(getmodifyempresultset
						.getString("AI_SHIFT_NAME"));

				locationstatement = db
						.getPreparedStatement(SQLutilConstants.GET_LOCATIOM_EMP_MAPPING);
				locationstatement.setString(1,
						getmodifyempresultset.getString(StringUtils.EMPID));

				locatinrs = locationstatement.executeQuery();

				HashSet<LocationMasterVo> locationlist = new HashSet<LocationMasterVo>();

				while (locatinrs.next()) {

					LocationMasterVo vo = new LocationMasterVo();

					vo.setLocationid(locatinrs.getString("LocationCode"));
					vo.setLocationname(locatinrs.getString("Location"));
					locationlist.add(vo);
				}

				JSONArray array = new JSONArray(locationlist);

				empVO.setLocationslist(locationlist);

				modifyemplist.add(empVO);

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (getmodifyempstatement !=null && (!getmodifyempstatement.isClosed())) {
					getmodifyempstatement.getConnection().close();
				}
				if (locationstatement !=null &&(!locationstatement.isClosed())) {
					locationstatement.getConnection().close();
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
				+ " Control in ModifyEmployeeDaoImpl: getModifyEmployeeList : Ending");
		return modifyemplist;
	}

	// Update employee
	public synchronized String updateEmployee(AddEmployeePojo emppojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: updateEmployee : Starting");
		DBService db = null;
		PreparedStatement updateEmployeeStatement = null;
		int count = 0;
		String status = null;
		ResultSet rs = null;
		String userid = null;

		try {
			db = new DBService();

			if (emppojo.getSelectedllocations().length > 0) {

				updateEmployeeStatement = db
						.getPreparedStatement(SQLutilConstants.DELETE_LOCATION_EMP_MAPPING);
				updateEmployeeStatement.setString(1, emppojo.getEmpid());
				updateEmployeeStatement.executeUpdate();


				if (!(emppojo.getSelectedllocations()[0].equalsIgnoreCase(""))) {

					updateEmployeeStatement = db
							.getPreparedStatement(SQLutilConstants.GET_USERID);
					updateEmployeeStatement.setString(1,
							emppojo.getCreateuser());
					rs = updateEmployeeStatement.executeQuery();
					while (rs.next()) {

						userid = rs.getString("userCode");

					}

					updateEmployeeStatement = db
							.getPreparedStatement(SQLutilConstants.EMP_LOCATION_MAPPING);

					for (int i = 0; i < emppojo.getSelectedllocations().length; i++) {

						updateEmployeeStatement
								.setString(1, emppojo.getEmpid());
						updateEmployeeStatement.setString(2,
								emppojo.getSelectedllocations()[i]);
						updateEmployeeStatement.setString(3, userid);

						updateEmployeeStatement.executeUpdate();

					}
				}

			}
			updateEmployeeStatement = db
					.getPreparedStatement(SQLutilConstants.INSERT_MODIFY_EMPLOYEE);


			updateEmployeeStatement.setString(1, emppojo.getEmpname());
			updateEmployeeStatement.setString(2, emppojo.getFathername());
			updateEmployeeStatement.setString(3, emppojo.getPhone());
			updateEmployeeStatement.setString(4, emppojo.getEmail());
			updateEmployeeStatement.setString(5, emppojo.getDob());
			updateEmployeeStatement.setString(6, emppojo.getDoj());
			updateEmployeeStatement.setString(7, emppojo.getEmpaddress());
			updateEmployeeStatement.setString(8,
					emppojo.getEmployeedesignation());
			updateEmployeeStatement.setString(9, emppojo.getDepartment());
			updateEmployeeStatement.setString(10, emppojo.getLocation());
			updateEmployeeStatement.setString(11, emppojo.getShift());
			updateEmployeeStatement.setString(12, emppojo.getCreateuser());
			updateEmployeeStatement.setTimestamp(13, emppojo.getCreatedate());
			updateEmployeeStatement.setString(14,
					emppojo.getIsemployeereginmultilocations());
			updateEmployeeStatement.setString(15, emppojo.getEmpregnumber());
			updateEmployeeStatement.setString(16, emppojo.getEmpid());

			count = updateEmployeeStatement.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (updateEmployeeStatement !=null &&(!updateEmployeeStatement.isClosed())) {
					updateEmployeeStatement.getConnection().close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}

		if (count > 0) {

			status = MessageConstants.EMPLOYEE_UPDATE_SUCCESS;

		} else {

			status = MessageConstants.EMPLOYEE_UPDATE_FAIL;

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: updateEmployee : Ending");
		return status;
	}

	// validate email id
	public synchronized boolean checkEmail(String email, String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: checkEmail : Starting");
		DBService db = null;
		PreparedStatement checkupdatemaiid = null;
		ResultSet checkemialresultset = null;
		boolean status = false;
		int count = 0;

		try {
			db = new DBService();
			checkupdatemaiid = db
					.getPreparedStatement(SQLutilConstants.UPDATE_EMAILCOUNT);

			checkupdatemaiid.setString(1, email);
			checkupdatemaiid.setString(2, empid);

			checkemialresultset = checkupdatemaiid.executeQuery();

			while (checkemialresultset.next()) {

				count = checkemialresultset.getInt(1);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (checkupdatemaiid !=null &&(!checkupdatemaiid.isClosed())) {
					checkupdatemaiid.getConnection().close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}

		if (count > 0) {

			status = true;

		} else {

			status = false;

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: checkEmail : Ending");
		return status;
	}

	// validate checkEmpregNo
	public synchronized boolean checkEmpregNo(String empregno, String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: checkEmpregNo : Starting");
		DBService db = null;
		PreparedStatement checkupdatemaiid = null;
		ResultSet checkemialresultset = null;
		boolean status = false;
		int count = 0;

		try {

			db = new DBService();
			checkupdatemaiid = db
					.getPreparedStatement(SQLutilConstants.UPDATE_EMPREGCOUNT);

			checkupdatemaiid.setString(1, empregno);
			checkupdatemaiid.setString(2, empid);

			checkemialresultset = checkupdatemaiid.executeQuery();

			while (checkemialresultset.next()) {

				count = checkemialresultset.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e);
		} finally {

			try {

				if (checkupdatemaiid !=null &&(!checkupdatemaiid.isClosed())) {
					checkupdatemaiid.getConnection().close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e);
			}
			;
		}

		if (count > 0) {

			status = true;

		} else {

			status = false;

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: checkEmpregNo : Ending");
		return status;
	}

	// Modify employee from all employees

	public synchronized List<EmpVO> getModifyEmpDetailsForAllEmp(String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: getModifyEmpDetailsForAllEmp : Starting");
		List<EmpVO> empVOlist = null;
		PreparedStatement empstatement = null;
		ResultSet rs_candidateDetails = null;
		PreparedStatement locationstatement = null;
		ResultSet locatinrs = null;
		DBService db = null;

		try {
			db = new DBService();
			empstatement = db
					.getPreparedStatement(SQLutilConstants.GET_MODIFYEMPFOR_ALLEMP);

			empstatement.setString(1, empid);
			rs_candidateDetails = empstatement.executeQuery();

			empVOlist = new ArrayList<EmpVO>();
			while (rs_candidateDetails.next()) {

				EmpVO empVO = new EmpVO();

				empVO.setEmpname(rs_candidateDetails
						.getString(StringUtils.EMPNAME));
				empVO.setEmpid(rs_candidateDetails.getString(StringUtils.EMPID));
				empVO.setPhone(rs_candidateDetails.getString(StringUtils.PHONE));
				empVO.setEmail(rs_candidateDetails.getString(StringUtils.EMAIL));
				empVO.setDesignation(rs_candidateDetails
						.getString("designationName"));
				empVO.setDesid(rs_candidateDetails.getString("designationId"));
				empVO.setDeptid(rs_candidateDetails.getString("DEPT_ID"));
				empVO.setDeptname(rs_candidateDetails.getString("DEPT_NAME"));
				empVO.setShiftname(rs_candidateDetails
						.getString("AI_SHIFT_NAME"));
				empVO.setShiftid(rs_candidateDetails.getString("AI_SHIFT_ID"));
				empVO.setAddress(rs_candidateDetails.getString("EMPADDRESS"));
				empVO.setDob(HelperClass
						.convertDatabaseToUI(rs_candidateDetails
								.getString("DOB")));
				empVO.setDoj(HelperClass
						.convertDatabaseToUI(rs_candidateDetails
								.getString("DOJ")));
				empVO.setFathername(rs_candidateDetails.getString("FATHERNAME"));
				empVO.setEmplocation(rs_candidateDetails.getString("Location"));
				empVO.setLocationid(rs_candidateDetails
						.getString("LocationCode"));
				empVO.setIsempreginmultilocations(rs_candidateDetails
						.getString("iSinMultiLocations"));
				empVO.setEmpregnumber(rs_candidateDetails
						.getString("EMP_REGISTRATION_NUMBER"));

				locationstatement = db
						.getPreparedStatement(SQLutilConstants.GET_MODIFYEMPFOR_ALLEMP);
				if (rs_candidateDetails.getString("iSinMultiLocations")
						.equalsIgnoreCase("Y")) {
					db.closeAll(locationstatement, null);
					locationstatement = db
							.getPreparedStatement(SQLutilConstants.GET_LOCATIOM_EMP_MAPPING);
					locationstatement.setString(1, empid);

					locatinrs = locationstatement.executeQuery();

					HashSet<LocationMasterVo> locationlist = new HashSet<LocationMasterVo>();
					LocationMasterVo vo = null;
					while (locatinrs.next()) {

						vo = new LocationMasterVo();

						vo.setLocationid(locatinrs.getString("LocationCode"));
						vo.setLocationname(locatinrs.getString("Location"));
						locationlist.add(vo);
					}
					db.closeAll(locationstatement, locatinrs);
					JSONArray array = new JSONArray(locationlist);

					empVO.setLocationslist(locationlist);

				}

				empVOlist.add(empVO);

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (empstatement !=null &&(!empstatement.isClosed())) {
					empstatement.getConnection().close();
				}
				if (locationstatement !=null && (!locationstatement.isClosed())) {
					locationstatement.getConnection().close();
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
				+ " Control in ModifyEmployeeDaoImpl: getModifyEmpDetailsForAllEmp : Ending");

		return empVOlist;
	}

	public synchronized ArrayList<EmpVO> getSearchEmployees(String searchname,
			int maxlimit, String groupid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeDaoImpl: getSearchEmployees : Starting");
		ArrayList<EmpVO> empVOlist = null;
		PreparedStatement empstatement = null;
		ResultSet rs_candidateDetails = null;
		DBService db = null;

		try {
			db = new DBService();
			empstatement = db
					.getPreparedStatement(SQLutilConstants.GET_MODIFY_EMPLOYEE);

			empstatement.setString(1, "%" + searchname + "%");
			empstatement.setString(2, groupid);
			empstatement.setInt(3, maxlimit);

			rs_candidateDetails = empstatement.executeQuery();

			empVOlist = new ArrayList<EmpVO>();
			while (rs_candidateDetails.next()) {

				EmpVO empVO = new EmpVO();

				empVO.setEmpname(rs_candidateDetails
						.getString(StringUtils.EMPNAME));
				empVO.setEmpid(rs_candidateDetails.getString(StringUtils.EMPID));

				empVOlist.add(empVO);

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (empstatement !=null && (!empstatement.isClosed())) {
					empstatement.getConnection().close();
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
				+ " Control in ModifyEmployeeDaoImpl: getSearchEmployees : Ending");

		return empVOlist;
	}

}
