package cn.dev.youngsmith.stockanalysis.parser;

import cn.dev.youngsmith.stockanalysis.bean.StockInstantInfo;
import cn.dev.youngsmith.stockanalysis.exception.StockException;
import cn.dev.youngsmith.stockanalysis.util.JsonUtils;

public class StockParser {
	public static StockInstantInfo parser(String json) {

		try {
			json = json.substring(9, json.length() - 1);
			return JsonUtils.toObject(json, StockInstantInfo.class);
		} catch (StockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void test() {

	}
}
