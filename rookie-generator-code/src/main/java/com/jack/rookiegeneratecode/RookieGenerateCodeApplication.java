package com.jack.rookiegeneratecode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;

@SpringBootApplication
public class RookieGenerateCodeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RookieGenerateCodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//构造模板引擎
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		//模板所在目录，相对于当前classloader的classpath。
		resolver.setPrefix("templates/");
		//模板文件后缀
		resolver.setSuffix(".html");
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(resolver);

		//构造上下文(Model)
		Context context = new Context();
		context.setVariable("name", "蔬菜列表");
		context.setVariable("array", new String[]{"土豆", "番茄", "白菜", "芹菜"});

		//渲染模板
		FileWriter write = new FileWriter("result.html");
		templateEngine.process("example", context, write);
	}
}
