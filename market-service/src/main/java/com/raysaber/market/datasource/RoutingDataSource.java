package com.raysaber.market.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class RoutingDataSource
 * @date 2021/4/16 4:49
 * @Copyright
 */
@Component
public class RoutingDataSource extends AbstractRoutingDataSource {

  public static void setDataSourceKey(String dataSource) {
    DataSourceHolder.setDataSourceType(dataSource);
  }

  @Override
  protected Object determineCurrentLookupKey() {
    return DataSourceHolder.getDataSourceType();
  }

  public static void clear(){
    DataSourceHolder.clearDataSourceType();
  }

}
