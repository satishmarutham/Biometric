package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;
import com.centris.VO.LocationMasterVo;


/**
 * @author seshuma
 *
 */
public class LocationMasterDecorator extends TableDecorator {
	

	String check;

	public String getCheck() {
		
		 String chkbx = "";
			
		 LocationMasterVo locationvo=(LocationMasterVo)getCurrentRowObject();
			String locid=locationvo.getLocationid();
			
			chkbx = "<input type='checkbox' name='locid'  value='"+locid+"' id='" + locid + "' />";
			
			return chkbx;
		
	}

}
