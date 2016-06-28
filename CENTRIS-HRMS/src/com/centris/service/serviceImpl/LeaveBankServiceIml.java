package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.LeaveBankDao;
import com.centris.DAO.DAOIMPL.LeaveBankDAOImpl;
import com.centris.POJO.LeaveBankPojo;
import com.centris.VO.LeaveBankVo;
import com.centris.VO.getAccYearVO;
import com.centris.form.GetLeavesform;
import com.centris.service.LeaveBankService;

public class LeaveBankServiceIml implements LeaveBankService {
	public ArrayList<getAccYearVO> getYear() {
		LeaveBankDao obj = new LeaveBankDAOImpl();
		return obj.getYear();
	}

	public String addLeave(GetLeavesform frm, String user) {
		LeaveBankDao obj = new LeaveBankDAOImpl();

		LeaveBankPojo pojo = new LeaveBankPojo();
		pojo.setAccyearCode(frm.getAccyear());
		pojo.setAllowed_per_month(Double.parseDouble(frm.getPermonth()));
		pojo.setTotal_leaves(Double.parseDouble(frm.getTotalleaves()));
		pojo.setSl(frm.getSl());
		pojo.setPl(frm.getPl());
		pojo.setCl(frm.getCl());
		pojo.setCreatedBy(user);

		return obj.addLeave(pojo);
	}

	public ArrayList<LeaveBankVo> getAllLeaves() {
		LeaveBankDao obj = new LeaveBankDAOImpl();
		return obj.getAllLeaves();
	}

	public ArrayList<LeaveBankVo> editLeave(GetLeavesform frm, String sno) {
		LeaveBankDao obj = new LeaveBankDAOImpl();
		return obj.editLeave(frm, sno);
	}

	public String updateLeave(GetLeavesform frm, String user) {
		LeaveBankDao obj = new LeaveBankDAOImpl();

		LeaveBankPojo pojo = new LeaveBankPojo();
		pojo.setSno(frm.getSno());
		pojo.setAccyearCode(frm.getAccyear());
		pojo.setAllowed_per_month(Double.parseDouble(frm.getPermonth()));
		pojo.setTotal_leaves(Double.parseDouble(frm.getTotalleaves()));
		pojo.setSl(frm.getSl());
		pojo.setPl(frm.getPl());
		pojo.setCl(frm.getCl());
		pojo.setModifiedBy(user);

		return obj.updateLeave(pojo);
	}

	public Boolean validAddLeave(String year) {
		LeaveBankDao obj = new LeaveBankDAOImpl();
		return obj.addvalid(year);
	}

	public Boolean validUpdateLeave(String year, String sno) {
		LeaveBankDao obj = new LeaveBankDAOImpl();
		return obj.validUpdateLeave(year, sno);
	}

	public Boolean deleteLeave(String[] deletelist) {
		LeaveBankDao obj = new LeaveBankDAOImpl();
		return obj.deleteLeave(deletelist);
	}

}
