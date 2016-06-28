package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;
import com.centris.VO.ManualAttendanceVO;

public class ManualAttendanceDecorator extends TableDecorator {
	String status = null;

	public String getStatus() {
		status = "";
		ManualAttendanceVO obj = (ManualAttendanceVO) getCurrentRowObject();

		if (obj.getAttStatus().equalsIgnoreCase("absent")) {

			status = "<select  class='empStatus'>" + "<option value='absent' selected>" + "Absent" + "</option>"
					+ "<option value='present'>" + "Present"
					+ "</option>" + "</select>";
		}
		return status;
	}
}
