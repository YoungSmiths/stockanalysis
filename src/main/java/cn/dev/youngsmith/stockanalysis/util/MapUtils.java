package cn.dev.youngsmith.stockanalysis.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: MapUtils
 * @Description: TODO map工具类
 * @author shiy
 * @date 2017年3月9日 下午3:49:09
 */
public abstract class MapUtils {
	/**
	 * 返回新建 HashMap 对象 例如 Map<String,Object> map = MapUtils.newMap();
	 * 
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> Map<K, V> newMap() {
		return new HashMap<K, V>();
	}

	/**
	 * 返回具有线程安全的 ConcurrentHashMap对象， 例如: Map<String,Object> map =
	 * MapUtils.newConcurrentHashMap();
	 * 
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> Map<K, V> newConcurrentHashMap() {
		return new ConcurrentHashMap<K, V>();
	}

	/**
	 * 返回由key和value组成的单一内容的map
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static Map getSingleMap(String key, Object value) {
		Map<String, Object> result = newMap();
		result.put(key, value);

		return result;
	}

	/**
	 * 将Map内容组装成字符串
	 * 
	 * @param source
	 * @return
	 */
	public static String changeToStr(Map source) {
		if (source == null || source.isEmpty()) {
			return "";
		}

		Iterator<String> keys = source.keySet().iterator();
		String key = "";
		StringBuilder result = new StringBuilder();
		while (keys.hasNext()) {
			key = (String) keys.next();
			result.append(key).append(":").append(source.get(key)).append(",");
		}

		// 去除最后添加的多余","
		if (result.length() > 0) {
			return result.substring(0, result.length() - 1);
		}

		return result.toString();
	}
}
