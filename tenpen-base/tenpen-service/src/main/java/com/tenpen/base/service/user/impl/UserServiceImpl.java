package com.tenpen.base.service.user.impl;

import com.tenpen.base.dao.OrgModifyPasswordMapper;
import com.tenpen.base.dao.OrgUsersAddressMapper;
import com.tenpen.base.dao.OrgUsersLoginMapper;
import com.tenpen.base.dao.OrgUsersMapper;
import com.tenpen.base.domain.model.*;
import com.tenpen.base.enums.DeleteFlagEnum;
import com.tenpen.base.enums.LoginTypeEnum;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.redis.RedisClient;
import com.tenpen.base.service.user.UserService;
import com.tenpen.base.service.user.handler.AccountLoginHandler;
import com.tenpen.base.service.user.handler.AliplayLoginHandler;
import com.tenpen.base.service.user.handler.MobileLoginHandler;
import com.tenpen.base.service.user.handler.WechatLoginHandler;
import com.tenpen.base.sms.SmsClient;
import com.tenpen.base.util.EncryptUtil;
import com.tenpen.base.util.FastJsonUtils;
import com.tenpen.base.util.IdUtils;
import com.tenpen.base.util.ParamsUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by x00376013 on 2019/9/24.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    RedisClient redisClient;
    @Autowired
    SmsClient smsClient;
    @Autowired
    MobileLoginHandler mobileLoginHandler;
    @Autowired
    AliplayLoginHandler aliplayLoginHandler;
    @Autowired
    WechatLoginHandler wechatLoginHandler;
    @Autowired
    AccountLoginHandler accountLoginHandler;
    @Autowired
    OrgUsersMapper orgUsersMapper;
    @Autowired
    OrgUsersAddressMapper orgUsersAddressMapper;
    @Autowired
    OrgUsersLoginMapper orgUsersLoginMapper;

    @Autowired
    OrgModifyPasswordMapper orgModifyPasswordMapper;

    @Override
    @Transactional
    public void login(String params, String requestIp, String deviceOs, String deviceName) {

        ParamsUtils.checkParams(params);

        String type = (String) FastJsonUtils.getValueByKey(params, "type");
        logger.info("login type:{}", type);
        if (StringUtils.isBlank(type)) {
            throw new ServiceException("login type is null!");
        }
        String userAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        logger.info("login userAccount:{}", userAccount);
        if (StringUtils.isBlank(userAccount)) {
            throw new ServiceException("login account is null!");
        }
        if (!LoginTypeEnum.isContains(type)) {
            throw new ServiceException("Don't support login type!");
        }
        //手机号码注册登录
        if (StringUtils.equalsIgnoreCase(type, LoginTypeEnum.MOBILE.getType())) {
            mobileLoginHandler.login(params);
        }
        // 用户账号密码登录
        else if (StringUtils.equalsIgnoreCase(type, LoginTypeEnum.ACCOUNT.getType())) {
            accountLoginHandler.login(params);
        }
        //微信用户注册登录
        else if (StringUtils.equalsIgnoreCase(type, LoginTypeEnum.WECHAT.getType())) {
            wechatLoginHandler.login(params);
        }
        //支付宝用户注册登录
        else if (StringUtils.equalsIgnoreCase(type, LoginTypeEnum.ALIPLAY.getType())) {
            aliplayLoginHandler.login(params);
        }
        //插入登录记录信息
        OrgUsersLogin usersLogin = new OrgUsersLogin();
        usersLogin.setId(IdUtils.getId());
        usersLogin.setUserAccount(userAccount);
        usersLogin.setLoginType(type);
        usersLogin.setIp(requestIp);
        usersLogin.setOsType(deviceOs);
        usersLogin.setMobilePhone(deviceName);
        usersLogin.setStatus("1");//登录成功
        usersLogin.setLastUpdateTime(new Date());
        usersLogin.setLastUpdator(userAccount);
        usersLogin.setLastUpdateVersion(1);
        usersLogin.setCreateTime(new Date());
        usersLogin.setCreator(userAccount);
        usersLogin.setRemark("user login success!");
        orgUsersLoginMapper.insert(usersLogin);

    }

    @Override
    @Transactional
    public void modifyPassword(String params) {
        ParamsUtils.checkParams(params);
        String userAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        if (StringUtils.isBlank(userAccount)) {
            throw new ServiceException("userAccount is null!");
        }

        String oldPassword = (String) FastJsonUtils.getValueByKey(params, "oldPassword");
        if (StringUtils.isBlank(oldPassword)) {
            throw new ServiceException("oldPassword is null!");
        }

        String newPassword = (String) FastJsonUtils.getValueByKey(params, "newPassword");
        if (StringUtils.isBlank(newPassword)) {
            throw new ServiceException("newPassword is null!");
        }

        OrgUsersExample orgUsersExample = new OrgUsersExample();
        orgUsersExample.createCriteria().andUserAccountEqualTo(userAccount).andDeleteFlagEqualTo(DeleteFlagEnum.NO.getKey());
        List<OrgUsers> orgUsersList = orgUsersMapper.selectByExample(orgUsersExample);
        if (CollectionUtils.isEmpty(orgUsersList)) {
            throw new ServiceException("user data is not exist!");
        }
        OrgUsers user = orgUsersList.get(0);
        boolean result = EncryptUtil.isEqual(oldPassword, user.getUserPassword());
        if (!result) {
            throw new ServiceException("Invalid original password!");
        }
        if (StringUtils.equalsIgnoreCase(oldPassword, newPassword)) {
            throw new ServiceException("The original password is the same as the new password");
        }

        OrgUsers newUser = new OrgUsers();
        newUser.setId(user.getId());
        String salt = EncryptUtil.randomSalt();
        newUser.setUserPassword(EncryptUtil.generate(newPassword, salt));
        newUser.setLastUpdateTime(new Date());
        newUser.setLastUpdateVersion(user.getLastUpdateVersion() + 1);
        orgUsersExample.clear();
        orgUsersExample.createCriteria().andIdEqualTo(user.getId()).andLastUpdateVersionEqualTo(user.getLastUpdateVersion());
        orgUsersMapper.updateByExampleSelective(newUser, orgUsersExample);

        //保存修改密码记录
        OrgModifyPassword password = new OrgModifyPassword();
        password.setId(IdUtils.getId());
        password.setLastUpdateVersion(1);
        password.setLastUpdateTime(new Date());
        password.setCreateTime(new Date());
        password.setCreator(userAccount);
        password.setUserId(user.getId());
        password.setNewPassword(newUser.getUserPassword());
        password.setOldPassword(user.getUserPassword());
        password.setStatus("1");
        password.setRemark("user modify password success!");
        orgModifyPasswordMapper.insert(password);
    }

    @Override
    @Transactional
    public void modifyPhoneNo(String params) {
        ParamsUtils.checkParams(params);
        String loginUserId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(loginUserId)) {
            throw new ServiceException("loginUserId is null!");
        }
        String userAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        if (StringUtils.isBlank(userAccount)) {
            throw new ServiceException("userAccount is null!");
        }
        String telephoneNo = (String) FastJsonUtils.getValueByKey(params, "telephoneNo");
        if (StringUtils.isBlank(telephoneNo)) {
            throw new ServiceException("telephoneNo is null!");
        }
        String verCode = (String) FastJsonUtils.getValueByKey(params, "verCode");
        if (StringUtils.isBlank(verCode)) {
            throw new ServiceException("verCode is null!");
        }
        //验证验证码是否已经过期
        String code = (String) redisClient.get(telephoneNo);
        if (StringUtils.isBlank(code)) {
            throw new ServiceException("The verification code has expired. Please retrieve it!");
        }
        //验证验证是否有效
        if (!StringUtils.equalsIgnoreCase(verCode, code)) {
            logger.error("Invalid Verification Code!requestCode:{},serverCode:{}", verCode, code);
            throw new ServiceException("Invalid Verification Code!");
        }

        OrgUsers user = orgUsersMapper.selectByPrimaryKey(loginUserId);
        if (user == null) {
            throw new ServiceException("User data is not exist!");
        }
        //无需判断用户类型，所有用户都支持修改手机号
        OrgUsers newUser = new OrgUsers();
        newUser.setId(user.getId());
        newUser.setTelephoneNo(telephoneNo);
        newUser.setLastUpdateVersion(user.getLastUpdateVersion() + 1);
        newUser.setLastUpdator(user.getUserAccount());
        newUser.setLastUpdateTime(new Date());
        OrgUsersExample usersExample = new OrgUsersExample();
        usersExample.createCriteria().andIdEqualTo(user.getId()).andLastUpdateVersionEqualTo(user.getLastUpdateVersion());
        orgUsersMapper.updateByExampleSelective(newUser, usersExample);

    }

    @Override
    @Transactional
    public void addRecAddress(String params) {
        ParamsUtils.checkParams(params);
        String loginUserId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(loginUserId)) {
            throw new ServiceException("loginUserId is null!");
        }
        String loginUserAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        if (StringUtils.isBlank(loginUserAccount)) {
            throw new ServiceException("loginUserAccount is null!");
        }
        String userName = (String) FastJsonUtils.getValueByKey(params, "userName");
        if (StringUtils.isBlank(userName)) {
            throw new ServiceException("userName is null!");
        }
        String telephoneNo = (String) FastJsonUtils.getValueByKey(params, "telephoneNo");
        if (StringUtils.isBlank(telephoneNo)) {
            throw new ServiceException("telephoneNo is null!");
        }
        String address = (String) FastJsonUtils.getValueByKey(params, "address");
        if (StringUtils.isBlank(address)) {
            throw new ServiceException("address is null!");
        }
        //验证登录用户是否存在
        OrgUsersExample usersExample = new OrgUsersExample();
        usersExample.createCriteria().andIdEqualTo(loginUserId).andDeleteFlagEqualTo(DeleteFlagEnum.NO.getKey());
        List<OrgUsers> usersList = orgUsersMapper.selectByExample(usersExample);
        if (CollectionUtils.isEmpty(usersList)) {
            logger.error("User does not exist!id:{},account:{}", loginUserId, loginUserAccount);
            throw new ServiceException("User does not exist!");
        }
        OrgUsers user = usersList.get(0);

        OrgUsersAddress usersAddress = new OrgUsersAddress();
        usersAddress.setId(IdUtils.getId());
        usersAddress.setUserId(user.getId());
        usersAddress.setUserAccount(user.getUserAccount());
        usersAddress.setCreateTime(new Date());
        usersAddress.setLastUpdateVersion(1);
        usersAddress.setLastUpdateTime(new Date());
        usersAddress.setCreator(user.getUserAccount());
        usersAddress.setIsDefualt("N");
        usersAddress.setLastUpdator(user.getUserAccount());
        usersAddress.setRecAddress(address);
        usersAddress.setRecName(userName);
        usersAddress.setTelNo(telephoneNo);
        usersAddress.setRemark("add rec address success!");
        orgUsersAddressMapper.insert(usersAddress);
    }

    @Override
    @Transactional
    public void modifyRecAdress(String params) {

        ParamsUtils.checkParams(params);
        String addressId = (String) FastJsonUtils.getValueByKey(params, "id");
        if (StringUtils.isBlank(addressId)) {
            throw new ServiceException("addressId is null!");
        }
        String userName = (String) FastJsonUtils.getValueByKey(params, "userName");
        if (StringUtils.isBlank(userName)) {
            throw new ServiceException("userName is null!");
        }
        String telephoneNo = (String) FastJsonUtils.getValueByKey(params, "telephoneNo");
        if (StringUtils.isBlank(telephoneNo)) {
            throw new ServiceException("telephoneNo is null!");
        }
        String address = (String) FastJsonUtils.getValueByKey(params, "address");
        if (StringUtils.isBlank(address)) {
            throw new ServiceException("address is null!");
        }

        OrgUsersAddressExample addressExample = new OrgUsersAddressExample();
        OrgUsersAddress usersAddress = orgUsersAddressMapper.selectByPrimaryKey(addressId);
        if (usersAddress == null) {
            throw new ServiceException("user address data is null!");
        }
        OrgUsersAddress newAddress = new OrgUsersAddress();
        newAddress.setTelNo(telephoneNo);
        newAddress.setRecAddress(address);
        newAddress.setRecName(userName);
        newAddress.setLastUpdator(usersAddress.getUserAccount());
        newAddress.setLastUpdateVersion(usersAddress.getLastUpdateVersion() + 1);
        newAddress.setLastUpdateTime(new Date());
        addressExample.clear();
        addressExample.createCriteria().andIdEqualTo(address).andLastUpdateVersionEqualTo(usersAddress.getLastUpdateVersion());
        orgUsersAddressMapper.updateByExample(newAddress, addressExample);
    }

    @Override
    @Transactional
    public void delRecAddress(String params) {
        ParamsUtils.checkParams(params);
        String addressId = (String) FastJsonUtils.getValueByKey(params, "id");
        if (StringUtils.isBlank(addressId)) {
            throw new ServiceException("addressId is null!");
        }
        orgUsersAddressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public List getRecAddress(String params) {
        ParamsUtils.checkParams(params);
        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        OrgUsersAddressExample addressExample = new OrgUsersAddressExample();
        addressExample.createCriteria().andUserIdEqualTo(userId);
        List<OrgUsersAddress> orgUsersAddressList = orgUsersAddressMapper.selectByExample(addressExample);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (OrgUsersAddress address : orgUsersAddressList) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("addressId", address.getId());
            resultMap.put("userName", address.getRecName());
            resultMap.put("telephoneNo", address.getTelNo());
            resultMap.put("recAddress", address.getRecAddress());
            resultMap.put("isDefualt", address.getIsDefualt());
            resultList.add(resultMap);
        }
        return resultList;
    }

    @Override
    @Transactional
    public void setDefualtAdress(String params) {
        ParamsUtils.checkParams(params);
        String addressId = (String) FastJsonUtils.getValueByKey(params, "id");
        if (StringUtils.isBlank(addressId)) {
            throw new ServiceException("addressId is null!");
        }
        //判断是否已经存在默认地址了 如果存在则更新为非默认地址
        OrgUsersAddressExample addressExample = new OrgUsersAddressExample();
        addressExample.createCriteria().andIsDefualtEqualTo("Y");
        List<OrgUsersAddress> orgUsersAddresses = orgUsersAddressMapper.selectByExample(addressExample);
        if (!CollectionUtils.isEmpty(orgUsersAddresses)) {
            OrgUsersAddress defualtAddress = orgUsersAddresses.get(0);
            OrgUsersAddress newAddress = new OrgUsersAddress();
            newAddress.setIsDefualt("N");
            newAddress.setId(defualtAddress.getId());
            newAddress.setLastUpdateTime(new Date());
            newAddress.setLastUpdateVersion(defualtAddress.getLastUpdateVersion() + 1);
            newAddress.setLastUpdator(defualtAddress.getUserAccount());
            addressExample.clear();
            addressExample.createCriteria().andIdEqualTo(addressId).andLastUpdateVersionEqualTo(defualtAddress.getLastUpdateVersion());
            orgUsersAddressMapper.updateByExampleSelective(newAddress, addressExample);
        }

        OrgUsersAddress orgUsersAddress = orgUsersAddressMapper.selectByPrimaryKey(addressId);
        if (orgUsersAddress == null) {
            throw new ServiceException("user address data is null!");
        }

        OrgUsersAddress newAddress = new OrgUsersAddress();
        newAddress.setId(orgUsersAddress.getId());
        newAddress.setIsDefualt("Y");
        newAddress.setLastUpdateTime(new Date());
        newAddress.setLastUpdateVersion(orgUsersAddress.getLastUpdateVersion() + 1);
        newAddress.setLastUpdator(orgUsersAddress.getUserAccount());
        addressExample.clear();
        addressExample.createCriteria().andIdEqualTo(addressId).andLastUpdateVersionEqualTo(orgUsersAddress.getLastUpdateVersion());
        orgUsersAddressMapper.updateByExampleSelective(newAddress, addressExample);
    }

    @Override
    public Map<String, Object> getVerifyCode(String params) {
        ParamsUtils.checkParams(params);
        String phoneNo = (String) FastJsonUtils.getValueByKey(params, "telephoneNo");
        ParamsUtils.isMobileNo(phoneNo);
        String verifyCode = ParamsUtils.getRandom();
        smsClient.sendSms(phoneNo, verifyCode);
        redisClient.sSetAndTime(phoneNo, 60, verifyCode);
        Map<String, Object> map = new HashMap<>();
        map.put("code", verifyCode);
        return map;
    }

    @Override
    @Transactional
    public void setUserName(String params) {

        ParamsUtils.checkParams(params);
        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        String userName = (String) FastJsonUtils.getValueByKey(params, "userName");
        if (StringUtils.isBlank(userName)) {
            throw new ServiceException("userName is null!");
        }

        OrgUsers users = orgUsersMapper.selectByPrimaryKey(userId);
        if (users == null) {
            throw new ServiceException("user data is not exist!");
        }
        OrgUsers newUser = new OrgUsers();
        newUser.setId(userId);
        newUser.setUserName(userName);
        newUser.setLastUpdateTime(new Date());
        newUser.setLastUpdateVersion(users.getLastUpdateVersion() + 1);
        newUser.setRemark("modify userName is success!");

        OrgUsersExample usersExample = new OrgUsersExample();
        usersExample.createCriteria().andIdEqualTo(users.getId()).andLastUpdateVersionEqualTo(users.getLastUpdateVersion());
        orgUsersMapper.updateByExampleSelective(newUser, usersExample);
    }

    @Override
    @Transactional
    public void setUserPassword(String params) {

        ParamsUtils.checkParams(params);

        String phoneNo = (String) FastJsonUtils.getValueByKey(params, "phoneNo");
        if (StringUtils.isBlank(phoneNo)) {
            throw new ServiceException("phoneNo is null!");
        }
        String password = (String) FastJsonUtils.getValueByKey(params, "password");
        if (StringUtils.isBlank(password)) {
            throw new ServiceException("password is null!");
        }
        String verCode = (String) FastJsonUtils.getValueByKey(params, "verCode");
        if (StringUtils.isBlank(verCode)) {
            throw new ServiceException("verCode is null!");
        }
        //首先要验证当前手机号码对应的账户是否存在，如果存在则只更新密码
        OrgUsersExample orgUsersExample = new OrgUsersExample();
        orgUsersExample.createCriteria().andUserAccountEqualTo(phoneNo);
        List<OrgUsers> orgUsersList = orgUsersMapper.selectByExample(orgUsersExample);
        if (CollectionUtils.isEmpty(orgUsersList)) {
            throw new ServiceException("user data is not exist!");
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

        OrgUsers user = orgUsersList.get(0);
        OrgUsers newUser = new OrgUsers();
        newUser.setId(user.getId());
        String salt = EncryptUtil.randomSalt();
        newUser.setUserPassword(EncryptUtil.generate(password, salt));
        newUser.setLastUpdateVersion(user.getLastUpdateVersion() + 1);
        newUser.setLastUpdateTime(new Date());
        orgUsersExample.clear();
        orgUsersExample.createCriteria().andIdEqualTo(user.getId()).andLastUpdateVersionEqualTo(user.getLastUpdateVersion());
        orgUsersMapper.updateByExampleSelective(newUser, orgUsersExample);
    }
}
