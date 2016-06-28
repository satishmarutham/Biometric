package com.centris.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

import com.centris.VO.AttendanceTimeSheetReportVo;
import com.centris.VO.MonthlyLagendReportVo;

public class TimesheetReportExcel {
	

    
    int rownum = 0;
    HSSFSheet firstSheet;
    Collection<File> files;
    HSSFWorkbook workbook;
    File exactFile;

    CellStyle styleAbsent=null;
    CellStyle stylePresent=null;
    CellStyle styleWeekOff=null;
    CellStyle styleNone=null;
    CellStyle styleHoliday=null;
    CellStyle styleHeader=null;
    Font fontAbsent=null;
    Font fontPresent=null;
    Font fontWeekOff=null;
    Font fontNone=null;
    Font fontHoliday=null;
    Font fontHeader=null;
    
   
 
    public CellStyle AbsentCss() {
    	if(styleAbsent==null)
		 styleAbsent = workbook.createCellStyle();
    	if(fontAbsent==null)
		 fontAbsent = workbook.createFont();
    	fontAbsent.setColor(HSSFColor.RED.index);
		styleAbsent.setFont(fontAbsent);
		styleAbsent.setAlignment(styleAbsent.ALIGN_CENTER);
		styleAbsent.setBorderBottom((short) 1);
		styleAbsent.setBorderTop((short) 1);
		styleAbsent.setBorderLeft((short) 1);
		styleAbsent.setBorderRight((short) 1);
		return styleAbsent;
	}

	public CellStyle PresentCss() {
		if(stylePresent==null)
			stylePresent = workbook.createCellStyle();
		if(fontPresent==null)
		 fontPresent = workbook.createFont();
		fontPresent.setColor(HSSFColor.GREEN.index);
		stylePresent.setFont(fontPresent);
		stylePresent.setAlignment(stylePresent.ALIGN_CENTER);
		stylePresent.setBorderBottom((short) 1);
		stylePresent.setBorderTop((short) 1);
		stylePresent.setBorderLeft((short) 1);
		stylePresent.setBorderRight((short) 1);
		return stylePresent;
	}

	public CellStyle WeekOffCss() {
		if(styleWeekOff==null)
		styleWeekOff = workbook.createCellStyle();
		if(fontWeekOff==null)
		 fontWeekOff = workbook.createFont();
		fontWeekOff.setColor(HSSFColor.BLUE.index);
		styleWeekOff.setFont(fontWeekOff);
		styleWeekOff.setAlignment(styleWeekOff.ALIGN_CENTER);
		styleWeekOff.setBorderBottom((short) 1);
		styleWeekOff.setBorderTop((short) 1);
		styleWeekOff.setBorderLeft((short) 1);
		styleWeekOff.setBorderRight((short) 1);
		return styleWeekOff;
	}

	public CellStyle NoneCss() {
		if(styleNone==null)
		 styleNone = workbook.createCellStyle();
		if(fontNone==null)
		 fontNone = workbook.createFont();
		fontNone.setColor(HSSFColor.BLACK.index);
		styleNone.setFont(fontNone);
		styleNone.setAlignment(styleNone.ALIGN_CENTER);
		styleNone.setBorderBottom((short) 1);
		styleNone.setBorderTop((short) 1);
		styleNone.setBorderLeft((short) 1);
		styleNone.setBorderRight((short) 1);

		return styleNone;
	}

	public CellStyle HeaderCss() {
		if(styleHeader==null)
		styleHeader = workbook.createCellStyle();
		if(fontHeader==null)
		 fontHeader = workbook.createFont();
		fontHeader.setColor(HSSFColor.BLACK.index);
		fontHeader.setBoldweight(Font.BOLDWEIGHT_BOLD);
		styleHeader.setFont(fontHeader);
	
		styleHeader.setAlignment(styleHeader.ALIGN_CENTER);
		styleHeader.setBorderBottom((short) 1);
		styleHeader.setBorderTop((short) 1);
		styleHeader.setBorderLeft((short) 1);
		styleHeader.setBorderRight((short) 1);
		styleHeader.setFillBackgroundColor(HSSFColor.GREY_80_PERCENT.index);
		return styleHeader;
	}
    
