package com.centris.delegate;

import java.util.List;

import com.centris.VO.WeekOffSettingVo;
import com.centris.form.WeekoffSettingForm;
import com.centris.service.WeekOffSettingService;
import com.centris.service.serviceImpl.WeekOffSettingServiceImpl;

public class WeekOffSettingBD {
	public List<WeekOffSettingVo> getWeekofDetailsByEmployeeId(String empId){
		WeekOffSettingService offSettingService=new WeekOffSettingServiceImpl();
		return offSettingService.getWeekofDetailsByEmployeeId(empId);
	}
	
	public String insertWeekOffDetails(WeekoffSettingForm settingForm)
	{
		WeekOffSettingService offSettingService=new WeekOffSettingServiceImpl();
		return offSettingService.insertWeekOffDetails(settingForm);
	}
	
}
