package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.TimesheetReconciliationVO;
import com.centris.util.HelperClass;

public class TimesheetReconciliationDecorator extends TableDecorator {
	
	
	public String getDate(){
		TimesheetReconciliationVO mapData = (TimesheetReconciliationVO) getCurrentRowObject();
		String date="<input type=\"text\" class=\"attendanceClass\" readonly=\"readonly\" style=\"height:25px;width:130px;\" value=\""+HelperClass.convertDatabaseToUI(mapData.getDate())+"\"/>";
		return date;
	}

	
	public String getInTime(){
		TimesheetReconciliationVO mapData = (TimesheetReconciliationVO) getCurrentRowObject();
		String intimeValue="00:00:00";
		if(mapData.getInTime()!=null)
			intimeValue=mapData.getInTime();

	String inTime=	"<div  class=\"input-append inTimeClass\">	<input type=\"text\" title=\"Click On Time Image\" id=\"intime\" name=\"intime\" readonly=\"readonly\" style=\"height:25px;width:130px;\"	data-format=\"hh:mm:ss\" value=\""+intimeValue+"\" />	<span class=\"add-on\"> <img src=\"./images/time.jpg\"	title=\"Click Here\" width=\"25\" height=\"10\"></img></span>	</div>";
	return inTime;
	}
	
	public String getOutTime(){
		TimesheetReconciliationVO mapData = (TimesheetReconciliationVO) getCurrentRowObject();
		String outtimeValue="00:00:00";
		if(mapData.getOutTime()!=null)
			outtimeValue=mapData.getOutTime();
	String outTime=	"<div  class=\"input-append outTimeClass\">	<input type=\"text\" title=\"Click On Time Image\" id=\"outtime\" name=\"outtime\" readonly=\"readonly\" style=\"height:25px;width:130px;\"	data-format=\"hh:mm:ss\" value=\""+outtimeValue+"\" />	<span class=\"add-on\"> <img src=\"./images/time.jpg\"	title=\"Click Here\"	width=\"25\" height=\"10\"></img></span>	</div>";
	return outTime;
	}
	
	
	public String getTotalHours(){
		TimesheetReconciliationVO mapData = (TimesheetReconciliationVO) getCurrentRowObject();
		String totalHoursValue="00:00:00";
		if(mapData.getTotalHours()!=null)
			totalHoursValue=mapData.getTotalHours();
	String totalHours=	"<input type=\"text\" name=\"totalhours\" class=\"totalhours\" readonly=\"readonly\" style=\"height:25px;width:130px;\" value=\""+totalHoursValue+"\"  onclick=\"getTime()\" />";
	return totalHours;
	}
	
	public String getWorkingHours(){
		TimesheetReconciliationVO mapData = (TimesheetReconciliationVO) getCurrentRowObject();
		String workingHourValue="00:00:00";
		if(mapData.getWorkingHours()!=null)
			workingHourValue=mapData.getWorkingHours();
	String workingHour=	"<input type=\"text\" name=\"workedhours\" class=\"workinghours\" readonly=\"readonly\" style=\"height:25px;width:130px;\" value=\""+workingHourValue+"\" />";
	return workingHour;
	}
	
	public String getMorningLate(){
		TimesheetReconciliationVO mapData = (TimesheetReconciliationVO) getCurrentRowObject();
		
		String optionString="";
	
			if(mapData.getMorningLate() != null && mapData.getMorningLate().equals("Late")){
				 optionString=optionString+"<option value=\"OnTime\">OnTime</option><option selected=\"selected\" value=\"Late\">Late</option>";
			}
			else{
				optionString=optionString+"<option selected=\"selected\" value=\"OnTime\">OnTime</option><option selected=\"selected\" value=\"Late\">Late</option>";
			}
		String morningLate = "<select  style=\"height:35px;width:90%;\" class=\"morningLate\" id=\"shift_"+mapData.getEmpId()+"\"> "+optionString+"</select>";
		return morningLate;
	}
	
	public String getEveningEarly(){
		TimesheetReconciliationVO mapData = (TimesheetReconciliationVO) getCurrentRowObject();
		
		String optionString="";
	
			if(mapData.getEveningEarly() != null && mapData.getEveningEarly().equals("Early")){
				 optionString=optionString+"<option value=\"OnTime\">OnTime</option><option selected=\"selected\" value=\"Early\">Early</option>";
			}
			else{
				optionString=optionString+"<option selected=\"selected\" value=\"OnTime\">OnTime</option><option selected=\"selected\" value=\"Early\">Early</option>";
			}
		String eveningEarly = "<select  style=\"height:35px;width:90%;\" class=\"eveningEarly\" id=\"shift_"+mapData.getEmpId()+"\"> "+optionString+"</select>";
		return eveningEarly;
	}
	

	public String getSaveButton(){
		TimesheetReconciliationVO mapData = (TimesheetReconciliationVO) getCurrentRowObject();
	String saveButton=	"<input type=\"button\"  class=\"savebutton button1\" style=\"height:32px;width:110px;\" id=\""+mapData.getEmpId()+","+mapData.getAttendancedate()+"\" value=\"Update\" />";
	return saveButton;
	}
	
}
