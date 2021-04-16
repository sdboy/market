package com.raysaber.market.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class DataSourceConfig
 * @date 2021/4/16 2:45
 * @Copyright
 */
@Configuration
public class DataSourceConfig {
  private final static String DATASOURCE_ONE = "ds1";
  private final static String DATASOURCE_TWO = "ds2";

  @Bean(value = "druidDataSourceOne", initMethod = "init", destroyMethod = "close")
  @Scope(value = "singleton")
  @Qualifier
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
  public DruidDataSource druidDataSourceOne() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean(value = "druidDataSourceTwo", initMethod = "init", destroyMethod = "close")
  @Scope(value = "singleton")
  @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
  public DruidDataSource druidDataSourceTwo() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean(value = "routingDataSource")
  @Scope(value = "singleton")
  public RoutingDataSource routingDataSource(@Qualifier("druidDataSourceOne") DataSource druidDataSourceOne,
                                             @Qualifier("druidDataSourceTwo") DataSource druidDataSourceTwo) {
    RoutingDataSource routingDataSource = new RoutingDataSource();
    Map<Object, Object> druidDataSourceMap = new HashMap<>();
    druidDataSourceMap.put(DATASOURCE_ONE, druidDataSourceOne);
    druidDataSourceMap.put( DATASOURCE_TWO, druidDataSourceTwo);
    routingDataSource.setTargetDataSources(druidDataSourceMap);
    routingDataSource.setDefaultTargetDataSource(druidDataSourceOne);
    routingDataSource.afterPropertiesSet();
    return routingDataSource;
  }

}
