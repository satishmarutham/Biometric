package com.centris.DAO;

import java.util.ArrayList;

import com.centris.VO.ManualAttendanceVO;
import com.centris.form.ManualAttendanceForm;

public interface ManualAttendanceDao {
	public ArrayList<ManualAttendanceVO> getAttendanceDetails(
			ManualAttendanceForm formObj);
	public int updateAttendanceDetails(ManualAttendanceForm formObj);
}
