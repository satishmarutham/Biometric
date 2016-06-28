package com.centris.delegate;

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
import com.centris.service.AttendanceReconcilationService;
import com.centris.service.serviceImpl.AttendanceReconcilationServiceImpl;




public class AttendanceReconcillationBD {



	public ArrayList<AttendanceReconcilationVO> getEmployeeAttendance(String employeeId, String dateval) {
	
		AttendanceReconcilationService attendanceReconcilationService =new AttendanceReconcilationServiceImpl();
		
		return  attendanceReconcilationService.getEmployeeAttendance(employeeId, dateval);
	}

	public String attendnaceReconcilInsertion(String[] employeeids,
			String[] paybleVal, String[] notpaybleVal, String reason,
			String shortname, String date, String createdby) {
			
		AttendanceReconcilationService attendanceReconcilationService =new AttendanceReconcilationServiceImpl();
	 return attendanceReconcilationService.attendnaceReconcilInsertion(employeeids, paybleVal, notpaybleVal,
				reason, shortname, date,createdby);
	}
	
	public ArrayList<DepartmentFilterVO> getAllDepartments() {
		
		AttendanceReconcilationService attendanceReconcilationService =new AttendanceReconcilationServiceImpl();
		
		return attendanceReconcilationService.getAllDepartments();
	}

	public ArrayList<ManagerFilterVO> getManagersByDept(String depts) {

		AttendanceReconcilationService attendanceReconcilationService =new AttendanceReconcilationServiceImpl();
		
		return attendanceReconcilationService.getManagersByDept(depts);
	}

	

	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {

		AttendanceReconcilationService attendanceReconcilationService =new AttendanceReconcilationServiceImpl();
		
		return attendanceReconcilationService.getEmployeesByMang(manager);
	}

	

	

	
	
}
