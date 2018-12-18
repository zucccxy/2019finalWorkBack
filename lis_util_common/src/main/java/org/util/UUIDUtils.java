/*
 * $Id$
 */
package org.util;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * <code>UUID工具类</code>
 * 
 */
public class UUIDUtils {

	private static SecureRandom random = new SecureRandom();

	/**
	 * 产生一个GUID字符串
	 * 
	 * @return GUID字符串
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 使用SecureRandom随机生成Long.
	 */
	public static long randomLong() {
		return random.nextLong();
	}

	// 获取随机数字, length随机数长度
	public static String getRandomNumber(int length) {
		final String allChar = "0123456789";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString().toLowerCase();
	}

	public static void main(String[] args) {
		System.out.println(generateUUID());

	}

}
