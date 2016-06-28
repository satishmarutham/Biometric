package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.AddDesignationVO;


/**
 * @author seshuma
 *
 */
public class AddDesignationDecorator extends TableDecorator {
	
	String check;

	public String getCheck() {
		
		 String chkbx = "";
			
		 AddDesignationVO designationvo=(AddDesignationVO)getCurrentRowObject();
			String desid=designationvo.getDesgid();
			
			chkbx = "<input type='checkbox' name='desname'  value='"+desid+"' id='" + desid + "' />";
			
			return chkbx;
		
	}
	
	

}
