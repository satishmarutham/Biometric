/**
 * 
 */
package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.POJO.ManagerLeaveConfirmationPojo;


/**
 * @author sathish
 *
 */
public class ManagerLeaveConfirmationDecorator extends TableDecorator {
	String viewButton;

	public String getViewButton() {

		String btn = "";
		ManagerLeaveConfirmationPojo currentreq = (ManagerLeaveConfirmationPojo) getCurrentRowObject();
		int reqSno = currentreq.getSno();

		btn = "<input type='button' class='submitbutton' name='sno' value=\"View\" id='"
				+ reqSno + "'  onclick='openDailog(" + reqSno + ")'/>";

		return btn;
	}
	

}
