package com.centris.service;

import java.util.ArrayList;

import com.centris.VO.LeaveBankVo;
import com.centris.VO.getAccYearVO;
import com.centris.form.GetLeavesform;

public interface LeaveBankService {
	public ArrayList<getAccYearVO> getYear();
	public String addLeave(GetLeavesform frm,String user);
	public ArrayList<LeaveBankVo> getAllLeaves();
	public ArrayList<LeaveBankVo> editLeave(GetLeavesform frm,String sno);
	public String updateLeave(GetLeavesform frm,String user);
	public Boolean validAddLeave(String year);
	public Boolean validUpdateLeave(String year,String sno);
	public Boolean deleteLeave(String[] deletelist);
}
