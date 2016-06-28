package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.AttendenceApprovelVo;

public class AttApprovedByDateDecorator extends TableDecorator {
	

	
	
	public String getInTime(){
		AttendenceApprovelVo mapData = (AttendenceApprovelVo) getCurrentRowObject();
		String intimeValue="00:00:00";
		if(mapData.getIntime()!=null)
			intimeValue=mapData.getIntime();
		String attendancedate=mapData.getAttendencedate();
		String date=mapData.getEmpid();

	String inTime=	"<div  class=\"input-append inTimeClass"+attendancedate+"--"+date+"\">	<input type=\"text\" title=\"Click On Time Image\" id=\""+attendancedate+"--"+date+"intime1\" name=\"intime\" class=\"intime\" readonly=\"readonly\" style=\"height:25px;width:100px !important;\"	data-format=\"hh:mm:ss\" value=\""+intimeValue+"\" />	<span class=\"add-on\"> <img src=\"./images/time.jpg\"	title=\"Click Here\" width=\"25\" height=\"10\"></img></span>	</div>";
	return inTime;
	}
	
	public String getOutTime(){
		AttendenceApprovelVo mapData = (AttendenceApprovelVo) getCurrentRowObject();
		String outtimeValue="00:00:00";
		if(mapData.getOuttime()!=null)
			outtimeValue=mapData.getOuttime();
		String attendancedate=mapData.getAttendencedate();
		String date=mapData.getEmpid();
	String outTime=	"<div  class=\"input-append outTimeClass"+attendancedate+"--"+date+"\">	<input type=\"text\" title=\"Click On Time Image\" id=\""+attendancedate+"--"+date+"outtime\" name=\"outtime\" class=\"outtime\" readonly=\"readonly\" style=\"height:25px;width:100px !important;\"	data-format=\"hh:mm:ss\" value=\""+outtimeValue+"\" />	<span class=\"add-on\"> <img src=\"./images/time.jpg\"	title=\"Click Here\"	width=\"25\" height=\"10\"></img></span>	</div>";
	return outTime;
	}
	
	
	public String getTotalHours(){
		AttendenceApprovelVo mapData = (AttendenceApprovelVo) getCurrentRowObject();
		String totalHoursValue="00:00:00";
		if(mapData.getTotaltime()!=null)
			totalHoursValue=mapData.getTotaltime();
		String attendancedate=mapData.getAttendencedate();
		String date=mapData.getEmpid();
	String totalHours=	"<input type=\"text\" name=\"totalhours\" class=\"totalhours\" id=\""+attendancedate+"--"+date+"totaltime\" readonly=\"readonly\" style=\"height:25px;width:130px;\" value=\""+totalHoursValue+"\" />";
	return totalHours;
	}



}
