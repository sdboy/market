package com.raysaber.market.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class PropertiesUtil
 * @date 2021/4/16 3:24
 * @Copyright
 */
public class PropertiesUtil {
  private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
  private static Properties properties;
  private final static String FILE_NAME = "datasource.properties";
  private final static String CHARSET_NAME = "UTF-8";
  static {
    properties = new Properties();
    try {
      properties.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(FILE_NAME),
          CHARSET_NAME));
    } catch (IOException e) {
      logger.error("配置文件读取异常", e);
    }
  }

  public static String getPorperty(String key) {
    String value = properties.getProperty(key.trim());
    if(StringUtils.isBlank(value)) {
      return null;
    }
    return value.trim();
  }

  public static String getPorperty(String key, String defaultValue) {
    String value = properties.getProperty(key.trim());
    if(StringUtils.isBlank(value)) {
      value = defaultValue;
    }
    return value.trim();
  }
}
