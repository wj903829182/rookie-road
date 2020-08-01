package com.jack.common.util.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jack
 * @Classname Test1
 * Create by jack 2019/12/20
 * @date: 2019/12/20 21:54
 * @Description:
 * 参考资料：https://blog.csdn.net/ryo1060732496/article/details/80812102
 *
 * @Test、@TestTemplate、@RepeatedTest、@BeforeAll、@AfterAll、@BeforeEach或@AfterEach注释的方法不能返回值
 *
 *
 *
 *
 */
public class Test1 {
    @Test
     void test1(){
        //断言
        assert 1 == 1;
        //判断相等
        assertEquals(2, 1+1);
        assertEquals("hello", "hello");
    }

    @DisplayName("重复测试注解")
    @Test
    @RepeatedTest(3)
    void test2() {
         assertEquals(2,3-1);
    }
}
