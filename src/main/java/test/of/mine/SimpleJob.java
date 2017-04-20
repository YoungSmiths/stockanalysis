package test.of.mine;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.dev.youngsmith.stockanalysis.exception.StockException;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.SHSZInstanceJsonObject;
import cn.dev.youngsmith.stockanalysis.juhe.catcher.Catcher;
import cn.dev.youngsmith.stockanalysis.juhe.parser.StockParser;
import cn.dev.youngsmith.stockanalysis.util.MailSender;

public class SimpleJob implements Job {
	private double pre = 3.5;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			String youjiu = Catcher.getStockSHSZ("sh600652");
			SHSZInstanceJsonObject youjiuInstance = StockParser.parserSHSZInstance(youjiu);
			String content = youjiuInstance.getData().getName() + ":" + youjiuInstance.getData().getIncrePer();
			if (youjiuInstance.getData().getIncrePer() > pre || youjiuInstance.getData().getIncrePer() < -pre) {
				System.out.println(content);
				MailSender.sendEmail(content);
			}

			String huatie = Catcher.getStockSHSZ("sh603300");
			SHSZInstanceJsonObject huatieInstance = StockParser.parserSHSZInstance(huatie);
			content = huatieInstance.getData().getName() + ":" + huatieInstance.getData().getIncrePer();
			if (huatieInstance.getData().getIncrePer() > pre || huatieInstance.getData().getIncrePer() < -pre) {
				System.out.println(content);
				MailSender.sendEmail(content);
			}

			String deli = Catcher.getStockSHSZ("sz002571");
			SHSZInstanceJsonObject deliInstance = StockParser.parserSHSZInstance(deli);
			content = deliInstance.getData().getName() + ":" + deliInstance.getData().getIncrePer();
			if (deliInstance.getData().getIncrePer() > pre || deliInstance.getData().getIncrePer() < -pre) {
				System.out.println(content);
				MailSender.sendEmail(content);
			}
		} catch (StockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String youjiu = Catcher.getStockSHSZ("sh600652");
		SHSZInstanceJsonObject youjiuInstance = StockParser.parserSHSZInstance(youjiu);
		StringBuilder sb = new StringBuilder();
		sb.append("亲爱的 " + "，<br/><br/>");
		sb.append(youjiuInstance.getData().getName() + ":" + youjiuInstance.getData().getIncrePer());
		Thread.sleep(1000);
		String content = sb.toString();
		System.out.println(content);
		System.out.println();

		if (youjiuInstance.getData().getIncrePer() < 5) {
			MailSender.sendEmail(content);
		}
		// String stockSHSZ1 = Catcher.getStockSHSZ("sh603300");
		// SHSZInstanceJsonObject instance1 =
		// StockParser.parserSHSZInstance(stockSHSZ1);
		// System.out.println(instance1.getData().getName() + ":" +
		// instance1.getData().getIncrePer());
		//
		// String stockSHSZ2 = Catcher.getStockSHSZ("sz002571");
		// SHSZInstanceJsonObject instance2 =
		// StockParser.parserSHSZInstance(stockSHSZ2);
		// System.out.println(instance2.getData().getName() + ":" +
		// instance2.getData().getIncrePer());
	}

}
