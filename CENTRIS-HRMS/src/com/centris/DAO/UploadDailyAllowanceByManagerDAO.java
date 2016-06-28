package com.centris.DAO;

import java.util.Map;

public interface UploadDailyAllowanceByManagerDAO {
	public  String insertDailyAllowance(Map<String,Object> employeeMap,String uploadedFilePath) ;
}
