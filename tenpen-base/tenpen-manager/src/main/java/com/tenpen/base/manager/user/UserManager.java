package com.tenpen.base.manager.user;

/**
 * Created by x00376013 on 2019/9/24.
 */
public interface UserManager {

    /**
     * 用户登录(注册)
     *
     * @param params 入参
     * @return 响应请求
     */
    String login(String params);

    /**
     * 用户密码修改
     *
     * @param params 入参
     * @return 响应请求
     */
    String modifyPassword(String params);

    /**
     * 修改绑定手机
     *
     * @param params 入参
     * @return 响应请求
     */
    String modifyPhoneNo(String params);

    /**
     * 添加收货地址
     *
     * @param params 入参
     * @return 响应请求
     */
    String addRecAddress(String params);

    /**
     * 修改收货地址
     *
     * @param params 入参
     * @return 响应请求
     */
    String modifyRecAdress(String params);

    /**
     * 删除收货地址
     *
     * @param params 入参
     * @return 响应请求
     */
    String delRecAddress(String params);

    /**
     * 查询收货地址列表
     *
     * @param params 入参
     * @return 响应请求
     */
    String getRecAddress(String params);

    /**
     * 设置默认地址
     *
     * @param params 入参
     * @return 响应请求
     */
    String setDefualtAdress(String params);
}
