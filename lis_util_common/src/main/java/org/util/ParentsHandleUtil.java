package org.util;

import java.util.HashMap;
import java.util.Map;

public class ParentsHandleUtil {

	private static int lastIndex = 0;
	
	private static String level;
	/**
	 * 获取有效的parentsId
	 * @param parentsId
	 * @return
	 */
	public static String getUsefulId(String parentsId){
		String[] split = parentsId.split("/");
		for (int i = split.length-1; i >= 0; i--) {
			if (!(split[i].equals("*"))) {
				lastIndex = i+1;
				break;
			} 
		}
		String newString = "";
		for (int i = 0; i < lastIndex; i++) {
				newString = newString + split[i] + "/";
		}
		return newString;
	}
	/**
	 * 获取最近一级有效ID和层级
	 * @param parentsId
	 * @return
	 */
	public static Map<String, String> getLevelAndId(String parentsId){
		String[] split = parentsId.split("/");
		String newString = null;
		for (int i = split.length-1; i >= 0; i--) {
			if (!(split[i].equals("*"))) {
				level = Integer.toString(i+1);
				newString = split[i];
				break;
			} 
		}
		Map<String, String> merge = new HashMap<String, String>();
		merge.put("level", level);
		merge.put("Id", newString);
		return merge;
	}
	/**
	 * 获取到层级对应ID封装的map
	 * @param parentsId
	 * @return
	 */
	public static Map<String, String> getUserfulId(String parentsId){
		String[] split = parentsId.split("/");
//		int m = 0;
		Map<String, String> merge = new HashMap<String, String>();
//		for (int i = split.length-1; i >= 0; i--) {
//			if (!(split[i].equals("*"))) {
//				m = i;
//			} 
//			m=m+1;
//		}
		for(int i = 0;i < split.length;i++){
			merge.put((i+1)+"", split[i]);
		}
		return merge;
	}
}
