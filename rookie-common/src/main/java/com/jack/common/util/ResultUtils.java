package com.jack.common.util;

import com.alibaba.fastjson.JSONObject;
import com.jack.common.rest.Result;

/**
 * create by jack 2019/11/27
 *
 * @author jack
 * @date: 2019/11/27 21:44
 * @Description:
 */
public class ResultUtils {
    public static final Integer SUCCESS_CODE = 1;
    public static final Integer FAIL_CODE = 0;
    public static final String SUCCESS_MSG = "success";
    public static final String FAIL_MSG = "fail";
    /**
     * 成功
     * @return
     */
    public static Result success() {
        return Result.builder().code(SUCCESS_CODE).msg(SUCCESS_MSG).build();
    }

    public static Result success(String msg) {
        return Result.builder().code(SUCCESS_CODE).msg(msg).build();
    }

    public static Result success(String msg,Object data) {
        return Result.builder().code(SUCCESS_CODE).msg(msg).data(data).build();
    }

    public static Result success(Integer code,String msg,Object data) {
        return Result.builder().code(code).msg(msg).data(data).build();
    }

    public static Result success(Object data) {
        return Result.builder().code(SUCCESS_CODE).msg(SUCCESS_MSG).data(data).build();
    }

    /**
     * 失败
     * @return
     */
    public static Result fail() {
        return Result.builder().code(FAIL_CODE).msg(FAIL_MSG).build();
    }

    public static Result fail(Object data) {
        return Result.builder().code(FAIL_CODE).msg(FAIL_MSG).data(data).build();
    }

    public static Result fail(Integer code,String msg) {
        return Result.builder().code(code).msg(msg).build();
    }

    public static Result fail(String msg,Object data) {
        return Result.builder().code(FAIL_CODE).msg(msg).data(data).build();
    }

    public static Result fail(Integer code,String msg,Object data) {
        return Result.builder().code(code).msg(msg).data(data).build();
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSON(ResultUtils.success()));
        System.out.println(JSONObject.toJSON(ResultUtils.fail()));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "b");
        System.out.println(JSONObject.toJSON(ResultUtils.success(jsonObject)));
        System.out.println(JSONObject.toJSON(ResultUtils.success("调用成功")));
        System.out.println(JSONObject.toJSON(ResultUtils.success("调用成功",jsonObject)));
        System.out.println("***************");
        System.out.println(JSONObject.toJSON(ResultUtils.fail(jsonObject)));
        System.out.println(JSONObject.toJSON(ResultUtils.fail(400,"调用失败")));
        jsonObject.clear();
        jsonObject.put("失败", "失败数据");
        System.out.println(JSONObject.toJSON(ResultUtils.fail("调用失败",jsonObject)));
        System.out.println(JSONObject.toJSON(ResultUtils.fail(500,"内部服务器错误",jsonObject)));

    }
}
