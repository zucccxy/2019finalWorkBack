package org.hzqisheng.config;



import javax.annotation.Resource;

import org.hzqisheng.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer 
        extends WebMvcConfigurerAdapter {
	
	@Resource
	MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截,excludePathPatterns("/api/user/userLogIn", "/api/user/userRegister") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
       registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/api/user/userLogIn",
               "/api/user/userRegister","/api/user/submitFeedback",
               "/api/article/categoryList","/api/article/articleList",
               "/api/article/articleDetail","/api/article/articleCategories",
               "/api/article/articleCommentCount","/api/article/articleCommentList",
               "/api/article/commentReplayList");
       super.addInterceptors(registry);
    }

}