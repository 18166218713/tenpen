package com.tenpen.base.service.product.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductListResponseDTO implements Serializable{

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
}
