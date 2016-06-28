package com.centris.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDateDay {
	
	
	public String checkSaturday(String dateCheck) throws java.text.ParseException {
		
		String days[] = {"sunday", "monday", "tuesday","wednesday","thursday","friday","saturday"};
		
		 DateFormat formatter ; 
		 Date date ; 
		 int day = 0;
 		 try{
			 formatter = new SimpleDateFormat(StringUtils.DATE_FORMAT);
			 date = (Date)formatter.parse(dateCheck);
			 day = date.getDay();
			
 			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return days[day];
 		 
	}
	

}
 
