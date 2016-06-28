package com.centris.service.serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.centris.DAO.DBService;
import com.centris.DAO.DAOIMPL.LogReportDAOImpl;
import com.centris.DAO.DAOIMPL.MonthReportDaoImpl;
import com.centris.POJO.GroupLogReportPojo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GroupLogReportVo;
import com.centris.VO.LocationSortVo;
import com.centris.VO.LogReportVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.form.LogReportForm;
import com.centris.service.LogReportService;
import com.centris.util.HelperClass;

public class LogReportServiceImpl implements LogReportService {

	@Override
	public List<EmployeeVO> getEmployeeByDesignation(String designationId) {
		return new LogReportDAOImpl().getEmployeeByDesignation(designationId);
	}

	@Override
	public List<LogReportVO> getLogReport(LogReportForm logReportForm) {
		return new LogReportDAOImpl().getLogReport(logReportForm);
	}

	@Override
	public List<EmployeeVO> getMangerInfo() {
		return new LogReportDAOImpl().getMangerInfo();
	}

	public List<EmployeeVO> getEmpDetailsByLocation(LogReportForm logReportForm) {
		return new LogReportDAOImpl().getEmpDetailsByLocation(logReportForm);
	}

	public Map<String, Map<String, List<GroupLogReportVo>>> getGroupLogReportDetails(
			GroupLogReportPojo groupLogReportPojo) {

		Map<String, Map<String, List<GroupLogReportVo>>> consolidatedMap = new LinkedHashMap<String, Map<String, List<GroupLogReportVo>>>();

		Map<String, List<GroupLogReportVo>> listMap = null;
		Connection conn =null;
		try {
			
			DBService dbService = new DBService();
			
			conn = dbService.getConnection();
			
			LogReportDAOImpl listDao = new LogReportDAOImpl();

			String minDate = groupLogReportPojo.getYearName().trim() + "-"
					+ groupLogReportPojo.getMonthName().trim() + "-01";

			String maxDay = HelperClass.lastDayOftheMonth(groupLogReportPojo
					.getYearName().trim(), groupLogReportPojo.getMonthName()
					.trim());
			String maxDate = groupLogReportPojo.getYearName().trim() + "-"
					+ groupLogReportPojo.getMonthName().trim() + "-" + maxDay;

			List<String> allDates = HelperClass.getDateListBetweenDates(
					minDate, maxDate);
				
			String temp_location[]=groupLogReportPojo.getLocationName().split(",");
			
			String LocatioName = null;

		/*		List<String> allLocations = listDao
						.getAllLocationDetails(groupLogReportPojo,conn);
				String[] stockArr = new String[allLocations.size()];
				stockArr = allLocations.toArray(stockArr);*/

				Arrays.sort(temp_location, new LocationSortVo());
							
				for(int k=0;k<temp_location.length;k++)
				{
					listMap = new LinkedHashMap<String, List<GroupLogReportVo>>();
					for (int i = 0; i < allDates.size(); i++) {							
						List<GroupLogReportVo> voList = new ArrayList<GroupLogReportVo>();
						voList = listDao.getGroupLogReportDetails(
								groupLogReportPojo, allDates.get(i), temp_location[k], conn);

						for (GroupLogReportVo vo : voList) {
							LocatioName = vo.getReport_Location();
						}
						Collections.sort(voList,
								new Comparator<GroupLogReportVo>() {
									@Override
									public int compare(GroupLogReportVo o1,
											GroupLogReportVo o2) {
										return o1.getReport_Date().compareTo(
												o2.getReport_Date());
									}
								});
						if (voList.size() > 0) {
							listMap.put(HelperClass
									.convertDatabaseToUI(allDates.get(i)),
									voList);
						}
					}
					consolidatedMap.put(LocatioName, listMap);
				}
					
		conn.close();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consolidatedMap;
	}

	public List<GroupLogReportVo> getLogDetailsForThisDate(
			GroupLogReportPojo pojoObj) {
		return new LogReportDAOImpl().getLogDetailsForThisDate(pojoObj);
	}
	
	 public  ArrayList<ManagerFilterVO> getManagersByDepartment(String[] departmentid,String userType,String userCode){
			
			return new LogReportDAOImpl().getManagersByDepartment(departmentid,userType,userCode);
			
		}
	 
		public ArrayList<EmployeeVO> getEmployees(String managerid_array,
				String[] departmentid_array) {
		
			return new LogReportDAOImpl().getEmployees(managerid_array,departmentid_array);
		}

	public static void main(String[] args) {

		GroupLogReportPojo kk = new GroupLogReportPojo();
		kk.setGroupName("GRP1");
		kk.setEmployeeName("%%");
		kk.setLocationName("%%");
		kk.setShiftName("%%");
		kk.setMonthName("10");
		kk.setYearName("2014");

		LogReportServiceImpl obj = new LogReportServiceImpl();
		obj.getGroupLogReportDetails(kk);
	}
	
}