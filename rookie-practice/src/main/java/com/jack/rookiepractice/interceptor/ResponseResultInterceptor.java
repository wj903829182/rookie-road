package com.jack.rookiepractice.interceptor;

import com.jack.common.annotation.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Jack
 * @ClassName ResponseResultInterceptor
 * Created By Jack on 2020/7/17
 * @date 2020/7/17 14:51
 * @Description:
 * 返回结果拦截器，判断是否在类或者方法上使用了BaseResponse自定义注解，使用的话添加一个请求标志
 */
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
     public static final String RESPONSE_RESULT_ANNOTATION = "RESPONSE_RESULT_ANNOTATION";
    /**
     * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("request请求地址path:[{}]", request.getServletPath());
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> beanType = handlerMethod.getBeanType();
        Method method = handlerMethod.getMethod();

        //判断是否在类对象上面添加了注解
        if (beanType.isAnnotationPresent(BaseResponse.class)) {
            request.setAttribute(RESPONSE_RESULT_ANNOTATION,beanType.getAnnotation(BaseResponse.class));
        } else if (method.isAnnotationPresent(BaseResponse.class)) {
            //判断是否在方法添加了注解
            request.setAttribute(RESPONSE_RESULT_ANNOTATION,method.getAnnotation(BaseResponse.class));
        }
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView （这个博主就基本不怎么用了）；
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
