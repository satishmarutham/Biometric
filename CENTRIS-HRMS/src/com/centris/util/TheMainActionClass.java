package com.centris.util;

public class TheMainActionClass {

	public static void main(String[] args) throws Exception {

		BioEmployeeHelper getAllText = new BioEmployeeHelper();

		try {

			System.out.println("Schedular Started::");
			getAllText.getMSACESSData();
			getAllText.pickTotalID();
			getAllText.calculateTimeSheet();
			getAllText.updateAuditData();
			System.out.println("Schedular Ended::");
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			getAllText.closeConnection();
		}

	}
}
