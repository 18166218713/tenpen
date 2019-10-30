package com.tenpen.base.service.bookmarks.handler;

import com.tenpen.base.dao.OrgCollectionRecordMapper;
import com.tenpen.base.dao.OrgComplaintRecordMapper;
import com.tenpen.base.dao.OrgProductsMapper;
import com.tenpen.base.domain.model.OrgCollectionRecord;
import com.tenpen.base.domain.model.OrgProducts;
import com.tenpen.base.domain.model.OrgProductsExample;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.util.FastJsonUtils;
import com.tenpen.base.util.IdUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by x00376013 on 2019/9/26.
 */
@Component
public class ProductCollectionHandler {

    @Autowired
    OrgCollectionRecordMapper orgCollectionRecordMapper;
    @Autowired
    OrgProductsMapper orgProductsMapper;

    /**
     * 添加商品收藏
     *
     * @param params
     */
    @Transactional
    public void addBookmarks(String params) {
        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        String userAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        String businessId = (String) FastJsonUtils.getValueByKey(params, "businessId");
        String type = (String) FastJsonUtils.getValueByKey(params, "type");
        OrgProducts product = orgProductsMapper.selectByPrimaryKey(businessId);
        OrgCollectionRecord record = new OrgCollectionRecord();
        record.setId(IdUtils.getId());
        record.setBusinessId(businessId);
        record.setBusinessName(product.getTitle());
        record.setUserId(userId);
        record.setUserAccount(userAccount);
        record.setCreator(userAccount);
        record.setCollectionTime(new Date());
        record.setCreateTime(new Date());
        record.setType(type);
        record.setLastUpdateTime(new Date());
        record.setLastUpdateVersion(1);
        orgCollectionRecordMapper.insert(record);
    }

    @Transactional
    public void cancelBookmarks(String params) {

    }
}
