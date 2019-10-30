package com.tenpen.base.service.recommend.impl;

import com.tenpen.base.dao.OrgMemberRecordMapper;
import com.tenpen.base.dao.OrgRecommendsMapper;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.recommend.RecommendService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by x00376013 on 2019/9/24.
 */
@Service
public class RecommendServiceImpl implements RecommendService {

    private static final Logger logger = LoggerFactory.getLogger(RecommendServiceImpl.class);

    @Autowired
    OrgRecommendsMapper orgRecommendsMapper;

    @Override
    public Map<String, Object> getRecommends(String type) {

        if(StringUtils.isBlank(type)){
            throw new ServiceException("type is null!");
        }















        return null;
    }
}
