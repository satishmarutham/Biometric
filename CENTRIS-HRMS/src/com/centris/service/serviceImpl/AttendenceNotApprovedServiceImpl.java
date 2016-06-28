package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.AttendenceNotApprovedDAOImpl;
import com.centris.VO.AttendenceNotApprovedVO;
import com.centris.service.AttendenceNotApprovedService;

public class AttendenceNotApprovedServiceImpl implements AttendenceNotApprovedService{

	@Override
	public List<AttendenceNotApprovedVO> getAttendanceNotApprovedByManager(String managerCode) {
		return new AttendenceNotApprovedDAOImpl().getAttendanceNotApprovedByManager(managerCode);
	}

	@Override
	public int getNotApprovedEmployeeCount(String managerCode) {
		return new AttendenceNotApprovedDAOImpl().getNotApprovedEmployeeCount(managerCode);
	}

}
