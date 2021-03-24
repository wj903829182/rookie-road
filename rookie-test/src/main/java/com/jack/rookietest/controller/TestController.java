package com.jack.rookietest.controller;

import com.alibaba.fastjson.JSONObject;
import com.jack.common.rest.Result;
import com.jack.common.util.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jack
 * @Classname TestController
 * Create by jack 2019/11/29
 * @date: 2019/11/29 22:35
 * @Description:
 */
@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("test1")
    public Result test1(){
        JSONObject json = new JSONObject();
        json.put("name","jack");
        json.put("age","18");

        return ResultUtils.success(json);
    }

}
