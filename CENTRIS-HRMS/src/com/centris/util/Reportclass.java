package com.centris.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.centris.DAO.DBService;
import com.centris.util.SQLUtils.SQLutilConstants;


public class Reportclass extends DBService{

	String empid ;
	String empname;
	String date;
	String status;	
	double succeess_Rate;
	int monthDays;
	int attended;

	
	public Double successRate(){
		
		return succeess_Rate;
	}
	
	public String getEmpid() {
		return empid;
	}

	

	public String getEmpname() {
		return empname;
	}

	
	public String getDate() {
		return date;
	}

	

	public String getStatus() {
		return status;
	}

	public int getMonthDays() {
		
		return monthDays;
	}

	public int getAttended() {
		
		return attended;
	}


	
	public Reportclass() {

		super();
	}
	
	public Reportclass(String empid,String empname,String date,String status)
	{
		this.date =date;
		this.empid =empid;
		this.empname =empname;
		this.status = status;
	}

	
	//Get all details
	public ArrayList<Reportclass> getDetail() throws SQLException
	{
		
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();		 
		Connection  con = null;
		try{
			con= getConnection();
			PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getreportAll);
			ResultSet rs_candidateDetails = stm.executeQuery();
			
			while (rs_candidateDetails.next())
		 		{
				
				String date1 = rs_candidateDetails.getString(StringUtils.EMPDATE);
				//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
				list.add(new Reportclass(rs_candidateDetails.getString(StringUtils.EMPID),rs_candidateDetails.getString(StringUtils.EMPNAME), date1 ,rs_candidateDetails.getString(StringUtils.DB_STATUS)));
		 		}
		 		}catch (Exception e) {
		 	}
		 con.close();
		return list;
	}
	
	
	
	//get details
	public ArrayList<Reportclass> getDetail(String empName, String status) throws SQLException
	{
		
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();
		Connection  con = null;
		try{
			con= getConnection();
			PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getrepNameStatus);
			stm.setString(1, empName);
			stm.setString(2, status);
		    ResultSet rs_candidateDetails = stm.executeQuery();
		    while (rs_candidateDetails.next())
		 		{
		    	
		    	String date1 = rs_candidateDetails.getString(StringUtils.EMPDATE);
				//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
		    	list.add(new Reportclass(rs_candidateDetails.getString(StringUtils.EMPID),rs_candidateDetails.getString(StringUtils.EMPNAME),rs_candidateDetails.getString(StringUtils.EMPDATE),rs_candidateDetails.getString(StringUtils.DB_STATUS)));
		 		}
				}catch (Exception e) {
			}
				 con.close();

		return list;
	}
	

	
	
	// get on specified date 
	public ArrayList<Reportclass> getDetailDate(String empName, String date) throws SQLException
	{
		
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();
		Connection  con = null;
		try{
			con= getConnection();
			PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getrepNameDate);
			stm.setString(1, empName);
			stm.setString(2, date);
			ResultSet rs_candidateDetails = stm.executeQuery();
			while (rs_candidateDetails.next())
		 		{
				
				String date1 = rs_candidateDetails.getString(StringUtils.EMPDATE);
				//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
				list.add(new Reportclass(rs_candidateDetails.getString(StringUtils.EMPID),rs_candidateDetails.getString(StringUtils.EMPNAME),rs_candidateDetails.getString(StringUtils.EMPDATE),rs_candidateDetails.getString(StringUtils.DB_STATUS)));
		 		}
		 	}catch (Exception e) {
		}
			 con.close();

		return list;
	}
	
	
	// day report
	public ArrayList<Reportclass> getDayReport(String date) throws SQLException
	{
		
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();
		Connection  con = null;
		try{
			con= getConnection();
			PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getDayReport);
			stm.setString(1, date);
			ResultSet rs_candidateDetails = stm.executeQuery();
			while (rs_candidateDetails.next())
		 		{	
				
				String date1 = rs_candidateDetails.getString(StringUtils.EMPDATE);
				//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
				list.add(new Reportclass(rs_candidateDetails.getString(StringUtils.EMPID),rs_candidateDetails.getString(StringUtils.EMPNAME),rs_candidateDetails.getString(StringUtils.EMPDATE),rs_candidateDetails.getString(StringUtils.DB_STATUS)));
		 		}
		 	}catch (Exception e) {
		}
			 con.close();

		return list;
	}
	
	
	
	
	
	//individual all report
	public ArrayList<Reportclass> getIndiReport(String empName) throws SQLException
	{
		String empid1 ;
		String empname1;
		String date1;
		String status1;
		double count=0;
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();
		Connection  con = null;
		try{
			con= getConnection();
			PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getIndiReport);
			stm.setString(1, empName);
			ResultSet rs_candidateDetails = stm.executeQuery();
			while (rs_candidateDetails.next())
		 		{	
				empid1= rs_candidateDetails.getString(StringUtils.EMPID);
				empname1=rs_candidateDetails.getString(StringUtils.EMPNAME);
				date1= rs_candidateDetails.getString(StringUtils.EMPDATE);
				status1=rs_candidateDetails.getString(StringUtils.DB_STATUS);
				 
				if(status1.equalsIgnoreCase(StringUtils.ABSENT)){
				  count++;
				}
				
				//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
				list.add(new Reportclass(empid1, empname1, date1, status1));
		 		}
		 	}catch (Exception e) {
		}
		 	
		 succeess_Rate = (double) ((list.size()-count)/list.size())*100;
		 succeess_Rate = Math.ceil(succeess_Rate);
		 con.close();

		return list;
	}
	
	
	
	// spec report
	public ArrayList<Reportclass> getSpecReport(String status) throws SQLException{
		
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();
		Connection  con = null;
		try{
			con= getConnection();
			PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getSpecReport);
			stm.setString(1, status);
			ResultSet rs_candidateDetails = stm.executeQuery();
			while (rs_candidateDetails.next())
		 		{
				
				String date1 = rs_candidateDetails.getString(StringUtils.EMPDATE);
				//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
				list.add(new Reportclass(rs_candidateDetails.getString(StringUtils.EMPID),rs_candidateDetails.getString(StringUtils.EMPNAME),rs_candidateDetails.getString(StringUtils.EMPDATE),rs_candidateDetails.getString(StringUtils.DB_STATUS)));
		 		}
		 	}catch (Exception e) {
		}
			 con.close();

		return list;
	}
	
	
	
	
	
	// day status
	public ArrayList<Reportclass> getSpecDayStatus(String status, String date) throws SQLException{
		
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();
		Connection  con = null;
		try{
			con= getConnection();
			PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getSpecDayStatus);
			stm.setString(1, status);
			stm.setString(2, date);
			ResultSet rs_candidateDetails = stm.executeQuery();
			while (rs_candidateDetails.next())
		 		{
				String date1 = rs_candidateDetails.getString(StringUtils.EMPDATE);
				//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
				list.add(new Reportclass(rs_candidateDetails.getString(StringUtils.EMPID),rs_candidateDetails.getString(StringUtils.EMPNAME),rs_candidateDetails.getString(StringUtils.EMPDATE),rs_candidateDetails.getString(StringUtils.DB_STATUS)));
		 		}
		 	}catch (Exception e) {
		}
			 con.close();

		return list;
		
	}
	
	
	
	
	// get individual month report
	
	public ArrayList<Reportclass> getIndiMonthlyReport(String month,String year, String name) throws SQLException
	{
		String empid1 ;
		String empname1;
		String date1;
		String status1;
		double count=0;
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();
		Connection  con = null;
		try{
			con= getConnection();
			PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getIndiMonthReport);
		  	stm.setString(1, "%"+year+"-"+month+"%");	//%2012-01%		
		  	stm.setString(2, name);
		  	ResultSet rs_candidateDetails = stm.executeQuery();
		  	while (rs_candidateDetails.next())
		  		{
		  		empid1= rs_candidateDetails.getString(StringUtils.EMPID);
		  		empname1=rs_candidateDetails.getString(StringUtils.EMPNAME);
		  		date1= rs_candidateDetails.getString(StringUtils.EMPDATE);
		  		status1=rs_candidateDetails.getString(StringUtils.DB_STATUS);
		  		if(status1.equalsIgnoreCase(StringUtils.ABSENT)){
				  count++;
		  		}
		  		
		  		//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
		  		
		  		list.add(new Reportclass(empid1, empname1, date1, status1));
		  		}
		 	}catch (Exception e) {
		 	}
		 	
		 	
		 	attended = (int)count;
		 	monthDays = list.size();
		 	succeess_Rate = (double) ((list.size()-count)/list.size())*100;
			succeess_Rate = Math.ceil(succeess_Rate);

			 con.close();

		return list;
	}
	
	
	
	
	// monthly report
	public ArrayList<Reportclass> getMonthlyReport(String month,String year) throws SQLException
	{
		String empid1 ;
		String empname1;
		String date1;
		String status1;
		double count=0;
		
		ArrayList<Reportclass> list = new ArrayList<Reportclass>();		
		Connection  con = null;
		 try{
			 con= getConnection();
			 PreparedStatement stm =  con.prepareStatement(SQLutilConstants.getMonthReport);
			 stm.setString(1, "%"+year+"-"+month+"%");	//%2012-01%		  
			 ResultSet rs_candidateDetails = stm.executeQuery();
			 while (rs_candidateDetails.next())
		 		{	
				empid1= rs_candidateDetails.getString(StringUtils.EMPID);
				empname1=rs_candidateDetails.getString(StringUtils.EMPNAME);
				date1= rs_candidateDetails.getString(StringUtils.EMPDATE);
				status1=rs_candidateDetails.getString(StringUtils.DB_STATUS);
				
				if(status1.equalsIgnoreCase(StringUtils.ABSENT)){
				  count++;
				}
				
				
				//reverse the date
				String[] dateRev = new String[3];
		  		StringTokenizer reverse = new StringTokenizer(date1, "-");
		  			int i=0;
		  		while(reverse.hasMoreTokens()){
		  			dateRev[i]=reverse.nextToken();
		  			i++;
		  			}
		  		date1= dateRev[2]+"-"+dateRev[1]+"-"+dateRev[0];
		  		//End of reverse
		  		
		  		
				list.add(new Reportclass(empid1, empname1, date1, status1));
		 		}
		 	}catch (Exception e) {
		}
		 	
		 	attended = (int)count;
		 	monthDays = list.size();
		 	succeess_Rate = (double) ((list.size()-count)/list.size())*100;
			succeess_Rate = Math.ceil(succeess_Rate);
			con.close();

		return list;
	}	
}
