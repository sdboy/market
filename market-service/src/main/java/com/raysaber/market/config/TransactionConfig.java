package com.raysaber.market.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.*;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局事务控制
 * @author jiaoguang
 * @version V1.0.0
 * @class TransactionConfig
 * @date 2021/4/19 17:04
 * @Copyright
 */
@Configuration
@Aspect
public class TransactionConfig {

  /**
   * 单位是 秒
   */
  private static final int TX_METHOD_TIMEOUT = 60;
  /**
   * 切点表达式
   */
  private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.raysaber.market.service.*(..))";
  /**
   * 执行优先级，默认是最低优先级，值越小优先级越高
   */
  private static final int ORDER = 2;

  @Bean(value = "transactionManager")
  public TransactionManager transactionManager(@Qualifier("routingDataSource") DataSource routingDataSource) {
    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(routingDataSource);
    dataSourceTransactionManager.setRollbackOnCommitFailure(true);
    return dataSourceTransactionManager;
  }

  @Bean(value = "txAdvice")
  public TransactionInterceptor transactionInterceptor(@Qualifier("transactionManager")
                                                           TransactionManager transactionManager) {
    NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
    // 非只读事务
    RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
    requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
    requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    // 只读事务
    RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
    readOnlyTx.setReadOnly(true);
    readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    // 配置加事务的规则,没有匹配到的方法将不会有事务，这些方法指的是Pointcut匹配到的方法
    Map<String, TransactionAttribute> map = new HashMap<>();
    map.put("add*", requiredTx);
    map.put("save*", requiredTx);
    map.put("insert*", requiredTx);
    map.put("update*", requiredTx);
    map.put("delete*", requiredTx);
    map.put("create*", requiredTx);
    map.put("init*", requiredTx);
    map.put("submit*", requiredTx);
    map.put("remove*", requiredTx);
    map.put("edit*", requiredTx);
    map.put("modify*", requiredTx);
    map.put("batch*", requiredTx);
    map.put("mass*", requiredTx);
    map.put("handle*", requiredTx);
    map.put("exec*", requiredTx);
    map.put("import*", requiredTx);
    map.put("set*", requiredTx);

    map.put("select*", readOnlyTx);
    map.put("get*", readOnlyTx);
    map.put("list*", readOnlyTx);
    map.put("query*", readOnlyTx);
    map.put("find*", readOnlyTx);
    map.put("count*", readOnlyTx);
    map.put("page*", readOnlyTx);
    map.put("*", readOnlyTx);
    source.setNameMap(map);
    return new TransactionInterceptor(transactionManager, source);
  }

  @Bean
  public Advisor txAdviceAdvisor(@Qualifier("txAdvice") TransactionInterceptor txAdvice) {
    DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
    advisor.setAdvice(txAdvice);
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
    advisor.setPointcut(pointcut);
    advisor.setOrder(ORDER);
    return advisor;
  }
}
