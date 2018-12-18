package org.util;

public class DominSubUtil {

	public static String DominSubstring(String str) throws Exception{
		String string = str.substring(str.indexOf(".")+1, str.lastIndexOf("."));
		return string;
	}
}
