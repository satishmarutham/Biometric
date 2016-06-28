package com.centris.service.serviceImpl;

import java.util.ArrayList;
import com.centris.DAO.ManualAttendanceDao;
import com.centris.DAO.DAOIMPL.ManualAttendanceDaoImpl;
import com.centris.VO.ManualAttendanceVO;
import com.centris.form.ManualAttendanceForm;
import com.centris.service.ManualAttendanceService;

public class ManualAttendanceServiceImpl implements ManualAttendanceService {

	@Override
	public ArrayList<ManualAttendanceVO> getAttendanceDetails(
			ManualAttendanceForm formObj) {

		ManualAttendanceDao daoClass = new ManualAttendanceDaoImpl();

		return daoClass.getAttendanceDetails(formObj);
	}

	@Override
	public int updateAttendanceDetails(ManualAttendanceForm formObj) {

		ManualAttendanceDao daoClass = new ManualAttendanceDaoImpl();

		return daoClass.updateAttendanceDetails(formObj);
	}
}
