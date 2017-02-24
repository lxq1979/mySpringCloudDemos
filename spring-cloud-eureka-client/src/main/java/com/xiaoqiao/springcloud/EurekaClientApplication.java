package com.xiaoqiao.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaoqiao.liu
 * 
 * */

@SpringBootApplication
// spring boot
@EnableDiscoveryClient
@EnableEurekaClient
// eureka client
@RestController
// restfull
@EnableAutoConfiguration
// config info
@EnableCircuitBreaker
@EnableHystrixDashboard
public class EurekaClientApplication {
	@Autowired
	RestTemplate client;

	public static void main(String[] args) {
		// SpringApplication.run(EurekaClientApplication.class, args);
		new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
	}

	/**
	 * LoadBlanced注解表明restTemplate使用LoadBlancerClient執行請求
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		return template;
	}
}
