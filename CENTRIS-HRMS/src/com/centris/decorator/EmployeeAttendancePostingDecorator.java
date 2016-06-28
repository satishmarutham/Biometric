package com.centris.decorator;

import java.util.List;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.ClientVO;
import com.centris.VO.EmployeeAttendancePostingVo;

public class EmployeeAttendancePostingDecorator extends TableDecorator {

	public String getStatus() {

		EmployeeAttendancePostingVo voObj = (EmployeeAttendancePostingVo) getCurrentRowObject();

		List<String> statusDetails = voObj.getAttendanceStatusList();

		String optionString = "<option value=\"\" selected=\"selected\">----Select----</option>";

		for (int i = 0; i < statusDetails.size(); i++) {

			optionString = optionString + "<option value=\""
					+ statusDetails.get(i)+ "\">"
					+ statusDetails.get(i)+ "</option>";
		}

		String finalList = "<select class=\"statusVal\" style=\"height:140%;width:90%;\" > "
				+ optionString + "</select>";
		return finalList;
	}
	
	public String getClients() {
		EmployeeAttendancePostingVo voObj = (EmployeeAttendancePostingVo) getCurrentRowObject();
		String optionString = "<option value=\"\" selected=\"selected\">--Select--</option>";
		List<ClientVO> clientList = voObj.getClientlist();
		for (int i = 0; i < clientList.size(); i++) {

			optionString = optionString + "<option value=\""
					+ clientList.get(i).getClientcode()+ "\">"
					+ clientList.get(i).getClientname()+ "</option>";
		}
		String finalList = "<select class=\"projectVal\" style=\"width:100%;height:140%;\" > "
				+ optionString + "</select>";
		return finalList;
	}


	public String getDate() {

		EmployeeAttendancePostingVo voObj = (EmployeeAttendancePostingVo) getCurrentRowObject();
		String text = "";
		text = "<span class=\"dateVal\" style=\"width:85%;height:100%;\">"
				+ voObj.getGet_attDate() + "</span>";

		return text;
	}

	public String getLocation() {

		String text = "";

		text = "<input type=\"text\" style=\"width:90%;height:140%;\" name=\"locationVal\" maxlength=\"25\"  placeholder=\"Location Name here \" value=\" \" />";

		return text;
	}
	
	public String getDescription() {

		String text = "";

		text = "<textarea  style=\"width:80%;height:100%;\" name=\"description\" rows=\"2\" cols=\"22\"  placeholder=\"Description here \" value=\" \" ></textarea>";

		return text;
	}
	
	
	
	
	public String getIntime(){
	String inTime=	"<div  class=\"input-append inTimeClass\">	<input type=\"text\" title=\"Click On Time Image\" id=\"intime\" name=\"intimeVal\" readonly=\"readonly\" style=\"height:20px;width:80px;\"	data-format=\"hh:mm:ss\" value=\"00:00:00\" />	<span class=\"add-on\"> <img src=\"./images/time.jpg\"	title=\"Click Here\" width=\"20\" height=\"20\"></img></span>	</div>";
	return inTime;
	}
	
	public String getOuttime(){
	String outTime=	"<div  class=\"input-append outTimeClass\">	<input type=\"text\" title=\"Click On Time Image\" id=\"outtime\" name=\"outtimeVal\" readonly=\"readonly\" style=\"height:20px;width:80px;\"	data-format=\"hh:mm:ss\" value=\"00:00:00\" />	<span class=\"add-on\"> <img src=\"./images/time.jpg\"	title=\"Click Here\"	width=\"20\" height=\"20\"></img></span>	</div>";
	return outTime;
	}
	
	public String getTotaltime() {

		String text = "";

		text = "<input type=\"text\" style=\"height:20px;width:80px;background:#E0E0D1;\" name=\"totaltimeVal\" placeholder=\"Outtime Name here \" readonly=\"readonly\" value=\"00:00:00 \" />";

		return text;
	}

	public String getManager() {

		EmployeeAttendancePostingVo voObj = (EmployeeAttendancePostingVo) getCurrentRowObject();

		List<EmployeeAttendancePostingVo> managerDetails = voObj
				.getGet_Project_ManagerList();

		String optionString = "<option value=\"\" selected=\"selected\">--Select--</option>";
		
		System.out.println("director list ::: "+managerDetails.size());

		for (int i = 0; i < managerDetails.size(); i++) {

			System.out.println("director  :: "+managerDetails.get(i).getGet_ManagerCode());
			System.out.println("director name  :: "+managerDetails.get(i).getGet_ManagerName());
			
			optionString = optionString + "<option value=\""
					+ managerDetails.get(i).getGet_ManagerCode() + "\">"
					+ managerDetails.get(i).getGet_ManagerName() + "</option>";
		}

		String finalList = "<select class=\"managerVal\" style=\"width:90%;height:140%;\" > "
				+ optionString + "</select>";
		return finalList;
	}

	public String getType() {

		EmployeeAttendancePostingVo voObj = (EmployeeAttendancePostingVo) getCurrentRowObject();

		List<EmployeeAttendancePostingVo> attTypedetails = voObj
				.getGet_statusTypeList();

		String optionString ="<option value=\"\" selected=\"selected\">--Select--</option>";

		for (int i = 0; i < attTypedetails.size(); i++) {

			optionString = optionString + "<option value=\""
					+ attTypedetails.get(i).getGet_statusTypeCode() + "\">"
					+ attTypedetails.get(i).getGet_statusTypeName()
					+ "</option>";
		}
		String finalList = "<select class=\"statusTypeVal\" style=\"width:90%;height:140%;\" > "
				+ optionString + "</select>";
		return finalList;
	}
}
