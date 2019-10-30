package com.tenpen.base.service.incomes.impl;

import com.tenpen.base.dao.OrgUsersIncomesDetailMapper;
import com.tenpen.base.dao.OrgUsersIncomesMapper;
import com.tenpen.base.dao.OrgUsersIncomesWithdrawMapper;
import com.tenpen.base.domain.model.*;
import com.tenpen.base.enums.WithdrawStatusEnum;
import com.tenpen.base.enums.WithdrawTypeEnum;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.incomes.IncomeService;
import com.tenpen.base.service.member.impl.MemberServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by x00376013 on 2019/9/26.
 */
@Service
public class IncomeServiceImpl implements IncomeService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    OrgUsersIncomesDetailMapper orgUsersIncomesDetailMapper;
    @Autowired
    OrgUsersIncomesMapper orgUsersIncomesMapper;
    @Autowired
    OrgUsersIncomesWithdrawMapper orgUsersIncomesWithdrawMapper;

    @Override
    public List getIncomes(String userId, String incomesType, int offset, int limit) {
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userid is null!");
        }
        if (StringUtils.isBlank(incomesType)) {
            throw new ServiceException("incomesType is null!");
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userId", userId);
        queryMap.put("incomesType", incomesType);
        queryMap.put("offset", offset);
        queryMap.put("limit", limit);
        List<OrgUsersIncomesDetail> detailList = orgUsersIncomesDetailMapper.selectIncomesByPage(queryMap);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (OrgUsersIncomesDetail detail : detailList) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("businessId", detail.getBusinessId());
            dataMap.put("businessName", detail.getBusinessName());
            dataMap.put("incomesTime", detail.getIncomesTime());
            dataMap.put("incomesAmount", detail.getIncomesAmount());
            resultList.add(dataMap);
        }
        return resultList;
    }


    @Override
    public Map<String, Object> getMyIncomes(String userId) {
        Map<String, Object> resultMap = new HashMap<>();
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userid is null!");
        }
        OrgUsersIncomesExample incomesExample = new OrgUsersIncomesExample();
        incomesExample.createCriteria().andUserIdEqualTo(userId);
        List<OrgUsersIncomes> incomesList = orgUsersIncomesMapper.selectByExample(incomesExample);
        if (!CollectionUtils.isEmpty(incomesList)) {
            OrgUsersIncomes incomes = incomesList.get(0);
            resultMap.put("userId", incomes.getUserId());
            resultMap.put("totalAmount", incomes.getTotalAmount());
            resultMap.put("withdrawalAmount", incomes.getWithdrawalAmount());
            resultMap.put("balanceAmount", incomes.getBalanceAmount());
            resultMap.put("productAmount", incomes.getProductAmount());
            resultMap.put("photoAmount", incomes.getPhotoAmount());
        }
        return resultMap;
    }

    @Override
    public List getWithdraws(String userId, int offset, int limit) {
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userid is null!");
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userId", userId);
        queryMap.put("offset", offset);
        queryMap.put("limit", limit);

        List<OrgUsersIncomesWithdraw> withdrawList = orgUsersIncomesWithdrawMapper.selectWithdrawsByPage(queryMap);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (OrgUsersIncomesWithdraw withdraw : withdrawList) {
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("userId",withdraw.getUserId());
            dataMap.put("withdrawType", WithdrawTypeEnum.getValueByKey(withdraw.getWithdrawType()));
            dataMap.put("withdrawTime",withdraw.getWithdrawTime());
            dataMap.put("amount",withdraw.getAmount());
            dataMap.put("status", WithdrawStatusEnum.getValueByStatus(withdraw.getStatus()));
            resultList.add(dataMap);
        }
        return resultList;
    }
}
