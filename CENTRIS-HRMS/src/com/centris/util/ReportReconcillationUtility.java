package com.centris.util;
import java.sql.Time;


public class ReportReconcillationUtility {
  
	
	public  String getToatalHoursandWorkingHours(String intime,String outtime){
				
		long inTime = (Time.valueOf(intime).getTime());
		long outTime = (Time.valueOf(outtime).getTime());
		
	
		long secs = (outTime - inTime) / 1000;
		long hours = secs / 3600;    
		secs = secs % 3600;
		long mins = secs / 60;
		secs = secs % 60;
		
		 String hh =(hours+"").length()>1?(hours+""):"0"+hours;
		 String mm=(mins+"").length()>1?(mins+""):"0"+mins;
		 String sec=(secs+"").length()>1?(secs+""):"0"+secs;
     	 String	 totalhours= hh+":"+mm+":"+sec;
	
     	 return totalhours;
	}
	
	
	
	
	
	
}
