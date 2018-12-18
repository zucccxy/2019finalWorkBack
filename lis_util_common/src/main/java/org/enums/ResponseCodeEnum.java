package org.enums;

/**
 * 返回枚举
 *
 * @author
 * @date 2018/7/23
 */
public enum ResponseCodeEnum {

    /**成功    success*/
    SUCCESS(1, "成功"),

    /**未登录    noLogin*/
    NO_LOGIN(2, "未登录"),
    
    /**失败    fail*/
    FAIL(3, "失败"),
    
    /**未登录    noLogin*/
    ERROR(4, "异常"),



    ;

    private Integer code;
    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

   

    public Integer getCode() {
		return code;
	}

	public String getMessage() {
        return message;
    }
}
