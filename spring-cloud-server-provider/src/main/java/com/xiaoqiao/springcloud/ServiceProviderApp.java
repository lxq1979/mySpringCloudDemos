package com.xiaoqiao.springcloud;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;




@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@EnableDiscoveryClient
public class ServiceProviderApp 
{
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(ServiceProviderApp.class).web(true).run(args);
    }
}
