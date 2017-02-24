package com.xiaoqiao.springcloud.hystrix.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaoqiao.springcloud.hystrix.service.ICallDependencyService;

@Service
public class CallDependencyServiceImpl implements ICallDependencyService{
	private Random random=new Random();

	@HystrixCommand(fallbackMethod="fallback")
	public String mockGetUserInfo() {
	    int randomInt = random.nextInt(10);
	    if(randomInt<8){
	    	throw new RuntimeException("Call dependency service fail.");
	    }else{
	    	return "UserName:xiaoqiao.liu;number:"+randomInt;
	    }
    }

	public String fallback() {
	    return "Some excption occur call fallback method";
    }
	

}
