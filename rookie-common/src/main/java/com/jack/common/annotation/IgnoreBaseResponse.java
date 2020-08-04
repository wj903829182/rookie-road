package com.jack.common.annotation;

import java.lang.annotation.*;

/**
 * @author Jack
 * @ClassName IgnoreBaseResponse
 * Created By Jack on 2020/8/4
 * @date 2020/8/4 16:38
 * @Description:
 * 忽略统一返回
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface IgnoreBaseResponse {
}
