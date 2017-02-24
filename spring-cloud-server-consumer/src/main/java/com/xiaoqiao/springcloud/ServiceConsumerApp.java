package com.xiaoqiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@Configuration
@EnableDiscoveryClient
public class ServiceConsumerApp 
{
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplage(){
		RestTemplate template = new RestTemplate();
		SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory)template.getRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		return template;
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceConsumerApp.class, args);
    }
}
