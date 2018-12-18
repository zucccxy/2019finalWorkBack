package org.util;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class StringUtil {
	
	/**
	 * 将",1,2,3,"拆解为{1,2,3}List<Long>
	 * @param data
	 * @return
	 */
	public static List<Long> stringSplit(String data) {
		String[] splits = data.split(",");
		ArrayList<Long> list = new ArrayList<>();
		for (String split : splits) {
			if(!"".equals(split)){
				list.add(Long.parseLong(split));
			}
		}
		return list;
	}
	/**
	 * 将2个Long类型组合为  "1/2"类型 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String stringBuild(Long a,Long b) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(a);
		stringBuffer.append("/");
		stringBuffer.append(b);
		return stringBuffer.toString();
	}
	

	//过滤emoji表情
	public static String filterEmoji(String source) { 
        if(source != null)
        {
            Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;
            Matcher emojiMatcher = emoji.matcher(source);
            if ( emojiMatcher.find())
            {
                source = emojiMatcher.replaceAll("*");
                return source ;
            }
        return source;
       }
       return source; 
    }
	/**
	 * 字符串是否非空
	 *
	 * @param str 字符串
	 * @return boolean true 表示非空 false 表示空
	 * @throws
	 */
	public static boolean isNotBlank(String str) {
		return str != null && str.length() > 0;
	}

	/**
	 * 字符串是空字符串
	 *
	 * @param str 字符串
	 * @return boolean true 空字符串 false 非空
	 * @throws
	 */
	public static boolean isBlank(String str) {
		return str == null || str.length() < 1;
	}

	/**
	 * 将“-1”或者空字符串转为null,否则不变
	 *
	 * @param str 字符串
	 * @return java.lang.String
	 * @throws
	 */
	public static String changeToNullOrStr(String str) {
		return "-1".equals(str) || isBlank(str) ? null : str;
	}
}
