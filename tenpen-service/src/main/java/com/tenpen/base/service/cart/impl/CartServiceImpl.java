package com.tenpen.base.service.cart.impl;

import com.tenpen.base.dao.OrgProductsMapper;
import com.tenpen.base.dao.OrgShoppingCartMapper;
import com.tenpen.base.domain.model.OrgProducts;
import com.tenpen.base.domain.model.OrgProductsExample;
import com.tenpen.base.domain.model.OrgShoppingCart;
import com.tenpen.base.domain.model.OrgShoppingCartExample;
import com.tenpen.base.enums.ProductStatusEnum;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.cart.CartService;
import com.tenpen.base.util.DateUtils;
import com.tenpen.base.util.FastJsonUtils;
import com.tenpen.base.util.IdUtils;
import com.tenpen.base.util.ParamsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by x00376013 on 2019/9/27.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    OrgShoppingCartMapper orgShoppingCartMapper;

    @Autowired
    OrgProductsMapper orgProductsMapper;

    @Override
    public List getShoppingCarts(String userId, int offset, int limit) {
        ParamsUtils.checkParams(userId);
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userId", userId);
        queryMap.put("offset", offset);
        queryMap.put("limit", limit);
        List<OrgShoppingCart> cartList = orgShoppingCartMapper.selectShoppingCartsByPage(queryMap);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (OrgShoppingCart shoppingCart : cartList) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("userId", shoppingCart.getUserId());
            dataMap.put("productsId", shoppingCart.getProductsId());
            dataMap.put("title", shoppingCart.getTitle());
            dataMap.put("price", shoppingCart.getPrice());
            //todo 图片暂未处理
            dataMap.put("imgeUrl", "");
            resultList.add(dataMap);
        }
        return resultList;
    }

    @Override
    @Transactional
    public void addShoppingCart(String params) {

        ParamsUtils.checkParams(params);

        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        String userAccount = (String) FastJsonUtils.getValueByKey(params, "userAccount");
        if (StringUtils.isBlank(userAccount)) {
            throw new ServiceException("userAccount is null!");
        }
        String productsId = (String) FastJsonUtils.getValueByKey(params, "productsId");
        if (StringUtils.isBlank(productsId)) {
            throw new ServiceException("productsId is null!");
        }
        //首先要查下该产品的状态
        OrgProductsExample productsExample = new OrgProductsExample();

        OrgProducts product = orgProductsMapper.selectByPrimaryKey(productsId);
        if (product == null) {
            throw new ServiceException("product data is error!");
        }
        //除了之后发布状态的商品能添加到购物车，其他的均不能添加到购物车
        if (!StringUtils.equalsIgnoreCase(product.getStatus(), ProductStatusEnum.PUBLISHED.getStatus())) {
            throw new ServiceException("current product can't add to shopping cart!");
        }

        //先将商品更新为锁定状态
        OrgProducts newProduct = new OrgProducts();
        newProduct.setId(product.getId());
        newProduct.setLastUpdateTime(new Date());
        newProduct.setStatus(ProductStatusEnum.LOCK.getStatus());
        Date startLockTime = new Date();
        newProduct.setLockStartTime(startLockTime);
        Date lockEndTime = DateUtils.getSpecifiedTime(5);//锁定时间5分钟
        newProduct.setLockEndTime(lockEndTime);
        newProduct.setRemark("add shopping cart by " + userAccount);
        newProduct.setLastUpdateVersion(product.getLastUpdateVersion() + 1);
        productsExample.clear();
        productsExample.createCriteria().andIdEqualTo(productsId).andLastUpdateVersionEqualTo(product.getLastUpdateVersion());
        orgProductsMapper.updateByExampleSelective(newProduct, productsExample);

        //插入商品数据到购物车里面
        OrgShoppingCart shoppingCart = new OrgShoppingCart();
        shoppingCart.setId(IdUtils.getId());
        shoppingCart.setProductsId(productsId);
        shoppingCart.setPrice(product.getPrice());
        shoppingCart.setUserAccount(userAccount);
        shoppingCart.setUserId(userId);
        shoppingCart.setSupplerId(product.getCreateBy());
        shoppingCart.setSupplerAccount(product.getCreator());
        shoppingCart.setLockStartTime(startLockTime);
        shoppingCart.setLockEndTime(lockEndTime);
        shoppingCart.setQty(1);//默认都是1
        shoppingCart.setTitle(product.getTitle());
        shoppingCart.setCreator(userAccount);
        shoppingCart.setCreateTime(new Date());
        shoppingCart.setLastUpdateVersion(1);
        shoppingCart.setLastUpdateTime(new Date());
        shoppingCart.setLastUpdator(userAccount);
        orgShoppingCartMapper.insert(shoppingCart);
    }

    @Override
    @Transactional
    public void deleteProducts(String params) {
        ParamsUtils.checkParams(params);
        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }
        String productsIds = (String) FastJsonUtils.getValueByKey(params, "productsIds");
        if (StringUtils.isBlank(productsIds)) {
            throw new ServiceException("productsIds is null!");
        }

        OrgProductsExample orgProductsExample = new OrgProductsExample();

        String[] productIds = productsIds.split(",");
        List<String> productIdList = new ArrayList<>();
        for (String id : productIds) {
            orgProductsExample.clear();
            OrgProducts products =  orgProductsMapper.selectByPrimaryKey(id);
            OrgProducts newProduct = new OrgProducts();
            newProduct.setId(products.getId());
            newProduct.setLastUpdateVersion(products.getLastUpdateVersion()+1);
            newProduct.setLockStartTime(null);
            newProduct.setLockEndTime(null);
            newProduct.setStatus(ProductStatusEnum.PUBLISHED.getStatus());
            newProduct.setLastUpdateTime(new Date());
            newProduct.setRemark("move out cart by "+userId);
            orgProductsExample.clear();
            orgProductsExample.createCriteria().andIdEqualTo(id).andLastUpdateVersionEqualTo(products.getLastUpdateVersion());
            orgProductsMapper.updateByExampleSelective(newProduct,orgProductsExample);
            productIdList.add(id);
        }
        OrgShoppingCartExample cartExample = new OrgShoppingCartExample();
        cartExample.createCriteria().andProductsIdIn(productIdList).andUserIdEqualTo(userId);
        orgShoppingCartMapper.deleteByExample(cartExample);
    }
}
