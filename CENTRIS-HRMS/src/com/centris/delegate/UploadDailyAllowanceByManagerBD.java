package com.centris.delegate;

import java.util.List;
import java.util.Map;

import com.centris.VO.DailyAllownaceDownloadVo;
import com.centris.service.serviceImpl.UploadDailyAllowanceByManagerServiceImpl;

public class UploadDailyAllowanceByManagerBD {
	public String insertDailyAllowance(Map<String, Object> employeeMap,String uploadedFilePath) {
		return new UploadDailyAllowanceByManagerServiceImpl()
				.insertDailyAllowance(employeeMap,uploadedFilePath);
	}

	public List<DailyAllownaceDownloadVo> getUploadedFileDetails(
			String managerCode) {
		return new UploadDailyAllowanceByManagerServiceImpl()
				.getUploadedFileDetails(managerCode);
	}
}
