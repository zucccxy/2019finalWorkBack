package org.util.response;

import org.enums.ResponseCodeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回类型
 *
 * @author LQ
 * @date 2018/7/23
 */
public class ResponseDataUtil {

	private static final String CODE = "code";
	private static final String DATA = "data";
	private static final String MESSAGE = "message";

	public static ResponseDataBuilder build() {
		return new ResponseDataBuilder();
	}

	/**
	 * 返回成功
	 * 
	 * @return
	 */
	public static ResponseDataBuilder ok() {
		return createResponseDataBuilder(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage());
	}

	/**
	 * 返回失败
	 * 
	 * @return
	 */
	public static ResponseDataBuilder fail() {
		return fail(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMessage());
	}

	/**
	 * 返回自定义信息失败
	 * 
	 * @param message
	 *            自定义信息
	 * @return
	 */
	public static ResponseDataBuilder fail(String message) {
		return fail(ResponseCodeEnum.FAIL.getCode(), message);
	}

	/**
	 * 返回自定义信息/自定义code失败
	 * 
	 * @param code
	 *            自定义code
	 * @param message
	 *            自定义信息
	 * @return
	 */
	public static ResponseDataBuilder fail(Integer code, String message) {
		return createResponseDataBuilder(code, message);
	}

	/**
	 * 返回自定义信息/自定义code失败
	 * 
	 * @param codeEnum
	 *            自定义{@link ResponseCodeEnum}枚举
	 * @return
	 */
	public static ResponseDataBuilder fail(ResponseCodeEnum codeEnum) {
		return createResponseDataBuilder(codeEnum.getCode(), codeEnum.getMessage());
	}

	private static ResponseDataBuilder createResponseDataBuilder(Integer code, String message) {
		ResponseDataBuilder builder = new ResponseDataBuilder();
		builder.response.put(CODE, code);
		builder.response.put(MESSAGE, message);
		return builder;
	}

	public static class ResponseDataBuilder {
		private final Map<String, Object> response;

		private final Map<String, Object> data;

		private ResponseDataBuilder() {
			this.response = new HashMap<>();
			this.data = new HashMap<>();
		}

		/**
		 * 创建
		 * 
		 * @return
		 */
		public Map<String, Object> build() {
			response.put(DATA, data);
			return this.response;
		}

		/**
		 * 放入参数
		 * 
		 * @param key
		 * @param value
		 * @return
		 */
		public ResponseDataBuilder putData(String key, Object value) {
			data.put(key, value);
			return this;
		}
	}
}
