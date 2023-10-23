package com.example.demo;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.Http2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ChatServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatServiceDemoApplication.class, args);
	}

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		String decodeMessage = URLDecoder.decode(name);
    	return String.format("%s", decodeMessage);
    }

}
