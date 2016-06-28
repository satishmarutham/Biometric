package com.centris.util;

import org.displaytag.decorator.TableDecorator;

public class ActionDecorator extends TableDecorator {
	
	public String getStatus() {
		Reportclass report = (Reportclass)getCurrentRowObject();
		@SuppressWarnings("unused")
		String status = null;
		if(report.getStatus().equalsIgnoreCase(StringUtils.ABSENT)){
			return "<html>"+"<body>"+"<table>"+"<td bgcolor=#DC143C>"+ report.getStatus()+"</td>"+"</table>"+"</body>"+"</html>";
			
		}else if(report.getStatus().equalsIgnoreCase("present")){
			return status="<html>"+"<body>"+"<table>"+"<td bgcolor=#5757FF>"+ report.getStatus()+"</td>"+"</table>"+"</body>"+"</html>";
				}
		return report.getStatus();	
	}	
}
