package com.tenpen.base.service.product.impl;

import com.tenpen.base.dao.OrgCollectionRecordMapper;
import com.tenpen.base.dao.OrgProductsMapper;
import com.tenpen.base.domain.model.OrgProducts;
import com.tenpen.base.domain.model.OrgProductsExample;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.product.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by x00376013 on 2019/9/26.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    OrgProductsMapper orgProductsMapper;

    @Override
    public OrgProducts getProduct(String productId) {
        if (StringUtils.isBlank(productId)) {
            throw new ServiceException("productId is null!");
        }
        OrgProducts orgProduct = orgProductsMapper.selectByPrimaryKey(productId);
        if (orgProduct == null) {
            throw new ServiceException("product is null!");
        }
        return orgProduct;
    }
}
