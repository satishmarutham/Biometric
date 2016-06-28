package com.centris.action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.GeneratePayrollVo;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.GeneratePayrollBD;
import com.centris.form.CreatepayslipForm;
import com.centris.util.HelperClass;
import com.centris.util.JPropertyReader;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class CreatepayslipAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(CreatepayslipAction.class);

	private static String ClientName = JPropertyReader
			.getProperty("ClientName");
	private static String ClientAddress_l1 = JPropertyReader
			.getProperty("ClientAddress_Line_1");
	private static String ClientAddress_l2 = JPropertyReader
			.getProperty("ClientAddress_Line_2");
	private static String ImageName = JPropertyReader.getProperty("ImageName");
	private static String TeleIndia_Payslip_Dir = JPropertyReader
			.getProperty("TeleIndia_Payslip_Dir");

	public ActionForward createPayslip(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CreatepayslipAction : createPayslip: Starting");

		CreatepayslipForm payslipform = (CreatepayslipForm) form;
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		String montharray[] = payslipform.getMonth().trim().split(",");
		try {
			ServletOutputStream stream = null;
			String sourceFileName = request
					.getRealPath("Reports/CreatePayslip.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			String month = montharray[0];
			String year = payslipform.getYear().trim();
			String department = payslipform.getDept().trim();

			if (department.equalsIgnoreCase("All")) {

				department = "%%";
			}

			List<GeneratePayrollVo> payslipList = new GeneratePayrollBD()
					.getEmpMonthPayrollDetailsDownload(month, year, department);

			ArrayList<DepartmentMasterVO> deptlist = new DepartmentMasterBD()
					.getSingleDeportmentDetails(department);

			List<GeneratePayrollVo> payslip = null;
			FileOutputStream outputFile = null;
			File secondDir = null;
			File firstDir = null;
			File thirdDir = null;
			JRBeanCollectionDataSource beanColDataSource = null;

			firstDir = new File(TeleIndia_Payslip_Dir);
			if (firstDir.exists()) {

				secondDir = new File(TeleIndia_Payslip_Dir + "/"
						+ HelperClass.getMonthFullName(month) + "-"
						+ year.trim());
				secondDir.mkdir();
			} else {

				new File(TeleIndia_Payslip_Dir + "/"
						+ HelperClass.getMonthFullName(month) + "-"
						+ year.trim()).mkdirs();
			}

			if (secondDir != null) {
				if (secondDir.exists()) {
					for (int i = 0; i < deptlist.size(); i++) {
						thirdDir = new File(TeleIndia_Payslip_Dir + "/"
								+ HelperClass.getMonthFullName(month) + "-"
								+ year.trim() + "/"
								+ deptlist.get(i).getDepName().trim());
						thirdDir.mkdir();
					}

				} else {
					for (int i = 0; i < deptlist.size(); i++) {
						new File(TeleIndia_Payslip_Dir + "/"
								+ HelperClass.getMonthFullName(month) + "-"
								+ year.trim() + "/"
								+ deptlist.get(i).getDepName().trim()).mkdirs();
					}
				}
			} else {

				for (int i = 0; i < deptlist.size(); i++) {
					new File(TeleIndia_Payslip_Dir + "/"
							+ HelperClass.getMonthFullName(month) + "-"
							+ year.trim() + "/"
							+ deptlist.get(i).getDepName().trim()).mkdirs();
				}
			}

			for (int i = 0; i < payslipList.size(); i++) {
				payslip = new ArrayList<GeneratePayrollVo>();
				payslip.add(payslipList.get(i));
				beanColDataSource = new JRBeanCollectionDataSource(payslip);
				String imageFilePath = null;

				imageFilePath = getServlet().getServletContext().getRealPath(
						"/images/" + ImageName);

				Map parameters = new HashMap();
				parameters.put("ClientName", ClientName);
				parameters
						.put("monthName", HelperClass.getMonthFullName(month));
				parameters.put("year", year);
				parameters.put("Image", imageFilePath);
				parameters.put("AddressLine1", ClientAddress_l1);
				JasperPrint print = JasperFillManager.fillReport(jasperreport,
						parameters, beanColDataSource);
				outputFile = new FileOutputStream(new File(
						TeleIndia_Payslip_Dir
								+ "/"
								+ HelperClass.getMonthFullName(month)
								+ "-"
								+ year.trim()
								+ "/"
								+ payslipList.get(i).getEmp_dept()
								+ "/"
								+ payslip.get(0).getEmpId()
								+ "-"
								+ payslip.get(0).getEmpName().trim()
										.replaceAll(" ", "_") + ".pdf"));
				JasperExportManager.exportReportToPdfStream(print, outputFile);

				/*
				 * JRXlsExporter exporter = new JRXlsExporter();
				 * 
				 * exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME,
				 * print);
				 * exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
				 * outputFile);
				 */

				/* exporter.exportReport(); */

				outputFile.close();
			}

			if (payslipList.size() != 0) {

				request.setAttribute("serverMessage",
						"Payslip genarated find path D:'\'TeleIndia_Payslip "
								+ montharray[1] + "-" + year);
			} else {

				request.setAttribute("serverMessage",
						"payroll not genarated for " + montharray[1]
								+ "please genarate payroll first");
			}

			List<DepartmentMasterVO> departmentlist = new DepartmentMasterBD()
					.getDepartmentRecordsBD();
			request.setAttribute("deptlist", departmentlist);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);

		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CreatepayslipAction : createPayslip: Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "createpayslipfilter";
		} else {
			forward = Director.DIRECTOR_GET_PAYROLL_FILTER;
		}
		return mapping.findForward(forward);
	}
}