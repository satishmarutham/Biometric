package com.centris.delegate;

import java.util.List;

import com.centris.VO.AttendenceNotApprovedVO;
import com.centris.service.serviceImpl.AttendenceNotApprovedServiceImpl;

public class AttendenceNotApprovedBD {
	public List<AttendenceNotApprovedVO> getAttendanceNotApprovedByManager(String managerCode) {
		return new AttendenceNotApprovedServiceImpl().getAttendanceNotApprovedByManager(managerCode);
	}
	public int getNotApprovedEmployeeCount(String managerCode) {
		return new AttendenceNotApprovedServiceImpl().getNotApprovedEmployeeCount(managerCode);
	}
}
