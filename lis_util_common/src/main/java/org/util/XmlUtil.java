package org.util;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.thoughtworks.xstream.XStream;

/**
 * 封装DOM4J的xpath查询，简化Node的text设置和获取。
 * 
 * @author bing
 * 
 */
public class XmlUtil {

	/**
	 * 分析一个xml字符串，并产生一个Document对象。
	 * 
	 * @param xml
	 * @return
	 */
	public static Document parseXml(String xml) {
		try {
			return DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
		}
		return null;
	}

	/**
	 * 根据xml文本名称，得到文本值
	 * 
	 * @param xml
	 * @param path
	 * @param name
	 * @return
	 */
	public static String getSelectText(String xml, String path, String name) {
		try {
			return getElementText(DocumentHelper.parseText(xml)
					.getRootElement(), path, name);
		} catch (DocumentException e) {
		}
		return null;
	}

	/**
	 * 给一个节点设置文本内容
	 * 
	 * @param xml
	 * @param xpath
	 * @param text
	 */
	public static void setElementCDATAText(Element xml, String xpath,
			String text) {
		Element e = getElement(xml, xpath, true);
		if (text == null) {
			e.addCDATA("");
		} else {
			e.addCDATA(text);
		}
	}

	/**
	 * 给一个节点设置文本内容
	 * 
	 * @param xml
	 * @param xpath
	 * @param text
	 */
	public static void setElementText(Element xml, String xpath, String text) {
		Element e = getElement(xml, xpath, true);
		if (text == null) {
			e.setText("");
		} else {
			e.setText(text);
		}
	}

	/**
	 * 获取元素节点内容
	 * 
	 * @param xml
	 * @param xpath
	 * @return
	 */
	public static String getElementText(Element xml, String xpath) {
		return getElementText(xml, xpath, "");
	}

	/**
	 * 获取元素节点内容
	 * 
	 * @param xml
	 * @param xpath
	 * @param defaultValue
	 * @return
	 */
	public static String getElementText(Element xml, String xpath,
			String defaultValue) {
		Element e = getElement(xml, xpath);
		if (e == null) {
			return defaultValue;
		}
		return e.getText();
	}

	/**
	 * 获取元素属性值
	 * 
	 * @param xml
	 * @param xpath
	 * @param attrName
	 * @return
	 */
	public static String getElementAttribute(Element xml, String xpath,
			String attrName) {
		return getElement(xml, xpath).attributeValue(attrName);
	}

	/**
	 * 设置元素属性值
	 * 
	 * @param xml
	 * @param xpath
	 * @param attrName
	 * @param attrValue
	 */
	public static void setElementAttribute(Element xml, String xpath,
			String attrName, String attrValue) {
		getElement(xml, xpath, true).addAttribute(attrName, attrValue);
	}

	/**
	 * 获取元素
	 * 
	 * @param xml
	 * @param xpath
	 * @return
	 */
	public static Element getElement(Element xml, String xpath) {
		return getElement(xml, xpath, false);
	}

	/**
	 * 获取元素
	 * 
	 * @param xml
	 * @param xpath
	 * @param autoCreate
	 * @return
	 */
	public static Element getElement(Element xml, String xpath,
			boolean autoCreate) {
		Element p = (Element) xml.selectSingleNode(xpath);
		if (p != null) {
			return p;
		}

		// 如果不存在，并要求自动创建这个Node
		if (autoCreate) {
			return DocumentHelper.makeElement(xml, xpath);
		}
		return null;
	}

	/**
	 * 获取元素
	 * 
	 * @param xml
	 * @param xpath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Node> getElements(Element xml, String xpath) {
		return xml.selectNodes(xpath);
	}
	
	/**
	 * SortedMap 转化成string
	 * @param params
	 * @return
	 */
	public static String toXml(SortedMap<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");

		for (Map.Entry<String, String> e : params.entrySet()) {
			sb.append("<" + e.getKey() + ">");
			sb.append(e.getValue());
			sb.append("</" + e.getKey() + ">");
		}
		sb.append("</xml>");
		return sb.toString();
	}
	
	/**
	 * xml转换成object 动态化转化
	 * @param xml
	 * @param classname 类名
	 * @param name xml 根目录 名字
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Object xmlToBean(String xml, String name, String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		XStream xstream = new XStream(); 
		Object newInstance = Class.forName(className).newInstance();
		xstream.aliasType(name, newInstance.getClass());
		Object object = (Object)xstream.fromXML(xml);
		return object;
	}
	

	public static void main(String[] args) {
		/*Document doc = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("root");
		doc.setRootElement(root);
		setElementText(root, "/abc/name", "xiezb");
		setElementText(root, "/abc/value", "123");
		// Element e = root.addElement("abc");
		// e.addElement("name").setText("YY");
		// e.addElement("value").setText("XX");
		System.out.println(doc.asXML());
		System.out.println(Dom4jUtil.getElementText(root, "/root/abc/name",
				null));
		// System.out.println(doc.asXML());

		String str = "<xml><return_code><![CDATA[SUCCESS]]></return_code>"
				+ "<return_msg><![CDATA[OK]]></return_msg>"
				+ "<appid><![CDATA[wx0320f91ac688c64d]]></appid>"
				+ "<mch_id><![CDATA[1235093702]]></mch_id>"
				+ "<device_info><![CDATA[WEB]]></device_info>"
				+ "<nonce_str><![CDATA[2K1QEqARO0FSlOF6]]></nonce_str>"
				+ "<sign><![CDATA[9DA827A593D0F849660B4F669DF1F689]]></sign>"
				+ "<result_code><![CDATA[SUCCESS]]></result_code>"
				+ "<prepay_id><![CDATA[wx2015060720093554e2e5b29c0540383483]]></prepay_id>"
				+ "<trade_type><![CDATA[JSAPI]]></trade_type></xml>";
		doc = Dom4jUtil.parseXml(str);
		root = doc.getRootElement();
		System.out.println(Dom4jUtil.getElementText(root, "return_code",
				"FAIL"));
		System.out.println(Dom4jUtil.getElementText(root, "prepay_id",
				""));*/
		
	}
}
