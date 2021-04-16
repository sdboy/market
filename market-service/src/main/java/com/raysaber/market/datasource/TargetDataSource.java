package com.raysaber.market.datasource;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class DataSource
 * @date 2021/4/16 5:02
 * @Copyright
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface TargetDataSource {
  String value() default "";
}
