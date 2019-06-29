package com.tarena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarena.service.HelloService;

@RestController
public class HelloControler {

	@Autowired
	private HelloService helloService;
	@RequestMapping("/feign/hello")
	private String getHello(){
		return helloService.hello();
	}
}
