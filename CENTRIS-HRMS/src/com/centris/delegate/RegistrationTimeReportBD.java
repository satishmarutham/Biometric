package com.centris.delegate;

import java.util.List;

import com.centris.VO.RegistrationTimeReportVo;
import com.centris.form.RegistrationTimeReportForm;
import com.centris.service.serviceImpl.RegistrationTimeReportServiceImpl;

public class RegistrationTimeReportBD {

	public List<RegistrationTimeReportVo> getRegistrationDetails(
			RegistrationTimeReportForm formObj) {
		return new RegistrationTimeReportServiceImpl()
				.getRegistrationDetails(formObj);
	}
}
