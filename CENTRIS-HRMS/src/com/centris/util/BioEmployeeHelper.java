package com.centris.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.centris.DAO.DBService;
import com.centris.util.SQLUtils.SQLutilConstants;



public class BioEmployeeHelper extends DBService{
	String dateTimeToken=null;
	private String date;
	private String time;
	private String id; 	 
	private static PreparedStatement stat,stat2 ;
	private static Statement stat1;
	private static String dateFromAudit="";
	private static String dateNow;
	private static ArrayList<String> EmpIDTotalList = new ArrayList<String>();
	private static ArrayList<String> EmpIDList = new ArrayList<String>();
	private static ArrayList<String> dateList = new ArrayList<String>(); 
	private static ArrayList<BioEmployeeHelper> list = new ArrayList<BioEmployeeHelper>();
 	static long graceTime;
	static long outGraceTime;
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	static Calendar cal = Calendar.getInstance();

	public BioEmployeeHelper(String date, String time, String id) {
		super();
		this.date = date;
		this.time = time;
		this.id = id;
	}	
	public BioEmployeeHelper(){
	}

	public void getMSACESSData() throws Exception{

		String date1 = null;
		String time = null;
		String id = null;
		String flag =null;
		

		Connection con= getConnection();
		stat = con.prepareStatement(SQLutilConstants.SHIFT_MAX_LOGAUDIT);

		System.out.println("Shift Max Audit::"+stat);
		ResultSet getDate = stat.executeQuery();
		

		while(getDate.next())
			dateFromAudit=getDate.getString(1);
           
		stat.close();

		
		// change the date format
		String spi[] = dateFromAudit.split("-");
		dateFromAudit = spi[0]+"/"+spi[1]+"/"+spi[2];		
		

		// assign to checkdate 
		Date CheckDate = new Date(dateFromAudit);

		System.out.println("Check Date"+CheckDate);
		// today's date
		Calendar currentDate = Calendar.getInstance();
//		currentDate.set(2014, 06, 29);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
		dateNow = formatter.format(currentDate.getTime());

 

		try{

			stat = con.prepareStatement(SQLutilConstants.INSERT_LOGAUDIT);

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connection=DriverManager.getConnection("jdbc:odbc:bio");
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select chk.USERID,chk.CHECKTIME,chk.CHECKTYPE,usrinfo.USERID,usrinfo.Badgenumber  from CHECKINOUT chk,USERINFO usrinfo where chk.USERID=usrinfo.USERID  order by chk.USERID");
//			ResultSet rs=statement.executeQuery("select UserId,LogDate from DeviceLogs order by LogDate ");
System.out.println("Access:::::::::::::::::::");
System.out.println(statement);
			while(rs.next())
			{      
				
 				id = rs.getString("Badgenumber");
				dateTimeToken=rs.getString("CHECKTIME");
				StringTokenizer dateTime = new StringTokenizer(dateTimeToken);
				while(dateTime.hasMoreTokens()){

					date1=dateTime.nextToken().trim();
					time=dateTime.nextToken().trim();
				}

				flag =rs.getString("CHECKTYPE"); 
				Date endDate = new Date(dateNow);

				String[] spi2 = date1.split("-");
				date1 = spi2[0]+"/"+spi2[1]+"/"+spi2[2];
				Date gettinDate = new Date(date1);
				
				
				
				System.out.println("gettinDate::::::::"+gettinDate);
				System.out.println("endDate:::"+endDate);
				System.out.println(CheckDate.before(gettinDate) && endDate.after(gettinDate));
				if(CheckDate.before(gettinDate) && endDate.after(gettinDate)){
					
					list.add(new BioEmployeeHelper(date1, time, id));
					System.out.println("Adding Data:");

				}
			}
 



		}catch (Exception e){ 
			
			e.printStackTrace();
		}finally{


		}

		try{
			// data is inserted through this function
              
			insertData(list);

			// pick the inserted dates..

			pickDates();


			for(String da : dateList){
				
				
			}


			//pickDistinctID();

		}catch (Exception e) {
			e.printStackTrace();	
		}

	}



