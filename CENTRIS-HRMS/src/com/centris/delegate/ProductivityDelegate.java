package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.EmployeeFilterVO;
import com.centris.form.ProductivityForm;
import com.centris.service.ProductivityService;
import com.centris.service.serviceImpl.ProductivityServiceImpl;

public class ProductivityDelegate {
	
	ProductivityService ProductivityService =new ProductivityServiceImpl();

public ArrayList<EmployeeFilterVO> getEmployeesByDept(EmployeeFilterVO b) {
	
	System.out.println("productivity Delegate");
		
	
		return ProductivityService.getEmployeesByDept(b);
	}

public  ArrayList<EmployeeFilterVO> getProductivityReport(ProductivityForm productivitybean)
{
	System.out.println("productivity Submit Delegate");
	
	return  ProductivityService.getProductivityReport(productivitybean);
}


}

