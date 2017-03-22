package cn.dev.youngsmith.stockanalysis.juhe.catcher;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.dev.youngsmith.stockanalysis.constant.ErrorCode;
import cn.dev.youngsmith.stockanalysis.exception.StockException;
import net.sf.json.JSONObject;

public class Catcher {

	private static final Logger LOGGER = LoggerFactory.getLogger(Catcher.class);
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	// 配置您申请的KEY
	public static final String APPKEY = "0900164a403ea05cede1db5a452e3ae8";

	public static void main(String[] args) throws Exception {
		Catcher.getStockSHSZ(null);
	}

	/**
	 * 1.上证股市 股票编号，上海股市以sh开头，深圳股市以sz开头如：sh601009
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getStockSHSZ(String stockID) throws StockException {
		String result = "";
		// stockID = "sh601311";
		String url = "http://web.juhe.cn:8080/finance/stock/hs";// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("gid", stockID);// 股票编号，上海股市以sh开头，深圳股市以sz开头如：sh601009
		params.put("key", APPKEY);// APP Key

		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				result = object.getString("result");
				return result;
			} else {
				LOGGER.debug(object.get("error_code") + ":" + object.get("reason"));
				throw new StockException(Integer.parseInt(object.get("error_code").toString()),
						object.get("reason").toString());
			}
		} catch (Exception e) {
			LOGGER.error("this is a error: ", e);
			throw new StockException(ErrorCode.CATCHER_FAIL, e.getMessage());
		}
	}

	/**
	 * 2.香港股市
	 * 
	 * @throws StockException
	 */
	public static String getStockHK(String stockID) throws StockException {
		String result = "";
		String url = "http://web.juhe.cn:8080/finance/stock/hk";// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("num", stockID);// 股票代码，如：00001 为“长江实业”股票代码
		params.put("key", APPKEY);// APP Key

		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				LOGGER.debug(object.getString("result"));
				result = object.getString("result");
				return result;
			} else {
				LOGGER.debug(object.get("error_code") + ":" + object.get("reason"));
				throw new StockException(Integer.parseInt(object.get("error_code").toString()),
						object.get("reason").toString());
			}
		} catch (Exception e) {
			LOGGER.error("this is a error: ", e);
			throw new StockException(ErrorCode.CATCHER_FAIL, e.getMessage());
		}
	}

	/**
	 * 3.美国股市
	 * 
	 * @throws StockException
	 */
	public static String getStockUSA(String stockID) throws StockException {
		String result = "";
		String url = "http://web.juhe.cn:8080/finance/stock/usa";// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("gid", stockID);// 股票代码，如：aapl 为“苹果公司”的股票代码
		params.put("key", APPKEY);// APP Key

		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				result = object.getString("result");
				return result;
			} else {
				LOGGER.error(object.get("error_code") + ":" + object.get("reason"));
				throw new StockException(Integer.parseInt(object.get("error_code").toString()),
						object.get("reason").toString());
			}
		} catch (Exception e) {
			LOGGER.error("this is a error: ", e);
			throw new StockException(ErrorCode.CATCHER_FAIL, e.getMessage());
		}
	}

	/**
	 * 4.香港股市列表
	 * 
	 * @throws StockException
	 */
	public static String getStockHKAll(String pageNum) throws StockException {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/hkall";// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("key", APPKEY);// 您申请的APPKEY
		params.put("page", pageNum);// 第几页,每页20条数据,默认第1页

		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				result = object.getString("result");
				return result;
			} else {
				LOGGER.error(object.get("error_code") + ":" + object.get("reason"));
				throw new StockException(Integer.parseInt(object.get("error_code").toString()),
						object.get("reason").toString());
			}
		} catch (Exception e) {
			LOGGER.error("this is a error: ", e);
			throw new StockException(ErrorCode.CATCHER_FAIL, e.getMessage());
		}
	}

	/**
	 * 5.美国股市列表
	 * 
	 * @throws StockException
	 */
	public static String getStockUSAAll(String pageNum) throws StockException {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/usaall";// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("key", APPKEY);// 您申请的APPKEY
		params.put("page", pageNum);// 第几页,每页20条数据,默认第1页

		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				result = object.getString("result");
				return result;
			} else {
				LOGGER.error(object.get("error_code") + ":" + object.get("reason"));
				throw new StockException(Integer.parseInt(object.get("error_code").toString()),
						object.get("reason").toString());
			}
		} catch (Exception e) {
			LOGGER.error("this is a error: ", e);
			throw new StockException(ErrorCode.CATCHER_FAIL, e.getMessage());
		}
	}

	public enum Type {
		SH("sh"), SZ("sz");
		private String param;

		Type(String type) {
			this.param = type;
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

	}

	/**
	 * 6.深圳股市列表
	 */
	public static String getStockSHSZAll(String pageNum, Type type) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/" + type.getParam() + "all";// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("key", APPKEY);// 您申请的APPKEY
		params.put("page", pageNum);// 第几页(每页20条数据),默认第1页

		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				result = object.getString("result");
			} else {
				LOGGER.error(object.get("error_code") + ":" + object.get("reason"));
				throw new StockException(Integer.parseInt(object.get("error_code").toString()),
						object.get("reason").toString());
			}
		} catch (Exception e) {
			LOGGER.error("this is a error: ", e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *
	 * @param strUrl
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 */
	public static String net(String strUrl, Map<String, String> params, String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	// 将map型转为请求参数型
	public static String urlencode(Map<String, String> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
