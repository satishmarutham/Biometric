package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.LeaveBankVo;
import com.centris.VO.getAccYearVO;
import com.centris.form.GetLeavesform;
import com.centris.service.LeaveBankService;
import com.centris.service.serviceImpl.LeaveBankServiceIml;

public class LeaveBankBD {
	public ArrayList<getAccYearVO> getYear() {
		LeaveBankService obj = new LeaveBankServiceIml();
		return obj.getYear();
	}

	public String addLeave(GetLeavesform frm, String user) {
		LeaveBankService obj = new LeaveBankServiceIml();
		return obj.addLeave(frm, user);
	}

	public ArrayList<LeaveBankVo> getAllLeaves() {
		LeaveBankService obj = new LeaveBankServiceIml();
		return obj.getAllLeaves();
	}

	public ArrayList<LeaveBankVo> editLeave(GetLeavesform frm, String sno) {
		LeaveBankService obj = new LeaveBankServiceIml();
		return obj.editLeave(frm, sno);
	}

	public String updateLeave(GetLeavesform frm, String user) {
		LeaveBankService obj = new LeaveBankServiceIml();
		return obj.updateLeave(frm, user);
	}

	public Boolean validAddLeave(String year) {
		LeaveBankService obj = new LeaveBankServiceIml();
		return obj.validAddLeave(year);
	}

	public Boolean validUpdateLeave(String year, String sno) {
		LeaveBankService obj = new LeaveBankServiceIml();
		return obj.validUpdateLeave(year, sno);
	}

	public Boolean deleteLeave(String[] deletelist) {
		LeaveBankService obj = new LeaveBankServiceIml();
		return obj.deleteLeave(deletelist);
	}

}
