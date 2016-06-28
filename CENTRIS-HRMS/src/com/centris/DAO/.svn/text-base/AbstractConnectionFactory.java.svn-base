package com.centris.DAO;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import com.centris.util.JPropertyReader;
import com.centris.util.StringUtils;
public abstract class AbstractConnectionFactory {
	
		public static Connection getConnection() throws Exception {
			
			System.out.println(" getting Connection ");
			Connection conn = null;
			try {
				
			   String driverName = JPropertyReader.getProperty(StringUtils.DATABASE_DRIVERNAME);
				String hostName = JPropertyReader.getProperty(StringUtils.HOST_NAME); 
				String dbName = JPropertyReader.getProperty(StringUtils.DATABASE_NAME); 
				String dbuserName = JPropertyReader.getProperty(StringUtils.USER_NAME); 
				String dbpassword = JPropertyReader.getProperty(StringUtils.USER_PASSWORD); 
		 
			
				
				Class.forName(driverName).newInstance();
				conn = DriverManager.getConnection(hostName+dbName, dbuserName,dbpassword);
 

			} catch (SQLException e) {
				// TODO: handle exception
			 e.printStackTrace();
		
			}

			catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
					}
			
			
		    
			return conn;
			
		}	
		
		
public static Connection getLogConnection() throws Exception {
			
			System.out.println("");
			Connection conn = null;
			try {
				
			    String logdriverName = JPropertyReader.getProperty(StringUtils.DATABASE_DRIVERNAME);
				String loghostName = JPropertyReader.getProperty("LOGHOST_NAME"); 
				String logdbName = JPropertyReader.getProperty("Logdatabase"); 
				String logdbuserName = JPropertyReader.getProperty("logusername"); 
				String logdbpassword = JPropertyReader.getProperty("logpassword"); 
		 
			
				
				Class.forName(logdriverName).newInstance();
				conn = DriverManager.getConnection(loghostName+logdbName, logdbuserName,logdbpassword);
 

			} catch (SQLException e) {
				// TODO: handle exception
			 e.printStackTrace();
		
			}

			catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
					}
			
			
		    
			return conn;
			
		}	
	}
