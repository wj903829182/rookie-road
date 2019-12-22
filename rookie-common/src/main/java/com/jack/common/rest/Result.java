package com.jack.common.rest;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * create by jack 2019/11/27
 *
 * @author jack
 * @date: 2019/11/27 21:02
 * @Description:
 *https://segmentfault.com/a/1190000019795918
 *
 * @Accessors(chain = true)支持链式调用
 * @Builder支持静态链式调用
 */
@Accessors(chain = true)
@Data
@Builder
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 5846917318379681348L;
    /**
     * 请求结果代码
     */
    private Integer code;
    /**
     * 请求说明
     */
    private String msg;
    /**
     * 请求返回的数据，包括正确请求的数据，和错误请求的数据
     */
    private T data;

}
