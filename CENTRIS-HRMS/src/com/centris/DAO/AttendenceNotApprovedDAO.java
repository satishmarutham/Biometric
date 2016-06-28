package com.centris.DAO;

import java.util.List;

import com.centris.VO.AttendenceNotApprovedVO;

public interface AttendenceNotApprovedDAO {

	public List<AttendenceNotApprovedVO> getAttendanceNotApprovedByManager(String managerCode);
	public int getNotApprovedEmployeeCount(String managerCode);
	
}
