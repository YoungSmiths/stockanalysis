package cn.dev.youngsmith.stockanalysis.juhe.schedule;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import cn.dev.youngsmith.stockanalysis.juhe.task.SHSZInstantJob;

public class Schedule {
	public void run() {
		SchedulerFactory sf = new StdSchedulerFactory();
		try {
			Scheduler scheduler = sf.getScheduler();
			JobDetail job = JobBuilder.newJob(SHSZInstantJob.class).withIdentity("shshinstant", "catcher").build();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("shszInstant", "catcher").startNow().build();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Schedule s = new Schedule();
		s.run();
	}
}
