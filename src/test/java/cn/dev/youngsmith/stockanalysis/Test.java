package cn.dev.youngsmith.stockanalysis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.DaPanData;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.GoPicture;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.SHSZInstanceJsonObject;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.SHSZInstantInfo;
import cn.dev.youngsmith.stockanalysis.juhe.catcher.Catcher;
import cn.dev.youngsmith.stockanalysis.juhe.parser.StockParser;

public class Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void test() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("stockanalysis");

		factory.close();
	}

	@org.junit.Test
	public void test1() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("stockanalysis");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		String stockSHSZ = Catcher.getStockSHSZ("sh601009");
		System.out.println(stockSHSZ);
		SHSZInstanceJsonObject instance = StockParser.parserSHSZInstance(stockSHSZ);
		System.out.println(instance);

		DaPanData daPanData = instance.getDapandata();
		GoPicture goPicture = instance.getGopicture();
		SHSZInstantInfo shszInstantInfo = instance.getData();
		// SHSZInstantInfo shszInstantInfo = (SHSZInstantInfo)
		// shszInstantInfoSuper;
		shszInstantInfo.setDaPanData(daPanData);
		shszInstantInfo.setGoPicture(goPicture);
		em.persist(daPanData);
		em.persist(goPicture);
		em.persist(shszInstantInfo);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
