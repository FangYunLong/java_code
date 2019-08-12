package com.fylong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class JavaApplication {

	@RequestMapping("/")
	public String index(){
		return "Codeing";
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

}
