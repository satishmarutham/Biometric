package com.centris.DAO;

import java.util.ArrayList;

import com.centris.VO.AllEmployeesViewDialogVo;
import com.centris.VO.EmployVO;
import com.centris.VO.GetAllEmployeeVO;

public interface GetAllEmployeeDao {
	public ArrayList<GetAllEmployeeVO> getDetails();
	public ArrayList<GetAllEmployeeVO> autosearchemployee(String term);
	public ArrayList<GetAllEmployeeVO> searchemployee(String searchterm);
	public ArrayList<EmployVO> modifyemployee(String empid);
	public ArrayList<AllEmployeesViewDialogVo> getEmpDetailsForViewDao(String empid);
	public ArrayList<GetAllEmployeeVO> getDeactiveEmployeeDetails();
	public int activateEmployee(String empid);
}
