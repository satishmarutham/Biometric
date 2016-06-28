package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.AttendenceNotApprovedVO;

public class AttendenceNotApprovedDecorator extends TableDecorator {

	public String getView(){
		AttendenceNotApprovedVO mapData = (AttendenceNotApprovedVO) getCurrentRowObject();
		String startDate=mapData.getStartDate();
		String endDate=mapData.getEndDate();
		String empDetails= mapData.getEmpId();
		String viewButton="<a href=\"managerLeaveApprovedbydate.do?parameter=getEmployeeAttendence&startdate="+startDate+"&enddate="+endDate+"&employeename="+empDetails+"\"  class=\"viewClass\" >View</a>";
		return viewButton;
	}
}
