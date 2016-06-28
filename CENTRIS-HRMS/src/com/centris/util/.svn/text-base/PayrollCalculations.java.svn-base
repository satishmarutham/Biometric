package com.centris.util;

import com.centris.VO.SalaryDetailsVo;
import com.centris.util.SQLUtils.Employee;

public class PayrollCalculations {
	
	
// ************* calculations for earned start ******************//
	
	
public static double calEarnedGross(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
		
		
		double earned_gross=0.0;
		
		
		earned_gross=(salaryDetailsVo.getGrosssalary()/totaldays)*payabledays;
		
			return Math.round(earned_gross);
		}

public static double calEarnedCtc(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_ctc=0.0;
	
	
	earned_ctc=(salaryDetailsVo.getCtc()/totaldays)*payabledays;
	
		return Math.round(earned_ctc);
	}




/*public static double calEarnedBasic(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getBasicda()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedHra(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getHra()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedEmprPf(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getPfempr()/totaldays)*payabledays;

		return Math.round(earned_gross);
	}

public static double calEarnedEmpyPf(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
		
		
		double earned_gross=0.0;
		
		
		earned_gross=(salaryDetailsVo.getPfempy()/totaldays)*payabledays;
		
			return Math.round(earned_gross);
		}

public static double calEarnedEmprEsi(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getEsiempr()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedEmpyEsi(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getEsiempy()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedPt(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getPtax()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedIcometax(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getIncometax()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedAdvance(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getAdvance()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedTotEarnings(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getTotearned()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedTotDeductions(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getTotdeductions()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedTotPayable(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getTotpayable()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}
*/


public static double calculateBasicDa(SalaryDetailsVo salaryDetailsVo,double ctc){
	
	double basicda=(ctc*Employee.BASI_DA)/100;
	
	return Math.round(basicda);
}
public static double calculateHra(SalaryDetailsVo salaryDetailsVo,double basicda){
		
		double hra=(basicda*Employee.HRA)/100;
		
		return Math.round(hra);
	}

public static double calEarnedConveyance(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getConveyance()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}
public static double calEarnedMedical(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getMedical()/totaldays)*payabledays;
	

		return Math.round(earned_gross);
	}
