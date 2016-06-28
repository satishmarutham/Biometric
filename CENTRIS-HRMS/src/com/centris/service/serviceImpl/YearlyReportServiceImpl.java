/**
 * 
 */
package com.centris.service.serviceImpl;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centris.DAO.YearlyReportDao;
import com.centris.DAO.DAOIMPL.YearlyReportDaoImpl;
import com.centris.POJO.YearlyReportPojo;
import com.centris.form.YearlyReportForm;
import com.centris.service.YearlyReportService;
import com.itextpdf.text.Element;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author sathish
 *
 */
public class YearlyReportServiceImpl implements YearlyReportService {

	@Override
	public Map<String, List<YearlyReportPojo>> getYearlyReportDetails(YearlyReportForm reportForm) {
		YearlyReportPojo yearlyReportPojo=new YearlyReportPojo();
	
		String employeeId=reportForm.getEmployee();
		YearlyReportDao yearlyReportDao=new YearlyReportDaoImpl();
	Map<String, List<YearlyReportPojo>> getYearlyReportList=new HashMap<String, List<YearlyReportPojo>>();

	
		String shift=reportForm.getShift();
		String location=reportForm.getLocation();
		String group=reportForm.getGroup();

	
		if(employeeId.equals("%%")){
			
			List<String> employeeIds=new YearlyReportDaoImpl(). getEmpDetailsByShift( shift,  group,  location) ;
for( int i=0;i<employeeIds.size(); i++){
		
		
				yearlyReportPojo.setEmployeeId(employeeIds.get(i));

				yearlyReportPojo.setShiftCode(reportForm.getShift());
				
				yearlyReportPojo.setLocationCode(reportForm.getLocation());
			yearlyReportPojo.setGroupCode(reportForm.getGroup());
			yearlyReportPojo.setStartmonth(reportForm.getStartmonth());
			yearlyReportPojo.setEndmonth(reportForm.getEndmonth());
			yearlyReportPojo.setYear(reportForm.getYear());
		
		  getYearlyReportList.put(employeeIds.get(i),yearlyReportDao.getYearlyReportDetails(yearlyReportPojo));
			}

		}
		else
		{
		
			yearlyReportPojo.setShiftCode(reportForm.getShift());
			yearlyReportPojo.setEmployeeId(employeeId);
			yearlyReportPojo.setLocationCode(reportForm.getLocation());
		yearlyReportPojo.setGroupCode(reportForm.getGroup());
		yearlyReportPojo.setStartmonth(reportForm.getStartmonth());
		yearlyReportPojo.setEndmonth(reportForm.getEndmonth());
		yearlyReportPojo.setYear(reportForm.getYear());
		 getYearlyReportList.put(employeeId,yearlyReportDao.getYearlyReportDetails(yearlyReportPojo));
		}
	
		
		return getYearlyReportList;
	}
	
