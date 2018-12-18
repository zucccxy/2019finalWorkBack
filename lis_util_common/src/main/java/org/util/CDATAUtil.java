package org.util;

public class CDATAUtil {
	public static String htmlspecialchars(String str){
		str = str.replaceAll("'","").replaceAll("\r", "").replaceAll("\n", "");
		str = "<![CDATA[" + str + "]]>";
		return str;
	}
}
