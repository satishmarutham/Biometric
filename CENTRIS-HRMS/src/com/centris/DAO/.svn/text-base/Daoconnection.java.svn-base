package com.centris.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import com.centris.util.JPropertyReader;
import com.centris.util.StringUtils;

public class Daoconnection {

	public static Connection conn = null;
	public static java.sql.Statement st=null;

	public static String username;
	public static String password;



	
	public void dbConn() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	
	
		  String url = JPropertyReader.getProperty(StringUtils.HOST_NAME);
		  String dbName = JPropertyReader.getProperty(StringUtils.DATABASE_NAME); 
		  String driver = JPropertyReader.getProperty(StringUtils.DATABASE_DRIVERNAME);
		  String userName = JPropertyReader.getProperty(StringUtils.USER_NAME); 
		  String dbpassword = JPropertyReader.getProperty(StringUtils.USER_PASSWORD); 
		  
		  
		  try{
			  Class.forName(driver).newInstance();
 		  
			  conn=DriverManager.getConnection(url+dbName,userName,dbpassword);
 			 
		  }
			
			  catch(Exception e){
				  e.printStackTrace();
				  
			  }		  
	}
	}
