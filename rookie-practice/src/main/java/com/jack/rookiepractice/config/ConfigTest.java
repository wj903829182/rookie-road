package com.jack.rookiepractice.config;

import com.jack.rookiepractice.test.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jack
 * @Classname ConfigTest
 * Create by jack 2019/12/19
 * @date: 2019/12/19 21:37
 * @Description:
 */
@Configuration
public class ConfigTest {
    @Bean
    @ConditionalOnMissingBean(Student.class)
    public Student student2() {
        System.out.println("3333333333333");
        Student s = new Student();
        s.setAge(22);
        return s;
    }
}
