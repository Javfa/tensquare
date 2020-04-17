package com.tensquare.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
 * @Description: ConfigApplication
 * @Author: Mr. Jf
 * @Time: 2020/4/16 15:07
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigApplication.class);
  }
}
