package com.centris.service.serviceImpl;

import com.centris.DAO.DAOIMPL.EmployeeForgotPassDaoImpl;

public class EmployeeForgotPassServiceImpl {

	
	public int checkEmployeeService(String dateofbirth, String emp_official_emailid) {
		
		return new EmployeeForgotPassDaoImpl().checkEmployeeDao(dateofbirth,emp_official_emailid);
	}

}
