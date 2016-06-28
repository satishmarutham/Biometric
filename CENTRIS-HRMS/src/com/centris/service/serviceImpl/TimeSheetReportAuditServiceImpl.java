package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.DAOIMPL.TimeSheetReportAuditDAOImpl;
import com.centris.VO.AuditReportEmpVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.ShiftVO;
import com.centris.VO.TimeSheetReportVO;
import com.centris.form.TimeSheetReportForm;

public class TimeSheetReportAuditServiceImpl {
	
	public List<ShiftVO> getShiftDetails() throws Exception {
		List<ShiftVO> shiftlist = new TimeSheetReportAuditDAOImpl().getShiftDeatails();
		return shiftlist;
	}
	public List<DepartmentMasterVO> getDepartMentDetails()throws Exception{
		List<DepartmentMasterVO> departmentlist= new TimeSheetReportAuditDAOImpl().getDepartmentDetails();
		return departmentlist;
	}
	public List<TimeSheetReportVO>	getEmployeeAttendanceInfo(TimeSheetReportForm timeSheetReportForm){
		return new TimeSheetReportAuditDAOImpl().getEmployeeAttendanceInfo(timeSheetReportForm);
	}
	public List<TimeSheetReportVO> getEmpTimeSheet(String empid,String date,String updatetime){
		return new TimeSheetReportAuditDAOImpl().getEmpTimeSheet(empid,date,updatetime);
	}
	
	public ArrayList<AuditReportEmpVO> getEmpDetails(String shiftid, String deptid){
		return new TimeSheetReportAuditDAOImpl().getEmpDetails(shiftid, deptid);
	}
}
