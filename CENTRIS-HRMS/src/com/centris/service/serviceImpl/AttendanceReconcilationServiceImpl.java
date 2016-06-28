package com.centris.service.serviceImpl;



import java.util.ArrayList;

import com.centris.DAO.AttendanceReconcilationDao;
import com.centris.DAO.DAOIMPL.AttendanceReconcilationDaoImpl;
import com.centris.VO.AttendanceReconcilationVO;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.service.AttendanceReconcilationService;
import com.centris.util.HelperClass;


public class AttendanceReconcilationServiceImpl implements
		AttendanceReconcilationService {
	
	
	public ArrayList<AttendanceReconcilationVO> getEmployeeAttendance(String employeeId, String dateval) {
		
	     AttendanceReconcilationDao attendanceReconcilationDao = new AttendanceReconcilationDaoImpl();
		
	  return  attendanceReconcilationDao.getEmployeeAttendance(employeeId, dateval);
	}
	
	

	public String attendnaceReconcilInsertion(String[] employeeids,
			String[] paybleVal, String[] notpaybleVal, String reason,
			String shortname, String date,String createdby) {

		 AttendanceReconcilationDao attendanceReconcilationDao = new AttendanceReconcilationDaoImpl();
		 
		 
		 
		String result = attendanceReconcilationDao.attendnaceReconcilInsertion(employeeids, paybleVal, notpaybleVal,
						reason, shortname, HelperClass.getSqlDate(date),createdby);
		return result;
	}


	

	public ArrayList<DepartmentFilterVO> getAllDepartments() {
	
		AttendanceReconcilationDao attendanceReconcilationDao = new AttendanceReconcilationDaoImpl();
		
		return attendanceReconcilationDao.getAllDepartments();
	}

	
	
	
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts) {
	
		AttendanceReconcilationDao attendanceReconcilationDao = new AttendanceReconcilationDaoImpl();
		
		return attendanceReconcilationDao.getManagersByDept(depts);
	}




	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {
	
     AttendanceReconcilationDao attendanceReconcilationDao = new AttendanceReconcilationDaoImpl();
		
		return attendanceReconcilationDao.getEmployeesByMang(manager);
	}

	
	

	

}
