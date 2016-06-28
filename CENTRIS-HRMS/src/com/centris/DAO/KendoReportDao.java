package com.centris.DAO;

import java.util.ArrayList;

import com.centris.VO.KendoReportVo;

public interface KendoReportDao {
	public ArrayList<KendoReportVo> getReportCountDetails(String todaydate);
}
