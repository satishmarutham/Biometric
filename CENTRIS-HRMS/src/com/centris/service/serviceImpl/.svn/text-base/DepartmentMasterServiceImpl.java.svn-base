package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DepartmentMasterDAO;
import com.centris.DAO.DAOIMPL.DepartmentMasterDAOImpl;
import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.DepartmentMasterPojo;
import com.centris.VO.DepartmentMasterVO;
import com.centris.action.DepartmentMasterAction;
import com.centris.form.DepartmentMasterForm;
import com.centris.service.DepartmentMasterService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class DepartmentMasterServiceImpl implements DepartmentMasterService{

	@Override
	public List<DepartmentMasterVO>  getDepRecordsService() {
		// TODO Auto-generated method stub
		List<DepartmentMasterVO> depRecordsList=new ArrayList<DepartmentMasterVO>();
		DepartmentMasterDAO depRecordsDAO=new DepartmentMasterDAOImpl();
		depRecordsList=depRecordsDAO.getDepRecordsDao();  
		
		
		
		return depRecordsList;
	}

	@Override
	    public String deleteDepartment(String id,String loc) {
		// TODO Auto-generated method stub
	
		return new DepartmentMasterDAOImpl().deleteDepartmentDAO(id,loc);
		
	}
	public String addDepartmentService(DepartmentMasterForm depForm,String createdby)
	{
		Logger logger = Logger.getLogger(DepartmentMasterAction.class);
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterServiceImpl : addDepartmentService : Starting");
		
		DepartmentMasterDAO depRecordsDAO=new DepartmentMasterDAOImpl();
		DepartmentMasterPojo dpojo=new DepartmentMasterPojo();
		
		try{
		
		IDGenerator id=new IDGenerator();
		
		dpojo.setDeptid(id.getPrimaryKeyID("hrms_department"));
	/*	dpojo.setLocManagerMail(depForm.getLocManagerMail());
		dpojo.setHrManagerMail(depForm.getHrManagerMail());
		dpojo.setOnsiteManagerMail(depForm.getOnsiteManagerMail());*/
		dpojo.setDeptname(depForm.getDepName());
		dpojo.setDeptdes(depForm.getDesc());
	
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
			
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMasterServiceImpl : addDepartmentService : Ending");
		
		return depRecordsDAO.addDepartmentDAO(dpojo,createdby);
	}
	public String updateDepartmentServiceImpl(DepartmentMasterPojo dpojo)
	{
		DepartmentMasterDAO depRecordsDAO=new DepartmentMasterDAOImpl();
		return depRecordsDAO.updateDepartmentDAO(dpojo);
	}
	
	public boolean validateDeptName(String deptname,String deptid){
		
		return new DepartmentMasterDAOImpl().validateDeptName(deptname, deptid);
	}
	

	public ArrayList<DepartmentMasterVO> getSingleDeportmentDetails(String depid) {
		
		return new DepartmentMasterDAOImpl().getSingleDeportmentDetails(depid);
	}


}
