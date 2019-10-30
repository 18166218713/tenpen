package com.tenpen.base.service.member.impl;

import com.tenpen.base.dao.OrgMemberRecordMapper;
import com.tenpen.base.dao.OrgUsersMapper;
import com.tenpen.base.domain.model.OrgMemberRecord;
import com.tenpen.base.domain.model.OrgMemberRecordExample;
import com.tenpen.base.domain.model.OrgUsers;
import com.tenpen.base.domain.model.OrgUsersExample;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.member.MemberService;
import com.tenpen.base.util.DateUtils;
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
public class MemberServiceImpl implements MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    OrgMemberRecordMapper orgMemberRecordMapper;
    @Autowired
    OrgUsersMapper orgUsersMapper;

    @Override
    public List getMemberRecords(String userId, int offset, int limit) {
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userId", userId);
        queryMap.put("offset", offset);
        queryMap.put("limit", limit);
        List<OrgMemberRecord> memberRecordList = orgMemberRecordMapper.selectListByPage(queryMap);
        List<Map<String, Object>> recordList = new ArrayList<>();
        for (OrgMemberRecord memberRecord : memberRecordList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", memberRecord.getId());
            map.put("rechargeType", memberRecord.getRechargeType());
            map.put("amount", memberRecord.getAmount());
            map.put("createTime", memberRecord.getCreateTime());
            recordList.add(map);
        }
        return recordList;
    }

    @Override
    public Map<String, Object> getMemberInfo(String userId) {
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        //查询当前用户信息
        OrgUsers user = orgUsersMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new ServiceException("user data is not exist!");
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("id", user.getId());
        resultMap.put("userName", user.getUserName());
        resultMap.put("userAccount", user.getUserAccount());
        if (!DateUtils.isEffective(user.getEndEffective())) {
            throw new ServiceException("Current user is not a member");
        }
        resultMap.put("isMember", "Y");
        resultMap.put("endEffective", user.getEndEffective());
        resultMap.put("startEffective", user.getStartEffective());
        return resultMap;
    }

    @Override
    public Map<String, Object> isMember(String userId) {
        Map<String, Object> resultMap = new HashMap<>();
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        //查询当前用户信息是否存在
        OrgUsers user = orgUsersMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new ServiceException("user data is not exist!");
        }
        resultMap.put("userId", user.getId());
        resultMap.put("userName", user.getLastUpdateVersion());
        resultMap.put("userId", user.getId());
        resultMap.put("userAccount", user.getUserAccount());

        OrgMemberRecordExample memberRecordExample = new OrgMemberRecordExample();
        memberRecordExample.createCriteria().andUserIdEqualTo(userId);
        memberRecordExample.setOrderByClause("create_time desc");
        List<OrgMemberRecord> orgMemberRecordList = orgMemberRecordMapper.selectByExample(memberRecordExample);
        if (CollectionUtils.isEmpty(orgMemberRecordList)) {
            resultMap.put("isMember", "N");
            return resultMap;
        }
        //只需要获取第一个角标的元素即可
        OrgMemberRecord memberRecord = orgMemberRecordList.get(0);
        //判断生效结束时间与当前时间是否一致
        if (DateUtils.isEffective(memberRecord.getEndEffective())) {
            resultMap.put("memberId", memberRecord.getId());
            resultMap.put("isMember", "Y");
            return resultMap;
        } else {
            resultMap.put("memberId", memberRecord.getId());
            resultMap.put("isMember", "N");
            return resultMap;
        }
    }
}
