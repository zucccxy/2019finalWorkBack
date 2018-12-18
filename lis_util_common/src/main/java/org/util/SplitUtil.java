package org.util;


public class SplitUtil {
	
	/**
	 * 逗号连接
	 * @author Administrator
	 *
	 */
	public static String append(String[] str) throws Exception{
		String newStr = null;
		for (int i = 0; i < str.length; i++){
			if(i ==0){
				newStr = str[i];
			}else{
				newStr += "," + str[i]; 
			 }
			}
		return newStr;
	}
	
	/**
	 * 逗号分隔
	 * @author Administrator
	 *
	 */
	public static String[] toSplit(String str) throws Exception{
		String[] newStr = str.replace(",","，").split("，");
		return newStr;
	}

}
