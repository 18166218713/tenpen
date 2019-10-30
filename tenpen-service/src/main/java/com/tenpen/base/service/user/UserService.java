package com.tenpen.base.service.user;

import java.util.List;
import java.util.Map;

/**
 * Created by x00376013 on 2019/9/24.
 */
public interface UserService {

    /**
     * 用户登录(包含注册)
     *
     * @param params 入参
     * @return 响应请求
     */
    void login(String params,String requestIp,String deviceOs,String deviceName);

    /**
     * 用户密码修改
     *
     * @param params 入参
     * @return 响应请求
     */
    void modifyPassword(String params);

    /**
     * 修改绑定手机
     *
     * @param params 入参
     * @return 响应请求
     */
    void modifyPhoneNo(String params);

    /**
     * 添加收货地址
     *
     * @param params 入参
     * @return 响应请求
     */
    void addRecAddress(String params);

    /**
     * 修改收货地址
     *
     * @param params 入参
     * @return 响应请求
     */
    void modifyRecAdress(String params);

    /**
     * 删除收货地址
     *
     * @param params 入参
     * @return 响应请求
     */
    void delRecAddress(String params);

    /**
     * 查询收货地址列表
     *
     * @param params 入参
     * @return 响应请求
     */
    List getRecAddress(String params);

    /**
     * 设置默认地址
     *
     * @param params 入参
     * @return 响应请求
     */
    void setDefualtAdress(String params);

    /**
     * 获取短信验证码
     *
     * @param params telephoneNo手机号码
     * @return 响应参数
     */
    Map<String, Object> getVerifyCode(String params);

    /**
     * 设置昵称
     *
     * @param params 入参
     */
    void setUserName(String params);

    /**
     * 设置密码(忘记密码)
     *
     * @param params 入参
     */
    void setUserPassword(String params);
}
