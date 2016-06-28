/**
 * 
 */
package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.POJO.EmployeeLeaveStatusPojo;

/**
 * @author sathish
 *
 */
public class EmployeeLeaveStatusDecorator extends TableDecorator{
	String viewButton;

	public String getViewButton() {

		String btn = "";
		EmployeeLeaveStatusPojo currentreq = (EmployeeLeaveStatusPojo)getCurrentRowObject();
		int reqSno = currentreq.getSno();

		btn = "<input type='button' class='submitbutton' name='sno' value=\"View\" id='"
				+ reqSno + "'  onclick='openDailog(" + reqSno + ")'/>";

		return btn;

}
}