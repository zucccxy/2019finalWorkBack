package org.util;

import java.util.List;

/**
 * 去除重复数组
 * @author 80664
 *
 */
public class DuplicateUtil {

	public static List<Long> removeList(List<Long> oldList,List<Long> newList){
		oldList.removeAll(newList);
		return oldList;
	}
}
