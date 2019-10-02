package com.tenpen.base.service.cart;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/27.
 */
public interface CartService {
    /**
     * 分页查询购物车明细
     *
     * @param userId 用户ID
     * @param offset 开始位置
     * @param limit  总数
     * @return 购物车列表
     */
    List getShoppingCarts(String userId, int offset, int limit);

    /**
     * 添加商品到购物车
     *
     * @param params 入参
     */
    void addShoppingCart(String params);

    /**
     * 移除购物车的商品
     *
     * @param params 入参
     */
    void deleteProducts(String params);
}
