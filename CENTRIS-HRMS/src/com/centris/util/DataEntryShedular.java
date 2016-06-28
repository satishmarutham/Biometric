package com.centris.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.centris.DAO.DBService;

public class DataEntryShedular {

	public DataEntryShedular() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		DBService db=new DBService();
		
		  String yday = HelperClass.getYesterdayDateString();
		  System.out.println(yday);
		  java.sql.Date yesterday = HelperClass.getSqlDate(yday);
		  System.out.println(yesterday);
		  java.sql.Date currDate = HelperClass.getCurrentSqlDate();
		 try {
			 
			 
			 
			   System.out.println(" Procedure 1 started ---- ");
				 
				CallableStatement proc = null; 
			    Connection con =db.getConnection();
			     
			     PreparedStatement pstmt = db.getPreparedStatement("select count(*) from storedproceduresaudit where DATE_LOG = ? and SP_NAME = 'DataEntryOnDayStarting'"); 
			     pstmt.setDate(1, currDate);
			    
			     ResultSet rs = pstmt.executeQuery();
			     int count = 0;
			     while (rs.next()) {
			    	 count = rs.getInt(1);
				 }
			     
			     if(count == 0){
//			     			        	   
				  proc= con.prepareCall("{ call attedencePosting(?) }");
				  proc.setDate(1, currDate);
			      boolean reult= proc.execute();
			      System.out.println(reult);
			     }else{
			    	 
			    	 System.out.println( "Procedure 1 : Already ran "); 
			     }
				 
			   con.close();
			     
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		
		 try {
			 
			   System.out.println(" Procedure 2 started ---- ");
				 
				CallableStatement proc1 = null; 
			    Connection con1 =db.getConnection();
			   
			    PreparedStatement pstmt = db.getPreparedStatement("select count(*) from storedproceduresaudit where DATE_LOG = ? and SP_NAME = 'AttendenceReconcillationForHolidayMaster'"); 
			     pstmt.setDate(1, currDate);
			    
			     ResultSet rs = pstmt.executeQuery();
			     int count = 0;
			     while (rs.next()) {
			    	 count = rs.getInt(1);
				 }
			     
			     if(count == 0){		        	   
				
			    
			    proc1= con1.prepareCall("{ call AttendenceReconcillationForHolidayMaster(?) }");
				proc1.setDate(1, yesterday);
			    boolean reult2= proc1.execute();
			     
			    System.out.println(reult2);
			     }else{
			    	 System.out.println( "Procedure 2 : Already ran ");
			     }
			     con1.close();
			     
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 try {
			 
			   System.out.println(" Procedure 3 started ---- ");
				 
				CallableStatement proc2 = null; 
			    Connection con1 =db.getConnection();
			   
			    PreparedStatement pstmt = db.getPreparedStatement("select count(*) from storedproceduresaudit where DATE_LOG = ? and SP_NAME = 'AttendenceReconcillationForWeekOff'"); 
			     pstmt.setDate(1, currDate);
			    
			     ResultSet rs = pstmt.executeQuery();
			     int count = 0;
			     while (rs.next()) {
			    	 count = rs.getInt(1);
				 }
			     
			     if(count == 0){		        	   
				
			    
			    proc2= con1.prepareCall("{ call AttendenceReconcillationForWeekOff(?) }");
				proc2.setDate(1, yesterday);
			    boolean reult2= proc2.execute();
			     
			    System.out.println(reult2);
			     }else{
			    	 System.out.println( "Procedure 3 : Already ran ");
			     }
			     con1.close();
			     
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		
		
		
	}

}