	public List<YearlyReportPojo> yearlyReportPDF(YearlyReportPojo reportPojo) {

	
		try{
PdfPTable tableEmpDetail = new PdfPTable(11);
		tableEmpDetail.setSpacingBefore(8);
		 
		tableEmpDetail.setWidthPercentage(110);
		PdfPCell r1c1 = new PdfPCell(new Paragraph("Employee Id"));
		r1c1.setFixedHeight(30f);
		r1c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		r1c1.setBackgroundColor(new Color(0, 204, 255));
		r1c1.setPaddingTop(11f);
		r1c1.setPaddingLeft(2f);
		r1c1.setPaddingRight(2f);
		
		tableEmpDetail.addCell(r1c1);
		PdfPCell r1c2 = new PdfPCell(new Paragraph(reportPojo.getEmployeeId()));
		r1c2.setFixedHeight(30f);
		r1c2.setHorizontalAlignment(Element.ALIGN_LEFT);
		r1c2.setPaddingTop(11f);
		r1c2.setPaddingLeft(2f);
		r1c2.setPaddingRight(2f);
		tableEmpDetail.addCell(r1c2);
		PdfPCell r1c3 = new PdfPCell(new Paragraph("Employee Name"));
		r1c3.setFixedHeight(30f);
		r1c3.setHorizontalAlignment(Element.ALIGN_LEFT);
		r1c3.setBackgroundColor(new Color(0, 204, 255));
		r1c3.setPaddingTop(11f);
		r1c3.setPaddingLeft(2f);
		r1c3.setPaddingRight(2f);
		tableEmpDetail.addCell(r1c3);
		PdfPCell r1c4 = new PdfPCell(new Paragraph(reportPojo.getEmployeeName()));
		r1c4.setFixedHeight(30f);
		r1c4.setHorizontalAlignment(Element.ALIGN_LEFT);
		r1c4.setPaddingTop(11f);
		r1c4.setPaddingLeft(2f);
		r1c4.setPaddingRight(2f);
		tableEmpDetail.addCell(r1c4);
		
		PdfPCell r1c5 = new PdfPCell(new Paragraph("Location"));
		r1c5.setFixedHeight(30f);
		r1c5.setHorizontalAlignment(Element.ALIGN_LEFT);
		r1c5.setBackgroundColor(new Color(0, 204, 255));
		r1c5.setPaddingTop(11f);
		r1c5.setPaddingLeft(2f);
		r1c5.setPaddingRight(2f);
		tableEmpDetail.addCell(r1c5);
		PdfPCell r2c1 = new PdfPCell(new Paragraph(reportPojo.getMonthName()));
		r2c1.setFixedHeight(30f);
		r2c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		r2c1.setPaddingTop(11f);
		r2c1.setPaddingLeft(2f);
		r2c1.setPaddingRight(2f);
		tableEmpDetail.addCell(r2c1);
		PdfPCell r2c2 = new PdfPCell(new Paragraph("Present"));
		r2c2.setFixedHeight(30f);
		r2c2.setHorizontalAlignment(Element.ALIGN_LEFT);
		r2c2.setBackgroundColor(new Color(0, 204, 255));
		r2c2.setPaddingTop(11f);
		r2c2.setPaddingLeft(2f);
		r2c2.setPaddingRight(2f);
		tableEmpDetail.addCell(r2c2);
		PdfPCell r2c3 = new PdfPCell(new Paragraph(reportPojo.getPresents()));
		r2c3.setFixedHeight(30f);
		r2c3.setHorizontalAlignment(Element.ALIGN_LEFT);
		r2c3.setPaddingTop(11f);
		r2c3.setPaddingLeft(2f);
		r2c3.setPaddingRight(2f);
		tableEmpDetail.addCell(r2c3);
		
		PdfPCell r3c1 = new PdfPCell(new Paragraph("Holidays"));
		r3c1.setFixedHeight(30f);
		r3c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		r3c1.setBackgroundColor(new Color(0, 204, 255));
		r3c1.setPaddingTop(11f);
		r3c1.setPaddingLeft(2f);
		r3c1.setPaddingRight(2f);
		tableEmpDetail.addCell(r3c1);
		PdfPCell r3c2 = new PdfPCell(new Paragraph(reportPojo.getHolidays()));
		r3c2.setFixedHeight(30f);
		r3c2.setHorizontalAlignment(Element.ALIGN_LEFT);
		r3c2.setPaddingTop(11f);
		r3c2.setPaddingLeft(2f);
		r3c2.setPaddingRight(2f);
		tableEmpDetail.addCell(r3c2);
		PdfPCell r3c3 = new PdfPCell(new Paragraph("HolidaysPayable"));
		r3c2.setFixedHeight(30f);
		r3c2.setHorizontalAlignment(Element.ALIGN_LEFT);
		r3c3.setBackgroundColor(new Color(0, 204, 255));
		r3c3.setPaddingTop(11f);
		r3c3.setPaddingLeft(2f);
		r3c3.setPaddingRight(2f);
		tableEmpDetail.addCell(r3c3);
		PdfPCell r3c4 = new PdfPCell(new Paragraph(reportPojo.getHolidayPayable()));
		r3c4.setHorizontalAlignment(Element.ALIGN_LEFT);
		r3c4.setPaddingTop(11f);
		r3c4.setPaddingLeft(2f);
		r3c4.setPaddingRight(2f);
		r3c4.setNoWrap(false);
		tableEmpDetail.addCell(r3c4);
		
		PdfPCell r4c1 = new PdfPCell(new Paragraph("WeekOff"));
		r4c1.setFixedHeight(30f);
		r4c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		r4c1.setBackgroundColor(new Color(0, 204, 255));
		r4c1.setPaddingTop(11f);
		r4c1.setPaddingLeft(2f);
		r4c1.setPaddingRight(2f);
		tableEmpDetail.addCell(r4c1);
		PdfPCell r4c2 = new PdfPCell(new Paragraph(reportPojo.getWeekOffs()));
		r4c2.setFixedHeight(30f);
		r4c2.setHorizontalAlignment(Element.ALIGN_LEFT);
		r4c2.setPaddingTop(11f);
		r4c2.setPaddingLeft(2f);
		r4c2.setPaddingRight(2f);
		tableEmpDetail.addCell(r4c2);
		PdfPCell r4c3 = new PdfPCell(new Paragraph("WeekOffPayable"));
		r4c3.setFixedHeight(30f);
		r4c3.setHorizontalAlignment(Element.ALIGN_LEFT);
		r4c3.setBackgroundColor(new Color(0, 204, 255));
		r4c3.setPaddingTop(11f);
		r4c3.setPaddingLeft(2f);
		r4c3.setPaddingRight(2f);
		tableEmpDetail.addCell(r4c3);
		PdfPCell r4c4 = new PdfPCell(new Paragraph(reportPojo.getWeekoffPayable()));
		r4c4.setFixedHeight(30f);
		r4c4.setHorizontalAlignment(Element.ALIGN_LEFT);
		r4c4.setPaddingTop(11f);
		r4c4.setPaddingLeft(2f);
		r4c4.setPaddingRight(2f);
		tableEmpDetail.addCell(r4c4);
		
		PdfPCell r5c1 = new PdfPCell(new Paragraph("CasualLeaves"));
		r5c1.setFixedHeight(30f);
		r5c1.setBackgroundColor(new Color(0, 204, 255));
		r5c1.setPaddingTop(11f);
		r5c1.setPaddingLeft(2f);
		r5c1.setPaddingRight(2f);
		tableEmpDetail.addCell(r5c1);
		PdfPCell r5c2 = new PdfPCell(new Paragraph(reportPojo.getCasualLeaves()));
		r5c2.setFixedHeight(30f);
		r5c2.setHorizontalAlignment(Element.ALIGN_LEFT);
		r5c2.setPaddingTop(11f);
		r5c2.setPaddingLeft(2f);
		r5c2.setPaddingRight(2f);
		tableEmpDetail.addCell(r5c2);
		PdfPCell r5c3 = new PdfPCell(new Paragraph("Payable Leaves"));
		r5c3.setFixedHeight(30f);
		r5c3.setHorizontalAlignment(Element.ALIGN_LEFT);
		r5c3.setBackgroundColor(new Color(0, 204, 255));
		r5c3.setPaddingTop(11f);
		r5c3.setPaddingLeft(2f);
		r5c3.setPaddingRight(2f);
		tableEmpDetail.addCell(r5c3);
		PdfPCell r5c4 = new PdfPCell(new Paragraph( "SickLeaves"));
		r5c4.setFixedHeight(30f);
		r5c4.setHorizontalAlignment(Element.ALIGN_LEFT);
		r5c4.setPaddingTop(11f);
		r5c4.setPaddingLeft(2f);
		r5c4.setPaddingRight(2f);
		tableEmpDetail.addCell(r5c4);
		
		PdfPTable tableNetSalary = new PdfPTable(2);
		tableNetSalary.setSpacingBefore(8);
		tableNetSalary.setWidthPercentage(110);
		PdfPCell r12c1 = new PdfPCell(new Paragraph("Total"));
		r12c1.setFixedHeight(30f);
		r12c1.setBackgroundColor(new Color(0, 255, 0));
		r12c1.setPaddingTop(11f);
		r12c1.setPaddingLeft(2f);
		r12c1.setPaddingRight(2f);
		tableNetSalary.addCell(r12c1);
		PdfPCell r12c2 = new PdfPCell(new Paragraph(reportPojo.getTotalLeaves()));
		r12c2.setFixedHeight(30f);
		r12c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		r12c2.setPaddingTop(11f);
		r12c2.setPaddingLeft(2f);
		r12c2.setPaddingRight(2f);
		tableNetSalary.addCell(r12c2);
		
		/*PdfPTable tableNote = new PdfPTable(1);
		tableNote.setSpacingBefore(8);
		tableNote.setWidthPercentage(110);
		Paragraph p1 = new Paragraph(new Phrase("Note:", new com.lowagie.text.Font(10, 10, 0, new Color(0, 58, 255))));
		p1.setAlignment(Element.ALIGN_LEFT);
		Paragraph p2 = new Paragraph("N.W.D means No. Of Working Days", new com.lowagie.text.Font(10, 10, 0, new Color(0, 58, 255)));
	    p2.setAlignment(Element.ALIGN_LEFT);
		Paragraph p3 = new Paragraph("N.H.P.D means No. Of Hours Per Day", new com.lowagie.text.Font(10, 10, 0, new Color(0, 58, 255)));
	    p3.setAlignment(Element.ALIGN_LEFT);
	    
	    PdfPCell r13c1 = new PdfPCell();
		r13c1.addElement(p1);
		r13c1.addElement(p2);
		r13c1.addElement(p3);
		r13c1.setBorder(0);
		tableNote.addCell(r13c1);
		*/
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(reportPojo.getServerPath() +"YearlyReport/Internal/"+".pdf"));
		document.open();
		
		document.add(tableEmpDetail);
		document.add(tableNetSalary);

		document.close();
		
	
		}
		catch(Exception e){
			e.printStackTrace();
		
		}
	/*	reportPojo.setFileName("PayslipHourly/Internal/"+ ".pdf");*/
List<YearlyReportPojo> reportPojos = new YearlyReportDaoImpl().getYearlyReportDetails(reportPojo);
		return reportPojos;
		
	}
}
		
	
	
	



/*	public List<YearlyReportPojo> getYearlyReportDetails(
			YearlyReportForm reportForm) {
		YearlyReportPojo yearlyReportPojo=new YearlyReportPojo();
		yearlyReportPojo.setShiftCode(reportForm.getShift());
		yearlyReportPojo.setEmployeeId(reportForm.getEmployee());
		yearlyReportPojo.setLocationCode(reportForm.getLocation());
	yearlyReportPojo.setGroupCode(reportForm.getGroup());
	yearlyReportPojo.setStartmonth(reportForm.getStartmonth());
	yearlyReportPojo.setEndmonth(reportForm.getEndmonth());
	yearlyReportPojo.setYear(reportForm.getYear());
	
		return new YearlyReportDaoImpl().getYearlyReportDetails(yearlyReportPojo);
	}
*/
	
	

