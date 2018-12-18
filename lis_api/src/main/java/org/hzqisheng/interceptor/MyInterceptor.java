package org.hzqisheng.interceptor;

import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器1
 *
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	response.setHeader("Access-Control-Allow-Origin", "http://localhost:8187");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT,PATCH");
	    //设置时区
		System.setProperty("user.timezone","GMT+8");
	    TimeZone.setDefault(null);
	    HttpSession session = request.getSession();
//	    if (session.getAttribute("currUser") == null) {
//	    	User currUser = new User();
//	    	currUser.setUserId(1L);
//	    	session.setAttribute("currUser", currUser);
//	    }
		return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
