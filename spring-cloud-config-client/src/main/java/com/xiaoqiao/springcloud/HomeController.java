package com.xiaoqiao.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@RefreshScope
public class HomeController {

	private static final String template = "Hello, %s!";

	@Value("${foo:World,this is LXQ!}")
	private String name;

	@Value("${name:defaultName}")
	private String myName;

	@RequestMapping("/")
	public String home() {
		
		return String.format(template, name);
	}

	@RequestMapping("/myName")
	public String myName() {
		return String.format(template, myName);
	}

}
