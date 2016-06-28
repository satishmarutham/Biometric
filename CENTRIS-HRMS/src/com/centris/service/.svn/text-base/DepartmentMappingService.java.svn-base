package com.centris.service;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.AddDesignationVO;
import com.centris.VO.DepartmentMappingVo;

public interface DepartmentMappingService {

	ArrayList<DepartmentMappingVo> getAllUsersUnderDesignation(String designation);

	ArrayList<DepartmentMappingVo> getAvailableDepartments(String usercode);

	ArrayList<DepartmentMappingVo> getMappedDepartments(String usercode);

	String saveDepartmentMapping(String userId, JSONArray jsonArray,String currentuser);

	ArrayList<AddDesignationVO> getDesignationDetails();

}
