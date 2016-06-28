package com.centris.service.serviceImpl;

import java.util.List;
import java.util.Map;

import com.centris.DAO.DAOIMPL.UploadDailyAllowanceByManagerDAOImpl;
import com.centris.VO.DailyAllownaceDownloadVo;
import com.centris.service.UploadDailyAllowanceByManagerService;

public class UploadDailyAllowanceByManagerServiceImpl implements
		UploadDailyAllowanceByManagerService {
	public String insertDailyAllowance(Map<String, Object> employeeMap,
			String uploadedFilePath) {
		return new UploadDailyAllowanceByManagerDAOImpl().insertDailyAllowance(
				employeeMap, uploadedFilePath);
	}

	public List<DailyAllownaceDownloadVo> getUploadedFileDetails(
			String managerCode) {
		return new UploadDailyAllowanceByManagerDAOImpl()
				.getUploadedFileDetails(managerCode);
	}
}
