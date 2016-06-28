package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.GeneratePayrollDAO;
import com.centris.VO.EmployeeDetailsForPayrollVo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GeneratePayrollVo;
import com.centris.VO.SalaryDetailsVo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.EmployeePayroll;
import com.centris.util.constants.MessageConstants;

public class GeneratePayrollDaoImpl extends DBService implements GeneratePayrollDAO{
	
	private static Logger logger = Logger.getLogger(GeneratePayrollDaoImpl.class);
	
	
	public Map<String,EmployeeDetailsForPayrollVo> getEmployeeDetailsForPayroll(int month,int year,String dept,Connection connction){
		Map<String,EmployeeDetailsForPayrollVo> EmployeeDetailsForPayrollMap = new HashMap<String, EmployeeDetailsForPayrollVo>();
		EmployeeDetailsForPayrollVo employeeDetailsForPayrollVO=null;
		
		Connection conn=connction;
	
		try{
			
			List<EmployeeVO> empList= getEmployeeList(conn,dept);
			
			for(int i=0;i<empList.size();i++){
				
				employeeDetailsForPayrollVO = new EmployeeDetailsForPayrollVo();
				
				String empId=empList.get(i).getEmpid();
				
				employeeDetailsForPayrollVO.setEmpid(empId);
				employeeDetailsForPayrollVO.setEmpName(empList.get(i).getEmpname());
				employeeDetailsForPayrollVO.setEmail(empList.get(i).getEmail());
				employeeDetailsForPayrollVO.setDepartment(empList.get(i).getDeptname());
				employeeDetailsForPayrollVO.setDesignation(empList.get(i).getDesignation());
				employeeDetailsForPayrollVO.setDesid(empList.get(i).getDesId());
				employeeDetailsForPayrollVO.setDoj(empList.get(i).getDoj());
				employeeDetailsForPayrollVO.setDeptid(empList.get(i).getDeptid());
				employeeDetailsForPayrollVO.setLocation(empList.get(i).getEmplocation());
				employeeDetailsForPayrollVO.setTotalDaysInMonth(HelperClass.getDaysByMonthAndYear(month, year)+"");
				
				employeeDetailsForPayrollVO.setTotalPresent(getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalPresent"));
				employeeDetailsForPayrollVO.setTotalAbsent(getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalAbsent"));
				employeeDetailsForPayrollVO.setTotalleave(getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalleave"));
				employeeDetailsForPayrollVO.setTotalholiday(getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("holidaydate"));
				employeeDetailsForPayrollVO.setTotalweekoff(getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalweekoff"));
				
				String totalabsentdates=  getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalabsentdates");
				String totalpresentdates=  getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalpresentdates");
				String totalleavedates=  getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalleavedates");
				String totalholidaydates=  getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalholidaydates");
				String totalweekoffdates=  getEmployeeTotalPresentAndAbsent( empId, month, year,conn).get("totalweekoffdates");
				
				ArrayList<String> absentdates_list=new ArrayList<String>();
				ArrayList<String> presentdates_list=new ArrayList<String>();
				ArrayList<String> leavedates_list=new ArrayList<String>();
				ArrayList<String> holidaydates_list=new ArrayList<String>();
				ArrayList<String> weekoffdates_list=new ArrayList<String>();
				
				
				if(!(totalabsentdates.equalsIgnoreCase(""))){
				String[] tot_absentdate= totalabsentdates.split(",");
				for(int j=0;j<tot_absentdate.length;j++){
					
					absentdates_list.add(tot_absentdate[j]);
					
				}
				employeeDetailsForPayrollVO.setAbsentdates(absentdates_list);
				}else{
					
					employeeDetailsForPayrollVO.setAbsentdates(absentdates_list);
				}
				
				if(!(totalpresentdates.equalsIgnoreCase(""))){
					String[] tot_presentdate= totalpresentdates.split(",");
					for(int j=0;j<tot_presentdate.length;j++){
						
						presentdates_list.add(tot_presentdate[j]);
						
					}
					employeeDetailsForPayrollVO.setPresentdates(presentdates_list);
					}else{
						
						employeeDetailsForPayrollVO.setPresentdates(presentdates_list);
					}
				
				if(!(totalleavedates.equalsIgnoreCase(""))){
					String[] tot_leavedate= totalleavedates.split(",");
					for(int j=0;j<tot_leavedate.length;j++){
						
						leavedates_list.add(tot_leavedate[j]);
						
					}
					employeeDetailsForPayrollVO.setLeavedates(leavedates_list);
					}else{
						
						employeeDetailsForPayrollVO.setLeavedates(leavedates_list);
					}
				
				if(!(totalholidaydates.equalsIgnoreCase(""))){
					String[] tot_holidaydate= totalholidaydates.split(",");
					for(int j=0;j<tot_holidaydate.length;j++){
						
						holidaydates_list.add(tot_holidaydate[j]);
						
					}
					employeeDetailsForPayrollVO.setHolidaydates(holidaydates_list);
					}else{
						
						employeeDetailsForPayrollVO.setHolidaydates(holidaydates_list);
					}
				
				if(!(totalweekoffdates.equalsIgnoreCase(""))){
					String[] tot_weekoffdate= totalweekoffdates.split(",");
					for(int j=0;j<tot_weekoffdate.length;j++){
						
						weekoffdates_list.add(tot_weekoffdate[j]);
						
					}
					employeeDetailsForPayrollVO.setWeekoffdates(weekoffdates_list);
					}else{
						
						employeeDetailsForPayrollVO.setWeekoffdates(weekoffdates_list);
					}
				
				
				EmployeeDetailsForPayrollMap.put(empId, employeeDetailsForPayrollVO);
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return EmployeeDetailsForPayrollMap;
	}
	
	
	public List<EmployeeVO> getEmployeeList(Connection connection,String dept){
		List<EmployeeVO> EmployeeList = new ArrayList<EmployeeVO>();
		PreparedStatement ps_employee=null;
		ResultSet rs_employee=null;
		EmployeeVO employeeVO=null;
		Connection conn=connection;
		try{
			 ps_employee = conn.prepareStatement(EmployeePayroll.GET_EMPLIST);
			 ps_employee.setString(1, dept);
			 ps_employee.setString(2, dept);
			 
			 
			 System.out.println("get employees ::: "+ps_employee.toString());
			 
			 System.out.println(ps_employee);
			 
			 rs_employee = ps_employee.executeQuery();
			while(rs_employee.next()){
				
				employeeVO= new EmployeeVO();
				employeeVO.setEmpid(rs_employee.getString("EMPID"));
				employeeVO.setEmpname(rs_employee.getString("First_Name"));
				employeeVO.setEmail(rs_employee.getString("Official_Email_ID"));
				employeeVO.setDeptname(rs_employee.getString("DEPT_NAME"));
				employeeVO.setDesignation(rs_employee.getString("designationName"));
				employeeVO.setDesId(rs_employee.getString("DesignationCode"));
				employeeVO.setDoj(rs_employee.getString("DOJ"));
				employeeVO.setDeptid(rs_employee.getString("DEPT_ID"));
				employeeVO.setEmplocation("BaseLocation");
				
				
				
				EmployeeList.add(employeeVO);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
		}
		return EmployeeList;
	}
	
	
	public Map<String,String> getEmployeeTotalPresentAndAbsent(String empId,int month,int year,Connection conn){
		Map<String,String> EmployeeDetailsForPayrollMap = new HashMap<String,String>();
		PreparedStatement ps_totalPresentAbsent=null;
		ResultSet rs_totalPresentAbsent=null;
		Connection connection=conn;
		try{
			ps_totalPresentAbsent = connection.prepareStatement(EmployeePayroll.GET_EMPLOYEE_ATTENDANCE);
			ps_totalPresentAbsent.setString(1, empId);
			ps_totalPresentAbsent.setString(2, year+"-"+month+"-01");
			ps_totalPresentAbsent.setString(3, year+"-"+month+"-"+HelperClass.getDaysByMonthAndYear(month, year));
			rs_totalPresentAbsent = ps_totalPresentAbsent.executeQuery();
			boolean flag=false;
			while(rs_totalPresentAbsent.next()){
				
				
				flag=true;
				String totalpresent=rs_totalPresentAbsent.getString("totalpresent");
				if( totalpresent==null){
					totalpresent="0";
				}
				String totalAbsent=rs_totalPresentAbsent.getString("totalabsent");
				if( totalAbsent==null){
					totalAbsent="0";
				}
				String totalLeaves=rs_totalPresentAbsent.getString("totalleave");
				if( totalLeaves==null){
					totalLeaves="0";
				}
				String totalHolidays=rs_totalPresentAbsent.getString("totalholiday");
				if( totalHolidays==null){
					totalHolidays="0";
				}
				String totalWeekoff=rs_totalPresentAbsent.getString("totalweekoff");
				if( totalWeekoff==null){
					totalWeekoff="0";
				}
				String totlatabsentdates=rs_totalPresentAbsent.getString("absentdate");
				String totalpresentdates=rs_totalPresentAbsent.getString("presentdate");
				String totalleavedates=rs_totalPresentAbsent.getString("leavedate");
				String totalholidaydates=rs_totalPresentAbsent.getString("holidaydate");
				String totalweekoffdates=rs_totalPresentAbsent.getString("weekoffdate");
				
				EmployeeDetailsForPayrollMap.put("totalPresent", totalpresent);
				EmployeeDetailsForPayrollMap.put("totalAbsent", totalAbsent);
				EmployeeDetailsForPayrollMap.put("totalleave", totalLeaves);
				EmployeeDetailsForPayrollMap.put("totalholiday", totalHolidays);
				EmployeeDetailsForPayrollMap.put("totalweekoff", totalWeekoff);
				if(totlatabsentdates==null){
					
					totlatabsentdates="";
				}
				if(totalpresentdates==null){
					
					totalpresentdates="";
				}
				if(totalleavedates==null){
										
					totalleavedates="";
				}
				if(totalholidaydates==null){
						
					totalholidaydates="";
				}
				if(totalweekoffdates==null){
						
					totalweekoffdates="";
				}
				EmployeeDetailsForPayrollMap.put("totalpresentdates",totalpresentdates );
				EmployeeDetailsForPayrollMap.put("totalabsentdates", totlatabsentdates);
				EmployeeDetailsForPayrollMap.put("totalleavedates", totalleavedates);
				EmployeeDetailsForPayrollMap.put("totalholidaydates", totalholidaydates);
				EmployeeDetailsForPayrollMap.put("totalweekoffdates", totalweekoffdates);
				
			}
			
			
			if(!flag){
				EmployeeDetailsForPayrollMap.put("totalPresent", "0");
				EmployeeDetailsForPayrollMap.put("totalAbsent", "0");
				EmployeeDetailsForPayrollMap.put("totalleave", "0");
				EmployeeDetailsForPayrollMap.put("totalholiday", "0");
				EmployeeDetailsForPayrollMap.put("totalweekoff", "0");
				
				EmployeeDetailsForPayrollMap.put("totalpresentdates", "");
				EmployeeDetailsForPayrollMap.put("totalabsentdates", "");
				EmployeeDetailsForPayrollMap.put("totalleavedates", "");
				EmployeeDetailsForPayrollMap.put("totalholidaydates", "");
				EmployeeDetailsForPayrollMap.put("totalweekoffdates", "");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			
		}
		return EmployeeDetailsForPayrollMap;
	}
	
	public SalaryDetailsVo getSalaryDetails(String empid,Connection connection){

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GeneratePayrollDaoImpl: getSalaryDetails : Starting");
		
		PreparedStatement salarystatement=null;
		ResultSet rs_salary=null;
		SalaryDetailsVo salaryDetailsVo=new SalaryDetailsVo();
		Connection conn=connection;
		
				try {
					
					 salarystatement = conn.prepareStatement(Employee.GET_SAL_DETAILS);
					 salarystatement.setString(1, empid);
					 
					 rs_salary=salarystatement.executeQuery();
					 
					 while(rs_salary.next()){
						 
						 salaryDetailsVo.setBankaccno(rs_salary.getString("BankAccNumber"));
						 salaryDetailsVo.setEmppfno(rs_salary.getString("PfNumber"));
						 salaryDetailsVo.setEmpesino(rs_salary.getString("EsiCode"));
						 salaryDetailsVo.setPaymenttype(rs_salary.getString("PaymentType"));
						 salaryDetailsVo.setCtc(Math.round(rs_salary.getDouble("Ctc")));
						 salaryDetailsVo.setGrosssalary(Math.round(rs_salary.getDouble("GrossSalary")));
						 salaryDetailsVo.setTotpayable(Math.round(rs_salary.getDouble("TotalPayable")));
						 salaryDetailsVo.setBasicda(Math.round(rs_salary.getDouble("BasicDa")));
						 salaryDetailsVo.setHra(Math.round(rs_salary.getDouble("Hra")));
						 salaryDetailsVo.setConveyance(Math.round(rs_salary.getDouble("Conveyance")));
						 salaryDetailsVo.setMedical(Math.round(rs_salary.getDouble("Medical")));
						 salaryDetailsVo.setCca(Math.round(rs_salary.getDouble("Cca")));
						 salaryDetailsVo.setSplallow(Math.round(rs_salary.getDouble("FixSplAllowances")));
						 salaryDetailsVo.setVariablepay(Math.round(rs_salary.getDouble("VariablePay")));
						 salaryDetailsVo.setEpfempr(Math.round(rs_salary.getDouble("EarnedEmprPf")));
						 salaryDetailsVo.setEesiempr(Math.round(rs_salary.getDouble("EarnedEmprEsi")));
						 salaryDetailsVo.setTotearned(Math.round(rs_salary.getDouble("TotalEarned")));
						 salaryDetailsVo.setPfempr(Math.round(rs_salary.getDouble("PfEmpr")));
						 salaryDetailsVo.setPfempy(Math.round(rs_salary.getDouble("PfEmpy")));
						 salaryDetailsVo.setEsiempr(Math.round(rs_salary.getDouble("EsiEmpr")));
						 salaryDetailsVo.setEsiempy(Math.round(rs_salary.getDouble("EsiEmpy")));
						 salaryDetailsVo.setPtax(Math.round(rs_salary.getDouble("PTax")));
						 salaryDetailsVo.setIncometax(Math.round(rs_salary.getDouble("IncomeTax")));
						 salaryDetailsVo.setAdvance(Math.round(rs_salary.getDouble("Advance")));
						 salaryDetailsVo.setTotdeductions(Math.round(rs_salary.getDouble("TotalDeductions")));
						
						 if(rs_salary.getString("IsApplicableForLeave")==null){
							 
						 salaryDetailsVo.setLeavedeductions("");
						 
						 }else{
							
							 salaryDetailsVo.setLeavedeductions(rs_salary.getString("IsApplicableForLeave"));
						 }
						
						 if(rs_salary.getString("IsApplicableForLate")==null){
							
							 salaryDetailsVo.setLatedeductions("");
							 
						 }else{
								
								 salaryDetailsVo.setLatedeductions(rs_salary.getString("IsApplicableForLeave"));
							 }
						
						 if(rs_salary.getString("IsApplicableForOt")==null){
							
							 salaryDetailsVo.setOvertime("");
							 
						 }else{
								
								 salaryDetailsVo.setOvertime(rs_salary.getString("IsApplicableForLeave"));
							 }
						 
						 
					 }
					 

				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error(e1);
				}finally{
						try{

							if(rs_salary!=null && (!rs_salary.isClosed())){
								
								rs_salary.close();
							}
							if(salarystatement!=null && (!salarystatement.isClosed())){
								
								salarystatement.close();
							}
							
							
						} catch (SQLException sqle) {
							sqle.printStackTrace();
							logger.error(sqle);
						} catch (Exception e1) {
							e1.printStackTrace();
							logger.error(e1);
						}
					}
			
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in GeneratePayrollDaoImpl: getSalaryDetails : Ending");
				
				return salaryDetailsVo;
			

	}
	
	public void storePayrollDetails(ArrayList<GeneratePayrollVo> parollList,Connection connection){

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GeneratePayrollDaoImpl: storePayrollDetails : Starting");
		
		PreparedStatement salarystatement=null;
		PreparedStatement psDeletPayroll=null;
		ResultSet rs_salary=null;
		Connection conn=connection;
		
				try {
					
				salarystatement =conn.prepareStatement(EmployeePayroll.STORE_PAYROLL_DEATILS);
				
				psDeletPayroll= conn.prepareStatement(EmployeePayroll.DELETE_PAYROLL);
				
				for(int i=0;i<parollList.size();i++){
					
					psDeletPayroll.setString(1, parollList.get(i).getEmpId());
					psDeletPayroll.setInt(2, parollList.get(i).getMonth());
					psDeletPayroll.setInt(3, parollList.get(i).getYear());
					
					psDeletPayroll.executeUpdate();
					
				}
				
				
				for(int i=0;i<parollList.size();i++){
				salarystatement.setString(1, parollList.get(i).getEmpId());
				salarystatement.setString(2, parollList.get(i).getDesid());
				salarystatement.setString(3, parollList.get(i).getDoj());
				salarystatement.setString(4, parollList.get(i).getEpfNo());
				salarystatement.setString(5, parollList.get(i).getEsicode());
				salarystatement.setInt(6, parollList.get(i).getNo_of_actual_days());
				salarystatement.setDouble(7, parollList.get(i).getBasicda_actual());
				salarystatement.setDouble(8, parollList.get(i).getHra_actual());
				salarystatement.setDouble(9, parollList.get(i).getConvinience_actual());
				salarystatement.setDouble(10, parollList.get(i).getMedical_actual());
				salarystatement.setDouble(11, parollList.get(i).getCca_actual());
				salarystatement.setDouble(12, parollList.get(i).getSpecial_allowances_actual());
				salarystatement.setDouble(13, parollList.get(i).getVariablepay_actual());
				salarystatement.setDouble(14, parollList.get(i).getCtc_actual());
				salarystatement.setDouble(15, parollList.get(i).getGross_actual());
				salarystatement.setDouble(16, parollList.get(i).getPayable_days());
				salarystatement.setDouble(17, parollList.get(i).getBasicda_earned());
				salarystatement.setDouble(18, parollList.get(i).getHra_earned());
				salarystatement.setDouble(19, parollList.get(i).getConvinience_earned());
				salarystatement.setDouble(20, parollList.get(i).getMedical_earned());
				salarystatement.setDouble(21, parollList.get(i).getCca_earned());
				salarystatement.setDouble(22, parollList.get(i).getSpecial_allowances_earned());
				salarystatement.setDouble(23, parollList.get(i).getVariablepay_earned());
				salarystatement.setDouble(24, parollList.get(i).getCtc_earned());
				salarystatement.setDouble(25, parollList.get(i).getGross_earned());
				salarystatement.setDouble(26, parollList.get(i).getPfempr_earned());
				salarystatement.setDouble(27, parollList.get(i).getPfempy_earned());
				salarystatement.setDouble(28, parollList.get(i).getEsiempr_earned());
				salarystatement.setDouble(29, parollList.get(i).getEsiempy_earned());
				salarystatement.setDouble(30, parollList.get(i).getPtax_earned());
				salarystatement.setDouble(31, parollList.get(i).getIncometax_earned());
				salarystatement.setDouble(32, parollList.get(i).getAdvance_earned());
				salarystatement.setDouble(33, parollList.get(i).getTotdeduction_earned());
				salarystatement.setDouble(34, parollList.get(i).getTakehome());
				salarystatement.setDouble(35, parollList.get(i).getSalaryadvanced());
				salarystatement.setDouble(36, parollList.get(i).getPendingsalary());
				salarystatement.setDouble(37, parollList.get(i).getNetamount());
				salarystatement.setDouble(38, parollList.get(i).getMonth());
				salarystatement.setDouble(39, parollList.get(i).getYear());
				salarystatement.setString(40, parollList.get(i).getCreatedby());
				salarystatement.setString(41, parollList.get(i).getDeptid());
				salarystatement.setString(42, parollList.get(i).getLocation());
				salarystatement.setString(43, parollList.get(i).getBackaccno());
				
				salarystatement.executeUpdate();
				
				
				}
					
					 

				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error(e1);
				}finally{
						try{

							if(rs_salary!=null && (!rs_salary.isClosed())){
								
								rs_salary.close();
							}
							if(salarystatement!=null && (!salarystatement.isClosed())){
								
								salarystatement.close();
							}
							
							
						} catch (SQLException sqle) {
							sqle.printStackTrace();
							logger.error(sqle);
						} catch (Exception e1) {
							e1.printStackTrace();
							logger.error(e1);
						}
					}
			
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in GeneratePayrollDaoImpl: storePayrollDetails : Ending");
				

	}
	
	
public String updateSalarydetails(String[] emp_array,String[] salaryadvance_array,String[] pendingsalary,String[] netpay_array,String month,String year,String usercode){

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GeneratePayrollDaoImpl: updateSalarydetails : Starting");
	
	PreparedStatement salarystatement=null;
	Connection conn=null;
	int count=0;
	String status=null;
	
			try {
				
				conn=getConnection();
				
				 salarystatement = conn.prepareStatement(EmployeePayroll.UPDATE_PAYROLL);
				
				for(int i=0;i<emp_array.length;i++){
				
				 salarystatement.setString(1, salaryadvance_array[i]);
				 salarystatement.setString(2, pendingsalary[i]);
				 salarystatement.setString(3, netpay_array[i]);
				 salarystatement.setString(4, usercode);
				 salarystatement.setTimestamp(5, HelperClass.getCurrentTimestamp());
				 salarystatement.setString(6, emp_array[i]);
				 salarystatement.setString(7, month);
				 salarystatement.setString(8, year);
				 
				 
				 count=salarystatement.executeUpdate();
				}
				 
				if(count>0){
					
					status="Payroll details updated successfully";
				}else{
					
					status="Payroll details not updated successfully";
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
					try{

						
						if(salarystatement!=null && (!salarystatement.isClosed())){
							
							salarystatement.close();
						}
						
						
					} catch (SQLException sqle) {
						sqle.printStackTrace();
						logger.error(sqle);
					} catch (Exception e1) {
						e1.printStackTrace();
						logger.error(e1);
					}
				}
		
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in GeneratePayrollDaoImpl: updateSalarydetails : Ending");
			
			return status;
		

}


public ArrayList<GeneratePayrollVo> getEmpMonthPayrollDetailsDownload(String month,String year,String department ){
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in GeneratePayrollDaoImpl: getEmpMonthPayrollDetailsDownload : Starting");
	
	PreparedStatement salarystatement=null;
	Connection conn=null;
	ArrayList<GeneratePayrollVo> payrollList=new ArrayList<GeneratePayrollVo>();
	ResultSet rs_payroll=null;
	int count=0;
	
			try {
				
				conn=getConnection();
				
				 salarystatement = conn.prepareStatement(EmployeePayroll.GET_PAYROLL_DETAILS);
				
				 salarystatement.setString(1, department);
				 salarystatement.setString(2, month);
				 salarystatement.setString(3, year);
				 
				 System.out.println("get payroll details ::: "+salarystatement.toString());
				 
				 rs_payroll=salarystatement.executeQuery();
				 
				 while(rs_payroll.next()){
					 count++;
					 
					 GeneratePayrollVo payrollVo=new GeneratePayrollVo();
					 payrollVo.setSno(count);
					 payrollVo.setEmpId(rs_payroll.getString("EmpId"));
					 payrollVo.setEmpName(rs_payroll.getString("First_Name"));
					 payrollVo.setEmp_des(rs_payroll.getString("designationName"));
					 payrollVo.setEmp_dept(rs_payroll.getString("DEPT_NAME"));
					 payrollVo.setDoj(rs_payroll.getString("Doj"));
					 payrollVo.setEpfNo(rs_payroll.getString("PfNo"));
					 payrollVo.setEsicode(rs_payroll.getString("EsiCode"));
					 payrollVo.setNo_of_actual_days(rs_payroll.getInt("NoOfDays"));
					 payrollVo.setBasicda_actual(rs_payroll.getDouble("BasicDa_Actual"));
					 payrollVo.setHra_actual(rs_payroll.getDouble("Hra_Actual"));
					 payrollVo.setConvinience_actual(rs_payroll.getDouble("Conveyance_Actual"));
					 payrollVo.setMedical_actual(rs_payroll.getDouble("Medical_Actual"));
					 payrollVo.setCca_actual(rs_payroll.getDouble("Cca_Actual"));
					 payrollVo.setSpecial_allowances_actual(rs_payroll.getDouble("SplAllow_Actual"));
					 payrollVo.setVariablepay_actual(rs_payroll.getDouble("VariablePay_Actual"));
					 payrollVo.setCtc_actual(rs_payroll.getDouble("Ctc_Actual"));
					 payrollVo.setGross_actual(rs_payroll.getDouble("GrossSalary_Actual"));
					 payrollVo.setPayable_days(rs_payroll.getInt("PayableDays"));
					 payrollVo.setBasicda_earned(rs_payroll.getDouble("BasicDa_Earned"));
					 payrollVo.setHra_earned(rs_payroll.getDouble("Hra_Earned"));
					 payrollVo.setConvinience_actual(rs_payroll.getDouble("Conveyance_Earned"));
					 payrollVo.setMedical_earned(rs_payroll.getDouble("Medical_Earned"));
					 payrollVo.setCca_earned(rs_payroll.getDouble("Cca_Earned"));
					 payrollVo.setSpecial_allowances_earned(rs_payroll.getDouble("SplAllow_Earned"));
					 payrollVo.setVariablepay_earned(rs_payroll.getDouble("VariablePay_Earned"));
					 payrollVo.setCtc_earned(rs_payroll.getDouble("Ctc_Earned"));
					 payrollVo.setGross_earned(rs_payroll.getDouble("GrossSalary_Earned"));
					 payrollVo.setPfempr_earned(rs_payroll.getDouble("EmprPf"));
					 payrollVo.setPfempy_earned(rs_payroll.getDouble("EmpyPf"));
					 payrollVo.setEsiempr_earned(rs_payroll.getDouble("EmprEsi"));
					 payrollVo.setEsiempy_earned(rs_payroll.getDouble("EmpyEsi"));
					 payrollVo.setPtax_earned(rs_payroll.getDouble("PTax"));
					 payrollVo.setIncometax_earned(rs_payroll.getDouble("Incometax"));
					 payrollVo.setAdvance_earned(rs_payroll.getDouble("Advance"));
					 payrollVo.setTotdeduction_earned(rs_payroll.getDouble("TotalDeductions"));
					 payrollVo.setTakehome(rs_payroll.getDouble("TakeHome"));
					 payrollVo.setSalaryadvanced(rs_payroll.getDouble("SalaryAdvance"));
					 payrollVo.setPendingsalary(rs_payroll.getDouble("PendingSalary"));
					 payrollVo.setNetamount(rs_payroll.getDouble("NetPay")); 
					 payrollVo.setLocation(rs_payroll.getString("Location"));
					 payrollVo.setBackaccno(rs_payroll.getString("BankAccountNumber"));
					 payrollVo.setTotal((rs_payroll.getDouble("TotalDeductions")+rs_payroll.getDouble("SalaryAdvance")+""));
					 
					 
					 payrollList.add(payrollVo);
					 
				 }
				 
				 
			

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}finally{
					try{

						
						if(salarystatement!=null && (!salarystatement.isClosed())){
							
							salarystatement.close();
						}
						
						
					} catch (SQLException sqle) {
						sqle.printStackTrace();
						logger.error(sqle);
					} catch (Exception e1) {
						e1.printStackTrace();
						logger.error(e1);
					}
				}
		
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in GeneratePayrollDaoImpl: getEmpMonthPayrollDetailsDownload : Ending");
			
			return payrollList;
		
}
	
	
	
	

}
