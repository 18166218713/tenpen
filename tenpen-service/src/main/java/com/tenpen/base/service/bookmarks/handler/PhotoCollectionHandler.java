package com.tenpen.base.service.bookmarks.handler;

import com.tenpen.base.dao.OrgCollectionRecordMapper;
import com.tenpen.base.dao.OrgPhotosMapper;
import com.tenpen.base.domain.model.OrgCollectionRecord;
import com.tenpen.base.domain.model.OrgPhotos;
import com.tenpen.base.domain.model.OrgProducts;
import com.tenpen.base.util.FastJsonUtils;
import com.tenpen.base.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by x00376013 on 2019/9/26.
 */
@Component
public class PhotoCollectionHandler {
    @Autowired
    OrgCollectionRecordMapper orgCollectionRecordMapper;
    @Autowired
    OrgPhotosMapper orgPhotosMapper;

    /**
     * 添加自拍收藏
     *
     * @param params 入参
     */
    @Transactional
    public void addBookmarks(String params) {
        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        String userAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        String businessId = (String) FastJsonUtils.getValueByKey(params, "businessId");
        String type = (String) FastJsonUtils.getValueByKey(params, "type");
        OrgPhotos photo = orgPhotosMapper.selectByPrimaryKey(businessId);
        OrgCollectionRecord record = new OrgCollectionRecord();
        record.setId(IdUtils.getId());
        record.setBusinessId(businessId);
        record.setBusinessName(photo.getTitle());
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
