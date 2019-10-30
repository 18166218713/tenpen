package com.tenpen.base.service.product.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MyProductListResponseDTO implements Serializable{

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 图片
     */
    private String imageUrl;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 状态 1 草稿 2 待审核 3 审核通过 4 已发布 -1 锁定 5已支付 6已发货 7已完成 0下架
     */
    private Integer status;
}
