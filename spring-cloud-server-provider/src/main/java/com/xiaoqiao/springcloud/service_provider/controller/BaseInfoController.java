package com.xiaoqiao.springcloud.service_provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoqiao.springcloud.facade.entity.BusinessDictionary;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@RefreshScope
public class BaseInfoController {
	
	@Value("${ServiceProviderDevelop:xxx}")
	private String developer;
		
	@RequestMapping("/getString")
	public String getString(String inputStr){		
		return "Current program was developed by "+developer+", input string is:"+inputStr;
	}
	
	@RequestMapping("/getObject")
	public BusinessDictionary getObject(String type,String code){	
		System.out.println(type+" "+code);
		BusinessDictionary bd=new BusinessDictionary();
		bd.setId("idxxx");
		bd.setDesc_("obj type transfer");
		bd.setOrd("1");
		bd.setType(type);
		bd.setCode(code);
		bd.setValue("xiaoqiao");
		return bd;
	}
	
	
	@RequestMapping("/listObject")
	public List<BusinessDictionary> getListObj(){
		List<BusinessDictionary> listObj= new ArrayList<BusinessDictionary>();
		
		BusinessDictionary bd1=new BusinessDictionary();
		bd1.setId("idxxx1");
		bd1.setDesc_("obj type transfer");
		bd1.setOrd("1");
		bd1.setType("type1");
		bd1.setCode("code1");
		bd1.setValue("xiaoqiao");
		listObj.add(bd1);
		
		BusinessDictionary bd2=new BusinessDictionary();
		bd2.setId("idxxx2");
		bd2.setDesc_("obj type transfer");
		bd2.setOrd("2");
		bd2.setType("type2");
		bd2.setCode("code2");
		bd2.setValue("xiaoqiao");
		listObj.add(bd2);
		
		return listObj;
	}
	
}
