package com.centris.decorator;



import org.displaytag.decorator.TableDecorator;

import com.centris.VO.HolidayMasterVO;

/**
 * @author swathi
 * 
 */
public class HolidayMasterDecorator extends TableDecorator {

	public String getUpdate() {
		HolidayMasterVO careersViewVo = (HolidayMasterVO) getCurrentRowObject();
		String date = careersViewVo.getDate();
		String clientCode = careersViewVo.getClientCode();

		
	
		String result = "<input class=\"submitbutton\" type=\"button\" value=\"Update\" onclick='callDialgEdit(\""
				+ date + "," + clientCode + " \")'/>";
		
		
	
		return result;

	}

	public String getDelete() {
		HolidayMasterVO careersViewVo = (HolidayMasterVO) getCurrentRowObject();
		String date = careersViewVo.getDate();
		String clienCode = careersViewVo.getClientCode();

	

		String result = "<input class=\"submitbutton\" type=\"button\" value=\"Delete\" onclick='callDialgDelete(\"" + date +  "\",\""   + clienCode + " \")'/>";

	

		return result;

	}
}