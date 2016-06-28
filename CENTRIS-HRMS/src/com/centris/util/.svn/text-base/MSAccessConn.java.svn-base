package com.centris.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class MSAccessConn {
	public static void main(String[] args) throws Exception{
		//start
		String id= null;
		String dateTimeToken=null;
		String date =null;
		String time = null;
		String flag = null;
		//BioEmployee MSACESS helper
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connection=DriverManager.getConnection("jdbc:odbc:bio");
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from CHECKINOUT order by USERID");
			while(rs.next())
			{      
				id = rs.getString("USERID");
				dateTimeToken=rs.getString("CHECKTIME");
				StringTokenizer dateTime = new StringTokenizer(dateTimeToken);
				while(dateTime.hasMoreTokens()){
					date=dateTime.nextToken();
					time=dateTime.nextToken();
				}
				
				flag =rs.getString("CHECKTYPE");
				 
			}
			 
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		//end
		
	}

}
