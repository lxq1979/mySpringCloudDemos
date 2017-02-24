package com.xiaoqiao.springcloud.hystrix.service;

public interface ICallDependencyService {
	String mockGetUserInfo();
	String fallback();
}
