package com.jack.rookiepractice.config;

import com.jack.rookiepractice.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author Jack
 * @ClassName WebMvcConfig
 * Created By Jack on 2020/7/13
 * @date 2020/7/13 23:29
 * @Description: https://www.cnblogs.com/zwqh/p/11651865.html
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源路径 css,js,img等
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        //视图
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }

    /**
     * 路径和页面映射
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/index2").setViewName("/index2");
        registry.addViewController("/index3").setViewName("/index3");
        registry.addViewController("/layout/baseLayout").setViewName("/layout/baseLayout");
        //错误页面
        registry.addViewController("/404").setViewName("/404");
        registry.addViewController("/500").setViewName("/500");
    }




    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //可添加多个，这里选择拦截所有请求地址，进入后判断是否有加注解即可
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new ResponseResultInterceptor());
        interceptorRegistration.excludePathPatterns("/js/**");
        interceptorRegistration.excludePathPatterns("/css/**");
        interceptorRegistration.excludePathPatterns("/images/**");
        interceptorRegistration.excludePathPatterns("/plugin/**");
        interceptorRegistration.excludePathPatterns("/font/**");

        interceptorRegistration.addPathPatterns("/**");
    }
}
