package com.jack.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jack
 * @Classname BaseResponse
 * Create by jack 2019/12/22
 * @date: 2019/12/22 20:42
 * @Description:
 *
 * 统一响应注解
 * 添加注解后，统一响应体才能生效
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface BaseResponse {
}
