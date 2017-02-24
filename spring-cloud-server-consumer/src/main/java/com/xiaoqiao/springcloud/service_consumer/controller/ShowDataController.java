package com.xiaoqiao.springcloud.service_consumer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import com.alibaba.fastjson.JSON;
import com.xiaoqiao.springcloud.facade.entity.BusinessDictionary;

@RestController
public class ShowDataController {
	private String url="http://service.provider/";
	
	@Autowired
	RestTemplate client;
	
	
	@RequestMapping("/string")
	public String getString(){
		return client.getForObject(url+"getString?inputStr={userName}", String.class, "xiaoqiao.liu");
	}
	
	@RequestMapping("/object")
	public String getObj(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("pType", "in-type");
		map.put("pCode", "in-code");
		BusinessDictionary bd=client.getForObject(url+"getObject?type={pType}&code={pCode}", BusinessDictionary.class,map);
		return JSON.toJSONString(bd);
	}
	
	@RequestMapping("/list")
	public String getList(){
		Map<String,String> map = new HashMap<String,String>();
		List<BusinessDictionary> bd=client.getForObject(url+"listObject",List.class);
		return JSON.toJSONString(bd);
	}
	
}
