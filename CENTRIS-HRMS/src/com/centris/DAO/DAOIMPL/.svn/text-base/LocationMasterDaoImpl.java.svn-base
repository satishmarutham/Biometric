package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.LocationMasterDao;
import com.centris.POJO.LocationMasterPojo;
import com.centris.VO.LocationMasterVo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class LocationMasterDaoImpl extends DBService implements
		LocationMasterDao {

	private static Logger logger = Logger
			.getLogger(LocationMasterDaoImpl.class);

	public synchronized String storelocation(LocationMasterPojo lpojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: storelocation : Starting");
		PreparedStatement locationStatement = null;
		ResultSet locationrs = null;
		Connection connection = null;
		int no = 0;
		String status = null;

		try {
			connection = getConnection();
			if ((new LocationMasterDaoImpl().validateLocationName(lpojo
					.getLocationname()) == 0)) {

				locationStatement = connection
						.prepareStatement(SQLutilConstants.INSERT_LOCATION);
				locationStatement.setString(1, lpojo.getLocationid());
				locationStatement.setString(2, lpojo.getLocationname());
				locationStatement.setString(3, lpojo.getLocationnomber());
				locationStatement.setString(4, lpojo.getPropriteraddresss());
				locationStatement.setString(5, lpojo.getMobilenumber());
				locationStatement.setString(6, lpojo.getPropritername());
				locationStatement.setString(7, lpojo.getMachinenumber());
				locationStatement.setString(8, lpojo.getCompanyname());
				locationStatement.setString(9, lpojo.getCreateuser());
				locationStatement.setTimestamp(10, lpojo.getCreatedate());
				locationStatement.setString(11, "Y");
				locationStatement.setString(12, lpojo.getTsmname());
				locationStatement.setString(13, lpojo.getContactnumber());
				locationStatement.setString(14, lpojo.getEmployeestrength());
				locationStatement.setString(15, lpojo.getBioidindexnumber());
				locationStatement.setString(16, lpojo.getDsecount());

				no = locationStatement.executeUpdate();

				if (no > 0) {

					status = MessageConstants.LOCATION_ADD_SUCCESS;
				} else {

					status = MessageConstants.LOCATION_ADD_FAIL;
				}

			}
			/* } */

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationrs != null && (!locationrs.isClosed())) {

					locationrs.close();
				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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

		return status;

	}

	public synchronized ArrayList<LocationMasterVo> getLocation(String groupcode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getLocation : Starting");

		PreparedStatement locationStatement = null;
		PreparedStatement locationStatement1 = null;
		ResultSet locationrs = null;
		Connection con = null;

		ResourceBundle res = ResourceBundle
				.getBundle("com/centris/properties/IDEA");
		String desigId = res.getString("DesignationId").trim();

		ArrayList<LocationMasterVo> locationList = new ArrayList<LocationMasterVo>();

		try {
			con = getConnection();

			locationStatement = con
					.prepareStatement(SQLutilConstants.SELECT_LOCATION);
			locationStatement.setString(1, groupcode);

			ResultSet locationResultset = null;
			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				LocationMasterVo vo = new LocationMasterVo();

				vo.setLocationid(locationResultset.getString("LocationCode"));
				vo.setLocationname(locationResultset.getString("Location"));
				vo.setLocationnomber(locationResultset
						.getString("LocationNumber"));
				vo.setPropriteraddresss(locationResultset
						.getString("PropriterAddress"));
				vo.setMobilenumber(locationResultset.getString("PhoneNo"));
				vo.setPropritername(locationResultset
						.getString("PropriterName"));
				vo.setMachinenumber(locationResultset
						.getString("BioMachineNumber"));
				vo.setCompanyname(locationResultset.getString("ContactPerson"));
				vo.setAsmname(locationResultset.getString("TSM_TSE_Name"));
				vo.setContactnumber(locationResultset
						.getString("ContactNumber"));
				vo.setEmployeestrength(locationResultset
						.getString("EmployeeStrength"));
				vo.setBioindexnumber(locationResultset
						.getString("Bio_Id_Index_Number"));

				locationStatement1 = con
						.prepareStatement(SQLutilConstants.LOCATION_EMPLOYEES_COUNT);
				locationStatement1.setString(1, desigId.trim());
				locationStatement1.setString(2,
						locationResultset.getString("LocationCode"));

				locationrs = locationStatement1.executeQuery();

				while (locationrs.next()) {
					vo.setNoofemployees(locationrs.getInt(1));
					vo.setDsecount(String.valueOf(locationrs.getInt(2)));
				}
				locationList.add(vo);
			}
			// locationStatement1.close();
			// locationStatement.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationrs != null && (!locationrs.isClosed())) {

					locationrs.close();
				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
				}
				if (locationStatement1 != null
						&& (!locationStatement1.isClosed())) {

					locationStatement1.close();
				}
				if (con != null && (!con.isClosed())) {

					con.close();
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
				+ " Control in LocationMasterAction: getLocation : Ending");

		return locationList;

	}

	public synchronized ArrayList<LocationMasterVo> getSingleLocation(
			String locId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getSingleLocation : Starting");
		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		ArrayList<LocationMasterVo> locationList = new ArrayList<LocationMasterVo>();
		Connection connection = null;

		try {
			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.SELECT_SINGLE_LOCATION);
			locationStatement.setString(1, locId);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				LocationMasterVo vo = new LocationMasterVo();

				vo.setLocationid(locationResultset.getString("LocationCode"));
				vo.setLocationname(locationResultset.getString("Location"));
				vo.setLocationnomber(locationResultset
						.getString("LocationNumber"));
				vo.setPropriteraddresss(locationResultset
						.getString("PropriterAddress"));
				vo.setMobilenumber(locationResultset.getString("PhoneNo"));
				vo.setPropritername(locationResultset
						.getString("PropriterName"));
				vo.setMachinenumber(locationResultset
						.getString("BioMachineNumber"));
				vo.setCompanyname(locationResultset.getString("ContactPerson"));
				vo.setAsmname(locationResultset.getString("TSM_TSE_Name"));
				vo.setContactnumber(locationResultset
						.getString("ContactNumber"));
				vo.setEmployeestrength(locationResultset
						.getString("EmployeeStrength"));
				vo.setBioindexnumber(locationResultset
						.getString("Bio_Id_Index_Number"));
				vo.setDsecount(locationResultset.getString("DSE_S_Count"));
				locationList.add(vo);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();
				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: getSingleLocation : Ending");

		return locationList;

	}

	public synchronized String updateLocation(LocationMasterPojo lpojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: updateLocation : Starting");
		PreparedStatement locationStatement = null;
		Connection connection = null;
		int no = 0;
		String status = null;

		try {

			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.UPDATE_LOCATION);

			locationStatement.setString(1, lpojo.getLocationname());
			locationStatement.setString(2, lpojo.getLocationnomber());
			locationStatement.setString(3, lpojo.getPropriteraddresss());
			locationStatement.setString(4, lpojo.getMobilenumber());
			locationStatement.setString(5, lpojo.getPropritername());
			locationStatement.setString(6, lpojo.getMachinenumber());
			locationStatement.setString(7, lpojo.getCompanyname());
			locationStatement.setString(8, lpojo.getTsmname());
			locationStatement.setString(9, lpojo.getContactnumber());
			locationStatement.setString(10, lpojo.getEmployeestrength());
			locationStatement.setString(11, lpojo.getBioidindexnumber());
			locationStatement.setString(12, lpojo.getDsecount());
			locationStatement.setString(13, lpojo.getCreateuser());
			locationStatement.setTimestamp(14, lpojo.getCreatedate());
			locationStatement.setString(15, lpojo.getLocationid());

			no = locationStatement.executeUpdate();

			if (no > 0) {

				status = MessageConstants.LOCATION_UPDATE_SUCCESS;
			} else {

				status = MessageConstants.LOCATION_UPDATE_FAIL;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: updateLocation : Ending");

		return status;

	}

	public synchronized String deleteLocation(String[] locid,String currentuser) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deleteLocation : Starting");

		PreparedStatement locationStatement = null;
		PreparedStatement ps_employeecheck = null;
		PreparedStatement ps_shiftcheck = null;
		PreparedStatement ps_deptcheck = null;
		PreparedStatement ps_location_group = null;
		PreparedStatement ps_user = null;
		ResultSet rs_emp = null;
		ResultSet rs_shift = null;
		ResultSet rs_dept = null;
		ResultSet rs_loc_group = null;
		ResultSet rs_user = null;
		Connection connection = null;

		int no = 0;
		String status = null;

		try {
			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.DELETE_LOCATION);
			ps_employeecheck = connection
					.prepareStatement(SQLutilConstants.CHECK_LOCATION_FOR_EMP);

			for (int i = 0; i < locid.length; i++) {

				ps_employeecheck.setString(1, locid[i]);
				rs_emp = ps_employeecheck.executeQuery();

				while (rs_emp.next()) {

					no = rs_emp.getInt(1);

					if (no > 0) {

						status = "You can not delete location aleredy mapped with employee";

					} else {

						ps_shiftcheck = connection
								.prepareStatement(SQLutilConstants.CHECK_LOCATION_FOR_SHIFT);
						ps_shiftcheck.setString(1, locid[i]);
						rs_shift = ps_shiftcheck.executeQuery();

						while (rs_shift.next()) {

							no = rs_shift.getInt(1);

							if (no > 0) {

								status = "You can not delete location aleredy mapped with shift";

							} else {

								ps_deptcheck = connection
										.prepareStatement(SQLutilConstants.CHECK_LOCATION_FOR_DEPT);
								ps_deptcheck.setString(1, locid[i]);
								rs_dept = ps_deptcheck.executeQuery();

								while (rs_dept.next()) {

									no = rs_dept.getInt(1);

									if (no > 0) {

										status = "You can not delete location aleredy mapped with department";

									} else {

										ps_location_group = connection
												.prepareStatement(SQLutilConstants.CHECK_LOCATION_FOR_GROUPMAPPING);
										ps_location_group
												.setString(1, locid[i]);
										rs_loc_group = ps_location_group
												.executeQuery();

										while (rs_loc_group.next()) {

											no = rs_loc_group.getInt(1);

											if (no > 0) {

												status = "You can not delete location aleredy mapped with group";

											} else {

												ps_user = connection
														.prepareStatement(SQLutilConstants.CHECK_LOCATION_FOR_USER);
												ps_user.setString(1, locid[i]);
												rs_user = ps_user
														.executeQuery();

												while (rs_user.next()) {

													no = rs_user.getInt(1);

													if (no > 0) {

														status = "You can not delete location aleredy mapped with user";

													} else {

														locationStatement.setString(1,currentuser);
														locationStatement.setTimestamp(2,HelperClass.getCurrentTimestamp());
														locationStatement.setString(3,locid[i]);

														no = locationStatement
																.executeUpdate();

														if (no > 0) {

															status = MessageConstants.LOCATION_DELETE_SUCCESS;
														} else {

															status = MessageConstants.LOCATION_DELETE_FAIL;
														}
													}
												}

											}
										}

									}
								}
							}
						}

					}

				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (rs_user != null && (!rs_user.isClosed())) {

					rs_user.close();
				}
				if (rs_loc_group != null && (!rs_loc_group.isClosed())) {

					rs_loc_group.close();
				}
				if (rs_dept != null && (!rs_dept.isClosed())) {

					rs_dept.close();
				}
				if (rs_shift != null && (!rs_shift.isClosed())) {

					rs_shift.close();
				}
				if (rs_emp != null && (!rs_emp.isClosed())) {

					rs_emp.close();
				}
				if (ps_user != null && (!ps_user.isClosed())) {

					ps_user.close();
				}
				if (ps_location_group != null
						&& (!ps_location_group.isClosed())) {

					ps_location_group.close();
				}
				if (ps_deptcheck != null && (!ps_deptcheck.isClosed())) {

					ps_deptcheck.close();
				}
				if (ps_shiftcheck != null && (!ps_shiftcheck.isClosed())) {

					ps_shiftcheck.close();
				}
				if (ps_employeecheck != null && (!ps_employeecheck.isClosed())) {

					ps_employeecheck.close();
				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: deleteLocation : Ending");

		return status;

	}

	public synchronized int validateLocationName(String locationname) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationName : Starting");
		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		int no = 0;
		Connection connection = null;

		try {

			connection = getConnection();

			locationStatement = connection
					.prepareStatement(SQLutilConstants.VALIDATE_LOCATIONNAME);

			locationStatement.setString(1, locationname);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt("locationname");

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateLocationName : Ending");

		return no;

	}

	public synchronized int validateLocationNameUpdate(String locationname,
			String locationid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationNameUpdate : Starting");

		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		int no = 0;
		Connection connection = null;

		try {
			connection = getConnection();

			locationStatement = connection
					.prepareStatement(SQLutilConstants.VALIDATE_LOCATIONNAME_UPDATE);

			locationStatement.setString(1, locationname);
			locationStatement.setString(2, locationid);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt("locationname");

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateLocationNameUpdate : Ending");

		return no;

	}

	public synchronized boolean validateLocationID(String locationID) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationID : Starting");

		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		int no = 0;
		Connection connection = null;

		boolean status = false;

		try {
			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.VALIDATE_LOCATIONID);

			locationStatement.setString(1, locationID);
			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt("locaid");

			}

			if (no > 0) {

				status = true;
			} else {

				status = false;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateLocationID : Ending");

		return status;

	}

	public synchronized List<LocationMasterVo> getLocationByGroup(String group) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getLocationByGroup : Starting");

		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		List<LocationMasterVo> locationList = new ArrayList<LocationMasterVo>();
		Connection connection = null;
		LocationMasterVo locationMasterVo = null;
		try {
			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.GET_LOCATION_BY_GROUP);
			locationStatement.setString(1, group);
			locationResultset = locationStatement.executeQuery();
			while (locationResultset.next()) {
				locationMasterVo = new LocationMasterVo();
				locationMasterVo.setLocationid(locationResultset
						.getString("LocationCode"));
				locationMasterVo.setLocationname(locationResultset
						.getString("Location"));
				locationList.add(locationMasterVo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: getLocationByGroup : Ending");

		return locationList;
	}

	public synchronized int validateLocationNumber(String locationnumber) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationNumber : Starting");
		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		Connection connection = null;
		int no = 0;

		try {

			connection = getConnection();

			locationStatement = connection
					.prepareStatement(SQLutilConstants.VALIDATE_LOCATIONNUMBER);

			locationStatement.setString(1, locationnumber);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt("locationnumber");

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateLocationNumber : Ending");

		return no;

	}

	public synchronized int validateLocationNumberUpdate(String locationnumber,
			String locationid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationNumberUpdate : Starting");

		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		Connection connection = null;
		int no = 0;

		try {

			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.VALIDATE_LOCATIONNUMBER_UPDATE);

			locationStatement.setString(1, locationnumber);
			locationStatement.setString(2, locationid);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt("locationnumber");

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateLocationNumberUpdate : Ending");

		return no;

	}

	public synchronized int validateMachineNumber(String machinenumber) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Starting");

		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		int no = 0;
		Connection connection = null;

		try {
			connection = getConnection();

			locationStatement = connection
					.prepareStatement(SQLutilConstants.VALIDATE_MACHINENUMBER);

			locationStatement.setString(1, machinenumber);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt("machinenumber");

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateMachineNumber : Ending");

		return no;

	}

	public synchronized int validateMachineNumberUpdate(String machinenumber,
			String locationid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumberUpdate : Starting");

		int no = 0;
		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		Connection connection = null;
		try {
			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.VALIDATE_MACHINENUMBER_UPDATE);

			locationStatement.setString(1, machinenumber);
			locationStatement.setString(2, locationid);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt("machinenumber");

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateMachineNumberUpdate : Ending");

		return no;

	}

	public synchronized int validateBioIdIndex(String bioidindex) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateBioIdIndex : Starting");

		int no = 0;
		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		Connection connection = null;

		try {

			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.CHECK_BIOIDINDEX);

			locationStatement.setString(1, bioidindex);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt(1);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateBioIdIndex : Ending");

		return no;

	}

	public synchronized int validateBioIdIndexUpdate(String bioidindex,
			String locationid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateBioIdIndexUpdate : Starting");

		int no = 0;
		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		Connection connection = null;

		try {
			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.CHECK_BIOIDINDEX_UPDATE);

			locationStatement.setString(1, bioidindex);
			locationStatement.setString(2, locationid);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				no = locationResultset.getInt(1);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: validateBioIdIndexUpdate : Ending");

		return no;

	}

	public synchronized ArrayList<LocationMasterVo> getDeactivelocations() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getDeactivelocations : Starting");

		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		Connection connection = null;
		ArrayList<LocationMasterVo> locationList = new ArrayList<LocationMasterVo>();

		try {

			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.SELECT_DEACTIVE_LOCATION);
			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				LocationMasterVo vo = new LocationMasterVo();

				vo.setLocationid(locationResultset.getString("LocationCode"));
				vo.setLocationname(locationResultset.getString("Location"));
				vo.setLocationnomber(locationResultset
						.getString("LocationNumber"));
				vo.setPropriteraddresss(locationResultset
						.getString("PropriterAddress"));
				vo.setMobilenumber(locationResultset.getString("PhoneNo"));
				vo.setPropritername(locationResultset
						.getString("PropriterName"));
				vo.setMachinenumber(locationResultset
						.getString("BioMachineNumber"));
				vo.setCompanyname(locationResultset.getString("ContactPerson"));
				vo.setAsmname(locationResultset.getString("TSM_TSE_Name"));
				vo.setContactnumber(locationResultset
						.getString("ContactNumber"));
				vo.setEmployeestrength(locationResultset
						.getString("EmployeeStrength"));
				vo.setBioindexnumber(locationResultset
						.getString("Bio_Id_Index_Number"));

				locationList.add(vo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();

				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: getDeactivelocations : Ending");

		return locationList;

	}

	public synchronized String activatelocation(String locationname,String currentuser) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: activatelocation : Starting");
		PreparedStatement locationStatement = null;
		String status = null;
		int no = 0;
		Connection connection = null;

		try {
			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.ACTIVATE_LOCATION);
			locationStatement.setString(1, currentuser);
			locationStatement.setTimestamp(2, HelperClass.getCurrentTimestamp());
			locationStatement.setString(3, locationname);
			no = locationStatement.executeUpdate();

			if (no > 0) {

				status = "Location activated successfully";
			} else {

				status = "Location not activated successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {

				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
				}
				if (connection != null && (!connection.isClosed())) {

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
				+ " Control in LocationMasterAction: activatelocation : Ending");
		return status;
	}

	public synchronized ArrayList<LocationMasterVo> getALLLocation() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getALLLocation : Starting");

		PreparedStatement locationStatement = null;
		ResultSet locationResultset = null;
		Connection connection = null;
		ArrayList<LocationMasterVo> locationList = new ArrayList<LocationMasterVo>();

		try {

			connection = getConnection();
			locationStatement = connection
					.prepareStatement("select LocationCode,Location,LocationNumber,PropriterAddress,PhoneNo,PropriterName,BioMachineNumber,ContactPerson,TSM_TSE_Name,ContactNumber,EmployeeStrength,Bio_Id_Index_Number,DSE_S_Count from ai_emp_location where isActive='Y' order by Location");

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				LocationMasterVo vo = new LocationMasterVo();

				vo.setLocationid(locationResultset.getString("LocationCode"));
				vo.setLocationname(locationResultset.getString("Location"));
				vo.setLocationnomber(locationResultset
						.getString("LocationNumber"));
				vo.setPropriteraddresss(locationResultset
						.getString("PropriterAddress"));
				vo.setMobilenumber(locationResultset.getString("PhoneNo"));
				vo.setPropritername(locationResultset
						.getString("PropriterName"));
				vo.setMachinenumber(locationResultset
						.getString("BioMachineNumber"));
				vo.setCompanyname(locationResultset.getString("ContactPerson"));
				vo.setAsmname(locationResultset.getString("TSM_TSE_Name"));
				vo.setContactnumber(locationResultset
						.getString("ContactNumber"));
				vo.setEmployeestrength(locationResultset
						.getString("EmployeeStrength"));
				vo.setBioindexnumber(locationResultset
						.getString("Bio_Id_Index_Number"));
				vo.setDsecount(locationResultset.getString("DSE_S_Count"));

				locationList.add(vo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();
				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: getALLLocation : Ending");

		return locationList;

	}

	public synchronized ArrayList<LocationMasterVo> getSearchLocations(
			String groupcode, String searchLocation) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getSearchLocations : Starting");

		PreparedStatement locationStatement = null;
		PreparedStatement locationempstatement = null;
		ResultSet locationResultset = null;
		ResultSet locationrs = null;
		ArrayList<LocationMasterVo> locationList = new ArrayList<LocationMasterVo>();
		Connection connection = null;

		try {
			connection = getConnection();
			locationStatement = connection
					.prepareStatement(SQLutilConstants.SELECT_LOCATIONS_BY_SEARCH_LOCATION);
			locationStatement.setString(1, "%" + searchLocation + "%");
			locationStatement.setString(2, groupcode);

			locationResultset = locationStatement.executeQuery();

			while (locationResultset.next()) {

				LocationMasterVo vo = new LocationMasterVo();

				vo.setLocationid(locationResultset.getString("LocationCode"));
				vo.setLocationname(locationResultset.getString("Location"));
				vo.setLocationnomber(locationResultset
						.getString("LocationNumber"));
				vo.setPropriteraddresss(locationResultset
						.getString("PropriterAddress"));
				vo.setMobilenumber(locationResultset.getString("PhoneNo"));
				vo.setPropritername(locationResultset
						.getString("PropriterName"));
				vo.setMachinenumber(locationResultset
						.getString("BioMachineNumber"));
				vo.setCompanyname(locationResultset.getString("ContactPerson"));
				vo.setAsmname(locationResultset.getString("TSM_TSE_Name"));
				vo.setContactnumber(locationResultset
						.getString("ContactNumber"));
				vo.setEmployeestrength(locationResultset
						.getString("EmployeeStrength"));
				vo.setBioindexnumber(locationResultset
						.getString("Bio_Id_Index_Number"));

				locationempstatement = connection
						.prepareStatement(SQLutilConstants.EMPLOYEES_COUNT);
				locationempstatement.setString(1,
						locationResultset.getString("LocationCode"));
				locationrs = locationempstatement.executeQuery();

				while (locationrs.next()) {
					vo.setNoofemployees(locationrs.getInt(1));

				}

				locationList.add(vo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (locationrs != null && (!locationrs.isClosed())) {

					locationrs.close();
				}
				if (locationResultset != null
						&& (!locationResultset.isClosed())) {

					locationResultset.close();
				}
				if (locationempstatement != null
						&& (!locationempstatement.isClosed())) {

					locationempstatement.close();
				}
				if (locationStatement != null
						&& (!locationStatement.isClosed())) {

					locationStatement.close();
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
				+ " Control in LocationMasterAction: getSearchLocations : Ending");

		return locationList;

	}
	
	
	
	

}
