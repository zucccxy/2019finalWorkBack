package org.util;

/**
 * 常量定义类
 * @author HopeStar
 *
 */
public class Const {

	/**
	 * 初始密码
	 */
	public static final String INIT_PASSWORD = "123456";

	/**
	 * 初始密码（加密后）
	 */
	public static final String ENCRYPT_PASSWORD = new MD5().getStrToMD5(INIT_PASSWORD);

	/**
	 * 登录用户信息
	 */
	public static final String LOGIN_INFO = "loginInfo";
	/**
	 * 用户未登录
	 */
	public static final String LOGIN_NG = "LOGIN_NG";
	
	/**
	 * 父类别ID（敏感词分类）
	 */
	public static final String KEY_WORD_ID = "100001";
	
	/**
	 * 父类别ID（党委类型）
	 */
	public static final String PARTY_TYPE_ID = "100002";
}
