package com.centris.scheduler;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.quartz.Scheduler;


public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent conEvent) {
    	System.out.println("context Initialized");
		ServletContext appCxt=conEvent.getServletContext();
		try{
			TaskScheduler createSchedule=new TaskScheduler();
			Scheduler scheduler = createSchedule.createScheduler();
			createSchedule.scheduleJob( scheduler, appCxt );		
			scheduler.start();
		}catch(Exception ex){ex.printStackTrace();}

    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    }
	
}
