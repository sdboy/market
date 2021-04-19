package com.raysaber.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.raysaber.market.db1", "com.raysaber.market.db2"})
public class MarketApplication {

  public static void main(String[] args) {
    SpringApplication.run(MarketApplication.class, args);
  }

}
