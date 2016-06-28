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
import com.centris.DAO.TimesheetReportDao;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.VO.AttendanceTimeSheetReportVo;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendanceTimeSheetReport;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class TimeSheetReportDaoImpl extends DBService implements TimesheetReportDao {
	
private static Logger logger = Logger.getLogger(AttendenceApprovelDaoImpl.class);


	
	public  ArrayList<String> getAccYear() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getAccYear : Starting");
		
		PreparedStatement ps_acc_year = null;
		ResultSet rs_acc_year = null;
		Connection connection = null;
		ArrayList<String> year=new ArrayList<String>();

		try {
			connection = getConnection();
			
			ps_acc_year = connection.prepareStatement(AttendanceTimeSheetReport.GET_ACC_YEAR);
			
			rs_acc_year = ps_acc_year.executeQuery();

				while(rs_acc_year.next()){
					
					year.add(rs_acc_year.getString("AccadamicYear"));
					
				}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_acc_year != null && (!rs_acc_year.isClosed())) {

					rs_acc_year.close();
				}
				if (ps_acc_year != null && (!ps_acc_year.isClosed())) {

					ps_acc_year.close();
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
				+ " Control in AttendenceApprovelDaoImpl: getAccYear : Ending");
		
		return year;

	}
	
	public  ArrayList<EmployeeReportPojo> getEmployees(String[] empArray,Connection conn) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getEmployees : Starting");
		
		PreparedStatement ps_emp = null;
		ResultSet rs_emp = null;
		Connection connection = conn;
		ArrayList<EmployeeReportPojo> employee_list=new ArrayList<EmployeeReportPojo>();
	/*	boolean status=false;
		String query=null;
		boolean mgr_status=false;
		boolean pjt_status=false;
		boolean dept_status=false;*/

		try {
			
			String empIds=null;
			
			for(int i=0;i<empArray.length;i++){
							
							if(empIds==null){
								
								empIds=empArray[i];
							}else{
								
								empIds=empIds+","+empArray[i];
								
							}
						}
			String temp_emp= "'" +empIds.replaceAll(",", "','") + "'";
			
			ps_emp = connection.prepareStatement("select EMPID,First_Name,bioid from  hrms_employee where EMPID in ("+temp_emp+")");
			 
			rs_emp=ps_emp.executeQuery();
			
			while(rs_emp.next()){
				
				EmployeeReportPojo emp_pojo=new EmployeeReportPojo();
				
				emp_pojo.setEmpid(rs_emp.getString("EMPID"));
				emp_pojo.setEmp_name(rs_emp.getString("First_Name"));
				emp_pojo.setBoiid(rs_emp.getString("bioid"));
				
				employee_list.add(emp_pojo);
			}
			
			
			
			
			
			/*
			
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
		
		
		
			

		*/} catch (SQLException sqle) {
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
				+ " Control in AttendenceApprovelDaoImpl: getEmployees : Ending");
		
		return employee_list;

	}
	
	
	public  ArrayList<AttendanceTimeSheetReportVo> getTimesheetReport(ArrayList<EmployeeReportPojo> employee_list,String month,String year,Connection conn) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getTimesheetReport : Starting");
		
		PreparedStatement ps_emp = null;
		PreparedStatement ps_shrtname = null;
		ResultSet rs_emp = null;
		ResultSet rs_shrtname = null;
		Connection connection = conn;
		ArrayList<AttendanceTimeSheetReportVo> timesheet_list=new ArrayList<AttendanceTimeSheetReportVo>();
		ArrayList<String> ast=null;
		
		
		try {
			
			int total_no_of_days=HelperClass.getDaysByMonthAndYear(Integer.parseInt(month), Integer.parseInt(year));
			
			ps_emp=connection.prepareStatement(AttendanceTimeSheetReport.GET_TIMESHEET_REPORT);
			ps_shrtname=connection.prepareStatement(AttendanceTimeSheetReport.GET_SHORT_NAME);
			
			for(int i=0;i<employee_list.size();i++){
				
				int absent=0;
				int present=0;
				int weekoff=0;
				int holiday=0;
				int leave=0;
				
				
				AttendanceTimeSheetReportVo att_vo=new AttendanceTimeSheetReportVo();
				String empid=employee_list.get(i).getEmpid();
				String emp_name=employee_list.get(i).getEmp_name();
				String bioId=employee_list.get(i).getBoiid();
				ast=new ArrayList<String>();
				
				for(int j=1;j<=total_no_of_days;j++){
					
					ps_emp.setString(1, year+"-"+month+"-"+j);
					ps_emp.setString(2, employee_list.get(i).getEmpid());
			
			
			rs_emp=ps_emp.executeQuery();
			
			if(rs_emp.next()){
				
				
				
				if("N".equalsIgnoreCase(rs_emp.getString("isPosted")) && "N".equalsIgnoreCase(rs_emp.getString("isAproved"))){
					
				//String	str = "<span style=\"color:green;font-weight:bold;\">NN</span>";
					ast.add("NN");
					
					
					if("Absent".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
						
						absent++;
						
					}else
					if("Present".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
						
						present++;
					}else
					if("Leave".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
						
						leave++;
					}else
					if("Advance Leave".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
						
						leave++;
					}else
					if("Holiday".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
						
						holiday++;
					}else
					if("week off".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
						
						weekoff++;
					}else{
						
						absent++;
					}
					
				}else if("Y".equalsIgnoreCase(rs_emp.getString("isPosted")) && "N".equalsIgnoreCase(rs_emp.getString("isAproved"))){
				
					ps_shrtname.setString(1, year+"-"+month+"-"+j);
					ps_shrtname.setString(2, employee_list.get(i).getEmpid());
					
					
					rs_shrtname=ps_shrtname.executeQuery();
					
					while(rs_shrtname.next()){
						
						ast.add(rs_shrtname.getString("ShortName"));
						
						if("Absent".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							absent++;
						}
						if("Present".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							present++;
						}
						if("Leave".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							leave++;
						}
						if("Advance Leave".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							leave++;
						}
						if("Holiday".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							holiday++;
						}
						if("week off".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							weekoff++;
						}
						
					}
					
				}else if("Y".equalsIgnoreCase(rs_emp.getString("isPosted")) && "Y".equalsIgnoreCase(rs_emp.getString("isAproved"))){
					
					ps_shrtname.setString(1, year+"-"+month+"-"+j);
					ps_shrtname.setString(2, employee_list.get(i).getEmpid());
					
					
					rs_shrtname=ps_shrtname.executeQuery();
					
					while(rs_shrtname.next()){
						
						ast.add(rs_shrtname.getString("ShortName"));
						
						if("Absent".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							absent++;
						}
						if("Present".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							present++;
						}
						if("Leave".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							leave++;
						}
						if("Advance Leave".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							leave++;
						}
						if("Holiday".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							holiday++;
						}
						if("weeklyoff".equalsIgnoreCase(rs_emp.getString("Attedence_Status"))){
							
							weekoff++;
						}
						
						
					}
					
				}
				
				
			}else{
				
				ast.add("NA");
			}
			
			}
				
				att_vo.setTotaldays(total_no_of_days);
				att_vo.setWorkingdays(total_no_of_days-holiday-weekoff);
				att_vo.setPresentdays(present);
				att_vo.setPayabledays(present+holiday+leave+weekoff);
				att_vo.setStatus(ast);
				att_vo.setEmpid(empid);
				att_vo.setEmpname(emp_name);
				att_vo.setBioid(bioId);
				
				timesheet_list.add(att_vo);
				
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
				+ " Control in AttendenceApprovelDaoImpl: getEmployees : Ending");
		
		JSONArray array=new JSONArray();
		array.put(timesheet_list);
		
		return timesheet_list;

	}
	
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts,String userId,String userType) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeSheetReportDaoImpl: getManagersByDept Starting");
		Connection con = null;
		PreparedStatement pst_mang = null;
		ResultSet rs_mang=null;
		ArrayList<ManagerFilterVO> manglist =new ArrayList<ManagerFilterVO>();
		try {
			con = getConnection();
			String temp_dept = "'" + depts.replaceAll(",", "','") + "'";
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				pst_mang = con.prepareStatement("select ManagerCode,FirstName from hrms_manager where isActive='Y' and ManagerCode in (select UserCode from hrms_department_mapping where DepartmentCode in("+temp_dept+")) and ManagerCode in (select ManagerCode from hrms_manager_director_mapping where DirectorCode='"+userId+"')");
				
				System.out.println("director query ::: "+pst_mang.toString());
				
			}else{
			pst_mang = con.prepareStatement("select ManagerCode,FirstName from hrms_manager where isActive='Y' and ManagerCode in (select UserCode from hrms_department_mapping where DepartmentCode in("+temp_dept+"))");
			}
			rs_mang = pst_mang.executeQuery();
			
			while (rs_mang.next()) {
				ManagerFilterVO managvo = new ManagerFilterVO();
				managvo.setManagerid(rs_mang.getString("ManagerCode"));
				managvo.setManagername(rs_mang.getString("FirstName"));
				
				manglist.add(managvo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}finally{
			try{
				
				if(rs_mang != null && (!rs_mang.isClosed())){
					rs_mang.close();
				
				 }
				 if(pst_mang != null && (!pst_mang.isClosed())){
					 pst_mang.close();
				
				 }
				 if(con != null && (!con.isClosed())){
					 con.close();
				
				 }
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
  				+ MessageConstants.END_POINT);
  		logger.info(JDate.getTimeString(new Date())
  				+ " Control in  TimeSheetReportDaoImpl : getManagersByDept Ending");

		return manglist;
	}


	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeSheetReportDaoImpl: getEmployeesByMang Starting");
		Connection con = null;
		PreparedStatement pst_emp= null;
		ResultSet rs_emp=null;
		ArrayList<EmployeeFilterVO> emplist =new ArrayList<EmployeeFilterVO>();
		try {
			
			con = getConnection();
			String temp_manager= "'" + manager.replaceAll(",", "','") + "'";
			pst_emp = con.prepareStatement("select EMPID,First_Name from hrms_employee where isActive='Y' and (EMPID in (select EMPID from hrms_manager where ManagerCode in ("+temp_manager+")) or EMPID in (select EmployeeId from hrms_employee_manager_mapping where ManagerId in ("+temp_manager+") )) ");
			
			rs_emp = pst_emp.executeQuery();
			
			
			while (rs_emp.next()) {
				EmployeeFilterVO empvo = new EmployeeFilterVO();
				empvo.setEmpid(rs_emp.getString("EMPID"));
				empvo.setEmpname(rs_emp.getString("First_Name"));
				
				emplist.add(empvo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}finally{
			try{
				
				if(rs_emp != null && (!rs_emp.isClosed())){
					rs_emp.close();
				
				 }
				 if(pst_emp != null && (!pst_emp.isClosed())){
					 pst_emp.close();
				
				 }
				 if(con != null && (!con.isClosed())){
					 con.close();
				 }
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
  				+ MessageConstants.END_POINT);
  		logger.info(JDate.getTimeString(new Date())
  				+ " Control in  TimeSheetReportDaoImpl : getEmployeesByMang Ending");

  		return emplist;
	}
	
	
}
