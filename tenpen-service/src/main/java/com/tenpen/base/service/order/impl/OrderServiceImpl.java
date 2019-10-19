package com.tenpen.base.service.order.impl;

import com.tenpen.base.dao.OrgOrdersDetailsMapper;
import com.tenpen.base.dao.OrgOrdersMapper;
import com.tenpen.base.domain.model.OrgOrdersDetails;
import com.tenpen.base.domain.model.OrgOrdersDetailsExample;
import com.tenpen.base.domain.model.OrgOrdersExample;
import com.tenpen.base.enums.OrderDetailStatusEnum;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.order.OrderService;
import com.tenpen.base.util.FastJsonUtils;
import com.tenpen.base.util.ParamsUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by x00376013 on 2019/9/30.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrgOrdersMapper orgOrdersMapper;
    @Autowired
    OrgOrdersDetailsMapper orgOrdersDetailsMapper;

    @Override
    public List getOrders(String userId, String type, int offset, int limit) {
        return null;
    }

    @Override
    @Transactional
    public void deleteOrder(String params) {

        ParamsUtils.checkParams(params);

        String orderId = (String) FastJsonUtils.getValueByKey(params, "orderId");
        if (StringUtils.isBlank(orderId)) {
            throw new ServiceException("orderId is null!");
        }

        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }

        OrgOrdersDetailsExample detailsExample = new OrgOrdersDetailsExample();

        OrgOrdersExample orgOrdersExample = new OrgOrdersExample();

        String orderDetailId = (String) FastJsonUtils.getValueByKey(params, "orderDetailId");
        if (StringUtils.isNotBlank(orderDetailId)) {
            // 删除明细
            detailsExample.clear();
            detailsExample.createCriteria().andIdEqualTo(orderDetailId).andOrderIdEqualTo(orderId).andCustomerIdEqualTo(userId);
            orgOrdersDetailsMapper.deleteByExample(detailsExample);
            //再查询一次当前订单是否还没有明细，如果没有明细了则删除订单头数据
            detailsExample.clear();
            detailsExample.createCriteria().andOrderIdEqualTo(orderId).andCustomerIdEqualTo(userId);
            List<OrgOrdersDetails> detailsList = orgOrdersDetailsMapper.selectByExample(detailsExample);
            if (CollectionUtils.isEmpty(detailsList)) {
                //删除订单头数据
                orgOrdersExample.clear();
                orgOrdersExample.createCriteria().andIdEqualTo(orderId).andCustomerIdEqualTo(userId);
                orgOrdersMapper.deleteByExample(orgOrdersExample);
            }
        } else {
            //删除订单时，先删除订单明细
            detailsExample.clear();
            detailsExample.createCriteria().andOrderIdEqualTo(orderId).andCustomerIdEqualTo(userId);
            orgOrdersDetailsMapper.deleteByExample(detailsExample);
            //删除订单
            orgOrdersExample.clear();
            orgOrdersExample.createCriteria().andIdEqualTo(orderId).andCustomerIdEqualTo(userId);
            orgOrdersMapper.deleteByExample(orgOrdersExample);
        }
    }

    @Override
    @Transactional
    public void confirmOrder(String params) {

        ParamsUtils.checkParams(params);

        String orderId = (String) FastJsonUtils.getValueByKey(params, "orderId");
        if (StringUtils.isBlank(orderId)) {
            throw new ServiceException("orderId is null!");
        }

        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");
        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }

        String orderDetailId = (String) FastJsonUtils.getValueByKey(params, "orderDetailId");
        if (StringUtils.isBlank(orderDetailId)) {
            throw new ServiceException("order detailId is null!");
        }
        // 需要将订单行数据更新状态
        OrgOrdersDetailsExample orgOrdersDetailsExample = new OrgOrdersDetailsExample();
        OrgOrdersExample orgOrdersExample = new OrgOrdersExample();
        OrgOrdersDetails ordersDetail = orgOrdersDetailsMapper.selectByPrimaryKey(orderDetailId);
        if (ordersDetail == null) {
            throw new ServiceException("order detail is not exist!");
        }
        OrgOrdersDetails newDetail = new OrgOrdersDetails();
        newDetail.setId(ordersDetail.getId());
        newDetail.setStatus(OrderDetailStatusEnum.RECEIVED.getStatus());
        newDetail.setLastUpdateTime(new Date());
        newDetail.setLastUpdateVersion(ordersDetail.getLastUpdateVersion() + 1);
        orgOrdersDetailsExample.clear();
        orgOrdersDetailsExample.createCriteria().andIdEqualTo(ordersDetail.getId()).andLastUpdateVersionEqualTo(ordersDetail.getLastUpdateVersion());
        orgOrdersDetailsMapper.updateByExampleSelective(newDetail,orgOrdersDetailsExample);

    }
}
