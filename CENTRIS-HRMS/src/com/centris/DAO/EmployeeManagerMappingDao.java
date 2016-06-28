package com.centris.DAO;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.EmployeeManagerMappingVO;

public interface EmployeeManagerMappingDao {

	ArrayList<EmployeeManagerMappingVO> getAvailableEmployees();

	String saveemployeeMangerMapping(String managerId, JSONArray jsonproject,String username);

	ArrayList<EmployeeManagerMappingVO> getMappedEmployees(String managerId);

}
