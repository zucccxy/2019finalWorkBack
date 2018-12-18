package org.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 云片短信工具
 * @author sun
 *
 */
public class ShortYunMessageUtil {
    //查账户信息的http地址
    private static String URI_GET_USER_INFO = "https://sms.yunpian.com/v1/user/get.json";

    //智能匹配模板发送接口的http地址
    private static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/batch_send.json";
    
    //单条发送短信
    private static String URI_SEND_SMS_SINGLE = "https://sms.yunpian.com/v2/sms/single_send.json";

    //模板发送接口的http地址
    private static String URI_TPL_SEND_SMS = "https://sms.yunpian.com/v1/sms/tpl_send.json";

    //发送语音验证码接口的http地址
    private static String URI_SEND_VOICE = "https://voice.yunpian.com/v1/voice/send.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";
    
    //xjz  apikey
    private static String apikey = "bf48c6c9a5f36c411ecfed9800a699b5";
    //用户提现提醒   模板id
    private static Long tpl_withdraw_id = 1481583L;
    
    
    /**
     * 发送验证码
     *
     * @param apikey apikey
     * @param text   　短信内容
     * @param mobile 　接受的手机号
     * @return json格式字符串
     * @throws IOException 【鼎升凯优】亲爱的#name#，您的验证码是#code#。有效期为#hour#，请尽快验证
     */

    public static String sendCode(int code, String mobile,String name) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("text", "【鼎升凯优】亲爱的会员，您的验证码是"+code+"。有效期为5分钟，请尽快验证。");
        params.put("mobile", mobile);
		String message = post(URI_SEND_SMS_SINGLE, params);
		JSONObject json = new JSONObject();
		json = JSONObject.fromObject(message);
        System.out.println(message);
        //获取返回码
        return json.getString("code");
    }
    
    /**
     * 批量发送短信,相同内容多个号码,智能匹配短信模板
     *
     * @param apikey 成功注册后登录云片官网,进入后台可查看
     * @param text   需要使用已审核通过的模板或者默认模板
     * @param mobile 接收的手机号,多个手机号用英文逗号隔开
     * @return json格式字符串
     */
    public static String batchSend( String text, String mobile) {
        Map<String, String> params = new HashMap<String, String>();//请求参数集合
//        mobile = "15757101914,15757101439";
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", mobile);
        String message = post("https://sms.yunpian.com/v2/sms/batch_send.json", params);
		JSONObject json = new JSONObject();
		json = JSONObject.fromObject(message);
        System.out.println(message);
        return json.getString("total_count");
    }
    
    
    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */
	private static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
	
	
	/**
	 * 批量个性化发送
	 */
	public static String multiSend(String phones,String text) throws UnsupportedEncodingException {
	    Map<String, String> params = new HashMap<String, String>();//请求参数集合
	    params.put("apikey", apikey);
	    params.put("text", text);
	    params.put("mobile", phones);
	    return post("https://sms.yunpian.com/v2/sms/multi_send.json", params);//请自行使用post方式请求,可使用Apache HttpClient
	}
	public static void main(String[] args) throws IOException {	
	    String code = sendCode(123456, "13757738258","邹浩翔");
	    System.out.println(code);
    }

}
