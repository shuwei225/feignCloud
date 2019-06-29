package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	@Autowired
	private RestTemplate restTemplate; 
	
	private static String  hiostName="localhost:8001";//"MINROSERVICECLOUD-DEPT";
	@RequestMapping(value="/consumer/service",method=RequestMethod.GET)
	public Object service()
	{
		  return restTemplate.getForObject(hiostName+"/service" , Object.class);
	}
}
