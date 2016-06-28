package com.centris.decorator;

import org.displaytag.decorator.ColumnDecorator;
import org.displaytag.decorator.TableDecorator;
import org.displaytag.exception.DecoratorException;

import com.centris.POJO.DayReportPojo;

public class DayReportDecorator implements ColumnDecorator {

	/* public String addRowClass()
     {
         return ((DayReportPojo)getCurrentRowObject()).getAttendenceStatus().equalsIgnoreCase("Absent")  ? "red" : "green";
     }
*/

	@Override
	public String decorate(Object dayReportPojo) throws DecoratorException {
		String str;
		if (dayReportPojo.getClass().equals(String.class)) {
			if (((String) dayReportPojo).equalsIgnoreCase("Present") ) {
			str = "<span style=\"color:green;font-weight:bold;\">" +dayReportPojo + 
			"</span";
			} else {
			str = "<span style=\"color:red;font-weight:bold;\">" +dayReportPojo
			+ "</span>";
			}
			} else {
			str = dayReportPojo.toString();
			}
			return (str);
		
	}
}
