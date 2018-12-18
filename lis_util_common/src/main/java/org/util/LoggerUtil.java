package org.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class LoggerUtil {

	
	 	public static final String LOG_TARGET_TYPE="targetType";
	    public static final String LOG_ACTION="action";
	    public static final String LOG_REMARK="remark";
	    public LoggerUtil(){}

//	    public static OperationRecords getLog(HttpServletRequest request){
	        //1.依次获取每个属性信息 userId,operator,action,remark,ip,targetType
//	    	OperationRecords record = new OperationRecords();
	        
//	        log.setIp(LoggerUtil.getCliectIp(request));
//	        log.setOperator("operator");
//	        log.setUserId(1);
//	        log.setAction("create");
//	        log.setCustomerId("0000-1111");
//	        log.setTargetType("message");
//	        log.setRemark("消息发布");
//	    	record.s
//	        return record;
//	    }
	    /**
	     * 获取客户端ip地址
	     * @param request
	     * @return
	     */
	    public static String getCliectIp(HttpServletRequest request){
	        String ip = request.getHeader("X-Real-IP");
	        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	        ip = request.getHeader("X-Forwarded-For");
	        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
	            // 多次反向代理后会有多个IP值，第一个为真实IP。
	            int index = ip.indexOf(',');
	            if (index != -1) {
	                return ip.substring(0, index);
	            } else {
	                return ip;
	            }
	        } else {
	            return request.getRemoteAddr();
	        }
	    }
}
