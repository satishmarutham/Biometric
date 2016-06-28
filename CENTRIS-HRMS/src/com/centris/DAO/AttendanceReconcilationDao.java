package com.centris.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.centris.VO.AttendanceReconcilationVO;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.LocationMasterVo;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.ProjectFilterVo;
import com.centris.VO.ShiftMasterVO;


public interface AttendanceReconcilationDao {
	
	public ArrayList<AttendanceReconcilationVO> getEmployeeAttendance(String employeeId,String date) ;
	public String attendnaceReconcilInsertion(String[] employeeids,
			String[] paybleVal, String[] notpaybleVal, String reason,
			String shortname,java.sql.Date sqlDate, String createdby);
	
	public ArrayList<DepartmentFilterVO> getAllDepartments();
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts);

	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager);

	
}
