package com.centris.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts.upload.FormFile;

import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class UploadEmployeeDailyAllowance {
	private static Logger logger = Logger
			.getLogger(UploadEmployeeDailyAllowance.class);

	public Map<String, Object> getExcelData(File fileURL, FormFile file) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmployeeDailyAllowance : getExcelData : Starting");
		Map<String, Object> excelMap = new HashMap<String, Object>();
		List<DailyEmployeeAllowanceVO> employeelist = new ArrayList<DailyEmployeeAllowanceVO>();
		try {

			fileURL.createNewFile();
			FileOutputStream fileOutStream = new FileOutputStream(fileURL);
			fileOutStream.write(file.getFileData());
			fileOutStream.flush();
			fileOutStream.close();

			FileInputStream inputstream = new FileInputStream(fileURL);

			HSSFWorkbook workbook = new HSSFWorkbook(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(0);

			HSSFRow row;
			String date = null;
			Iterator<Row> rows = sheet.iterator();
			DailyEmployeeAllowanceVO dailyEmployeeAllowanceVO = null;
			int i = 1;
			while (rows.hasNext()) {
				i = 1;
				row = (HSSFRow) rows.next();
				if (row.getRowNum() == 1) {
					date = row.getCell(4).getStringCellValue();
					continue;
				}
				if (row.getRowNum() > 2) {
					dailyEmployeeAllowanceVO = new DailyEmployeeAllowanceVO();

					if (row.getCell(i) != null)
						if (row.getCell(i).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							dailyEmployeeAllowanceVO.setCode((int) row.getCell(
									i).getNumericCellValue()
									+ "");
						} else
							dailyEmployeeAllowanceVO.setCode(row.getCell(i)
									.getStringCellValue());

					i++;

					if (row.getCell(i) != null)
						dailyEmployeeAllowanceVO.setNames(row.getCell(i)
								.getStringCellValue());
					i++;

					if (row.getCell(i) != null)
						if (row.getCell(i).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							Double e1Val = row.getCell(i).getNumericCellValue();
							BigDecimal bd = new BigDecimal(e1Val.toString());
							dailyEmployeeAllowanceVO.setHdfcNo(bd.longValue()
									+ "");
						} else
							dailyEmployeeAllowanceVO.setHdfcNo(row.getCell(i)
									.getStringCellValue());
					i++;

					if (row.getCell(i) != null)
						if (row.getCell(i).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							dailyEmployeeAllowanceVO.setAmount((int) row
									.getCell(i).getNumericCellValue() + "");
						} else
							dailyEmployeeAllowanceVO.setAmount(row.getCell(i)
									.getStringCellValue());
					i++;

					if (row.getCell(i) != null)
						dailyEmployeeAllowanceVO.setProjectManager(row.getCell(
								i).getStringCellValue());
					i++;

					if (row.getCell(i) != null)
						dailyEmployeeAllowanceVO.setClient(row.getCell(i)
								.getStringCellValue());
					i++;

					if (row.getCell(i) != null)
						dailyEmployeeAllowanceVO.setProject(row.getCell(i)
								.getStringCellValue());
					i++;

					if (row.getCell(i) != null)
						dailyEmployeeAllowanceVO.setTeamLead(row.getCell(i)
								.getStringCellValue());
					i++;

					if (row.getCell(i) != null)
						dailyEmployeeAllowanceVO.setLocation(row.getCell(i)
								.getStringCellValue());
					i++;

					if (row.getCell(i) != null)
						dailyEmployeeAllowanceVO.setRemarks(row.getCell(i)
								.getStringCellValue());
					i++;

					employeelist.add(dailyEmployeeAllowanceVO);

				}
			}

			excelMap.put("EmployeeList", employeelist);
			excelMap.put("date", date);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return null;
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
			return null;
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmployeeDailyAllowance : getExcelData : Ending");
		return excelMap;
	}
}
