package org.util;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanMap;

/**
 * Map工具类
 * 
 * @author gjc
 *
 */
public class MapUtil {
	
	private final static String PARAM_ERROR = "参数错误";

	/**
	 * 
	 * 对象转Map<String, Object>(获取需要的属性)
	 * 
	 * @param Map<Object,
	 *            Object> 第一个Object:对象; 第二个Object:需要的属性列表;
	 * @return
	 * @throws MyException
	 */
	public static Map<String, Object> object2Map(Map<Object, Object> objectMap){
		Map<String, Object> map = new HashMap<String, Object>();
		Set<Object> set = objectMap.keySet();
		for (Object object : set) {// 获取对象
			BeanMap b = new BeanMap(object);// 对象转成map
			Set<?> strSet = b.keySet();
			List<String> list = (List<String>) objectMap.get(object);
			for (String str : list) {
				if (b.get(str) == null) {// 减少循环
					for (Object s : strSet) {
						s = s.toString();
						if (!s.equals(str)) {// 传入参数不存在
							try {// 抛出自定义错误(输入参数错误)
								throw new Exception(str+PARAM_ERROR);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else {
							map.put(str, "");
						}
					}
				} else {
					map.put(str, b.get(str));
				}
			}
		}
		return map;
	}

	/**
	 * 测试
	 * 
	 * @throws MyException
	 */
//	public static void main(String[] args) throws MyException {
//		Student student = new Student();
//		Teacher teacher = new Teacher();
//		teacher.setName("my");
//		teacher.setSex(1);
//		teacher.setTel("135");
//		student.setName("测试");
//		student.setAge(18);
//		Date date = new Date();
//		student.setDate(date);
//		List<String> list = Arrays.asList("name", "date", "age");
//		List<String> list2 = Arrays.asList("tel","sex");
//		Map<Object, Object> map = new HashMap<Object, Object>();
//		map.put(student, list);
//		map.put(teacher, list2);
//		Map<String, Object> json = object2Map(map);
//		Date d = (Date) json.get("date");
//		System.out.println(d.getTime());
//		System.out.println(json);
//	}

}

