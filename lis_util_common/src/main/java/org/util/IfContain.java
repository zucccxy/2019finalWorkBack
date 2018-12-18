package org.util;

public class IfContain {
/**
 * 判断 一个数组中的元素 是否 存在于另一个 数组中
 * @param a
 * @param b
 * @return
 */
	public static boolean ifContain(String[] a,String[] b){
		for(String numA:a){
			for(String numB:b){
				if(numA.equals(numB)){
					return true;
				}
			}
		}
		return false;
	}
}
