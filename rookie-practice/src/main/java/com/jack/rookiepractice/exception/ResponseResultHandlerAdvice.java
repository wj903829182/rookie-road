package com.jack.rookiepractice.exception;

import com.jack.common.rest.Result;
import com.jack.common.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author jack
 * @Classname ResponseResultHandlerAdvice
 * Create by jack 2019/12/22
 * @date: 2019/12/22 20:55
 * @Description:
 * 统一响应体处理器
 * @ControllerAdvice(annotations = BaseResponse.class)
 * @Slf4j
 * 统一响应体处理器
 * @ControllerAdvice(annotations = BaseResponse.class)
 */

@ControllerAdvice
@Slf4j
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        log.info("returnType:"+methodParameter);
        log.info("converterType:"+aClass);
        return true;
    }

    /**
     * 在方法体返回之前改写
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 判断响应的Content-Type为JSON格式的body
        if(MediaType.APPLICATION_JSON.equals(mediaType) || MediaType.APPLICATION_JSON_UTF8.equals(mediaType)){
            // 如果响应返回的对象为统一响应体，则直接返回body
            if(body instanceof Result){
                return body;
            }else{
                // 只有正常返回的结果才会进入这个判断流程，所以返回正常成功的状态码
                Result responseResult = ResultUtils.success(body);
                return responseResult;
            }
        }
        // 非JSON格式body直接返回即可
        return body;
    }
}
