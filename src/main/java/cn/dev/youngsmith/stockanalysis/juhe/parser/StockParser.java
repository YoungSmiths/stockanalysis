package cn.dev.youngsmith.stockanalysis.juhe.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.dev.youngsmith.stockanalysis.exception.StockException;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.SHSZInstanceJsonObject;
import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.all.SHSZAllJson;
import cn.dev.youngsmith.stockanalysis.juhe.catcher.Catcher;
import cn.dev.youngsmith.stockanalysis.juhe.catcher.Catcher.Type;
import cn.dev.youngsmith.stockanalysis.util.JsonUtils;

/**
 * @ClassName: StockParser
 * @Description: TODO 抓取股票信息解析
 * @author shiy
 * @date 2017年3月10日 下午4:02:16
 */
public class StockParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(StockParser.class);

	/**
	 * 上证深圳实时数据解析
	 * 
	 * @param json
	 * @return
	 */
	public static SHSZInstanceJsonObject parserSHSZInstance(String json) {

		try {
			json = json.substring(1, json.length() - 1);
			json = "{\"map\":" + json + "}";
			return JsonUtils.toObject(json, SHSZInstanceJsonObject.class);
		} catch (StockException e) {
			LOGGER.error("this is the error:", e, json);
		}
		return null;
	}

	/**
	 * 上证深圳所有股票信息解析
	 * 
	 * @param json
	 * @return
	 */
	public static SHSZAllJson parserSHSZAll(String json) {

		try {
			return JsonUtils.toObject(json, SHSZAllJson.class);
		} catch (StockException e) {
			LOGGER.error("this is the error:", e, json);
		}
		return null;
	}

	public static void main(String[] args) throws Exception {

		// String json = JsonUtils.toFormatJson(new SHSZInstanceJsonObject());
		// System.out.println(json);
	}
}
