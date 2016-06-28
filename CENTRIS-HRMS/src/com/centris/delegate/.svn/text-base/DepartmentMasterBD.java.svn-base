package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.DepartmentMasterPojo;
import com.centris.VO.DepartmentMasterVO;
import com.centris.form.DepartmentMasterForm;
import com.centris.service.DepartmentMasterService;
import com.centris.service.serviceImpl.DepartmentMasterServiceImpl;



public class DepartmentMasterBD {
	
	
	public List<DepartmentMasterVO> getDepartmentRecordsBD() 	{
		DepartmentMasterService depMasterService=new DepartmentMasterServiceImpl();
		List<DepartmentMasterVO> depRecords=depMasterService.getDepRecordsService();
		return depRecords;
		
	}
	public String deleteDepartmentBD(String id,String loc)
	{
		
		return new DepartmentMasterServiceImpl().deleteDepartment(id,loc);
	}
	
	public String addDepartmentBD(DepartmentMasterForm depForm,String createdby)
	{
		DepartmentMasterService depMasterService=new DepartmentMasterServiceImpl();
		return depMasterService.addDepartmentService(depForm,createdby);
	}
	public String updateDepartmentBD(DepartmentMasterPojo dpojo)
	{
		DepartmentMasterService depMasterService=new DepartmentMasterServiceImpl();
		return depMasterService.updateDepartmentServiceImpl(dpojo);
	}
	
	public boolean validateDeptName(String deptname,String deptid){
		
		return new DepartmentMasterServiceImpl().validateDeptName(deptname, deptid);
	}
	
public ArrayList<DepartmentMasterVO> getSingleDeportmentDetails(String depid) {
		
		return new DepartmentMasterServiceImpl().getSingleDeportmentDetails(depid);
	}
	
}
