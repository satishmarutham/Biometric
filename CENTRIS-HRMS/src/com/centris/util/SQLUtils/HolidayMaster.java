package com.centris.util.SQLUtils;

public class HolidayMaster {
	
	public static final String GET_ALL_YEARS="select AccadamicYear,AccyearCode from hrms_accyear";
	public static final String INSERT_HOLIDAY = "insert into hrms_holidaymaster(CURRENT_YEAR, HOLIDAY_DATE, WEEKDAY, HOLIDAY_NAME,CreatedBy,CREATEDDATE,ClientCode)values(?,?, ?, ?,?,now(),?)";
	public static final String GET_ALL_HOLIDAYS = "select distinct hm.HOLIDAY_DATE,hm.HOLIDAY_NAME,hm.WEEKDAY,hm.ClientCode,hc.ClientName from hrms_holidaymaster hm, hrms_client hc where hm.CURRENT_YEAR=? and hm.ClientCode=? and hc.ClientCode=hm.ClientCode";
	public static final String GET_DISTINCT_HOLIDAYLIST = "select distinct HOLIDAY_DATE  from hrms_holidaymaster where ClientCode=? and CURRENT_YEAR=?";
	public static final String DATE_VALIDATE = "select count(*) from hrms_holidaymaster where HOLIDAY_DATE=? and ClientCode=?";
	public static final String UPDATE_HOLIDAY = "UPDATE hrms_holidaymaster SET WEEKDAY=?,HOLIDAY_NAME=?,ModifiedBy=?,ClientCode=?,MODIFIEDDATE=now() WHERE HOLIDAY_DATE= ? and ClientCode=?";
	public static final String GET_EDIT_HOLIDAY = "select hh.HOLIDAY_DATE,hh.WEEKDAY,hh.HOLIDAY_NAME,hh.CURRENT_YEAR,hh.ClientCode,hc.ClientName from hrms_holidaymaster hh,hrms_client hc where hh.HOLIDAY_DATE=? and hc.ClientCode=hh.ClientCode and hh.ClientCode=?";
	public static final String DELETE_SINGLE_HOLIDAY = "delete from hrms_holidaymaster where HOLIDAY_DATE=? and ClientCode=? ";
	public static final String GET_HOLIDAY_COUNT = " select count(*) from hrms_holidaymaster where HOLIDAY_DATE=? and ClientCode=? ";
	public static final String GET_CLIENT = "select ClientCode,ClientName from hrms_client";

	public static final String GET_ACADAMIC_YEAR = "select AccadamicYear from hrms_accyear where AccyearCode=?";
	
	

}
