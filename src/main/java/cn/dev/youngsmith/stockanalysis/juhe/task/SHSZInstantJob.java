package cn.dev.youngsmith.stockanalysis.juhe.task;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.dev.youngsmith.stockanalysis.dao.impl.SHSZInstantDaoImpl;
import cn.dev.youngsmith.stockanalysis.exception.StockException;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.DaPanData;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.GoPicture;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.SHSZInstanceJsonObject;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.SHSZInstantInfo;
import cn.dev.youngsmith.stockanalysis.juhe.catcher.Catcher;
import cn.dev.youngsmith.stockanalysis.juhe.parser.StockParser;

@SessionScoped
public class SHSZInstantJob implements Job, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8809887333494441180L;
	@Inject
	private SHSZInstantDaoImpl shszInstantDaoImpl;

	public SHSZInstantDaoImpl getShszInstantDaoImpl() {
		return shszInstantDaoImpl;
	}

	public void setShszInstantDaoImpl(SHSZInstantDaoImpl shszInstantDaoImpl) {
		this.shszInstantDaoImpl = shszInstantDaoImpl;
	}

	public void execute(JobExecutionContext jec) throws JobExecutionException {
		String stockSHSZ = null;
		try {
			stockSHSZ = Catcher.getStockSHSZ("sh601009");
		} catch (StockException e) {
			e.printStackTrace();
		}
		System.out.println(stockSHSZ);
		SHSZInstanceJsonObject instance = StockParser.parserSHSZInstance(stockSHSZ);
		System.out.println(instance);

		DaPanData daPanData = instance.getDapandata();
		GoPicture goPicture = instance.getGopicture();
		SHSZInstantInfo shszInstantInfo = instance.getData();
		shszInstantInfo.setDaPanData(daPanData);
		shszInstantInfo.setGoPicture(goPicture);
		shszInstantDaoImpl.save(shszInstantInfo);

	}

}
