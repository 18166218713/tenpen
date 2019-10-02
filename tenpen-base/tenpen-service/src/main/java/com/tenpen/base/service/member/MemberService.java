package com.tenpen.base.service.member;

import java.util.List;
import java.util.Map;

/**
 * Created by x00376013 on 2019/9/26.
 */
public interface MemberService {

    /**
     * 分页获取会员交易记录
     *
     * @param userId 用户ID
     * @param offset 开始位置
     * @param limit  条数
     * @return 会员交易记录
     */
    List getMemberRecords(String userId, int offset, int limit);

    /**
     * 获取会员信息
     * 要判断了是否为会员之后才调用
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    Map<String, Object> getMemberInfo(String userId);

    /**
     * 是否判断为会员
     *
     * @param userId 用户ID
     * @return 返回信息
     */
    Map<String, Object> isMember(String userId);
}
