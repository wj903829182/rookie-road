package com.jack.rookie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jack
 * @Classname TestController
 * Create by jack 2020/1/6
 * @date: 2020/1/6 23:28
 * @Description:
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/test1")
    public String test1() {
        return "index2";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "index3";
    }
}
