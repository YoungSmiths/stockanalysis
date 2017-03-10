package cn.dev.youngsmith.stockanalysis.juhe.catcher;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.dev.youngsmith.stockanalysis.juhe.catcher.Catcher;

public class CatcherTest {

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

	@Test
	public void testMain() {
	}

	@Test
	public void testGetStockSHSZ() {
		try {
			String stockSH = Catcher.getStockSHSZ("sh601009");
			System.out.println(stockSH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetStockHK() {
		try {
			String stockHK = Catcher.getStockHK("00001");
			System.out.println(stockHK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetStockUSA() {
		try {
			String stockUSA = Catcher.getStockUSA("WFC");
			System.out.println(stockUSA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetStockHKAll() {
		try {
			String stockHKAll = Catcher.getStockHKAll("2");
			System.out.println(stockHKAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetStockUSAAll() {
		try {
			String stockUSAAll = Catcher.getStockUSAAll("2");
			System.out.println(stockUSAAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetStockSHSZAll() {
		try {
			String stockSZAll = Catcher.getStockSHSZAll("2", Catcher.Type.SH);
			System.out.println(stockSZAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testNet() {
	}

	@Test
	public void testUrlencode() {
	}

}
