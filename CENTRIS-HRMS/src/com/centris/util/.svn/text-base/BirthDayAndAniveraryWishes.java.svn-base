package com.centris.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.centris.DAO.DBService;

public class BirthDayAndAniveraryWishes {

	public BirthDayAndAniveraryWishes() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		DBService db=new DBService();
		
		 
		  java.sql.Date currDate = HelperClass.getCurrentSqlDate();
		  
		  String cd= currDate.toString();
		  System.out.println(currDate);
		 try {
			 
			 
			 
			   System.out.println(" Procedure 1 started ---- ");
				 
				CallableStatement proc = null; 
			    Connection con =db.getConnection();
			     
			     PreparedStatement pstmt = db.getPreparedStatement("SELECT count(*) FROM hrms_employee WHERE isActive ='Y' AND DOB like ? "); 
			     pstmt.setString(1, currDate.toString().replace(cd.substring(0, 4), "%"));
			    System.out.println(pstmt.toString());
			     ResultSet rs = pstmt.executeQuery();
			     
			     System.out.println(pstmt.toString());
			     int count = 0;
			     while (rs.next()) {
			    	 count = rs.getInt(1);
				 }
			     System.out.println(count);
			     if(count > 0){
//			     	
			    	 System.out.println(" YESSSSSSSSSS");
			    	 
			    	 PreparedStatement pstmtDOB = db.getPreparedStatement("SELECT First_Name,Official_Email_ID,Personal_Email_ID,DOB   FROM hrms_employee WHERE isActive ='Y' AND DOB like ? "); 
			    	 pstmtDOB.setString(1, currDate.toString().replace(cd.substring(0, 4), "%"));
				    
				     ResultSet rsDOB = pstmtDOB.executeQuery();
				     
				     while (rsDOB.next()) {
				    	 
				    	 
				    	 EmailContent em = new EmailContent();
																		
							String[] mails={rsDOB.getString("Official_Email_ID"),rsDOB.getString("Personal_Email_ID")};
								
								em.setMailids(mails);
								em.setSubject("Birthday Wishes");
								
								em.setMessage("Dear "+rsDOB.getString("First_Name")+", "+"<html><br/></html>"
										+"<html><br/></html>"
										+ "We at Teleindia Networks Pvt. Ltd. wish you on this day "
										+ HelperClass.getDateFromSQLDateinDDMMYYYYFormat(currDate)
										+ " a very Happy Birthday. May this day, the entire year as well as all the birthdays you celebrate ahead be filled with peace, happiness and satisfaction!! We also wish you greater strides & success in your life and your career throughout"
										+"<html><br/><br/></html>"
										+"<html><br/><br/></html>"
										+"<html><br/><br/></html>"
										+ "Have a nice day  "+"<html><br/><br/></html>"
										
										+ "E-ATTENDANCE PRO "+"<html><br/></html>"
										+ "-------------------------------------------------------------- "+"<html><br/><br/></html>"
										+ "This is system generated mail,Please do not reply " );
								
															
							String status=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
				    	 
					 }
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
			   
			    PreparedStatement pstmt1 = db.getPreparedStatement("SELECT count(*)  FROM hrms_employee WHERE isActive ='Y' AND DOM like ? "); 
			     pstmt1.setString(1, currDate.toString().replace(cd.substring(0, 4), "%"));
			    
			     ResultSet rs = pstmt1.executeQuery();
			     int count = 0;
			     while (rs.next()) {
			    	 count = rs.getInt(1);
				 }
			     
			     if(count > 0){		        	   
				
			    	 PreparedStatement pstmtDOM = db.getPreparedStatement("SELECT First_Name,Official_Email_ID,Personal_Email_ID,DOM  FROM hrms_employee WHERE isActive ='Y' AND DOM like ?"); 
			    	 pstmtDOM.setString(1, currDate.toString().replace(cd.substring(0, 4), "%"));
				    
				     ResultSet rsDOM = pstmtDOM.executeQuery();
				    
				     while (rsDOM.next()) {
				    	 
				    	 EmailContent em1 = new EmailContent();
																		
							String[] mails={rsDOM.getString("Official_Email_ID"),rsDOM.getString("Personal_Email_ID")};
								
								em1.setMailids(mails);
								em1.setSubject("Marriage Anniversary Wishes ");
								
								em1.setMessage("Dear "+rsDOM.getString("First_Name")+", "+"<html><br/></html>"
										+ "Greetings from TeleIndia."+"<html><br/><br/></html>"
										+ "Congratulations! Today "
										+  HelperClass.getDateFromSQLDateinDDMMYYYYFormat(currDate)
										+ " marks the completion of a year of togetherness!! We at Teleindia Networks Pvt. Ltd. wish you & your spouse a Happy Wedding Anniversary. Celebrate this milestone!!"
										+"<html><br/><br/></html>"
										+"<html><br/><br/></html>"
										+"<html><br/><br/></html>"
										+ "Have a nice day  "+"<html><br/><br/></html>"
										+ "E-ATTENDANCE PRO "+"<html><br/></html>"
										+ "-------------------------------------------------------------- "+"<html><br/><br/></html>"
										+ "This is system generated mail,Please do not reply " );
								
								
																	
							String status=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em1);
					 }
			     }else{
			    	 System.out.println( "Procedure 2 : Already ran ");
			     }
			     con1.close();
			     
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
		
		
	}

}
