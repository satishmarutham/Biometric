package com.centris.util;

import java.sql.Timestamp;
import java.util.ArrayList;

public class AttedencePostingFromMdbToMySql {

	public static void main(String[] args) throws Exception {

		LogsPosting getAllText = new LogsPosting();
		try {
			String ETL_CODE = getAllText.getETLCode();
			System.out.println("Schedular Started ::");
			ArrayList chk = getAllText.getMSACESSData(ETL_CODE);

			int id = (Integer) chk.get(0);
			String con = (String) chk.get(1);
			int count = (Integer) chk.get(2);

			Timestamp time = (Timestamp) chk.get(5);
			
			System.out.println("time ::: "+time);
			
			if (con.equalsIgnoreCase("true") && time != null && count != 0) {

				System.out.println(" Proceed For next Step ");
				String first_stamp = getAllText
						.getCurrentSessionFirstTimeStamp(ETL_CODE);

				ArrayList<java.sql.Date> allDates = getAllText
						.calculateDatesBetweenTwoStamps(first_stamp,
								time.toString());

				getAllText.updateAuditDates(allDates, ETL_CODE);

				getAllText.updateLogAudit(time, id, ETL_CODE);

				System.out.println(allDates);

				ClaculateTimeSheet time_sheet = new ClaculateTimeSheet();
				time_sheet.claculateTimeSheetLocationAndShiftWise(allDates,
						ETL_CODE);
			}
			System.out.println("Schedular Ended ::");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getAllText.closeConnection();
		}
	}
}