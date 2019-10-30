package com.tenpen.base.service.incomes;

import java.util.List;
import java.util.Map;

/**
 * Created by x00376013 on 2019/9/26.
 */
public interface IncomeService {

    /**
     * 分页查询收益记录
     *
     * @param userId      用户ID
     * @param incomesType 收益类型 1 商品收益 2 自拍收益
     * @param offset      开始位置
     * @param limit       总数
     * @return
     */
    List getIncomes(String userId, String incomesType, int offset, int limit);

    /**
     * 获取用户个人的收益
     *
     * @param userId 用户ID
     * @return
     */
    Map<String, Object> getMyIncomes(String userId);

    /**
     * 分页查询提现收益记录
     *
     * @param userId 用户ID
     * @param offset 开始位置
     * @param limit
     * @return
     */
    List getWithdraws(String userId, int offset, int limit);
}
