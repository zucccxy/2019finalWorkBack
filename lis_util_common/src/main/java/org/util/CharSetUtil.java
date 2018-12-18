package org.util;

/**
 * get提交编码转换
 * @author Administrator
 *
 */
public class CharSetUtil {
	
	
	public static String change(String str) throws Exception{
		String newStr = new String(str.getBytes("ISO-8859-1"),"UTF-8");
		return newStr;
	}
	
}
