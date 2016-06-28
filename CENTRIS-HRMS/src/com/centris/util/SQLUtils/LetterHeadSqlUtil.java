package com.centris.util.SQLUtils;

public class LetterHeadSqlUtil {

	public static final String INSERT_lETTER_HEAD = "insert into hrms_employee_letterhead_request(LetterHeadCode,LetterType,Purpose,Description,CreatedBy,CreateDate)values(?,?,?,?,?,now())";
	public static final String GET_ALL_LETTERHEADS = "select LetterType,Purpose,Description,Status,CreateDate from hrms_employee_letterhead_request where CreatedBy=?";
	public static final String GET_lETTER_HEAD_COUNT = "select count(*) from hrms_employee_letterhead_request where LetterType= ? and Purpose=? and Description=? and CreatedBy=? ";

}
