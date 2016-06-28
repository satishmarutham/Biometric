
package com.centris.action;


import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;
import com.centris.VO.EmployeeFilterVO;
import com.centris.delegate.ProductivityDelegate;
import com.centris.exception.AITrackerException;
import com.centris.form.ProductivityForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.constants.MessageConstants;


public class productivityAction  extends DispatchAction {
	
	private static Logger logger = Logger
			.getLogger(productivityAction.class);
	
	
	public synchronized  ActionForward getEmployeeByDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in productivityAction: getEmployeeByDept Starting");
		
		System.out.println("productivity employee action");

   	    String department = request.getParameter("dept");

		ArrayList<EmployeeFilterVO> list = new ArrayList<EmployeeFilterVO>();
		
		ProductivityDelegate delegate = new ProductivityDelegate();
		
   	 
		System.out.println("department code is" + department);

     try
     {
    
    	 EmployeeFilterVO b = new EmployeeFilterVO();
    	 
    	 b.setDepartmentCode(department);
        	 
		list=delegate.getEmployeesByDept(b);

		//ArrayList<EmployeeFilterVO> emplist = new ProductivityDelegate().getEmployeesByDept(department);
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.accumulate("employeeList", list);
		response.getWriter().print(jsonobject);
			
         }catch(Exception e){
        	 logger.error(e.getMessage(),e);
 		     e.printStackTrace();
 	     }
 	   
 	   JLogger.log(0, JDate.getTimeString(new Date())
 				+ MessageConstants.END_POINT);
 		logger.info(JDate.getTimeString(new Date())
 				+ " Control in productivityAction : getEmployeeByDept Ending");
		return null;
	}

	

	
	public ActionForward Submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException,Exception	{
		
		
		System.out.println("Action Submit is working");
		
		ProductivityForm productivitybean = (ProductivityForm) form;
	    
		/*String[] Departmentt = request.getParameter("department").split(",");
		for(int i=0; i<Departmentt.length; i++)
		{
			System.out.println("get dept ajax"+Departmentt[i]);
		}
		
		String[] Empp = request.getParameter("employee").split(",");
		
		for(int i=0; i<Empp.length; i++)
		{
			System.out.println("getEmployee ajax"+Empp[i]);
		}
		*/
		
		String s2[]=productivitybean.getDepartment();
		
		/*for(int j=0; j<s2.length; j++)
		{
			System.out.println("getDepartment"+s2[j]);
		}
		*/
		String s1[]=productivitybean.getEmployee();
		
		/*for(int i=0; i<s1.length; i++)
		{
			System.out.println("getEmployee"+s1[i]);
		}*/
		System.out.println(productivitybean.getStartdate());
		
		System.out.println(productivitybean.getEnddate());
		
				
		ProductivityDelegate delegate = new ProductivityDelegate();
		
		
		ArrayList<EmployeeFilterVO> getproductivitylist = new ArrayList<EmployeeFilterVO>();

		getproductivitylist = delegate.getProductivityReport(productivitybean);
				
		request.setAttribute("getemployeelist",getproductivitylist);
		
		return mapping.findForward(Director.getProductivityReporttimesheetreport);


			}
		}


	
