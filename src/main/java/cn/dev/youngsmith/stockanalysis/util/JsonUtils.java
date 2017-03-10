package cn.dev.youngsmith.stockanalysis.util;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import cn.dev.youngsmith.stockanalysis.constant.ErrorCode;
import cn.dev.youngsmith.stockanalysis.exception.StockException;

/**
 * @ClassName: JsonUtils 
 * @Description: TODO json工具类
 * @author shiy
 * @date 2017年3月9日 下午3:48:54
 */
public final class JsonUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

	/** ObjectMapper */
	private static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// enum转换为数值
		// mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,true);
	}

	private JsonUtils() {

	}

	/**
	 * 
	 * @name 将对象转换为JSON字符串
	 * @Description
	 * @CreateDate 2015年8月21日下午3:00:01
	 */
	public static String toJson(Object value) {
		try {
			// enum转换为数值
			// mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,true);
			return mapper.writeValueAsString(value);
		} catch (Exception e) {
			LOGGER.error("get json error", e);
			return null;
		}
	}

	/**
	 * 
	 * @name 将对象转换为JSON字符串并格式化
	 * @Description 相关说明
	 * @Time 创建时间:2015年8月5日下午1:28:00
	 */
	public static String toFormatJson(Object value) {
		try {
			// enum转换为数值
			// mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,true);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
		} catch (Exception e) {
			LOGGER.error("toFormatJson error", e);
		}
		return null;
	}

	/**
	 * 
	 * @throws StockException
	 * @name 格式化json
	 * @Description 相关说明
	 * @Time 创建时间:2015年8月5日下午1:31:04
	 */
	public static String formatJson(String json) throws StockException {
		Object object = toObject(json, Object.class);
		return toFormatJson(object);
	}

	/**
	 * 
	 * @name 统一报文协议
	 * @Description 远程调用返回值采用统一报文 成功: errorCode:0 data:返回数据 失败: errorCode:非0
	 *              errorMsg:错误提示信息 data:错误提示数据(可选)
	 * @Time 创建时间:2014-5-15下午3:59:23
	 */
	public static Map<String, Object> createSuccess() {
		return createSuccess(null);
	}

	/**
	 * 
	 * @name 统一报文协议
	 * @Description 远程调用返回值采用统一报文 成功: errorCode:0 data:返回数据 失败: errorCode:非0
	 *              errorMsg:错误提示信息 data:错误提示数据(可选)
	 * @Time 创建时间:2014-5-15下午3:59:23
	 */
	public static Map<String, Object> createSuccess(Object value) {
		Map<String, Object> result = MapUtils.newMap();
		result.put("errorCode", ErrorCode.SUCCESS);
		if (value != null) {
			result.put("data", value);
		}

		return result;
	}

	/**
	 * 
	 * @throws StockException
	 * @name 将JSON字符串转换为对象
	 * @Description
	 * @CreateDate 2015年8月21日下午3:00:45
	 */
	public static <T> T toObject(String json, Class<T> valueType) throws StockException {
		try {
			checkJsonAndType(json, valueType);
			return mapper.readValue(json, valueType);
		} catch (Exception e) {
			LOGGER.error("to Object error", e);
			throw new StockException(ErrorCode.SERVER_INNER_ERROR);
		}
	}

	/**
	 * 
	 * @name 将JSON字符串转换为对象
	 * @Description
	 * @CreateDate 2015年8月21日下午3:00:54
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toObject(String json, TypeReference<?> typeReference) {
		try {
			checkJsonAndType(json, typeReference);
			return (T) mapper.readValue(json, typeReference);
		} catch (Exception e) {
			LOGGER.error("to Object error", e);
		}
		return null;
	}

	/**
	 * 
	 * @name 将JSON字符串转换为对象
	 * @Description
	 * @CreateDate 2015年8月21日下午3:01:05
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toObject(String json, JavaType javaType) {
		try {
			checkJsonAndType(json, javaType);
			return (T) mapper.readValue(json, javaType);
		} catch (Exception e) {
			LOGGER.error("to Object error", e);
		}
		return null;
	}

	/**
	 * 
	 * @name 将对象转换为JSON流
	 * @Description
	 * @CreateDate 2015年8月21日下午3:01:14
	 */
	public static void writeValue(Writer writer, Object value) {
		try {
			mapper.writeValue(writer, value);
		} catch (JsonGenerationException e) {
			LOGGER.error("", e);
		} catch (JsonMappingException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	/**
	 * 
	 * @name 序列化对象
	 * @Description
	 * @CreateDate 2015年8月21日下午3:01:25
	 */
	public static byte[] serializeObject(Object o) {
		try {
			return mapper.writeValueAsBytes(o);
		} catch (JsonProcessingException e) {
			LOGGER.error("serialize object error", e);
		}

		return null;
	}

	/**
	 * 
	 * @name 根据类型反序列化对象
	 * @Description
	 * @CreateDate 2015年8月21日下午3:01:47
	 */
	public static <T> T deSerializeObject(byte[] bytes, TypeReference<T> type) {
		try {
			return (T) mapper.readValue(bytes, type);
		} catch (JsonParseException e) {
			LOGGER.error("deSerialize object error", e);
		} catch (JsonMappingException e) {
			LOGGER.error("deSerialize object error", e);
		} catch (IOException e) {
			LOGGER.error("deSerialize object error", e);
		}

		return null;
	}

	public static void main(String[] args) {
		Set<Long> test = new HashSet<Long>();
		test.add(1L);
		test.add(2L);
		test.add(3L);

		byte[] json = JsonUtils.serializeObject(test);

		Set<Long> test1 = JsonUtils.deSerializeObject(json, new TypeReference<Set<Long>>() {
		});

		for (Long long1 : test1) {
			LOGGER.debug(long1.toString());
			// System.out.println(long1);
		}
	}

	private static void checkJsonAndType(String json, Object obj) throws Exception {
		if (StringUtils.isBlank(json)) {
			throw new IllegalArgumentException("text must not be empty");
		}
		if (obj == null) {
			throw new IllegalArgumentException("Object is required");
		}

	}
}