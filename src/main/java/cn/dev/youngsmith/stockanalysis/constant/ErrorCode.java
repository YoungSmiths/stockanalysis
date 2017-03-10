package cn.dev.youngsmith.stockanalysis.constant;

public interface ErrorCode {

	final static int SUCCESS = 0;

	final static int SERVER_INNER_ERROR = 1;

	final static int CATCHER_FAIL = 6100;
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

	/***
	 * 1500 - 1600 DataBase相关错误码
	 */
	final static int EC_DATABASE_ERROR = 1500;

	/***
	 * 5001 - 5500 def相关错误码
	 */

	final static int EC_DEFROOT_NOTFOUND = 5001;

}
