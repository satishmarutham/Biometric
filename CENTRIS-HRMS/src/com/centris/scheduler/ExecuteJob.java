package com.centris.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.centris.util.HelperClass;
//import com.centris.util.SendMailReport;

public class ExecuteJob implements Job {

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
//		new SendMailReport().sendLastThreeAbsentReportPDF(HelperClass.getCurrentSqlDate()+"");
//		new SendMailReport().sendMachineStatusReportPDF(HelperClass.getCurrentSqlDate()+"");
	}
}
