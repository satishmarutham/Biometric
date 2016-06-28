package com.centris.util.SQLUtils;

public class KendoSQLtableconstants {
	public static final String GET_EMP_ATTENDENCE_DETAILS="select sum(case when att.Attedence_Status='present' then 1 else 0 end)PresentCount,sum(case when att.Attedence_Status='absent' then 1 else 0 end)AbsentCount,dep.DEPT_NAME from hrms_employee_attendance att join hrms_employee emp on att.EMPID = emp.EMPID join hrms_department dep on dep.DEPT_ID = emp.DEPT_ID where att.Attendence_Date = ? group by dep.DEPT_NAME";
}
