package com.centris.VO;

import java.sql.Timestamp;

public class GeneratePayrollVo {
	
	private int sno; 
	private String empId;
	private String empName;
	private String emp_dept;
	private String deptid;
	private String emp_des;
	private String desid;
	private String doj;
	private String esicode;
	private int month;
	private int year;
	private String epfNo;
	private int no_of_actual_days;
	private int payable_days;
	private double basicda_actual;
	private double basicda_earned;
	private double hra_actual;
	private double hra_earned;
	private double convinience_actual;
	private double convinience_earned;
	private double medical_actual;
	private double medical_earned;
	private double cca_actual;
	private double cca_earned;
	private double special_allowances_actual;
	private double special_allowances_earned;
	private double variablepay_actual;
	private double variablepay_earned;
	private double epfempr_actual;
	private double epfempr_earned;
	private double eesiempr_actual;
	private double eesiempr_earned;
	private double totEarned_actual;
	private double totEarned_earned;
	private double pfempr_actual;
	private double pfempr_earned;
	private double pfempy_actual;
	private double pfempy_earned;
	private double esiempr_actual;
	private double esiempr_earned;
	private double esiempy_actual;
	private double esiempy_earned;
	private double ptax_actual;
	private double ptax_earned;
	private double incometax_actual;
	private double incometax_earned;
	private double advance_actual;
	private double advance_earned;
	private double totdeduction_actual;
	private double totdeduction_earned;
	private double ctc_actual;
	private double ctc_earned;
	private double gross_actual;
	private double gross_earned;
	private double leave_deduction;
	private String late_deduction;
	private String overtime_pay;
	private double totpayabbla_actual;
	private double totpayabbla_earned;
	private double pf;
	private double esi;
	private double takehome;
	private double netamount;
	private double salaryadvanced;
	private double pendingsalary;
	private String createdby;
	private Timestamp createdate;
	private String location;
	private String backaccno;
	private String total; 
	
	
	
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBackaccno() {
		return backaccno;
	}
	public void setBackaccno(String backaccno) {
		this.backaccno = backaccno;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public double getSalaryadvanced() {
		return salaryadvanced;
	}
	public void setSalaryadvanced(double salaryadvanced) {
		this.salaryadvanced = salaryadvanced;
	}
	public double getPendingsalary() {
		return pendingsalary;
	}
	public void setPendingsalary(double pendingsalary) {
		this.pendingsalary = pendingsalary;
	}
	public String getDesid() {
		return desid;
	}
	public void setDesid(String desid) {
		this.desid = desid;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getEsicode() {
		return esicode;
	}
	public void setEsicode(String esicode) {
		this.esicode = esicode;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getTakehome() {
		return takehome;
	}
	public void setTakehome(double takehome) {
		this.takehome = takehome;
	}
	public double getNetamount() {
		return netamount;
	}
	public void setNetamount(double netamount) {
		this.netamount = netamount;
	}
	public double getPf() {
		return pf;
	}
	public void setPf(double pf) {
		this.pf = pf;
	}
	public double getEsi() {
		return esi;
	}
	public void setEsi(double esi) {
		this.esi = esi;
	}
	public String getEpfNo() {
		return epfNo;
	}
	public void setEpfNo(String epfNo) {
		this.epfNo = epfNo;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	public String getEmp_des() {
		return emp_des;
	}
	public void setEmp_des(String emp_des) {
		this.emp_des = emp_des;
	}
	public int getNo_of_actual_days() {
		return no_of_actual_days;
	}
	public void setNo_of_actual_days(int no_of_actual_days) {
		this.no_of_actual_days = no_of_actual_days;
	}
	public int getPayable_days() {
		return payable_days;
	}
	public void setPayable_days(int payable_days) {
		this.payable_days = payable_days;
	}
	public double getBasicda_actual() {
		return basicda_actual;
	}
	public void setBasicda_actual(double basicda_actual) {
		this.basicda_actual = basicda_actual;
	}
	public double getBasicda_earned() {
		return basicda_earned;
	}
	public void setBasicda_earned(double basicda_earned) {
		this.basicda_earned = basicda_earned;
	}
	public double getHra_actual() {
		return hra_actual;
	}
	public void setHra_actual(double hra_actual) {
		this.hra_actual = hra_actual;
	}
	public double getHra_earned() {
		return hra_earned;
	}
	public void setHra_earned(double hra_earned) {
		this.hra_earned = hra_earned;
	}
	public double getConvinience_actual() {
		return convinience_actual;
	}
	public void setConvinience_actual(double convinience_actual) {
		this.convinience_actual = convinience_actual;
	}
	public double getConvinience_earned() {
		return convinience_earned;
	}
	public void setConvinience_earned(double convinience_earned) {
		this.convinience_earned = convinience_earned;
	}
	public double getMedical_actual() {
		return medical_actual;
	}
	public void setMedical_actual(double medical_actual) {
		this.medical_actual = medical_actual;
	}
	public double getMedical_earned() {
		return medical_earned;
	}
	public void setMedical_earned(double medical_earned) {
		this.medical_earned = medical_earned;
	}
	public double getCca_actual() {
		return cca_actual;
	}
	public void setCca_actual(double cca_actual) {
		this.cca_actual = cca_actual;
	}
	public double getCca_earned() {
		return cca_earned;
	}
	public void setCca_earned(double cca_earned) {
		this.cca_earned = cca_earned;
	}
	public double getSpecial_allowances_actual() {
		return special_allowances_actual;
	}
	public void setSpecial_allowances_actual(double special_allowances_actual) {
		this.special_allowances_actual = special_allowances_actual;
	}
	public double getSpecial_allowances_earned() {
		return special_allowances_earned;
	}
	public void setSpecial_allowances_earned(double special_allowances_earned) {
		this.special_allowances_earned = special_allowances_earned;
	}
	public double getVariablepay_actual() {
		return variablepay_actual;
	}
	public void setVariablepay_actual(double variablepay_actual) {
		this.variablepay_actual = variablepay_actual;
	}
	public double getVariablepay_earned() {
		return variablepay_earned;
	}
	public void setVariablepay_earned(double variablepay_earned) {
		this.variablepay_earned = variablepay_earned;
	}
	public double getEpfempr_actual() {
		return epfempr_actual;
	}
	public void setEpfempr_actual(double epfempr_actual) {
		this.epfempr_actual = epfempr_actual;
	}
	public double getEpfempr_earned() {
		return epfempr_earned;
	}
	public void setEpfempr_earned(double epfempr_earned) {
		this.epfempr_earned = epfempr_earned;
	}
	public double getEesiempr_actual() {
		return eesiempr_actual;
	}
	public void setEesiempr_actual(double eesiempr_actual) {
		this.eesiempr_actual = eesiempr_actual;
	}
	public double getEesiempr_earned() {
		return eesiempr_earned;
	}
	public void setEesiempr_earned(double eesiempr_earned) {
		this.eesiempr_earned = eesiempr_earned;
	}
	public double getTotEarned_actual() {
		return totEarned_actual;
	}
	public void setTotEarned_actual(double totEarned_actual) {
		this.totEarned_actual = totEarned_actual;
	}
	public double getTotEarned_earned() {
		return totEarned_earned;
	}
	public void setTotEarned_earned(double totEarned_earned) {
		this.totEarned_earned = totEarned_earned;
	}
	public double getPfempr_actual() {
		return pfempr_actual;
	}
	public void setPfempr_actual(double pfempr_actual) {
		this.pfempr_actual = pfempr_actual;
	}
	public double getPfempr_earned() {
		return pfempr_earned;
	}
	public void setPfempr_earned(double pfempr_earned) {
		this.pfempr_earned = pfempr_earned;
	}
	public double getPfempy_actual() {
		return pfempy_actual;
	}
	public void setPfempy_actual(double pfempy_actual) {
		this.pfempy_actual = pfempy_actual;
	}
	public double getPfempy_earned() {
		return pfempy_earned;
	}
	public void setPfempy_earned(double pfempy_earned) {
		this.pfempy_earned = pfempy_earned;
	}
	public double getEsiempr_actual() {
		return esiempr_actual;
	}
	public void setEsiempr_actual(double esiempr_actual) {
		this.esiempr_actual = esiempr_actual;
	}
	public double getEsiempr_earned() {
		return esiempr_earned;
	}
	public void setEsiempr_earned(double esiempr_earned) {
		this.esiempr_earned = esiempr_earned;
	}
	public double getEsiempy_actual() {
		return esiempy_actual;
	}
	public void setEsiempy_actual(double esiempy_actual) {
		this.esiempy_actual = esiempy_actual;
	}
	public double getEsiempy_earned() {
		return esiempy_earned;
	}
	public void setEsiempy_earned(double esiempy_earned) {
		this.esiempy_earned = esiempy_earned;
	}
	public double getPtax_actual() {
		return ptax_actual;
	}
	public void setPtax_actual(double ptax_actual) {
		this.ptax_actual = ptax_actual;
	}
	public double getPtax_earned() {
		return ptax_earned;
	}
	public void setPtax_earned(double ptax_earned) {
		this.ptax_earned = ptax_earned;
	}
	public double getIncometax_actual() {
		return incometax_actual;
	}
	public void setIncometax_actual(double incometax_actual) {
		this.incometax_actual = incometax_actual;
	}
	public double getIncometax_earned() {
		return incometax_earned;
	}
	public void setIncometax_earned(double incometax_earned) {
		this.incometax_earned = incometax_earned;
	}
	public double getAdvance_actual() {
		return advance_actual;
	}
	public void setAdvance_actual(double advance_actual) {
		this.advance_actual = advance_actual;
	}
	public double getAdvance_earned() {
		return advance_earned;
	}
	public void setAdvance_earned(double advance_earned) {
		this.advance_earned = advance_earned;
	}
	public double getTotdeduction_actual() {
		return totdeduction_actual;
	}
	public void setTotdeduction_actual(double totdeduction_actual) {
		this.totdeduction_actual = totdeduction_actual;
	}
	public double getTotdeduction_earned() {
		return totdeduction_earned;
	}
	public void setTotdeduction_earned(double totdeduction_earned) {
		this.totdeduction_earned = totdeduction_earned;
	}
	public double getCtc_actual() {
		return ctc_actual;
	}
	public void setCtc_actual(double ctc_actual) {
		this.ctc_actual = ctc_actual;
	}
	public double getCtc_earned() {
		return ctc_earned;
	}
	public void setCtc_earned(double ctc_earned) {
		this.ctc_earned = ctc_earned;
	}
	public double getGross_actual() {
		return gross_actual;
	}
	public void setGross_actual(double gross_actual) {
		this.gross_actual = gross_actual;
	}
	public double getGross_earned() {
		return gross_earned;
	}
	public void setGross_earned(double gross_earned) {
		this.gross_earned = gross_earned;
	}
	public double getLeave_deduction() {
		return leave_deduction;
	}
	public void setLeave_deduction(double leave_deduction) {
		this.leave_deduction = leave_deduction;
	}
	public String getLate_deduction() {
		return late_deduction;
	}
	public void setLate_deduction(String late_deduction) {
		this.late_deduction = late_deduction;
	}
	public String getOvertime_pay() {
		return overtime_pay;
	}
	public void setOvertime_pay(String overtime_pay) {
		this.overtime_pay = overtime_pay;
	}
	public double getTotpayabbla_actual() {
		return totpayabbla_actual;
	}
	public void setTotpayabbla_actual(double totpayabbla_actual) {
		this.totpayabbla_actual = totpayabbla_actual;
	}
	public double getTotpayabbla_earned() {
		return totpayabbla_earned;
	}
	public void setTotpayabbla_earned(double totpayabbla_earned) {
		this.totpayabbla_earned = totpayabbla_earned;
	}
	
	
	
	
		
	
}
