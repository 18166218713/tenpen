package com.tenpen.base.service.user.handler;

import com.tenpen.base.dao.OrgUsersLoginMapper;
import com.tenpen.base.dao.OrgUsersMapper;
import com.tenpen.base.domain.model.OrgUsers;
import com.tenpen.base.domain.model.OrgUsersExample;
import com.tenpen.base.domain.model.OrgUsersLogin;
import com.tenpen.base.enums.DeleteFlagEnum;
import com.tenpen.base.enums.LoginTypeEnum;
import com.tenpen.base.enums.UserStatusEnum;
import com.tenpen.base.enums.UserTypeEnum;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.manager.user.UserManager;
import com.tenpen.base.redis.RedisClient;
import com.tenpen.base.service.user.impl.UserServiceImpl;
import com.tenpen.base.util.FastJsonUtils;
import com.tenpen.base.util.IdUtils;
import com.tenpen.base.util.ParamsUtils;
import com.tenpen.base.util.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 手机用户登录处理类
 * Created by x00376013 on 2019/9/25.
 */
@Component
public class MobileLoginHandler {

    private static final Logger logger = LoggerFactory.getLogger(MobileLoginHandler.class);

    @Autowired
    RedisClient redisClient;
    @Autowired
    OrgUsersMapper orgUsersMapper;

    @Transactional
    public void login(String params) {
        //短信验证码登录时，userAccount即是手机号码
        String phoneNo = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        ParamsUtils.isMobileNo(phoneNo);
        String verCode = (String) FastJsonUtils.getValueByKey(params, "verCode");
        if (StringUtils.isBlank(verCode)) {
            throw new ServiceException("verCode is null!");
        }
        //验证验证码是否已经过期
        String code = (String) redisClient.get(phoneNo);
        if (StringUtils.isBlank(code)) {
            throw new ServiceException("The verification code has expired. Please retrieve it!");
        }
        //验证验证是否有效
        if (!StringUtils.equalsIgnoreCase(verCode, code)) {
            logger.error("Invalid Verification Code!requestCode:{},serverCode:{}", verCode, code);
            throw new ServiceException("Invalid Verification Code!");
        }

        OrgUsersExample orgUsersExample = new OrgUsersExample();
        orgUsersExample.createCriteria().andUserAccountEqualTo(phoneNo).andDeleteFlagEqualTo(DeleteFlagEnum.NO.getKey());
        List<OrgUsers> usersList = orgUsersMapper.selectByExample(orgUsersExample);
        if (!CollectionUtils.isEmpty(usersList) && usersList.size() > 1) {
            logger.error("Invalid user data!userAccount:{}", phoneNo);
            throw new ServiceException("Invalid user data!");
        }
        if(CollectionUtils.isEmpty(usersList)){
            OrgUsers user = new OrgUsers();
            user.setId(IdUtils.getId());
            user.setUserAccount(phoneNo);//默认手机号
            user.setTelephoneNo(phoneNo);
            user.setLastUpdateVersion(1);
            user.setCreateTime(new Date());
            user.setCreator(phoneNo);
            user.setDeleteFlag(DeleteFlagEnum.NO.getKey());
            user.setLastUpdateTime(new Date());
            user.setLastUpdator(phoneNo);
            user.setRemark("user register success!");
            user.setSourceType(LoginTypeEnum.MOBILE.getType());//手机用户
            user.setUserType(UserTypeEnum.ORDINARY.getType());//普通会员
            user.setStatus(UserStatusEnum.NORMAL.getStatus());//正常用户
            user.setUserName(phoneNo);//默认手机号
            orgUsersMapper.insert(user);
        }
    }
}
