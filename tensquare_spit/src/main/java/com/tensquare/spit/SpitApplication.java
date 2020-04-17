package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/*
 * @Description: SpitApplication
 * @Author: Mr. Jf
 * @Time: 2020/4/11 15:19
 */

@SpringBootApplication
public class SpitApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpitApplication.class);
  }
  
  @Bean
  public IdWorker idWorker() {
    return new IdWorker(1, 1);
  }
}
