package com.centris.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/*import com.sun.jmx.snmp.Timestamp;*/

public class TodayReportFromAccess {

	public TodayReportFromAccess() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */

	public Map getTodaysLogsFromAccess() {

		Map empMap = null;

		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 System.out.println("-- inside UTIL before ");
		Connection connection=null;
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datee = sdf.format(dt);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 connection = DriverManager
					.getConnection("jdbc:odbc:bio1");
			
			 System.out.println("-- inside UTIL");
			 
			 if(connection!=null){
				 System.out.println(" connection established");
			 }else{
				 System.out.println(" connection not established");
			 }
			Statement statement = connection.createStatement();
//			
			ResultSet rs = statement.executeQuery("select chk.USERID,chk.CHECKTIME,chk.CHECKTYPE,usrinfo.USERID,usrinfo.Badgenumber  from CHECKINOUT chk,USERINFO usrinfo where chk.USERID=usrinfo.USERID and  DATE(chk.CHECKTIME) = '"+ datee + "'  order by chk.USERID,chk.CHECKTIME");
			System.out.println(statement.toString());
//			
			String id, dateTimeToken;

			String date1 = null;
			String time = null;

			empMap = new HashMap<String, ArrayList>();

			ArrayList<Emp> al = new ArrayList<Emp>();
			Emp e = null;
			while (rs.next()) {
				
				id = rs.getString("Badgenumber");
				dateTimeToken = rs.getString("CHECKTIME");
				StringTokenizer dateTime = new StringTokenizer(dateTimeToken);
				while (dateTime.hasMoreTokens()) {

					date1 = dateTime.nextToken().trim();
					time = dateTime.nextToken().trim();
					if (e == null) {
						
						e = new Emp();
						e.setDate(date1);
						e.setEmpno(id);
						e.setTime(time);
						al.add(e);
						
						e = null;
						e = new Emp();
						e.setEmpno(id);

					} else {

						if (id.equalsIgnoreCase(e.getEmpno())) {

							e.setDate(date1);
							e.setEmpno(id);
							e.setTime(time);
							al.add(e);
							
							e = null;
							e = new Emp();
							e.setEmpno(id);

						} else {

							empMap.put(Integer.parseInt(e.getEmpno())+"", al);
							// dispalyMap(empMap);
							
							// new TodayReportFromAccess().dispalyMap(empMap);
							al = null;
							al = new ArrayList<Emp>();
							e = new Emp();
							e.setDate(date1);
							e.setEmpno(id);
							e.setTime(time);
							al.add(e);
						}
					}
				}
			}
			if (e == null) {
				
			} else {
				empMap.put(Integer.parseInt(e.getEmpno())+"", al);
				dispalyMap(empMap);
				
				// new TodayReportFromAccess().dispalyMap(empMap);

				
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			if(connection==null)
			{
				return null;
			}		
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		dispalyMap(empMap);
		return empMap;
	}

	public void dispalyMap(Map empMap) {
		
		System.out.println(" DISPLAY "+empMap.size());
		if (empMap.size() > 0) {
			Iterator it = empMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry) it.next();
				
				ArrayList<Emp> al1 = (ArrayList<Emp>) pairs.getValue();
				System.out.println("Key::"+pairs.getKey());
				for (Iterator iterator = al1.iterator(); iterator.hasNext();) {
					Emp emp = (Emp) iterator.next();
					System.out.println(emp.getDate() +" -- "+emp.getEmpno()+" -- "+emp.getTime());
				}
			}
		}
		
	}
}