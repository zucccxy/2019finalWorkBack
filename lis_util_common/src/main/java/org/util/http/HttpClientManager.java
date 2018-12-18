package org.util.http;

import java.io.IOException;

import javax.net.ssl.SSLHandshakeException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

/**
 * HttpClient管理器
 * 
 * @author xie
 * 
 */
@SuppressWarnings("deprecation")
public class HttpClientManager {
	private static final Log log = LogFactory.getLog(HttpClientManager.class);

	private static final PoolingClientConnectionManager conman;
	private static final HttpParams params;
	private static final HttpRequestRetryHandler requestRetryHandler;

	private final static int MAX_TOTAL_CONNECTIONS = 2; // 最大连接数
	private final static int WAIT_TIMEOUT = 60000;// 获取连接的最大等待时间
	private final static int MAX_ROUTE_CONNECTIONS = 200; // 每个路由最大连接数
	private final static int CONNECT_TIMEOUT = 60000; // 连接超时时间
	private final static int READ_TIMEOUT = 60000; // 读取超时时间
	private final static int RETRY_TIMES = 2;// 重试次数

	static {
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory
				.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory
				.getSocketFactory()));

		conman = new PoolingClientConnectionManager(schemeRegistry);
		// Increase max total connection to 200
		conman.setMaxTotal(MAX_TOTAL_CONNECTIONS);
		// Increase default max connection per route to 20
		conman.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);

		params = new BasicHttpParams();
		// 从连接池中取连接的超时时间
		ConnManagerParams.setTimeout(params, WAIT_TIMEOUT);
		// 设置连接超时时间
		HttpConnectionParams.setConnectionTimeout(params, CONNECT_TIMEOUT);
		// 设置读取超时时间
		HttpConnectionParams.setSoTimeout(params, READ_TIMEOUT);

		// 请求重试处理
		requestRetryHandler = new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception,
					int executionCount, HttpContext context) {
				if (executionCount >= RETRY_TIMES) {
					// 如果超过最大重试次数，那么就不要继续了
					return false;
				}
				if (exception instanceof NoHttpResponseException) {
					// 如果服务器丢掉了连接，那么就重试
					return true;
				}
				if (exception instanceof SSLHandshakeException) {
					// 不要重试SSL握手异常
					return false;
				}
				HttpRequest request = (HttpRequest) context
						.getAttribute(ExecutionContext.HTTP_REQUEST);
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					// 如果请求被认为是幂等的，那么就重试
					return true;
				}
				return false;
			}
		};
	}

	/**
	 * 获取HttpClient
	 * 
	 * @return
	 */
	public static HttpClient getHttpClient() {
		PoolStats ps = conman.getTotalStats();
		log.error("conman pool stat before:" + ps.getAvailable() + "-"
				+ ps.getLeased() + "-" + ps.getMax() + "-" + ps.getPending());
		DefaultHttpClient httpClient = new DefaultHttpClient(conman, params);
		httpClient.setHttpRequestRetryHandler(requestRetryHandler);
		ps = conman.getTotalStats();
		log.error("conman pool stat after:" + ps.getAvailable() + "-"
				+ ps.getLeased() + "-" + ps.getMax() + "-" + ps.getPending());
		// DefaultHttpClient httpClient = new DefaultHttpClient(params);
		// httpClient.setHttpRequestRetryHandler(requestRetryHandler);
		return httpClient;
	}

}
