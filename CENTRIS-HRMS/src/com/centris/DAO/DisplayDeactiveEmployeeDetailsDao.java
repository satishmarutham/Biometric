package com.centris.DAO;

import java.util.ArrayList;

import com.centris.VO.EmployVO;

public interface DisplayDeactiveEmployeeDetailsDao {
	
	public ArrayList<EmployVO> getDeactiveEmployeeDetails(String empid);

}
