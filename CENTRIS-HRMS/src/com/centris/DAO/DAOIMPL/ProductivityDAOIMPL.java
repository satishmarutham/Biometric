package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import com.centris.DAO.DBService;
import com.centris.DAO.ProductivityDAO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ProductivityStatusList;
import com.centris.form.ProductivityForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class ProductivityDAOIMPL extends DBService implements ProductivityDAO {
	private static Logger logger = Logger.getLogger(ProductivityDAOIMPL.class);

	public ArrayList<EmployeeFilterVO> getEmployeesByDept(EmployeeFilterVO b)

	{
		System.out.println("productivitydaoimpl");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProductivityDAOIMPL: getEmployeesByDept Starting");

		Connection con = null;
		PreparedStatement pst_emp = null;
		ResultSet rs_emp = null;

		ArrayList<EmployeeFilterVO> emplist = new ArrayList<EmployeeFilterVO>();

		System.out.println(emplist);

		try {

			con = getConnection();

			String[] deptList = b.getDepartmentCode().split(",");

			// String temp_department= "'" + b.replaceAll(",", "','") + "'";

			// pst_emp =
			// con.prepareStatement("select emp.First_Name from hrms_employee emp join hrms_department dept on dept.DEPT_ID= emp.DEPT_ID where DEPT_ID like ? ");

			for (int i = 0; i < deptList.length; i++) {

				pst_emp = con
						.prepareStatement(SQLutilConstants.GET_EMP_BY_DEPT);

				pst_emp.setString(1, "%" + deptList[i] + "%");

				System.out.println("query ::: " + pst_emp);

				rs_emp = pst_emp.executeQuery();

				while (rs_emp.next())

				{
					EmployeeFilterVO empvo = new EmployeeFilterVO();

					empvo.setEmpid(rs_emp.getString("EMPID"));

					empvo.setEmpname(rs_emp.getString("employeename"));

					emplist.add(empvo);
				}

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (rs_emp != null && (!rs_emp.isClosed())) {
					rs_emp.close();

				}
				if (pst_emp != null && (!pst_emp.isClosed())) {
					pst_emp.close();

				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ProductivityDAOIMPL : getEmployeesByDept Ending");

		JSONArray array = new JSONArray();
		array.put(emplist);

		System.out.println("employee list ::: " + array);

		return emplist;

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * EmployeeFilterVO vo=new EmployeeFilterVO();
	 * vo.setDepartmentCode("DEP1,DEP2"); new
	 * ProductivityDAOIMPL().getEmployeesByDept(vo); }
	 */

	// get bProductivity Form

	public ArrayList<EmployeeFilterVO> getProductivityReport(
			ProductivityForm productivitybean)

	{

		System.out.println("DAOIMPL submit");

		Connection con = null;

		PreparedStatement pst_emp = null;

		ResultSet rs_emp = null;

		ArrayList<EmployeeFilterVO> emplist = new ArrayList<EmployeeFilterVO>();

		try {

			con = getConnection();

			// String[] deptList= productivitybean.getDepartment();

			String[] empList = productivitybean.getEmployee();

			pst_emp = con.prepareStatement(SQLutilConstants.GET_EMP_ATT);

			for (int j = 0; j < empList.length; j++)

			{
				// System.out.println(empList[j]);

				pst_emp.setString(1, empList[j]);

				pst_emp.setString(2, HelperClass
						.convertUIToDatabase(productivitybean.getStartdate()));

				pst_emp.setString(3, HelperClass
						.convertUIToDatabase(productivitybean.getEnddate()));

				System.out.println("query ::: " + pst_emp);

				rs_emp = pst_emp.executeQuery();

				EmployeeFilterVO empvo = new EmployeeFilterVO();

				ProductivityStatusList list = new ProductivityStatusList();

				ArrayList<ProductivityStatusList> StatusList = new ArrayList<ProductivityStatusList>();

				while (rs_emp.next())

				{
					System.out.println("Inside while loop");

					String s1 = rs_emp.getString("totaltime");
					String s2 = rs_emp.getString("TOTAL_WORKING_HOURS");
					String permission_hrs = HelperClass.getTimeDifference(s2,s1);

					list.setWorking_hrs(rs_emp.getString("TOTAL_WORKING_HOURS"));
					list.setTotal_hrs(rs_emp.getString("totaltime"));
					list.setPermission_hrs(permission_hrs);
					list.setEmpname(rs_emp.getString("First_Name"));
					StatusList.add(list);

					// EmployeeFilterVO empvo = new EmployeeFilterVO();

					empvo.setEmpname(rs_emp.getString("First_Name"));
					empvo.setIntime(rs_emp.getString("intime"));
					empvo.setOuttime(rs_emp.getString("outtime"));
					empvo.setTotaltime(rs_emp.getString("totaltime"));
					empvo.setWorking_hours(rs_emp
							.getString("TOTAL_WORKING_HOURS"));
					empvo.setPermission_hours(permission_hrs);
					/*
					 * System.out.println(s1); System.out.println(s2);
					 * System.out.println(permission_hrs);
					 * System.out.println(rs_emp.getString("First_Name"));
					 * System.out.println(rs_emp.getString("intime"));
					 * System.out.println(rs_emp.getString("outtime"));
					 * System.out.println(rs_emp.getString("totaltime"));
					 */
					emplist.add(empvo);

				}

			}

		}

		catch (Exception e1) {
			e1.printStackTrace();

		}

		JSONArray array = new JSONArray();
		array.put(emplist);
		System.out.println("employee list ::: " + array);

		return emplist;
	}

	public static void main(String[] args) {

		ProductivityForm form = new ProductivityForm();
		String[] employee = { "EMP14", "EMP6", "EMP16", };
		form.setEmployee(employee);
		form.setEnddate("5-02-2015");
		form.setStartdate("31-01-2015");

		new ProductivityDAOIMPL().getProductivityReport(form);
	}

}
