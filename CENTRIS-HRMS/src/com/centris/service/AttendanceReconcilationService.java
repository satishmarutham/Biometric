package com.centris.service;

import java.util.ArrayList;
import java.util.List;

import com.centris.VO.AttendanceReconcilationVO;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GroupMasterVO;
import com.centris.VO.LocationMasterVo;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.ProjectFilterVo;
import com.centris.VO.ShiftMasterVO;

public interface AttendanceReconcilationService {

	public ArrayList<AttendanceReconcilationVO> getEmployeeAttendance(String employeeId, String dateval) ;
	public String attendnaceReconcilInsertion(String[] employeeids,String[] paybleVal, String[] notpaybleVal,String reason,String shortname, String date, String createdby);
	
	
	public ArrayList<DepartmentFilterVO> getAllDepartments();
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts);
	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager);
	

}
