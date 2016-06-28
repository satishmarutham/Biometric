package com.centris.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONException;
import org.json.JSONObject;

import com.centris.VO.KendoReportVo;
import com.centris.delegate.KendoReportBD;

public class KendoReportAction extends DispatchAction {

	public ActionForward getEmpAttendanceDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out
				.println("Control in KendoReportAction : getEmpAttendanceDetails ");

		ArrayList<KendoReportVo> allDetails = new ArrayList<KendoReportVo>();
		KendoReportBD obj = new KendoReportBD();

		String todaydate = "2015-07-08";
		try {
			allDetails = obj.getReportCountDetails(todaydate);

			JSONObject jsonObject = new JSONObject(allDetails);
			jsonObject.accumulate("allDetails", allDetails);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
