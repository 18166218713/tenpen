package com.tenpen.base.service.bookmarks.impl;

import com.tenpen.base.dao.OrgCollectionRecordMapper;
import com.tenpen.base.domain.model.OrgCollectionRecord;
import com.tenpen.base.domain.model.OrgCollectionRecordExample;
import com.tenpen.base.domain.model.OrgProducts;
import com.tenpen.base.enums.CollectionTypeEnum;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.bookmarks.BookmarkService;
import com.tenpen.base.service.bookmarks.handler.PhotoCollectionHandler;
import com.tenpen.base.service.bookmarks.handler.ProductCollectionHandler;
import com.tenpen.base.service.product.ProductService;
import com.tenpen.base.util.FastJsonUtils;
import com.tenpen.base.util.ParamsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by x00376013 on 2019/9/26.
 */
@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    OrgCollectionRecordMapper orgCollectionRecordMapper;
    @Autowired
    ProductService productService;
    @Autowired
    ProductCollectionHandler productCollectionHandler;
    @Autowired
    PhotoCollectionHandler photoCollectionHandler;

    @Override
    public List getBookmarks(String userId, String type, int offset, int limit) {
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        if (StringUtils.isBlank(type)) {
            throw new ServiceException("type is null!");
        }
        OrgCollectionRecordExample collectionRecordExample = new OrgCollectionRecordExample();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userId", userId);
        queryMap.put("type", type);
        queryMap.put("offset", offset);
        queryMap.put("limit", limit);
        List<OrgCollectionRecord> collectionRecordList = orgCollectionRecordMapper.selectBookmarksByPage(queryMap);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (OrgCollectionRecord collectionRecord : collectionRecordList) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("businessId", collectionRecord.getBusinessId());
            dataMap.put("businessName", collectionRecord.getBusinessName());
            dataMap.put("type", collectionRecord.getType());
            //todo 暂时这么实现着，不合理
            if (StringUtils.equalsIgnoreCase(collectionRecord.getType(), CollectionTypeEnum.PRODUCT.getKey())) {
                OrgProducts product = productService.getProduct(collectionRecord.getBusinessId());
                dataMap.put("price", product.getPrice());
            }
            collectionRecordExample.clear();
            collectionRecordExample.createCriteria().andBusinessIdEqualTo(collectionRecord.getBusinessId());
            int count = orgCollectionRecordMapper.countByExample(collectionRecordExample);
            dataMap.put("count", count);
            dataMap.put("collectionTime", collectionRecord.getCollectionTime());
            resultList.add(dataMap);
        }
        return resultList;
    }

    @Override
    public void addBookmarks(String params) {

        ParamsUtils.checkParams(params);

        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        String userAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        if (StringUtils.isBlank(userAccount)) {
            throw new ServiceException("userAccount is null!");
        }
        String businessId = (String) FastJsonUtils.getValueByKey(params, "businessId");
        if (StringUtils.isBlank(businessId)) {
            throw new ServiceException("businessId is null!");
        }
        String type = (String) FastJsonUtils.getValueByKey(params, "type");
        if (StringUtils.isBlank(type)) {
            throw new ServiceException("type is null!");
        }
        if (StringUtils.equalsIgnoreCase(type, CollectionTypeEnum.PRODUCT.getKey())) {
            productCollectionHandler.addBookmarks(params);
        } else if (StringUtils.equalsIgnoreCase(type, CollectionTypeEnum.PHOTO.getKey())) {
            photoCollectionHandler.addBookmarks(params);
        }
    }

    @Override
    public void cancelBookmarks(String params) {
        ParamsUtils.checkParams(params);

        String bookmarksId = (String) FastJsonUtils.getValueByKey(params, "bookmarksId");
        if (StringUtils.isBlank(bookmarksId)) {
            throw new ServiceException("bookmarksId is null!");
        }
        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }

        String type = (String) FastJsonUtils.getValueByKey(params, "type");
        if (StringUtils.isBlank(type)) {
            throw new ServiceException("type is null!");
        }

        OrgCollectionRecordExample collectionRecordExample = new OrgCollectionRecordExample();
        collectionRecordExample.createCriteria().andUserIdEqualTo(userId).andIdEqualTo(bookmarksId).andTypeEqualTo(type);
        int num = orgCollectionRecordMapper.deleteByExample(collectionRecordExample);
        if (num != 1) {
            throw new ServiceException("delete collection data is error!");
        }
    }
}
