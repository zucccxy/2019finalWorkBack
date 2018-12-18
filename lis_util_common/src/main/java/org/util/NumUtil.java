package org.util;

public class NumUtil {
/**
 * 将 1 转换为 0001 形式
 * @param num
 * @return
 */
	public static String no(String num){
		for(int i=num.length();i<4;i++ ){
			num = "0"+num;
		}
		return num;
	}
}
