package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.WeekOffSettingDao;
import com.centris.DAO.DAOIMPL.WeekOffSettingDaoImpl;
import com.centris.VO.WeekOffSettingVo;
import com.centris.form.WeekoffSettingForm;
import com.centris.service.WeekOffSettingService;

public class WeekOffSettingServiceImpl implements WeekOffSettingService {

	@Override
	public List<WeekOffSettingVo> getWeekofDetailsByEmployeeId(String empId) {
		WeekOffSettingDao weekOffSettingDao=new WeekOffSettingDaoImpl();
		// TODO Auto-generated method stub
		return weekOffSettingDao.getWeekofDetailsByEmployeeId(empId);
	}

	@Override
	public String insertWeekOffDetails(WeekoffSettingForm settingForm) {
		// TODO Auto-generated method stub
		WeekOffSettingDao weekOffSettingDao=new WeekOffSettingDaoImpl();
		return weekOffSettingDao.insertWeekOffDetails(settingForm);
	}

}
