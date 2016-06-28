package com.centris.util.constants;

public class Contants {

	public static String SHIFT_ID = "shift_id";
	public static String SHIFT_NAME;
	public static String START_NAME;
	public static String END_NAME;
	public static String LATE_TO_COME;
	public static String EARLY_TO_GO;
	public static String LATE_TO_COME_GRACE_TIME;
	public static String EARLY_TO_GO_GRACE_TIME;
	public static String LATE_TO_COME_NO_EXCUSE;
	public static String EARLY_TO_GO_NO_EXCUSE;
	public static String LATE_TO_COME_DAYS_DEDUCT;
	public static String EARLY_TO_GO_DAYS_DEDUCT;



	
	
	
	public static final String GET_SHIFT_BY_LOCATION="select ai_shift_id,AI_SHIFT_NAME from ai_shift_deatails where Location=?";
	public static final String GET_EMP_BY_LOCATION_SHIFT="select EMPID,EMPNAME from ai_emp_details where Location=? and SHIFT_ID=?";
	public static final String SUCCESS= "success";


}