package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.LeaveDetailsReportVo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LeaveDetailsReport;
import com.centris.util.constants.MessageConstants;

public class LeaveDetailsReportDaoImpl extends DBService{
	
	private static Logger logger = Logger.getLogger(AttendenceApprovelDaoImpl.class);
	

public  ArrayList<EmployeeReportPojo> getEmployees(ArrayList<ManagerReportPojo> mgr_list,ArrayList<ProjectReportPojo> pjt_list,ArrayList<DepartMentReportPojo> dept_list,ArrayList<DesignationReportPojo> des_list) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in LeaveDetailsReportDaoImpl: getEmployees : Starting");
	
	PreparedStatement ps_emp = null;
	ResultSet rs_emp = null;
	Connection connection = null;
	ArrayList<EmployeeReportPojo> employee_list=new ArrayList<EmployeeReportPojo>();
	boolean status=false;
	String query=null;
	boolean mgr_status=false;
	boolean pjt_status=false;
	boolean dept_status=false;

	try {
		
		connection=getConnection();
		
		String manager_con="";
		
	if(!("all".equalsIgnoreCase(mgr_list.get(0).getMgr_id()))){
		
		status=true;
		
		mgr_status=true;
		
		String mgr_string="";
		
		for (ManagerReportPojo mgr_pojo : mgr_list)
		{
			mgr_string += mgr_pojo.getMgr_id() + ",";
		}
			
			mgr_string = mgr_string.substring(0, mgr_string.length() - 1);
		
			String manager="'"+mgr_string.replaceAll(",","','")+"'";
			
			 manager_con=" ManagerCode in ("+manager+")";
		}
	
	String project_con="";
	
	if(!("all".equalsIgnoreCase(pjt_list.get(0).getProjectid()))){
		
		status=true;
		pjt_status=true;
		String pjt_string="";
		
		for (ProjectReportPojo pjt_pojo : pjt_list)
		{
			pjt_string += pjt_pojo.getProjectid() + ",";
		}
		
		pjt_string = pjt_string.substring(0, pjt_string.length() - 1);
		
		String project="'"+pjt_string.replaceAll(",","','")+"'";
		
		if(mgr_status){
		 project_con=" and ProjectCode in ("+project+")";
		}else{
			
			 project_con=" ProjectCode in ("+project+")";
		}
	}
	
	String department_con="";
	if(!("all".equalsIgnoreCase(dept_list.get(0).getDeptid()))){
		
		status=true;
		dept_status=true;
		String dept_string="";
		
		for (DepartMentReportPojo dept_pojo : dept_list)
		{
			dept_string += dept_pojo.getDeptid() + ",";
		}
		
		dept_string = dept_string.substring(0, dept_string.length() - 1);
		
		String department="'"+dept_string.replaceAll(",","','")+"'";
		if(mgr_status || pjt_status){
		department_con=" and DEPT_ID in ("+department+")";
		}else{
			
			department_con=" DEPT_ID in ("+department+")";
		}
	}
	
	String designation_con="";
	if(!("all".equalsIgnoreCase(des_list.get(0).getDesig_id()))){
		
		status=true;
		
		String des_string="";
		
		for (DesignationReportPojo des_pojo : des_list)
		{
			des_string += des_pojo.getDesig_id() + ",";
		}
		
		des_string = des_string.substring(0, des_string.length() - 1);
		
		String designation="'"+des_string.replaceAll(",","','")+"'";
		if(mgr_status || pjt_status || dept_status){
		designation_con=" and DesignationCode in ("+designation+")";
		}else{
			
			designation_con=" DesignationCode in ("+designation+")";
		}
	}
	
	if(status){
	 query="select EMPID,First_Name from hrms_employee where"+manager_con+project_con+department_con+designation_con;
	
	}else{
		
		 query="select EMPID,First_Name from hrms_employee";
	}
	
	
	ps_emp = connection.prepareStatement(query);
 
	rs_emp=ps_emp.executeQuery();
	
	while(rs_emp.next()){
		
		EmployeeReportPojo emp_pojo=new EmployeeReportPojo();
		
		emp_pojo.setEmpid(rs_emp.getString("EMPID"));
		emp_pojo.setEmp_name(rs_emp.getString("First_Name"));
		
		employee_list.add(emp_pojo);
	}

	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs_emp != null && (!rs_emp.isClosed())) {

				rs_emp.close();
			}
			if (ps_emp != null && (!ps_emp.isClosed())) {

				ps_emp.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in LeaveDetailsReportDaoImpl: getEmployees : Ending");
	
	return employee_list;

}

public  ArrayList<LeaveDetailsReportVo> getLeaveDetails(String[] emp_array) {
	
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in LeaveDetailsReportDaoImpl: getLeaveDetails : Starting");
	
	PreparedStatement ps_leave=null;
	ResultSet rs_leave=null;
	Connection connection=null;

	PreparedStatement ps_leavecount=null;
	ResultSet rs_leave_count=null;
	double total_no_of_leaves=0;
	
	
	
	ArrayList<LeaveDetailsReportVo> leave_list=new ArrayList<LeaveDetailsReportVo>();
	java.sql.Date currentdate=HelperClass.getCurrentSqlDate();
	
	
	try {
		connection=getConnection();
		
	
		
		String currentyear=HelperClass.getCurrentYear();
		
		ps_leavecount=connection.prepareStatement(LeaveDetailsReport.GET_NO_OF_LEAVES);
		ps_leavecount.setString(1, currentyear);
		
		rs_leave_count=ps_leavecount.executeQuery();
		
		while(rs_leave_count.next()){
			
			total_no_of_leaves=rs_leave_count.getDouble("allowed_per_month");
			//total_no_of_leaves=rs_leave_count.getDouble("total_leaves");
		}
	
	
		ps_leave=connection.prepareStatement(LeaveDetailsReport.GET_LEAVEDETAILS_REPORT);
		
		for(int i=0;i<emp_array.length;i++){
			
			
			int tot_taken_leaves=0;
			int jan=0;
			int feb=0;
			int mar=0;
			int aprl=0;
			int may=0;
			int june=0;
			int july=0;
			int aug=0;
			int sep=0;
			int oct=0;
			int nov=0;
			int dec=0;
			String jan_str=null;
			String feb_str=null;
			String mar_str=null;
			String aprl_str=null;
			String may_str=null;
			String june_str=null;
			String july_str=null;
			String aug_str=null;
			String sep_str=null;
			String oct_str=null;
			String nov_str=null;
			String dec_str=null;
			String[] date_of_join=new String[10];
		
		ps_leave.setString(1, emp_array[i]);
		ps_leave.setDate(2, currentdate);
		
		rs_leave=ps_leave.executeQuery();
		
		System.out.println("ps_leave"+ps_leave);
		
		
		LeaveDetailsReportVo leave_vo=new LeaveDetailsReportVo();
		while(rs_leave.next()){
			
			
			leave_vo.setEmpid(rs_leave.getString("bioid"));
			leave_vo.setStatus(rs_leave.getString("Employee_Status"));
			leave_vo.setEmpname(rs_leave.getString("First_Name"));
			leave_vo.setDoj(HelperClass.converDateDDMMMYYYY(rs_leave.getString("DOJ")));
			
			
			date_of_join=rs_leave.getString("DOJ").split("-");
			
			if(rs_leave.getString("Attendence_Date")!=null){
			String[] att_date=rs_leave.getString("Attendence_Date").split("-");
			String monthfullname=HelperClass.getMonthFullName(att_date[1]);
			
			
			if("January".equalsIgnoreCase(monthfullname)){
				
				jan++;
				tot_taken_leaves++;
				
			}else if("February".equalsIgnoreCase(monthfullname)){
				
				feb++;
				tot_taken_leaves++;
			}else if("March".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				mar++;
			}else if("April".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				aprl++;
			}else if("May".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				may++;
			}else if("June".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				june++;
			}else if("July".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				july++;
			}else if("August".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				aug++;
			}else if("September".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				sep++;
			}else if("October".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				oct++;
			}else if("November".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				nov++;
			}else if("December".equalsIgnoreCase(monthfullname)){
				tot_taken_leaves++;
				dec++;
			}
			}
			
			
		}
		
		
		if(date_of_join[0].endsWith(HelperClass.getCurrentYear())){
		for(int j=0;j<Integer.parseInt(date_of_join[1]);j++){
			
			if(j==1){
				
				jan_str="NA";
			}
			if(j==2){
				
				feb_str="NA";
			}
			if(j==3)
			{
				mar_str="NA";
			}
			if(j==4)
			{
				aprl_str="NA";
			}
			if(j==5)
			{
				may_str="NA";
			}
			if(j==6)
			{
				june_str="NA";
			}
			if(j==7)
			{
				july_str="NA";
			}
			if(j==8)
			{
				aug_str="NA";
			}
			if(j==9)
			{
				sep_str="NA";
			}
			if(j==10)
			{
				oct_str="NA";
			}
			if(j==11)
			{
				nov_str="NA";
			}
			if(j==12)
			{
				dec_str="NA";
			}
			
		}
		}
		if("NA".equalsIgnoreCase(jan_str)){
			leave_vo.setJan(jan_str);
	
		}else{
			leave_vo.setJan(jan+"");
		}
		if("NA".equalsIgnoreCase(feb_str)){
			
			leave_vo.setFeb(feb_str);
			
			}else{
				
				leave_vo.setFeb(feb+"");
				
			}
		if("NA".equalsIgnoreCase(mar_str)){
			
			leave_vo.setMar(mar_str);
			
			}else{
				
				leave_vo.setMar(mar+"");
				
			}
		if("NA".equalsIgnoreCase(aprl_str)){
			leave_vo.setAprl(aprl_str);
			}else{
				leave_vo.setAprl(aprl+"");
				
			}
		if("NA".equalsIgnoreCase(may_str)){
			leave_vo.setMay(may_str);
			}else{
				leave_vo.setMay(may+"");
			
			}
		if("NA".equalsIgnoreCase(june_str)){
			leave_vo.setJune(june_str);
			}else{
				leave_vo.setJune(june+"");
				
			}
		if("NA".equalsIgnoreCase(july_str)){
			
			leave_vo.setJuly(july_str);
			
			}else{
				leave_vo.setJuly(july+"");
			}
		if("NA".equalsIgnoreCase(aug_str)){
			leave_vo.setAug(aug_str);
			
			}else{
				leave_vo.setAug(aug+"");
			}
		if("NA".equalsIgnoreCase(sep_str)){
			
			leave_vo.setSep(sep_str);
			
			}else{
				
				leave_vo.setSep(sep+"");
			}
		if("NA".equalsIgnoreCase(oct_str)){
			leave_vo.setOct(oct_str);
			}else{
				leave_vo.setOct(oct+"");
				
			}
		if("NA".equalsIgnoreCase(nov_str)){
			
			leave_vo.setNov(nov_str);
			
			}else{
				
				leave_vo.setNov(nov+"");
			}
		if("NA".equalsIgnoreCase(dec_str)){
			
			leave_vo.setDec(dec_str);
			
			}else{
				
				leave_vo.setDec(dec+"");
			}
	
		
		double leaves=(Double.parseDouble(HelperClass.getCurrentMonth())*total_no_of_leaves)-tot_taken_leaves;
		leave_vo.setBalance(leaves);
		
		leave_list.add(leave_vo);
	
		
		}
		
	
	
	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs_leave != null && (!rs_leave.isClosed())) {

				rs_leave.close();
			}
			if (rs_leave_count != null && (!rs_leave_count.isClosed())) {

				rs_leave_count.close();
			}
			if (ps_leave != null && (! ps_leave.isClosed())) {

				 ps_leave.close();
			}
			if (ps_leavecount != null && (! ps_leavecount.isClosed())) {

				ps_leavecount.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	JSONArray array = new JSONArray(leave_list);
	System.out.println("array"+array);
	
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in LeaveDetailsReportDaoImpl: getLeaveDetails : Ending");
	
	
	
	return leave_list;
}

}
