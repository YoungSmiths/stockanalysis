package cn.dev.youngsmith.stockanalysis.juhe.parser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.SHSZInstanceJsonObject;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.all.SHSZAllJson;
import cn.dev.youngsmith.stockanalysis.juhe.catcher.Catcher;
import cn.dev.youngsmith.stockanalysis.juhe.catcher.Catcher.Type;

public class StockParserTest {

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
	public void testParserSHSZInstance() {
		SHSZInstanceJsonObject jsonObject;
		try {
			jsonObject = StockParser.parserSHSZInstance(Catcher.getStockSHSZ("sh601009"));
			System.out.println(jsonObject.toString());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void testParserSHSZAll() {
		SHSZAllJson parserSHSZAll = StockParser.parserSHSZAll(Catcher.getStockSHSZAll("1", Type.SH));
		System.out.println(parserSHSZAll.toString());
	}
}
