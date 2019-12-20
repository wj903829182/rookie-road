package com.jack.rookiepractice;

import com.jack.rookiepractice.test.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

@SpringBootApplication
public class RookiePracticeApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(RookiePracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Assert.isNull("a","空值");
		System.out.println("*********************启动成功*********************");
		System.out.println(applicationContext.getBean(Student.class).getAge());
		System.out.println(applicationContext.getBean(Student.class).getAge());
	}

	@Bean
	//@ConditionalOnMissingBean(name = "student1")
	@ConditionalOnMissingBean(Student.class)
	public Student student1() {
		System.out.println("1111111111");
		Student s = new Student();
		s.setAge(18);
		return s;
	}

	@Bean
	//@ConditionalOnMissingBean(name = "student2")
	@ConditionalOnMissingBean(Student.class)
	public Student student2() {
		System.out.println("22222222222222");
		Student s = new Student();
		s.setAge(20);
		return s;
	}


}
