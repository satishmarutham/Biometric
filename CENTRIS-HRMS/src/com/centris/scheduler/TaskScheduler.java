package com.centris.scheduler;

import java.util.Date;

import javax.servlet.ServletContext;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

import com.centris.util.JPropertyReader;
import com.centris.util.StringUtils;

public class TaskScheduler {
	
	private static final  int schedule_hour = Integer.parseInt(JPropertyReader.getProperty(StringUtils.SCHEDULER_HOUR));
	private static final  int schedule_minute = Integer.parseInt(JPropertyReader.getProperty(StringUtils.SCHEDULER_MINUTE));
	
	public Scheduler createScheduler() throws SchedulerException {
		return StdSchedulerFactory.getDefaultScheduler();
	}

	public void scheduleJob(Scheduler scheduler, ServletContext context) throws SchedulerException {
		System.out.println("TaskScheduler::scheduleJob:Start");
		try {
			JobDetail jobDetail = new JobDetail("Task",Scheduler.DEFAULT_GROUP, ExecuteJob.class);
			Trigger trigger = TriggerUtils.makeDailyTrigger("Task", schedule_hour, schedule_minute);
			Date d = scheduler.scheduleJob(jobDetail, trigger);
			System.out.println("Schedule Date::" + d);
			// trigger.clearAllTriggerListeners();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("TaskScheduler::scheduleJob:End");
	}

}
