package com.centris.VO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAttendancePostingVo {

	private String get_Sno;
	private String get_EmployeeId;
	private String get_EmployeeName;
	private String get_inTime;
	private String get_outTime;
	private String get_totalTime;
	private String get_Location;
	private String get_attDate;
	private String get_attStatus;
	private String get_statusTypeCode;
	private String get_statusTypeName;
	private String get_ManagerCode;
	private String get_ManagerName;
	private String get_Description;
	private List<ClientVO> clientlist;


	
	


	public List<ClientVO> getClientlist() {
		return clientlist;
	}

	public void setClientlist(List<ClientVO> clientlist) {
		this.clientlist = clientlist;
	}

	public String getGet_Description() {
		return get_Description;
	}

	public void setGet_Description(String get_Description) {
		this.get_Description = get_Description;
	}

	private List<EmployeeAttendancePostingVo> get_AttendanceDetails;
	private List<EmployeeAttendancePostingVo> get_statusTypeList;
	private List<EmployeeAttendancePostingVo> get_Project_ManagerList;

	private List<String> attendanceStatusList;
	private String response;

	public String getGet_Sno() {
		return get_Sno;
	}

	public void setGet_Sno(String get_Sno) {
		this.get_Sno = get_Sno;
	}

	public String getGet_EmployeeId() {
		return get_EmployeeId;
	}

	public void setGet_EmployeeId(String get_EmployeeId) {
		this.get_EmployeeId = get_EmployeeId;
	}

	public String getGet_EmployeeName() {
		return get_EmployeeName;
	}

	public void setGet_EmployeeName(String get_EmployeeName) {
		this.get_EmployeeName = get_EmployeeName;
	}

	public String getGet_inTime() {
		return get_inTime;
	}

	public void setGet_inTime(String get_inTime) {
		this.get_inTime = get_inTime;
	}

	public String getGet_outTime() {
		return get_outTime;
	}

	public void setGet_outTime(String get_outTime) {
		this.get_outTime = get_outTime;
	}

	public String getGet_totalTime() {
		return get_totalTime;
	}

	public void setGet_totalTime(String get_totalTime) {
		this.get_totalTime = get_totalTime;
	}

	public String getGet_Location() {
		return get_Location;
	}

	public void setGet_Location(String get_Location) {
		this.get_Location = get_Location;
	}

	public String getGet_attDate() {
		return get_attDate;
	}

	public void setGet_attDate(String get_attDate) {
		this.get_attDate = get_attDate;
	}

	public String getGet_attStatus() {
		return get_attStatus;
	}

	public void setGet_attStatus(String get_attStatus) {
		this.get_attStatus = get_attStatus;
	}

	public String getGet_statusType() {
		return get_statusTypeCode;
	}

	public void setGet_statusType(String get_statusTypeCode) {
		this.get_statusTypeCode = get_statusTypeCode;
	}

	public String getGet_statusTypeCode() {
		return get_statusTypeCode;
	}

	public void setGet_statusTypeCode(String get_statusTypeCode) {
		this.get_statusTypeCode = get_statusTypeCode;
	}

	public String getGet_statusTypeName() {
		return get_statusTypeName;
	}

	public void setGet_statusTypeName(String get_statusTypeName) {
		this.get_statusTypeName = get_statusTypeName;
	}

	public List<EmployeeAttendancePostingVo> getGet_statusTypeList() {
		return get_statusTypeList;
	}

	public void setGet_statusTypeList(
			List<EmployeeAttendancePostingVo> get_statusTypeList) {
		this.get_statusTypeList = get_statusTypeList;
	}

	public List<EmployeeAttendancePostingVo> getGet_Project_ManagerList() {
		return get_Project_ManagerList;
	}

	public void setGet_Project_ManagerList(
			List<EmployeeAttendancePostingVo> get_Project_ManagerList) {
		this.get_Project_ManagerList = get_Project_ManagerList;
	}

	public String getGet_ManagerCode() {
		return get_ManagerCode;
	}

	public void setGet_ManagerCode(String get_ManagerCode) {
		this.get_ManagerCode = get_ManagerCode;
	}

	public String getGet_ManagerName() {
		return get_ManagerName;
	}

	public void setGet_ManagerName(String get_ManagerName) {
		this.get_ManagerName = get_ManagerName;
	}

	public List<EmployeeAttendancePostingVo> getGet_AttendanceDetails() {
		return get_AttendanceDetails;
	}

	public void setGet_AttendanceDetails(
			List<EmployeeAttendancePostingVo> get_AttendanceDetails) {
		this.get_AttendanceDetails = get_AttendanceDetails;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<String> getAttendanceStatusList() {
		return attendanceStatusList;
	}

	public void setAttendanceStatusList(List<String> attendanceStatusList) {
		this.attendanceStatusList = attendanceStatusList;
	}
}