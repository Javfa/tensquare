package com.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.IdWorker;

/*
 * @Description: SearchApplication
 * @Author: Mr. Jf
 * @Time: 2020/4/12 15:17
 */
@SpringBootApplication
public class SearchApplication {
  public static void main(String[] args) {
    SpringApplication.run(SearchApplication.class);
  }
  
  public IdWorker idWorkker() {
    return new IdWorker(1, 1);
  }
}
