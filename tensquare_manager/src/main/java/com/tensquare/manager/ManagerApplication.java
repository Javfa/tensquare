package com.tensquare.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
 * @Description: ManagerApplication
 * @Author: Mr. Jf
 * @Time: 2020/4/16 10:22
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ManagerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ManagerApplication.class);
  }
}
