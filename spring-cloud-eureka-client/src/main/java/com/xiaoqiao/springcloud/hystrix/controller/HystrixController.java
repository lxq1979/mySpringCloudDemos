package com.xiaoqiao.springcloud.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoqiao.springcloud.hystrix.service.IHystrixService;

/**
 * 
 * @author xiaoqiao.liu
 *
 */


@EnableAutoConfiguration
@RestController
public class HystrixController {

	@Autowired
	private IHystrixService service;
	
	@RequestMapping("/call")
	public String callDependencyService(){
		return service.callDependencyService();
	}
}