	public static void insertData(ArrayList<BioEmployeeHelper> list) throws Exception{

		Iterator< BioEmployeeHelper> it = list.iterator();


		try
		{ 
			while(it.hasNext()){
				
				
				
 				BioEmployeeHelper getDataList = it.next();
                
 				stat.setString(1,getPerfectNumber(getDataList.id));				
				stat.setString(2, getDataList.date);
				stat.setString(3, getDataList.time); 
				stat.setString(4, dateFormat.format(cal.getTime())); 
				
				stat.executeUpdate();
 			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		finally{

			stat.close();
		}
	}
	//********************************BY Arul**********************
	public static String getPerfectNumber(String value) {
		Double empOpeningBalance = Double.valueOf(value);
		if (empOpeningBalance % 2 == 0) {
			Integer empOpBal = empOpeningBalance.intValue();
			return empOpBal.toString();
		} else if ((empOpeningBalance % 2 != 0)
				&& (empOpeningBalance.toString().endsWith(".5"))) {
			return empOpeningBalance.toString();
		} else {
			Integer empOpBal = empOpeningBalance.intValue();
			return empOpBal.toString();
		}
	}
	//*******************************************************INSERT COMPLETED**********************
	public void pickDates() throws SQLException
	{
		try{
			Connection con= getConnection();
			stat = con.prepareStatement(SQLutilConstants.LOGMAX_DATE_PICK);

			stat.setString(1, dateFromAudit);
			ResultSet getDates = stat.executeQuery();

			while(getDates.next()){
              
				dateList.add(getDates.getDate("AI_EMP_DATE").toString());
			}


			stat.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void pickTotalID() throws Exception{
		EmpIDTotalList.clear();

		Connection con= getConnection();
		stat = con.prepareStatement(SQLutilConstants.SELECT_EMPID);
		ResultSet totalId = stat.executeQuery();
		while(totalId.next()){

			EmpIDTotalList.add(totalId.getString("empid"));
		}

		stat.close();

	}


	public void updateAuditData() throws Exception{



		/* audit table should be modified.. should get date from the table ai_bio_log_details then insert
		 * 
		 * insert using the condition where date should less then todays and greater then  max of the today date
		 */

		Connection con= getConnection();
		stat = con.prepareStatement(SQLutilConstants.UPDATE_AUDITENTRY);

		for(String e : dateList){
			stat.setString(1, e);
			stat.setString(2, "success");
			stat.setString(3, dateFormat.format(cal.getTime()));
			stat.executeUpdate();
		}

		stat.close();

	}



	public void calculateTimeSheet() throws Exception{

		String inTime;
		String outTime;
		int lengthOfTransaction;
		long totalWorkingHours;
		Connection con= getConnection();
		Statement  sqlStatement = con.createStatement();

		ArrayList<String> availableTime = new ArrayList<String>();

		// 
		int inCount=0;
		int outCount=0;


		try{
	//****************************************************************************************************//
				// date list is already get while inserting the data into database from msaccess
			for(String date : dateList){

				// pick distinct ID's on particular date..
				stat = con.prepareStatement(SQLutilConstants.SELECT_EMP_LOG_COMPARISION);

				stat.setString(1, date);
				ResultSet disID = stat.executeQuery();


				while(disID.next()){

					EmpIDList.add(disID.getString("EMPID"));

				}

				stat.close();	
				// end distinct ID's ...



				try{
					
					// query to mark attendance on specified day
					stat = con.prepareStatement(SQLutilConstants.BIO_ATTANCANCE_INSERT);
					stat1 = con.createStatement();


					String name = null;
					
					
					for(String e : EmpIDList){	

						
						// get shift timings..
		// WARNING:				// no use getting shift timings here coz it will b changing everytime when ID changes
												
		// WARNING ENDS

						// get the empName for particular ID..
						ResultSet rs = stat1.executeQuery(SQLutilConstants.SELECT_EMPNAME+e.trim()+"'");
						while(rs.next()) {
							name = rs.getString("EMPNAME");	 
							name.trim();
						}

						stat.setString(1, e);
						stat.setString(2, name);
						stat.setString(3, "present");
						stat.setString(4, date);
						stat.executeUpdate();
						EmpIDTotalList.remove(e);
					}



					for(String absent : EmpIDTotalList ){

						ResultSet rs = stat1.executeQuery(SQLutilConstants.SELECT_EMPNAME+absent.trim()+"'");
						while(rs.next()) {
							name = rs.getString("EMPNAME");							
							name.trim();
						}
						stat.setString(1, absent);
						stat.setString(2, name);
						stat.setString(3, "absent");
						stat.setString(4, date);
						stat.executeUpdate();

					}



				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}


				stat.close();
				stat1.close();
				
// **************** end marking attendance **********************************				
				
				// prepare the time sheet for specified date n number of empID..

				for(String empID : EmpIDList){
					
					stat2 = con.prepareStatement("SELECT  ai_emp_details.EMPID, ai_emp_details.SHIFT_ID,ai_shift_deatails.AI_SHIFT_LTOC,ai_shift_deatails.AI_SHIFT_ETOG FROM ai_emp_details, ai_shift_deatails where ai_emp_details.SHIFT_ID=ai_shift_deatails.AI_SHIFT_ID and ai_emp_details.EMPID='"+empID+"'");
					ResultSet rs1 =stat2.executeQuery();

					while(rs1.next()){								 

						graceTime =  Time.valueOf(rs1.getString("AI_SHIFT_LTOC")).getTime();
						outGraceTime =(Time.valueOf(rs1.getString("AI_SHIFT_ETOG")).getTime());

					}	
					
					String query = "select AI_EMP_TIME from ai_bio_log_details where AI_EMP_ID = '"+empID+"' and AI_EMP_DATE ='"+date+"' ORDER BY AI_EMP_TIME";
					ResultSet rs = sqlStatement.executeQuery(query);					

					while(rs.next()){	
						availableTime.add(rs.getString("AI_EMP_TIME"));										
					}


					availableTime.trimToSize();
					// calculating in and out  time 
					lengthOfTransaction = availableTime.size();
					inTime = availableTime.get(0);
					outTime= availableTime.get(lengthOfTransaction-1);


					// total time
					totalWorkingHours= (Time.valueOf(availableTime.get(0)).getTime())-(Time.valueOf(availableTime.get(lengthOfTransaction-1)).getTime());


					// remove the negative n make it positive..
					if(totalWorkingHours<0) totalWorkingHours = totalWorkingHours*(-1);

					

					// pass the available time to calculate..
					long timeWorked = timeSplit(availableTime);

					availableTime.clear(); 

					Time total = new Time(totalWorkingHours);
					adjustBaseTime(total);

					Time worked = new Time(timeWorked);

					adjustBaseTime(worked);



					long mornTime = (Time.valueOf(inTime).getTime());
					long eveTime = (Time.valueOf(outTime).getTime());
					String latetime=null;
					String earlytime=null;
					if(graceTime<mornTime){

						inCount=1;
						 long seconds=((mornTime-graceTime)/1000);
						 long lhours=seconds/3600;
						 long min=seconds%3600;
						 long lmin1 = min/60;
						 long lsec = min%60;
						 
						 String hours=(lhours+"").length()>1?(lhours+""):"0"+lhours;
						 String min1=(lmin1+"").length()>1?(lmin1+""):"0"+lmin1;
						 String sec=(lsec+"").length()>1?(lsec+""):"0"+lsec;
						 latetime= hours+":"+min1+":"+sec;
						 
					}else{
						inCount=0;
						 latetime= "00:00:00";
					}

					if(outGraceTime>eveTime){

						outCount=1;
						
						 long seconds=((outGraceTime-eveTime)/1000);
						 long lhours=seconds/3600;
						 long min=seconds%3600;
						 long lmin1 = min/60;
						 long lsec = min%60;
						 
						 String hours=(lhours+"").length()>1?(lhours+""):"0"+lhours;
						 String min1=(lmin1+"").length()>1?(lmin1+""):"0"+lmin1;
						 String sec=(lsec+"").length()>1?(lsec+""):"0"+lsec;
						 earlytime= hours+":"+min1+":"+sec;
					}else{

						outCount=0;
						 earlytime="00:00:00";
					}

					

					// insert here in database
					String insertTimeSheet = "insert into ai_bio_timesheet(EMP_ID,ATTENDANCE_DATE,IN_TIME,OUT_TIME,TOTAL_HOURS,TOTAL_WORKING_HOURS,MORNING_LATE,EVENING_EARLY,LATE_TIME,EARLY_TIME) values('"+empID+"', '"+ date +"', '"+ inTime +"','" +outTime+"','"+total+"','"+worked+"', "+inCount+","+outCount+",'"+latetime+"','"+earlytime+"' )";		
					System.out.println("timeSheet :::::::::::::::::::"+insertTimeSheet);
					sqlStatement.executeUpdate(insertTimeSheet);

				}

				pickTotalID();
				EmpIDList.clear();



			}



		}catch(Exception e){

		}


	}






	public static long timeSplit(ArrayList<String> listPass){


		long t1=0;
		long t2=0;		
		long timeLap = 0;

		if(listPass.size() == 0) return 0;





		// calculating time lap 
		int k=0, l=1;

		for(int i=0; i< listPass.size(); i++){

			if ((l>=(listPass.size()))) break;

			t1 =  Time.valueOf(listPass.get(k)).getTime();
			t2 =  Time.valueOf(listPass.get(l)).getTime(); 
			if(t1 < t2) timeLap = timeLap +  (t2-t1);


			k+=2;
			l+=2;
		}



		listPass.clear();


		return timeLap;
	}


	// Adjust the time to Indian timings
	static void adjustBaseTime(Time time){
		time.setHours(time.getHours() - 5);
		time.setMinutes(time.getMinutes() - 30);
		System.out.println(time);
	}


	// close the conection
	public void closeConnection() throws Exception{
		Connection con= getConnection();
		con.close();
	}

	public static void main(String[] args) {
		 long seconds=3787;
		 long lhours=seconds/3600;
		 long min=seconds%3600;
		 long lmin1 = min/60;
		 long lsec = min%60;
		 String hours=(lhours+"").length()>1?(lhours+""):"0"+lhours;
		 String min1=(lmin1+"").length()>1?(lmin1+""):"0"+lmin1;
		 String sec=(lsec+"").length()>1?(lsec+""):"0"+lsec;
		 System.out.println(hours+":"+min1+":"+sec);
		 
	}

}
