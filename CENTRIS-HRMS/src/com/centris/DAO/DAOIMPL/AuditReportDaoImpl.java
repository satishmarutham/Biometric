package com.centris.DAO.DAOIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.centris.DAO.DBService;
import com.centris.VO.AuditReportDeptVO;
import com.centris.VO.AuditReportEmpVO;
import com.centris.VO.AuditReportShiftVO;

import com.centris.VO.EmpLocationVO;

import com.centris.util.SQLUtils.SQLutilConstants;

public class AuditReportDaoImpl  {

	

	public synchronized ArrayList<AuditReportShiftVO> getAllShifts(EmpLocationVO empLocationVO) {
		DBService db=null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		ArrayList<AuditReportShiftVO> audit_shift_list = new ArrayList<AuditReportShiftVO>();

		try {
			db = new DBService();
			 pstmt = db
					.getPreparedStatement(SQLutilConstants.GET_ALL_SHIFTS);
			pstmt.setString(1, empLocationVO.getLocation());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				AuditReportShiftVO auditSiftvo = new AuditReportShiftVO();

				auditSiftvo.setShiftId(rs.getString("AI_SHIFT_ID"));
				auditSiftvo.setShiftName(rs.getString("AI_SHIFT_NAME"));

				audit_shift_list.add(auditSiftvo);

			}

		} catch (SQLException sqle) {
		
			sqle.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
		   try {

				 if(pstmt != null && (!pstmt.isClosed())){
					 pstmt.getConnection().close();
					}
				
		      
			} catch (SQLException e) {
				
				e.printStackTrace();
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		 }
			
		

		return audit_shift_list;
	}

	public synchronized ArrayList<AuditReportDeptVO> getAllDepartments() {
		DBService db=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;

		ArrayList<AuditReportDeptVO> audit_dept_list = new ArrayList<AuditReportDeptVO>();

		try {
			db = new DBService();
			 pstmt = db
					.getPreparedStatement(SQLutilConstants.GET_ALL_DEPARTMENTS);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AuditReportDeptVO auditDeptVo = new AuditReportDeptVO();

				auditDeptVo.setDeptId(rs.getString("DEPT_ID"));
				auditDeptVo.setDeptName(rs.getString("DEPT_NAME"));

				audit_dept_list.add(auditDeptVo);

			}

		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
		   try {
			   if(pstmt != null && (!pstmt.isClosed())){
					 pstmt.getConnection().close();
					}
				
		      
			} catch (SQLException e) {
				
				e.printStackTrace();
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		 }
			
		

		return audit_dept_list;
	}

