package com.centris.util.Helper;


import org.displaytag.decorator.TableDecorator;

import com.centris.VO.HolidayMasterVO;


/**
 * @author seshuma
 *
 */
public class HolidayMasterDecorator extends TableDecorator{
	
	public String getEdit()
	{
		HolidayMasterVO careersViewVo = (HolidayMasterVO)getCurrentRowObject();
		String date=careersViewVo.getDate();
		String deptid=careersViewVo.getDepId();
		
		return "<span onclick='callDialgEdit(\""+date+","+deptid+"\")'>EDIT</span>";
		
	}
	public String getDelete()
	{
		HolidayMasterVO careersViewVo = (HolidayMasterVO)getCurrentRowObject();
		String date=careersViewVo.getDate();
		String deptid=careersViewVo.getDepId();
		
		System.out.println(deptid);
		
		return "<span onclick='callDialgDelete(\""+date+","+deptid+"\")'>DELETE</span>";
	
	}  
}