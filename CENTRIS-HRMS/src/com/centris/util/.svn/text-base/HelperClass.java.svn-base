package com.centris.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;

import com.centris.VO.UserDetailVO;
import com.centris.VO.UsermanagementEmployeeVo;
import com.centris.util.constants.MessageConstants;

public class HelperClass {

	public static Time getCurrentTime() {
		Time t = new Time(new Date().getTime());
		return t;
	}

	public static java.sql.Date getSqlDate(String date) {
		java.util.Date sd;
		java.sql.Date currdate = null;

		try {
			sd = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			currdate = new java.sql.Date(sd.getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currdate;
	}

	public static String convertUIToDatabase(String date) {

		String currdate = null;
		if (!"".equals(date.trim())) {
			try {
				Date sd = new SimpleDateFormat("dd-MM-yyyy").parse(date);
				currdate = new SimpleDateFormat("yyyy-MM-dd").format(sd);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return currdate;
	}

	public static String convertTitleToDatabase(String date) {

		String currdate = null;
		if (!"".equals(date.trim())) {
			date = date.replaceAll(" ", "");
			try {
				Date sd = new SimpleDateFormat("dd-MMM-yyyy").parse(date);
				currdate = new SimpleDateFormat("yyyy-MM-dd").format(sd);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return currdate;
	}

	public static String convertDatabaseToUI(String date) {

		String currdate = null;
		if (!"".equals(date.trim())) {
			try {
				Date sd = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				currdate = new SimpleDateFormat("dd-MM-yyyy").format(sd);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return currdate;
	}

	public static java.sql.Date getCurrentSqlDate() {
		java.util.Date sd = new java.util.Date();
		java.sql.Date currdate = new java.sql.Date(sd.getTime());
		return currdate;
	}

	/*
	 * public static java.sql.Date getSQLDate(java.util.Date date1){
	 * 
	 * 
	 * MessageResources res =
	 * MessageResources.getMessageResources("com.centris.tds.properties.CMS");
	 * String ConnectionString=""; String
	 * DriverName=res.getMessage("mySqlDriver");
	 * 
	 * 
	 * return ""; }
	 */

	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static Time getStringToTime(String getTime) {
		Time time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date d = null;
		try {
			d = sdf.parse(getTime);
			time = new Time(d.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return time;

	}

	public static String addTimeArray(String[] getTime) {
		String time = null;
		long cal_time = 0l;
		TimeZone UTC = TimeZone.getTimeZone("UTC");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.setTimeZone(UTC);
		Date d = null;
		try {
			for (int i = 0; i < getTime.length; i++) {
				d = sdf.parse(getTime[i]);
				cal_time = cal_time + d.getTime();
			}
			long seconds = (cal_time / 1000);
			long lhours = seconds / 3600;
			long min = seconds % 3600;
			long lmin1 = min / 60;
			long lsec = min % 60;

			String hours = (lhours + "").length() > 1 ? (lhours + "") : "0"
					+ lhours;
			String min1 = (lmin1 + "").length() > 1 ? (lmin1 + "") : "0"
					+ lmin1;
			String sec = (lsec + "").length() > 1 ? (lsec + "") : "0" + lsec;
			time = hours + ":" + min1 + ":" + sec;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return time;

	}

	public static String getTimeDifference(String startTime, String endEnd) {
		String differenceTime = "";
		long diff = 0l;
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1 = format.parse(startTime);
			Date date2 = format.parse(endEnd);
			if (date1.getTime() < date2.getTime()) {
				diff = date2.getTime() - date1.getTime();

			} else {
				date1 = format.parse(startTime);
				Date date3 = format.parse("23:59:59");
				long diff1 = date3.getTime() - date1.getTime();

				Date date4 = format.parse("00:00:00");
				date2 = format.parse(endEnd);
				long diff2 = date2.getTime() - date4.getTime();
				diff = diff1 + diff2;
			}
			String differencehour = diff / 3600000 + "";

			String differencemin = (diff % 3600000) / (1000 * 60) + "";

			differenceTime = differencehour + "." + differencemin;

			// differenceTime =
			// differenceTime.substring(0,(differenceTime.indexOf(".")+3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return differenceTime;
	}

	public static String getDateDifference(String startDate, String endDate) {
		String differenceDate = "";
		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = format.parse(startDate);
			Date date2 = format.parse(endDate);
			long diff = date2.getTime() - date1.getTime();
			differenceDate = diff / (1000 * 60 * 60 * 24) + 1 + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return differenceDate;
	}

	public static java.sql.Date getSQLDate(java.util.Date date1) {

		java.sql.Date sqldate = new java.sql.Date(date1.getTime());
		return sqldate;
	}

	public static String getDateFromSQLDateinDDMMYYYYFormat(java.sql.Date date) {

		String strDate = null;
		try {
			java.util.Date utildate = new Date(date.getTime());
			strDate = new SimpleDateFormat("dd-MM-yyyy").format(utildate);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strDate;
	}

	public static String getDaysCountBetweenTimePeriod(String startDate,
			String endDate, List<String> dateList) {
		String totalDaysCount = "";
		String totalDateCount = "";
		String weekoffData = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Calendar c1 = Calendar.getInstance();
			c1.setTime(format.parse(startDate));

			Calendar c2 = Calendar.getInstance();
			c2.setTime(format.parse(endDate));
			c2.add(Calendar.DATE, 1);

			int sundays = 0;
			int mondays = 0;
			int tuedays = 0;
			int weddays = 0;
			int thrdays = 0;
			int fridays = 0;
			int satdays = 0;
			String sunDate = "";
			String monDate = "";
			String tueDate = "";
			String wedDate = "";
			String thruDate = "";
			String friDate = "";
			String satDate = "";

			List<String> uniqueDateList = new ArrayList<String>();

			for (int i = 0; i < dateList.size(); i++) {
				Calendar holiDate = Calendar.getInstance();
				holiDate.setTime(format.parse(dateList.get(i)));
				String date = holiDate.get(Calendar.DAY_OF_MONTH) + "";
				uniqueDateList.add(date);
			}

			while (c1.before(c2)) {
				String days = new DateFormatSymbols().getWeekdays()[c1
						.get(Calendar.DAY_OF_WEEK)];
				if (!uniqueDateList
						.contains(c1.get(Calendar.DAY_OF_MONTH) + "")) {

					if (days.equals("Sunday")) {
						sundays++;
						sunDate = sunDate + "," + c1.get(Calendar.DAY_OF_MONTH);
					}
					if (days.equals("Monday")) {
						mondays++;
						monDate = monDate + "," + c1.get(Calendar.DAY_OF_MONTH);
					}
					if (days.equals("Tuesday")) {
						tuedays++;
						tueDate = tueDate + "," + c1.get(Calendar.DAY_OF_MONTH);
					}
					if (days.equals("Wednesday")) {
						weddays++;
						wedDate = wedDate + "," + c1.get(Calendar.DAY_OF_MONTH);
					}
					if (days.equals("Thursday")) {
						thrdays++;
						thruDate = thruDate + ","
								+ c1.get(Calendar.DAY_OF_MONTH);
					}
					if (days.equals("Friday")) {
						fridays++;
						friDate = friDate + "," + c1.get(Calendar.DAY_OF_MONTH);
					}
					if (days.equals("Saturday")) {
						satdays++;
						satDate = satDate + "," + c1.get(Calendar.DAY_OF_MONTH);
					}

				}
				c1.add(Calendar.DATE, 1);
			}

			totalDaysCount = sundays + "," + mondays + "," + tuedays + ","
					+ weddays + "," + thrdays + "," + fridays + "," + satdays;
			/*
			 * totalDaysCount=sunDate+","
			 * +monDate+","+tueDate+","+wedDate+","+thruDate
			 * +","+friDate+","+satDate;
			 */
			weekoffData = totalDaysCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalDaysCount;
	}

	public static String getTimeDifferenceinTimeFormat(String startTime,
			String endEnd) {
		String differenceTime = "";
		long diff = 0l;
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1 = format.parse(startTime);
			Date date2 = format.parse(endEnd);
			if (date1.getTime() < date2.getTime()) {
				diff = date2.getTime() - date1.getTime();

			} else {
				date1 = format.parse(startTime);
				Date date3 = format.parse("23:59:59");
				long diff1 = date3.getTime() - date1.getTime();

				Date date4 = format.parse("00:00:00");
				date2 = format.parse(endEnd);
				long diff2 = date2.getTime() - date4.getTime();
				diff = diff1 + diff2;
			}

			String differencehour = diff / 3600000 + "";
			String differencemin = (diff % 3600000) / (1000 * 60) + "";
			String differencesec = ((diff % 3600000) % (1000 * 60)) / 1000 + "";

			differencehour = (differencehour + "").length() > 1 ? (differencehour + "")
					: "0" + differencehour;
			differencemin = (differencemin + "").length() > 1 ? (differencemin + "")
					: "0" + differencemin;
			differencesec = (differencesec + "").length() > 1 ? (differencesec + "")
					: "0" + differencesec;

			differenceTime = differencehour + ":" + differencemin + ":"
					+ differencesec;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return differenceTime;
	}
	
	
	public static String getTimeDifferenceinTimeFormatForAttendance(String startTime,
			String endEnd) {
		String differenceTime = "";
		long diff = 0l;
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1 = format.parse(startTime);
			Date date2 = format.parse(endEnd);
			if (date1.getTime() < date2.getTime()) {
				diff = date2.getTime() - date1.getTime();
				
				String differencehour = diff / 3600000 + "";
				String differencemin = (diff % 3600000) / (1000 * 60) + "";
				String differencesec = ((diff % 3600000) % (1000 * 60)) / 1000 + "";

				differencehour = (differencehour + "").length() > 1 ? (differencehour + "")
						: "0" + differencehour;
				differencemin = (differencemin + "").length() > 1 ? (differencemin + "")
						: "0" + differencemin;
				differencesec = (differencesec + "").length() > 1 ? (differencesec + "")
						: "0" + differencesec;

				differenceTime = differencehour + ":" + differencemin + ":"+ differencesec;

			}else{
				
				differenceTime="00:00:00";
				
			}

		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return differenceTime;
	}

	public static String ConvertDBTimestamptoUITimestamp(String timestamp) {
		String currdate = null;
		Date sd;
		String time = null;
		try {
			sd = new SimpleDateFormat("yyyy-MM-dd").parse(timestamp);
			currdate = new SimpleDateFormat("dd-MM-yyyy").format(sd);
			SimpleDateFormat parseFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat printFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = parseFormat.parse(timestamp);
			time = printFormat.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currdate + " at " + time;
	}

	public static String convertDatabaseToUIWithDateTime(String date) {

		String currdate = null;

		try {
			Date sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
			currdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(sd);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currdate;
	}

	public static java.sql.Date getYesterDayDate(java.sql.Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.DATE, -1);

		date = new java.sql.Date(cal.getTimeInMillis());

		return date;
	}

	public static java.sql.Date getTomarrowDate(java.sql.Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.DATE, 1);

		date = new java.sql.Date(cal.getTimeInMillis());

		return date;
	}

	public static String getMiddleTimeinTimeFormat(String startTime,
			String endEnd) {
		String differenceTime = "";
		long diff = 0l;
		String newtt = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1 = format.parse(startTime);
			Date date2 = format.parse(endEnd);
			if (date1.getTime() < date2.getTime()) {
				diff = date2.getTime() - date1.getTime();

			} else {
				date1 = format.parse(startTime);
				Date date3 = format.parse("23:59:59");
				long diff1 = date3.getTime() - date1.getTime();

				Date date4 = format.parse("00:00:00");
				date2 = format.parse(endEnd);
				long diff2 = date2.getTime() - date4.getTime();
				diff = diff1 + diff2;
			}

			String differencehour = diff / 3600000 + "";

			String differencemin = (diff % 3600000) / (1000 * 60) + "";
			String differencesec = ((diff % 3600000) % (1000 * 60)) / 1000 + "";

			differenceTime = differencehour + ":" + differencemin + ":"
					+ differencesec;
			Time t = HelperClass.getStringToTime(differenceTime);
			String time = t.getHours() / 2 + ":" + t.getMinutes() / 2 + ":"
					+ t.getSeconds() / 2;
			Time halftime = HelperClass.getStringToTime(time);

			String[] tt = { startTime, time };

			newtt = HelperClass.addTimeArray(tt);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return newtt;
	}

	public static java.sql.Date getSqlDateFromYYYYMMDD(String date) {
		java.util.Date sd;
		java.sql.Date currdate = null;

		try {
			sd = new SimpleDateFormat("yyyy/MM/dd").parse(date);
			currdate = new java.sql.Date(sd.getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currdate;
	}

	public static java.sql.Date getSqlDateFromYYYYMMDD2(String date) {
		java.util.Date sd;
		java.sql.Date currdate = null;

		try {
			sd = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			currdate = new java.sql.Date(sd.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return currdate;
	}

	public static List<String> getDateListBetweenDates(String fromDate,
			String toDate) {
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fDate = sdf.parse(fromDate);
			Date tDate = sdf.parse(toDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(fDate);
			cal.add(Calendar.DATE, -1);
			while (cal.getTime().before(tDate)) {
				cal.add(Calendar.DATE, 1);
				if (sdf.format(cal.getTime()) != null)
					dateList.add(sdf.format(cal.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateList;
	}

	public static List<String> getLastThreeDateFromNow(String date) {
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {

			Calendar now = Calendar.getInstance();
			Date fDate = sdf.parse(date);
			now.setTime(fDate);
			now.add(Calendar.DATE, -1);
			Calendar previous = Calendar.getInstance();
			previous.setTime(fDate);
			previous.add(Calendar.DATE, -4);
			while (previous.getTime().before(now.getTime())) {
				previous.add(Calendar.DATE, 1);
				if (sdf.format(previous.getTime()) != null)
					dateList.add(sdf.format(previous.getTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateList;
	}

	public static List<String> getDateDifferenceBetweenDates(String fromDate,
			String toDate) {
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fDate = sdf.parse(fromDate);
			Date tDate = sdf.parse(toDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(fDate);
			cal.add(Calendar.DATE, -1);
			while (cal.getTime().before(tDate)) {
				cal.add(Calendar.DATE, 1);
				if (sdf.format(cal.getTime()) != null)
					dateList.add(sdf.format(cal.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateList;
	}

	public static String getMonthFullName(String month) {

		Map<String, String> monthMap = new HashMap<String, String>();
		monthMap.put("01", "January");
		monthMap.put("02", "February");
		monthMap.put("03", "March");
		monthMap.put("04", "April");
		monthMap.put("05", "May");
		monthMap.put("06", "June");
		monthMap.put("07", "July");
		monthMap.put("08", "August");
		monthMap.put("09", "September");
		monthMap.put("10", "October");
		monthMap.put("11", "November");
		monthMap.put("12", "December");
		return monthMap.get(month.length() < 2 ? "0" + month : month);
	}

	public static String lastDayOftheMonth(String sel_year, String sel_month) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		Calendar calendar = Calendar.getInstance();

		int year = Integer.parseInt(sel_year);
		int month = Integer.parseInt(sel_month);
		month = month - 1;
		int maxDay = 0;
		calendar.set(year, month, 1);
		// Getting Maximum day for Given Month
		maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		calendar.set(year, month, maxDay);

		String lDate = formatter.format(calendar.getTime());

		return lDate;
	}

	public static String convertDatabaseToTitle(String date) {

		String currdate = null;

		try {
			Date sd = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			currdate = new SimpleDateFormat("dd-MMM-yyyy").format(sd);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currdate;
	}

	public static String getYesterdayDateFromNow(String date) {
		String yesterdayDate = "";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		try {

			Calendar now = Calendar.getInstance();
			Date fDate = sd.parse(date);
			now.setTime(fDate);
			now.add(Calendar.DATE, -1);
			yesterdayDate = sdf.format(now.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return yesterdayDate;
	}

	public static String getLastThirdDateFromNow(String date) {
		String lastThirdDate = "";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {

			Calendar now = Calendar.getInstance();
			Date fDate = sd.parse(date);
			now.setTime(fDate);
			now.add(Calendar.DATE, -3);
			lastThirdDate = sd.format(now.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lastThirdDate;
	}

	public static int getDaysByMonthAndYear(int month, int year) {
		Calendar c1 = Calendar.getInstance();
		c1.clear();
		c1.set(year, (month - 1), 1);
		int days = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days;
	}

	public static String getCurrentUserID(HttpServletRequest request) {

		String user = "";

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			user = userDetailVO.getUserCode().toString().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public static String getCurrentUserIDType(HttpServletRequest request) {

		String user = "";

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			user = userDetailVO.getUserCode().toString().trim().substring(0, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static String getCurrentUser(HttpServletRequest request) {

		String user = "manager";

		// HttpSession ses = request.getSession(false);
		try {
			// user = (String) ses.getAttribute("user");
		} catch (Exception e) {
		}

		return user;
	}

	public static String getCurrentYear() {
		java.util.Date sd = new java.util.Date();
		java.sql.Date currdate = new java.sql.Date(sd.getTime());
		return (currdate + "").substring(0, 4);
	}

	public static String getLastFifteenthDateFromNow(String date) {
		String lastThirdDate = "";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {

			Calendar now = Calendar.getInstance();
			Date fDate = sd.parse(date);
			now.setTime(fDate);
			now.add(Calendar.DATE, -15);
			lastThirdDate = sd.format(now.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lastThirdDate;
	}

	public static String getCurrentMonth() {
		java.util.Date sd = new java.util.Date();
		java.sql.Date currdate = new java.sql.Date(sd.getTime());
		return (currdate + "").substring(5, 7);
	}

	public static String converDateDDMMMYYYY(String date1) {

		SimpleDateFormat format1 = new SimpleDateFormat("yy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
		Date date;
		String required_date = null;
		try {
			date = format1.parse(date1);
			required_date = format2.format(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return required_date;
	}

	public static String currentMonthStartdate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		String startdate = format1.format(c.getTime());

		return startdate;
	}

	public static int getDaysofCurrentMonth() {
		Calendar c = Calendar.getInstance();
		int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return monthMaxDays;
	}
	
	public static String genaratePasswordForManager(UsermanagementEmployeeVo vo) {
		
	         
		String pswd = null;
		String[] sp = {"@","#","%","&","*","_"};
		Random rand = new Random();
		
		
		String pswd1 = vo.getMobilenumber().toString().substring(1, 3);
		String pswd2 = vo.getEmpname().toString().substring(vo.getEmpname().length()-3,vo.getEmpname().length()).toUpperCase();
		String pswd3 = sp[rand.nextInt((5 - 1) + 1) + 1];
		String pswd4=null;
		if(vo.getBioid().length()>3){
			
			pswd4 = vo.getBioid().toString().substring(1, 3);
		
		}else{
			
			pswd4 = vo.getBioid().toString().substring(1, vo.getBioid().length());
		}
		String pswd5 = vo.getOfficialmailId().toString().substring(1, 3).toLowerCase();
		
		pswd = pswd1+pswd2+pswd3+pswd4+pswd5;
		
		pswd=pswd.replace(" ", "").trim();
		
			return pswd;
	}
	
	public static String genaratePasswordForDirector(UsermanagementEmployeeVo vo) {
		
		
		String pswd = null;
		String[] sp = {"@","#","%","&","*","_"};
		Random rand = new Random();
		
		
		String pswd1 = vo.getOfficialmailId().toString().substring(1, 3).toLowerCase();
		String pswd2 = sp[rand.nextInt((5 - 1) + 1) + 1];
		String pswd3 =  vo.getEmpname().toString().substring(vo.getEmpname().length()-3,vo.getEmpname().length()).toUpperCase();
		String pswd4 = null;
		if(vo.getBioid().length()>3){
			
			pswd4 = vo.getBioid().toString().substring(1, 3);
		
		}else{
			
			pswd4 = vo.getBioid().toString().substring(1, vo.getBioid().length());
		}
		String pswd5 = vo.getMobilenumber().toString().substring(1, 3);
		
		pswd = pswd1+pswd2+pswd3+pswd4+pswd5;
		
		pswd=pswd.replace(" ", "").trim();
		return pswd;
	}
	
	public static String genaratePasswordForUser(UsermanagementEmployeeVo vo) {
		
		String pswd = null;
		String[] sp = {"@","#","%","&","*","_"};
		Random rand = new Random();
		
		
		String pswd1 = vo.getEmpname().toString().substring(vo.getEmpname().length()-3,vo.getEmpname().length()).toLowerCase();
		String pswd2 = vo.getMobilenumber().toString().substring(1, 3);
		String pswd3 = null;
		if(vo.getBioid().length()>3){
			
			pswd3 = vo.getBioid().toString().substring(1, 3);
		
		}else{
			
			pswd3 = vo.getBioid().toString().substring(1, vo.getBioid().length());
		}
		String pswd4 = sp[rand.nextInt((5 - 1) + 1) + 1];
		String pswd5 = vo.getOfficialmailId().toString().substring(1, 3).toUpperCase();
		
		pswd = pswd1+pswd2+pswd3+pswd4+pswd5;
		pswd=pswd.replace(" ", "").trim();
		return pswd;
	}
	
	public static String currentMonthEnddate() {
		
		Calendar c = Calendar.getInstance();      
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String enddate = format.format(c.getTime());

		return enddate;
	}

	public static String getYesterdayDateString() {
	    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);    
	    return dateFormat.format(cal.getTime());
	}
     public static String getMonthName(String monthnum) {
    	 
    	 int num=Integer.parseInt(monthnum);
		
    	  String month = "wrong";
          DateFormatSymbols dfs = new DateFormatSymbols();
          String[] months = dfs.getMonths();
          
          if (num >= 0 && num <= 12 ) {
              month = months[num-1];
          }
          
           return month;
	}
     
 	public static String getLastThirtyDateFromNow(String date) {
		String lastThirdDate = "";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {

			Calendar now = Calendar.getInstance();
			Date fDate = sd.parse(date);
			now.setTime(fDate);
			now.add(Calendar.DATE, -30);
			lastThirdDate = sd.format(now.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lastThirdDate;
	}

	public static void main(String[] args) {

		/*UsermanagementEmployeeVo v = new UsermanagementEmployeeVo();
		v.setBioid("103");
		v.setDesignation("employee");
		v.setDob("10-06-1986");
		v.setEmpid("EMP1");
		v.setMobilenumber("9986625327");
		v.setEmpname("ratna");
		v.setOfficialmailId("rtnaraju.b@centrisinfotech.com");
		
		System.out.println(HelperClass.genaratePasswordForManager(v));
		System.out.println(HelperClass.genaratePasswordForDirector(v));
		System.out.println(HelperClass.genaratePasswordForUser(v));*/
		
		UsermanagementEmployeeVo employeeVo=new UsermanagementEmployeeVo();
		
		employeeVo.setEmpname("Harish B C");
		employeeVo.setDob("1984-06-16");
		employeeVo.setMobilenumber("9353030444");
		employeeVo.setOfficialmailId("harish@teleindianetworks.com");
		employeeVo.setEmpid("EMP5");
		employeeVo.setBioid("23");
		
		
		System.out.println(getMonthName("11"));
		
	}
}