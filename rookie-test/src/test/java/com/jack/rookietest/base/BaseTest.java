package com.jack.rookietest.base;

import com.jack.rookietest.RookieTestApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


/**
 * @author jack
 * @Classname Base
 * Create by jack 2019/11/29
 * @date: 2019/11/29 23:41
 * @Description:
 * @RunWith(SpringRunner.class):junit4才使用
 * @ExtendWith(SpringExtension.class)：junit5新增的注解
 * @ActiveProfiles("dev"):指定开发环境
 */
@SpringBootTest(classes = {RookieTestApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class BaseTest {
    @Autowired
    protected MockMvc mockMvc;
    @Test
    @DisplayName("baseTest")
    public void start(){
        System.out.println("************start************");
    }
}
