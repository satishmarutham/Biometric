package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.POJO.EmployeeSalaryDetailsPojo;
import com.centris.VO.SalaryDetailsVo;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class EmployeeSalaryDetailsDaoImpl extends DBService {

	private static Logger logger = Logger.getLogger(ProjectMasterDaoImpl.class);

	public String storeEmployeeSalaryDetails(
			EmployeeSalaryDetailsPojo salarypojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: storeEmployeeSalaryDetails : Starting");

		PreparedStatement ps_storesalary = null;
		ResultSet rs_storesalary = null;
		Connection connection = null;
		int no = 0;
		String status = null;

		try {
			connection = getConnection();

			if (new EmployeeSalaryDetailsDaoImpl().validateEmpId(salarypojo
					.getEmpid())) {

				ps_storesalary = connection
						.prepareStatement(Employee.UPDATE_SALARY_DETAILS);

				ps_storesalary.setString(1, salarypojo.getBankaccno());
				ps_storesalary.setString(2, salarypojo.getEmppfno());
				ps_storesalary.setString(3, salarypojo.getEmpesino());
				ps_storesalary.setString(4, salarypojo.getPaymenttype());
				ps_storesalary.setDouble(5, salarypojo.getCtc());
				ps_storesalary.setDouble(6, salarypojo.getGrosssalary());
				ps_storesalary.setDouble(7, salarypojo.getTotpayable());
				ps_storesalary.setDouble(8, salarypojo.getBasicda());
				ps_storesalary.setDouble(9, salarypojo.getHra());
				ps_storesalary.setDouble(10, salarypojo.getConveyance());
				ps_storesalary.setDouble(11, salarypojo.getMedical());
				ps_storesalary.setDouble(12, salarypojo.getCca());
				ps_storesalary.setDouble(13, salarypojo.getSplallow());
				ps_storesalary.setDouble(14, salarypojo.getVariablepay());
				ps_storesalary.setDouble(15, salarypojo.getEpfempr());
				ps_storesalary.setDouble(16, salarypojo.getEesiempr());
				ps_storesalary.setDouble(17, salarypojo.getTotearned());
				ps_storesalary.setDouble(18, salarypojo.getPfempr());
				ps_storesalary.setDouble(19, salarypojo.getPfempy());
				ps_storesalary.setDouble(20, salarypojo.getEsiempr());
				ps_storesalary.setDouble(21, salarypojo.getEsiempy());
				ps_storesalary.setDouble(22, salarypojo.getPtax());
				ps_storesalary.setDouble(23, salarypojo.getIncometax());
				ps_storesalary.setDouble(24, salarypojo.getAdvance());
				ps_storesalary.setDouble(25, salarypojo.getTotdeductions());
				ps_storesalary.setString(26, salarypojo.getLeavedeductions());
				ps_storesalary.setString(27, salarypojo.getLatedeductions());
				ps_storesalary.setString(28, salarypojo.getOvertime());
				ps_storesalary.setDouble(29, salarypojo.getLta());

				ps_storesalary.setDouble(30, salarypojo.getLoan());
				ps_storesalary.setString(31, salarypojo.getEmpid());

				no = ps_storesalary.executeUpdate();

				if (no > 0) {

					status = Employee.EMP_SAL_UPDATE_SUCESS;
				} else {

					status = Employee.EMP_SAL_UPDATE_FAIL;
				}

			} else {

				ps_storesalary = connection
						.prepareStatement(Employee.INSERT_SALARY_DETAILS);

				ps_storesalary.setString(1, salarypojo.getEmpid());
				ps_storesalary.setString(2, salarypojo.getBankaccno());
				ps_storesalary.setString(3, salarypojo.getEmppfno());
				ps_storesalary.setString(4, salarypojo.getEmpesino());
				ps_storesalary.setString(5, salarypojo.getPaymenttype());
				ps_storesalary.setDouble(6, salarypojo.getCtc());
				ps_storesalary.setDouble(7, salarypojo.getGrosssalary());
				ps_storesalary.setDouble(8, salarypojo.getTotpayable());
				ps_storesalary.setDouble(9, salarypojo.getBasicda());
				ps_storesalary.setDouble(10, salarypojo.getHra());
				ps_storesalary.setDouble(11, salarypojo.getConveyance());
				ps_storesalary.setDouble(12, salarypojo.getMedical());
				ps_storesalary.setDouble(13, salarypojo.getCca());
				ps_storesalary.setDouble(14, salarypojo.getSplallow());
				ps_storesalary.setDouble(15, salarypojo.getVariablepay());
				ps_storesalary.setDouble(16, salarypojo.getEpfempr());
				ps_storesalary.setDouble(17, salarypojo.getEesiempr());
				ps_storesalary.setDouble(18, salarypojo.getTotearned());
				ps_storesalary.setDouble(19, salarypojo.getPfempr());
				ps_storesalary.setDouble(20, salarypojo.getPfempy());
				ps_storesalary.setDouble(21, salarypojo.getEsiempr());
				ps_storesalary.setDouble(22, salarypojo.getEsiempy());
				ps_storesalary.setDouble(23, salarypojo.getPtax());
				ps_storesalary.setDouble(24, salarypojo.getIncometax());
				ps_storesalary.setDouble(25, salarypojo.getAdvance());
				ps_storesalary.setDouble(26, salarypojo.getTotdeductions());
				ps_storesalary.setString(27, salarypojo.getCreatedby());
				ps_storesalary.setString(28, salarypojo.getLeavedeductions());
				ps_storesalary.setString(29, salarypojo.getLatedeductions());
				ps_storesalary.setString(30, salarypojo.getOvertime());
				ps_storesalary.setDouble(31, salarypojo.getLta());
				ps_storesalary.setDouble(32, salarypojo.getLoan());

				no = ps_storesalary.executeUpdate();

				if (no > 0) {

					status = Employee.EMP_SAL_ADD_SUCESS;
				} else {

					status = Employee.EMP_SAL_ADD_FAIL;
				}

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs_storesalary != null && (!rs_storesalary.isClosed())) {

					rs_storesalary.close();
				}
				if (ps_storesalary != null && (!ps_storesalary.isClosed())) {

					ps_storesalary.close();
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

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: storeEmployeeSalaryDetails : Ending");

		return status;

	}

	public boolean validateEsiCode(String esicode, String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateBankAccNumber : Starting");
		DBService db = null;
		PreparedStatement salarystatement = null;
		ResultSet rs_salary = null;
		int count = 0;
		boolean status = false;

		try {

			db = new DBService();
			salarystatement = db.getPreparedStatement(Employee.CHECK_ESI_CODE);
			salarystatement.setString(1, empid);
			salarystatement.setString(2, esicode);
			rs_salary = salarystatement.executeQuery();

			while (rs_salary.next()) {

				count = rs_salary.getInt(1);

			}

			if (count > 0) {
				status = true;
			} else {

				status = false;
			}

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			sqle.printStackTrace();

		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (db != null) {
					db.closeAll(salarystatement, null);
				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();

			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
				logger.error(e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateBankAccNumber : Ending");

		return status;
	}

	public boolean validateBankAccNumber(String bankacc, String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateBankAccNumber : Starting");

		DBService db = null;
		PreparedStatement salarystatement = null;
		ResultSet rs_salary = null;
		int count = 0;
		boolean status = false;

		try {

			db = new DBService();
			salarystatement = db
					.getPreparedStatement(Employee.CHECK_BANKACC_NUMBER);
			salarystatement.setString(1, empid);
			salarystatement.setString(2, bankacc);
			rs_salary = salarystatement.executeQuery();

			while (rs_salary.next()) {

				count = rs_salary.getInt(1);

			}

			if (count > 0) {
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

				if (db != null) {
					db.closeAll(salarystatement, null);
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
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateBankAccNumber : Ending");

		return status;

	}

	public boolean validatePfCode(String pfnumber, String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateBankAccNumber : Starting");
		DBService db = null;
		PreparedStatement salarystatement = null;
		ResultSet rs_salary = null;
		int count = 0;
		boolean status = false;

		try {

			db = new DBService();
			salarystatement = db.getPreparedStatement(Employee.CHECK_PF_NUMBER);
			salarystatement.setString(1, empid);
			salarystatement.setString(2, pfnumber);
			rs_salary = salarystatement.executeQuery();

			while (rs_salary.next()) {

				count = rs_salary.getInt(1);

			}

			if (count > 0) {
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

				if (db != null) {
					db.closeAll(salarystatement, null);
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
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateBankAccNumber : Ending");

		return status;

	}

	public boolean validateEmpId(String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateEmpId : Starting");
		DBService db = null;
		PreparedStatement salarystatement = null;
		ResultSet rs_salary = null;
		int count = 0;
		boolean status = false;

		try {

			db = new DBService();
			salarystatement = db.getPreparedStatement(Employee.CHECK_EMPID);
			salarystatement.setString(1, empid);
			rs_salary = salarystatement.executeQuery();

			while (rs_salary.next()) {

				count = rs_salary.getInt(1);

			}

			if (count > 0) {
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

				if (db != null) {
					db.closeAll(salarystatement, null);
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
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateEmpId : Ending");

		return status;

	}

	public SalaryDetailsVo getSalaryDetails(String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: getSalaryDetails : Starting");
		DBService db = null;
		PreparedStatement salarystatement = null;
		ResultSet rs_salary = null;
		SalaryDetailsVo salaryDetailsVo = null;

		try {

			db = new DBService();

			salarystatement = db.getPreparedStatement(Employee.GET_SAL_DETAILS);
			salarystatement.setString(1, empid);

			rs_salary = salarystatement.executeQuery();

			while (rs_salary.next()) {

				salaryDetailsVo = new SalaryDetailsVo();

				salaryDetailsVo.setBankaccno(rs_salary
						.getString("HDFC_AC"));
				salaryDetailsVo.setEmppfno(rs_salary.getString("PfNumber"));
				salaryDetailsVo.setEmpesino(rs_salary.getString("EsiCode"));
				salaryDetailsVo.setPaymenttype(rs_salary
						.getString("PaymentType"));
				salaryDetailsVo.setCtc(rs_salary.getDouble("Ctc"));
				salaryDetailsVo.setGrosssalary(rs_salary
						.getDouble("GrossSalary"));
				salaryDetailsVo.setTotpayable(rs_salary
						.getDouble("TotalPayable"));
				salaryDetailsVo.setBasicda(rs_salary.getDouble("BasicDa"));
				salaryDetailsVo.setHra(rs_salary.getDouble("Hra"));
				salaryDetailsVo
						.setConveyance(rs_salary.getDouble("Conveyance"));
				salaryDetailsVo.setMedical(rs_salary.getDouble("Medical"));
				salaryDetailsVo.setCca(rs_salary.getDouble("Cca"));
				salaryDetailsVo.setSplallow(rs_salary
						.getDouble("FixSplAllowances"));
				salaryDetailsVo.setVariablepay(rs_salary
						.getDouble("VariablePay"));
				salaryDetailsVo.setEpfempr(rs_salary.getDouble("EarnedEmprPf"));
				salaryDetailsVo.setEesiempr(rs_salary
						.getDouble("EarnedEmprEsi"));
				salaryDetailsVo
						.setTotearned(rs_salary.getDouble("TotalEarned"));
				salaryDetailsVo.setPfempr(rs_salary.getDouble("PfEmpr"));
				salaryDetailsVo.setPfempy(rs_salary.getDouble("PfEmpy"));
				salaryDetailsVo.setEsiempr(rs_salary.getDouble("EsiEmpr"));
				salaryDetailsVo.setEsiempy(rs_salary.getDouble("EsiEmpy"));
				salaryDetailsVo.setPtax(rs_salary.getDouble("PTax"));
				salaryDetailsVo.setIncometax(rs_salary.getDouble("IncomeTax"));
				salaryDetailsVo.setAdvance(rs_salary.getDouble("Advance"));
				salaryDetailsVo.setTotdeductions(rs_salary
						.getDouble("TotalDeductions"));
				salaryDetailsVo.setLeavedeductions(rs_salary
						.getString("IsApplicableForLeave"));
				salaryDetailsVo.setLatedeductions(rs_salary
						.getString("IsApplicableForLate"));
				salaryDetailsVo.setOvertime(rs_salary
						.getString("IsApplicableForOt"));
				salaryDetailsVo.setLta(rs_salary.getDouble("Lta"));
				salaryDetailsVo.setLoan(rs_salary.getDouble("Loan"));

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (db != null) {
					db.closeAll(salarystatement, null);
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
				+ " Control in EmployeeSalaryDetailsDaoImpl: getSalaryDetails : Ending");

		return salaryDetailsVo;

	}

}
