package com.raysaber.market.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class DataSourceAspect
 * @date 2021/4/16 4:58
 * @Copyright
 */
@Order(1)
@Aspect
@Repository
public class DataSourceAspect {
  @Pointcut("execution(* com.raysaber.market.service.*.*(..))")
  private void anyMethod() {
  }

  @AfterReturning(value = "anyMethod()", returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result){
    DataSourceHolder.clearDataSourceType();
  }

  @Before(value="anyMethod()")
  public void before(JoinPoint joinPoint) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Method method = methodSignature.getMethod();
    //如果方法体上使用了DataSource注解
    if (method.isAnnotationPresent(TargetDataSource.class)) {
      //获取该方法上的注解名
      TargetDataSource datasource = method.getAnnotation(TargetDataSource.class);
      //将方法体上的注解的值赋予给DataSourceHolder数据源持有类
      DataSourceHolder.setDataSourceType(datasource.value());
    }
  }
}
