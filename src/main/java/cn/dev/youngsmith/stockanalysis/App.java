package cn.dev.youngsmith.stockanalysis;

import com.google.gson.JsonParser;

import cn.dev.youngsmith.stockanalysis.bean.StockInstantInfo;
import cn.dev.youngsmith.stockanalysis.catcher.Catcher;
import cn.dev.youngsmith.stockanalysis.parser.StockParser;
import cn.dev.youngsmith.stockanalysis.util.JsonUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// String json = JsonUtils.toJson(new StockInstantInfo());
		// System.out.println(json);
		String stockSH = null;
		try {
			stockSH = Catcher.getStockSH();
		} catch (Exception e) {
			e.printStackTrace();
		}
		stockSH = stockSH.substring(9, stockSH.length() - 1);
//		System.out.println(stockSH);
		StockInstantInfo stockInstantInfo = StockParser.parser(stockSH);
		System.out.println(stockInstantInfo.toString());
//		System.out.println("Hello World!");
	}
}
