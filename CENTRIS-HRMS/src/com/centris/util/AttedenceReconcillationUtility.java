package com.centris.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.action.AttendanceReConcilationAction;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class AttedenceReconcillationUtility {

	
	private static Logger logger = Logger.getLogger(AttedenceReconcillationUtility.class);
	public ArrayList<String> getReasonAndShortName(String val) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttedenceReconcillationUtility:getReasonAndShortName Starting");
	try{

		Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

		// adding first element
		ArrayList<String> listdata1 = new ArrayList<String>();
		listdata1.add("Casual leave-CL");
		listdata1.add("CL");
		map.put(1, listdata1);

		// adding second element
		ArrayList<String> listdata2 = new ArrayList<String>();
		listdata2.add("Sick Leave -SL");
		listdata2.add("SL");
		map.put(2, listdata2);

		// adding third element

		ArrayList<String> listdata3 = new ArrayList<String>();
		listdata3.add("Earned leave -EL");
		listdata3.add("EL");
		map.put(3, listdata3);

		// adding fourth element

		ArrayList<String> listdata4 = new ArrayList<String>();
		listdata4.add("General Holiday -H");
		listdata4.add("H");
		map.put(4, listdata4);

		// adding fifth element

		ArrayList<String> listdata5 = new ArrayList<String>();
		listdata5.add("Weekly Off - w");
		listdata5.add("W");
		map.put(5, listdata5);

		// adding sixth element

		ArrayList<String> listdata6 = new ArrayList<String>();
		listdata6.add("On Duty -  OD");
		listdata6.add("OD");
		map.put(6, listdata6);

		// adding seventh element

		ArrayList<String> listdata7 = new ArrayList<String>();
		listdata7.add("Compensation off -CO");
		listdata7.add("CO");
		map.put(7, listdata7);

		// adding eighth element

		ArrayList<String> listdata8 = new ArrayList<String>();
		listdata8.add("ESI-Leave -ESI");
		listdata8.add("ESI");
		map.put(8, listdata8);

		// adding NINEth element

		ArrayList<String> listdata9 = new ArrayList<String>();
		listdata9.add("Maternity leave -ML");
		listdata9.add("ML");
		map.put(9, listdata9);

		// getting map values
		
		ArrayList<String> al = map.get(Integer.parseInt(val));
		return al;
	
	}catch(Exception e){
		e.printStackTrace();
		logger.error(e);
	}
		
	JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttedenceReconcillationUtility:getReasonAndShortName  Ending");
		return null;
	}

}
