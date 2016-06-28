package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.VO.AuditReportEmpVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.ShiftVO;
import com.centris.VO.TimeSheetReportVO;
import com.centris.form.TimeSheetReportForm;
import com.centris.service.serviceImpl.TimeSheetReportAuditServiceImpl;

public class TimeSheetReportAuditBD {
	
	public List<ShiftVO> getShiftDetails()throws Exception {
		List<ShiftVO> shiftlist = new TimeSheetReportAuditServiceImpl().getShiftDetails();
		return shiftlist;
	}

	public List<DepartmentMasterVO> getDepartmentDetails()throws Exception {
		List<DepartmentMasterVO> departmentlist = new TimeSheetReportAuditServiceImpl().getDepartMentDetails();
		return departmentlist;
	}
public List<TimeSheetReportVO>	getEmployeeAttendanceInfo(TimeSheetReportForm timeSheetReportForm){
	return new TimeSheetReportAuditServiceImpl().getEmployeeAttendanceInfo(timeSheetReportForm);
}
public List<TimeSheetReportVO> getEmpTimeSheet(String empid,String date,String updatetime){
	return new TimeSheetReportAuditServiceImpl().getEmpTimeSheet(empid,date,updatetime);
}
public ArrayList<AuditReportEmpVO> getEmpDetails(String shiftid, String deptid){
	
	return new TimeSheetReportAuditServiceImpl().getEmpDetails(shiftid, deptid);
}
}
