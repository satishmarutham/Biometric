/**
 * 
 */
package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.AdminDayReportDao;
import com.centris.DAO.DBService;
import com.centris.POJO.AdminDayReportPojo;
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.AdminDayReportVo;
import com.centris.VO.MonthReportVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 *
 */
public class AdminDayReportDaoImpl extends DBService implements AdminDayReportDao  {
	private static Logger logger = Logger
			.getLogger(AdminDayReportDaoImpl.class);
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rsemployeeNames = null;

	@Override
	public ArrayList<AdminDayReportVo> getadminDayReport(
			ArrayList<ManagerReportPojo> managerlist,
			ArrayList<ProjectReportPojo> projectlist,
			ArrayList<EmployeeReportPojo> employeelist,
			ArrayList<DepartMentReportPojo> departmentlist,
			ArrayList<DesignationReportPojo> designationlist, String startDate,
			String endDate) {
		
	
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AdminDayReportDaoImpl : getadminDayReport Starting");
		
		
		Connection connection=null;
		PreparedStatement ps_adminreport_get=null;
		ResultSet rs_adminreport_get=null;
		
		ArrayList<AdminDayReportVo> dayreportlist=new ArrayList<AdminDayReportVo>();
		try{
			
			connection=getConnection();
			
			String managerid="";
			String managercondition="";
					
			StringBuffer managerbuffer=new StringBuffer();
				
			for(int i=0;i<managerlist.size();i++){
				
				if(managerlist.get(0).getMgr_id()!="all"){
					
					managerbuffer.append("'"+managerlist.get(i).getMgr_id().replaceAll(" ","','")+"'");
				
					managerbuffer=managerbuffer.append(",");
					
				}
			
			}
		
			if(managerlist.get(0).getMgr_id()!="all"){
				
				managerbuffer.replace(managerbuffer.length()-1, managerbuffer.length()," ");
				managercondition="and att.ManagerCode in("+managerbuffer+")";	
			}
			
				
			
			/*StringBuffer projectbuffer=new StringBuffer();
			String projectcondition="";
			 for(int i=0;i<projectlist.size();i++){
				
				if(projectlist.get(0).getProjectid()!="all"){
					
					projectbuffer.append("'"+projectlist.get(i).getProjectid().replaceAll(",","','")+"'");
				
					projectbuffer=projectbuffer.append(",");
					
				}
			
			}
			 
			if(projectlist.get(0).getProjectid()!="all"){
				projectbuffer.replace(projectbuffer.length()-1, projectbuffer.length(), " ");
				projectcondition=" and att.ProjectCode in("+projectbuffer+")";	
			}
			
			
			
			StringBuffer designationbuffer=new StringBuffer();
			String designationidcondition="";
			
			for(int i=0;i<designationlist.size();i++){    
			         
				if(designationlist.get(0).getDesig_id()!="all"){
				
				        designationbuffer.append("'"+designationlist.get(i).getDesig_id().replaceAll(",","','")+"'");
				
				          designationbuffer=designationbuffer.append(",");
				
                       }
			 }
			
			if(designationlist.get(0).getDesig_id()!="all"){
				designationbuffer.replace(designationbuffer.length()-1, designationbuffer.length(), " ");
				designationidcondition="and emp.DesignationCode in("+designationbuffer+")";	
			}
			 
			 
			 
			 
			 */

		StringBuffer departmentbuffer=new StringBuffer();	 
		 String departmentcondition="";
		 for(int i=0;i<departmentlist.size();i++){    		 
			 if(departmentlist.get(0).getDeptid()!="all"){
				
				 departmentbuffer.append("'"+departmentlist.get(i).getDeptid().replaceAll(",","','")+"'");
				 departmentbuffer=departmentbuffer.append(",");
				 
				 
			}
			
		 }
		
			if(departmentlist.get(0).getDeptid()!="all"){
				departmentbuffer.replace(departmentbuffer.length()-1, departmentbuffer.length()," ");
				departmentcondition="and emp.DEPT_ID in("+departmentbuffer+")";	
			}
			
			
			
			
		 
			StringBuffer employeebuffer=new StringBuffer();	
			 String employeecondition="";
			 
	       for(int i=0;i<employeelist.size();i++){  
			
			   if(employeelist.get(0).getEmpid()!="all"){
					
				 employeebuffer.append("'"+employeelist.get(i).getEmpid().replaceAll(",","','")+"'");
				 employeebuffer=employeebuffer.append(",");
				
			    }
			 }
	      
			if(employeelist.get(0).getEmpid()!="all"){
				 employeebuffer.replace(employeebuffer.length()-1, employeebuffer.length()," ");
				 employeecondition="and  att.EMPID in("+employeebuffer+")";
			
				 
			}
			 
	int count=0;	
	
/*	for(int i=0;i<dates.size();i++){*/
				
		
	/*ps_adminreport_get=connection.prepareStatement("select emp.EMPID,emp.First_Name,att.Attendence_Date,att.Attedence_Status,attst.ShortName,att.isPosted,att.isAproved from hrms_employee emp,hrms_employee_attendance att, hrms_attendence_status_type attst "
			      +	"where  "
			      +"emp.EMPID=att.EMPID  and att.ASTCode=attst.ASTCode " 
			    
			      +departmentcondition 
			      +managercondition
			    
			      +employeecondition
			      +"and att.Attendence_Date between '"+startDate+"' and '"+endDate+"' order by att.Attendence_Date,att.EMPID");
		
		 rs_adminreport_get= ps_adminreport_get.executeQuery();*/
	for(int i=0;i<employeelist.size();i++){
	
	ps_adminreport_get=connection.prepareStatement("select DISTINCT he.bioid,he.First_Name,hea.Attendence_Date,hea.Attedence_Status,hea.isPosted,hea.isAproved,has.ShortName from  hrms_employee_attendance hea,hrms_employee he,hrms_attendence_status_type has where he.EMPID like ? and hea.Attendence_Date between ? and  ? AND hea.EMPID=he.EMPID AND has.ASTCode=hea.ASTCode");
	ps_adminreport_get.setString(1, employeelist.get(i).getEmpid());
	ps_adminreport_get.setString(2,startDate);
	ps_adminreport_get.setString(3,endDate);
	rs_adminreport_get=ps_adminreport_get.executeQuery();
	
			
		 
		 while(rs_adminreport_get.next()){
			 count++;
		AdminDayReportVo adminDayReportVo=new AdminDayReportVo();
		adminDayReportVo.setSno(count);
		adminDayReportVo.setEmpid(rs_adminreport_get.getString("bioid"));
		adminDayReportVo.setEmpname(rs_adminreport_get.getString("First_Name"));
		adminDayReportVo.setAttendancedate(HelperClass.convertDatabaseToUI(rs_adminreport_get.getString("Attendence_Date")));
		adminDayReportVo.setStatus(rs_adminreport_get.getString("Attedence_Status"));
		adminDayReportVo.setType(rs_adminreport_get.getString("ShortName"));
			
			 if("N".equalsIgnoreCase(rs_adminreport_get.getString("isPosted"))){
				 
				 adminDayReportVo.setIsposted(MessageConstants.IS_POSTED_NO);
			 }else{
				 
				 adminDayReportVo.setIsposted(MessageConstants.IS_POSTED_YES);
			 }
			 
              if("N".equalsIgnoreCase(rs_adminreport_get.getString("isAproved"))){
				 
            	  adminDayReportVo.setIsapproved(MessageConstants.IS_APPROVED_NO);
			 }else{
				 
				 adminDayReportVo.setIsapproved(MessageConstants.IS_APPROVED_YES);
			 }
                            
              
			 
			 dayreportlist.add(adminDayReportVo);
		 }
	}
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception.getMessage(), exception);
		}finally{
			
			try {
				
				if(rs_adminreport_get!=null && (!rs_adminreport_get.isClosed())){
					rs_adminreport_get.close();
				}
				if(ps_adminreport_get!=null && (!ps_adminreport_get.isClosed())){
					ps_adminreport_get.close();
				}
				if(connection!=null && (!connection.isClosed())){
					connection.close();
				}
				
				
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(exception.getMessage(), exception);
			}
			
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AdminDayReportDaoImpl : getadminDayReport Ending");
		
	return dayreportlist;	
	}
	
	}


