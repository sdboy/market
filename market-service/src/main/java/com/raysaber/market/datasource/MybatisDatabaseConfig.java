package com.raysaber.market.datasource;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class MybatisDatabaseConfig
 * @date 2021/4/16 4:30
 * @Copyright
 */
@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(MybatisPropertiesObject.class)
//@MapperScan(basePackages = "com.raysaber.market.dao", sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisDatabaseConfig {

  private final MybatisPropertiesObject mybatisPropertiesObject;
  private final ResourceLoader resourceLoader;
  public MybatisDatabaseConfig(MybatisPropertiesObject mybatisPropertiesObject, ResourceLoader resourceLoader) {
    this.mybatisPropertiesObject = mybatisPropertiesObject;
    this.resourceLoader = resourceLoader;
  }

  @Bean(value = "sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory(@Qualifier("routingDataSource") DataSource routingDataSource)
      throws Exception  {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setTypeAliasesPackage(mybatisPropertiesObject.getTypeAliasesPackage());
    if(StringUtils.hasText(mybatisPropertiesObject.getConfigLocation())) {
      sqlSessionFactoryBean.setConfigLocation(resourceLoader.getResource(mybatisPropertiesObject.getConfigLocation()));
    }
    applyConfiguration(sqlSessionFactoryBean);
    if (StringUtils.hasLength(mybatisPropertiesObject.getTypeAliasesPackage())) {
      sqlSessionFactoryBean.setTypeAliasesPackage(mybatisPropertiesObject.getTypeAliasesPackage());
    }
    sqlSessionFactoryBean.setDataSource(routingDataSource);
    if (!ObjectUtils.isEmpty(mybatisPropertiesObject.resolveMapperLocations())) {
      sqlSessionFactoryBean.setMapperLocations(mybatisPropertiesObject.resolveMapperLocations());
    }
    return sqlSessionFactoryBean.getObject();
  }

  private void applyConfiguration(SqlSessionFactoryBean factory) {
    Configuration configuration = mybatisPropertiesObject.getConfiguration();
    if (configuration == null && !StringUtils.hasText(mybatisPropertiesObject.getConfigLocation())) {
      configuration = new Configuration();
    }
    factory.setConfiguration(configuration);
  }
}
