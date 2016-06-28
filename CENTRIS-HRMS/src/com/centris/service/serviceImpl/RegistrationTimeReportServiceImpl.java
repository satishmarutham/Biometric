package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.RegistrationTimeReportDaoImpl;
import com.centris.VO.RegistrationTimeReportVo;
import com.centris.form.RegistrationTimeReportForm;
import com.centris.service.RegistrationTimeReportService;

public class RegistrationTimeReportServiceImpl implements RegistrationTimeReportService{

	public List<RegistrationTimeReportVo> getRegistrationDetails(
			RegistrationTimeReportForm formObj) {
		return new RegistrationTimeReportDaoImpl()
				.getRegistrationDetails(formObj);
	}
}
