package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.ExpenseReportDao;
import com.centris.POJO.ExpenseReportPojo;
import com.centris.VO.ExpenseReportVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.ExpenseReportSqlUtil;
import com.centris.util.SQLUtils.TravelAllowancesReportSqlUtil;
import com.centris.util.constants.MessageConstants;

public class ExpenseReportDaoImpl extends DBService implements ExpenseReportDao{

	private static Logger logger = Logger.getLogger(ExpenseReportDaoImpl.class);
	
	public ArrayList<ExpenseReportVO> getAllAcadamicYearsDao() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExpenseReportDaoImpl : getAllAcadamicYearsDao Starting");
		
		Connection connection=null;
		PreparedStatement ps_expense=null;
		ResultSet rs_expense=null;
		ArrayList<ExpenseReportVO> allacadamicyearlist=new ArrayList<ExpenseReportVO>();
		try{
		
			connection =getConnection();
			ps_expense=connection.prepareStatement(ExpenseReportSqlUtil.GET_ALL_ACADAMICYEARS);
			rs_expense=ps_expense.executeQuery();
			while (rs_expense.next()) {
				
				ExpenseReportVO expenseReportVO=new ExpenseReportVO();
				expenseReportVO.setAcadamicyearcode(rs_expense.getString("AccyearCode"));
				expenseReportVO.setAcadamicyear(rs_expense.getString("AccadamicYear"));
				allacadamicyearlist.add(expenseReportVO);
			}
		
	  }catch(SQLException se){
		logger.error(se.getMessage(),se);
		se.printStackTrace();
	  }catch(Exception e){
		logger.error(e.getMessage(),e);
		e.printStackTrace();
	  }finally{
		try{
			if(rs_expense !=null && (!rs_expense.isClosed()))
			{
				rs_expense.close();
			}
			if(ps_expense !=null && (!ps_expense.isClosed()))
			{
				ps_expense.close();
			}
			if(connection !=null && (!connection.isClosed()))
			{
				connection.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ExpenseReportDaoImpl : getAllAcadamicYearsDao Ending");
	
		return allacadamicyearlist;
	}

	
	
	
	public Map<String, ArrayList<ExpenseReportVO>> getExpensesManagerWiseDao(ExpenseReportPojo expenseReportPojo) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExpenseReportDaoImpl : getExpensesManagerWiseDao Starting");
		
		Connection connection=null;
		PreparedStatement ps_expense=null;
		ResultSet rs_expense=null;
		int count=0;
		
		Map<String, ArrayList<ExpenseReportVO>> expensesmap=new LinkedHashMap<String, ArrayList<ExpenseReportVO>>();
		ArrayList<ExpenseReportVO> expenseslist=new ArrayList<ExpenseReportVO>();
		try{
		
			connection =getConnection();
			ps_expense=connection.prepareStatement(ExpenseReportSqlUtil.GET_EXPENSES_MANAGER_WISE);
			
			ps_expense.setString(1, expenseReportPojo.getCurusercode());
			ps_expense.setString(2, expenseReportPojo.getCurusercode());
			ps_expense.setString(3, expenseReportPojo.getStatus());
			ps_expense.setString(4,expenseReportPojo.getYear());
			ps_expense.setString(5,expenseReportPojo.getMonth());
		
			rs_expense=ps_expense.executeQuery();
			
			while (rs_expense.next()) {
				
				ExpenseReportVO expenseReportVO=new ExpenseReportVO();
				
		    if(expenseslist.size()!=0){
					
			     if(!(expenseslist.get(expenseslist.size()-1).getManagercode().equalsIgnoreCase(rs_expense.getString("ManagerCode")))){
						
				    expensesmap.put(expenseslist.get(expenseslist.size()-1).getManagername(), expenseslist);	
					
				   count=0;
				
				   expenseslist=new ArrayList<ExpenseReportVO>();
			    }
	        }
				
				
				count++;
				expenseReportVO.setSno(count);
				expenseReportVO.setYear(rs_expense.getString("year"));
				expenseReportVO.setMonthname(rs_expense.getString("monthname"));
				expenseReportVO.setManagercode(rs_expense.getString("ManagerCode"));
				expenseReportVO.setManagername(rs_expense.getString("manager"));
				expenseReportVO.setLocalconveyance(rs_expense.getDouble("Local_conveyance"));
				expenseReportVO.setTravelexpense(rs_expense.getDouble("Travel_expenses"));
				expenseReportVO.setStaffwelfare(rs_expense.getDouble("Staff_welfare"));
				expenseReportVO.setTelephoneexpense(rs_expense.getDouble("Telephone_expenses"));
				expenseReportVO.setPurchases(rs_expense.getDouble("Purchases"));
				expenseReportVO.setOtherworkexpenses(rs_expense.getDouble("other_work_expenses"));
				expenseReportVO.setMisllcellaneous(rs_expense.getDouble("Miscellaneous"));
				expenseReportVO.setTotalamountclaimed(rs_expense.getDouble("Total_amount_claimed"));
				
				if(rs_expense.getString("Advance_paid")!=null){
					expenseReportVO.setAdvancepaid(rs_expense.getDouble("Advance_paid"));
				}
				
				if(rs_expense.getString("Balance")!=null){
					expenseReportVO.setBalance(rs_expense.getDouble("Balance"));
				}
				expenseReportVO.setEmpname(rs_expense.getString("empname"));
				
				if(!(rs_expense.getString("apprvedamt").equalsIgnoreCase("-"))){
					expenseReportVO.setTotalamountapproved(rs_expense.getDouble("apprvedamt"));
				}
				
				expenseReportVO.setIsMangApproved(rs_expense.getString("isappvmang"));
				expenseReportVO.setIsDireApproved(rs_expense.getString("isappvdir"));
				expenseReportVO.setIsAccntApproved(rs_expense.getString("isappvaccnt"));
				
				if(!(rs_expense.getString("direapprvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setDireApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("direapprvdate")));
				}else{
					expenseReportVO.setDireApprovedDate(rs_expense.getString("direapprvdate"));
				}
				
				
				if(!(rs_expense.getString("accntappvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setAccntApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("accntappvdate")));
				}else{
					expenseReportVO.setAccntApprovedDate(rs_expense.getString("accntappvdate"));
				}
				
				
				
				if(!(rs_expense.getString("mangapprvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setMangApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("mangapprvdate")));
				}else{
					expenseReportVO.setMangApprovedDate(rs_expense.getString("mangapprvdate"));
				}
				
			   	expenseReportVO.setPosteddate(HelperClass.convertDatabaseToUI(rs_expense.getString("posteddate")));
				expenseReportVO.setApprovedAccntsname(rs_expense.getString("appradminname"));
				expenseReportVO.setApprovedDirename(rs_expense.getString("apprvdirename"));
						
				expenseslist.add(expenseReportVO);
			}
		
			if(expenseslist.size()!=0){
				
				expensesmap.put(expenseslist.get(expenseslist.size()-1).getManagername(), expenseslist);
				
			}
			
			
			
	  }catch(SQLException se){
		logger.error(se.getMessage(),se);
		se.printStackTrace();
	  }catch(Exception e){
		logger.error(e.getMessage(),e);
		e.printStackTrace();
	  }finally{
		try{
			if(rs_expense !=null && (!rs_expense.isClosed()))
			{
				rs_expense.close();
			}
			if(ps_expense !=null && (!ps_expense.isClosed()))
			{
				ps_expense.close();
			}
			if(connection !=null && (!connection.isClosed()))
			{
				connection.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}
		
	
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ExpenseReportDaoImpl : getExpensesManagerWiseDao Ending");
	
		return expensesmap;
	}

	
	public Map<String, ArrayList<ExpenseReportVO>> getExpensesProjectWiseDao(
			ExpenseReportPojo expenseReportPojo) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExpenseReportDaoImpl : getExpensesProjectWiseDao Starting");
		
		
		Connection connection=null;
		PreparedStatement ps_expense=null;
		ResultSet rs_expense=null;
		int count=0;
		
		Map<String, ArrayList<ExpenseReportVO>> expensesmap=new LinkedHashMap<String, ArrayList<ExpenseReportVO>>();
		ArrayList<ExpenseReportVO> expenseslist=new ArrayList<ExpenseReportVO>();
		try{
		
			connection =getConnection();
			ps_expense=connection.prepareStatement(ExpenseReportSqlUtil.GET_EXPENSES_PROJECT_WISE);
			
			ps_expense.setString(1, expenseReportPojo.getCurusercode());
			ps_expense.setString(2, expenseReportPojo.getCurusercode());
			ps_expense.setString(3, expenseReportPojo.getStatus());
			ps_expense.setString(4,expenseReportPojo.getYear());
			ps_expense.setString(5,expenseReportPojo.getMonth());
		
			rs_expense=ps_expense.executeQuery();
			
			
			while (rs_expense.next()) {
				
				ExpenseReportVO expenseReportVO=new ExpenseReportVO();
				
		    if(expenseslist.size()!=0){
					
			     if(!(expenseslist.get(expenseslist.size()-1).getProjectcode().equalsIgnoreCase(rs_expense.getString("ProjectCode")))){
						
				    expensesmap.put(expenseslist.get(expenseslist.size()-1).getProjectname(), expenseslist);	
					
				   count=0;
				
				   expenseslist=new ArrayList<ExpenseReportVO>();
			    }
	        }
				
				
				count++;
				expenseReportVO.setSno(count);
				expenseReportVO.setYear(rs_expense.getString("year"));
				expenseReportVO.setMonthname(rs_expense.getString("monthname"));
				expenseReportVO.setProjectname(rs_expense.getString("projectname"));
				expenseReportVO.setProjectcode(rs_expense.getString("ProjectCode"));
				expenseReportVO.setManagername(rs_expense.getString("manager"));
				expenseReportVO.setLocalconveyance(rs_expense.getDouble("Local_conveyance"));
				expenseReportVO.setTravelexpense(rs_expense.getDouble("Travel_expenses"));
				expenseReportVO.setStaffwelfare(rs_expense.getDouble("Staff_welfare"));
				expenseReportVO.setTelephoneexpense(rs_expense.getDouble("Telephone_expenses"));
				expenseReportVO.setPurchases(rs_expense.getDouble("Purchases"));
				expenseReportVO.setOtherworkexpenses(rs_expense.getDouble("other_work_expenses"));
				expenseReportVO.setMisllcellaneous(rs_expense.getDouble("Miscellaneous"));
				expenseReportVO.setTotalamountclaimed(rs_expense.getDouble("Total_amount_claimed"));
				
				if(rs_expense.getString("Advance_paid")!=null){
					expenseReportVO.setAdvancepaid(rs_expense.getDouble("Advance_paid"));
				}
				
				if(rs_expense.getString("Balance")!=null){
					expenseReportVO.setBalance(rs_expense.getDouble("Balance"));
				}
				expenseReportVO.setEmpname(rs_expense.getString("empname"));
				
				if(!(rs_expense.getString("apprvedamt").equalsIgnoreCase("-"))){
					expenseReportVO.setTotalamountapproved(rs_expense.getDouble("apprvedamt"));
				}
				
				expenseReportVO.setIsMangApproved(rs_expense.getString("isappvmang"));
				expenseReportVO.setIsDireApproved(rs_expense.getString("isappvdir"));
				expenseReportVO.setIsAccntApproved(rs_expense.getString("isappvaccnt"));
				
				if(!(rs_expense.getString("direapprvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setDireApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("direapprvdate")));
				}else{
					expenseReportVO.setDireApprovedDate(rs_expense.getString("direapprvdate"));
				}
				
				
				if(!(rs_expense.getString("accntappvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setAccntApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("accntappvdate")));
				}else{
					expenseReportVO.setAccntApprovedDate(rs_expense.getString("accntappvdate"));
				}
				
				
				
				if(!(rs_expense.getString("mangapprvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setMangApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("mangapprvdate")));
				}else{
					expenseReportVO.setMangApprovedDate(rs_expense.getString("mangapprvdate"));
				}
				
			   	expenseReportVO.setPosteddate(HelperClass.convertDatabaseToUI(rs_expense.getString("posteddate")));
				expenseReportVO.setApprovedAccntsname(rs_expense.getString("appradminname"));
				expenseReportVO.setApprovedDirename(rs_expense.getString("apprvdirename"));
						
				expenseslist.add(expenseReportVO);
			}
		
			if(expenseslist.size()!=0){
				
				expensesmap.put(expenseslist.get(expenseslist.size()-1).getProjectname(), expenseslist);
				
			}
			
			
			
	  }catch(SQLException se){
		logger.error(se.getMessage(),se);
		se.printStackTrace();
	  }catch(Exception e){
		logger.error(e.getMessage(),e);
		e.printStackTrace();
	  }finally{
		try{
			if(rs_expense !=null && (!rs_expense.isClosed()))
			{
				rs_expense.close();
			}
			if(ps_expense !=null && (!ps_expense.isClosed()))
			{
				ps_expense.close();
			}
			if(connection !=null && (!connection.isClosed()))
			{
				connection.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}
		
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ExpenseReportDaoImpl : getExpensesProjectWiseDao Ending");

	return expensesmap;
	
	}
	
	
	
	
public static void main(String[] args) {
	
	
	ExpenseReportPojo expenseReportPojo=new ExpenseReportPojo();
	expenseReportPojo.setCurusercode("DIR7");
	expenseReportPojo.setStatus("%%");;
	expenseReportPojo.setMonth("%%");
	expenseReportPojo.setYear("4");
	
	new ExpenseReportDaoImpl().getExpensesfordownload(expenseReportPojo);
	
}




   public ArrayList<ExpenseReportVO> getExpensesfordownload(ExpenseReportPojo expenseReportPojo) {
		
	   logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExpenseReportDaoImpl : getExpensesfordownload Starting");
		
		
		Connection connection=null;
		PreparedStatement ps_expense=null;
		ResultSet rs_expense=null;
		int count=0;
	  
		ArrayList<ExpenseReportVO> expenseslist=new ArrayList<ExpenseReportVO>();
		try{
		
			connection =getConnection();
			
			if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(expenseReportPojo.getGroupby())){
	            
				ps_expense=connection.prepareStatement(ExpenseReportSqlUtil.GET_EXPENSES_FOR_DOWNLOAD_MANAGER_WISE);
			 }
			
			ps_expense.setString(1, expenseReportPojo.getCurusercode());
			ps_expense.setString(2, expenseReportPojo.getCurusercode());
			ps_expense.setString(3, expenseReportPojo.getStatus());
			ps_expense.setString(4,expenseReportPojo.getYear());
			ps_expense.setString(5,expenseReportPojo.getMonth());
		
			rs_expense=ps_expense.executeQuery();
			System.out.println("ps_expense ::"+ps_expense);
			
			while (rs_expense.next()) {
				
				ExpenseReportVO expenseReportVO=new ExpenseReportVO();
						
				count++;
				expenseReportVO.setSno(count);
				expenseReportVO.setYear(rs_expense.getString("year"));
				
				if(expenseReportPojo.getMonth().equalsIgnoreCase("%%")){
					expenseReportVO.setMonthforheader(MessageConstants.ALL);
				}else{
					expenseReportVO.setMonthforheader(rs_expense.getString("monthname"));
				}
				expenseReportVO.setMonthname(rs_expense.getString("monthname"));	
							
				
				expenseReportVO.setManagercode(rs_expense.getString("ManagerCode"));
				expenseReportVO.setManagername(rs_expense.getString("manager"));
				expenseReportVO.setLocalconveyance(rs_expense.getDouble("Local_conveyance"));
				expenseReportVO.setTravelexpense(rs_expense.getDouble("Travel_expenses"));
				expenseReportVO.setStaffwelfare(rs_expense.getDouble("Staff_welfare"));
				expenseReportVO.setTelephoneexpense(rs_expense.getDouble("Telephone_expenses"));
				expenseReportVO.setPurchases(rs_expense.getDouble("Purchases"));
				expenseReportVO.setOtherworkexpenses(rs_expense.getDouble("other_work_expenses"));
				expenseReportVO.setMisllcellaneous(rs_expense.getDouble("Miscellaneous"));
				expenseReportVO.setTotalamountclaimed(rs_expense.getDouble("Total_amount_claimed"));
				
				if(rs_expense.getString("Advance_paid")!=null){
					expenseReportVO.setAdvancepaid(rs_expense.getDouble("Advance_paid"));
				}
				
				if(rs_expense.getString("Balance")!=null){
					expenseReportVO.setBalance(rs_expense.getDouble("Balance"));
				}
				expenseReportVO.setEmpname(rs_expense.getString("empname"));
				
				if(!(rs_expense.getString("apprvedamt").equalsIgnoreCase("-"))){
					expenseReportVO.setTotalamountapproved(rs_expense.getDouble("apprvedamt"));
				}
				
				expenseReportVO.setIsMangApproved(rs_expense.getString("isappvmang"));
				expenseReportVO.setIsDireApproved(rs_expense.getString("isappvdir"));
				expenseReportVO.setIsAccntApproved(rs_expense.getString("isappvaccnt"));
				
				if(!(rs_expense.getString("direapprvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setDireApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("direapprvdate")));
				}else{
					expenseReportVO.setDireApprovedDate(rs_expense.getString("direapprvdate"));
				}
				
				
				if(!(rs_expense.getString("accntappvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setAccntApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("accntappvdate")));
				}else{
					expenseReportVO.setAccntApprovedDate(rs_expense.getString("accntappvdate"));
				}
				
				
				
				if(!(rs_expense.getString("mangapprvdate").equalsIgnoreCase("-"))){
			    	expenseReportVO.setMangApprovedDate(HelperClass.convertDatabaseToUI(rs_expense.getString("mangapprvdate")));
				}else{
					expenseReportVO.setMangApprovedDate(rs_expense.getString("mangapprvdate"));
				}
				
			   	expenseReportVO.setPosteddate(HelperClass.convertDatabaseToUI(rs_expense.getString("posteddate")));
				expenseReportVO.setApprovedAccntsname(rs_expense.getString("appradminname"));
				expenseReportVO.setApprovedDirename(rs_expense.getString("apprvdirename"));
						
				expenseslist.add(expenseReportVO);
			}
		
		
			
			
			
		  }catch(SQLException se){
				logger.error(se.getMessage(),se);
				se.printStackTrace();
			  }catch(Exception e){
				logger.error(e.getMessage(),e);
				e.printStackTrace();
			  }finally{
				try{
					if(rs_expense !=null && (!rs_expense.isClosed()))
					{
						rs_expense.close();
					}
					if(ps_expense !=null && (!ps_expense.isClosed()))
					{
						ps_expense.close();
					}
					if(connection !=null && (!connection.isClosed()))
					{
						connection.close();
					}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle.getMessage(),sqle);
				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error(e1.getMessage(),e1);
				}
			}
	
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ExpenseReportDaoImpl : getExpensesfordownload Ending");

	return expenseslist;
 
 }
	
	
	
	
	
}
