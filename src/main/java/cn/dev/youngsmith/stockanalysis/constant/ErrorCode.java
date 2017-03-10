package cn.dev.youngsmith.stockanalysis.constant;

public interface ErrorCode {

	final static int SUCCESS = 0;

	final static int SERVER_INNER_ERROR = 1;

	final static int EC_MISSING_TOKEN = 2;

	final static int EC_EXPIRED_TOKEN = 3;

	final static int EC_INVALID_TOKEN = 4;

	final static int PERMISSION_DENIED = 8;

	final static int ACCESS_FORBIDDEN = 9;

	final static int SUPER_REGISTER_FORBIDDEN = 11;

	final static int FAILED_TO_PASS_APPLICATION = 12;

	final static int USER_BEEN_FROZEN = 13;

	final static int EC_IO_FAILED = 90;

	final static int EC_UNKNOWN_ERROR = 99;

	/**
	 * invalid or unkown parameter
	 */
	final static int EC_PARAM = 600;

	/**
	 * invalid required parameters
	 */
	final static int EC_INVALID_REQUIRED_PARAM = 605;

	/**
	 * Authentication failed: invalid userName or password
	 */
	final static int EC_AUTH_FAILED = 1000;
	final static int EC_USERNAME_EXISTED = 1001;
	final static int EC_USERNAME_NOT_EXIST = 1002;
	final static int EC_EMAIL_EXISTED = 1003;
	final static int EC_EMAIL_NOT_EXIST = 1004;
	final static int EC_USER_TO_AUDIT = 1005;
	final static int EC_USER_DISABLED = 1006;
	final static int EC_USER_TO_AUDIT_OR_LOCK = 1007;
	final static int EC_USER_LOGINED = 1008;
	final static int EC_PASSWRODISWRONG = 1009;

	final static int EC_DENY_RESET_PWD = 1100;
	final static int EC_SEND_SIGN_EMAIL_FAIL = 1101;
	final static int EC_FORBIDDEN = 1102;

	static final int REQUEST_TIME_OUT = 1103;

	/***
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * 1500 - 1600 DataBase相关错误码
	 * 
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	final static int EC_DATABASE_ERROR = 1500;

	/***
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * 5001 - 5500 def相关错误码
	 * 
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 */

	final static int EC_DEFROOT_NOTFOUND = 5001;

	final static int EC_DEFSUB_NOTFOUND = 5002;

	final static int EC_PATH_NOTFOUND = 5003;

	final static int EC_LICENSEINFO_PUBLICKEY_NOTFOUND = 5004;

	final static int EC_LICENSEINFO_CLASS_NOT_FOUND = 5005;

	final static int EC_CREATE_XMLSIGNATURE_ERROR = 5006;

	final static int EC_PARSE_XML_ERROR = 5007;

	final static int EC_IO_EXCEPTION = 5008;

	final static int EC_AES_CIPHER_EXCEPTION = 5009;

	final static int EC_OBJECT_OR_FIELD_IS_NULL = 5010;

	final static int EC_NO_ALGORITHM = 5011;

	final static int EC_UNSUPPORTED_ENCODING = 5012;

	final static int EC_OTHER_GENERAL = 5012;

	final static int EC_UPLOADLICENSE_NOTEXIST = 5013;

	final static int EC_SENDMAIL_ERROR = 5014;

	final static int EC_CREATE_EXCEL_ERROR = 5015;

	final static int DB_GET_LICENSEiNFO_ERROR = 5016;

	final static int EC_DOWNLOAD_EXCEL_ERROR = 5017;

	final static int EC_ZIP_ERROR = 5018;

	final static int EC_LICENSE_RECORDS_NOT_EXIST = 5019;

}
