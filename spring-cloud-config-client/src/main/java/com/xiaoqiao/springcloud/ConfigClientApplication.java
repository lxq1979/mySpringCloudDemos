package com.xiaoqiao.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConfigClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
  }

  @Autowired
  void setEnviroment(Environment env) {
      System.out.println("name from foo.properties: "  + env.getProperty("name"));
  }
}
