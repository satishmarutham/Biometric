package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;
import com.centris.VO.AttendenceApprovelVo;

public class AttendanceApprovelDecorator extends TableDecorator {
	
	
	public String getInTime(){
		AttendenceApprovelVo mapData = (AttendenceApprovelVo) getCurrentRowObject();
		String intimeValue="00:00:00";
		if(mapData.getIntime()!=null)
			intimeValue=mapData.getIntime();
		String attendancedate=mapData.getAttendencedate();

	String inTime=	"<div  class=\"input-append inTimeClass"+attendancedate+"\">	<input type=\"text\" title=\"Click On Time Image\" id=\""+attendancedate+"intime1\" name=\"intime\" class=\"intime\" readonly=\"readonly\" style=\"height:25px;width:100px !important;\"	data-format=\"hh:mm:ss\" value=\""+intimeValue+"\" />	<span class=\"add-on\"> <img src=\"./images/time.jpg\"	title=\"Click Here\" width=\"25\" height=\"10\"></img></span>	</div>";
	return inTime;
	}
	
	public String getOutTime(){
		AttendenceApprovelVo mapData = (AttendenceApprovelVo) getCurrentRowObject();
		String outtimeValue="00:00:00";
		if(mapData.getOuttime()!=null)
			outtimeValue=mapData.getOuttime();
		String attendancedate=mapData.getAttendencedate();
	String outTime=	"<div  class=\"input-append outTimeClass"+attendancedate+"\">	<input type=\"text\" title=\"Click On Time Image\" id=\""+attendancedate+"outtime\" name=\"outtime\" class=\"outtime\" readonly=\"readonly\" style=\"height:25px;width:100px !important;\"	data-format=\"hh:mm:ss\" value=\""+outtimeValue+"\" />	<span class=\"add-on\"> <img src=\"./images/time.jpg\"	title=\"Click Here\"	width=\"25\" height=\"10\"></img></span>	</div>";
	return outTime;
	}
	
	
	public String getTotalHours(){
		AttendenceApprovelVo mapData = (AttendenceApprovelVo) getCurrentRowObject();
		String totalHoursValue="00:00:00";
		if(mapData.getTotaltime()!=null)
			totalHoursValue=mapData.getTotaltime();
		String attendancedate=mapData.getAttendencedate();
	String totalHours=	"<input type=\"text\" name=\"totalhours\" class=\"totalhours\" id=\""+attendancedate+"totaltime\" readonly=\"readonly\" style=\"height:25px;width:130px;\" value=\""+totalHoursValue+"\" />";
	return totalHours;
	}

}
