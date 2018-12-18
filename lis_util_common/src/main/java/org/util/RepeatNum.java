package org.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算重复 id出现的次数
 * @author Administrator
 *
 */
public class RepeatNum {

	/**
	 * 计算重复 id出现的次数
	 * @param numArr
	 * @return
	 */
	public static Map<Long,Integer> repeatCount(ArrayList<Long> array){
		Map<Long,Integer> map = new HashMap<Long,Integer>();
		for(Long num:array){
			if(map.containsKey(num)){
				map.put(num, map.get(num)+1);
			}else{
				map.put(num, 1);
			}
		}
		return map;
	}
}