public static double calEarnedCca(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getCca()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}
public static double calEarnedSplAllow(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getSplallow()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}
public static double calEarnedVariablePay(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getVariablepay()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calculatePfEmpr(SalaryDetailsVo salaryDetailsVo,double basicda){
	
	double pf_empr=0.0;
	
	if(basicda<=15000){
	
	 pf_empr=(basicda*Employee.PF_EMPR)/100;
	
	}else{
	
		 pf_empr=0.0;
	}
	
	return Math.round(pf_empr);
}
public static double calculatePfEmpy(SalaryDetailsVo salaryDetailsVo,double basicda){
	
	double pf_empy=0.0;
	
	if(basicda<=15000){
		
	 pf_empy=(basicda*Employee.PF_EMPY)/100;
	 
	}else{
		
		pf_empy=1800;
	}
	
	return Math.round(pf_empy);
}
public static double calculateEsiEmpr(SalaryDetailsVo salaryDetailsVo,double grosssalary){
	
	double esi_empr=0.0;
	
	if(grosssalary<=15000){
		
		 esi_empr=(grosssalary*Employee.ESI_EMPR)/100;
		 
	}
		return Math.round(esi_empr);
	}
public static double calculateEsiEmpy(SalaryDetailsVo salaryDetailsVo,double grosssalary){
	
	double esi_empy=0.0;
	
	if(grosssalary<=15000){
		
	 esi_empy=(grosssalary*Employee.ESI_EMPY)/100;
	 
	}
	return Math.round(esi_empy);
}

public static double calculatePt(SalaryDetailsVo salaryDetailsVo,double basicda){
	
	double ptax=0.0;
	
	if(basicda<15000){
		
		ptax=150;
	 
	}else{
		
		ptax=200;
	}
	return ptax;
}

public static double calEarnedIcometax(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getIncometax()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}

public static double calEarnedAdvance(SalaryDetailsVo salaryDetailsVo,int payabledays,int totaldays){
	
	
	double earned_gross=0.0;
	
	
	earned_gross=(salaryDetailsVo.getAdvance()/totaldays)*payabledays;
	
		return Math.round(earned_gross);
	}




















// ************* calculations for earned end ******************//

/*public PayrolDeductionsPojo calculateNetSalary(EmployeeSalaryDetailsVo empsalaryvo,Connection connection){
	
	double netsalary=empsalaryvo.getGrosssalary();
	Connection conn=connection;
	PayrolDeductionsPojo payrolDeductionsPojo=new PayrolDeductionsPojo();
	
	double late_ded=0;
	String late_time="00:00:00";
		
	if("Y".equalsIgnoreCase(empsalaryvo.getLatedeductions())){
		
		CalculateTimeAmount timeamount_late=new Calculate_emp_payroll().lateDeductions(empsalaryvo,empsalaryvo.getBasicda(),conn);
		
		late_ded=timeamount_late.getAmount();
		late_time=timeamount_late.getTime();
					
		netsalary=netsalary-(late_ded);
		
	}
	

	
	netsalary = Math.round(netsalary);
	
	payrolDeductionsPojo.setLatedeductions(late_ded);
	payrolDeductionsPojo.setLatetime(late_time);
	payrolDeductionsPojo.setNetsalary(netsalary);
	
	return payrolDeductionsPojo;
	
}*/

/*public CalculateTimeAmount lateDeductions(SalaryDetailsVo vo,double grosssalary,Connection connection){

PreparedStatement ps_latedeductions=null;
ResultSet rs_latededuction=null;
Connection conn=connection;
String latetime=null;
int no_lateexec=0;
int year=vo.getYear();
int month=vo.getMonth();

PayrollCalculations cal=new PayrollCalculations();
	CalculateTimeAmount cal_vo=new CalculateTimeAmount();
 
 	String startdate=year+"-"+month+"-01";
	String enddate= year+"-"+month+"-"+HelperClass.getDaysByMonthAndYear(month, year);

try {
	ps_latedeductions = (PreparedStatement)conn.prepareStatement(SQLutilConstants.CALCULATE_LATE_TIME);
	ps_latedeductions.setString(1, startdate);
	ps_latedeductions.setString(2, enddate);
	ps_latedeductions.setString(3, vo.getEmpid());
	
	rs_latededuction=ps_latedeductions.executeQuery();
	
	while(rs_latededuction.next()){
		
		latetime=rs_latededuction.getString("LateTime");
		no_lateexec=Integer.parseInt(rs_latededuction.getString("lateexex"));
		
	}
	
	
	 cal_vo=cal.calculatingAmmountforLate(month, year, grosssalary, latetime, no_lateexec);
	 
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return cal_vo;
}

public CalculateTimeAmount overTimeBeforeShift(EmployeeSalaryDetailsVo vo,double grosssalary,Connection connection){



PreparedStatement ps_overtime=null;
ResultSet rs_overtime=null;
String overtimebeforeshift=null;
CalculatingEmployeeSalaryDetails cal=new CalculatingEmployeeSalaryDetails();
CalculateTimeAmount cal_vo=new CalculateTimeAmount();
int year=vo.getYear();
int month=vo.getMonth();
Connection conn=connection;

 	String startdate=year+"-"+month+"-01";
	String enddate= year+"-"+month+"-"+HelperClass.getDaysByMonthAndYear(month, year);

try {
	ps_overtime = (PreparedStatement) conn.prepareStatement(SQLutilConstants.CALCULATE_OVERTIME);
	ps_overtime.setString(1, startdate);
	ps_overtime.setString(2, enddate);
	ps_overtime.setString(3, vo.getEmpid());
	
	
	rs_overtime=ps_overtime.executeQuery();
	
	while(rs_overtime.next()){
		
		overtimebeforeshift=rs_overtime.getString("otbeforeshift");
		
	}
	 cal_vo=cal.calculatingAmmountforOT(month, year, grosssalary, overtimebeforeshift);

} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


return cal_vo;
}


public CalculateTimeAmount overTimeAfterShift(EmployeeSalaryDetailsVo vo,double grosssalary,Connection connection){


PreparedStatement ps_overtime=null;
ResultSet rs_overtime=null;
String overtimeaftershift=null;
CalculatingEmployeeSalaryDetails cal=new CalculatingEmployeeSalaryDetails();
CalculateTimeAmount cal_vo=new CalculateTimeAmount();
int year=vo.getYear();
int month=vo.getMonth();
Connection conn=connection;
 
 	String startdate=year+"-"+month+"-01";
	String enddate= year+"-"+month+"-"+HelperClass.getDaysByMonthAndYear(month, year);

try {
	ps_overtime = (PreparedStatement)conn.prepareStatement(SQLutilConstants.CALCULATE_OVERTIME);
	ps_overtime.setString(1, startdate);
	ps_overtime.setString(2, enddate);
	ps_overtime.setString(3, vo.getEmpid());
	
	rs_overtime=ps_overtime.executeQuery();
	
	while(rs_overtime.next()){
		
		overtimeaftershift=rs_overtime.getString("otaftershift");
		
	}
	
	 cal_vo=cal.calculatingAmmountforOT(month, year, grosssalary, overtimeaftershift);

	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


return cal_vo;
}


public CalculateTimeAmount calculatingAmmountforLate(int month,int year,double salary,String time,int exec){

String Tot_EarlyTime="00:00:00";

 int totalDaysInMonth = HelperClass.getDaysByMonthAndYear(month, year);
 double incentiveDays = salary/(totalDaysInMonth);
 double incentiveHours = incentiveDays/9;
 double incentivesMinutes = incentiveHours/60;

 CalculateTimeAmount vo=new CalculateTimeAmount();
 
 if(time!=null){
		
	 String[] earlyArray=time.split(",");
	if(earlyArray.length<= exec){
		Tot_EarlyTime="00:00:00";
	}
	 else{
		 String[] earlyTimeArray = new String[earlyArray.length-exec];
		 System.arraycopy(earlyArray, exec, earlyTimeArray, 0, earlyTimeArray.length);
		 Tot_EarlyTime= HelperClass.addTimeArray(earlyTimeArray);
	 }
String[] hourminSec = Tot_EarlyTime.split(":");

if(Tot_EarlyTime.equalsIgnoreCase(null)){
	Tot_EarlyTime="00:00:00";
}


double tot_amount=(((Integer.parseInt(hourminSec[0]) * 60) +  Integer.parseInt(hourminSec[1])) * incentivesMinutes);
vo.setAmount(Math.round(tot_amount)) ;

}
 vo.setTime(Tot_EarlyTime);

return vo;
}*/

//************* calculations for vspl end ******************//





}
