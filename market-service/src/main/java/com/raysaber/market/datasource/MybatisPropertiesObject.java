package com.raysaber.market.datasource;

import org.apache.ibatis.session.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class MybatisPropertiesObject
 * @date 2021/4/16 18:50
 * @Copyright
 */
@Component
@ConfigurationProperties(prefix = MybatisPropertiesObject.MYBATIS_PREFIX)
public class MybatisPropertiesObject {
  public static final String MYBATIS_PREFIX = "mybatis";
  private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

  /**
   * Location of MyBatis xml config file.
   */
  private String configLocation;

  /**
   * Locations of MyBatis mapper files.
   */
  private String[] mapperLocations;

  /**
   * Packages to search type aliases. (Package delimiters are ",; \t\n")
   */
  private String typeAliasesPackage;

  private Properties configurationProperties;

  @NestedConfigurationProperty
  private Configuration configuration;

  public static ResourcePatternResolver getResourceResolver() {
    return resourceResolver;
  }

  public String getConfigLocation() {
    return configLocation;
  }

  public void setConfigLocation(String configLocation) {
    this.configLocation = configLocation;
  }

  public String[] getMapperLocations() {
    return mapperLocations;
  }

  public void setMapperLocations(String[] mapperLocations) {
    this.mapperLocations = mapperLocations;
  }

  public String getTypeAliasesPackage() {
    return typeAliasesPackage;
  }

  public void setTypeAliasesPackage(String typeAliasesPackage) {
    this.typeAliasesPackage = typeAliasesPackage;
  }

  public Properties getConfigurationProperties() {
    return configurationProperties;
  }

  public void setConfigurationProperties(Properties configurationProperties) {
    this.configurationProperties = configurationProperties;
  }

  public Configuration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }

  public Resource[] resolveMapperLocations() {
    return Stream.of(Optional.ofNullable(this.mapperLocations).orElse(new String[0]))
        .flatMap(location -> Stream.of(getResources(location))).toArray(Resource[]::new);
  }

  private Resource[] getResources(String location) {
    try {
      return resourceResolver.getResources(location);
    } catch (IOException e) {
      return new Resource[0];
    }
  }
}
