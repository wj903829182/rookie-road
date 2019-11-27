package com.jack.rookiepractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RookiePracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RookiePracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*********************启动成功*********************");
	}
}
