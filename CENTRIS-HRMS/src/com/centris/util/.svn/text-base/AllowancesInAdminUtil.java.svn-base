package com.centris.util;

import java.util.ArrayList;

import com.centris.VO.AllowancesClaimByManagerVO;

public class AllowancesInAdminUtil {
	
	
	public StringBuilder getEmpFormatTable(ArrayList<AllowancesClaimByManagerVO> allowanceslist) {
		
		
		 String prefix = "<html><body><table style='border:1px solid gray;margin: 5px 0 0 0;width: 100%;font-family: Segoe UI Semibold;font-size: 12px;' cellpadding='0' cellspacing='0'>\n";
			
		 final	StringBuilder sb = new StringBuilder(prefix);
		
        sb.append("<tr style='border:1px solid gray;height;150%;'>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("S.No");
        sb.append("</th>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("BioId");
        sb.append("</th>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("EmpName");
        sb.append("</th>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("Allowance Date");
        sb.append("</th>");
        sb.append("</th>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("Posted By");
        sb.append("</th>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("ProjectRefCode");
        sb.append("</th>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("Actual Amount");
        sb.append("</th>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("DirectorApproved Amount");
        sb.append("</th>");
        sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
        sb.append("AdminApproved Amount");
        sb.append("</th>");
        
        sb.append("</tr>\n");
          
   	 for (int i = 0; i < allowanceslist.size(); i++) {
   		 
  		 sb.append("<tr>");
       
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getSno());
                  sb.append("</td>");
           
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getBioid());
                  sb.append("</td>");
                  
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getEmpname());
                  sb.append("</td>");
                  
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getAllowancedate());
                  sb.append("</td>");
                  
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getPostedBy());
                  sb.append("</td>");
                  
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getProject());
                  sb.append("</td>");
                  
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getAmount());
                  sb.append("</td>");
                  
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getApprovedamount());
                  sb.append("</td>");
                  
                  sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
                  sb.append("" +allowanceslist.get(i).getAccountapprovedamount());
                  sb.append("</td>");
                        
             sb.append("</tr>\n");
	    
	
		}
		  
   	      sb.append("</table>");
	          sb.append("</body>");
	          sb.append("</html>");  
	          
	          return sb;
	}


}
