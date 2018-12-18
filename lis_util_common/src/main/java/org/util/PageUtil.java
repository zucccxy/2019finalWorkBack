package org.util;

/**
 * 用于分页
 * 
 * @author Administrator
 * 
 */
public class PageUtil {
	
	/**
	 * 得到开始页码
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Integer startNo(Integer pageNo, Integer pageSize) {
		return (pageNo - 1) * pageSize;
	}
	
	/**
	 * 得到总页码
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public final static Integer totalPageNo(Integer page, Integer pageSize) {

		if (page % pageSize == 0) {
			return page / pageSize;
		}
		return page / pageSize + 1;
	}

}
