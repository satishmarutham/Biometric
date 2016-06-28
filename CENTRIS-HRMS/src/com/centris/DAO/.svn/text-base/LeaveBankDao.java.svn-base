package com.centris.DAO;

import java.util.ArrayList;

import com.centris.POJO.LeaveBankPojo;
import com.centris.VO.LeaveBankVo;
import com.centris.VO.getAccYearVO;
import com.centris.form.GetLeavesform;

public interface LeaveBankDao {
	public  ArrayList<getAccYearVO> getYear();
	public String addLeave(LeaveBankPojo pojo);
	public  ArrayList<LeaveBankVo> getAllLeaves() ;
	public ArrayList<LeaveBankVo> editLeave(GetLeavesform frm,
			String sno);
	public  String updateLeave(LeaveBankPojo pojo);
	public Boolean addvalid(String accyear);
	public Boolean validUpdateLeave(String accyear, String sno);
	public Boolean deleteLeave(String[] deletelist);
	
}
