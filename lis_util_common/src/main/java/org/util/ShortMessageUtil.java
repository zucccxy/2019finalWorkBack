package org.util;

/**
 * 阿里百川短信工具
 * @author haobo
 *
 */
public class ShortMessageUtil {
	
//	private static String url = "http://gw.api.taobao.com/router/rest";
//	//测试
//	private static String appkey = "23274338";
//	//正式
////	private static String appkey = "";
//	//测试
//	private static String secret = "481c860994f7d7cd7f2c30397b103585";
//	//正式
////	private static String secret = "";
//	//注册验证码
//	public static Long registerId  = 290902781L;
//	//重置登录验证码
//	public static Long reSetLoginId  = 290902781L;
//	//忘记登陆密码验证码
//	public static Long forgetPwdId  = 290902781L;
//	//交易密码验证码
//	public static Long payPwdId  = 290902781L;
//	//重设交易密码验证码
//	public static Long resetPayPwdId  = 290902781L;
//	//更换手机验证码
//	public static Long rePhone  = 290902781L;
//	//更换手机验证码
//	public static Long bind  = 290902781L;
//	//用户提现 提醒短信
//	public static Long withdraw = 3764L;
//	//发送不同验证码
//	public static String sendCode(String mobile,Long templateId) throws ApiException{
//		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//		OpenSmsSendvercodeRequest req = new OpenSmsSendvercodeRequest();
//		SendVerCodeRequest obj117744 = new SendVerCodeRequest();
//		obj117744.setExpireTime(10L);
//		obj117744.setSessionLimitInTime(10L);
////		obj117744.setSessionLimit(5L);
////		obj117744.setDeviceLimit(10L);
////		obj117744.setDeviceLimitInTime(123L);
////		obj117744.setMobileLimit(123L);
////		obj117744.setSessionLimitInTime(123L);
////		obj117744.setExternalId("12345");
////		obj117744.setMobileLimitInTime(123L);
//		obj117744.setTemplateId(templateId);
////		obj117744.setContext("上课啦：0517");
////		obj117744.setSignatureId(867L);
////		obj117744.setSessionId("demo");
////		obj117744.setDomain("demo");
////		obj117744.setDeviceId("demo");
//		obj117744.setMobile(mobile);
////		obj117744.setContextString("{\"appName\":\"xxx\"}");
////		obj117744.setVerCodeLength(5L);//大于等于4的数字，小于等于10的数字L
//		req.setSendVerCodeRequest(obj117744);
//		OpenSmsSendvercodeResponse rsp;
//		rsp = client.execute(req);
//		System.out.println(rsp.getBody());
//		
//		JSONObject json = new JSONObject();
//		String message = "";
//		json = JSONObject.fromObject(rsp.getBody());
//		message = json.getString("open_sms_sendvercode_response");
//		json = JSONObject.fromObject(message);
//		message = json.getString("result");
//		json = JSONObject.fromObject(message);
//		message = json.getString("message");
//		return message;
//	}
//	
//	//判断验证码是否正确
//	public static boolean checkCode(String code, String mobile) throws ApiException{
//		if ("315355".equals(code)) {//万能验证码
//			return true;
//		}
//		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//		OpenSmsCheckvercodeRequest req = new OpenSmsCheckvercodeRequest();
//		CheckVerCodeRequest obj116871 = new CheckVerCodeRequest();
////		obj116871.setDomain("demo");
////		obj116871.setCheckFailLimit(123L);
////		obj116871.setCheckSuccessLimit(123L);
//		obj116871.setVerCode(code);
//		obj116871.setMobile(mobile);
//		req.setCheckVerCodeRequest(obj116871);
//		OpenSmsCheckvercodeResponse rsp = client.execute(req);
//		System.out.println(rsp.getBody());
////		JsonUtil.readValue(rsp.getBody(), );
////		return rsp.getMsg();
//		if(!"SUCCESS".equals(rsp.getResult().getMessage())){
//			return false;
//		}
//		return true;
//	}
//	
//	//发送短信消息
//	public static void sendMessage(String mobile) throws ApiException{
//		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//		OpenSmsSendmsgRequest req = new OpenSmsSendmsgRequest();
//		SendMessageRequest obj117714 = new SendMessageRequest();
//		obj117714.setTemplateId(123L);
//		obj117714.setSignatureId(123L);
//		obj117714.setContextString("{\"key\":\"value\"}");
////		obj117714.setExternalId("demo");
//		obj117714.setMobile(mobile);
////		obj117714.setDeviceLimit(123L);
////		obj117714.setSessionLimit(123L);
////		obj117714.setDeviceLimitInTime(123L);
////		obj117714.setMobileLimit(123L);
////		obj117714.setSessionLimitInTime(123L);
////		obj117714.setMobileLimitInTime(123L);
////		obj117714.setSessionId("demo");
////		obj117714.setDomain("demo");
////		obj117714.setDeviceId("demo");
//		req.setSendMessageRequest(obj117714);
//		OpenSmsSendmsgResponse rsp = client.execute(req);
//		System.out.println(rsp.getBody());
//	}
//	
//	public static void main(String[] args) throws ApiException {
//		System.out.println("a");
////		sendCode();
////		checkCode("","13735447282");
//	}
//	/**
//	 * 发送 用户提现提醒
//	 * @param mobile
//	 * @param templateId
//	 * @param mess
//	 * @return
//	 * @throws ApiException
//	 */
//	public static String sendWithdraw(String mobile,String mess,Integer count) throws ApiException{
//		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//		OpenSmsSendvercodeRequest req = new OpenSmsSendvercodeRequest();
//		SendVerCodeRequest obj117744 = new SendVerCodeRequest();
//		obj117744.setExpireTime(10L);
//    	obj117744.setSessionLimitInTime(10L);
//		obj117744.setTemplateId(withdraw);
//		obj117744.setMobile(mobile);
//		obj117744.setContextString("{\"name\":\""+mess+"\",\"count\":\""+count+"\"}");
//		req.setSendVerCodeRequest(obj117744);
//		OpenSmsSendvercodeResponse rsp;
//		rsp = client.execute(req);
//		System.out.println(rsp.getBody());
//		
//		JSONObject json = new JSONObject();
//		String message = "";
//		json = JSONObject.fromObject(rsp.getBody());
//		message = json.getString("open_sms_sendvercode_response");
//		json = JSONObject.fromObject(message);
//		message = json.getString("result");
//		json = JSONObject.fromObject(message);
//		message = json.getString("message");
//		return message;
//	}
	
}
