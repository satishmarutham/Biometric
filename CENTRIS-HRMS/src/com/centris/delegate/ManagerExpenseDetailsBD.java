package com.centris.delegate;

import java.util.ArrayList;
import com.centris.VO.ManagerExpenseDetailsVo;
import com.centris.form.ManagerExpenseDetailsForm;
import com.centris.service.ManagerExpenseDetailsService;
import com.centris.service.serviceImpl.ManagerExpenseDetailsServiceImpl;

public class ManagerExpenseDetailsBD {

	public ArrayList<ManagerExpenseDetailsVo> getexpenseDetails(
			ManagerExpenseDetailsForm formObj,String userType) {
		ArrayList<ManagerExpenseDetailsVo> expenseDetails = new ArrayList<ManagerExpenseDetailsVo>();
		ManagerExpenseDetailsService obj = new ManagerExpenseDetailsServiceImpl();
		expenseDetails = obj.getexpenseDetails(formObj,userType);
		return expenseDetails;
	}

	public String approveExpenseDetails(ManagerExpenseDetailsVo vo) {
		ManagerExpenseDetailsService obj = new ManagerExpenseDetailsServiceImpl();
		String result = null;
		result = obj.approveExpenseDetails(vo);
		return result;
	}
	
	public String approveAllExpenseDetailsBD(ManagerExpenseDetailsVo vo) {
		ManagerExpenseDetailsService obj = new ManagerExpenseDetailsServiceImpl();
		String result = null;
		result = obj.approveAllExpenseDetailsService(vo);
		return result;
	}
	
	public String rejectExpenseDetails(ManagerExpenseDetailsVo vo) {
		ManagerExpenseDetailsService obj = new ManagerExpenseDetailsServiceImpl();
		String result = null;
		result = obj.rejectExpenseDetails(vo);
		return result;
	}
	
	
	
}
