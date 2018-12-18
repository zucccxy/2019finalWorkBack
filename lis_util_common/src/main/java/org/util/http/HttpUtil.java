package org.util.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;





public class HttpUtil {
	/**
	 * Http请求
	 * 
	 * @param url
	 * @param params
	 * @param isGet
	 * @param useSsl
	 * @return
	 */
	public static String requestForString(String url, String params,String partner,
			boolean isGet, boolean useSsl) {
		System.out.println("requestForString url=" + url + " params=" + params);
		HttpRequestBase httpRequest;
		if (isGet) {
			if (!StringUtils.isEmpty(params)) {
				if (url.indexOf("?") == -1) {
					url += "?" + params;
				} else {
					url += "&" + params;
				}
			}
			httpRequest = new HttpGet(url);
		} else {
			HttpPost httpPost = new HttpPost(url);
			if (!StringUtils.isEmpty(params)) {
				httpPost.setEntity(new StringEntity(params, "UTF-8"));
			}
			httpRequest = httpPost;
		}
		return execute(httpRequest, useSsl,partner);
	}
	
	
	public static String RequestForm(String Url,Map<String,String> Parms){		
		if(Parms.isEmpty()){
			return  "参数不能为空！";
		}
		String PostParms = "";
		for (String key : Parms.keySet()) {
			if(!key.isEmpty()){
				PostParms += key + "="+Parms.get(key)+"&";
			}
			
		}		
		PostParms = PostParms.substring(0,PostParms.length()-1);
		
		System.out.println("【请求参数】："+PostParms);
		HttpSendModel httpSendModel = new HttpSendModel(Url + "?" + PostParms);
		System.out.println("【SDK请求】：" + Url + "?" + PostParms);
		httpSendModel.setMethod(HttpMethod.POST);
		SimpleHttpResponse response = null;
		try {
			response = doRequest(httpSendModel, "utf-8");
		} catch (Exception e) {
			return e.getMessage();
		}
		return response.getEntityString();

	}
	
	
	
	
	

	/**
	 * 执行
	 * 
	 * @param httpRequest
	 * @param useSsl
	 * @return
	 */
	private static String execute(HttpRequestBase httpRequest, boolean useSsl,String partner) {
		long start = System.currentTimeMillis();
		HttpClient httpClient = null;
		HttpEntity entity = null;
		try {
			if (!useSsl) {
				httpClient = HttpClientManager.getHttpClient();
			} else {
				// 指定读取证书格式为PKCS12
				KeyStore keyStore = KeyStore.getInstance("PKCS12");
				// 读取本机存放的PKCS12证书文件
				FileInputStream instream = new FileInputStream(new File(Thread.currentThread().getContextClassLoader().getResource("apiclient_cert.p12").getPath()));
				try {
					// 指定PKCS12的密码(商户ID)
					keyStore.load(instream, partner
							.toCharArray());
				} finally {
					instream.close();
				}
				SSLContext sslcontext = SSLContexts
						.custom()
						.loadKeyMaterial(keyStore,
								partner.toCharArray())
						.build();
				// 指定TLS版本
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
						sslcontext,
						new String[] { "TLSv1" },
						null,
						SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
				// 设置httpclient的SSLSocketFactory
				httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
						.build();
				
				httpClient = (DefaultHttpClient) getNewHttpClient();
				
				try {  
		            //Secure Protocol implementation.    
		            SSLContext ctx = SSLContext.getInstance("SSL");  
		            //Implementation of a trust manager for X509 certificates    
		            X509TrustManager tm = new X509TrustManager() {  
		  
		                public void checkClientTrusted(X509Certificate[] xcs,  
		                        String string) throws CertificateException {  
		  
		                }  
		  
		                public void checkServerTrusted(X509Certificate[] xcs,  
		                        String string) throws CertificateException {  
		                }  
		  
		                public X509Certificate[] getAcceptedIssuers() {  
		                    return null;  
		                }  
		            };  
		            ctx.init(null, new TrustManager[] { tm }, null);  
		            SSLSocketFactory ssf = new SSLSocketFactory(ctx);  
		            ClientConnectionManager ccm = httpClient.getConnectionManager();  
		            //register https protocol in httpclient's scheme registry    
		            SchemeRegistry sr = ccm.getSchemeRegistry();  
		            sr.register(new Scheme("https", 443, ssf));  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }
			}
			HttpResponse response = httpClient.execute(httpRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode !=200) {
				// TODO
			}
			entity = response.getEntity();
			String str = EntityUtils.toString(entity, "UTF-8");
			System.out.println("url[" + httpRequest.getURI().toString() + "]请求返回[" + str
					+ "]");
			return str;
		} catch (Exception e) {
			httpRequest.abort();
		} finally {
			if (null != entity) {
				try {
					EntityUtils.consume(entity);
				} catch (IOException e) {
				}
			}

			System.out.println("请求url[" + httpRequest.getURI() + "]耗时"
					+ (System.currentTimeMillis() - start));
		}
		return "{}";
	}
	
