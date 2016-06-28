package com.centris.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author seshuma
 *
 */
public class AddEmployeeForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String empname;
	private String doj;
	private String dob;
	private String father;
	private String empid;
	private String empmail;
	private String empphone;
	private String empdesignation;
	private String empdepartment;
	private String empshift;
	private String emptype;
	private String empaddresss;
	private String empusername;
	private String empcategory;
	private String paymenttype;
	private String basic;
	private String hra;
	private String conveyance;
	private String allowance;
	private String medical;
	private String grosssalary;
	private String pf;
	private String incometax;
	private String loginUserName;
	private String profTax;
	private String pfNo;
	private String otherDeduction;
	private String pfEmployeeContribution;
	private String shiftHour;
	private String shiftMin;
	private String incentivePerMinute;
	private String incentivePerHour;
	private String incentivePerDay;
	private String incentivePerWeek;
	private String netSalary;
	private String bankerEmail;
	private String totalDeduction;
	private String empLocation;
	private String userRole;
	private String isemployeeregusteredinmultilocations;
	private String empregnumber;
	private String allselectedlocations;
	private String usergroup;
	
	
	

	
	
	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public String getAllselectedlocations() {
		return allselectedlocations;
	}

	public void setAllselectedlocations(String allselectedlocations) {
		this.allselectedlocations = allselectedlocations;
	}

	public String getIsemployeeregusteredinmultilocations() {
		return isemployeeregusteredinmultilocations;
	}

	public void setIsemployeeregusteredinmultilocations(
			String isemployeeregusteredinmultilocations) {
		this.isemployeeregusteredinmultilocations = isemployeeregusteredinmultilocations;
	}

	public String getEmpregnumber() {
		return empregnumber;
	}

	public void setEmpregnumber(String empregnumber) {
		this.empregnumber = empregnumber;
	}

	public String getShiftHour() {
		return shiftHour;
	}

	public void setShiftHour(String shiftHour) {
		this.shiftHour = shiftHour;
	}

	public String getIncentivePerMinute() {
		return incentivePerMinute;
	}

	public void setIncentivePerMinute(String incentivePerMinute) {
		this.incentivePerMinute = incentivePerMinute;
	}

	public String getIncentivePerHour() {
		return incentivePerHour;
	}

	public void setIncentivePerHour(String incentivePerHour) {
		this.incentivePerHour = incentivePerHour;
	}

	public String getIncentivePerDay() {
		return incentivePerDay;
	}

	public void setIncentivePerDay(String incentivePerDay) {
		this.incentivePerDay = incentivePerDay;
	}

	public String getIncentivePerWeek() {
		return incentivePerWeek;
	}

	public void setIncentivePerWeek(String incentivePerWeek) {
		this.incentivePerWeek = incentivePerWeek;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProfTax() {
		return profTax;
	}

	public void setProfTax(String profTax) {
		this.profTax = profTax;
	}


	public String getOtherDeduction() {
		return otherDeduction;
	}

	public void setOtherDeduction(String otherDeduction) {
		this.otherDeduction = otherDeduction;
	}

	public String getPfEmployeeContribution() {
		return pfEmployeeContribution;
	}

	public void setPfEmployeeContribution(String pfEmployeeContribution) {
		this.pfEmployeeContribution = pfEmployeeContribution;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpmail() {
		return empmail;
	}

	public void setEmpmail(String empmail) {
		this.empmail = empmail;
	}

	public String getEmpphone() {
		return empphone;
	}

	public void setEmpphone(String empphone) {
		this.empphone = empphone;
	}

	public String getEmpdesignation() {
		return empdesignation;
	}

	public void setEmpdesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}

	public String getEmpdepartment() {
		return empdepartment;
	}

	public void setEmpdepartment(String empdepartment) {
		this.empdepartment = empdepartment;
	}

	public String getEmpshift() {
		return empshift;
	}

	public void setEmpshift(String empshift) {
		this.empshift = empshift;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}

	public String getEmpaddresss() {
		return empaddresss;
	}

	public void setEmpaddresss(String empaddresss) {
		this.empaddresss = empaddresss;
	}


	public String getEmpusername() {
		return empusername;
	}

	public void setEmpusername(String empusername) {
		this.empusername = empusername;
	}

	public String getEmpcategory() {
		return empcategory;
	}

	public void setEmpcategory(String empcategory) {
		this.empcategory = empcategory;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getHra() {
		return hra;
	}

	public void setHra(String hra) {
		this.hra = hra;
	}

	public String getConveyance() {
		return conveyance;
	}

	public void setConveyance(String conveyance) {
		this.conveyance = conveyance;
	}

	public String getAllowance() {
		return allowance;
	}

	public void setAllowance(String allowance) {
		this.allowance = allowance;
	}

	public String getMedical() {
		return medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getGrosssalary() {
		return grosssalary;
	}

	public void setGrosssalary(String grosssalary) {
		this.grosssalary = grosssalary;
	}

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getIncometax() {
		return incometax;
	}

	public void setIncometax(String incometax) {
		this.incometax = incometax;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(String netSalary) {
		this.netSalary = netSalary;
	}

	public String getBankerEmail() {
		return bankerEmail;
	}

	public void setBankerEmail(String bankerEmail) {
		this.bankerEmail = bankerEmail;
	}

	public String getTotalDeduction() {
		return totalDeduction;
	}

	public void setTotalDeduction(String totalDeduction) {
		this.totalDeduction = totalDeduction;
	}

	public String getPfNo() {
		return pfNo;
	}

	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}

	public String getShiftMin() {
		return shiftMin;
	}

	public void setShiftMin(String shiftMin) {
		this.shiftMin = shiftMin;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
		
		this.isemployeeregusteredinmultilocations=null;
		this.allselectedlocations=null;
	}
	
	
	
	

}
