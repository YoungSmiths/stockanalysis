package cn.dev.youngsmith.stockanalysis.constant;

public interface AuthConstants {
	final static int ORIGIN_TOKEN_SIZE = 16;
	final static int MIN_USERNAME_LENGTH = 2;
	final static int MAX_USERNAME_LENGTH = 16;
	final static int MIN_PASSWORD_LENGTH = 8;
	final static int MAX_PASSWORD_LENGTH = 20;
	final static String DES_KEY = "9!8@#$2%^4&*(4)k";
	final static int TOKEN_EXPIRE_TIME = 15 * 60 * 1000; 
	final static String BASIC_TOKEN = "9#!T$*&3hhbSA&Tgb3D#%Dh32487^%^#";
	final static String API_PROJECT_NAME = "/project/version";
	final static String AES_KEY = "license";
	final static String UPDATE_ADMIN = "已被升级为管理员";
	final static String UPDATE_GENERAL = "已被降为普通用户";
	final static String UPDATE_FREEZE = "已被管理员冻结";
	final static String UPDATE_AUTH = "已通过审核，您现在可以登录";
}
