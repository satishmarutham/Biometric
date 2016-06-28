package com.centris.util.SQLUtils;

public class EmployeeResumeCreation {
	public static String INSERT_HOBBIES_SPORTS = "insert into hrms_resume_hobbiesnsports(HOBCode,EMPCODE,SNO,HOBBIES,createdby,createtime) values(?,?,?,?,?,?)";
	public static String INSERT_CARRER_OBJECTIVE = "insert into hrms_resume_careerobjective(CBCode,EMPCODE,SN,Objective,createdby,createTime) values(?,?,?,?,?,?)";

	public static String INSERT_RESPONSIBILITIES = "insert into hrms_resume_responsibilities(ResCode,EMPCODE,SNO,RESPONSIBILITIES,createdby,createtime) values(?,?,?,?,?,?)";

	public static String INSERT_TECHNICALSKILLS = "insert into hrms_resume_technicalskills(TECHCode,EMPCODE,SNO,TECHNICALSKILL,createdby,createtime) values(?,?,?,?,?,?)";
	public static String INSERT_PURSUITS = "insert into hrms_resume_pursuits(PURSITCode,EMPCODE,SN,PURSUITS,cretedby,createtime) values(?,?,?,?,?,?)";
	public static String GET_RESPONSIBILITIES="select ResCode,SNO,RESPONSIBILITIES from hrms_resume_responsibilities where EMPCODE=? order by SNO";
	public static String GET_HOBBIES_SPORTS = "select HOBCode,SNO,HOBBIES from hrms_resume_hobbiesnsports where EMPCODE=?";
	public static String GET_TECHNICALSKILLS = "select TECHCode,SNO,TECHNICALSKILL from hrms_resume_technicalskills where EMPCODE=? order by SNO";
	public static String GET_PURSUITS ="select PURSITCode,SN,PURSUITS from hrms_resume_pursuits where EMPCODE=? order by SN";
	public static String GET_EMPLOYEE_COUNT ="select count(*) from hrms_resume_careerobjective where EMPCODE=?";
	public static String GETCARRER_OBJECTIVE ="select CBCode,SN,Objective,EMPCODE from hrms_resume_careerobjective where EMPCODE=?";
	public static String GET_EXPERIENCE ="select EXPCode,SNO,EXPERIENCE from hrms_resume_experience where EMPCODE=? order by SNO";
	
	
	public static String INSERT_EXPERIENCE="insert into hrms_resume_experience(EXPCode,EMPCODE,SNO,EXPERIENCE,createdby,createtime) values(?,?,?,?,?,?)";
	
	
	
	
	//Update
	
	
	public static String UPDATE_CARRER_OBJECTIVE="update hrms_resume_careerobjective set Objective=?,updatedBy=?,updatetime=? where EMPCODE=? and SN=?";
	public static String UPDATE_HOBBIES_SPORTS = "update hrms_resume_hobbiesnsports set HOBBIES=?,updatedby=?,updatetime=? where EMPCODE=? and SNO=?";
	public static String UPDATE_RESPONSIBILITIES = "update hrms_resume_responsibilities set RESPONSIBILITIES=?,updatedby=?,updatetime=? where EMPCODE=? and SNO=?";
	public static String UPDATE_TECHNICALSKILLS = "update hrms_resume_technicalskills set TECHNICALSKILL=?,updatedby=?,updatetime=? where EMPCODE=? and SNO=?";
	public static String UPDATE_PURSUITS = "update hrms_resume_pursuits set PURSUITS=?,updatedby=?,updatetime=? where EMPCODE=? and SN=?";
	public static String GET_EMPLOYEE_DETAILS ="SELECT he.First_Name,he.Present_Address,he.Mobile_Number,ho.Username from hrms_employee he,hrms_online_users ho where he.EMPID=ho.EMPID and he.EMPID=?";
	public static String UPDATE_EXPERIENCE ="update hrms_resume_experience set EXPERIENCE=?,updatedBy=?,updatetime=? where EMPCODE=? and SNO=?";
	
	
	public static String COUNT_HOBBIES_SPORTS="select count(*) from hrms_resume_hobbiesnsports where EMPCODE=? and SNO=?";
	public static String COUNT_PURSUITS="select count(*) from hrms_resume_pursuits where EMPCODE=? and SN=?";
	public static String COUNT_TECHNICALSKILLS="select count(*) from hrms_resume_technicalskills where EMPCODE=? and SNO=?";
	public static String COUNT_EXPERIENCE="select count(*) from hrms_resume_experience where EMPCODE=? and SNO=?";
	public static String COUNT_RESPONSIBILITIES="select count(*) from hrms_resume_responsibilities where EMPCODE=? and SNO=?";
	public static String COUNT_CARRER_OBJECTIVE="select count(*) from hrms_resume_careerobjective where EMPCODE=? and SN=?";
	
	
//Delete
	public static String DELETE_PURSUITS = "delete from hrms_resume_pursuits where EMPCODE=? and SN=?";
	
	public static String DELETE_HOBBIES_SPORTS="delete from hrms_resume_hobbiesnsports where EMPCODE=? and SNO=?";
	
	public static String DELETE_TECHNICAL_SKILLS="delete from hrms_resume_technicalskills where EMPCODE=? and SNO=?";
	
	public static String DELETE_EXPERIENCE="delete from hrms_resume_experience where EMPCODE=? and SNO=?";
	public static String DELETE_RESPONSIBILITIES="delete from hrms_resume_responsibilities where EMPCODE=? and SNO=?";
	
	
	public static String GET_EMPLOYEE_DETAILS_BY_CODE="SELECT * from hrms_employee where EMPID =?";
	
	
}
