package com.example.demo;

import java.net.URLDecoder;
import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ChatServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatServiceDemoApplication.class, args);
	}

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@RequestMapping(path = "/send", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String send(@RequestParam String message) {
		String decodeMessage = URLDecoder.decode(message, Charset.forName("UTF-8"));
    	return String.format("%s", decodeMessage);
    }

}
