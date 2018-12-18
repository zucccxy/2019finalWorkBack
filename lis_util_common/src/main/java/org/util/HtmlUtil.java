package org.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 处理html的工具类
 * 
 * @author
 * @date 2010-1-25 上午02:47:56
 */
public class HtmlUtil {
	private static final String HTML_SCRIPT = "\\s*<[script|SCRIPT][^>]+\\s+\\s*>\\s+[^<]+\\s*</[script|SCRIPT]>";
	private static final String HTML_CLEAR = "<script[\\s\\S]*?>[\\s\\S]*?</script>|</?iframe[^>]*>";
	private static final String HTML_DIV_1 = "<div[\\s\\S]*?>";
	private static final String HTML_DIV_2 = "</div>";
	private static final String HTML_REGEX_1 = "\\&[a-zA-Z]{1,10};";
	private static final String HTML_REGEX_2 = "<[^>]*>";
	private static final String HTML_REGEX_3 = "[(/>)<]";

	private static final String REGEX_TITLE = "\\s*<title>\\s*.*?\\s*</title>";
	private static final String REGEX_DESCRIPTION = "<\\s*meta name=\"description\"\\s+([^>]+)\\s*>";
	private static final String REGEX_DESC_CONTENT = "\\s*content\\s*=\\s*\"([^\"]+)\\s*\"";

	private static final String REGEX_IMG = "<\\s*img\\s+([^>]+)\\s*>";
	private static final String REGEX_IMG_SRC = "\\s*src\\s*=\\s*\"([^\"]+)\\s*\"";

	private static final String HTTP = "http";

	public static void main(String[] args) {
		System.out.println("<img src=\"\" />".replaceAll(REGEX_IMG,
				StringUtils.EMPTY));
	}

	/**
	 * 移除IMG标签
	 * 
	 * @param str
	 * @return
	 */
	public static String clearImgTag(String str) {
		if (StringUtils.isBlank(str))
			return "";

		return str.replaceAll(REGEX_IMG, StringUtils.EMPTY);
	}

	/**
	 * 移除HTML标签
	 * 
	 * @param html
	 * @return
	 */
	public static String removeTag(String html) {
		if (StringUtils.isBlank(html))
			return null;

		return html.replaceAll(HTML_SCRIPT, StringUtils.EMPTY).replaceAll(
				HTML_REGEX_1, StringUtils.EMPTY).replaceAll(HTML_REGEX_2,
				StringUtils.EMPTY).replaceAll(HTML_REGEX_3, StringUtils.EMPTY);
	}

	/**
	 * 清除HTML中的iframe、script等
	 * 
	 * @param html
	 * @return
	 */
	public static String clear(String html) {
		if (StringUtils.isBlank(html)) {
			return "";
		}

		return html.replaceAll(HTML_DIV_1, StringUtils.EMPTY).replaceAll(
				HTML_DIV_2, StringUtils.EMPTY).replaceAll(HTML_CLEAR,
				StringUtils.EMPTY);
	}

	/**
	 * 获取网页的标题，从&lt;title&gt;&lt;/title&gt;标签中获取 如果没有该标签，或是解析该标签时发生运行时异常，则返回null
	 * 
	 * @param html
	 * @return
	 */
	public static String getTitle(String html) {
		Pattern pattern = Pattern.compile(REGEX_TITLE);
		Matcher matcher = pattern.matcher(html);

		String title = null;
		if (matcher.find()) {
			String titleHtml = matcher.group();
			try {
				titleHtml = titleHtml.trim();
				title = titleHtml.substring(7, titleHtml.length() - 8);
			} catch (Throwable e) {
				return null;
			}
		}

		return title;
	}

	/**
	 * 获取网页中的描述信息，从&lt;meta name="description"/&gt;标签中得到该信息
	 * 如果没有该标签，或者在解析该标签时出现运行时异常，则返回null
	 * 
	 * @param html
	 * @return
	 */
	public static String getDescription(String html) {
		Pattern pattern = Pattern.compile(REGEX_DESCRIPTION);
		Matcher matcher = pattern.matcher(html);

		String desc = null;

		Pattern descContentPattern = Pattern.compile(REGEX_DESC_CONTENT);
		if (matcher.find()) {
			String descriptionHtml = matcher.group();

			Matcher contentMatcher = descContentPattern
					.matcher(descriptionHtml);
			if (contentMatcher.find()) {
				desc = contentMatcher.group();
				try {
					desc = desc.trim();
					desc = desc.substring(9, desc.length() - 1);
				} catch (Throwable e) {
					return null;
				}
			}
		}

		return desc;
	}

	/**
	 * 从网页代码中获取所有图片的链接地址，如果没有图片，返回空的列表
	 * 
	 * @param html
	 * @return
	 */
	public static List<String> getImages(String html) {
		List<String> imgSrcs = new ArrayList<String>();

		Pattern pattern1 = Pattern.compile(REGEX_IMG, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern1.matcher(html);

		// img src元素的正则表达式：匹配img标签内的src属性
		Pattern pattern2 = Pattern.compile(REGEX_IMG_SRC,
				Pattern.CASE_INSENSITIVE);

		while (matcher.find()) {
			// group()返回符合表达式的内容
			Matcher matcher2 = pattern2.matcher(matcher.group());
			// 一定要find(),这是实际的匹配动作
			if (matcher2.find()) {
				String src = matcher2.group();
				int i1 = src.indexOf(HTTP);
				if (i1 != -1) {
					imgSrcs.add(src.substring(i1, src.length() - 1));
				}
			}
		}

		return imgSrcs;
	}

	/**
	 * 把字符串中的特殊字符转换为HTML字符
	 * 
	 * @param str
	 * @return
	 */
	public static String toHtml(String str) {
		if (str == null) {
			str = "";
		}

		String html = str;
		html = html.replace("&", "&amp;");
		html = html.replace("<", "&lt;");
		html = html.replace(">", "&gt;");
		html = html.replace("\r\n", "\n");
		html = html.replace("\n", "<br>");
		html = html.replace("\t", "    ");
		html = html.replace(" ", "&nbsp;");
		html = html.replace("\"", "&quot;");

		return html;
	}

	/**
	 * 把字符串中的HTML字符换为特殊字符转
	 * 
	 * @param html
	 * @return
	 */
	public static String toStr(String html) {
		if (StringUtils.isBlank(html)) {
			return "";
		}

		String str = html;
		str = str.replace("&amp;", "&");
		str = str.replace("&lt;", "<");
		str = str.replace("&gt;", ">");
		str = str.replace("\n", "\r\n");
		str = str.replace("<br>", "\n");
		str = str.replace("    ", "\t");
		str = str.replace("&nbsp;", " ");
		str = str.replace("&quot;", "\"");

		return str;
	}

	/**
	 * 忽略字符串中的宽度设置样式
	 * 
	 * @param str
	 * @return
	 */
	public static String ignoreWidth(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}

		str = str.replaceAll("width=\"\\d*((px)|(PX))?\"", "");
		str = str.replaceAll("", "");
		return str;

	}

}
