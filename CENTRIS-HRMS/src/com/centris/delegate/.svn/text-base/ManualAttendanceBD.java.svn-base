package com.centris.delegate;

import java.util.ArrayList;
import com.centris.VO.ManualAttendanceVO;
import com.centris.form.ManualAttendanceForm;
import com.centris.service.ManualAttendanceService;
import com.centris.service.serviceImpl.ManualAttendanceServiceImpl;

public class ManualAttendanceBD {

	public ArrayList<ManualAttendanceVO> getAttendanceDetails(
			ManualAttendanceForm formObj) {

		ManualAttendanceService serviceClass = new ManualAttendanceServiceImpl();

		return serviceClass.getAttendanceDetails(formObj);
	}

	public int updateAttendanceDetails(ManualAttendanceForm formObj) {

		ManualAttendanceService serviceClass = new ManualAttendanceServiceImpl();

		return serviceClass.updateAttendanceDetails(formObj);
	}
}
