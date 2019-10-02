package com.tenpen.base.service.order;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/30.
 */
public interface OrderService {

    /**
     * 分页查询我的订单列表
     *
     * @param userId 用户ID
     * @param type   订单类型
     * @param offset 开始位置
     * @param limit  限制条数
     * @return 分页列表数据
     */
    List getOrders(String userId, String type, int offset, int limit);

    /**
     * 删除订单
     *
     * @param params 入参
     */
    void deleteOrder(String params);

    /**
     * 确认收货
     *
     * @param params 入参
     */
    void confirmOrder(String params);
}
