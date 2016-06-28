package com.centris.DAO.DAOIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.centris.DAO.DBService;

public class IDGenerator extends DBService {

	/**
	 * @param args
	 * @throws SQLException
	 */

	public String getPrimaryKeyID(String tableName) throws SQLException {

		tableName = tableName.trim().toLowerCase();
		int currentID = 0;
		String pre = null;
		String previousID = getPreviousID(tableName);
		
	

		if (previousID == null) {
			currentID = 0;
		} else {
			String id = previousID.substring(3);
			currentID = Integer.parseInt(id);
		}
		if (tableName.equalsIgnoreCase("hrms_department"))
			pre = "DEP";
		else if (tableName.equalsIgnoreCase("lstms_teachers"))
			pre = "TEA";
		else if (tableName.equalsIgnoreCase("onsite_group"))
			pre = "GRP";
		else if (tableName.equalsIgnoreCase("hrms_designation"))
			pre = "DES";
		else if (tableName.equalsIgnoreCase("ai_bio_break"))
			pre = "BRE";
		else if (tableName.equalsIgnoreCase("hrms_user"))
			pre = "USR";
		else if (tableName.equalsIgnoreCase("hrmsi_role"))
			pre = "ROL";
		else if (tableName.equalsIgnoreCase("ai_emp_permissions"))
			pre = "PER";
		else if (tableName.equalsIgnoreCase("ai_shift_deatails"))
			pre = "SFT";
		else if (tableName.equalsIgnoreCase("ai_emp_location"))
			pre = "LOC";
		else if (tableName.equalsIgnoreCase("hrms_att_etl_details"))
			pre = "ETL";
		else if (tableName.equalsIgnoreCase("hrms_project"))
			pre = "PJT";
		else if (tableName.equalsIgnoreCase("hrms_manager"))
			pre = "MAN";
		else if (tableName.equalsIgnoreCase("hrms_employee"))
			pre = "EMP";
		else if (tableName.equalsIgnoreCase("hrms_attendence_status_type"))
			pre = "AST";
		else if (tableName.equalsIgnoreCase("hrms_monthly_expense"))
			pre = "MEP";
		else if (tableName.equalsIgnoreCase("hrms_employee_advance_salary"))
			pre = "ASD";
		else if (tableName.equalsIgnoreCase("hrms_client"))
			pre = "CLI";
		else if (tableName.equalsIgnoreCase("hrms_employee_daily_allowance"))
			pre = "DAL";
		else if (tableName.equalsIgnoreCase("hrms_resume_careerobjective"))
			pre = "RCO";
		
		else if (tableName.equalsIgnoreCase("hrms_resume_hobbiesnsports"))
			pre = "RHS";
		
		else if (tableName.equalsIgnoreCase("hrms_resume_responsibilities"))
			pre = "RRS";
		
		
		else if (tableName.equalsIgnoreCase("hrms_resume_technicalskills"))
			pre = "RTS";	
		
		else if (tableName.equalsIgnoreCase("hrms_resume_pursuits"))
			pre = "RPS";	
		else if (tableName.equalsIgnoreCase("hrms_ticket_booking"))
			pre = "TBK";
			
		else if (tableName.equalsIgnoreCase("hrms_resume_experience"))
			pre = "REP";	
		else if (tableName.equalsIgnoreCase("hrms_director"))
			pre = "DIR";	
		else if (tableName.equalsIgnoreCase("hrms_employee_letterhead_request"))
			pre = "LET";
	else {
		}
		String NextID = pre + ++currentID;
		return NextID;
	}

	private String getPreviousID(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		int counter = 0;
		String columnName = null;
		try {

			String sql = "SHOW KEYS FROM " + tableName
					+ " WHERE Key_name = 'PRIMARY'";

			PreparedStatement ps = (PreparedStatement) getPreparedStatement(sql);

			// PreparedStatement ps= (PreparedStatement)
			// JDBCConnection.getStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				columnName = (String) rs.getString("Column_name");
			}
			ps.close();
			String sql2 = "select max(" + columnName + ") from " + tableName
					+ " group by length(" + columnName + ") desc limit 1";

			ps = (PreparedStatement) getPreparedStatement(sql2);
			rs = ps.executeQuery();
			while (rs.next()) {
				counter++;
				columnName = (String) rs.getString(1);
			}

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (counter == 0) {
			return null;
		} else
			return columnName;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		IDGenerator id = new IDGenerator();
		String id1 = id.getPrimaryKeyID("hrms_ticket_booking");

		System.out.println("id1 -- " + id1);
	}
}