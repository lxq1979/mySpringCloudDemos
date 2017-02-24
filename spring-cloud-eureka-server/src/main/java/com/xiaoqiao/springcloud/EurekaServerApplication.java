package com.xiaoqiao.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  * @author xiao-qiao.liu
 * */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication{
	
	@Value("${eureka_server_rest_port_01:xxxx}")
	private String rest_port;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
		//new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
	}
	
	@RequestMapping("/home")
	public String home(){
		return "rest_port:"+rest_port;
	}
}
