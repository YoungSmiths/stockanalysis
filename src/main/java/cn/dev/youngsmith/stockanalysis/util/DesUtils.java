package cn.dev.youngsmith.stockanalysis.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.dev.youngsmith.stockanalysis.constant.AuthConstants;
import cn.dev.youngsmith.stockanalysis.exception.StockException;

public class DesUtils {

	private final static Logger LOGGER = LoggerFactory.getLogger(DesUtils.class);
	private Cipher encryptCipher;
	private Cipher decryptCipher;
	private final String ALGORITHM_DES = "DES";

	/**
	 * constructor
	 * 
	 * @param keyStr
	 * @throws StockException
	 */
	public DesUtils(String keyStr) throws StockException {
		try {
			Key key = getKey(keyStr);
			// 返回实现指定转换的 Cipher 对象
			this.encryptCipher = Cipher.getInstance(ALGORITHM_DES);
			this.decryptCipher = Cipher.getInstance(ALGORITHM_DES);
			// 用密钥初始化 Cipher
			this.encryptCipher.init(Cipher.ENCRYPT_MODE, key);
			this.decryptCipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception e) {
			LOGGER.error("init error: ", e);
			throw new StockException(e);
		}
	}

	/**
	 * 构造密钥
	 * 
	 * @param keyStr
	 * @return
	 */
	private Key getKey(String keyStr) {
		byte[] keyBytes = keyStr.getBytes();
		byte[] bytes = new byte[8];
		for (int i = 0; (i < keyBytes.length) && (i < bytes.length); i++) {
			bytes[i] = keyBytes[i];
		}
		// 根据给定的字节数组构造一个密钥
		Key key = new SecretKeySpec(bytes, ALGORITHM_DES);
		return key;
	}

	/**
	 * 加密数据
	 * 
	 * @param bytes
	 * @return
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public byte[] encrypt(byte[] bytes) throws GeneralSecurityException {
		// 按单部分操作加密数据
		return this.encryptCipher.doFinal(bytes);
	}

	/**
	 * 加密数据
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String str) {
		String result = null;
		try {
			result = byteArrToHexStr(encrypt(str.getBytes("utf-8")));
		} catch (Exception e) {
			LOGGER.error("encrypt error: ", e);
		}
		return result;
	}

	/**
	 * 解密数据
	 * 
	 * @param bytes
	 * @return
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public byte[] decrypt(byte[] bytes) throws GeneralSecurityException {
		// 按单部分操作解密数据
		return decryptCipher.doFinal(bytes);
	}

	/**
	 * 解密数据
	 * 
	 * @param str
	 * @return
	 * @throws StockException
	 * @throws Exception
	 */
	public String decrypt(String str) throws StockException {
		String result = null;
		try {
			result = new String(decrypt(hexStrToByteArr(str)));
		} catch (Exception e) {
			LOGGER.error("decrypt error: ", e);
			throw new StockException(e);
		}
		return result;
	}

	/**
	 * transform byte array into hexadecimal string
	 * 
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	private static String byteArrToHexStr(byte[] bytes) throws StockException {
		if (bytes == null || bytes.length == 0) {
			throw new StockException(HttpStatus.SC_BAD_REQUEST, "The byte array is empty.");
		}
		int len = bytes.length;
		StringBuilder sb = new StringBuilder(len * 2);
		for (int i = 0; i < len; i++) {
			int tmp = bytes[i];
			while (tmp < 0) {
				tmp += 256;
			}
			if (tmp < 16) {
				sb.append("0");
			}
			// 转为16进制字符串
			sb.append(Integer.toString(tmp, 16));
		}
		return sb.toString();
	}

	/**
	 * transform hexadecimal string into byte array
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private static byte[] hexStrToByteArr(String hexStr) throws StockException {
		if (StringUtils.isEmpty(hexStr)) {
			throw new StockException(HttpStatus.SC_INTERNAL_SERVER_ERROR, "The hexadecimal string is empty.");
		}
		byte[] bytes = new byte[0];
		try {
			bytes = hexStr.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("hexStr.getBytes error: ", e);
		}
		int len = bytes.length;
		byte[] result = new byte[len / 2];
		for (int i = 0; i < len; i = i + 2) {
			String tmp = new String(bytes, i, 2);
			result[i / 2] = (byte) Integer.parseInt(tmp, 16);
		}
		return result;
	}

	public static void main(String[] args) {
		DesUtils des;
		try {
			des = new DesUtils(AuthConstants.DES_KEY);
			// 加密
			LOGGER.debug(des.encrypt("yancloud"));
			// 解密
			LOGGER.debug(des.decrypt("8620b455a4767a56"));
		} catch (Exception e) {
			LOGGER.error("Decrypt error: ", e);
		}

	}
}
