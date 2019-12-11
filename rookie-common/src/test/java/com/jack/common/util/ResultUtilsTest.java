package com.jack.common.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jack
 * @Classname ResultUtilsTest
 * Create by jack 2019/12/11
 * @date: 2019/12/11 22:12
 * @Description:
 * junit5测试资料：
 * https://www.cnblogs.com/one12138/p/11536492.html
 * https://blog.csdn.net/ryo1060732496/article/details/80792246
 * http://www.51testing.com/html/09/n-3719809.html
 * https://juejin.im/post/5d80c66f51882539aa5adc10
 * https://zhuanlan.zhihu.com/p/55648107
 *
 * JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
 *
 * JUnit Platform：是基于JVM的运行测试的基础框架在，它定义了开发运行在这个测试框架上的TestEngine API。此外该平台提供了一个控制台启动器，可以从命令行启动平台，可以为Gradle和 Maven构建插件，同时提供基于JUnit 4的Runner
 *
 *JUnit Jupiter：是在JUnit 5中编写测试和扩展的新编程模型和扩展模型的组合.Jupiter子项目提供了一个TestEngine在平台上运行基于Jupiter的测试
 *
 * JUnit Vintage：提供了一个TestEngine在平台上运行基于JUnit 3和JUnit 4的测试
 *
 * @Test:注解在方法上标记方法为测试方法，以便构建工具和 IDE 能够识别并执行它们。
 * JUnit 5不再需要手动将测试类与测试方法为public，包可见的访问级别就足够了。
 *
 * @BeforeAll :只执行一次，执行时机是在所有测试和 @BeforeEach 注解方法之前。
 * @BeforeEach :在每个测试执行之前执行。
 * @AfterEach :在每个测试执行之后执行。
 * @AfterAll:只执行一次，执行时机是在所有测试和 @AfterEach 注解方法之后。
 * @DisplayName:测试类或者方法显示名称
 * @Disabled：禁用测试类或者方法
 * @Tag:为测试类或者方法添加标签
 */
@DisplayName("我的第一个测试用例")
class ResultUtilsTest {
    @Test
    public void test1(){
        System.out.println("test1");
        assertEquals(2, 1 + 1);
    }

    /**
     * @BeforeAll和@AfterAll,必须用在静态方法上
     */
    @Test
    @BeforeAll
    public static void test2(){
        System.out.println(" @BeforeAll test2");
        assertEquals(2, 1 + 1);
    }

    @Test
    @AfterAll
    public static void test3(){
        System.out.println("@AfterAll test3");
        assertEquals(2, 1 + 1);
    }

    @Test
    @BeforeEach
    public void test4(){
        System.out.println("@BeforeEach test4");
        assertEquals(2, 1 + 1);
    }

    @Test
    @AfterEach
    public void test5(){
        System.out.println("@AfterEach test5");
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test6(){
        System.out.println("test6");
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test7(){
        System.out.println("test7");
        assertEquals(2, 1 + 1);
    }

}