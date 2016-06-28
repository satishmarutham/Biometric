package com.centris.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.centris.DAO.DBService;
import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.util.SQLUtils.ETL_AttendanceProcessing;
import com.centris.util.SQLUtils.SQLutilConstants;

public class LogsPosting extends DBService {
	String dateTimeToken = null;
	private String date;
	private String time;
	private String id;
	private static PreparedStatement stat, stat2;
	private static Statement stat1;
	private static String dateFromAudit = "";
	private static String dateNow;
	private static ArrayList<String> EmpIDTotalList = new ArrayList<String>();
	private static ArrayList<String> EmpIDList = new ArrayList<String>();
	private static ArrayList<String> dateList = new ArrayList<String>();
	private static ArrayList<LogsPosting> list = new ArrayList<LogsPosting>();
	static long graceTime;
	static long outGraceTime;
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	static Calendar cal = Calendar.getInstance();

	public LogsPosting(String date, String time, String id) {
		super();
		this.date = date;
		this.time = time;
		this.id = id;
	}

	public LogsPosting() {
	}

	public ArrayList getMSACESSData(String ETL_CODE) throws Exception {

		System.out.println(" getMSACESSData() Started --------->> ");
		String date1 = null;
		String time = null;
		String id = null;
		String flag = null;
		Timestamp audit_date = null;
		int auidit_id = 0;
		String previous_timestamp = null;
		ArrayList al = new ArrayList();
		Timestamp t = new Timestamp(new java.util.Date().getTime());

		Date dt = HelperClass.getYesterDayDate(new java.sql.Date(
				new java.util.Date().getTime()));
		
		System.out.println("yestur day date ::: "+dt);

		Timestamp pcurrent_timestamp = new LogsPosting()
				.getTimeStampfromString(dt.toString().concat(" 23:59:59"));

		String current_timestamp = pcurrent_timestamp.toString().substring(0,
				pcurrent_timestamp.toString().length() - 2);
		
		System.out.println("current_timestamp :::: "+current_timestamp);
		
		al.add((Timestamp) pcurrent_timestamp);

		Connection con = getConnection();
		PreparedStatement audit_statement = con
				.prepareStatement(ETL_AttendanceProcessing.SHIFT_MAX_LOGAUDIT);
		ResultSet getDate = audit_statement.executeQuery();

		while (getDate.next()) {
			auidit_id = getDate.getInt("ADMS_CHK_ID");
		}
		audit_statement.close();
		if (auidit_id == 0) {
			System.out.println(" Audit Table is Empty.. Please put one entry.");
			al.add("false");
			al.add(0);
			return al;
		}

		System.out.println("curr Date " + current_timestamp);

		int count = 0;
		try {

			Connection conn = getConnection();
			PreparedStatement statement = conn
					.prepareStatement(ETL_AttendanceProcessing.INSERT_LOGDETAILS_new);

			Connection logconn = getLogConnection();

			PreparedStatement max_log_statement = logconn
					.prepareStatement(ETL_AttendanceProcessing.SELECT_MAX_LOG_ID);
			max_log_statement.setString(1, pcurrent_timestamp.toString());
			int max_id = 0;
			ResultSet max_rs = max_log_statement.executeQuery();

			while (max_rs.next()) {
				max_id = max_rs.getInt("id");
			}

			PreparedStatement log_statement = logconn
					.prepareStatement(ETL_AttendanceProcessing.LOG_SELECT_SQL);
			log_statement.setInt(1, auidit_id);
			log_statement.setInt(2, max_id);

			ResultSet rs1 = log_statement.executeQuery();
			count = 0;
			while (rs1.next()) {
				count++;
				id = rs1.getString("Badgenumber");
				dateTimeToken = rs1.getString("CHECKTIME");
				StringTokenizer dateTime = new StringTokenizer(dateTimeToken);
				while (dateTime.hasMoreTokens()) {

					date1 = dateTime.nextToken().trim();
					time = dateTime.nextToken().trim();
				}

				flag = rs1.getString("CHECKTYPE");
				String SN = rs1.getString("SN");
				String Location_code = "Office";
				String[] spi2 = date1.split("-");
				date1 = spi2[0] + "/" + spi2[1] + "/" + spi2[2];
				Date gettinDate = new Date(date1);

				System.out.println("Adding Logs:" + id + " - " + date1 + " - "
						+ time);

				statement.setString(1, getPerfectNumber(id));
				statement.setDate(2, HelperClass.getSqlDateFromYYYYMMDD(date1));
				statement.setTime(3, HelperClass.getStringToTime(time));
				statement.setString(4, SN);
				statement.setString(5, ETL_CODE);
				statement.setString(6, "ETL");
				statement.setInt(7, rs1.getInt("ADMS_CHK_ID"));
				statement.executeUpdate();

			}

			log_statement.close();
			statement.close();
			logconn.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

		}
		al.clear();
		ArrayList timelist = getTheLatestTimestamp();
		int ADMS_CHK_ID = (Integer) timelist.get(0);
		String timestamp1 = (String) timelist.get(1);

		if (ADMS_CHK_ID == 0)
			al.add(0);
		else
			al.add(ADMS_CHK_ID);

		al.add("true");
		al.add(count);
		al.add(previous_timestamp);
		al.add(current_timestamp);
		al.add(getTimeStampfromString(timestamp1));
		System.out.println("audit_date :" + audit_date);
		System.out.println();
		System.out.println(al);
		return al;
	}

