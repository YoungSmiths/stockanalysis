package cn.dev.youngsmith.stockanalysis.task;

import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.triggers.CronTriggerImpl;

public class Task {
	public static void main(String[] args) throws Exception {
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class

		JobDetail job = newJob(HelloJob.class).withIdentity("myJob", "group1").build();

		// Trigger the job to run now, and then every 40 seconds
		Trigger trigger = newTrigger().withIdentity("myTrigger", "group1").startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();
		CronTriggerImpl cronTrigger = new CronTriggerImpl();
		cronTrigger.setCronExpression("0 15 9 * * ? *");
		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);
		// sched.shutdown();
	}

	class HelloJob implements Job {

		public void execute(JobExecutionContext context) throws JobExecutionException {
			System.err.println("测试Quartz" + new Date());
		}
	}
}
