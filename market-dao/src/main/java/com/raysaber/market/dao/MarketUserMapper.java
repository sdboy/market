package com.raysaber.market.dao;

import com.raysaber.market.bean.MarketUser;

public interface MarketUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_USER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_USER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    int insert(MarketUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_USER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    int insertSelective(MarketUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_USER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    MarketUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_USER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    int updateByPrimaryKeySelective(MarketUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_USER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    int updateByPrimaryKey(MarketUser record);
}