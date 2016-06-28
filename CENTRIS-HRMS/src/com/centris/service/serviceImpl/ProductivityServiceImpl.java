package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.ProductivityDAO;
import com.centris.DAO.DAOIMPL.ProductivityDAOIMPL;
import com.centris.VO.EmployeeFilterVO;
import com.centris.form.ProductivityForm;
import com.centris.service.ProductivityService;

public class ProductivityServiceImpl implements ProductivityService

{
ProductivityDAO productivityDAO =new ProductivityDAOIMPL();



	
	public ArrayList<EmployeeFilterVO> getEmployeesByDept(EmployeeFilterVO b) {
		
		System.out.println("productivity ServiceImpl");
		
		
		
	
		return productivityDAO.getEmployeesByDept(b);
		
	}


	public ArrayList<EmployeeFilterVO> getProductivityReport(ProductivityForm productivitybean)
	{
		// TODO Auto-generated method stub
		System.out.println("productivity submit ServiceImpl");

		
		return productivityDAO.getProductivityReport(productivitybean) ;
	}

}
