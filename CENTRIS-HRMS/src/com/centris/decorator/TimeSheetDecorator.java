package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.TimeSheetReportVO;



public class TimeSheetDecorator extends TableDecorator {

private String viewbutton;
	
	public String getViewbutton() {
		TimeSheetReportVO timeSheetReportVO=(TimeSheetReportVO)getCurrentRowObject();
		String val = "<input type=\"button\" class=\"button1\" style=\"width:80px;\" value=\"View\" onclick=\"getTimesheet(\'"+timeSheetReportVO.getEmpid()+"&"+timeSheetReportVO.getAttendancedate()+"&"+timeSheetReportVO.getModifieddate()+"\')\" />";
	   return val;
	}
}
