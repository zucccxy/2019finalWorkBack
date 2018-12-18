package org.util;

public class TokenUtil {
	/**
	 * 产生一个token
	 */
	public static String generateToken(String salt) {
		String token = PasswordUtil.generate(Long.toString(System.currentTimeMillis()), salt);
		return token;
	}
}
