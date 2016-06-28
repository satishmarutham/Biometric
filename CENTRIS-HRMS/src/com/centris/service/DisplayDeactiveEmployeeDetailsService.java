package com.centris.service;

import java.util.ArrayList;

import com.centris.VO.EmployVO;

public interface DisplayDeactiveEmployeeDetailsService {
	
	public ArrayList<EmployVO> getDeactiveEmployeeDetails(String empid);

}
