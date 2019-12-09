package com.jack.rookietest.controller;

import com.jack.rookietest.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
/**
 * @author jack
 * @Classname TestControllerTest
 * Create by jack 2019/11/29
 * @date: 2019/11/29 22:46
 * @Description:
 *@AutoConfigureMockMvc:自动注入
 *@ExtendWith(SpringExtension.class) :spring boot2.x使用junit5需要使用注解 @ExtendWith(SpringExtension.class)
 *
 *
 *
 */
class TestControllerTest extends BaseTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test1() throws Exception {
        System.out.println("test1");
        //throw new Exception();
    }

}