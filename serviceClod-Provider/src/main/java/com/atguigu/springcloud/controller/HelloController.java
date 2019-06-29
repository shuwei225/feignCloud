package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private DiscoveryClient client;
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello()
	{
		return "hello";
	}
	@RequestMapping(value="/service",method=RequestMethod.GET)
	public Object service()
	{
		List<String> services=client.getServices();
		for (String service : services) {
			System.out.println("************"+service);
		}
		 List<ServiceInstance> servList=client.getInstances("MINROSERVICECLOUD-DEPT");
		 for (ServiceInstance serviceInstance : servList) {
			System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort());
		}
		return this.client;
		 
	}
}
