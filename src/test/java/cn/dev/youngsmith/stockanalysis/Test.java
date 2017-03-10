package cn.dev.youngsmith.stockanalysis;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import cn.dev.youngsmith.stockanalysis.bean.StockInstantInfo;
import cn.dev.youngsmith.stockanalysis.catcher.Catcher;
import cn.dev.youngsmith.stockanalysis.parser.StockParser;

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
		// StockInstantInfo entity = new StockInstantInfo();
		StockInstantInfo instantInfo = StockParser.parser(Catcher.getStockSH());
		em.persist(instantInfo);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
