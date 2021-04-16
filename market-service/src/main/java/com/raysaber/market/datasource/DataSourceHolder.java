package com.raysaber.market.datasource;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class DataSourceHolder
 * @date 2021/4/16 4:46
 * @Copyright
 */
public class DataSourceHolder {
  private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();

  /**
   * 管理所有的数据源ID：主要是为了判断数据源是否存在
   */
  public static List<String> dataSourceIDS = new CopyOnWriteArrayList<>();

  public static void setDataSourceType(String dataSourceType) {
    CONTEXT_HOLDER.set(dataSourceType);
  }

  public static String getDataSourceType() {
    return CONTEXT_HOLDER.get();
  }

  public static void clearDataSourceType() {
    CONTEXT_HOLDER.remove();
  }

  /**
   * 判断指定的dataSource 是否存在
   * @param dataSourceID
   * @return
   */
  public static boolean containsDataSource(String dataSourceID){
    return dataSourceIDS.contains(dataSourceID);
  }

}
