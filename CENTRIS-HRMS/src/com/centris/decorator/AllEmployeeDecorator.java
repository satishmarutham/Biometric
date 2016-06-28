package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;
import com.centris.VO.AllEmployeeVo;


/**
 * @author seshuma
 *
 */
public class AllEmployeeDecorator extends TableDecorator {

	public String getEdit() {
		AllEmployeeVo alldata = (AllEmployeeVo) getCurrentRowObject();
		String name = alldata.getEmpname();

		return "<span onclick='callDialg(\"" + name + "\")'>edit</span>";
	}
}
