package com.tenpen.base.service.user.handler;

import com.tenpen.base.dao.OrgUsersMapper;
import com.tenpen.base.domain.model.OrgUsers;
import com.tenpen.base.domain.model.OrgUsersExample;
import com.tenpen.base.enums.DeleteFlagEnum;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.util.EncryptUtil;
import com.tenpen.base.util.FastJsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/26.
 */
@Component
public class AccountLoginHandler {

    private static final Logger logger = LoggerFactory.getLogger(AccountLoginHandler.class);

    @Autowired
    OrgUsersMapper orgUsersMapper;

    @Transactional
    public void login(String params) {
        String userAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        if (StringUtils.isBlank(userAccount)) {
            throw new ServiceException("userAccount is null!");
        }
        String userPassword = (String) FastJsonUtils.getValueByKey(params, "userPassword");
        if (StringUtils.isBlank(userPassword)) {
            throw new ServiceException("userPassword is null!");
        }
        //从表中读取密码
        OrgUsersExample orgUsersExample = new OrgUsersExample();
        orgUsersExample.createCriteria().andUserAccountEqualTo(userAccount).andDeleteFlagEqualTo(DeleteFlagEnum.NO.getKey());
        List<OrgUsers> usersList = orgUsersMapper.selectByExample(orgUsersExample);
        if (CollectionUtils.isEmpty(usersList)) {
            throw new ServiceException("user data is not exist!");
        }
        OrgUsers user = usersList.get(0);
        //判断密码是否一致
        boolean result = EncryptUtil.isEqual(userPassword, user.getUserPassword());
        if (!result) {
            throw new ServiceException("Invalid password!");
        }
    }
}
