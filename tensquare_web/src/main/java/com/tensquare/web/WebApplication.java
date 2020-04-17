package com.tensquare.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
 * @Description: WebApplication
 * @Author: Mr. Jf
 * @Time: 2020/4/16 10:57
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class WebApplication {
  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class);
  }
}
