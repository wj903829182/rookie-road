package com.jack.rookietest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.Name;

@SpringBootApplication
public class RookieTestApplication implements CommandLineRunner{

	@Value("${name}")
	private String name;
	@Value("${sex}")
	private String sex;
	@Value("${age}")
	private String age;
	/*@Value("${jack.hello}")
	private String hello;*/

	public static void main(String[] args) {
		SpringApplication.run(RookieTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*****************启动成功*****************"+name);
		System.out.println("性别："+sex);
		System.out.println("年龄："+age);
		/*System.out.println("hello："+hello);*/
	}
}
