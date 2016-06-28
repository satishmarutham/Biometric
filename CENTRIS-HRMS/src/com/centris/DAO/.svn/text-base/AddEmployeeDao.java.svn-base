package com.centris.DAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.AddEmployeePojo;
import com.centris.VO.AllEmployeeVo;
import com.centris.VO.RemoveEmployeeVo;


/**
 * @author seshuma
 *
 */
public interface AddEmployeeDao {
	
	public String addEmployee(AddEmployeePojo emppojo);
	public boolean checkEmail(String email);
	public boolean checkEmpId(String empid);
	public ArrayList<RemoveEmployeeVo> getAllEmployees(String searchemp,String maxrows,String groupcode);
	public String removeEmployee(String empid,String modifiedby,Timestamp modifieddate);
	public List<AllEmployeeVo> getAllDisplayEmployee(String groupid);
	public List<AllEmployeeVo> getSerachofAllEmployee(String reqname);

}