	public synchronized ArrayList<AuditReportEmpVO> getEmpDetails(EmpLocationVO empLocationVO) {

		DBService db=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;

		ArrayList<AuditReportEmpVO> emp_list = new ArrayList<AuditReportEmpVO>();

		try {
			db = new DBService();
			String shiftId=empLocationVO.getShiftid();
			String deptId=empLocationVO.getDept();
			
			
			if(shiftId.equals("all")){
				shiftId="%%";
			}
			if(deptId.equals("all")){
				deptId="%%";
			}
			
			
			pstmt = db.getPreparedStatement(SQLutilConstants.GET_EMPLOYEES_WITH_SHIFTID_DEPTID);
			String location=empLocationVO.getLocation();
			if(empLocationVO.getUserRole().equals("ROL1")){
				location="%%";
			}
				pstmt.setString(1, location);
				pstmt.setString(2, shiftId);
				pstmt.setString(3, deptId);


/*
			if ((!(shiftId.equals("all"))) && (deptId.equals("all"))) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_EMPLOYEES_WITH_SHIFTID);

				pstmt.setString(1, shiftId);

			}

			if ((shiftId.equals("all")) && (!(deptId.equals("all")))) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_EMPLOYEES_WITH_DEPTID);

				pstmt.setString(1, deptId);

			}

			if ((shiftId.equals("all") && (deptId.equals("all")))) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_ALL_EMPLOYEES);

			}
*/
			rs = pstmt.executeQuery();

			while (rs.next()) {

				AuditReportEmpVO emp_vo = new AuditReportEmpVO();

				emp_vo.setEmpId(rs.getString("EMPID"));
				emp_vo.setEmpName(rs.getString("EMPNAME"));

				emp_list.add(emp_vo);

			}

        } catch (SQLException sqle) {
			
			sqle.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
		   try {
			   if(pstmt != null && (!pstmt.isClosed())){
					 pstmt.getConnection().close();
					}
		      
			} catch (SQLException e) {
				
				e.printStackTrace();
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		 }
			
		return emp_list;
	}

	/*	public ArrayList<AuditReportVO> getAuditReport(AuditReportForm aform,
//			int query_case) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<AuditReportVO> audtireport_list = new ArrayList<AuditReportVO>();

		try {
			String location=aform.getLocation();
			if(aform.getUserRole().equals("ROL1")){
				location="%%";
			}
		
			
			if (query_case == 1) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_AUDIT_REPORT_FOR_ONEEMP);
				pstmt.setString(1, location);
				pstmt.setInt(2, Integer.parseInt(aform.getEmpname()));
				if (aform.getFilter().equals("ap")) {
					pstmt.setString(3, "absent");
					pstmt.setString(4, "present");
				} else {
					pstmt.setString(3, "present");
					pstmt.setString(4, "absent");

				}

				pstmt.setDate(5, Date.valueOf((HelperClass
						.convertUIToDatabase(aform.getDate()))));
				pstmt.setDate(6, Date.valueOf((HelperClass
						.convertUIToDatabase(aform.getTodate()))));

			} else if (query_case == 2) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_AUDIT_REPORT_FOR_ALLEMP);
				pstmt.setString(1, location);
				if (aform.getFilter().equals("ap")) {
					pstmt.setString(2, "absent");
					pstmt.setString(3, "present");
				} else {
					pstmt.setString(2, "present");
					pstmt.setString(3, "absent");

				}

				pstmt.setDate(4, Date.valueOf((HelperClass
						.convertUIToDatabase(aform.getDate()))));
				pstmt.setDate(5, Date.valueOf((HelperClass
						.convertUIToDatabase(aform.getTodate()))));

			} else if (query_case == 3) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_AUDITREPORT_ONEEMP_WITHOUT_TODATE);
				pstmt.setString(1, location);
				pstmt.setInt(2, Integer.parseInt(aform.getEmpname()));
				if (aform.getFilter().equals("ap")) {
					pstmt.setString(3, "absent");
					pstmt.setString(4, "present");
				} else {
					pstmt.setString(3, "present");
					pstmt.setString(4, "absent");

				}

				pstmt.setDate(5, Date.valueOf((HelperClass
						.convertUIToDatabase(aform.getDate()))));

			} else {

				pstmt = db.getPreparedStatement(SQLutilConstants.GET_AUDITREPORT_ALLEMP_WITHOUT_TODATE);
				pstmt.setString(1, location);
				if (aform.getFilter().equals("ap")) {
					pstmt.setString(2, "absent");
					pstmt.setString(3, "present");
				} else {
					pstmt.setString(2, "present");
					pstmt.setString(3, "absent");

				}

				pstmt.setDate(4, Date.valueOf((HelperClass
						.convertUIToDatabase(aform.getDate()))));

			}

			rs = pstmt.executeQuery();

			while (rs.next()) {

				AuditReportVO auditreport_vo = new AuditReportVO();
				auditreport_vo.setEmpname(rs.getString("emp_name"));
				auditreport_vo.setAttendence_date(HelperClass
						.getDateFromSQLDateinDDMMYYYYFormat(rs
								.getDate("attendece_date")));
				auditreport_vo
						.setCurrent_status(rs.getString("current_status"));
				auditreport_vo.setModifiedby(rs.getString("modifiedby"));

				String timestamp = rs.getTimestamp("modifiedDate").toString();

				String[] date = timestamp.split(" ");

				auditreport_vo.setModifieddate(HelperClass
						.getDateFromSQLDateinDDMMYYYYFormat(Date
								.valueOf(date[0])));
				auditreport_vo.setPrevious_status(rs
						.getString("previous_status"));
				auditreport_vo.setReason(rs.getString("reason"));

				audtireport_list.add(auditreport_vo);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return audtireport_list;
	}*/

//	public ArrayList<AuditReportVO> getAuditReconciliationReportDao(
//			AuditReportForm aform, int query_case) {
//
//		ResultSet rs = null;
//		PreparedStatement pstmt = null;
//		ArrayList<AuditReportVO> audtireport_list = new ArrayList<AuditReportVO>();
//
//		try {
//			
//			// UPDATE_ATTENDANCE_ISRECONCILED 
//			
//			String shift=aform.getShiftid();
//			String dept = aform.getEmpdepartment();
//			String emp = aform.getEmpname();
//			if (shift.equalsIgnoreCase("all")) {
//				shift="%%";
//			}
//			if (dept.equalsIgnoreCase("all")) {
//				dept="%%";
//			}
//			if (emp.equalsIgnoreCase("0")) {
//				emp="%%";
//			}
//			
//			pstmt = db.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION);
//				String location=aform.getLocation();
//				if(aform.getUserRole() !=null  && aform.getUserRole().equals("ROL1")){
//					location="%%";
//				}
//				pstmt.setString(1, location);
//			 	pstmt.setString(2, HelperClass.convertUIToDatabase(aform.getDate()));
//			 	pstmt.setString(3, HelperClass.convertUIToDatabase(aform.getTodate()));
//				pstmt.setString(4,emp);
//			 	pstmt.setString(5, dept);
//				pstmt.setString(6, shift);
//			 
//			 	
//		/*	if (aform.getShiftid().equalsIgnoreCase("all"))
//
//			{
//				if (aform.getEmpdepartment().equalsIgnoreCase("all")) {
//					if (aform.getEmpname().equalsIgnoreCase("0")) {
//						pstmt = db
//								.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION_1);
//						pstmt.setString(1, HelperClass
//								.convertUIToDatabase(aform.getDate()));
//						pstmt.setString(2, HelperClass
//								.convertUIToDatabase(aform.getTodate()));
//					} else {
//						pstmt = db
//								.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION_2);
//						pstmt.setString(1, HelperClass
//								.convertUIToDatabase(aform.getDate()));
//						pstmt.setString(2, HelperClass
//								.convertUIToDatabase(aform.getTodate()));
//						pstmt.setString(3, aform.getEmpname());
//					}
//				} else if (!aform.getEmpdepartment().equalsIgnoreCase("all")) {
//					if (aform.getEmpname().equalsIgnoreCase("0")) {
//						pstmt = db
//								.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION_3);
//						pstmt.setString(1, HelperClass
//								.convertUIToDatabase(aform.getDate()));
//						pstmt.setString(2, HelperClass
//								.convertUIToDatabase(aform.getTodate()));
//						pstmt.setString(3, aform.getEmpdepartment());
//					} else {
//						pstmt = db
//								.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION_4);
//						pstmt.setString(1, HelperClass
//								.convertUIToDatabase(aform.getDate()));
//						pstmt.setString(2, HelperClass
//								.convertUIToDatabase(aform.getTodate()));
//						pstmt.setString(3, aform.getEmpname());
//						pstmt.setString(4, aform.getEmpdepartment());
//					}
//				}
//			} else if (!aform.getShiftid().equalsIgnoreCase("all"))
//
//			{
//				if (aform.getEmpdepartment().equalsIgnoreCase("all")) {
//					if (aform.getEmpname().equalsIgnoreCase("0")) {
//						pstmt = db
//								.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION_5);
//						pstmt.setString(1, HelperClass
//								.convertUIToDatabase(aform.getDate()));
//						pstmt.setString(2, HelperClass
//								.convertUIToDatabase(aform.getTodate()));
//						pstmt.setString(3, aform.getShiftid());
//					} else {
//						pstmt = db
//								.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION_6);
//						pstmt.setString(1, HelperClass
//								.convertUIToDatabase(aform.getDate()));
//						pstmt.setString(2, HelperClass
//								.convertUIToDatabase(aform.getTodate()));
//						pstmt.setString(3, aform.getEmpname());
//						pstmt.setString(4, aform.getShiftid());
//					}
//				} else if (!aform.getEmpdepartment().equalsIgnoreCase("all")) {
//					if (aform.getEmpname().equalsIgnoreCase("0")) {
//						pstmt = db
//								.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION_7);
//						pstmt.setString(1, HelperClass
//								.convertUIToDatabase(aform.getDate()));
//						pstmt.setString(2, HelperClass
//								.convertUIToDatabase(aform.getTodate()));
//						pstmt.setString(3, aform.getEmpdepartment());
//						pstmt.setString(4, aform.getShiftid());
//					} else {
//						pstmt = db
//								.getPreparedStatement(SQLutilConstants.AUDIT_REPORT_RECONCILIATION_8);
//						pstmt.setString(1, HelperClass
//								.convertUIToDatabase(aform.getDate()));
//						pstmt.setString(2, HelperClass
//								.convertUIToDatabase(aform.getTodate()));
//						pstmt.setString(3, aform.getEmpname());
//						pstmt.setString(4, aform.getEmpdepartment());
//						pstmt.setString(5, aform.getShiftid());
//					}
//				}
//			}*/
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				AuditReportVO auditreport_vo = new AuditReportVO();
//				auditreport_vo.setEmpid(rs.getString("empid"));
//				auditreport_vo.setEmpname(rs.getString("EMPNAME"));
//				auditreport_vo.setAttendence_date(HelperClass
//						.getDateFromSQLDateinDDMMYYYYFormat(rs
//								.getDate("Attendence_Date")));
//				auditreport_vo.setPrevious_status(rs
//						.getString("previousStatus"));
//				auditreport_vo.setCurrent_status(rs.getString("CurrentStatus"));
//				auditreport_vo.setModifiedby(rs.getString("modified_by"));
//
//				auditreport_vo.setModifieddate(HelperClass
//						.ConvertDBTimestamptoUITimestamp(rs
//								.getString("modified_date")));
//				auditreport_vo.setReason(rs.getString("reason"));
//				audtireport_list.add(auditreport_vo);
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return audtireport_list;
//	}
}