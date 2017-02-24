package com.xiaoqiao.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@RefreshScope
public class ProviderController {
	private static final String template = "ip:%s port:%s node:%s owner:%s developer:%s ";
	
	@Value("${eureka.client.01.owner:xxxx}")
	private String customer;
	
	@Value("${ip:0.0.0.0}")
	private String ip;
	
	@Value("${eureka_server_rest_port_01:xxxx}")
	private String rest_port;
	
	@Value("${node:x}")
	private String node;
	
	@Value("${owner:xxx}")
	private String owner;
	
	@Value("${developer:xxx}")
	private String develop;
	
    @Autowired
    private DiscoveryClient discoveryClient;
	
    @RequestMapping("/")
    public String indexPage(){
    	return "owner is:"+customer;
    }
    
	@RequestMapping("/home")
	public String home(){
		return "rest_port:"+rest_port;//String.format(template, ip,rest_port,node,owner,develop);
	}
	
	@RequestMapping("/discovery")
    public String doDiscoveryService(){
        StringBuilder buf = new StringBuilder();
        List<String> serviceIds = discoveryClient.getServices();
        if(!CollectionUtils.isEmpty(serviceIds)){
            for(String s : serviceIds){
                System.out.println("serviceId:" + s);
                List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
                if(!CollectionUtils.isEmpty(serviceInstances)){
                    for(ServiceInstance si:serviceInstances){
                        buf.append("["+si.getServiceId() +" host=" +si.getHost()+" rest_port="+si.getPort()+" uri="+si.getUri()+"]");
                    }
                }else{
                    buf.append("no service.");
                }
            }
        }
        return buf.toString();
    }
}
