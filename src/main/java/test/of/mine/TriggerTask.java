package test.of.mine;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.dev.youngsmith.stockanalysis.util.MailSender;

public class TriggerTask {
	Logger log = LoggerFactory.getLogger(TriggerTask.class);

	public void run() throws Exception {
		Scheduler sched = null;
		try {
			SchedulerFactory sf = new StdSchedulerFactory();
			sched = sf.getScheduler();
			JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1").build();
			job = newJob(SimpleJob.class).withIdentity("job3", "group1").build();

			CronTrigger trigger = newTrigger().withIdentity("trigger3", "group1")
					.withSchedule(cronSchedule("0 */1 9-15 * * ?")).build();

			Date ft = sched.scheduleJob(job, trigger);
			System.out.println(job.getKey() + " has been scheduled to run at: " + ft
					+ " and repeat based on expression: " + trigger.getCronExpression());
			sched.start();
		} catch (Exception e) {
//			sched.shutdown(true);
			SchedulerMetaData metaData = sched.getMetaData();
			log.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
			MailSender.sendEmail("服务器错误，请重启服务器！");
		} finally {
		}
	}

	public static void main(String[] args) throws Exception {
		TriggerTask example = new TriggerTask();
		example.run();
	}
}
