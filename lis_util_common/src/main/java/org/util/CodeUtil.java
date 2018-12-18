package org.util;

public class CodeUtil {

	/**
	 * 随机生成6位数字
	 * @return
	 */
	public static int getCode(){
		return (int)((Math.random()*9+1)*100000);
	}
}
