package com.xiaoqiao.springcloud.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**@author LXQ
 *  
 */


@EnableConfigServer
@SpringBootApplication
@RestController
public class ConfigServerApplication {

	@Value("${name:World!}")
	String bar;
	
	@RequestMapping("/")
	String hello(){
		return "Hello "+ bar+"!";
	}
	
	public static void main(String[] args){
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