	public CellStyle HolidayCss() {
		if(styleHoliday==null)
		 styleHoliday = workbook.createCellStyle();
		if(fontHoliday==null)
		 fontHoliday = workbook.createFont();
		fontHoliday.setColor(HSSFColor.BLACK.index);
		styleHoliday.setFont(fontHoliday);
		styleHoliday.setAlignment(styleHoliday.ALIGN_CENTER);
		styleHoliday.setBorderBottom((short) 1);
		styleHoliday.setBorderTop((short) 1);
		styleHoliday.setBorderLeft((short) 1);
		styleHoliday.setBorderRight((short) 1);
		return styleHoliday;
	}
 public void download( ArrayList<AttendanceTimeSheetReportVo> EMPATT,int days,String path) throws Exception {
		
	 workbook = new HSSFWorkbook();
     firstSheet = workbook.createSheet("Monthly Report");
     Row headerRow = firstSheet.createRow(rownum);
     headerRow.setHeightInPoints(15);
        Cell cellh0= headerRow.createCell(0);
        cellh0.setCellValue("SNO");
        cellh0.setCellStyle(HeaderCss()); 
        firstSheet.setColumnWidth(0,(short)1500);
        
        Cell cellh1= headerRow.createCell(1);
        cellh1.setCellValue("Employee ID");
        cellh1.setCellStyle(HeaderCss()); 
        firstSheet.setColumnWidth(1,(short)3000);
        
        Cell cellh2= headerRow.createCell(2);
        cellh2.setCellValue("Employee Name");
        cellh2.setCellStyle(HeaderCss()); 
        firstSheet.setColumnWidth(2,(short)5000);
        
        int g=3;
        for (int i = 0; i <days; i++) {
			
        	 Cell cellh3= headerRow.createCell(g++);
             cellh3.setCellValue(i+1);
             cellh3.setCellStyle(HeaderCss()); 
		}
        firstSheet.setColumnWidth(g,(short)4000);
        Cell cellh4= headerRow.createCell(g++);
        cellh4.setCellValue("Total days");
        cellh4.setCellStyle(HeaderCss()); 
        firstSheet.setColumnWidth(g,(short)4000);
        
        Cell cellh5= headerRow.createCell(g++);
        cellh5.setCellValue("Working Days");
        cellh5.setCellStyle(HeaderCss()); 
        firstSheet.setColumnWidth(g,(short)4000);
        
        Cell cellh6= headerRow.createCell(g++);
        cellh6.setCellValue("Present Days");
        cellh6.setCellStyle(HeaderCss()); 
        firstSheet.setColumnWidth(g,(short)4000);
        
        Cell cellh7= headerRow.createCell(g++);
        cellh7.setCellValue("Payable Days");
        cellh7.setCellStyle(HeaderCss()); 
        rownum=1;
     
	  try {
		  
          for (int j = 0; j < EMPATT.size(); j++) {
              Row row = firstSheet.createRow(rownum);
              AttendanceTimeSheetReportVo vo   = EMPATT.get(j);
               int i=0;
                        
                  Cell cell0 = row.createCell(i++);
                  cell0.setCellValue(j+1);
                  cell0.setCellStyle(NoneCss()); 
                  
                  Cell cell1 = row.createCell(i++);
                  cell1.setCellValue(vo.getBioid());
                  cell1.setCellStyle(NoneCss()); 
                  
                  Cell cell2 = row.createCell(i++);
                  cell2.setCellValue(vo.getEmpname());
                  cell2.setCellStyle(NoneCss()); 
                 ArrayList al=  vo.getStatus();
                   int p=0;
                  for (Iterator iterator = al.iterator(); iterator.hasNext();) {
					String str = (String) iterator.next();
					
					 Cell cell3 = row.createCell(i++);
                      cell3.setCellValue(str);
					 if(str.equalsIgnoreCase("NN")){
						 cell3.setCellStyle(AbsentCss()); 
					 }
					 if(str.equalsIgnoreCase("NA")){
						 cell3.setCellStyle(PresentCss()); 
					 }
					 
					
				   }
                  
                  Cell cell4 = row.createCell(i++);
                  cell4.setCellValue(vo.getTotaldays());
                  cell4.setCellStyle(NoneCss()); 
                  
                  Cell cell5 = row.createCell(i++);
                  cell5.setCellValue(vo.getWorkingdays());
                  cell5.setCellStyle(NoneCss()); 
                  
                  Cell cell6 = row.createCell(i++);
                  cell6.setCellValue(vo.getPresentdays());
                  cell6.setCellStyle(NoneCss()); 
                  
                  Cell cell7 = row.createCell(i++);
                  cell7.setCellValue(vo.getPayabledays());
                  cell7.setCellStyle(NoneCss()); 
                 
                 
             
              rownum++;
          }

      } catch (Exception e) {
          e.printStackTrace();
      } finally {
      }

	   
    
      FileOutputStream fos1 = null;
      try {
          fos1=new FileOutputStream(new File(path));
          HSSFCellStyle hsfstyle=workbook.createCellStyle();
         
          workbook.write(fos1);
      } catch (Exception e) {
          e.printStackTrace();
      }
    
   
}


}
