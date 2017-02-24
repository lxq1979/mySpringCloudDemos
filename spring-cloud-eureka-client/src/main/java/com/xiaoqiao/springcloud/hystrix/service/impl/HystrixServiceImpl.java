package com.xiaoqiao.springcloud.hystrix.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoqiao.springcloud.hystrix.service.ICallDependencyService;
import com.xiaoqiao.springcloud.hystrix.service.IHystrixService;

@Service
public class HystrixServiceImpl implements IHystrixService{
	
	@Autowired
	private ICallDependencyService dependcyService;

	public String callDependencyService() {
	    return dependcyService.mockGetUserInfo();
    }
}
