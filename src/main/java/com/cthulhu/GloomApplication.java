package com.cthulhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class GloomApplication {

	public static void main(String[] args) {
		SpringApplication.run(GloomApplication.class, args);
	}
	@RequestMapping("/main")
	public void main(HttpServletRequest request){
		//设置数据库名
	}

}