	public String getStringTimeStamp(Timestamp t) {
		String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(t.getTime());
		return timestamp;
	}

	public Timestamp getTimeStampfromString(String t) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date parsedDate = dateFormat.parse(t);
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		return timestamp;
	}

	public ArrayList getTheLatestTimestamp() {
		Connection con;
		PreparedStatement statement = null;
		int ADMS_CHK_ID = 0;
		String timestamp = null;
		ArrayList al = new ArrayList();

		try {
			con = getConnection();

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.calculate_latest_timestamp);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				al.clear();
				ADMS_CHK_ID = rs.getInt("ADMS_CHK_ID");
				timestamp = rs.getString(2) + " " + rs.getString(3);
				al.add(ADMS_CHK_ID);
				al.add(timestamp);
			}
			statement.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
		}
		return al;
	}

	public ArrayList<java.sql.Date> calculateDatesBetweenTwoStamps(
			String previous, String current) {

		ArrayList<java.sql.Date> dates = new ArrayList<java.sql.Date>();
		try {

			System.out.println(" previous "+previous);
			System.out.println(" current "+current);
			Timestamp previous_stamp = getTimeStampfromString(previous);
			Timestamp current_stamp = getTimeStampfromString(current);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(new Date(previous_stamp.getTime()));

			dates.clear();
			dates.add(HelperClass
					.getSqlDateFromYYYYMMDD2(new java.text.SimpleDateFormat(
							"yyyy-MM-dd").format(cal1.getTime())));
			while (cal1.getTime().before(current_stamp)) {
				cal1.add(Calendar.DATE, 1);
				dates.add(HelperClass
						.getSqlDateFromYYYYMMDD2(new java.text.SimpleDateFormat(
								"yyyy-MM-dd").format(cal1.getTime())));
			}
//			dates.remove(dates.size() - 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dates;
	}

	public String getETLCode() {
		String etl_code = null;

		try {
			IDGenerator id = new IDGenerator();
			etl_code = id.getPrimaryKeyID("hrms_att_etl_details");
			Connection con;
			PreparedStatement statement = null;
			try {
				con = getConnection();

				statement = con
						.prepareStatement(ETL_AttendanceProcessing.ETL_AUDIT);
				statement.setString(1, etl_code);
				statement.setString(2, HelperClass.getCurrentSqlDate() + " "
						+ HelperClass.getCurrentTime());
				int co = statement.executeUpdate();

				statement.close();
				con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return etl_code;
	}

	public String getCurrentSessionFirstTimeStamp(String ETLCODE) {

		Connection con;
		PreparedStatement statement = null;
		String timestamp = null;
		try {
			con = getConnection();

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.getCurrentSessionFirstTimeStamp);
			statement.setString(1, ETLCODE);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				timestamp = rs.getString(1) + " " + rs.getString(2);
			}
			statement.close();
			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
		}
		return timestamp;
	}

	public void updateAuditDates(ArrayList<java.sql.Date> allDates,
			String ETL_CODE) {

		Connection con;
		PreparedStatement statement = null;
		String timestamp = null;
		try {
			con = getConnection();

			for (Iterator iterator = allDates.iterator(); iterator.hasNext();) {

				java.sql.Date date = (java.sql.Date) iterator.next();

				int chk = checkForDateIsPresentOrNot(date, con);

				if (chk == 0) {
					String status = checkFOrData(date, con);

					statement = con
							.prepareStatement(ETL_AttendanceProcessing.UPDATE_AUDITDATES);
					statement.setDate(1, date);
					statement.setString(2, status);
					statement.setString(3, ETL_CODE);
					int co = statement.executeUpdate();
				}
			}
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
		}
	}

	public String checkFOrData(java.sql.Date date, Connection dbconn) {

		Connection con;
		PreparedStatement statement = null;
		String timestamp = null;
		int count = 0;
		try {
			con = dbconn;

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.checkForData);
			statement.setDate(1, date);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				count = rs.getInt(1);
			}

			statement.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

		}

		if (count != 0)
			return "completed";
		else
			return "no data in logs";

	}

	public int checkForDateIsPresentOrNot(java.sql.Date date, Connection dbconn) {

		Connection con;
		PreparedStatement statement = null;
		String timestamp = null;
		java.sql.Date count = null;
		try {
			con = dbconn;

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.checkForDateIsPresentOrNot);
			statement.setDate(1, date);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				count = rs.getDate(1);
			}

			statement.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

		}

		if (count != null)
			return 1;
		else
			return 0;

	}

	// ********************************BY Arul**********************
	public static String getPerfectNumber(String value) {
		Double empOpeningBalance = Double.valueOf(value);
		if (empOpeningBalance % 2 == 0) {
			Integer empOpBal = empOpeningBalance.intValue();
			return empOpBal.toString();
		} else if ((empOpeningBalance % 2 != 0)
				&& (empOpeningBalance.toString().endsWith(".5"))) {
			return empOpeningBalance.toString();
		} else {
			Integer empOpBal = empOpeningBalance.intValue();
			return empOpBal.toString();
		}
	}

	// *******************************************************INSERT
	// COMPLETED**********************
	public void pickDates() throws SQLException {
		try {
			Connection con = getConnection();
			stat = con
					.prepareStatement(ETL_AttendanceProcessing.LOGMAX_DATE_PICK);

			stat.setString(1, dateFromAudit);
			ResultSet getDates = stat.executeQuery();

			while (getDates.next()) {

				dateList.add(getDates.getDate("AI_EMP_DATE").toString());
			}

			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pickTotalID() throws Exception {
		EmpIDTotalList.clear();

		Connection con = getConnection();
		stat = con.prepareStatement(ETL_AttendanceProcessing.SELECT_EMPID);
		ResultSet totalId = stat.executeQuery();
		while (totalId.next()) {
			EmpIDTotalList.add(totalId.getString("EMPID"));
		}

		stat.close();

	}

	public void updateAuditData() throws Exception {

		/*
		 * audit table should be modified.. should get date from the table
		 * ai_bio_log_details then insert
		 * 
		 * insert using the condition where date should less then todays and
		 * greater then max of the today date
		 */

		Connection con = getConnection();
		stat = con.prepareStatement(ETL_AttendanceProcessing.UPDATE_AUDITENTRY);

		for (String e : dateList) {
			stat.setString(1, e);
			stat.setString(2, "success");
			stat.setString(3, dateFormat.format(cal.getTime()));
			stat.executeUpdate();
		}

		stat.close();

	}

	public int updateLogAudit(Timestamp time, int t, String ETL_CODE) {

		Connection con;
		PreparedStatement statement = null;
		int count = 0;
		try {
			con = getConnection();

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.UPDATE_AUDITENTRY);

			statement.setTimestamp(1, time);
			statement.setInt(2, t);
			statement.setTimestamp(3,
					new Timestamp(new java.util.Date().getTime()));
			statement.setString(4, ETL_CODE);
			count = statement.executeUpdate();
			statement.close();

			con.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
		}
		return count;
	}

	public void calculateTimeSheet() throws Exception {

		String inTime;
		String outTime;
		int lengthOfTransaction;
		long totalWorkingHours;
		Connection con = getConnection();
		Statement sqlStatement = con.createStatement();

		ArrayList<String> availableTime = new ArrayList<String>();

		//
		int inCount = 0;
		int outCount = 0;

		try {
			// ****************************************************************************************************//
			// date list is already get while inserting the data into database
			// from msaccess
			for (String date : dateList) {

				// pick distinct ID's on particular date..
				stat = con
						.prepareStatement(SQLutilConstants.SELECT_EMP_LOG_COMPARISION);

				stat.setString(1, date);
				ResultSet disID = stat.executeQuery();

				while (disID.next()) {

					EmpIDList.add(disID.getString("EMPID"));

				}

				stat.close();
				// end distinct ID's ...

				try {

					// query to mark attendance on specified day
					stat = con
							.prepareStatement(SQLutilConstants.BIO_ATTANCANCE_INSERT);
					stat1 = con.createStatement();

					String name = null;

					for (String e : EmpIDList) {

						// get shift timings..
						// WARNING: // no use getting shift timings here coz it
						// will b changing everytime when ID changes

						// WARNING ENDS

						// get the empName for particular ID..
						ResultSet rs = stat1
								.executeQuery(SQLutilConstants.SELECT_EMPNAME
										+ e.trim() + "'");
						while (rs.next()) {
							name = rs.getString("EMPNAME");
							name.trim();
						}

						stat.setString(1, e);
						stat.setString(2, name);
						stat.setString(3, "present");
						stat.setString(4, date);
						stat.executeUpdate();
						EmpIDTotalList.remove(e);
					}

					for (String absent : EmpIDTotalList) {

						ResultSet rs = stat1
								.executeQuery(SQLutilConstants.SELECT_EMPNAME
										+ absent.trim() + "'");
						while (rs.next()) {
							name = rs.getString("EMPNAME");
							name.trim();
						}
						stat.setString(1, absent);
						stat.setString(2, name);
						stat.setString(3, "absent");
						stat.setString(4, date);
						stat.executeUpdate();

					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				stat.close();
				stat1.close();

				// **************** end marking attendance
				// **********************************

				// prepare the time sheet for specified date n number of empID..

				for (String empID : EmpIDList) {

					stat2 = con
							.prepareStatement("SELECT  ai_emp_details.EMPID, ai_emp_details.SHIFT_ID,ai_shift_deatails.AI_SHIFT_LTOC,ai_shift_deatails.AI_SHIFT_ETOG FROM ai_emp_details, ai_shift_deatails where ai_emp_details.SHIFT_ID=ai_shift_deatails.AI_SHIFT_ID and ai_emp_details.EMPID='"
									+ empID + "'");
					ResultSet rs1 = stat2.executeQuery();

					while (rs1.next()) {

						graceTime = Time
								.valueOf(rs1.getString("AI_SHIFT_LTOC"))
								.getTime();
						outGraceTime = (Time.valueOf(rs1
								.getString("AI_SHIFT_ETOG")).getTime());

					}

					String query = "select AI_EMP_TIME from ai_bio_log_details where AI_EMP_ID = '"
							+ empID
							+ "' and AI_EMP_DATE ='"
							+ date
							+ "' ORDER BY AI_EMP_TIME";
					ResultSet rs = sqlStatement.executeQuery(query);

					while (rs.next()) {
						availableTime.add(rs.getString("AI_EMP_TIME"));
					}

					availableTime.trimToSize();
					// calculating in and out time
					lengthOfTransaction = availableTime.size();
					inTime = availableTime.get(0);
					outTime = availableTime.get(lengthOfTransaction - 1);

					// total time
					totalWorkingHours = (Time.valueOf(availableTime.get(0))
							.getTime())
							- (Time.valueOf(availableTime
									.get(lengthOfTransaction - 1)).getTime());

					// remove the negative n make it positive..
					if (totalWorkingHours < 0)
						totalWorkingHours = totalWorkingHours * (-1);

					// pass the available time to calculate..
					long timeWorked = timeSplit(availableTime);

					availableTime.clear();

					Time total = new Time(totalWorkingHours);
					adjustBaseTime(total);

					Time worked = new Time(timeWorked);

					adjustBaseTime(worked);

					long mornTime = (Time.valueOf(inTime).getTime());
					long eveTime = (Time.valueOf(outTime).getTime());
					String latetime = null;
					String earlytime = null;
					if (graceTime < mornTime) {

						inCount = 1;
						long seconds = ((mornTime - graceTime) / 1000);
						long lhours = seconds / 3600;
						long min = seconds % 3600;
						long lmin1 = min / 60;
						long lsec = min % 60;

						String hours = (lhours + "").length() > 1 ? (lhours + "")
								: "0" + lhours;
						String min1 = (lmin1 + "").length() > 1 ? (lmin1 + "")
								: "0" + lmin1;
						String sec = (lsec + "").length() > 1 ? (lsec + "")
								: "0" + lsec;
						latetime = hours + ":" + min1 + ":" + sec;

					} else {
						inCount = 0;
						latetime = "00:00:00";
					}

					if (outGraceTime > eveTime) {

						outCount = 1;

						long seconds = ((outGraceTime - eveTime) / 1000);
						long lhours = seconds / 3600;
						long min = seconds % 3600;
						long lmin1 = min / 60;
						long lsec = min % 60;

						String hours = (lhours + "").length() > 1 ? (lhours + "")
								: "0" + lhours;
						String min1 = (lmin1 + "").length() > 1 ? (lmin1 + "")
								: "0" + lmin1;
						String sec = (lsec + "").length() > 1 ? (lsec + "")
								: "0" + lsec;
						earlytime = hours + ":" + min1 + ":" + sec;
					} else {

						outCount = 0;
						earlytime = "00:00:00";
					}

					// insert here in database
					String insertTimeSheet = "insert into ai_bio_timesheet(EMP_ID,ATTENDANCE_DATE,IN_TIME,OUT_TIME,TOTAL_HOURS,TOTAL_WORKING_HOURS,MORNING_LATE,EVENING_EARLY,LATE_TIME,EARLY_TIME) values('"
							+ empID
							+ "', '"
							+ date
							+ "', '"
							+ inTime
							+ "','"
							+ outTime
							+ "','"
							+ total
							+ "','"
							+ worked
							+ "', "
							+ inCount
							+ ","
							+ outCount
							+ ",'"
							+ latetime
							+ "','" + earlytime + "' )";
					System.out.println("timeSheet :::::::::::::::::::"
							+ insertTimeSheet);
					sqlStatement.executeUpdate(insertTimeSheet);

				}

				pickTotalID();
				EmpIDList.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static long timeSplit(ArrayList<String> listPass) {

		long t1 = 0;
		long t2 = 0;
		long timeLap = 0;

		if (listPass.size() == 0)
			return 0;

		// calculating time lap
		int k = 0, l = 1;

		for (int i = 0; i < listPass.size(); i++) {

			if ((l >= (listPass.size())))
				break;

			t1 = Time.valueOf(listPass.get(k)).getTime();
			t2 = Time.valueOf(listPass.get(l)).getTime();
			if (t1 < t2)
				timeLap = timeLap + (t2 - t1);

			k += 2;
			l += 2;
		}
		listPass.clear();
		return timeLap;
	}

	// Adjust the time to Indian timings
	static void adjustBaseTime(Time time) {
		time.setHours(time.getHours() - 5);
		time.setMinutes(time.getMinutes() - 30);
		System.out.println(time);
	}

	// close the conection
	public void closeConnection() throws Exception {
		Connection con = getConnection();
		con.close();
	}

	public static void main(String[] args) throws Exception {
		LogsPosting getAllText = new LogsPosting();
		Timestamp t = new Timestamp(new java.util.Date().getTime());

		String current_timestamp1 = new LogsPosting().getStringTimeStamp(t);

		System.out.println(current_timestamp1);
		ArrayList<java.sql.Date> allDates = getAllText
				.calculateDatesBetweenTwoStamps("2014-10-22 05:05:05",
						"2014-10-27 23:59:59");

		System.out.println(allDates);
	}
}