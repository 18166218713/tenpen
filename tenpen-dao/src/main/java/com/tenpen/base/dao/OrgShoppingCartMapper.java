package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgShoppingCart;
import com.tenpen.base.domain.model.OrgShoppingCartExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrgShoppingCartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int countByExample(OrgShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int deleteByExample(OrgShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int insert(OrgShoppingCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int insertSelective(OrgShoppingCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    List<OrgShoppingCart> selectByExample(OrgShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    OrgShoppingCart selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgShoppingCart record, @Param("example") OrgShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int updateByExample(@Param("record") OrgShoppingCart record, @Param("example") OrgShoppingCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int updateByPrimaryKeySelective(OrgShoppingCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_shopping_cart
     *
     * @mbggenerated Mon Sep 30 14:54:37 CST 2019
     */
    int updateByPrimaryKey(OrgShoppingCart record);

    /**
     * 分页查询购物车数据
     *
     * @param queryMap 查询条件
     * @return 购物车明细
     */
    List<OrgShoppingCart> selectShoppingCartsByPage(Map<String, Object> queryMap);
}