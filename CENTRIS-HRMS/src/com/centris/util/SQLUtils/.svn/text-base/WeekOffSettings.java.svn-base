/**
 * 
 */
package com.centris.util.SQLUtils;

/**
 * @author satish
 *
 */
public class WeekOffSettings {
	public static String GET_WEEKOFFSETTING_BY_EMPID="select ws.EMPID,ws.SUNDAY,ws.MONDAY,ws.TUESDAY,ws.WEDNESDAY,ws.THURSDAY,ws.FRIDAY,ws.SATURDAY,ws.CLIENTCODE,c.ClientName from hrms_weekoffmaster ws left outer join hrms_client c  on  ws.CLIENTCODE=c.ClientCode where ws.EMPID=?";
	
	public static String GET__EMP_COUNT="select count(*) from hrms_weekoffmaster where EMPID=?";
}