	/**  
	    * @Title: getNewHttpClient  
	    * @Description: Methods Description 
	    * @param @return     
	    * @return HttpClient  
	    * @throws  
	    */   
	      
	    private static HttpClient getNewHttpClient() {  
	        try {  
	            KeyStore trustStore = KeyStore.getInstance(KeyStore  
	                    .getDefaultType());  
	            trustStore.load(null, null);  
	            SSLSocketFactory sf = new SSLSocketFactory(trustStore);  
	            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
	            HttpParams params = new BasicHttpParams();  
	            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);  
	            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);  
	            SchemeRegistry registry = new SchemeRegistry();  
	            registry.register(new Scheme("http", PlainSocketFactory  
	                    .getSocketFactory(), 80));  
	            registry.register(new Scheme("https", sf, 443));  
	            ClientConnectionManager ccm = new ThreadSafeClientConnManager(  
	                    params, registry);  
	            return new DefaultHttpClient(ccm, params);  
	        } catch (Exception e) {  
	            return new DefaultHttpClient();  
	        }  
	    }
	    
	    /**
		 * 请求是否成功
		 * 
		 * @param statusCode
		 * @return
		 */
		public static boolean isRequestSuccess(int statusCode) {
			return statusCode == 200;
		}
		
		public static SimpleHttpResponse doRequest(HttpSendModel httpSendModel,
				String getCharSet) throws Exception {

			// 创建默认的httpClient客户端端
			SimpleHttpClient simpleHttpclient = new SimpleHttpClient();

			try {
				return doRequest(simpleHttpclient, httpSendModel, getCharSet);
			} finally {
				simpleHttpclient.getHttpclient().getConnectionManager().shutdown();
			}

		}

		/**
		 * @param httpclient
		 * @param httpSendModel
		 * @param getCharSet
		 * @return
		 * @throws Exception 
		 */
		public static SimpleHttpResponse doRequest(
				SimpleHttpClient simpleHttpclient, HttpSendModel httpSendModel,
				String getCharSet) throws Exception {

			HttpRequestBase httpRequest = buildHttpRequest(httpSendModel);

			if (httpSendModel.getUrl().startsWith("https://")) {
				simpleHttpclient.enableSSL();
			}

			try {
				HttpResponse response = simpleHttpclient.getHttpclient().execute(
						httpRequest);
				int statusCode = response.getStatusLine().getStatusCode();

				if (isRequestSuccess(statusCode)) {
					return new SimpleHttpResponse(statusCode, EntityUtils.toString(
							response.getEntity(), getCharSet), null);
				} else {
					return new SimpleHttpResponse(statusCode, null, response
							.getStatusLine().getReasonPhrase());
				}

			} catch (Exception e) {
				throw new Exception("http请求异常", e);
			}

		}
		
		/**
		 * @param httpSendModel
		 * @return
		 * @throws Exception 
		 */
		protected static HttpRequestBase buildHttpRequest(
				HttpSendModel httpSendModel) throws Exception {
			HttpRequestBase httpRequest;
			if (httpSendModel.getMethod() == null) {
				throw new Exception("请求方式未设定");
			} else if (httpSendModel.getMethod() == HttpMethod.POST) {

				String url = httpSendModel.getUrl();
				String sendCharSet = httpSendModel.getCharSet();
				List<HttpFormParameter> params = httpSendModel.getParams();

				List<NameValuePair> qparams = new ArrayList<NameValuePair>();
				if (params != null && params.size() != 0) {

					for (HttpFormParameter param : params) {
						qparams.add(new BasicNameValuePair(param.getName(), param
								.getValue()));
					}

				}

				HttpPost httppost = new HttpPost(url);
				try {
					httppost.setEntity(new UrlEncodedFormEntity(qparams,
							sendCharSet));
				} catch (UnsupportedEncodingException e) {
					throw new Exception("构建post请求参数失败", e);
				}

				httpRequest = httppost;
			} else if (httpSendModel.getMethod() == HttpMethod.GET) {
				HttpGet httpget = new HttpGet(httpSendModel.buildGetRequestUrl());

				httpRequest = httpget;
			} else {
				throw new Exception("请求方式不支持：" + httpSendModel.getMethod());
			}

			return httpRequest;
		}

}
