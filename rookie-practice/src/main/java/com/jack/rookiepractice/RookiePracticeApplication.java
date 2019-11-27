package com.jack.rookiepractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

@SpringBootApplication
public class RookiePracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RookiePracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Assert.isNull("a","空值");
		System.out.println("*********************启动成功*********************");
	}
}
