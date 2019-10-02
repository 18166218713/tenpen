package com.tenpen.base.manager.user.impl;

import com.tenpen.base.dao.OrgUsersMapper;
import com.tenpen.base.manager.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户管理
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    OrgUsersMapper orgUsersMapper;

    @Override
    public String login(String params) {
        int num = orgUsersMapper.insert(null);
        return "success";
    }

    @Override
    public String modifyPassword(String params) {
        return null;
    }

    @Override
    public String modifyPhoneNo(String params) {
        return null;
    }

    @Override
    public String addRecAddress(String params) {
        return null;
    }

    @Override
    public String modifyRecAdress(String params) {
        return null;
    }

    @Override
    public String delRecAddress(String params) {
        return null;
    }

    @Override
    public String getRecAddress(String params) {
        return null;
    }

    @Override
    public String setDefualtAdress(String params) {
        return null;
    }
}
